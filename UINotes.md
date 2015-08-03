# User interface notes #

Tutorial
  * Getting Started
    * Should all fit on one screen
  * No orphans on paragraphs (or anywhere there is hard coded text on the screen)
  * Should be wizard**like with built-in functionality
    * people don't want to read a bunch before they start using the app
  * Inconsistencies between traces, and expeditions
  * Finds
    * mentioned before it's explained what they are**

**login screen
  * should be consistent with the home screen
    * link to the website
  * should be able to login from here with the option to create a new account**

Create new account
  * server should be a dropdown with the option to type in a new address
  * allow canceling of editing textboxes
  * remove colons from the field names
  * confirm password field doesn't come back up
    * create account button should be visible when typing in confirm password
  * No feed back after clicking enter
    * creating an account is not instant, should have a progress indicator
Register device screen
  * barcode button shouldn't be on the bottom, should be the first thing if the functionality works
  * progress indicator for logins
  * no error codes if something goes wrong
    * these should be human readable and stick around long enough to actually read them
Settings page
  * change order to be of frequency
  * register doesn't make sense
  * current user is only info, everything else is clickable
Change Current Project
  * don't show error message
    * these should be human readable and stick around long enough to actually read them
  * After switching project don't show popup with OK button
    * the user can't do anything at this point so it's useless to have the popup
    * Don't mention syncing the project (user doesn't need to know that) only show "switching project"
View Finds
  * Remove find id as this is not human readable or useful information
  * Name and Description should look like the standard android settings list
  * "Loc" should be Location or Latitude:x Longitude:Y
  * Possibly add more color, it's a boring screen
  * Don't show that the find is sync'd instead only show if it is "Not Sync'd"
  * Don't have a filler image. If there is no image associated with the Find give more room for name/description
  * Consider removing "Delete all finds" menu item
    * Could have a "Delete Project" instead
  * Should automatically sync only have to manually sync if there was an error automatically syncing
Individual Finds Viewing
  * No id
  * Long/Lat should be on the same line in the for of a coordinate (12.3245, 55.3333)
  * Name should be a label
    * Shouldn't be changeable.  If you rename the find the others in the group will have no idea if that is a new find or be able to find the old find if they wanted to
    * Put in grey bar
  * Description should be a multi**line box
    * Possibly use smaller text to show more
  * Save button
    * pressing back should automatically save the find no button needed
      * could be in the menu
  * Longitude/ Latitude should be clickable to show the map of the find
  * Remove buttons
    * should be in the menu
  * If there is no image add a clickable "add image" picture
    * Should always be first in the list
Map of Finds
  * Add callouts to finds
    * first image and name, possibly description if it would fit
    * Clickable to get to that finds "View Find" screen
  * Don't use android guys for the placemarks
    * use the proper pin** like placemarks
    * android guy for user's current location
  * menu
    * Search finds should be called something else because you aren't searching them
      * Either Cycle through finds, or grey out buttons so they aren't clickable if you are the first one or last one
      * Add x of y to the call out so the user knows what number they are at
        * popup is for error messages not useful info
      * Cycle through "My finds" or other people's finds
        * going through all finds chronologically within all users doesn't show what it should
          * a path of the finds/how they were found
      * Arrow buttons should be square, not rectangular
    * Center finds should be called "Show Finds"
      * give it a new icon. You are already on the map how do you go to a map in the map?
Add find
  * similar to viewing and individual find
Coverage tracker
  * Buttons are different than the rest of the app
  * Don't use abbreviations
  * Swath and min dist should be in the settings
    * mindist
      * units on everything
      * 3 should be (walking)
    * swath
      * add units
      * small, medium, large
  * no "idle"
    * shown by play button switching to stop
  * remove altitude because it is nowhere else
  * remove pts, it's not useful to the user
  * Show distance traveled and time it took/was running
  * Only mention the network or gps if it's not working
  * Stop
    * popups are too fast to read
Expedition list
  * Expedition is spelled wrong
  * Don't show project #, user doesn't know what that is
  * This list should look the same as settings and view finds lists
Home Screen
  * Should show state
    * current project
    * current server
    * number of finds
      * possibly in the button itself
  * Map button
    * centered to current location
  * Start expedition easily
  * get to expeditions list easily
  * menu
    * Adhoc should be in the settings
    * order menu by frequency


**When typing in one text box, you should be able to see what the next item will be** Consistent text box labeling
**menus on every screen but settings (standard)** don't ask the user if they want to go to the phone's home screen. (Hitting back on the app's home screen)
**consistent Next and Done labels for keyboard when entering text** If there is a display of altitude somewhere, it should be everywhere location is shown
**Add grey bar functionality like standard android apps (shows what screen the user is on)** When the coverage tracker is running, there should be an icon on the phone's status bar at the top
