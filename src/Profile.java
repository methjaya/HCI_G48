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
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        title.setBounds(80, 25, 250, 30);

//First Name
        final JTextField tfx = new JTextField();
        tfx.setBounds(80, 115, 240, 40);
        JLabel lb;
        lb = new JLabel("First Name");
        lb.setBounds(80, 75, 100, 30);

//Last Name
        final JTextField tfLn = new JTextField();
        tfLn.setBounds(380, 115, 240, 40);
        JLabel lbLn;
        lbLn = new JLabel("Last Name");
        lbLn.setBounds(380, 75, 100, 30);

//Email
        final JTextField tf2 = new JTextField();
        tf2.setBounds(80, 210, 540, 40);
        JLabel lb2;
        lb2 = new JLabel("Email");
        lb2.setBounds(80, 170, 100, 30);

//Address
        final JTextField tfAddress = new JTextField();
        tfAddress.setBounds(80, 305, 540, 40);
        JLabel lbAddress;
        lbAddress = new JLabel("Address");
        lbAddress.setBounds(80, 265, 100, 30);

//Contact No
        final JTextField tfContactNo = new JTextField();
        tfContactNo.setBounds(80, 400, 540, 40);
        JLabel lbContactNo;
        lbContactNo = new JLabel("Contact Number");
        lbContactNo.setBounds(80, 360, 100, 30);

//Districts
        JLabel lbDistricts;
        lbDistricts = new JLabel("District");
        lbDistricts.setBounds(80, 455, 100, 30);
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Open");
        comboBox.addItem("Save");
        comboBox.addItem("Exit");
        comboBox.setBounds(80, 495, 240, 30);
        comboBox.setBackground(Color.white);

// Add action listener to the JComboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //City
        JLabel lbCity;
        lbCity = new JLabel("City");
        lbCity.setBounds(380, 455, 100, 30);
        JComboBox<String> comboBoxCity = new JComboBox<>();
        comboBoxCity.addItem("Open");
        comboBoxCity.addItem("Save");
        comboBoxCity.addItem("Exit");
        comboBoxCity.setBounds(380, 495, 240, 30);
        comboBoxCity.setBackground(Color.white);

// Add action listener to the JComboBox
        comboBoxCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


//Save Details
        JButton b = new JButton("Save Details");
        b.setBounds(80, 545, 140, 40);
        b.setBackground(new Color(54, 174, 124));
        b.setForeground(Color.white);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current window
                f.dispose();
                // Open the home page window
//                    new Logout();
                new Room();
            }
        });

//Old Password
        final JTextField tfPassword = new JTextField();
        tfPassword.setBounds(80, 640, 240, 40);
        JLabel lbPassword;
        lbPassword = new JLabel("Old Password");
        lbPassword.setBounds(80, 600, 100, 30);
        //New Password
        final JTextField tfNewPassword = new JTextField();
        tfNewPassword.setBounds(380, 640, 240, 40);
        JLabel lbNewPassword;
        lbNewPassword = new JLabel("New Password");
        lbNewPassword.setBounds(380, 600, 100, 30);

//Save Password
        JButton btnSavePassword = new JButton("Save Password");
        btnSavePassword.setBounds(80, 700, 140, 40);
        btnSavePassword.setBackground(new Color(54, 174, 124));
        btnSavePassword.setForeground(Color.white);
        btnSavePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current window
                f.dispose();
                // Open the home page window
//                    new Logout();
                new Logout();
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
        panel.add(tfLn);
        panel.add(lbLn);
        panel.add(lbCity);
        panel.add(comboBoxCity);
        panel.add(lbNewPassword);
        panel.add(tfNewPassword);
        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);
    }


}