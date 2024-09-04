Train Ticket Booking System
Overview
The Train Ticket Booking System is a Java-based GUI application designed to simulate the booking of train tickets. It allows users to select ticket types, input personal details, choose pickup and destination points, and displays ticket details along with pricing information.

Features
Ticket Types: Users can choose between First Class and Second Class tickets.
Personal Details: Collects passenger name, mobile number, and age.
City Selection: Provides a list of cities for selecting pickup and destination points.
Price Calculation: Computes ticket prices based on selected cities and ticket types.
Error Handling: Validates input fields and displays error messages if necessary.
Ticket Details: Shows ticket details in a new window after booking, including ticket number and price.
GUI Components
JComboBox: For selecting ticket types, pickup points, and destination points.
JTextField: For entering passenger name, mobile number, and age.
JTextArea: Displays error messages and ticket details.
JButton: For booking tickets.
JLabel: Displays static text and images (e.g., train image, bus animation).
Prerequisites
Java Development Kit (JDK): Make sure you have JDK 8 or later installed on your machine.
Setup and Installation
Clone the Repository:

bash
Copy code
git clone https://github.com/yourusername/TrainTicketBookingSystem.git
Navigate to the Project Directory:

bash
Copy code
cd TrainTicketBookingSystem
Compile the Code:

bash
Copy code
javac TrainTicketBookingSystem.java
Run the Application:

bash
Copy code
java TrainTicketBookingSystem
Usage
Select Ticket Type: Choose between "First Class" and "Second Class" from the dropdown.
Enter Passenger Details: Provide the passenger's name, mobile number, and age.
Choose Cities: Select pickup and destination cities from the dropdown lists.
Book Ticket: Click the "Book Ticket" button to process the booking.
View Ticket Details: A new window will display the ticket details, including the ticket number and price.
Images
Include any relevant images such as screenshots or application icons. For example:

Train Image: train.png (Used in the main window)
Bus Animation: bus_animation.gif (Displayed in the ticket details window)
Error Handling
Missing Details: Prompts the user to fill in all required fields.
Invalid Age: Ensures that the age is a positive number.
Invalid Mobile Number: Validates that the mobile number is a 10-digit number.
Same Pickup and Destination: Checks that pickup and destination cities are different.
License
This project is licensed under the MIT License - see the LICENSE file for details.

Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your changes.
