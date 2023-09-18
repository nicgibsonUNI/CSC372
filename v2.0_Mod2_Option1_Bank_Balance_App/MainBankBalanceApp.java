import javax.swing.*;

// Class contains the main method to run the application.
public class MainBankBalanceApp {
    public static void main(String[] args) {
        // Create the main application frame
        JFrame frame = new JFrame("Bank Balance App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Creates BankAccount object initializes balance to 0
        BankAccount account = new BankAccount(0.0);

        // Creates UI panel and add it to the frame
        BankUI ui = new BankUI(account);
        frame.add(ui);

        // Make the frame visible
        frame.setVisible(true);
    }
}
