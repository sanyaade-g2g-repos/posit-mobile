**Download Positweb**

[http://code.google.com/p/posit-mobile/source/checkout?repo=web](http://code.google.com/p/posit-mobile/source/checkout?repo=web)

**Install and Configure Apache, MySQL, PHP**
```
> sudo apt-get install apache2-mpm-prefork
> sudo apt-get install mysql-server mysql-client
> sudo apt-get install libapache2-mod-php5 php5-mysql

> sudo a2enmod userdir
> sudo a2enmod rewrite
```

Edit the file to allow overrides in an .htaccess file:
```
> sudo gedit /etc/apache2/mods-enabled/userdir.conf

#  AllowOverride FileInfo AuthConfig Limit Indexes
   AllowOverride All
```

Edit the file to allow php to read in user directory:
```
> sudo gedit /etc/apache2/mods-available/php5.conf

    # To re-enable php in user directories comment the following lines
    # (from <IfModule ...> to </IfModule>.) Do NOT set it to On as it
    # prevents .htaccess files from disabling it.
#    <IfModule mod_userdir.c>
#        <Directory /home/*/public_html>
#            php_admin_value engine Off
#        </Directory>
#    </IfModule>
```

Restart Apache
```
> sudo /etc/init.d/apache2 restart 
```

**Create public\_html in your home directory.**
```
> cd
> mkdir public_html
```

Create a shortcut to your working positweb folder inside the public\_html
```
> cd ~/public_html
> ln -s ~/<PATH TO POSITWEB>/positweb .
```

**Setup database from commandline:**
```
> mysql -uroot -p

mysql> create database positweb;
mysql> grant all privileges on positweb.* to positweb@localhost identified by 'positweb';
mysql> exit
```

Import the database from positweb/setup
```
> mysql -upositweb -p positweb < positweb.sql
```
This is what the command does:
  * specifies username = positweb
  * asks for password
  * uses database positweb
  * pipes the sql script into the mysql command prompt

**Edit the config.php file under the positweb folder**

It should look something like this:
```
// base uri of server instance
define(SERVER_BASE_URI, "http://192.168.1.105/positweb2");
// database hostname
define("DB_HOST", "localhost");
// database username
define("DB_USER", "posit");
// database password
define("DB_PASS", "");
// database name
define("DB_NAME", "posit_august2010");
```

Change it to match your settings.
```
// base uri of server instance
define(SERVER_BASE_URI, "http://localhost/~<YOUR_USER>/positweb");
// database hostname
define("DB_HOST", "localhost");
// database username
define("DB_USER", "positweb");
// database password
define("DB_PASS", "positweb");
// database name
define("DB_NAME", "positweb");
```

There may be other settings you need to change, like the google api key.

**Create the logs directory under positweb if it doesn't exist**
```
> mkdir logs
> cd logs
> touch log.txt
> cd ..
> chmod -R 777 logs/
```

**Create the cache directory under positweb if it doesn't exist**
```
> mkdir cache
> cd cache
> mkdir compile
> cd ..
> chmod -R 777 cache/
```

**It should now work:**
```
http://localhost/~<YOUR_USER>/positweb
```