import javax.swing.*;
import java.awt.*;

public class BankUI extends JPanel {
    private BankAccount account;
    private CardLayout cardLayout;
    private JPanel centerPanel;

    public BankUI(BankAccount account) {
        this.account = account;

        setLayout(new BorderLayout());
        cardLayout = new CardLayout();
        centerPanel = new JPanel(cardLayout);

        add(centerPanel, BorderLayout.CENTER);

        // Create a panel for the initial balance input
        JPanel initialPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcInitial = new GridBagConstraints();

        JLabel initialLabel = new JLabel("Enter Initial Balance: ");
        JTextField initialField = new JTextField(10);
        JButton initialButton = new JButton("Click to Set Balance");

        gbcInitial.gridx = 0;
        gbcInitial.gridy = 0;
        gbcInitial.gridwidth = 1;
        gbcInitial.insets = new Insets(20, 20, 10, 20);  // top, left, bottom, right
        initialPanel.add(initialLabel, gbcInitial);

        gbcInitial.gridy = 1;
        gbcInitial.insets = new Insets(10, 20, 10, 20);
        initialPanel.add(initialField, gbcInitial);

        gbcInitial.gridy = 2;
        gbcInitial.insets = new Insets(10, 20, 20, 20);
        initialPanel.add(initialButton, gbcInitial);

        centerPanel.add(initialPanel, "Initial");

        JLabel topLabel = new JLabel("What would you like to do?");
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel actionPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        actionPanel.add(topLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        JButton depositButton = new JButton("Deposit");
        actionPanel.add(depositButton, gbc);

        JTextField depositField = new JTextField(10);
        gbc.gridx++;
        actionPanel.add(depositField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JButton withdrawButton = new JButton("Withdraw");
        actionPanel.add(withdrawButton, gbc);

        JTextField withdrawField = new JTextField(10);
        gbc.gridx++;
        actionPanel.add(withdrawField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton exitButton = new JButton("Check Balance and Exit");
        actionPanel.add(exitButton, gbc);

        centerPanel.add(actionPanel, "Actions");

        ExitPage exitPage = new ExitPage();
        centerPanel.add(exitPage, "Exit");

        initialButton.addActionListener(e -> setInitialBalance(initialField, centerPanel));
        depositButton.addActionListener(e -> depositFunds(depositField));
        withdrawButton.addActionListener(e -> withdrawFunds(withdrawField));
        exitButton.addActionListener(e -> goToExitPage(exitPage));
    }

    private void setInitialBalance(JTextField initialField, JPanel centerPanel) {
        try {
            double initialBalance = Double.parseDouble(initialField.getText());
            account.deposit(initialBalance);
            cardLayout.show(centerPanel, "Actions");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid number.");
        }
    }

    private void depositFunds(JTextField depositField) {
        try {
            double depositAmount = Double.parseDouble(depositField.getText());
            account.deposit(depositAmount);
            depositField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid number.");
        }
    }

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

    private void goToExitPage(ExitPage exitPage) {
        exitPage.updateFinalBalance(account.getBalance());
        cardLayout.show(centerPanel, "Exit");
    }
}
