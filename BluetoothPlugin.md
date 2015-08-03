# Introduction #

The Bluetooth function plugin allows you to sync Finds across two devices via a Bluetooth connection.

# Enabling the Bluetooth Plugin #

If it isn't already, set active to "true" in the following code in res/raw/plugin\_preferences.xml

```
<Plugin active="true"
type="function"
extensionPoint="listMenu"
name="bluetooth"
menuIcon="ic_menu_bluetooth"
menuTitle="Bluetooth Sync"
menuActivity="org.hfoss.posit.android.functionplugin.bluetooth.BluetoothSyncActivity" />
```

Compile and run POSIT.

# Connect to a device and set your device as discoverable #

This is fairly straight forward. Click on "View Finds" and then from the menu options select "Bluetooth Sync". This opens a new Activity that will show all the Finds for the specific project. Click on the menu again and you will see both options there: "Make device discoverable" and "Connect to device".

**Note:** Before being able to sync finds across devices via Bluetooth, ensure both phones are subscribed to the same project. Otherwise it will not be possible to share data.


# Sending a Find #

Once the connection is established, select the Finds you would like to sync and click the "Send Selected" button. Then wait for the transmission to complete.

That's it. Finds should be transferred from one device to the other.

# Receiving a Find #

You should get a Toast message every time a Find is received indicating that the Find was transmitted successfully or not. Once the last Find is received, you should get a final message indicating that no more data will be arriving.

After this message, users can go back to the ViewFinds Activity where they should see the new Finds received from the other device.

**Note:** Pressing the back button, the home button or simply exiting the Activity will close the Bluetooth connection. Please refrain from doing so until the transmission is over.