import components.RoundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModelSave {

    JFrame f;
    Color selectedColor;
    ModelSave() {

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(1000, 800);
        f.setLocationRelativeTo(null);

        // TOP PANEL
        JPanel panelTop = new JPanel();
        panelTop.setBounds(0, 0, 1000, 80);
        panelTop.setBackground(new Color(54, 48, 98));
        panelTop.setLayout(null);

        // BACK BUTTON
        RoundButton backButton = new RoundButton("assets/back.png",40,40);
        backButton.setBounds(15, 20, 40, 40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Dashboard();
            }
        });

        // USER IMAGE
        RoundButton userImage = new RoundButton("assets/user.png",35,35);
        userImage.setBounds(870, 20, 40, 40);
        userImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Profile();
            }
        });

        // USER NAME LABEL
        JLabel usernameLb;
        usernameLb= new JLabel("John");
        usernameLb.setBounds(920,25,50,30);
        usernameLb.setFont(usernameLb.getFont().deriveFont(usernameLb.getFont().getSize() * 1.2f));
        usernameLb.setForeground(Color.white);

        // TITLE
        JLabel title;
        title = new JLabel("DESIGN SAVE");
        Font currentFont = title.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f); // increase by 1.5 times
        title.setFont(newFont);
        title.setForeground(Color.white);
        title.setBounds(75, 20, 250, 40);

        // CENTER PANEL
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(146, 144, 195,100));
        centerPanel.setBounds(300, 150, 400, 500);
        centerPanel.setLayout(null);

        // CUSTOMER NAME LABEL
        JLabel custNameLb;
        custNameLb = new JLabel("Customer Name");
        custNameLb.setFont(newFont);
        custNameLb.setForeground(new Color(27, 26, 85));
        custNameLb.setBounds(50, 95, 200, 40); // Changed y-coordinate to 95
        custNameLb.setFont(custNameLb.getFont().deriveFont(custNameLb.getFont().getSize() * 0.9f));

// TEXT FIELD CUSTOMER NAME
        JTextField cusNameTf = new JTextField(); // Default value
        cusNameTf.setBounds(50, 140, 300, 30); // Changed y-coordinate to 140
        cusNameTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        cusNameTf.setForeground(new Color(54, 48, 98));

// EMAIL LABEL
        JLabel emailLb;
        emailLb = new JLabel("Email");
        emailLb.setFont(newFont);
        emailLb.setForeground(new Color(27, 26, 85));
        emailLb.setBounds(50, 175, 200, 40); // Changed y-coordinate to 175
        emailLb.setFont(emailLb.getFont().deriveFont(emailLb.getFont().getSize() * 0.9f));

// TEXT FIELD EMAIL
        JTextField emailTf = new JTextField(); // Default value
        emailTf.setBounds(50, 220, 300, 30); // Changed y-coordinate to 220
        emailTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        emailTf.setForeground(new Color(54, 48, 98));

// WALL COLOR LABEL
        JLabel contactNoLb;
        contactNoLb = new JLabel("Contact Number");
        contactNoLb.setFont(newFont);
        contactNoLb.setForeground(new Color(27, 26, 85));
        contactNoLb.setBounds(50, 255, 200, 40); // Changed y-coordinate to 255
        contactNoLb.setFont(contactNoLb.getFont().deriveFont(contactNoLb.getFont().getSize() * 0.9f));

        JTextField contactNoTf = new JTextField(); // Default value
        contactNoTf.setBounds(50, 300, 300, 30); // Changed y-coordinate to 300
        contactNoTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contactNoTf.setForeground(new Color(54, 48, 98));

// SAVE BUTTON
        JButton goBtn = new JButton("Save");
        goBtn.setBounds(165, 370, 70, 30); // Changed y-coordinate to 370
        goBtn.setBackground(new Color(54, 48, 98));
        goBtn.setForeground(Color.white);
        goBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Model saved successfully!");
            }
        });






        panelTop.add(title);
        panelTop.add(backButton);
        panelTop.add(userImage);
        panelTop.add(usernameLb);
        centerPanel.add(goBtn);
        centerPanel.add(custNameLb);
        centerPanel.add(cusNameTf);
        centerPanel.add(emailLb);
        centerPanel.add(emailTf);
        centerPanel.add(contactNoLb);
        centerPanel.add(contactNoTf);
        f.add(panelTop);
        f.add(centerPanel);
        f.setLayout(null);
        f.setVisible(true);
    }
}

