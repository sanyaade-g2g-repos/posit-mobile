# Introduction #

  * Hey, this is Eric Yao.
  * I am a 4th-year Computer Science specialist studying at University of Toronto.
  * And I am also a proud member of the POSIT team for the Fall 2011 semester.


---


# Project Proposal #

(Updated on 10/24/2011)

[Revised Proposal PDF File with updated Design Approach](https://docs.google.com/open?id=0Bz2Uy-g-nRQ0ZWU4YmFmZmYtOTNiMS00YzM1LTkzY2YtZTcyMDU4YWNmYjVh)

[Revised Proposal ODT File with updated Design Approach](https://docs.google.com/open?id=0Bz2Uy-g-nRQ0ZmVmZGFiNTEtMzdlMy00ZDNjLWFjYzQtNDE2NGM4MjVjZTY5)


---


# To-Do Reminder Design Document #

## [To-Do Reminder Design Document](https://docs.google.com/open?id=0Bz2Uy-g-nRQ0ZDNhZmFkODktYTk1NS00Yjg5LWExZWMtNjI4MWFhODAzYTFm) ##


---


# To-Do Reminder Walk-through #

## [To-Do Reminder Walk-through](http://code.google.com/p/posit-mobile/wiki/To_Do_Reminder_Walkthrough?ts=1321990913&updated=To_Do_Reminder_Walkthrough) ##


---


# Weekly Updates / To-Do Function Plug-in Progress #

### December 7 - 13 ###

  * **Fixed the occasional location notification problem**
  * **Did further field testings** on location notification around Toronto area and have concluded that the fix has worked great
  * Modify the code so that users will be notified of the reminder **again** when they **re-enter** the specified location
  * Completed the **design document** for To-Do Reminder
  * **Further documented** my code so that each step in the code is easily understood

  * **Goal:** Implement at least the following:
    * Re-test the reminder to see why notifications are not sent sometimes

### November 30 - December 6 ###

  * **Re-designed Function Plug-in's preference architecture** so that it is independent of the core POSIT preference and thus can be detached easily
  * **Re-designed Function Plug-in's service architecture** so that all services requited by all function plug-ins can be aggregated and be called all at once by Posit's entry point, onCreate()

  * **Goal:** Implement at least the following:
    * Re-design "Allow Reminder". Add this to "Setting" without changing XML, but only changing it through JAVA code. That is, if users detach "Reminder plug-in", "Allow Reminder" should not appear in "Setting"

### November 23 - 29 ###

  * Received feedback and **added an alarm clock icon** in "Add Find" and "List Finds" **as a visual indicator** that the finds has reminders attached
  * **Added blue alarm icons to "Add Find" and "List Finds" layout solely through JAVA code without changing the XML layout.** This is to provide user a visual indicator that finds have reminders attached, also as a test to see the capability of our POSIT plug-in infrastructure
  * **Finish the visual guide** on my ["Location Aware To-Do Reminder" function plugin](http://code.google.com/p/posit-mobile/wiki/To_Do_Reminder_Walkthrough?ts=1321990913&updated=To_Do_Reminder_Walkthrough,)
  * Implemented patches for [Issue 232](http://code.google.com/p/posit-mobile/issues/detail?id=232&colspec=ID%20Date%20Repository%20Type%20Status%20Priority%20Difficulty%20Owner%20Summary) and [Issue 253](http://code.google.com/p/posit-mobile/issues/detail?id=253&colspec=ID%20Date%20Repository%20Type%20Status%20Priority%20Difficulty%20Owner%20Summary)

  * **Goal:** Implement at least the following:
    * Receive feedback from Professor Morelli and improve the my project accordingly

### November 16 - 22 ###

  * **Refined algorithms to filter and select the most up-to-date and accurate GPS location fixes**
  * **Did field testing** to verity the GPS location selection algorithms
  * Largely **refined and improved the user experience of the date/address dialogs**
  * **Created a background thread to run the HTTP location retrieval** instead of running in the UI foreground to **avoid the "UI unresponsive" error**
  * **Added Progress Dialog** during HTTP location retrieval for a more natural user experience
  * Finished field testing and the results returned are fairly reasonable
  * **Added "Allow Reminder" in the setting menu**, dependent of "Geotagging" option

  * **Goal:** Implement at least the following:
    * Improve the UI / user experience of date/address selection dialogs **(implemented)**
    * Figure out ways to retrieve the most reliable current GPS location data **(tested)**
    * Perhaps implement some kind of map view to reassure the user that the correct location is indeed selected

### November 9 - 15 ###

  * **Migrated** the existing To-Do plug-in **using the new Function Plug-in API**
  * Researched and studied on **Android Service** and **implemented and integrated within the existing POSIT a simple music player** that runs in the background and **continues to run even after POSIT is closed based on if Finds have reminders set**
  * **Fully implemented background notification service** that notify users when they are close to the desired location
  * **Fully implemented a location search engine** that lets users type in location name / address and translates that into GPS coordinates using Google Location API
  * Finished some field testing on the program and noticed that the GPS location data on the physical phone can be unreliable, needs way to improve this.

  * **Goal:** Implement at least the following:
    * Improve the "Select Address" pop-up dialog functionally and aesthetically **(Implemented)**
    * User can type the address in the dialog **(Implemented)**
    * User can choose/pinpoint a location on Google Map the chosen GPS will be recorded in the To-Do Find
  * **Nice to have:** Implement the following if timer permits
    * User can also search for locations using phrases like "Search for Starbucks near my current location" (Google does not allow usage of business locations)
    * Research on how to send users reminders/notifications when they are near desired locations and run this in the background (without POSIT running) **(Implemented)**

### November 2 - 8 ###

  * **Decided  and implemented a great way to let user select To-Do Find's DATE and ADDRESS (GPS Location)**
    * The To-Do function plug-in is implemented as a menu option, named **"Set Reminder"** **(implemented)**
    * Once the option is pressed, the pop-up "Date Picker Dialog" will appear and prompt the user to pick a preferred To-Do DATE **(implemented)**
    * After the date is selected, the pop-up "Select Address" will be displayed and ask the user to choose a desired To-Do ADDRESS **(implemented)**, and there are **FOUR** ways this can be done
      1. Choose the location of the existing To-Do find **(implemented)**
      1. Use the current location **(implemented)**
      1. Pinpoint the desired location on Google Map (to be done)
      1. Type the wanted address (to be done)
    * I choose the above approach because these pop-up dialogs are both **intuitive in guiding users** and can be implemented independent from the core Find activity and thus have **minimum impact on the core code base**

  * Managed to borrow an Android phone (Nexus One) from the Computer Science faculty at U of T and **successfully deployed the POSIT with my functional plug-in**. I can now finally test my plug-in with real GPS location data!

  * Improved the "Date Picking" function in the plug-in. Users can now tap on the "Please choose a date" text and this will prompt a **"Date Picker" Dialog**. Users can then easily **select the date without ever leaving the "Add Find" interface** (This is no longer used after the above new approach is implemented)

  * Cleaned and tweaked "FindActivity" so that users will **see different "Add Find" interface based on if "To-Do" function plug-in is enabled** (This is no longer used after the above new approach is implemented)

  * Merged my updates with the newly patched POSITx

### October 26 - November 1 ###

  * Created a simple **functional plug-in** that, when enabled, lets users modify the location and the date of a "Find"
  * Fixed and submitted a patch for [Issue 242](http://code.google.com/p/posit-mobile/issues/detail?id=242&colspec=ID%20Date%20Repository%20Type%20Status%20Priority%20Difficulty%20Owner%20Summary&start=100), which overhaules the Basic Finds' interface.
  * The above patch also fixed [Issue 225](http://code.google.com/p/posit-mobile/issues/detail?id=225&colspec=ID%20Date%20Repository%20Type%20Status%20Priority%20Difficulty%20Owner%20Summary) and [Issue 243](http://code.google.com/p/posit-mobile/issues/detail?id=243&colspec=ID%20Date%20Repository%20Type%20Status%20Priority%20Difficulty%20Owner%20Summary&start=100)
  * Studied FindOverlay and MapFindsActivity under **org.hfoss.posit.android.experimental.api.activity**
  * Understood how POSIT map finds on the Map View and took notes that the search buttons need to be re-implemented back in

### October 19 - 25 ###
  * Successfully **implemented** "Delete All Finds" for Basic Finds
  * Studied all classes under **org.hfoss.posit.android.experimental.api**
  * Understood the structure of four major database tables (classes)
  * Studied PositMain, AboutActivity, FindActivity, ListFindsActivity classes under **org.hfoss.posit.android.experimental.api.activity**
  * Understood the activity flow and data transactions of POSIT
  * Studying how "Authentication" and "Sync" classes work

### October 12 - 18 ###
  * Further adjusted project proposal using feedback from Skype meeting and the email
  * Studied all classes under **org.hfoss.posit.android.experimental.plugin**
  * Understood how "Plug-in" functions by parsing XML and assigning desired classes
  * Studied all classes under **org.hfoss.posit.android.experimental.api.database**
  * Understood POSIT database structure, that is, how POSIT uses imported [OrmLiteSqliteOpenHelper](http://ormlite.com/javadoc/ormlite-android/com/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper.html) to facilitate database operations

### October 5 - 11 ###
  * Brainstorm for project proposal
  * Drafted project proposal, proposing "Geo-Aware Reminder" functionality

### September 28 - October 4 ###
  * Discovered and submitted a few app issues
  * Updated Wiki
  * Worked on more Android tutorials

### September 21 - 27 ###
  * Participated UCOSP code sprint
  * Familiarized with the Eclipse Android development environment
  * Looked over the Android Notepad tutorial
  * Understood the overall structure of the POSIT app


---


## Questions ##

  * How does "sync" work in the database? "recordSync" function in "DbManager.java" is never used.


---


## Others ##

Update http://code.google.com/p/posit-mobile/wiki/FunctionalComponents
collectively.

Look at http://code.google.com/p/posit-mobile/wiki/DevelopmentProjectsAndIdeas

SMS Message Compression

IRC Channel: [irc://irc.freenode.net](irc://irc.freenode.net) #posit
Use webchat.freenode.net