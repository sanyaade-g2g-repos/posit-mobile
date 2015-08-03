# Repository Descriptions #

  * Trunk, Revision: 972bf147e9  -- Contains Derek's and Ed's changes from Fall UCOSP, but not Anna's or Yang's or Greg's.
  * ram8647-ucosp clone -- Contains Derek's, Ed's, Anna's, and Yang's changes but not Greg's.

# Details #


  * if you make your own server you can have access to the db (php myadmin)
  * multiple photo bug, let's trace it to explore the code base
    * first open ddms perspective in eclipse: (top right corner where it may say "Java", click the window+ icon)
    * get logcat open in java perspective window>open view>other>android>logcat
    * last time this was touched was yang's rev. it fixed syncing to respect project ids. http://code.google.com/r/ram8647-ucosp/source/detail?r=d2be44cc4ad32d354971b44a92eb67117b8bda0c
    * not sure if it was broken before that
    * in positdbhelper.java, sendfind having trouble: never returns false
    * send in commmunicator.java: make it return false
    * getdeltafindsids in syncthreads.java line 185 should return empty if nothing to pull in
    * next thing: determine where it's not broken. ralph thinks it was working before yang's rev
  * deleting files on the server or someone else's phone never deletes photos from the phone. we should discuss whether this is desirable behaviour
  * Jon is installing a POSIT server that we will be able to access
  * Alberta folks proposed a different repo structure, but we're keeping the model from last semester
  * created clones: Winter2011UcospSprintHowToClone
  * you'll be able to pull changes from each other's clones and the mainline
  * you'll have to email Ralph to request anything pulled into main from your repo
  * Winter2011UcospSprintPersonalWorkflow


## Summing Up ##

  * We got to track down a nasty bug, and see the sorts of synchronization issues we're dealing with.
  * We should do refactoring and bug fixes and first release in about a month.
  * Each student needs to pitch and create a feature. It won't need to be releasable by the end of the semester.
  * Project proposal due in maybe three weeks?
  * Tracker, bluetooth, maps, syncing need to be tested and incorporated into release 2 by the end of the semester.