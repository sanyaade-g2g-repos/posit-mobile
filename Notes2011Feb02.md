#Summary of February 2nd skype meeting

Refactoring/testing projects

Sarah
  * refactoring task
    * removed commented out code
      * [issue 140](https://code.google.com/p/posit-mobile/issues/detail?id=140)
    * next: remove unused packages? (confirm with Ralph/list first)
      * Sarah will create a separate issue for each such candidate
  * testing
    * part of refactoring task
  * Sarah has been looking at registration/login


Stas
  * help Sarah look for dead code

Erin
  * Worked on last week
    * Changing of orientation of phone causes view problems
      * added android:configChanges="orientation" to every Activity in AndroidManifest.xml
      * doesn't reset the activity anymore
    * Dialog box that pops up after selecting a project
      * changed to allow for cancellation
        * Ralph unsure whether thi	s is desired behaviour
        * although there's not much a user can do without a project


Dustin
  * Withdrawing from the class

Jon
  * Refactor Proposal
    * Android.utilities.util class
      * put functionality in better groups
      * use android api instead of custom code
  * Testing
    * fixed issues
      * regression?
      * create a reproducable test for [issue 21](https://code.google.com/p/posit-mobile/issues/detail?id=21)
      * framework for ui testing
  * Other work: Jon will take care of merging approved changes


Shawn would like
  * Refactor/testing task
    * Posit includes lots of resources -- e.g., strings, images, xmls -- that are not used and take up space. Identify and remove unused resources.
      * figure out a way to do this programatically
        * possibly check access times of resource files after a run on the emulator


Stas
  * Add "removal of compile warnings" to the list of refactor tasks
  * Refactor/testing task
    * Fix compile warnings
    * move Adhoc constants
      * likely has wide-ranging implications; be careful

Ralph
  * Set up Milestone in issue tracker

Edward
  * Meeting with biologist about using POSIT

Sarah, Stas and Shawn
  * Stay in touch about removing un-needed code/resources

**IMPORTANT best practice: Pull from central repo and merge changes into your own code before pushing your changes to your repo.**

Milestones: 1 week to assess impact of proposed refactorings and/or
good progress on implementation; 1 further week to have that done and
a good proposal for term project