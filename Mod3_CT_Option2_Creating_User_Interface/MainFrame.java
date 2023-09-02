import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;

public class MainFrame extends JFrame {
    private JTextArea textArea;
    private Color randomOrangeHue;

    public MainFrame() {
        setTitle("Menu Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu Bar and Items
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem menuItem1 = new JMenuItem("Print Date and Time");
        JMenuItem menuItem2 = new JMenuItem("Save to log.txt");
        JMenuItem menuItem3 = new JMenuItem("Change Background Color");
        JMenuItem menuItem4 = new JMenuItem("Exit");
        
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Text Area
        textArea = new JTextArea();
        textArea.setOpaque(false); 
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        add(scrollPane, BorderLayout.CENTER);

        // Event Handlers
        menuItem1.addActionListener(this::printDateTime);
        menuItem2.addActionListener(e -> FileUtil.writeToFile(textArea.getText()));
        menuItem3.addActionListener(e -> changeBackgroundColor());
        menuItem4.addActionListener(e -> System.exit(0));

        // Generate a random hue of orange for this program instance
        float hue = 0.05f + (float) Math.random() * (0.15f - 0.05f);
        randomOrangeHue = Color.getHSBColor(hue, 1, 1); // Full saturation, 75% brightness
    }

    private void printDateTime(ActionEvent e) {
        textArea.append(LocalDateTime.now().toString() + "\n");
    }

    private void changeBackgroundColor() {
        getContentPane().setBackground(randomOrangeHue);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
