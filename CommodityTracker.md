POSITx -- Commodity Tracking app


Overview

The Commodity Tracker app is a tools for recording pricing information on food items in rural areas, and has been configured for Haiti. This information is then sent to FAO. It utilizes POSITx. POSITx stands for Portable Open Source Information Tool - eXperimental. It is a customizable Android platform for mobile apps.




POSITx was built by the HFOSS, The Humanitarian Free and Open Source Software Project. It is free software. The source code is available and licensed under the GNU LGPL. POSITx runs on Android phones. It's been tested on several varieties but not on all Androids.

The Commodity Tracker App extends POSIT.


![http://notes.hfoss.org/images/0/0b/CommodityQR.png](http://notes.hfoss.org/images/0/0b/CommodityQR.png)

Downloading and Installation

Here is the apk: http://notes.hfoss.org/images/b/bb/Commodity081.apk

If you have the Barcode Scanner on your Android phone you can simply scan the QR code on this page. The scanner will download the app. Once it is downloaded you can install it like any other market app. If you don't have Barcode Scanner, you can download it from the market. It is free.

Some phones come with an App Installer app. In that case copy the positx.apk file onto your phone using the phone's USB Connected menu. Then install it using the installer app. If your phone doesn't have an installer, you can download and install an Apps Installer from the Android market (free) and follow these instructions.

It will also be necessary to download and unzip the commodity folder located [here](http://notes.hfoss.org/images/7/78/Commodity.zip), and place the folder with its contents onto your phone. For developers cloning the repository, this will be a folder marked "commodity" in the packge. Copy this folder onto your phone. The program relies on these file names to be correct to function properly. The folder contains the lists of markets and commodities. By altering the files in the folder, an administrator can change the list of commodities or the market list.

Adding and Saving Finds

When the app is first used, You can hit "New Item".

Below is the data entry form for adding and saving finds. It has code for sending a text message at the time data submission is completed, it has been localized, and it currently stores data on a database on the phone. The "Next Find" button will save the data for the previous item and proceed to the next item, provided none of the prices are zero.


![http://i1242.photobucket.com/albums/gg535/cnobile/com4.png](http://i1242.photobucket.com/albums/gg535/cnobile/com4.png)

To send data, you must navigate to the saved data section from the main menu. Here you can access previously saved information as well as send finds. From here you should press the menu button and select the Send Finds option. You can just check the finds you wish to send or select them all, and send them.

![http://i1242.photobucket.com/albums/gg535/cnobile/com5.png](http://i1242.photobucket.com/albums/gg535/cnobile/com5.png)

To change the recipient of the SMS messages or the language, navigate to settings. Language change options are under the locale section. The Commodity Tracker specific settings are at the bottom. The default number for the SMS manager must be changed, it was deliberately selected to not be a line that is currently in use.

![http://i1242.photobucket.com/albums/gg535/cnobile/com7.png](http://i1242.photobucket.com/albums/gg535/cnobile/com7.png)

![http://i1242.photobucket.com/albums/gg535/cnobile/com8.png](http://i1242.photobucket.com/albums/gg535/cnobile/com8.png)


Things to watch out for:

When trying to merge the project with the main branch, you will find that a number of changes to POSIT resource files were done. strings-commoditysms has a lot of the same string definitions as the bluetooth string folder. A number of the resource files, particularly the menus for list finds, the main menu, and the settings, have had fields commented out that the Haitian users do not need. If there's a missing menu item, it's probably commented out. Furthermore, any plugins not being used were set to false, and the option to activate the other plugins was disabled.

I added a null check concerning sync accounts, this was to stop a Null Pointer Exception that tended to occur shortly after the project is first installed. It also appears to take a moment for the project to realize an account is already active, which means users will occationally get an error if they try to submit a find on startup. The work-around is to wait until the project is fully loaded.

A number of strings have been hard coded into Haitian. The language for the account login on the app was hard coded because the user cannot change the local until they enter the app. "Voye Done", the Send Finds button in List Finds used for the SMS manager, was also hard coded due to localization issues. Conversly, I also internationalized a number of strings that were hard coded into the Java files, which should not change anything.

The folder titled "commodity" must be on the phone and must contain "commoditylist.csv" and "marketlist.csv" for the app's spinners to work properly.

It might be a good idea to include some code to confirm that text messages sent by the phone are received. Currently, it will send SMS messages, but it does not do any checks beyond that.

Much of the code for CommoditySMS was adjusted BlueToothSync code. A lot of the layouts for this code was original defined in Java in SelectFindView, instead of in the XML files.

It is difficult to seperate Syncing, and by extension account initialization, from POSIT. Unlike the plugins, it's fairly entrenched in the code. However, syncing and account initialization are not essential features for this plugin.

Bluetooth is not in any way important to the functionality of this particular application.