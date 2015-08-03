# Summary of February 9th skype meeting #

## Attendance ##
  * Ralph
  * Sarah
  * Sean
  * Stas
  * Edward
  * Jon

## Status of test/refactor tasks ##

### Sarah ###
  * Has been swamped by work in other classes.

### Sean ###
  * Found some 30+ unused resources from the res/drawable folder.
    * Can be removed, no compiler warnings or runtime issues observed.
    * Accomplished through simple bash script (3-4 liner).
    * Can likely be easily adapted for other resource folder.

### Stas ###
  * Has been looking into compiler warnings.
    * Able to clear up most of them.
    * Hesitant to make changes to warnings related to bluetooth and/or adhoc code.
      * So far not able to get these things to work, so can't really test changes.
      * Related: Working on getting wifi working for other devices.

### Jon ###
  * Refactoring out code from catchall Utility class into more fitting places has not really panned out, but the activity has had great side effect of more familiarity with code base.
  * Only briefly looking at [robotium](http://code.google.com/p/robotium/) for automated testing.

## Discussion of term project ideas ##

### Sarah ###

  * Stepping back from SMS protocol idea as work is being done in that area by non-UCOSP contributors.
  * Instead: registration process.
    * Problems include:
      * Lack of clarity of what it really means to log in.
      * Issues with barcode process.
      * Inability to log out, except through a bug.

### Sean ###
  * UI work.
    * Making UI for different activities more consistent with each other, and with recommended android standards.
    * Looking at what type of UI elements are used for certain tasks (dropdowns vs other selection methods, etc).
    * Edward wanted to add the concern that often the menu button does not do anything in certain contexts.
      * Users expect **some** response from the menu button, or they may think something is going wrong.
      * We should consider what useful menu options POSIT can have for these situations.

### Stas ###
  * Interested in working towards customization for UofA Biology professor's purposes.
    * Edward and Jon pointed out that this may not be feasable, due to her project timeline.
  * Alternatively interested in working towards architectural changes to support some sort of plugin API.
    * Outside developers may be interested in adding functionality not in POSIT, things like collecting sound clips or accelerometer data with finds.
    * Ralph brings up the concern that any change to data collected with a find will require corresponding changes on the server and in the database.
    * Ralph brought up a related subproject that was attempted in the past (but did not get very far).
      * Web GUI for building new Find creation activities.
      * Exports xml.
      * Tool to translate xml into code for new workflow.
      * However, what Stas is talking about is more a programmatical API targeted at people with development skills.
    * Edward points out that this seems somewhat in line with the idea of Intents in android development.
    * Ralph is concerned about this being a project that can be completed in a single term.
    * Stas and Ralph will discuss this further during the week.

### SIDEBAR: Philosophical discussion on term projects vs long term POSIT maturation ###
  * It is a major concern of Ralph that larger projects that are started but not finished in the scope of a single term will be abandoned forever.
    * Stas points out that project leader(s) (Ralph, among others) should be responsible for ensuring that larger projects receive further attention from future contributors.
  * Stas points out that POSIT is a "young" code base.  It is at a stage where it is often beneficial to look at larger architecture design and ensure that it is good for long term evolution.
  * It seems like there is some difficulty in balancing the need for projects that meet the requirements of the UCOSP program with needs within POSIT.

### Jon ###
  * Has identified security concerns with app-server communication.
  * Correcting this issue is also one that will require more effort than one student project over one school term.
    * Ralph points out that this work is necessary to correct a defect, not considered an "enhancement".
  * Options have been identified as potential strategies:
    * Investigate some more mature support for secure communication and syncing that have been added to the Android API.
    * Try building a protocol within the context of Java SSLSockets.
  * Ralph would like to see a project proposal that clearly provides a goal that can be completed within the term.

## For Next Meeting ##

  * Have project proposal written up.
    * Either add as page on this wiki, or post elsewhere and link from this wiki.
    * Jon suggests having these posted at least a day before next week's meeting, so that we can read each others' proposals before the meeting.
    * Ralph emphasized that these writeups will be subject to discussion/revision.
  * Finish up as much as possible testing/refactoring tasks.