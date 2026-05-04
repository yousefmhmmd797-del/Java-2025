
import javax.swing.*;
import java.awt.BorderLayout;

public class Book {

    private static final String[] availableBooks = {
        "Ego is The Enemy", "Think Like a Monk", "1984", "A Little Life", "Majdoleen"
    };

    // Check if the book exists in the array
    public static boolean bookExists(String bookName) {
        for (String book : availableBooks) {
            if (book.equalsIgnoreCase(bookName)) {
                return true;  // Book found
            }
        }
        return false;  // Book not found
    }

    // Open book details page
    public static void openBookPage(String bookName) {
        JFrame bookPage = new JFrame(bookName);
        bookPage.setSize(400, 300);
        bookPage.setLocationRelativeTo(null);
        bookPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bookPage.setLayout(new BorderLayout());

        JLabel bookDetails = new JLabel("Good news! " + bookName+  " is availabel ");
        bookDetails.setHorizontalAlignment(SwingConstants.CENTER);
        bookPage.add(bookDetails, BorderLayout.CENTER);
        
        JCheckBox checkBox = new JCheckBox("Reserve a copy");
        bookPage.add(checkBox, BorderLayout.SOUTH);

        bookPage.setVisible(true);
    }
}
