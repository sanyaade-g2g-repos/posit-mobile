# Introduction #

> #### "Tracker Activity" is a function plug-in for POSIT that tracks the phone's location by collecting its altitude, latitude and longitude, displays the current expedition on a Google map in Tracker’s UI, saves the points on the phone’s database and synchronizes the points with the POSIT’s server. ####

> #### This function plug-in is independent of the basic POSIT and can be attached and detached by modifying "plugins\_preferences.xml". ####

> #### The following walk-through will guide you through how to enable and use the "Tracker Activity Plug-in". ####


---


# Tracker Activity Walk-through #

> ## How To Enable the Tracker Activity Plug-in ##

> #### To enable the "To-Do Reminder" function plug-in, you would need to go through the following steps. ####

> ### 1. Attach To-Do Plug-in ###

> Change "active=**false**" of the following code in "plugins\_preferences.xml" to "active=**true**".

```
<Plugin active="true" 
	 type="function" 
	 extensionPoint="mainMenu"
	 name="tracker" 
	 menuIcon="radar" 
	 menuTitle="Tracker Activity"	 	 	 	 	        
	 menuActivity="org.hfoss.posit.android.experimental.functionplugins.tracker.TrackerActivity" />	
```

> ### 2. Set up a project ###

> Go to http://turing.cs.trincoll.edu/~ram/positweb/web/main and register.
> Now, create a new Project by going to Projects and clicking New project, specifying the Project name and Description.

> ### 3. Allow syncing on your phone ###

> Go to the Settings menu on your phone. Click Accounts & sync.  Click Add account.  Click POSITx and use the email address and password you used when setting up a project.

