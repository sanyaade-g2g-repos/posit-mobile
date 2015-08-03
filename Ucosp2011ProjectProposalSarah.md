## Login and Registration Overhaul Project ##

_Note: The information below is intended as a proposal, open to amendment by my project mentor Ralph Morelli._


### Motivation ###

A user's first impression of an app is essential in determining whether they'll try it out long enough to decide it's right for them, and POSIT's first impression leaves much to be desired. I intend to overhaul aspects of POSIT related to login and registration, providing a smoother introduction to the app and lessening day to day annoyances in using the program.


### Implementation ###

#### [Issue #146](https://code.google.com/p/posit-mobile/issues/detail?id=#146): First week of March ####

POSIT recently removed a package that was being used to validate that usernames were valid emails on the phone (see [issue 128](https://code.google.com/p/posit-mobile/issues/detail?id=128)). This caused crashes on some users' phones when POSIT tried to use it to validate emails ([issue 146](https://code.google.com/p/posit-mobile/issues/detail?id=146)). To resolve this problem, we need to replace or remove the validation.

I suggest we remove the restriction that usernames must be email addresses. The emails are not being used for anything and, in any case, it doesn't benefit anyone to check if an email is valid without checking that it is also correct and owned by the user.

This would require me to

  * Remove username-as-email validation from the phone.
  * Determine reasonable limits to usernames. Should they be any ascii? Any unicode? Any non-whitespace? Consider input methods for android phones.
  * Change any behaviour that assumes POSIT has a user's email address. For instance, when you create a new account, POSIT sends you an email before allowing you to log in. That would break on non-email usernames.
  * Add email field.

#### User Interface fixes: Rest of March ####

  * Regularize language. Currently "register" and "log in" are used interchangeably. Instead, use "Log in" to mean log in to an existing account and "Sign up" to mean register.
  * Front page if not logged in: |Log In| |Sign Up| |Take a tour| instead of dropping you in to the tour on install.
  * Login page: Either eliminate barcode option or set up page as:
    * Layout: |username| |password| |Login| |<blank space>| |Graphic of barcode||Or, sign in using your barcode from the POSIT website|
    * |Log in| is automatically selected when you press enter in the password field, not |register with barcode|.
  * Sign up page:
    * Change "Create new account. Create an account on the POSIT server. You can also do this on the server" to "Create a new account" or "Create a new account. If you've already made one on the POSIT website, just use it to log in"
    * "Server: foo" |Change|. Change leads to a page that explains what the POSIT server is and allows you to change it. It should also have a button that resets it to default server.
  * Add "Log out" to settings menu. Already doable, see [issue 116](https://code.google.com/p/posit-mobile/issues/detail?id=116)
  * Investigate how information is stored in the phone and what will happen to that information when a user logs out. Can user information still be easily accessed when a user logs out? When we switch users, what happens to the first user's information?


#### Small bug fixes ####

There are several bugs relating to the login process that I'd like to fix along the way.

  * [Issue 63](https://code.google.com/p/posit-mobile/issues/detail?id=63) (barcode)
  * [Issue 65](https://code.google.com/p/posit-mobile/issues/detail?id=65) (barcode)
  * [Issue 117](https://code.google.com/p/posit-mobile/issues/detail?id=117) (new user)
  * [Issue 120](https://code.google.com/p/posit-mobile/issues/detail?id=120) (log in)
  * [Issue 139](https://code.google.com/p/posit-mobile/issues/detail?id=139) (change password)


#### Input Validation: if there's time ####

  * Investigate how validation is handled on the server and determine whether it is sufficient. Possibly cooperate with Jon's security project to replace validation methods on the server. See [issue 148](https://code.google.com/p/posit-mobile/issues/detail?id=148) for another validation bug.

### Deliverables ###

  1. Cleaned up snapshot of my clone at the end of the term
  1. Clear documentation of what was and was not completed in wiki form

### Proposal Changes ###

  * March 3rd, submitted proposal for review
  * March 5th, edited timeline to: fix [issue 146](https://code.google.com/p/posit-mobile/issues/detail?id=146), then UI fixes, then explore validation and sanitation fixes if there's time and it doesn't interfere with Jon VanAlten's security fixes.
  * April. It became clear that there was significant overlap between my project, Sean's UI overhaul, and Eran's settings changes. I've listed the parts of my proposal I ceded to them at Ucosp2011ProjectStatusSarah

<a href='Hidden comment:  With many thanks to Jon VanAlten and Anna Komarova for their proposals. This one is based on theirs as a templates. '></a>

# Brainstorm #
_Please feel free to leave your comments, criticisms, questions, and wishlist items for the login process here._