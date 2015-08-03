# Project Proposal #
Plugin Manager: [PluginManagerProposal](http://dl.dropbox.com/u/20066539/Documents/POSIT/UCOSP_Proposal_Plugin_Manager.odt)

# Weekly Updates #

### Jan 20 - Jan 26 ###
  * Set up development environment
  * Submitted a trivial patch ([Issue 327](https://code.google.com/p/posit-mobile/issues/detail?id=327))
  * Worked on adding the finish callback with Andrew to address [issue 328](https://code.google.com/p/posit-mobile/issues/detail?id=328)

### Jan 27 - Feb 2 ###
  * Added parameters to finish callback
  * Fixed [issue 334](https://code.google.com/p/posit-mobile/issues/detail?id=334)
  * Created wiki page

### Feb 3 - Feb 9 ###
  * Find some more issues to work on
  * Come up with project ideas
  * Recruted some developers to work on POSIT and set them up with the development environment
  * Looked into creating a user accessable plugin manager
  * Created paper prototypes for project ideas: [PluginManager](http://dl.dropbox.com/u/20066539/Images/POSIT/Plugin%20Manager.jpg), [MainActivity](http://dl.dropbox.com/u/20066539/Images/POSIT/Main%20Activity.jpg)

### Feb 10 - Feb 16 ###
  * Researched project and wrote up first draft of the [proposal](http://dl.dropbox.com/u/20066539/Documents/POSIT/UCOSP_Proposal_Plugin_Manager.odt)

### Feb 17 - Feb 23 ###
  * Added new menu item in settings menu to access the plugin manager
  * Added GUI for toggeling function plugins
  * Added database table for storing a plugin's enabled status
  * Synced new GUI and new database table
  * Initialized database table from plugins\_preferences.xml
  * Removed all warnings form modified files

### Feb 24 - Mar 1 ###
  * Replaced the database table for storing a plugin's enabled status with shared preferences
  * Created event for informing classes of a newly enabled/disabled plugin and added code to handel this event in the necessary classes
  * Created [issue 340](https://code.google.com/p/posit-mobile/issues/detail?id=340) and submitted a patch for the set of core requirements

### Mar 2 - Mar 8 ###
  * Created [issue 342](https://code.google.com/p/posit-mobile/issues/detail?id=342) which addresses the find plugin enhancements suggested in my project proposal
  * Implimented UI changes for [Issue 342](https://code.google.com/p/posit-mobile/issues/detail?id=342)
  * Started looking into modifying the server to store which find plugin is associated with a project

### Mar 9 - Mar 15 ###
  * Added ability to show descriptions for function plugins
  * Added ability to specify which function/find plugins will be available to the user from the plugins\_preferences.xml file.

### Mar 16 - Mar 22 ###
  * Worked on getting descriptions working for find plugins
  * Added Javadoc to the code I have written
  * Submitted patch for [Issue 340](https://code.google.com/p/posit-mobile/issues/detail?id=340)

### May 23 - Mar 29 ###
  * Cleaned up code and removed find plugin features for final patch