# CPRG352 Final Project
*Bryan Meyer*

## Introduction

This is my submission for the SAIT Web Application Development final project. The assignment is to build a fully-functional inventory management web application from scratch using Java. The application will be built using an MVC architecture coupled with a MySQL database. See the [assignment doc](/Project.docx) for more information.

## Functionality

The core functionality of the app includes:
- Authentication
- Registration
- User account management
- Inventory management
- Management of accounts by admins
- Management of categories by admins

The app also has some additional functionality:
- Upon registration, users receive an email with a link they need to follow to activate their account before they can sign in
- Upon activating their account, users receive a welcome email
- All user passwords are stored hashed and salted using SHA-512 hashing
- Users can request a password reset which sends an email with a link to follow 

## Technologies

The app was built using the following technologies:

- Netbeans 12
- Tomcat 8
- Maven
- Java
- JPA
- MariaDB
- JSTL
- Bootstrap

## Running the app

To run the app as is, download it to your local machine and run the sql file found in the database package within your local MariaDB client. Add your own email and password to the web.xml. Open the project and run it from Netbeans.

## References

- All of the styling in the app is courtesy of [Bootstrap](https://getbootstrap.com/). Some small sections of the app (such as the navbar and sign in page) were adapted from Bootstrap examples, but the majority of the user interface was built from scratch with only the styling provided by Bootstrap.
- The use of the SHA-512 algorithm to hash passwords was taken from [JavaGuides](https://www.javaguides.net/2020/02/java-sha-256-hash-with-salt-example.html) and [Baeldung](https://www.baeldung.com/java-password-hashing). Converting byte arrays to and from base64 was taken from [Mkyong](https://mkyong.com/java/how-do-convert-byte-array-to-string-in-java/).