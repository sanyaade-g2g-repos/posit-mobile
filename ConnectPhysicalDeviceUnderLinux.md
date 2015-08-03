# How to connect a physical device under Linux #

If you want to run POSIT on a physical device via a USB attachment to your computer and it does not "just work" under Linux, here are the steps to make it work.


# Details #

The original source of this material is the [Ubuntu Forums](http://www.google.com/support/forum/p/android/thread?tid=08945730bbd7b22b&hl=en).

Here is a copy of the best answer (by jerichod 10/11/10):
```
hi folks. 

i found this info to be helpful, although there was not much explanation behind it, and in the end things still did not work for me.  after a number of hours of debugging (which was kind of fun!) i finally got things working, and wanted to document it here in case others have the same issues.  also documented is *how to debug* your stuff, which may be as valuable as the fix!

disclaimer:
i still dont really understand udev very well, so if someone who does can clarify my observations, that would be cool.

my environment:
ubuntu 10.04, device is a motorola cliq.
adb version 1.0.26
eclipse version 3.5.2 (galileo)

the problem:
persistent issues with adb devices returning:
   List of devices attached
   ????????????     no permissions

rat holes i went down:
a) first, be sure that when you write your android-specific rules in /etc/udev/rules.d that you ensure that you  name the file with a name that ends in .rules, or else the udev daemon wont read it.
b) Ubuntu 10.04 uses a new version of udev, so some of the documentation you find on the web is out of date.
c) The phone looks like a disk drive to the OS, which caused me some wierdness.  more later.

some basics:
a) the udev infrastructure is what the OS uses to dynamically map, present, and control USB devices.  you will need to tell udev what to do with your android phone when the phone is in application debug mode (that is why you need the /etc/udev/rules.d/50-android.rules file.
b) the adb (android debug bridge) is the daemon (using network sockets) that allows the IDE to talk to the device.  when you run commands like 'adb devices' the command looks for a running daemon, and if one is not running it starts one and then communicates with it.
c) the "no permissions" error message indicates that the adb daemon cannot get the right permissions to access the device as the user that it is running as.  normally the IDE starts the daemon as the user you are logged in as.  unless the phone device appears in the udev infrastructure with the correct permissions to be accessed as the user you are logged in as, it wont work.

steps:
1) plug your phone into the usb bus on your system.  does not need to be in application debug mode yet...

2) verify that you can see the phone by using 'lsusb', e.g.:
  $ lsusb
  Bus 003 Device 001: ID 1d6b:0001 Linux Foundation 1.1 root hub
  Bus 002 Device 044: ID 22b8:2d66 Motorola PCS
  Bus 002 Device 004: ID 0451:2046 Texas Instruments, Inc. TUSB2046 Hub
  Bus 002 Device 003: ID 10d5:0001 Uni Class Technology Co., Ltd
  ...
 the line "ID 22b8:2d66 Motorola PCS" is my phone.  the rest is other stuff on the usb busses.  ignore it.

3) the 4 digit value 22b8 is the Vendor ID of my phone.  yours may be different.  whatever it is, this is the value you need to use in your udev rule.

4) the Bus number and Device number are useful.  you can see what permissions your device is getting at any time by doing
  $ ls -l /dev/bus/usb/<busnumber>  where <busnumber> is the Bus number above (002 in this case).
 the permissions of the device will be the permissions of the file numbered with the Device number above.  in my case it was device 044, so the full file path is /dev/bus/usb/002/044
! note - this device number will change when you plug/unplug or enable/disable debug on your device.

5) you can now get *alot* of info on this device now by using 'udevadm info', but you need to use the bus and device info above (remember yours may be different and change).  you can use either udev info command --query=all or --attribute-walk, e.g.:
  $ udevadm info --query=all --name=/dev/bus/usb/002/044
  or
  $ udevadm info --attribute-walk --name=/dev/bus/usb/002/044
 note that the attribute-walk walks up the bus.  the first entry printed should be the lowest device on the chain, which is your phone.  in my case some of the lines looked like:
   looking at device '/devices/pci0000:00/0000:00:1d.0/usb2/2-2/2-2.4':
    KERNEL=="2-2.4"
    SUBSYSTEM=="usb"
    DRIVER=="usb"
    ATTR{configuration}=="Motorola Config 42"
    ...
    ATTR{idVendor}=="22b8"
    ...
    ATTR{busnum}=="2"
    ATTR{devnum}=="44"
    ATTR{version}==" 2.00"
    ATTR{maxchild}=="0"
    ATTR{quirks}=="0x0"
    ATTR{authorized}=="1"
    ATTR{manufacturer}=="Motorola "
    ATTR{product}=="MB200"
    ATTR{serial}=="<serialnumber>"
    ...
 where the <serialnumber> is the serial number of my phone, which will show up in the adb devices list when this all works.  recognize the items that you will need for the .rules file are there.
 
6) now, lets write the .rules file.  you have two choices.  either get the permissions of the phone as it shows up changed to 0666 (rw for all users, including the world) or change the ownership to be your user.  i prefer the latter.  seems cleaner to me, so i will use this approach for the rest of the info.

7) find out who you are.  use the id command, e.g.:
  $ id
  uid=1000(<your username>) gid=1000(<your group name>) groups=...
  where the uid and gid for you are indicated.  for now lets use both as 'juser' for the example.
 
8) now lets create the .rules file.  the number at the beginning of the file name is the order that it will be loaded by the udev infrastructure.  it may be important.  all the examples showed a number of 50, but there are a bunch of things being loaded in /lib/udev/rules.d/ as well.  i prefer to make my file name 99-android.rules to force it to load very late in the process.  this keeps other later things from clobbering my permissions as they load.

for example, if you use the ATTR{idVendor} attribute in .rules as oppose to SYSFS{idVendor}, then when other later rules load they could over write the permissions you set in your .rules file.

9) you have to use root or sudo to create the file in /etc/udev/rules.d.  create /etc/udev/rules.d/99-android.rules and put in a line like:
 SUBSYSTEM=="usb", SYSFS{idVendor}=="<Vendor ID>", OWNER="<your username>" GROUP="<your group name>"
and save it.
the SYSFS{idVendor} value needs to match your device id, and the OWNER and GROUP are from step 7 above.
for this example lets use
 SUBSYSTEM=="usb", SYSFS{idVendor}=="22b8", OWNER="juser" GROUP="juser"
if you just want to set the permissions use:
 SUBSYSTEM=="usb", ATTR{idVendor}=="22b8", MODE="0666"

10) now, when you connect the device (try the application debug mode) you should be able to see that the device appears with the correct user permissions.  e.g.(using this example's bus, device, and uid/gid values):
  $ ls -l /dev/bus/usb/002
  crw-rw-r-- 1 root   root   189, 128 2010-10-09 20:02 001
  ...
  crw-rw-r-- 1 root   root   189, 131 2010-10-09 20:02 004
  crw-rw-r-- 1 juser  juser  189, 173 2010-10-10 11:29 044
this is very good, 'cause now adb running as you will be able to read and write the device.

11) if you did not get here, then you have udev issues.  dont bother beating on adb, the problem is in udev.  your best bet is to go into /etc/udev and edit udev.conf, to change the line
  udev_log="err" to udev_log="debug" to see what is going on.  then you can follow what udev is doing by opening a terminal window and following /var/log/syslog with:
  # tail -f /var/log/syslog
you may need to restart udev, which you can do by doing:
  $ sudo /etc/init.d/udev restart
 from another terminal window.
this output is very verbose, but you should look to see that your .rules file is being loaded.  if not, then that is the issue to fix.

12) if all is ok, and the device has the right permissions, when you put it into application debug mode you should be able to simply start the adb server with:
  $ adb devices
 and see your device by serial number
  List of devices attached
  <serialnumber>   device

13) if you have problems with adb, here are a few things to check.
a) make sure you see that adb is running, and owned by you by looking for it with ps, e.g.:
  $ ps aux |grep adb
 you should see a line like:
  juser  <pid>  0.0  0.1  28160   728 pts/4    Sl   10:18   0:01 adb fork-server server
 where juser should be your user id, and <pid> is the process ID.
b) if adb is running as root, you may need to use 'sudo killall adb' to kill it off and then as your user run 'adb devices', which should start the server as you.
c) if you still have problems you can run strace on the server and it's child processes with:
  $ strace -f ./tools/adb server
 note that the output is very verbose, but look thru there for some kind of permissions problem.  lots of 'file not founds' are ok, but as the daemon starts and tries to bind to the device, you may find a permission problem.


hope this helps.  sorry to be long winded.

jerichod.
```