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

        JPanel initialPanel = new JPanel();
        JLabel initialLabel = new JLabel("Enter Initial Balance: ");
        JTextField initialField = new JTextField(10);
        JButton initialButton = new JButton("Click to Set Balance");
        initialPanel.add(initialLabel);
        initialPanel.add(initialField);
        initialPanel.add(initialButton);
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
