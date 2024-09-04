// package TrainTicketBookingSystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

// Abstract class representing a generic Ticket

class MissingDetailsException extends Exception {
    public MissingDetailsException(String message) {
        super(message);
    }
}

abstract class Ticket {
    private String passengerName;

    // Constructor
    public Ticket(String passengerName) {
        this.passengerName = passengerName;
    }

    // Abstract method to be implemented by subclasses
    public abstract String getTicketType();

    // Getter methods
    public String getPassengerName() {
        return passengerName;
    }
}

// Subclass representing FirstClassTicket
class FirstClassTicket extends Ticket {
    public FirstClassTicket(String passengerName) {
        super(passengerName); // Calls the constructor of the superclass (Ticket)
    }

    @Override
    public String getTicketType() {
        return "First Class";
    }
}

// Subclass representing SecondClassTicket
class SecondClassTicket extends Ticket {
    public SecondClassTicket(String passengerName) {
        super(passengerName);
    }

    @Override
    public String getTicketType() {
        return "Second Class";
    }
}

// GUI class
public class TrainTicketBookingSystem extends JFrame implements ActionListener {
    private JComboBox<String> ticketTypeComboBox;
    private JTextField passengerNameField, mobileNumberField, ageField;
    private JTextArea displayArea;
    private JComboBox<String> pickupComboBox, destinationComboBox; // Member variables
    private Map<String, Integer> cityPrices;

