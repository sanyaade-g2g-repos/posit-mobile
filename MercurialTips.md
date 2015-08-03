# Mercurial #

[Mercurial By Example (PDF)](http://jemander.se/MercurialByExample.pdf) is a good introductory resource.

### Extensions ###
  * `hg help extensions` shows all extensions installed on your system and whether they are enabled or not; and tells how to enable them.
  * **hgk** (`hg view` to use; GUI revision graph; (silently) requires package tk to be installed on machine)
  * **fetch** (`hg fetch` to use; pull, update and merge in one command)
  * color (colorize output from some commands)
  * graphlog (`hg glog` to use; ASCII-art revision graph; )
  * pager (pipes output through (eg.) less)
  * progress (shows progress bar for some operations)
  * win32text (perform automatic newline conversion)
  * **hgext.extdiff** (use external diff tool) then add **`[extdiff]`** section to .hgrc, with content `cmd.kdiff3 =`

  * **External Merge Tool**: add **`[merge-tools]`** section to .hgrc, with content `kdiff3.args = $base $local $other -o $output`


### Submitting Patches ###
When you have a changeset ready to submit for review and inclusion in the mainline POSIT codebase:
  * In Eclipse, in the Package Explorer pane on the left of the screen (in the Java Perspective), right-click on the Project or the individual file, as appropriate. Doing this on a file will allow you to select multiple changed files (but won't force you to take every file that has changed); a single file will generate a patch for only that file.
  * Select Team -> Commit
  * Enter changeset description, select desired files, etc.; click OK
  * That will commit the changeset to your own local Mecurial repository.
  * And that is all that we have been able to figure out how to do from within Eclipse itself so far (2010-10-03).
  * Next, open a command-line shell terminal, and cd into any directory within your local Mecurial repository.
  * Enter the command: `hg outgoing` (or `hg out`, for short)
  * That will give you a list of the changesets that have been committed to your local repository but not to the central one.
  * The first line of output for each changeset has this format:
> > changeset: `<local-changeset-number>`:`<globally-unique-changeset-hash>`
  * Use that local changeset number together with the "hg export" command to generate a patch. e.g.
|command|changesets for which a patch will be generated|
|:------|:---------------------------------------------|
|hg export 211|211                                           |
|hg export 211:213|211-213                                       |
|hg export 211:|211 and up                                    |

  * The patch that gets generated will be sent to standard-out (i.e. the screen), so redirect it to a file. e.g.<br><code>hg export 211 &gt; descriptive-filename.diff</code>
<ul><li>Open your web-browser, go to<br><code>http://code.google.com/p/posit-mobile/issues/list</code><br> and login<br>
</li><li>Select the issue that your patch applies to<br>
</li><li>Click on the "Add a comment below" link on the left of the page, and then scroll down, fill in the comment textbox about your changes, and attach the file. (Note that there seems to be an arguable GUI bug on the page, in that the option to attach a file does not appear below the comment textbox if you just scroll down without first clicking on the comment link on the left.)<br>
</li><li>Your patch will be reviewed and possibly committed to the central Mecurial repository</li></ul>

NOTES:<br>
<ul><li>The difference between generating a patch through Mercurial and any other diff utility is that the former includes version-control metadata. This is the preferred way to submit patches.</li></ul>


<h3>Other tips</h3>
<ul><li><a href='http://hgbook.red-bean.com/read/a-tour-of-mercurial-the-basics.html'>Mercurial: The Definitive Guide</a> suggests this:<br>
<code>it's often good practice to keep a “pristine” copy of a remote repository around, which you can then make temporary clones of to create sandboxes for each task you want to work on. This lets you work on multiple tasks in parallel, each isolated from the others until it's complete and you're ready to integrate it back. Because local clones are so cheap, there's almost no overhead to cloning and destroying repositories whenever you want.</code></li></ul>

<ul><li><a href='http://blogs.sun.com/tor/entry/mercurial_tip_checking_in_regularly'>Here</a> is an alternate idea on how to keep separate stuff that is "in progress" in your working directory from stuff that is ready to push upstream.