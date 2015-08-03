# Attendees #

Edward, Jon, Eran, Stas, Sarah, Ralph


# Summary #

(I wasn't taking notes during the meeting, so others should feel free to add to this summary.)

Ralph reported that he will be submitting a mid-term progress report to the UCOSP faculty.

Eran volunteered to post a blog entry on the group's progress over the past few weeks. Time is flying by!

Jon provided an overview of the [Android SyncAdapter](http://developer.android.com/resources/samples/SampleSyncAdapter/index.html) which can be used to help an application synchronize data with a cloud service.  It uses an account manager which could be used to share credentials. The API provides a [AbstractAccountAuthenticator](http://developer.android.com/reference/android/accounts/AbstractAccountAuthenticator.html) class to support this.  It also provides the [AbstractThreadedSyncAdapter](http://developer.android.com/reference/android/content/AbstractThreadedSyncAdapter.html) class to support the data transfer.  The latter looks promising as a basis for a refactoring of POSIT's SyncActivity.  The former looks relevant for POSIT's registration process.  Perhaps Sarah, who wasn't present for this part of the meeting, should take a look at this in relation to her work on the POSIT's registration process??

We also discussed the POSIT 0.72 (?) release.  Jon will managed this by going back to the 0.70 beta release tag on the main trunk and identifying bug fixes and minor enhancements.  The release will not include new features not already present in 0.70.

Ralph added Jon and Edward as committers and the three of them will work as a subgroup on getting this release put together, with Jon taking the lead.

Sarah discussed the bug fix she submitted -- see [Issue 147](http://code.google.com/p/posit-mobile/issues/detail?id=146&colspec=ID%20Date%20Type%20Status%20Priority%20Difficulty%20Owner%20Summary). There was a lively discussion of this issue and the degree to which email address validation should occur on the client.  It was noted that email addresses are used only as unique account names.  Sarah agreed to look further into this as part of her work on POSIT's registration project.  It was agreed that the POSIT server should shoulder much of the validation process to avoid corruption of the database and that the client should avoid getting too loaded up with libraries to support this kind of validation.

Eran reported that he has looked at Greg's code from last semester and is moving ahead to develop a sorting and searching feature for the List Finds activity.


Stas reported that he has looked at the adhoc configuration issue for different devices but couldn't not find the needed information for his phones (NexusOne and Samsung??) A wide ranging discussion ensued about how POSIT's ad-hoc feature could be revised to handle the fact that it is very difficult to configure such a feature for such a heterogeneous set of devices.  One idea was designing a protocol that would have some phones serves as hotspots and others as clients to operate a manet in a wilderness area.

Ralph is traveling next week so the next Skype conference is in two weeks, on the March 16.