import javax.swing.*;
import java.awt.*;

public class ExitPage extends JPanel {
    private JLabel finalBalanceLabel;

    public ExitPage() {
        setLayout(new BorderLayout());
        finalBalanceLabel = new JLabel("Final Balance: $0.0", SwingConstants.CENTER);
        add(finalBalanceLabel, BorderLayout.CENTER);

        // Create a panel for the button and set its layout to GridBagLayout
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Setting insets
        gbc.insets = new Insets(20,20,20,20);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JButton returnButton = new JButton("Return to Options");
        returnButton.setPreferredSize(new Dimension(200, 30));
        buttonPanel.add(returnButton, gbc);

        
        returnButton.addActionListener(e -> {
            CardLayout parentCardLayout = (CardLayout) getParent().getLayout();
            parentCardLayout.show(getParent(), "Actions");
        });

        // Creating an Exit button
        gbc.gridy = 1;
        JButton exitButton = new JButton("Exit App");
        exitButton.setPreferredSize(new Dimension(200, 30));
        buttonPanel.add(exitButton, gbc);

        // Add action listener for exiting app with exit button
        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        // Adding button panel to main panel
        add(buttonPanel, BorderLayout.SOUTH);

    }

    public void updateFinalBalance(double balance) {
        finalBalanceLabel.setText("Final Balance: $" + balance);
    }
}