    public TrainTicketBookingSystem() {
        setTitle("IRCTC Train Ticket Booking System");
        setSize(400, 550); // Increased the height to accommodate new fields and image
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Image
        ImageIcon trainImage = new ImageIcon(getClass().getResource("D:\\Akshay\\coding-JAVA\\train.png"));
        JLabel imageLabel = new JLabel(trainImage);
        int imgWidth = trainImage.getIconWidth();
        int imgHeight = trainImage.getIconHeight();
        int x = (400 - imgWidth) / 2; // Calculate the x-coordinate for centering
        int y = 10; // Position the image at the top
        imageLabel.setBounds(x, y, imgWidth, imgHeight);
        add(imageLabel);

        JLabel ticketTypeLabel = new JLabel("Ticket Type:");
        ticketTypeLabel.setBounds(20, y + imgHeight + 10, 100, 20);

        String[] ticketTypes = { "First Class", "Second Class" };
        ticketTypeComboBox = new JComboBox<>(ticketTypes);
        ticketTypeComboBox.setBounds(120, y + imgHeight + 10, 150, 20);

        // Passenger Name
        JLabel passengerNameLabel = new JLabel("Passenger Name:");
        passengerNameLabel.setBounds(20, y + imgHeight + 50, 100, 20);

        passengerNameField = new JTextField();
        passengerNameField.setBounds(120, y + imgHeight + 50, 150, 20);

        // List of cities for pickup and destination
        String[] cities = { "Ahmedabad", "Vadodara", "Kutch", "Morbi", "Rajkot" };

        // Create JComboBox for selecting pickup point
        JLabel pickupLabel = new JLabel("Pickup Point:");
        pickupLabel.setBounds(20, y + imgHeight + 90, 100, 20);

        pickupComboBox = new JComboBox<>(cities); // Using member variable
        pickupComboBox.setBounds(120, y + imgHeight + 90, 150, 20);

        // Create JComboBox for selecting destination
        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(20, y + imgHeight + 130, 100, 20);

        destinationComboBox = new JComboBox<>(cities); // Using member variable
        destinationComboBox.setBounds(120, y + imgHeight + 130, 150, 20);

        // Mobile Number
        // Jlabel is used to display text
        JLabel mobileNumberLabel = new JLabel("Mobile Number:");
        mobileNumberLabel.setBounds(20, y + imgHeight + 170, 100, 20);

        mobileNumberField = new JTextField();
        mobileNumberField.setBounds(120, y + imgHeight + 170, 150, 20);

        // Age
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(20, y + imgHeight + 210, 100, 20);

        ageField = new JTextField();
        ageField.setBounds(120, y + imgHeight + 210, 150, 20);

        // Book Ticket Button
        JButton bookTicketButton = new JButton("Book Ticket");
        bookTicketButton.setBounds(120, y + imgHeight + 250, 150, 30);
        bookTicketButton.addActionListener(this);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setBounds(20, y + imgHeight + 290, 350, 100);

        cityPrices = new HashMap<>();
        cityPrices.put("Ahmedabad-Kutch", 850);
        cityPrices.put("Kutch-Ahmedabad", 850);
        cityPrices.put("Ahmedabad-Vadodara", 550);
        cityPrices.put("Vadodara-Ahmedabad", 550);
        cityPrices.put("Ahmedabad-Morbi", 900);
        cityPrices.put("Morbi-Ahmedabad", 900);
        cityPrices.put("Kutch-Rajkot", 750);
        cityPrices.put("Rajkot-Kutch", 750);
        cityPrices.put("Kutch-Morbi", 600);
        cityPrices.put("Morbi-Kutch", 600);
        cityPrices.put("Morbi-Rajkot", 200);
        cityPrices.put("Rajkot-Morbi", 200);

        // Add components to the frame
        add(ticketTypeLabel);
        add(ticketTypeComboBox);
        add(passengerNameLabel);
        add(passengerNameField);
        add(pickupLabel);
        add(pickupComboBox);
        add(destinationLabel);
        add(destinationComboBox);
        add(mobileNumberLabel);
        add(mobileNumberField);
        add(ageLabel);
        add(ageField);
        add(bookTicketButton);
        add(displayArea);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ticketType = (String) ticketTypeComboBox.getSelectedItem();
        String passengerName = passengerNameField.getText();
        String mobileNumber = mobileNumberField.getText();
        int age = Integer.parseInt(ageField.getText());
        String pickupCity = (String) pickupComboBox.getSelectedItem();
        String destinationCity = (String) destinationComboBox.getSelectedItem();
        String ageText = ageField.getText();
        // EXCEPTION HANDLING
        // Try to parse the age and handle exceptions

        if (passengerName.isEmpty() || mobileNumber.isEmpty() || ageText.isEmpty()) {
            displayErrorMessage("Please fill in all the required details");
            return;
        }

        try {
            age = Integer.parseInt(ageField.getText());
            if (age <= 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
        } catch (IllegalArgumentException ex) {
            displayErrorMessage("Invalid Age: " + ex.getMessage());
            return;
        }

        // Try to validate the phone number and handle exceptions
        try {
            if (mobileNumber.length() != 10 || !mobileNumber.matches("\\d+")) {
                throw new IllegalArgumentException("Mobile number should be a 10-digit number");
            }
        } catch (IllegalArgumentException ex) {
            displayErrorMessage("Invalid Mobile Number: " + ex.getMessage());
            return;
        }

        // exception in the same pickup and destination point
        if (pickupCity.equals(destinationCity)) {
            displayErrorMessage("Pickup and Destination cities cannot be the same");
            return;
        }

        Ticket ticket;
        if (ticketType.equals("First Class")) {
            ticket = new FirstClassTicket(passengerName);
        } else {
            ticket = new SecondClassTicket(passengerName);
        }

        int ticketPrice = cityPrices.get(pickupCity + "-" + destinationCity);
        if (ticketType.equals("First Class")) {
            ticketPrice += 300;
        }
        // Open a new window to display the ticket details
        displayTicketDetails(ticket, mobileNumber, age, pickupCity, destinationCity, ticketPrice);
    }

    // Helper method to display an error message in the display area
    private void displayErrorMessage(String message) {
        displayArea.setText(message);
    }


    private void displayTicketDetails(Ticket ticket, String mobileNumber, int age, String pickupCity,
            String destinationCity, int ticketPrice) {
        JFrame detailsFrame = new JFrame("Ticket Details");
        detailsFrame.setSize(500, 500);

        int ticketNumber = new Random().nextInt(100) + 1;

        JLabel busLabel = new JLabel(new ImageIcon(getClass().getResource("bus_animation.gif")));
        busLabel.setBounds(180, 10, 128, 96); // Adjust the position and size as needed

        JTextArea detailsTextArea = new JTextArea();
        detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        detailsTextArea.setText("Ticket booked:\n" +
                "Passenger Name: " + ticket.getPassengerName() + "\n" +
                "Mobile Number: " + mobileNumber + "\n" +
                "Age: " + age + "\n" +
                "Ticket Type: " + ticket.getTicketType() + "\n" +
                "Pickup City: " + pickupCity + "\n" +
                "Destination City: " + destinationCity + "\n" +
                "Ticket Number: " + ticketNumber + "\n" +
                "Ticket Price: " + ticketPrice);

        detailsTextArea.setEditable(false);

        // Set the background color here
        // detailsTextArea.setBackground(Color.gray); // You can change this color to your preferred one
        detailsTextArea.setBackground(new Color(240, 240, 240)); // Light gray background

        if (ticketPrice > 800) {
            detailsTextArea.setForeground(Color.RED); // Set font color to red for high-priced tickets
        } else {
            detailsTextArea.setForeground(Color.BLACK); // Set font color to black for other tickets
        }

        detailsFrame.add(detailsTextArea);
        detailsFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new TrainTicketBookingSystem();
    }
}
