import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public Login() {
        JFrame window = new JFrame("Leybrica | Login");
        window.setSize(350, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(new Color(240, 240, 240));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField username = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField password = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        loginButton.setBackground(new Color(52, 73, 94));
        loginButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(52, 73, 94));
        registerButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);

        registerButton.addActionListener((e) -> {
            new Register();
        });
        
        loginButton.addActionListener((e) -> {
           try{
           String sql = "Select * from customer where User = ? and Pass = ?";
           PreparedStatement info = DBConnection.connect().prepareStatement(sql);
           info.setString(1,username.getText());
           info.setString(2,new String(password.getPassword()));
           
           ResultSet result = info.executeQuery();
           
           if(result.next()){
               String user = result.getString(1);
               window.dispose();
               Browsing.main(null);
           }
           
           else {
               System.out.println("Wrong username / password");
           }
               
               
           
           } 
           
           catch (SQLException ex){
           System.out.println(ex.getMessage());
           
           }
            
            
        });

        panel.add(usernameLabel);
        panel.add(username);
        panel.add(passwordLabel);
        panel.add(password);
        panel.add(registerButton);
        panel.add(loginButton);

        window.add(panel);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}

