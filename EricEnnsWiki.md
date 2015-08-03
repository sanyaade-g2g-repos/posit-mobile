# Introduction #

  * 4th year Honours CS student from University of Manitoba (Winnipeg).
  * Part of the Winter 2012 UCOSP team.

# Proposal #

Enhancing the POSIT UI - Final Proposal
  * ODT File: http://dl.dropbox.com/u/29208261/Posit/UCOSP_Proposal.odt
  * Generated APK file from clone: http://dl.dropbox.com/u/29208261/Posit/ericenns-posit-ucosp-2012.apk

# Weekly Updates #

### Week Ending January 24/2012 ###
  * Attended UCOSP Sprint at UBC
  * Performed test patch which added comments
  * Read Android Design guidelines  http://developer.android.com/design/index.html
  * Tasked with working on [issue 329](https://code.google.com/p/posit-mobile/issues/detail?id=329)

### Week Ending February 2/2012 ###
  * ReRead Android Design guidelines
  * Tested positx on tablet (running ICS)
  * Resolved [issue 329](https://code.google.com/p/posit-mobile/issues/detail?id=329) (Waiting for patch to be accepted)
  * Looking at http://code.google.com/p/iosched/ on how they do actionBar on pre honeycomb

### Week Ending February 9/2012 ###
  * Requested membership to posit group, in pending status
    * Was going to email about using http://actionbarsherlock.com/ to have a UI that was usable on 1.6 to 4.0+ and that followed the design guideline at http://developer.android.com/design/index.html
  * Created Mockups for project to update UI used [WireFrameSketcher](http://wireframesketcher.com/)
    * [FirstRun](http://dl.dropbox.com/u/29208261/Posit/Mockups/FirstRun.png) [Main](http://dl.dropbox.com/u/29208261/Posit/Mockups/Main.png) [DisplayFind](http://dl.dropbox.com/u/29208261/Posit/Mockups/DisplayFind.png)
  * Found [issue 336](https://code.google.com/p/posit-mobile/issues/detail?id=336), unsure how to approach issue
    * Do I re log all finds each time
    * Do I check to see if the file exists and if not re log all finds
    * What If file is not created by posit, how do I tell, how do I handle
  * Found [Android Screen Monitor](http://code.google.com/p/android-screen-monitor/) and [Android Screencast](http://code.google.com/p/androidscreencast/) may be usefull for demoing application during our meetings
  * Found [issue 337](https://code.google.com/p/posit-mobile/issues/detail?id=337), and submitted a patch which fixes the bug

### Week Ending February 16/2012 ###
  * Wrote abstract and now working on project proposal
  * Tested out ActionBarSherlock
  * Wrote a blog post about android screen capture utilities

### Week Ending February 23/2012 ###
  * Wrote preliminary final draft of proposal [Proposal](http://dl.dropbox.com/u/29208261/Posit/UCOSP_Proposal.odt) Updated February 27/2012
  * Tested ActionBarSherlock further

### Week Ending March 1/2102 ###
  * Started writing code for ui
  * Created classes ORMLiteBaseFragmentActivity
  * Created org.hfoss.posit.android.api.fragment
  * Starting moving code from ListFindsActivity.java to ListFindsFragment.java
  * Starting to move code from FindActivity.java to FindFragment.java

### Week Ending March 8/2012 ###
  * Updated to ActionBarSherlock to v4.0.0 release
  * Created splitpane view for viewing and editing and creating finds on a tablet
  * code tested with previous plugins and works
  * commented out ACDIVOCA code

### Week Ending March 15/2012 ###
  * created [issue 344](https://code.google.com/p/posit-mobile/issues/detail?id=344) and 345
  * worked on creating guide for using my clone

### Week Ending March 22/2012 ###
  * submitted patch for [issue 345](https://code.google.com/p/posit-mobile/issues/detail?id=345)
  * created [issue 346](https://code.google.com/p/posit-mobile/issues/detail?id=346) and enhancement [issue 347](https://code.google.com/p/posit-mobile/issues/detail?id=347) for my project
  * found issue with magnification showing, had to modify manifest to say which screen sizes are supported

### Week Ending March 29/2012 ###
  * Changed to ActionBarSherlock v4.0.1 no code changes needed
  * Added project selector to actionbar in posit main screen