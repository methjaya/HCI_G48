import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AddFurniture {
    private static List<Color> selectedColors = new ArrayList<>();
    private static JPanel colorDisplayPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddFurniture::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Multiple Color Selection Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Button for adding new colors
        JButton addColorButton = new JButton("Choose Color");
        addColorButton.addActionListener(AddFurniture::handleAddColorAction);

        // Panel to display selected colors
        colorDisplayPanel = new JPanel();
        colorDisplayPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        frame.add(addColorButton, BorderLayout.NORTH);
        frame.add(new JScrollPane(colorDisplayPanel), BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Action handler for adding a new color
    private static void handleAddColorAction(ActionEvent e) {
        Color color = JColorChooser.showDialog(null, "Choose a Color", Color.WHITE);
        if (color != null) {
            selectedColors.add(color);
            updateColorDisplayPanel();
        }
    }

    // Updates the display panel with selected colors
    private static void updateColorDisplayPanel() {
        colorDisplayPanel.removeAll();
        for (Color color : selectedColors) {
            JPanel colorPanel = new JPanel();
            colorPanel.setPreferredSize(new Dimension(20, 20));
            colorPanel.setBackground(color);
            colorDisplayPanel.add(colorPanel);
        }
        colorDisplayPanel.revalidate();
        colorDisplayPanel.repaint();
    }
}

