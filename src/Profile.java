import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Profile {

    JFrame f;

    Profile() {

        f = new JFrame();
        f.setSize(700, 850);

        //PANEL
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(0, 0, 700, 850);
        panel.setLayout(null);

//Title
        JLabel title;
        title = new JLabel("EDIT PROFILE");
        Font currentFont = title.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f); // increase by 1.5 times
// Set the new font to the JLabel
        title.setFont(newFont);
        title.setForeground(new Color(27, 26, 85));
        title.setBounds(100, 25, 250, 30); // Adjusted y-coordinate

//First Name
        final JTextField tfx = new JTextField();
        tfx.setBounds(100, 115, 270, 40); // Adjusted y-coordinate
        JLabel lb;
        lb = new JLabel("First Name");
        lb.setBounds(100, 75, 100, 30); // Adjusted y-coordinate

//Email
        final JTextField tf2 = new JTextField();
        tf2.setBounds(100, 210, 270, 40); // Adjusted y-coordinate
        JLabel lb2;
        lb2 = new JLabel("Email");
        lb2.setBounds(100, 170, 100, 30); // Adjusted y-coordinate

//Address
        final JTextField tfAddress = new JTextField();
        tfAddress.setBounds(100, 305, 270, 40); // Adjusted y-coordinate
        JLabel lbAddress;
        lbAddress = new JLabel("Address");
        lbAddress.setBounds(100, 265, 100, 30); // Adjusted y-coordinate

//Contact No
        final JTextField tfContactNo = new JTextField();
        tfContactNo.setBounds(100, 400, 270, 40); // Adjusted y-coordinate
        JLabel lbContactNo;
        lbContactNo = new JLabel("Contact Number");
        lbContactNo.setBounds(100, 360, 100, 30); // Adjusted y-coordinate

//Districts
        JLabel lbDistricts;
        lbDistricts = new JLabel("Districts");
        lbDistricts.setBounds(100, 455, 100, 30); // Adjusted y-coordinate
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Open");
        comboBox.addItem("Save");
        comboBox.addItem("Exit");
        comboBox.setBounds(100, 495, 270, 30); // Adjusted y-coordinate
        comboBox.setBackground(Color.white);

// Add action listener to the JComboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item
                String selectedItem = (String) comboBox.getSelectedItem();
                if (selectedItem.equals("Exit")) {
                    System.exit(0); // Exit the application when "Exit" is selected
                } else {
                    // Perform other actions based on selected item
                    // For demonstration, we'll print the selected item
                    System.out.println("Selected: " + selectedItem);
                }
            }
        });

//Save Details
        JButton b = new JButton("Save Details");
        b.setBounds(100, 545, 140, 40); // Adjusted y-coordinate
        b.setBackground(new Color(54, 174, 124));
        b.setForeground(Color.white);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current window
                f.dispose();
                // Open the home page window
//                    new Logout();
                new Profile();
            }
        });

//Contact No
        final JTextField tfPassword = new JTextField();
        tfPassword.setBounds(100, 640, 270, 40); // Adjusted y-coordinate
        JLabel lbPassword;
        lbPassword = new JLabel("Old Password");
        lbPassword.setBounds(100, 600, 100, 30); // Adjusted y-coordinate

        //Save Password
        JButton btnSavePassword = new JButton("Save Password");
        btnSavePassword.setBounds(100, 700, 140, 40); // Adjusted y-coordinate
        btnSavePassword.setBackground(new Color(54, 174, 124));
        btnSavePassword.setForeground(Color.white);
        btnSavePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current window
                f.dispose();
                // Open the home page window
//                    new Logout();
                new Profile();
            }
        });



        panel.add(title);
        panel.add(lb);
        panel.add(lb2);
        panel.add(tfx);
        panel.add(tf2);
        panel.add(b);
        panel.add(tfAddress);
        panel.add(lbAddress);
        panel.add(tfContactNo);
        panel.add(lbContactNo);
        panel.add(lbDistricts);
        panel.add(comboBox);
        panel.add(lbPassword);
        panel.add(tfPassword);
        panel.add(btnSavePassword);
        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);
    }


}