> ![https://lh4.googleusercontent.com/-C81met4I-F8/TuAApQCuu0I/AAAAAAAAAHk/hqeCE--LieM/s400/Accounts%252520and%252520sync.jpg](https://lh4.googleusercontent.com/-C81met4I-F8/TuAApQCuu0I/AAAAAAAAAHk/hqeCE--LieM/s400/Accounts%252520and%252520sync.jpg)  ![https://lh5.googleusercontent.com/-qWT9nUZzkLQ/TuAApaYLzOI/AAAAAAAAAHo/N4_L6vdOL6g/s400/Add%252520account.jpg](https://lh5.googleusercontent.com/-qWT9nUZzkLQ/TuAApaYLzOI/AAAAAAAAAHo/N4_L6vdOL6g/s400/Add%252520account.jpg)  ![https://lh6.googleusercontent.com/-bCtjwYDU1Dg/TuAAqo4riaI/AAAAAAAAAIA/YP-FrMDwrW8/s400/username%252520and%252520password.jpg](https://lh6.googleusercontent.com/-bCtjwYDU1Dg/TuAAqo4riaI/AAAAAAAAAIA/YP-FrMDwrW8/s400/username%252520and%252520password.jpg)

> Ensure you turn Sync on. If your account is not set to sync, "Sync is OFF will be displayed below your POSIT project account. You can turn syncing on by selecting your POSIT project account. This will bring you to the "Data and Synchronization". Ensure the check mark is clicked.

> ![https://lh6.googleusercontent.com/-rNWMrabbLdg/TuALCCbV0KI/AAAAAAAAAJQ/3odL5dOgc98/s400/sync%252520on%2525201.jpg](https://lh6.googleusercontent.com/-rNWMrabbLdg/TuALCCbV0KI/AAAAAAAAAJQ/3odL5dOgc98/s400/sync%252520on%2525201.jpg) ![https://lh6.googleusercontent.com/-0aPJyrIchX4/TuAAqX4ABNI/AAAAAAAAAIE/fpYRM61yOBI/s400/Turn%252520on%252520sync.jpg](https://lh6.googleusercontent.com/-0aPJyrIchX4/TuAAqX4ABNI/AAAAAAAAAIE/fpYRM61yOBI/s400/Turn%252520on%252520sync.jpg)

> ### 4. Select a Project ###

> Open up POSIT. Go to Settings, then Click "Change current project. Select your desired project.

> ![https://lh3.googleusercontent.com/-H16kwb1cR08/TuAApqtwhMI/AAAAAAAAAH0/2mLDXSS_zNY/s400/Select%252520a%252520project.jpg](https://lh3.googleusercontent.com/-H16kwb1cR08/TuAApqtwhMI/AAAAAAAAAH0/2mLDXSS_zNY/s400/Select%252520a%252520project.jpg)

> You have now enabled "Tracker Activity" plug-in in POSIT.


---


> ## Opening Tracker Activity Plug-in ##

> In the Main Menu, select Tracker Activity.

> ![https://lh4.googleusercontent.com/-W-TYQ3IA3FA/TuAAqAGTlcI/AAAAAAAAAH4/6mqg971yXRY/s400/select%252520tracker%252520activity.jpg](https://lh4.googleusercontent.com/-W-TYQ3IA3FA/TuAAqAGTlcI/AAAAAAAAAH4/6mqg971yXRY/s400/select%252520tracker%252520activity.jpg)

> The Tracker View opens.
> > ![https://lh6.googleusercontent.com/-cJyLW38uPaw/Tt_s-TJRyNI/AAAAAAAAAF4/9ns4VYIxPME/s400/Expidition%252520Tracking.jpg](https://lh6.googleusercontent.com/-cJyLW38uPaw/Tt_s-TJRyNI/AAAAAAAAAF4/9ns4VYIxPME/s400/Expidition%252520Tracking.jpg)


---



> ## How to Start/Stop Tracker Activity ##

> Click the Start button. "Tracker Activity" will begin to collect points based  when the phone's location changes by at least the  Minimum Recording Distance found in settings. At this point the Start/Stop button's label will change to Stop. You are free to leave Tracker Activity and to continue recording points. You are also free to open up other applications on the phone and continue recording points.

> In the Tracker View, you can stop Tracker Activity by clicking the Stop button. Now Tracker Activity will stop and the Start/Stop button's label will change to Start.
> > ![https://lh4.googleusercontent.com/-jdv-GXXRI4Q/TuAEqbTinvI/AAAAAAAAAIY/kcl8BbWNPRQ/s400/StartStop.jpg](https://lh4.googleusercontent.com/-jdv-GXXRI4Q/TuAEqbTinvI/AAAAAAAAAIY/kcl8BbWNPRQ/s400/StartStop.jpg)


---



> ## How to Change Settings in Tracker Activity in Real Time ##

> Click the Settings button. You are shown the 2 settings you may change: Swath and Minimum Distance.
> > ![https://lh4.googleusercontent.com/-m_Fwdt2cISE/Tt_sP06pUOI/AAAAAAAAAFk/fJxLU9ijwFc/s400/Settings.jpg](https://lh4.googleusercontent.com/-m_Fwdt2cISE/Tt_sP06pUOI/AAAAAAAAAFk/fJxLU9ijwFc/s400/Settings.jpg)

> Clicking on either of these brings up an Android Preference View to select your preferred settings.

> Clicking Swath allows you to change the width of the path you can see.
> > ![https://lh5.googleusercontent.com/-0vDY_-F6yiE/Tt_r1iiDmsI/AAAAAAAAAFQ/g14ogkvnXZo/s400/Swath.jpg](https://lh5.googleusercontent.com/-0vDY_-F6yiE/Tt_r1iiDmsI/AAAAAAAAAFQ/g14ogkvnXZo/s400/Swath.jpg)

> Clicking Minimum Distance allows you to change the minimum location change needed to record a point.
> > ![https://lh4.googleusercontent.com/-Dj11Jhn3Vag/Tt_pj2QtLfI/AAAAAAAAAFA/oAr3-JKarv0/s400/Minimum%252520Distance.jpg](https://lh4.googleusercontent.com/-Dj11Jhn3Vag/Tt_pj2QtLfI/AAAAAAAAAFA/oAr3-JKarv0/s400/Minimum%252520Distance.jpg)


---



> ## How to Save/List Expeditions ##
> To see the list of Expeditions, with in Tracker View, with Tracker Activity Stopped press "List".
> Once you have collected points you can save the Expedition. To save the current Expedition, stop Tracker Activity and click the Save button.

> Once the Save/List button is clicked, you will be brought to to a screen displaying a list Expeditions in your project.
> > ![https://lh6.googleusercontent.com/-C8MADyLTo7M/Tt_3bQa1hfI/AAAAAAAAAGM/9XB8TRQM1gc/s400/Expedition%252520List.jpg](https://lh6.googleusercontent.com/-C8MADyLTo7M/Tt_3bQa1hfI/AAAAAAAAAGM/9XB8TRQM1gc/s400/Expedition%252520List.jpg)


---


# Known issues #
  * Tracker Activity crashes if you click on a list item while Viewing the list of Expeditions.
  * Viewing expeditions functionality needs to be implemented.
  * Delete expeditions functionality needs to be implemented.


---


# Conclusion #


> The "Tracker Activity" can serve multiple purposes within the scope of POSIT.

> The ability to share expeditions and projects shows that Tracker’s important applicable functionality. The ability improve efficiency via coordinating and storing expeditions for such things as search and rescue missions is an example use of Tracker.

> "Tracker Activity" still has known issues. If you have any feedback on bugs or areas of improvements, please contact me (Kalin Ash-Elliott) at ashellio@ualberta.ca. I will look into the issue and incorporate the solution in the next release of "Tracker Activity".