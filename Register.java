import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class Register {

    private Connection connect() throws SQLException {
        // Adjust your database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/leybrica";
        String user = "root"; // your DB username
        String password = ""; // your DB password
        return DriverManager.getConnection(url, user, password);
    }

    public Register() {
        JFrame window = new JFrame("Leybrica | Register");
        window.setSize(500, 650);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 240, 240));

        JLabel welcomeLabel = new JLabel("Join Leybrica and Discover The Glory world of Books", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        welcomeLabel.setForeground(new Color(44, 62, 80));
        
    
        JPanel formPanel = new JPanel(new GridLayout(14, 2, 10, 10)); // 14 rows for labels + inputs
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        formPanel.setSize(500, 650);;
        formPanel.setBackground(new Color(240, 240, 240));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField phoneField = new JTextField();
        JTextField cityField = new JTextField();
        JTextField streetField = new JTextField();
        JTextField buildingField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField yearField = new JTextField();
        JTextField monthField = new JTextField();
        JTextField dayField = new JTextField();

        JLabel genderLabel = new JLabel("Gender:");
        String[] genders = {"Male", "Female", "Other"};
        JComboBox<String> genderComboBox = new JComboBox<>(genders);
      

        String[] interestsOptions = {"Literature", "History", "Romance", "Science", "Philosophy"};
        JList<String> interestsList = new JList<>(interestsOptions);
        interestsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane interestsScrollPane = new JScrollPane(interestsList);
        
        JTextField emailField = new JTextField();

        JButton registerButton = new JButton("Register");
        registerButton.setBackground(new Color(52, 73, 94));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);

        registerButton.addActionListener(e -> {
            try {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String phone = phoneField.getText();
                String city = cityField.getText();
                String street = streetField.getText();
                String building = buildingField.getText();
                String age = ageField.getText();
                String year = yearField.getText();
                String month = monthField.getText();
                String day = dayField.getText();
                
                
                ArrayList<String> selectedInterests = new ArrayList<>(interestsList.getSelectedValuesList());
                String interests = String.join(", ", selectedInterests);
               
                String email = emailField.getText();
                String gender = (String) genderComboBox.getSelectedItem();
               

                if (username.isEmpty() || password.isEmpty() || phone.isEmpty() || city.isEmpty() 
                        || street.isEmpty() || building.isEmpty() || age.isEmpty()) {
                    JOptionPane.showMessageDialog(window, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Connection con = connect();
                String sql = "INSERT INTO customer (User, Pass, Phone, City, Street, Building, Age, Year, Month, Day, Gender, Interests, Email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);

                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setString(3, phone);
                stmt.setString(4, city);
                stmt.setString(5, street);
                stmt.setString(6, building);
                stmt.setString(7, age);
                stmt.setString(8, year); 
                stmt.setString(9, month);
                stmt.setString(10, day);
                stmt.setString(11, gender);
                stmt.setString(12, interests);
                stmt.setString(13, email);

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(window, "Registration Successful!");

                stmt.close();
                con.close();
                window.dispose();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(window, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        
        formPanel.add(new JLabel("Username:"));
        formPanel.add(usernameField);

        formPanel.add(new JLabel("Password:"));
        formPanel.add(passwordField);

        formPanel.add(new JLabel("Phone Number:"));
        formPanel.add(phoneField);

        formPanel.add(new JLabel("City:"));
        formPanel.add(cityField);
        
        formPanel.add(new JLabel("Street:"));
        formPanel.add(streetField);
        
        formPanel.add(new JLabel("Building:"));
        formPanel.add(buildingField);
        
        formPanel.add(new JLabel("Age:"));
        formPanel.add(ageField);
        
        formPanel.add(new JLabel("Year:"));
        formPanel.add(yearField);
        
        formPanel.add(new JLabel("Month:"));
        formPanel.add(monthField);
        
        formPanel.add(new JLabel("Day:"));
        formPanel.add(dayField);
        
        
        formPanel.add(genderLabel);
        formPanel.add(genderComboBox);

        
        formPanel.add(new JLabel("Interests:"));
        formPanel.add(interestsScrollPane);
        
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);


        

        formPanel.add(new JLabel());
        formPanel.add(registerButton);

        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        window.add(mainPanel);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Register::new);
    }
}

