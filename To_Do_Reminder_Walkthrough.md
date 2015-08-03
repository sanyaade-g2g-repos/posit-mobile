# Introduction #

> #### "Location Aware To-Do Reminder" is a function plug-in for POSIT that lets users set geo-aware reminders for finds. ####

> #### The user set the reminder by specifying a particular date and location; and when the user is in the proximity of the location on the desired date, POSIT will notify the user of the reminder set. ####

> #### This function plug-in is independent of the basic POSIT and can be easily detached by modifying "plugins\_preferences.xml". ####

> #### The following walk-through will guide you through how to enable and use "To-Do Plug-in". ####


---


# To-Do Reminder Walk-through #

> ## How To Enable To-Do Plug-in ##

> #### To enable the "To-Do Reminder" function plug-in, you would need to go through the following steps. ####

> ### 1. Attach To-Do Plug-in ###

> Change "active=**false**" of the following code in "plugins\_preferences.xml" to "active=**true**".

```
  <Plugin active="false" 
	type="function" 
	extensionPoint="addFindMenu"
	name="setReminder" 
	menuIcon="ic_menu_list" menuTitle="Set Reminder"
	menuActivity="org.hfoss.posit.android.experimental.functionplugins.SetReminder"
	activity_returns_result="true"
	activity_result_action="0" />
```

> ### 2. Enable To-Do Plug-in ###

> Go to the Setting Menu, and check the "Allow Reminder" check box if it is not checked.

> Because "Allow Reminder" is dependent of "GeoTagging", make sure you check "GeoTagging" first before checking "Allow Reminder".

