package Mod2_Option1_Bank_Balance_App;

import javax.swing.*;
import java.awt.*;

// Class for handling the UI for the bank application
public class BankUI extends JPanel {
    private BankAccount account;    // Holds reference to BankAccount object that UI will interact with
    private JLabel currentBalanceLabel; // Holds reference to  JLabel component that is used to display current balance
    private CardLayout cardLayout;  // Holds reference to CardLayout object that manages layout of UI panels.

    // Constructor initializes the UI elements and action listeners
    public BankUI(BankAccount account) {
        this.account = account; // // Associate this UI with a BankAccount object
        
        // Set layout and initialize card layout for panel switching
        setLayout(new BorderLayout());
        cardLayout = new CardLayout();
        JPanel centerPanel = new JPanel(cardLayout);

        // Initialize and add balance label at the top
        currentBalanceLabel = new JLabel("Current Balance: $ 0.0");
        add(currentBalanceLabel, BorderLayout.NORTH);

        // Add the center panel that holds the different card layouts
        add(centerPanel, BorderLayout.CENTER);

        // Initial Panel for entering the initial balance
        JPanel initialPanel = new JPanel();
        JLabel initialLabel = new JLabel("Enter Initial Balance: ");
        JTextField initialField = new JTextField(10);
        JButton initialButton = new JButton("Click to Set Balance");
        initialPanel.add(initialLabel);
        initialPanel.add(initialField);
        initialPanel.add(initialButton);
        centerPanel.add(initialPanel, "Initial");

        // Action Panel for depositing and withdrawing funds
        JPanel actionPanel = new JPanel();
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JTextField depositField = new JTextField(10);
        JTextField withdrawField = new JTextField(10);
        actionPanel.add(depositButton);
        actionPanel.add(depositField);
        actionPanel.add(withdrawButton);
        actionPanel.add(withdrawField);
        centerPanel.add(actionPanel, "Actions");

        // Attach action listeners to buttons
        initialButton.addActionListener(e -> setInitialBalance(initialField, centerPanel));
        depositButton.addActionListener(e -> depositFunds(depositField));
        withdrawButton.addActionListener(e -> withdrawFunds(withdrawField));
    }

    // Sets the initial balance and updates the UI
    private void setInitialBalance(JTextField initialField, JPanel centerPanel) {
        try {
            double initialBalance = Double.parseDouble(initialField.getText());
            account.deposit(initialBalance);
            updateBalanceLabel();
            cardLayout.show(centerPanel, "Actions");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid number.");
        }
    }

    // Handles depositing funds
    private void depositFunds(JTextField depositField) {
        try {
            double depositAmount = Double.parseDouble(depositField.getText());
            account.deposit(depositAmount);
            updateBalanceLabel();
            depositField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid number.");
        }
    }

    // Handles withdrawing funds
    private void withdrawFunds(JTextField withdrawField) {
        try {
            double withdrawAmount = Double.parseDouble(withdrawField.getText());
            account.withdraw(withdrawAmount);
            updateBalanceLabel();
            withdrawField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid number.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Insufficient funds.");
        }
    }

    // Updates the balance label with the current balance
    private void updateBalanceLabel() {
        currentBalanceLabel.setText("Current Balance: $" + account.getBalance());
    }
}
