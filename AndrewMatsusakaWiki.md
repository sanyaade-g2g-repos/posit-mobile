# Introduction #

Fourth year Computer Science student studying at University of Manitoba. Will be graduating in April of 2012.

# Proposal #

ODT: http://dl.dropbox.com/u/3537167/SyncImprovement_Proposal.odt

PDF: http://dl.dropbox.com/u/3537167/SyncImprovement_Proposal.pdf

# Weekly Log #

## Week of January 23 ##
-Attended UCOSP 2012 code sprint

-Set up development environment and familiarized with workflow

-Worked with Rob to fix an issue with camera data persisting across finds

-Submitted patch that was pushed to main branch

-Attended weekly meeting and picked up another camera related issue

## Week of January 30 ##
-Looked into duplicate images appearing on web server when syncing

-Was unsure what type of implementation would be best suited for this issue, so it was discussed during Thursday meeting

-We agreed on a solution where the image will not be sent based on its creation/modified date

-Completed and tested change to only send out of sync image. Submitted patch.

## Week of February 6 ##
-Attended weekly meeting and discussed issues fixed as well as the term projects

-I decided to work on the synchronization process to create a sync library as part of POSIT's core

-Put together some ideas of how to go about creating this library

-Wrote an abstract about the project and sent to Ralph

## Week of February 13 ##
-Discussed ideas with Ralph concerning the synchronization project

-Put together some diagrams and planned out the design for the new synchronization process

-Added ideas and diagrams to the project proposal, which is still in progress

-Completed initial draft of project proposal and sent to Ralph and Trishan for approval

## Week of February 20 ##
-Will be out of town during this time and will have limited access to internet.

## Week of February 27 ##
-Began work on creating abstract class SyncMedium

-Worked out more details on how to simplify sync process

## Week of March 5 ##
-Continued work on abstract class, started work on both SMS and WiFi sync

-Completed WiFi sending/receiving of finds

-Testing changes and confirming original functionality for WiFi

-Some challenges that arose:

> -Syncing images will require additional methods to be handled

> -SMS and WiFi syncing differences will either require major redesign or use one as the standard for future sync methods

> -SMS (Bundles) appears to be the ideal option to go with here

## Week of March 12 ##
-Tested WiFi syncing to confirm previous functionality. After testing with various plugins it appears to be working properly.

-Completed majority of the SyncMedium functionality and it has been tested.

-Still feel as though SyncMedium may need some cleaning up as SMS is finished off. No major changes but minor fixes here and there to improve organization.

-Will need to collaborate with Elias as we start to merge projects

-Created issue and submitted patch for new changes.

-Wrote blog post for the HFOSS blog and submitted to Trishan for review.

## Week of March 19 ##
-Majority of SyncSms implementation is finished, just testing to confirm previous functionality before submitting patch for it

-Increased the amount of functions within SyncMedium that are public

-Added a few methods for getting changed finds in various formats

-Submitted patch with SyncMedium, SyncServer and SyncSms changes.

-Will start working on [Issue 344](https://code.google.com/p/posit-mobile/issues/detail?id=344)

## Week of March 26 ##
-Worked with Eric in adding project list request to server and changing current project

-Added java doc to all new functions and classes

-Added boilerplate comments to all new files added

-Looked into [Issue 344](https://code.google.com/p/posit-mobile/issues/detail?id=344) and found it to be an enhancement, not a bug.

-Started testing SyncSms changes, however phone started to have issues with SMS in general. Cause of SMS issues not POSIT related.