> ![https://lh3.googleusercontent.com/-r2tYXtTvnVQ/TtMK2uDcesI/AAAAAAAAAGE/jcrkMYmUAFU/s400/1.png](https://lh3.googleusercontent.com/-r2tYXtTvnVQ/TtMK2uDcesI/AAAAAAAAAGE/jcrkMYmUAFU/s400/1.png) ![https://lh6.googleusercontent.com/-5j9WLdPo_Rk/TtMK2cD1vBI/AAAAAAAAAF0/jeAA0kFSc5g/s400/2.png](https://lh6.googleusercontent.com/-5j9WLdPo_Rk/TtMK2cD1vBI/AAAAAAAAAF0/jeAA0kFSc5g/s400/2.png) ![https://lh6.googleusercontent.com/-NXyhRmVf4vM/TtMK2sxa_TI/AAAAAAAAAF8/n_7AwjRjKGU/s400/3.png](https://lh6.googleusercontent.com/-NXyhRmVf4vM/TtMK2sxa_TI/AAAAAAAAAF8/n_7AwjRjKGU/s400/3.png)

> You have now enabled "To-Do Reminder" function plug-in in POSIT.


---


> ## How To Set Reminder ##

> #### To set a reminder for a find, you need to go through the following steps. ####

> ### 1. Go Into "Add Find" ###

> Click on "Add Find" on the main menu to go into the "Add Find" interface.

> ![https://lh3.googleusercontent.com/-r2tYXtTvnVQ/TtMK2uDcesI/AAAAAAAAAGE/jcrkMYmUAFU/s400/1.png](https://lh3.googleusercontent.com/-r2tYXtTvnVQ/TtMK2uDcesI/AAAAAAAAAGE/jcrkMYmUAFU/s400/1.png) ![https://lh6.googleusercontent.com/-RTPXbXb5zh4/TtMK2wv7U-I/AAAAAAAAAGM/EGwMofmmYxQ/s400/4.png](https://lh6.googleusercontent.com/-RTPXbXb5zh4/TtMK2wv7U-I/AAAAAAAAAGM/EGwMofmmYxQ/s400/4.png)

> ### 2. Type Name And Description ###

> In "Add Find", type in the name and description of the reminder, and click on **"Set Reminder"** in the menu.

> ![https://lh4.googleusercontent.com/-8DaSTIuUOW0/TtMK3Pf05CI/AAAAAAAAAGU/Su3lQWzV-BA/s400/5.png](https://lh4.googleusercontent.com/-8DaSTIuUOW0/TtMK3Pf05CI/AAAAAAAAAGU/Su3lQWzV-BA/s400/5.png) ![https://lh4.googleusercontent.com/-6y76CV39ERI/TtMK3WOQTWI/AAAAAAAAAGc/Ar0G0NLF5UQ/s400/6.png](https://lh4.googleusercontent.com/-6y76CV39ERI/TtMK3WOQTWI/AAAAAAAAAGc/Ar0G0NLF5UQ/s400/6.png)

> ### 3. Step 1: Choose a Date ###

> In **Step 1**, select a desired date and press "Set", which leads to **Step 2**.

> ![https://lh3.googleusercontent.com/-iebqvbEWv8g/TtMK3qA1rMI/AAAAAAAAAGk/IVktk0PFxXw/s400/7.png](https://lh3.googleusercontent.com/-iebqvbEWv8g/TtMK3qA1rMI/AAAAAAAAAGk/IVktk0PFxXw/s400/7.png) ![https://lh3.googleusercontent.com/-qzuh8aIslQU/TtMK320a2TI/AAAAAAAAAGs/enm6qp3r4-0/s400/8.png](https://lh3.googleusercontent.com/-qzuh8aIslQU/TtMK320a2TI/AAAAAAAAAGs/enm6qp3r4-0/s400/8.png)

> ### 4. Step 2: Choose an address ###

> In **Step 2**, if you wish to use **"Current Location"** or **"Find's Location"**, this find's location will be set accordingly. This concludes the "Setting Reminder" process and you will see **a blue alarm clock** on the screen to indicate that this find has a reminder attached.

> ![https://lh3.googleusercontent.com/-qzuh8aIslQU/TtMK320a2TI/AAAAAAAAAGs/enm6qp3r4-0/s400/8.png](https://lh3.googleusercontent.com/-qzuh8aIslQU/TtMK320a2TI/AAAAAAAAAGs/enm6qp3r4-0/s400/8.png) ![https://lh6.googleusercontent.com/-4uz40SOF0ns/TtMK5qiq6jI/AAAAAAAAAHc/jc6y4X2HiAk/s400/15.png](https://lh6.googleusercontent.com/-4uz40SOF0ns/TtMK5qiq6jI/AAAAAAAAAHc/jc6y4X2HiAk/s400/15.png)

> ### 5. Step 3: Enter Location Name / Address ###

> In **Step 2**, if you wish to "Enter Location Name / Landmark Address", this will lead to **Step 3**. You can then type **an address**, **an intersection**, **or a landmark name**, such as "45 Willcocks Street", "Yonge and Bloor St", or "Chinatown".

> ![https://lh3.googleusercontent.com/-qzuh8aIslQU/TtMK320a2TI/AAAAAAAAAGs/enm6qp3r4-0/s400/8.png](https://lh3.googleusercontent.com/-qzuh8aIslQU/TtMK320a2TI/AAAAAAAAAGs/enm6qp3r4-0/s400/8.png) ![https://lh6.googleusercontent.com/-t437uvnE5qM/TtMK4CKaCoI/AAAAAAAAAG0/hfZ70DBgOLE/s400/9.png](https://lh6.googleusercontent.com/-t437uvnE5qM/TtMK4CKaCoI/AAAAAAAAAG0/hfZ70DBgOLE/s400/9.png) ![https://lh3.googleusercontent.com/-SBmncKrOXRE/TtMTukKkAnI/AAAAAAAAAIQ/YwE_jeObHpg/s400/17.png](https://lh3.googleusercontent.com/-SBmncKrOXRE/TtMTukKkAnI/AAAAAAAAAIQ/YwE_jeObHpg/s400/17.png)

> ### 6. Search For Exact Location ###

> After you type the location in **Step 3**, press "Search" and a progress dialog will appear. If the typed location is **specific enough to pinpoint the exact location**, this find's location will be set and the "Setting Reminder" process concludes.

> ![https://lh3.googleusercontent.com/-SBmncKrOXRE/TtMTukKkAnI/AAAAAAAAAIQ/YwE_jeObHpg/s400/17.png](https://lh3.googleusercontent.com/-SBmncKrOXRE/TtMTukKkAnI/AAAAAAAAAIQ/YwE_jeObHpg/s400/17.png) ![https://lh6.googleusercontent.com/-4uz40SOF0ns/TtMK5qiq6jI/AAAAAAAAAHc/jc6y4X2HiAk/s400/15.png](https://lh6.googleusercontent.com/-4uz40SOF0ns/TtMK5qiq6jI/AAAAAAAAAHc/jc6y4X2HiAk/s400/15.png)

> ### 7. Step 4: Choose The Desired Location ###

> If, however, the typed location isn't specific enough, **a list of possible addresses** will appear in **Step 4**. If the desired address is not found, press **"Retry"** to re-type a more specific location (with **city name** added). Else, press the desired address, which **finally** concludes the "Setting Reminder" process.

> ![https://lh4.googleusercontent.com/-nCQUdTITJv0/TtMK4TWg8pI/AAAAAAAAAG8/WEt23-4lXPg/s400/10.png](https://lh4.googleusercontent.com/-nCQUdTITJv0/TtMK4TWg8pI/AAAAAAAAAG8/WEt23-4lXPg/s400/10.png) ![https://lh4.googleusercontent.com/-A24OGsOne14/TtMK4qvpsII/AAAAAAAAAHE/Fz_jI27esTw/s400/11.png](https://lh4.googleusercontent.com/-A24OGsOne14/TtMK4qvpsII/AAAAAAAAAHE/Fz_jI27esTw/s400/11.png) ![https://lh6.googleusercontent.com/-4uz40SOF0ns/TtMK5qiq6jI/AAAAAAAAAHc/jc6y4X2HiAk/s400/15.png](https://lh6.googleusercontent.com/-4uz40SOF0ns/TtMK5qiq6jI/AAAAAAAAAHc/jc6y4X2HiAk/s400/15.png)


---


> ## How To See A List Of Reminders ##

> #### To see the list of finds with reminders, press "List Finds" on the main menu. ####

> In "List Finds" interface, you will see some finds have **a blue alarm clock** in their rows. This indicate that they have reminders attached. The other finds without the blue alarm clock means that they are only the basic finds.

> ![https://lh5.googleusercontent.com/-r2tYXtTvnVQ/TtMK2uDcesI/AAAAAAAAAGE/jcrkMYmUAFU/s400/1.png](https://lh5.googleusercontent.com/-r2tYXtTvnVQ/TtMK2uDcesI/AAAAAAAAAGE/jcrkMYmUAFU/s400/1.png) ![https://lh5.googleusercontent.com/-5Wxe5wG_p_Q/TtMK51_sfmI/AAAAAAAAAHk/nVxj3dN0p2c/s400/16.png](https://lh5.googleusercontent.com/-5Wxe5wG_p_Q/TtMK51_sfmI/AAAAAAAAAHk/nVxj3dN0p2c/s400/16.png)


---


> ## How Users Are Notified ##

> #### Once the reminders are set, POSIT's background service will start sensing location changes and check if users are in the proximity of desired locations. ####

> When the users are indeed close to the set locations, **a notification of the reminder** (shown in red rectangle) will appear at the top of the screen.

> Swipe to show the notification interface, users can now see **the actual reminder notification** (shown in red rectangle).

> Press on the notification leads users back into POSIT. Users can then choose to **"Keep the find"** or **"Discard the find"**.

> ![https://lh4.googleusercontent.com/-G6VqhDipes0/TtMK6CDHXaI/AAAAAAAAAHo/BK6flWLlWfU/s400/14.png](https://lh4.googleusercontent.com/-G6VqhDipes0/TtMK6CDHXaI/AAAAAAAAAHo/BK6flWLlWfU/s400/14.png) ![https://lh4.googleusercontent.com/-gCLWqtVnhJE/TtMK4-Kz6JI/AAAAAAAAAHM/mRZTr2HZNQk/s400/12.png](https://lh4.googleusercontent.com/-gCLWqtVnhJE/TtMK4-Kz6JI/AAAAAAAAAHM/mRZTr2HZNQk/s400/12.png) ![https://lh4.googleusercontent.com/-YlzzNAL_UnE/TtMK5DiLTaI/AAAAAAAAAHU/3RTX7Wv03aU/s400/13.png](https://lh4.googleusercontent.com/-YlzzNAL_UnE/TtMK5DiLTaI/AAAAAAAAAHU/3RTX7Wv03aU/s400/13.png)


---


# Conclusion #

> #### The "Location Aware To-Do Reminder" can serve multiple purposes within the scope of POSIT. ####

> #### It could be used simply as a reminder itself with description being the THING to do (e.g., return a book to the library). But it could also be use in combination with the basic find. Having set the desired location to be the find's location, field researchers can be easily notified when they are close to a find that is recorded by their colleges. ####

> #### "To-Do Reminder" function plug-in is still in its early stages. If you have any feedback on bugs or areas of improvements, please send me (Eric Yao) an email at jiaxian.yao@gmail.com. I will look into the issue and incorporate the solution in the next release of "To-Do Reminder". ####