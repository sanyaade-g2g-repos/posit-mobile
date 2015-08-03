# Introduction #

  * Pursuing a Double Major in Computer Science and Economics at the University of Toronto
  * Member of the POSIT team for Winter 2012!

# Proposal #

Enhancing the POSIT Mapping Plugin - Final Proposal
  * ODT File: http://dl.dropbox.com/u/49194078/UCOSP%20Final%20Proposal.odt
  * PDF File: http://dl.dropbox.com/u/49194078/UCOSP%20Final%20Proposal.pdf

# Details #

### _Week of January_ _15_ ###
  * Began to set up environment for POSIT project
  * Worked through two Andorid tutorials

### _Week of January_ _22_ ###

  * Met the team at UBC for the **UCOSP code sprint**
    * Finished environment set-up, and installed POSIT on an Android phone (after some difficulties)
    * Traced through POSIT architecture
    * Worked through creating an issue and submitting a patch for a trivial issue - [Issue 324](https://code.google.com/p/posit-mobile/issues/detail?id=324)
  * Assigned [Issue 330](https://code.google.com/p/posit-mobile/issues/detail?id=330)

### _Week of January_ _29_ ###

  * Code-reading
  * Completed a Preferences tutorial for Android
  * Thought of possible project ideas - enhancing the Finds Map
  * Worked on [Issue 330](https://code.google.com/p/posit-mobile/issues/detail?id=330)

### _Week of February_ _5_ ###

  * Submitted a patch for [Issue 330](https://code.google.com/p/posit-mobile/issues/detail?id=330)
  * Added [Issue 335](https://code.google.com/p/posit-mobile/issues/detail?id=335)

### _Week of February_ _12_ ###

  * Developed a basis for looking at the mapping plugin in POSIT
    * Read POSIT:Basic Functions - Mapping Finds - http://notes.hfoss.org/index.php/POSIT:BasicFunctions#Mapping_Finds
    * Worked through Android mapview tutorial - http://developer.android.com/guide/tutorials/views/hello-mapview.html
  * Submitted Abstract of Project Proposal to Ralph - Abstract was OK'ed

### _Week of February_ _19_ ###

  * Researched and wrote First Draft of Project Proposal

### _Week of February_ _26_ ###

  * Looked further into developing a testing procedure for generating multiple Finds, and the use of different data structures for the enhancement
  * Finalized Proposal

### _Week of March_ _4_ ###

  * Began implementation of the class _PointCluster_
  * Working on the creation of a testing framework
  * Wrote blog post - "POSIT: Project Launch Summary"

### _Week of March_ _11_ ###

  * Working on the clustering algorithm and _draw_ function in FindOverlay.java
  * Completed testing procedure - this requires some modifications since currently it is not completely independent from existing code

### _Week of March_ _18_ ###

  * Continued working on the functions _addOverlayItemClustered_ and _draw_
  * Experienced reboot loop problems with my Nexus One again - this significantly hindered development because I couldn't test. I ended up using a friend's phone, and continue to test using that

### _Week of March_ _25_ ###

  * Clustering is completed!
  * The clusters are visually different from the image on my Project Proposal, but I want to confirm the new image: ![http://dl.dropbox.com/u/49194078/POSIT-ClusterVisual.png](http://dl.dropbox.com/u/49194078/POSIT-ClusterVisual.png)
  * Will be finishing up the ClusterItems screen this week and integrate it with the _onTap_ method in Find Overlay.java

### _Week of April_ _1_ ###

  * Finished _onTap_ method
  * Refactored code to make testing more independent
  * Submitted preliminary patch for Clustering Enhancement
  * Rewrote the draw() function in FindOverlay.java, added comments

### _Week of April_ _8_ ###

  * Spend time getting zoom and pan functionality to work with clustering
  * Added a new class MapViewExtended to account for the above functionality
  * Cleaned up all code, and submitted Final Patch for [Issue 341](https://code.google.com/p/posit-mobile/issues/detail?id=341)
  * Wrote [Clustering](Clustering.md) Walkthrough for POSIT Architecture