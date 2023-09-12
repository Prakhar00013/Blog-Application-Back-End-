# Blog-Application-Back-End-
REST APIS of Blogging Application

# Project Description: 

 ➤ This Blog Application (Backend) project enables the user to post blogs, comment on any blog and delete any post or comment.<br />
 ➤ The Project properties are divided into 2 parts i.e. "application-prod.properties" and "application-dev.properties"<br />
 ➤ The developer can change the profile type of the application accordingly: For Development - dev, For Production - prod.<br />
 ➤ By default the "dev" profile is active in the main "application.properties" file.<br />
 ➤ Any user can have any number of roles like ADMIN or NORMAL user.<br />
 ➤ All the apis are secured only the GET apis are public.<br />
 ➤ The user first have to register, then only the user is able to access the functions of the application.<br />

# Technologies Used:

1. Java
2. Spring Boot
3. JWT
4. Spring Data JPA (Hibernate)
5. MySQL
6. AWS
7. Postman
8. Swagger

# How to run:

1. Clone the repo in your system or download a zip file of the code.
2. Open the folder in Spring Boot or IntelliJ IDEA.
3. Setup the MySQL Database before running the application.
4. Create a Schema: blog_app_apis, username: root and password: root
5. The required table and columns will be automaticcally created at the initial run of the application.
6. To run the code, right click on the Blog-Application-Back-End folder in your IDE and go to "Run as" and click on Spring Boot App.
7. It will start running and you can see the console for more information.
8. Go to http://localhost:9090/swagger-ui/index.html
9. You can check and run the apis in the Postman Software also.

# ER - Diagram of the Blogging Application:

![Screenshot_1](https://github.com/Prakhar00013/Blog-Application-Back-End-/assets/89144627/4bc335cb-8ee8-426b-937d-a7fb1cc4f653)

# Swagger Screenshot: 

![Screenshot_2](https://github.com/Prakhar00013/Blog-Application-Back-End-/assets/89144627/69dac38e-4eb9-424d-a871-0da532d3fd16)
