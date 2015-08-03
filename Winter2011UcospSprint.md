# Introduction #

The goal of the Code Sprint is:
  * to get our development environments set up;
  * to create a POSIT project in  Eclipse (or other IDE) pulling from the Mercurial Google Code Resository;
  * to experiment with running and testing POSIT on both phones and the Android emulator;
  * to learn how to create new issues on the Google issue tracker and to process issues for the project;
  * develop and test and submit a patch for a simple change to the POSIT codebase.


# Details #

Setting up your development environment:
  * If you haven't already done so, [install the Android SDK](http://developer.android.com/sdk/installing.html)
  * Work through the [Hello World tutorial](http://developer.android.com/resources/tutorials/hello-world.html)
  * Choose one of the [Hello Views](http://developer.android.com/resources/tutorials/views/index.html) tutorials and work through it
  * Work through the [Google Map View tutorial](http://developer.android.com/resources/tutorials/views/hello-mapview.html)

Creating a POSIT project in Eclipse
  * POSIT uses Mercurial; here's a nice [hands-on Tutorial](http://mercurial.selenic.com/wiki/Tutorial)
  * Read and follow the suggestions in the [Mercurial Tutorial](http://code.google.com/p/posit-mobile/wiki/MercurialTutorial)
  * Create a POSIT project in your Eclipse:  New> Other> Mercurial> Clone Existing Mercurial Repository.
> -- Use the following URL: http://code.google.com/r/ram8647-ucosp/
> -- Test that POSIT runs successfully on your phone

# Using POSIT #
  * Create a user account
> -- Create a user account on: http://www.cs.trincoll.edu/~ram/positweb/web/main
> -- We can share the pre-existing project: UCOSP Winter Sprint, which is owned by ram8647 (I will have to share it with you)
> -- You can also create your own projects
  * Run POSIT (as Android Application) through the USB cable
> -- Work through the POSIT tutorial on the phone
  * Register the phone with the server
> -- New User: Choose this option if you don't have a user account on the server
> -- Login:  If you already have a user account
> -- Select the UCOSP Winter Sprint project (POSIT should sync an existing Find)

  * Experiment with POSIT, trying as many features as you can.
> -- Try adding Finds and images, syncing with the server.
> -- Try viewing Finds on the Map on both the phone and the server.
> -- View Finds > Sync Bluetooth:  Needs testing
> -- View Finds > Map > Center Finds: Needs testing
> -- View Finds > Map > Search : Needs testing
> -- Adhoc Mode: Test Infrastructure mode -- requires wifi hotspot
> -- Coverage Tracker: Test on way to lunch -- requires Sim card or Wifi.
> -- If you discover bugs or deficiencies, create a New issue on the Google Issue Tracker:  http://code.google.com/p/posit-mobile/issues/list
> -- First check that the issue isn't already on the Issues list.

Setting up a Workflow
  * We (Edward, Jon, and I) will set up and experiment with a Mercurial model in which we share a UCOSP branch.

# Using the Issue Tracker #

We would like to have a consistent bug/enhancement workflow process, as follows:
  * Create issue for bug/enhancement, marked as NEW.
  * If you are going to start working on the issue, mark it as STARTED.
  * If Ralph reviews a NEW issue, he may mark it as ACCEPTED to indicate it is a reproducible POSIT issue or acceptable new feature, or mark it as INVALID if it is not a reproducible issue or is not a POSIT issue, or mark it as WONTFIX if it is out of the scope of the project.
  * Once a (non-vetted, unreviewed) change is proposed by a student who has been working on the bug/enhancement, they should push the changes to their server side clone, and add a comment to the issue including a link to the appropriate changeset.
  * Anyone who tests the changes should comment with the method they used and their results.  Ralph will be the person responsible for finally vetting and either accepting or rejecting the changes.  If the changes are confirmed to fix the problem, he will change the status to FIXED.  If the changes are furthermore considered to be acceptable for contribution to the project, Ralph will pull the changes into his clone of the main repo and push up to the main and/or the ucosp trunk, .  He will then notify all contributors via email that there are changes to the main code base for us to pull into our own repos using the same method.  The issue shall be marked as VERIFIED.  If the changes are a good step towards a fix but still require work, the status should be changed to STARTED and a detailed comment left describing why the change is not yet acceptable.  It may be that, at this point, Ralph can decide that the bug/enhancement is no longer worthwhile and it can be marked as WONTFIX.


Enhancements, Bug Fixes, Patches
  * In this part we are going to work together to make changes to the POSIT code base and share those changes among ourselves.
  * Some ideas
> -- Tutorial: Improvements, missing elements?
> -- Registration: Can the instructions be improved?

  * Issues (I'm sure we'll find others)
> -- [Issue #96](https://code.google.com/p/posit-mobile/issues/detail?id=#96): Add the time stamp to the Add Find View
> -- [Issue #103](https://code.google.com/p/posit-mobile/issues/detail?id=#103): Use an Intent flag to return to List of Tracks
> -- [Issue #64](https://code.google.com/p/posit-mobile/issues/detail?id=#64) and #79: Determine if still a problem
> -- [Issue #62](https://code.google.com/p/posit-mobile/issues/detail?id=#62): Determine if still a problem
> -- [Issue #72](https://code.google.com/p/posit-mobile/issues/detail?id=#72): Determine if still a problem
> -- [Issue #65](https://code.google.com/p/posit-mobile/issues/detail?id=#65): Record user email after registering with barcode reader.


Setting up a POSIT Server (optional)
  * If you wish to install your own POSIT server, following the instructions provided in [the POSIT Web Docs](http://code.google.com/p/posit-mobile/wiki/PositWebDocs).

**Problems encountered by UCOSP 2011 students are being recorded at Winter2011UcospSprintProblems**

Notes for discussion with Ralph, Tristan and Eran on Saturday during the sprint at Winter2011UcospSprintSaturdayNotes