/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.regestrationsampleapp;

/**
 *
 * @author youse
 */
public class Regestrationsampleapp {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Register extends JFrame implements ActionListener {

    private JTextField txtUsername, txtFullname, txtMobile, txtEmail;
    private JPasswordField txtPassword;
    private JButton btnRegister, btnCancel;

    public Register() {
        setTitle("User Registration");
        setSize(420, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Outer panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Title
        JLabel title = new JLabel("Register New Account");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(new Color(33, 150, 243));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        mainPanel.add(title);

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        formPanel.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        formPanel.add(txtUsername);

        formPanel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        formPanel.add(txtPassword);

        formPanel.add(new JLabel("Full Name:"));
        txtFullname = new JTextField();
        formPanel.add(txtFullname);

        formPanel.add(new JLabel("Mobile:"));
        txtMobile = new JTextField();
        formPanel.add(txtMobile);

        formPanel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        formPanel.add(txtEmail);

        mainPanel.add(formPanel);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        btnRegister = new JButton("Register");
        btnCancel = new JButton("Cancel");

        btnRegister.setBackground(new Color(76, 175, 80));
        btnRegister.setForeground(Color.WHITE);

        btnCancel.setBackground(new Color(244, 67, 54));
        btnCancel.setForeground(Color.WHITE);

        btnRegister.addActionListener(this);
        btnCancel.addActionListener(this);

        buttonPanel.add(btnRegister);
        buttonPanel.add(btnCancel);

        mainPanel.add(buttonPanel);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            String userInfo = String.format(
                "Username: %s\nPassword: %s\nFull Name: %s\nMobile: %s\nEmail: %s",
                txtUsername.getText(),
                new String(txtPassword.getPassword()),
                txtFullname.getText(),
                txtMobile.getText(),
                txtEmail.getText()
            );
            JOptionPane.showMessageDialog(this, "✅ Registration Successful!\n\n" + userInfo);
        } else if (e.getSource() == btnCancel) {
            // Clear all fields instead of closing
            txtUsername.setText("");
            txtPassword.setText("");
            txtFullname.setText("");
            txtMobile.setText("");
            txtEmail.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Register());
    }
}
