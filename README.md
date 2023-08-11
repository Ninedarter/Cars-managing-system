# Car Management System - Backend

Welcome to the backend repository of the Car Management System. This repository focuses on the backend implementation, providing the core functionality to manage cars, track expenses, and handle user interactions. The backend is built using Java and Spring Boot, leveraging an H2 in-memory database for data storage.This project backend part was developed using IntelliJ IDEA

## Frontend Repository

For the frontend part of the Car Management System, please visit separate repository:

\https://github.com/Ninedarter/Cars-managing-system-frontend

The frontend repository contains the user interface, enabling users to interact with the Car Management System. It's built using Angular.

# Description
The Car Management System is a Java application designed to help users efficiently manage their cars, track expenses, and stay organized with essential vehicle information. Whether you're a car enthusiast or simply want to keep tabs on your vehicles, this application has you covered. This is only backend, you also need to clone and run this repository Here's what you can do with the Car Management System:

# Features
- User Registration: Create a personalized account to access the system, ensuring privacy and security.

- Car Registration: Easily add new cars to the system, providing crucial details like make, model, year, and initial mileage.

- Expense Tracking: Keep a comprehensive record of expenses related to your vehicles, including maintenance costs and fuel expenditures. Stay on top of your budget and identify areas for optimization.

- Monthly Expense Charts: Visualize your car expenses with interactive charts that display monthly spending patterns. This feature helps you better understand your financial outlays.

- Car Information Updates: Update essential car information such as mileage, technical expiration dates, and insurance dates. Maintain accurate records for your vehicles.


#  Getting Started
To get started with the Car Management System, follow these steps:

1.Clone the Repository: Clone this repository to your local machine using git clone.
2.Configure H2 database: you can change port, username, password in application.propierties in the project file if needed. 
After running the program you can access H2 in memory databe with link :
http://localhost:8082/h2-console

    - On the H2 console login page, use the following details to log in 
        (if no previous changes was made use default username and password)
    - JDBC URL: `jdbc:h2:mem:testdb`
    - Username: `sa`
    - Password: `sa`

3.Build and Run: Compile the Java application and launch it.

4.Register a User : Create your user account within the application.
There is sample user with login  details :  
 email: john@mail.com
 password: john123

5.Add Cars: Start adding your vehicles to the system, providing all the required information.

6.Track Expenses: Log maintenance and fuel expenses for each car, enabling accurate expense monitoring.

7.View Charts: Explore the monthly expense charts to gain insights into your spending habits.

8.Update Car Info: Periodically update car information as mileage, technical and insurance expiration dates to reflect the latest details accurately.
