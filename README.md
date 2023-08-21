# Blog-Application-Back-End-
REST APIS of Blogging Application

# Project Description: 

 ➤ This Blog Application (Backend) project enables the user to post blogs, comment on any blog and delete any post or comment.<br />
 ➤ The Project properties are divided into 2 parts i.e. "application-prod.properties" and "application-dev.properties"
 ➤ The developer can change the profile type of the application accordingly: For Development - dev, For Production - prod
 ➤ By default the "dev" profile is active in the main "application.properties" file
 ➤ Any user can have any number of roles like ADMIN or NORMAL user.<br />
 ➤ All the apis are secured only the GET apis are public.<br />
 ➤ The user first have to register, then only the user is able to access the functions of the application.<br />

This applcation is hosted on AWS platform, to check the real time working of the project: 
http://blogapp-env.eba-y3mjn6bi.ap-south-1.elasticbeanstalk.com/swagger-ui/index.html

# Technologies Used:

1. Java
2. Spring Boot
3. JWT
4. Spring Data JPA (Hibernate)
5. MySQL
6. AWS

# How to run:

1. Clone the repo in your system or download a zip file of the code.
2. Open the folder in Spring Boot or IntelliJ IDEA.
3. Setup the MySQL Database before running the application.
4. Set name of Schema as :
5. To run the code, right click on the Blog-Application-Back-End folder in your IDE and go to "Run as" and click on Spring Boot App.
6. It will start running and you can see the console for more information.
7. Go to http://localhost:9090/swagger-ui/index.html
