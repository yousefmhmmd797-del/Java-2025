
import java.awt.*;
import javax.swing.*;

public class Browsing {

    public static void main(String[] args) {
        // Window setup
        JFrame frame = new JFrame("LIBRECA");
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // FirstPanel
        JPanel firstPanel = new JPanel();
        firstPanel.setBackground(Color.decode("#399FA4"));
        firstPanel.setPreferredSize(new Dimension(100, 70));
        firstPanel.setLayout(new GridBagLayout());
        frame.add(firstPanel, BorderLayout.NORTH);

        //SecondPanel
        JPanel secondPanel = new JPanel();
        secondPanel.setBackground(Color.white);
        secondPanel.setPreferredSize(new Dimension(50, 50));
        frame.add(secondPanel, BorderLayout.CENTER);

        
        //ThirdPanel
        JPanel thirdPanel = new JPanel();
        thirdPanel.setPreferredSize(new Dimension(320, 320));
        thirdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        thirdPanel.setBorder(BorderFactory.createEmptyBorder(70, 30, 30, 30));
        frame.add(thirdPanel, BorderLayout.SOUTH);

        // Labels
        JLabel name = new JLabel("LIBRECA");
        name.setFont(new Font("American Script", Font.BOLD, 40));
        firstPanel.add(name);

        JLabel mainText = new JLabel("Let your adventure begin here");
        mainText.setFont(new Font("American Script", Font.ITALIC, 20));
        secondPanel.add(mainText);

        // Text Field
        JTextField nameField = new JTextField(30);
        thirdPanel.add(nameField);

        // "Out of Stock" Dialog
        JDialog d1 = new JDialog(frame, "Out of stock", false);
        d1.setSize(400, 400);
        d1.setLocationRelativeTo(frame);
        d1.setLayout(new FlowLayout());

        JLabel messageLabel = new JLabel("<html><p style='text-align:center;'><br><br>We sincerely apologize for the inconvenience,<br>"
                + "but the book you are looking for <br> is currently unavailable in our Libreca.<br></p></html>");
        d1.add(messageLabel);

        JCheckBox checkBox = new JCheckBox("Notify me when available");
        d1.add(checkBox);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> d1.setVisible(false));
        d1.add(closeButton);

        // Search Button
        JButton SearchButton = new JButton("Search");
        thirdPanel.add(SearchButton);

        // ActionListener - Checks book availability
        SearchButton.addActionListener(e -> {
            String bookName = nameField.getText().trim();
            if (Book.bookExists(bookName)) {
                Book.openBookPage(bookName);  // Opens book details
            } else {
                d1.setVisible(true);  // Shows "Out of Stock" message
            }
        });

        frame.setVisible(true);
    }
}