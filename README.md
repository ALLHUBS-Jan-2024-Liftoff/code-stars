# Tent Talk
Tent Talk is an application created to streamline the process of finding a place to camp. It allows users to search and review campgrounds. By providing user-submitted tags and ratings, users can feel confident in their camping destinations.


| ![React badge](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB) | ![Spring Boot badge](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) | ![MySQL badge](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white) |
|--|--|--|

## Features

 - Account creation and management
 - Persistent relational database using Spring Boot and MySQL
 - Create, view, edit, and delete reviews for campgrounds
 - Photos of campgrounds with Google Places API

## Installation and Startup
**Front End**  
Use [npm](https://nodejs.org/en/learn/getting-started/an-introduction-to-the-npm-package-manager) to install and run tenttalk-ui.

    npm install
    npm run dev


**Back End**  
Use [IntelliJ](https://www.jetbrains.com/idea/) to open tenttalk-api, and select bootRun from the Gradle pane.  
![bootRun in IntelliJ Gradle pane](https://i.ibb.co/RNptcXZ/Screenshot-2024-08-15-171850.png)

**Database**  
Use [MySQL Workbench](https://www.mysql.com/products/workbench/) to set up the database.

 1. Create a new schema called *tenttalk*
 2. Create a new account with username *tenttalk* and password *#TentTalk123*
 3. Give account all schema privileges for tenttalk

**Google Places API**  
In order to render campground photos, you'll need a Google Maps API key. 
Note: Other features will still function without a key.

 1. In Google Cloud console, navigate to the Credentials page and set application restrictions to allow requests from http://localhost:5173/*
 2.  Open tenttalk-ui\src\components\campground\CampgroundPhoto.jsx
 3. Put your API key in between the double quotes on line 4

## Contributors
- Mads Bohn -- [mads-bohn](https://github.com/mads-bohn)
- Amanda Darby -- [momijivibes](https://github.com/momijivibes)
- June Lee -- [2amkoding](https://github.com/2amkoding)
- Pierce L -- [pierceLC](https://github.com/pierceLC)


