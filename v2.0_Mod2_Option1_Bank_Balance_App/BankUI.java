import javax.swing.*;
import java.awt.*;

// Declare class that inherits from JPanel
public class BankUI extends JPanel {
    private BankAccount account;    // BankAccount object
    private CardLayout cardLayout;  // For switching between different panels/"cards"
    private JPanel centerPanel;     // Main panel to be used to display other panels

    // Constructor initializes UI components and layout
    public BankUI(BankAccount account) {
        this.account = account;     // Initialize BankAccount object

        setLayout(new BorderLayout());
        cardLayout = new CardLayout();  // Initialize CardLayout manager
        centerPanel = new JPanel(cardLayout);   //Create new panel for CarLayout

        add(centerPanel, BorderLayout.CENTER);  // Adds to main panel

        // Create a panel for the initial balance input, initial UI setup
        JPanel initialPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcInitial = new GridBagConstraints();

        
        JLabel initialLabel = new JLabel("Enter Initial Balance: ");
        JTextField initialField = new JTextField(10);
        JButton initialButton = new JButton("Click to Set Balance");

        // Setting up constraints and positioning for GridBagLayout
        gbcInitial.gridx = 0;
        gbcInitial.gridy = 0;
        gbcInitial.gridwidth = 1;
        gbcInitial.insets = new Insets(20, 20, 10, 20);  // (top, left, bottom, right)
        initialPanel.add(initialLabel, gbcInitial);

        gbcInitial.gridy = 1;
        gbcInitial.insets = new Insets(10, 20, 10, 20);
        initialPanel.add(initialField, gbcInitial);

        gbcInitial.gridy = 2;
        gbcInitial.insets = new Insets(10, 20, 20, 20);
        initialPanel.add(initialButton, gbcInitial);

        centerPanel.add(initialPanel, "Initial");

        // Initialize and add components for action panel
        JLabel topLabel = new JLabel("What would you like to do?");
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel actionPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Setting top label positioning and adds to actionPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10); // (top, left, bottom, right)
        actionPanel.add(topLabel, gbc); // 

        gbc.gridy++; // Move to next row for deposit button and text field
        gbc.gridwidth = 1;

        // Creates and adds deposit button to action panel
        JButton depositButton = new JButton("Deposit");
        actionPanel.add(depositButton, gbc);

        // Creates text field for deposit and positioning
        JTextField depositField = new JTextField(10);
        gbc.gridx++;    // Moves textfield for deposit one cell to right
        actionPanel.add(depositField, gbc);

        
        gbc.gridx = 0;  // Move to first column
        gbc.gridy++;    // Move to next row

        JButton withdrawButton = new JButton("Withdraw"); 
        actionPanel.add(withdrawButton, gbc);

        JTextField withdrawField = new JTextField(10);
        gbc.gridx++;    // Moves withdraw textfield one cell to right
        actionPanel.add(withdrawField, gbc);

        // Exit button positioning
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton exitButton = new JButton("Check Balance and Exit"); // Create exit button
        actionPanel.add(exitButton, gbc);

        centerPanel.add(actionPanel, "Actions");

        // Initialize exit page
        ExitPage exitPage = new ExitPage();
        centerPanel.add(exitPage, "Exit");

        // Attaching action listeners to buttons
        initialButton.addActionListener(e -> setInitialBalance(initialField, centerPanel));
        depositButton.addActionListener(e -> depositFunds(depositField));
        withdrawButton.addActionListener(e -> withdrawFunds(withdrawField));
        exitButton.addActionListener(e -> goToExitPage(exitPage));
    }

    // Method to set initial balance and switch to action panel
    private void setInitialBalance(JTextField initialField, JPanel centerPanel) {
        try {
            double initialBalance = Double.parseDouble(initialField.getText());
            account.deposit(initialBalance);
            cardLayout.show(centerPanel, "Actions");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid number.");
        }
    }

    // Method for deposit action
    private void depositFunds(JTextField depositField) {
        try {
            double depositAmount = Double.parseDouble(depositField.getText());
            account.deposit(depositAmount);
            depositField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid number.");
        }
    }

    // Method for withdraw action
    private void withdrawFunds(JTextField withdrawField) {
        try {
            double withdrawAmount = Double.parseDouble(withdrawField.getText());
            account.withdraw(withdrawAmount);
            withdrawField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid number.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Insufficient funds.");
        }
    }

    // Method to switch to exit page and show final balance
    private void goToExitPage(ExitPage exitPage) {
        exitPage.updateFinalBalance(account.getBalance());
        cardLayout.show(centerPanel, "Exit");
    }
}
