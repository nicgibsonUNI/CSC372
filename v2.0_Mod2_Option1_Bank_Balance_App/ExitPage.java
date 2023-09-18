import javax.swing.*;
import java.awt.*;

// Defines exit page class where final account balance will be show to user
public class ExitPage extends JPanel {
    private JLabel finalBalanceLabel;

    public ExitPage() {
        setLayout(new BorderLayout());  // Setting layout for the panel
        finalBalanceLabel = new JLabel("Final Balance: $0.0", SwingConstants.CENTER);
        
        add(finalBalanceLabel, BorderLayout.CENTER);    // Puts final balance in center of window

        // Create a panel for the button and set its layout to GridBagLayout
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Setting layout constraints
        gbc.insets = new Insets(20,20,20,20);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Creates the return to options button
        JButton returnButton = new JButton("Return to Options");
        returnButton.setPreferredSize(new Dimension(200, 30));
        buttonPanel.add(returnButton, gbc);

        // Adds action listener for return to options button
        returnButton.addActionListener(e -> {
            CardLayout parentCardLayout = (CardLayout) getParent().getLayout();
            parentCardLayout.show(getParent(), "Actions"); // Switches back to actions panel
        });

        // Creates an Exit button
        gbc.gridy = 1;
        JButton exitButton = new JButton("Exit App");
        exitButton.setPreferredSize(new Dimension(200, 30));
        buttonPanel.add(exitButton, gbc);

        // Adds action listener for exiting app with exit button
        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        // Adding button panel to main panel
        add(buttonPanel, BorderLayout.SOUTH);

    }

    //Method updates the final balance label
    public void updateFinalBalance(double balance) {
        finalBalanceLabel.setText("Final Balance: $" + balance);
    }
}
