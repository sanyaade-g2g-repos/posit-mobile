# New Mercurial Users #

If you are new to mercurial, or are curious about miscellaneous tidbits that other Posit contributors have found useful, or if you have useful tidbits of your own to add, see:

  * MercurialTips
  * [Mercurial Workflows](http://mercurial.selenic.com/wiki/Workflows)

# Information for Contributors #

If you want to improve Posit, we love you.  But, there are some things that you should know about, as well as some guidelines that you should follow, in order to ensure that the code base stays manageable.

## Local or Remote Clone ##

As a distributed version control system, mercurial offers a lot of flexibility for how you can use it.  At the very least, you will need to create a local clone in your file system in order to make any changes to Posit.  You can commit to this local clone, and be able to save your incremental changes, and the changes you commit will not be visible to others.

You can even make a local clone **from** your local clone.  Some people like to keep a pristine local clone - one without any local changes.  One advantage of this is you can have multiple local second generation clones, in which you are working on unrelated features.  When the features are ready, you can push them back up to your first generation clone.

Because Posit is hosted on Google code, you can take this one step further - make a clone on the Google code site and use it as your pristine first generation clone, and make local clones from that to do work on features.  This method offers a couple of advantages over a local pristine clone.  First, for back up purposes.  Any changes that you push to your Google hosted clone are no longer at risk in case of your hard drive failing.  Of course, it is still possible (but rather unlikely) for Google to lose your data.  Second, any changes that are in your Google clone can be seen by others without the need to export changesets or generate patch files.  People can look at your clone through a web browser, check out a copy to test, pull changesets to their own clones.  Committers on the Posit project can pull from your hosted clone rather than requiring you to generate patches.

## To Branch or Not To Branch ##

Within a clone, there can be multiple branches.  The head of the default branch, sometimes called the "trunk", will generally include the most recent updates, the newest bugfixes, etc.  This is where most changes will be taking place.

Posit also maintains release branches.  As a contributor, you probably don't need to worry too much about these.  A release maintainer will be applying relevant changes from the default branch to the release branch(es).  You probably will not be making changes directly on release branches.

Occasionally, it makes sense to create a feature-specific branch.  If the development of a feature is likely to break existing functionality (at least in early development stages), that feature may be a candidate for a separate branch.  In such a branch, the feature can be developed without interfering with the rest of the code base, and then merged back into the default branch when it is ready.

If you think that the feature you plan to hack on will justify a separate branch, or if you are at all unsure about which branch the work you plan to do belongs in, you should post a message to the [discussion group](http://groups.google.com/group/posit-group).

## Small Commits ##

We cannot stress this enough.  Make your commits small, and make sure they are atomic.

Committing to your local repository regularly is an important habit.  Don't be tricked into non-distributed-version-control thinking - remember, making a local commit is not going to break the build or cause anybody any problems; it cannot even be seen by others.  Making incremental commits gives you and anyone else looking at the code once published a history of the changes.  A local commit need not even be working code, need not even build.  It should simply be a point where some small milestone has been reached on the path towards your goal.  Don't hack away for days before committing any of your work.

What do we mean by atomic?  The changes in a single commit should all relate to each other in some common way.  Maybe the changes are a fix to a single bug.  Maybe they are part of a new feature you are trying to implement.  But you should try to avoid committing changes that fix a bug at the same time as changes relating to a new feature, or committing changes relating to two separate new features in a single commit.  Keeping your changes atomic allows other contributors and committers to more easily examine any changes you post for review, and release maintainers to do their job effectively.

## Share Your Improvements ##

Once you have some changes that are ready to be included in Posit, there are a few different ways to proceed.  If there is an issue open for the bug or enhancement you are working on, you should make a comment on that issue.  In the comment, you should provide some way to look at your changes.  If you have been pushing to a Google hosted clone, then it would be best to provide a link to the most recent relevant changeset in that clone.  Otherwise, you will need to generate a patch and attach it to the issue comment.  It is preferred that you generate such a patch using the

`hg export ...`

command.  This exports entire changesets (or groups of changesets) including author information, change log entries, and the relationships between the changesets.  A committer can take such a patch and apply it to their local clone for testing.  Then, assuming the changes are accepted for inclusion in Posit, when a committer pushes the changes to the primary repository, your name as author and the change log entry that you made will be preserved.

If there is not an open issue associated with your proposed contribution, or if you are not getting a response from your comments on an issue, then you should send a message to the [discussion group](http://groups.google.com/group/posit-group).  Don't take it personally; not most Posit developers do not get notification for every issue.

## Ideas ##

You can find a list of potential subprojects within Posit to hack on at DevelopmentProjectsAndIdeas.  Some of these may be out of date, so be sure to [discuss](http://groups.google.com/group/posit-group) with other Posit developers before spending a lot of time working on these.

# Information for Committers #
## Default Branch is ##

At the present time the main repository for POSIT is named **plugin** (https://ram8647@code.google.com/p/posit-mobile.plugin/).  This is the repo you should clone. And the main branch of that repo named **test-branch**  (**not default**).  Make sure you clone the right branch.

Please apply all changes to the **test-branch** of the **plugin** repository using the guidelines above.

## Release Branches ##
### Current Release Branches ###
EOL:

EOL Announced:

Active:

  * 0.7

### Tips for Managing Release Branches ###

Release branches should always be a subset of changesets from the default branch.  In other words, do not pull anything to a release branch from outside sources, or make separate changes to a release branch that are not made to the default branch, unless it is absolutely necessary.

Your most important tool when managing a release branch is likely to be the transplant extension for mercurial.  You may need to install it as a separate module; consult your linux distribution or wherever you got mercurial from for details.  This extension allows you to apply specific changesets to your current working directory.  So, you can cherry pick the changes relevant to your release branch from the default branch.  Once installed, you can find details on the options for the transplant extension in the mercurial manpage.  For an example of recommended workflow when applying changesets to your release branch, see ReleaseBranchExamples.  If you are already comfortable with using the transplant extension, please just remember that we want to maintain authorship and origin information, so act accordingly and please use the

`--log`

argument when transplanting changesets.

It is useful to note that occasionally changesets will not transplant cleanly.  This is because you may be changing the parent of the changeset; applying diffs over source code that is different than the parent of the original change.  Mercurial will tell you if there are any problems, leaving the normal sort of conflict information in the source files.  You can manually fix these conflicts, and use

`hg transplant -c`

to continue or finish the transplant operation.

Occasionally, despite encouraging contributors to keep commits small and atomic, you may find that only a portion of a commit is relevant to your release branch.  This is where your job can get harder.  You can handle this in one of two ways.  Either transplant the entire changeset, then edit the relevant files to remove the unwanted changes and make another commit, or use

`hg export`

to generate a patch for the changeset, remove the unwanted chunks from the patch, and use

`hg import`

to apply the modified patch to your release branch.  It is also a good idea to add a line to the commit log portion of the patch indicating

`(Partially transplanted from CHANGESET_HASH)`

in order to keep track of source code origins.  Both methods are subject to errors, so be sure to test thoroughly after applying changes in this way!  Both methods have pros and cons; primarily, the transplant-newcommit method avoids the need to edit patch files, which some people find difficult, but results in two changesets in the release branch for a single changeset from the default branch.  An example of each method is found in ReleaseBranchExamples.

## Accepting Patches ##

As a committer on the Posit project, you may be asked to apply changes from other contributors who lack commit access, or from others not formally associated with the project who have provided code to improve or enhance functionality.  It is assumed that as someone who has been granted commit access, you are capable of deciding whether the code should be accepted; if you are ever unsure, discuss the change on the [discussion group](http://groups.google.com/group/posit-group).

We do, however, want to maintain some standards for how changes are applied to the trunk, in order that authorship is accurate (credit where credit is due) and so that the code base remains manageable.  So, before applying changes, please make sure that the contributor has followed the guidelines with respect to small, atomic commits as listed above.

There are a few different forms that incoming source code can come in:
  * Changesets in a publicly visible repository, such as a user's clone on google code.
  * Patches generated by `hg export`.
  * Raw diffs.
Each of these can be applied in a different way, while still maintaining authorship information.

### Public Repository ###

Changes can be transplanted directly from the repository to the relevant branch.  In your local clone, do the following:
```
hg update -C
hg transplant -s REPO_URL REV1|REV2:REVN [REV3] [REV4]...
hg push
```
This will ensure that you are on the tip of the current branch (probably you should check that you are currently on the right branch), discarding any local changes, transplant the selected revisions (a list of revisions based on local revision numbers for the source repository; REVX:REVY will select a range of revisions), and push the changes from your local clone to its parent repository.

### Exported Patch ###

These changes can be applied by the `hg import` command, maintaining commit log and authorship information from the contributor.
```
hg update -C
hg import PATCH_FILENAME
hg push
```

### Raw diff ###

These changes must be applied and committed manually.  After using your favorite patching tool to apply the patch to the tip of the default branch, do the following:
```
hg commit -u 'FIRSTNAME LASTNAME <email@address.com>'
```
You will need to enter the commit log entry, but the resulting changeset will appear in the log as from the user specified.