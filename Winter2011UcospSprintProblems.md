# Problems Encountered #

## Setting up eclipse and phone and getting POSIT source ##

  * Setting up phone, basic info: http://developer.android.com/guide/developing/device.html
  * Phone problem on Ubuntu: "List of devices attached ???????????? no permissions". Fix1: "kill-server adb; sudo start-server adb". Fix2: create the file /etc/udev/rules.d/##-android.rules, where ## should match other files in dir (50, 51 or 70) with same privileges as others in dir and paste the following line:SUBSYSTEM=="usb", SYSFS{idVendor}=="VENDOR", MODE="0666". Where VENDOR is a 4 digist string from: http://developer.android.com/guide/developing/device.html#VendorIds
  * Phone problem on Ubuntu "List of devices attached                 ". Fix: http://forum.xda-developers.com/showthread.php?t=640158
  * Setting up google maps API key, instructions here: http://code.google.com/android/maps-api-signup.html
    * For windows users go to your jdk\bin for the keytool executable.  Sample command: C:\Program Files (x86)\Java\jdk1.6.0\_23\bin>keytool -list -keystore C:\Users\USERNAME\.android\debug.keystore
    * The password is blank

## Building and installing POSIT ##

  * Problem: "Android requires .class compatibility set to 5.0" Fix:  http://excid3.com/blog/2010/06/android-requires-class-compatibility-set-to-5-0/
  * Problem: Cannot build: no "gen" folder. Fix 1: Install Google API 7. If that doesn't work, alternate fix: Right-click on posit-trunk and select properties. Go to build-path and doubleclick on posit-trunk/gen. Click finish.
  * Problem: Cannot find target Google API 7. Fix: install Google API 7 (Under Third Party Addons) in SDK manager.
  * Problem: Conversion to Dalvik format failed with error 1.  Fix: downloaded a new clone from the repository. Fix2: Reinstall API7, all other SDK elements from the android install manager.
  * Problem: Cannot resolve R. Fix: Reinstall API7, all other SDK elements from the android install manager.
  * Problem: Run project doesn't allow you to choose the device to run on. Fix: Right click posit-trunk>Run as...>Run configuration>Target. Unselect preferred device. Apply.
  * Problem: Logcat shows read error: run as sudo adb logcat -c, and restart eclipse

### Enhancements ###
  * UI: Maybe there could be a "log out" sort of option to lock access to your project, photos, and history?
  * UI: In new user input, pressing "enter" in password field makes the field blank and doesn't erase it. Expected behaviour: move to next field.
  * UI: In share project section of website. Need a better way to add new users. There's no dropdown menu.
  * UI: Make it clearer that barcode scanning is an alternative to typing in your login and password, not a second step. (Perhaps by changing "register device" to "login with barcode" or something?)
  * UI: When it says "you need barcode scanner app," we could perhaps add a button to get it for free from the store without having to search for it.
  * Enhancement: Under conditions with a possible lack of GPS connectivity, google maps is able to roughly pinpoint my location. POSIT is not. We may be able to access this information through the google api.