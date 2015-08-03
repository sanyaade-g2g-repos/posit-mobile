# Introduction #

The SMS plugin allows the user to send and receive Finds with other users via SMS messaging. This has the advantage of giving users a way to share Finds without access to an Internet connection and without having to attach to the same project and server.

# Enabling the SMS Plugin #

If it isn't already, set active to "true" in the following code in res/raw/plugins\_preferences.xml

```
	<!-- SMS Plugin Begins -->
	<Plugin active="true"
		type="function"
		extensionPoint="addFindMenu"
		name="sendsms"
		menuIcon="ic_menu_send" menuTitle="Send SMS"
		preferences_xml="sms_preferences"
                menuActivity="org.hfoss.posit.android.experimental.functionplugins.sms.SmsActivity" />
	<!-- SMS Plugin Ends -->
```

Then compile and run POSIT.

# Sending a Find via SMS #

  1. From the Add Find screen, choose Send SMS from the menu.
![http://i76.photobucket.com/albums/j1/His_Ryanness/smssend1.png](http://i76.photobucket.com/albums/j1/His_Ryanness/smssend1.png)
> 2. You will see the screen below. Note the Phone # field, which specifies where to send the SMS message. You can set a default value for this field in POSIT Settings or enter a phone number here for each find you send. This screen also shows you the contents of the raw SMS message you'll be sending, and tells you how many messages it has to be split up into. (In the example below, 2.)
![http://i76.photobucket.com/albums/j1/His_Ryanness/smssend2.png](http://i76.photobucket.com/albums/j1/His_Ryanness/smssend2.png)
> 3 Press the Send button. POSIT will then transmit the SMS messages.

# Receiving a Find via SMS #

  1. POSIT will automatically monitor for incoming SMS messages that contain finds when using the SMS plugin. When an SMS message is recognised as a find, a notification will appear in the status bar.
![http://i76.photobucket.com/albums/j1/His_Ryanness/smsreceive1.png](http://i76.photobucket.com/albums/j1/His_Ryanness/smsreceive1.png)
> 2. Select the notification to display a parsed view of the find's contents.
![http://i76.photobucket.com/albums/j1/His_Ryanness/smsreceive2.png](http://i76.photobucket.com/albums/j1/His_Ryanness/smsreceive2.png)
> 3. If you don't wish to save the find, press the Dismiss Find button. Otherwise, you can press the Add Find to Current Project button to open the Add Find screen. Once you press either button, the notification will be removed from the status bar.

> 4. Finally, press the Save button to save the find to your project.
![http://i76.photobucket.com/albums/j1/His_Ryanness/smsreceive3.png](http://i76.photobucket.com/albums/j1/His_Ryanness/smsreceive3.png)