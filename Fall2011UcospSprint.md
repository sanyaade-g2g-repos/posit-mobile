# Agenda #

The goal of the Code Sprint is:
  * to get our development environments set up;
  * to create a POSIT project in  Eclipse (or other IDE) pulling from the Mercurial Google Code Resository;
  * to experiment with running and testing POSIT on both phones and the Android emulator;
  * to learn how to create new issues on the Google issue tracker and to process issues for the project;
  * develop and test and submit a patch for a simple change to the POSIT codebase.

# Participants #

  * [Kalin Ash-Elliott](http://code.google.com/p/posit-mobile/wiki/Kalin_AshElliott_Wiki), U Alberta, ashellio@ualberta.ca
  * [Gordon Leung](http://code.google.com/p/posit-mobile/wiki/GordonLeungWiki), SFU, Vancouver, gal3@sfu.ca
  * [Stanley Fung](http://code.google.com/p/posit-mobile/wiki/StanleyFungWiki), SFU, Vancouver, scf3@sfu.ca
  * [Eric Yao](http://code.google.com/p/posit-mobile/wiki/Eric_Yao_Wiki?ts=1317136068&updated=Eric_Yao_Wiki), U Toronto, jiaxian.yao@gmail.com
  * [Ryan McLeod](http://code.google.com/p/posit-mobile/wiki/Ryan_McLeod_Wiki), U Waterloo, rjmcleod@uwaterloo.ca
  * Ralph Morelli, Trinity College, Hartford, CT, ram8647@gmail.com

# Setting Up the Development Environment #

Setting up your development environment:
  * If you haven't already done so, [install the Android SDK](http://developer.android.com/sdk/installing.html)
  * Work through the [Hello World tutorial](http://developer.android.com/resources/tutorials/hello-world.html)
  * Choose one of the [Hello Views](http://developer.android.com/resources/tutorials/views/index.html) tutorials and work through it
  * Work through the [Google Map View tutorial](http://developer.android.com/resources/tutorials/views/hello-mapview.html)

# Plug-in POSIT #

This semester the UCOSP project will be focusing on revising POSIT into a _plugin architecture_, using some of the ideas and code that was contributed one of last year's UCOSP participants, Stas Kalashnikov.   POSIT's current lead programmer, Rachel Foecking, has already begun this process and we will be working closely with her.

The goal of the plugin architecture is to make it easy to customize POSIT for different clients and to make it possible to add and subtract features from a given customization.  The idea is to provide a basic set of functions -- e.g., adding, listing, mapping, and syncing of geo-coded Finds -- but allow the _data definition_ of the Find to vary from instance to instance.   Similarly, it should be possible, for a user to customize a particular instance by turning some of the available features -- e.g., mapping, tracking, images -- on or off.

The refactoring approach is to remove most of the functions currently included in POSIT (e.g., tracking, mapping).  Revise the basic architecture into an API that contains much of POSIT's basic functionality and is easy to extend.  Then add POSIT's functions back into system by extending the basic architecture.

# Downloading and Running the POSIT Codebase #

  * Download the experimental POSIT code base from the [test\_branch of the plugin repository](http://code.google.com/p/posit-mobile/source/browse?repo=plugin&name=test_branch).

  * Experiment with POSIT, trying as many features as you can.
  * Try adding, saving, and revising Finds.
  * Try listing Finds and selecting Finds from the list.
  * Try viewing Finds on the Map.
  * If you discover bugs or deficiencies, create a New issue on the Google Issue Tracker:  http://code.google.com/p/posit-mobile/issues/list
  * First check that the issue isn't already on the Issues list.

# UCOSP Workflow #

For now at least we will use the following workflow with the Google Code repository.
  * Mercurial Tutorial: http://code.google.com/p/rawtherapee/wiki/MercurialHowto
  * Rachel and I will have commit access to the Google code repository.
  * For each issue you fix create a patch and post the patch in the issue tracker.
  * Patches should be thoroughly tested before they are submitted.
  * Patches should also be very well documented before they are submitted.
  * Rachel or I will test the patch and review its code and, if it's okay, will push


# Using the Issue Tracker #

We would like to have a consistent bug/enhancement workflow process, as follows:
  * Create issue for bug/enhancement, marked as NEW.
  * If you are going to start working on the issue, mark it as STARTED.
  * If Ralph reviews a NEW issue, he may mark it as ACCEPTED to indicate it is a reproducible POSIT issue or acceptable new feature, or mark it as INVALID if it is not a reproducible issue or is not a POSIT issue, or mark it as WONTFIX if it is out of the scope of the project.
  * Once a (non-vetted, unreviewed) change is proposed by a student who has been working on the bug/enhancement, they should create a patch and post the patch file on the issue tracker. All patches should be thoroughly tested and properly documented before they are submitted.
See the tutorial here on submitting patches:  http://code.google.com/p/rawtherapee/wiki/MercurialHowto
  * Anyone who tests a patch should comment with the method they used and their results.
  * Ralph and Rachel will be responsible for finally vetting and either accepting or rejecting patches.  If the changes are confirmed to fix the problem, he will change the status to FIXED.  If the changes are furthermore considered to be acceptable for contribution to the project, Ralph will pull the changes into his clone of the main repo and push up to the main and/or the ucosp trunk.  He will then notify all contributors via email that there are changes to the main code base for us to pull into our own repos using the same method.  The issue shall be marked as VERIFIED.  If the changes are a good step towards a fix but still require work, the status should be changed to STARTED and a detailed comment left describing why the change is not yet acceptable.  It may be that, at this point, Ralph can decide that the bug/enhancement is no longer worthwhile and it can be marked as WONTFIX.