import components.RoundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile {

    JFrame f;
    JTextField tfFirstName;
    JTextField tfLastName;
    JTextField tfEmail;
    JTextField tfAddress;
    JTextField tfContactNo;
    JComboBox<String> comboBoxDistrict;
    JComboBox<String> comboBoxCity;
    JTextField tfOldPassword;
    JTextField tfNewPassword;

    Profile() {

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(1000, 750);
        f.setLocationRelativeTo(null);

        // TOP PANEL
        JPanel panelTop = new JPanel();
        panelTop.setBounds(0, 0, 1000, 80);
        panelTop.setBackground(new Color(54, 48, 98));
        panelTop.setLayout(null);

        // BACK BUTTON
        RoundButton backButton = new RoundButton("assets/back.png", 40, 40);
        backButton.setBounds(15, 20, 40, 40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Dashboard();
            }
        });


        // USER IMAGE
        RoundButton userImage = new RoundButton("assets/user.png", 35, 35);
        userImage.setBounds(870, 20, 40, 40);

        // USER NAME LABEL
        JLabel usernameLb = new JLabel("John");
        usernameLb.setBounds(920, 25, 50, 30);
        usernameLb.setFont(usernameLb.getFont().deriveFont(usernameLb.getFont().getSize() * 1.3f));
        usernameLb.setForeground(Color.white);

        // TITLE
        JLabel title = new JLabel("EDIT PROFILE");
        Font currentFont = title.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f); // increase by 1.5 times
        title.setFont(newFont);
        title.setForeground(Color.white);
        title.setBounds(75, 20, 250, 40);

        // PANEL
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(0, 0, 1000, 750);
        panel.setLayout(null);

        // First Name
        tfFirstName = new JTextField("John"); // Default value
        tfFirstName.setBounds(220, 145, 240, 40);
        JLabel lbFirstName = new JLabel("First Name");
        lbFirstName.setBounds(220, 115, 100, 30);
        lbFirstName.setFont(lbFirstName.getFont().deriveFont(lbFirstName.getFont().getSize() * 1.2f));
        lbFirstName.setForeground(new Color(54, 48, 98));

        // Last Name
        tfLastName = new JTextField("Doe"); // Default value
        tfLastName.setBounds(520, 145, 240, 40);
        JLabel lbLastName = new JLabel("Last Name");
        lbLastName.setBounds(520, 115, 100, 30);
        lbLastName.setFont(lbLastName.getFont().deriveFont(lbLastName.getFont().getSize() * 1.2f));
        lbLastName.setForeground(new Color(54, 48, 98));

        // Email
        tfEmail = new JTextField("john.doe@example.com"); // Default value
        tfEmail.setBounds(220, 220, 540, 40);
        JLabel lbEmail = new JLabel("Email");
        lbEmail.setBounds(220, 190, 100, 30);
        lbEmail.setFont(lbEmail.getFont().deriveFont(lbEmail.getFont().getSize() * 1.2f));
        lbEmail.setForeground(new Color(54, 48, 98));

        // Address
        tfAddress = new JTextField("123 Street, Gampaha, Colombo"); // Default value
        tfAddress.setBounds(220, 295, 540, 40);
        JLabel lbAddress = new JLabel("Address");
        lbAddress.setBounds(220, 265, 100, 30);
        lbAddress.setFont(lbAddress.getFont().deriveFont(lbAddress.getFont().getSize() * 1.2f));
        lbAddress.setForeground(new Color(54, 48, 98));

        // Contact No
        tfContactNo = new JTextField("0701234567"); // Default value
        tfContactNo.setBounds(220, 370, 540, 40);
        JLabel lbContactNo = new JLabel("Contact Number");
        lbContactNo.setBounds(220, 340, 200, 30);
        lbContactNo.setFont(lbContactNo.getFont().deriveFont(lbContactNo.getFont().getSize() * 1.2f));
        lbContactNo.setForeground(new Color(54, 48, 98));

        // Districts
        JLabel lbDistricts = new JLabel("District");
        lbDistricts.setBounds(220, 415, 100, 30);
        lbDistricts.setFont(lbDistricts.getFont().deriveFont(lbDistricts.getFont().getSize() * 1.2f));
        lbDistricts.setForeground(new Color(54, 48, 98));

        String[] districts = {
                "Colombo",
                "Gampaha",
                "Kalutara",
                "Kandy",
                "Matale",
                "Nuwara Eliya",
                "Galle",
                "Matara",
                "Polonnaruwa",
                "Badulla",
                "Moneragala",
                "Ratnapura",
                "Kegalle",
        };

        comboBoxDistrict = new JComboBox<>(districts);
        comboBoxDistrict.setBounds(220, 445, 240, 30);
        comboBoxDistrict.setBackground(Color.white);

        comboBoxDistrict.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action here
            }
        });

        // City
        JLabel lbCity = new JLabel("City");
        lbCity.setBounds(520, 415, 100, 30);
        lbCity.setFont(lbCity.getFont().deriveFont(lbCity.getFont().getSize() * 1.2f));
        lbCity.setForeground(new Color(54, 48, 98));

        String[] cities = {
                "Colombo",
                "Mount Lavinia",
                "Kesbewa",
                "Maharagama",
                "Moratuwa",
                "Ratnapura",
                "Negombo",
                "Kandy",
                "Sri Jayewardenepura Kotte",
                "Gampaha",
                "Matara"
        };

        comboBoxCity = new JComboBox<>(cities);
        comboBoxCity.setBounds(520, 445, 240, 30);
        comboBoxCity.setBackground(Color.white);

        comboBoxCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action here
            }
        });

        // Save Details
        JButton b = new JButton("Save Details");
        b.setBounds(220, 495, 140, 35);
        b.setBackground(new Color(54, 48, 98));
        b.setForeground(Color.white);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    // Save details
                    JOptionPane.showMessageDialog(f, "Details saved successfully");
                }
            }
        });

        // Old Password
        tfOldPassword = new JPasswordField();
        tfOldPassword.setBounds(220, 570, 240, 40);
        JLabel lbOldPassword = new JLabel("Old Password");
        lbOldPassword.setBounds(220, 540, 100, 30);
        lbOldPassword.setFont(lbOldPassword.getFont().deriveFont(lbOldPassword.getFont().getSize() * 1.2f));
        lbOldPassword.setForeground(new Color(54, 48, 98));

        // New Password
        tfNewPassword = new JPasswordField();
        tfNewPassword.setBounds(520, 570, 240, 40);
        JLabel lbNewPassword = new JLabel("New Password");
        lbNewPassword.setBounds(520, 540, 200, 30);
        lbNewPassword.setFont(lbNewPassword.getFont().deriveFont(lbNewPassword.getFont().getSize() * 1.2f));
        lbNewPassword.setForeground(new Color(54, 48, 98));

        // Save Password
        JButton btnSavePassword = new JButton("Save Password");
        btnSavePassword.setBounds(220, 630, 140, 35);
        btnSavePassword.setBackground(new Color(54, 48, 98));
        btnSavePassword.setForeground(Color.white);
        btnSavePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validatePassword(tfOldPassword.getText(), tfNewPassword.getText())) {
                    // Update password
                    JOptionPane.showMessageDialog(f, "Password updated successfully");
                }
            }
        });

        panelTop.add(title);
        panelTop.add(backButton);
        panelTop.add(userImage);
        panelTop.add(usernameLb);
        panel.add(lbFirstName);
        panel.add(lbEmail);
        panel.add(tfFirstName);
        panel.add(tfEmail);
        panel.add(b);
        panel.add(tfAddress);
        panel.add(lbAddress);
        panel.add(tfContactNo);
        panel.add(lbContactNo);
        panel.add(lbDistricts);
        panel.add(comboBoxDistrict);
        panel.add(lbOldPassword);
        panel.add(tfOldPassword);
        panel.add(btnSavePassword);
        panel.add(tfLastName);
        panel.add(lbLastName);
        panel.add(lbCity);
        panel.add(comboBoxCity);
        panel.add(lbNewPassword);
        panel.add(tfNewPassword);

        f.add(panelTop);
        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);
    }

    // Method to validate fields
    private boolean validateFields() {
        if (tfFirstName.getText().isEmpty() || tfEmail.getText().isEmpty() || tfAddress.getText().isEmpty() || tfContactNo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(f, "Please fill in all fields");
            return false;
        }
        return true;
    }

    // Method to validate password
    private boolean validatePassword(String oldPassword, String newPassword) {
        if (oldPassword.length() < 5 || newPassword.length() < 5) {
            JOptionPane.showMessageDialog(f, "Password should have at least 5 characters");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new Profile();
    }
}

