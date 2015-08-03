# Log In Overhaul: Project Status #

### Overview ###

This semester, I implemented a log out feature and many smaller bug fix and cleanup projects. I decided not to pursue some of my planned user interface changes because they would have interfered with Sean and Eran's projects, but I did make many small UI changes that add up to a much smoother login procedure. I also tried to test and fix as many phone-side (not server-side) bugs as I could. I spent the beginning of the semester doing a very thorough code cleaning and refactoring campaign, and I think those changes helped to make POSIT a much easier project to develop for by eliminating unused classes and methods.

### Bugs and ticketable changes ###

| **Issue** | **Status** |
|:----------|:-----------|
| [issue 146](https://code.google.com/p/posit-mobile/issues/detail?id=146) | Done, committed to ucosp-ram |
| [issue 128](https://code.google.com/p/posit-mobile/issues/detail?id=128) | Done, committed to ucosp-ram |
| [issue 63](https://code.google.com/p/posit-mobile/issues/detail?id=63) | Blocked on [issue 153](https://code.google.com/p/posit-mobile/issues/detail?id=153) |
| [issue 65](https://code.google.com/p/posit-mobile/issues/detail?id=65) | Blocked on [issue 153](https://code.google.com/p/posit-mobile/issues/detail?id=153) |
| [issue 117](https://code.google.com/p/posit-mobile/issues/detail?id=117) | Done, pending Ralph review |
| [issue 120](https://code.google.com/p/posit-mobile/issues/detail?id=120) | Done, committed to ucosp-ram |
| [issue 139](https://code.google.com/p/posit-mobile/issues/detail?id=139) | Wont-fix, per Ralph's comment |
| [issue 62](https://code.google.com/p/posit-mobile/issues/detail?id=62) | Done, pending Ralph review |
| [issue 116](https://code.google.com/p/posit-mobile/issues/detail?id=116) | Done, pending Ralph review |
| [issue 149](https://code.google.com/p/posit-mobile/issues/detail?id=149) | Done, pending Ralph review |
| [issue 114](https://code.google.com/p/posit-mobile/issues/detail?id=114) | Done, pending Ralph review |

### [Issue #146](https://code.google.com/p/posit-mobile/issues/detail?id=#146): Email validation ###

I left server changes to another the security rehaul project.

Instead, I simply removed email validation from the phone and allowed the server to conduct email validation of its own.

### UI Changes ###

| **Planned UI change** | **Status** |
|:----------------------|:-----------|
| Regularize language.  | Done, see issues above. |
| Front page if not logged in: |Log In| |Sign Up| |Take a tour| instead of dropping you in to the tour on install. | Skipped in favour of Sean's UI proposal. |
| Log in page changes   | Fixed wording, skipped button changes in favour of to Sean's UI proposal. |
| Sign in wording changes | Changed to "Create a new account on your POSIT server. You can also do this on your server's website" |
| Sign in server pick change | Skipped in favour of Eran's server pick changes |
| Add log out           | Done, see issues above |

### Other ###

I had hoped to have extra time to work on input validation, but I didn't make any changes there.

I wound up doing a huge amount of code cleanup in the first half of the semester, POSIT is a much smaller and less confusing app now.

## Deliverables ##

  1. This page describing what I accomplished for UCOSP 2011.
  1. My project branch at https://sarahestrong-ucosp-w11.googlecode.com/hg/
  1. To get a snapshot of my branch at the time the assignment was due, run 'hg clone -r 82dcbd03571e https://sarahestrong-ucosp-w11.googlecode.com/hg/'