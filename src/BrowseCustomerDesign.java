import components.RoundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BrowseCustomerDesign {

    JFrame f;

    BrowseCustomerDesign() {

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 720);
        f.setLocationRelativeTo(null);

        // TOP PANEL
        JPanel panelTop = new JPanel();
        panelTop.setBounds(0, 0, 1000, 80);
        panelTop.setBackground(new Color(54, 48, 98));
        panelTop.setLayout(null);

        // BACK BUTTON
        RoundButton backButton = new RoundButton("assets/back.png",40,40);
        backButton.setBounds(15, 20, 40, 40);

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
        title = new JLabel("BROWSE CUSTOMER DESIGNS");
        Font currentFont = title.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f);
        title.setFont(newFont);
        title.setForeground(Color.white);
        title.setBounds(75, 20, 400, 40);

        // BOTTOM PANEL
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(0, 80, 1000, 720);
        panel.setLayout(null);

        // PANEL 1
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(146, 144, 195, 100));
        panel1.setBounds(100, 120, 310, 140);
        panel1.setLayout(null);
        ImageIcon imageIcon = new ImageIcon("assets/chairs/chair.jpg");
        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(10, 20, 100, 100);
        panel1.add(imageLabel);
        // Date Label
        JLabel dateLabel = new JLabel("Date : 2024/01/02");
        panel1.add(dateLabel);
        // Item Name Label
        JLabel itemNameLabel = new JLabel("Type : Chair 1");
        panel1.add(itemNameLabel);
        // Name Label
        JLabel nameLabel = new JLabel("Name : John Doe");
        panel1.add(nameLabel);
        // Email Label
        JLabel emailLabel = new JLabel("Email : johndoe@gmail.com");
        panel1.add(emailLabel);
        // Phone Number Label
        JLabel phoneLabel = new JLabel("Contact : +94 70 343 4555");
        panel1.add(phoneLabel);
        dateLabel.setBounds(130, 10, 200, 20);
        itemNameLabel.setBounds(130, 35, 200, 20);
        nameLabel.setBounds(130, 60, 200, 20);
        emailLabel.setBounds(130, 85, 200, 20);
        phoneLabel.setBounds(130, 110, 200, 20);
        ImageIcon deleteIcon = new ImageIcon("assets/delete_icon.png");
        JButton deleteButton = new JButton(deleteIcon);
        deleteButton.setBounds(280, 10, 20, 20);
        deleteButton.setOpaque(false);
        deleteButton.setContentAreaFilled(false);
        deleteButton.setBorderPainted(false);
        deleteButton.setFocusPainted(false);
        deleteButton.setToolTipText("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your deletion logic here
                System.out.println("Delete button clicked");
            }
        });
        panel1.add(deleteButton);


        // PANEL 2
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(146, 144, 195, 100));
        panel2.setBounds(500, 120, 310, 140);
        panel2.setLayout(null);
        ImageIcon imageIcon2 = new ImageIcon("assets/chairs/chair2.jpg");
        Image image2 = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image2);
        JLabel imageLabel2 = new JLabel(imageIcon);
        imageLabel2.setBounds(10, 20, 100, 100);
        panel2.add(imageLabel2);
        // Date Label
        JLabel dateLabel2 = new JLabel("Date : 2024/01/03");
        panel2.add(dateLabel2);
        // Item Name Label
        JLabel itemNameLabel2 = new JLabel("Type : Chair 2");
        panel2.add(itemNameLabel2);
        // Name Label
        JLabel nameLabel2 = new JLabel("Name : Jane Doe");
        panel2.add(nameLabel2);
        // Email Label
        JLabel emailLabel2 = new JLabel("Email : janedoe@gmail.com");
        panel2.add(emailLabel2);
        // Phone Number Label
        JLabel phoneLabel2 = new JLabel("Contact : +94 70 555 2055");
        panel2.add(phoneLabel2);
        dateLabel2.setBounds(130, 10, 200, 20);
        itemNameLabel2.setBounds(130, 35, 200, 20);
        nameLabel2.setBounds(130, 60, 200, 20);
        emailLabel2.setBounds(130, 85, 200, 20);
        phoneLabel2.setBounds(130, 110, 200, 20);
        ImageIcon deleteIcon2 = new ImageIcon("assets/delete_icon.png");
        JButton deleteButton2 = new JButton(deleteIcon2);
        deleteButton2.setBounds(280, 10, 20, 20);
        deleteButton2.setOpaque(false);
        deleteButton2.setContentAreaFilled(false);
        deleteButton2.setBorderPainted(false);
        deleteButton2.setFocusPainted(false);
        deleteButton2.setToolTipText("Delete");
        deleteButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your deletion logic here
                System.out.println("Delete button clicked");
            }
        });
        panel2.add(deleteButton2);


        // PANEL 3
        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(146, 144, 195, 100));
        panel3.setBounds(100, 310, 310, 140);
        panel3.setLayout(null);
        ImageIcon imageIcon3 = new ImageIcon("assets/tables/table.png");
        Image image3 = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image3);
        JLabel imageLabel3 = new JLabel(imageIcon3);
        imageLabel3.setBounds(10, 20, 100, 100);
        panel3.add(imageLabel3);
        // Date Label
        JLabel dateLabel3 = new JLabel("Date : 2024/01/06");
        panel3.add(dateLabel3);
        // Item Name Label
        JLabel itemNameLabel3 = new JLabel("Type : Table 1");
        panel3.add(itemNameLabel3);
        // Name Label
        JLabel nameLabel3 = new JLabel("Name : Colt Johnson");
        panel3.add(nameLabel3);
        // Email Label
        JLabel emailLabel3 = new JLabel("Email : colt1234@gmail.com");
        panel3.add(emailLabel3);
        // Phone Number Label
        JLabel phoneLabel3 = new JLabel("Contact : +94 70 120 4552");
        panel3.add(phoneLabel3);
        dateLabel3.setBounds(130, 10, 200, 20);
        itemNameLabel3.setBounds(130, 35, 200, 20);
        nameLabel3.setBounds(130, 60, 200, 20);
        emailLabel3.setBounds(130, 85, 200, 20);
        phoneLabel3.setBounds(130, 110, 200, 20);
        ImageIcon deleteIcon3 = new ImageIcon("assets/delete_icon.png");
        JButton deleteButton3 = new JButton(deleteIcon2);
        deleteButton3.setBounds(280, 10, 20, 20);
        deleteButton3.setOpaque(false);
        deleteButton3.setContentAreaFilled(false);
        deleteButton3.setBorderPainted(false);
        deleteButton3.setFocusPainted(false);
        deleteButton3.setToolTipText("Delete");
        deleteButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your deletion logic here
                System.out.println("Delete button clicked");
            }
        });
        panel3.add(deleteButton3);


        // PANEL 4
        JPanel panel4 = new JPanel();
        panel4.setBackground(new Color(146, 144, 195, 100));
        panel4.setBounds(500, 310, 310, 140);
        panel4.setLayout(null);
        ImageIcon imageIcon4 = new ImageIcon("assets/chairs/chair.jpg");
        Image image4 = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image4);
        JLabel imageLabel4 = new JLabel(imageIcon4);
        imageLabel4.setBounds(10, 20, 100, 100);
        panel4.add(imageLabel4);
        // Date Label
        JLabel dateLabel4 = new JLabel("Date : 2024/01/06");
        panel4.add(dateLabel4);
        // Item Name Label
        JLabel itemNameLabel4 = new JLabel("Type : Chair 1");
        panel4.add(itemNameLabel4);
        // Name Label
        JLabel nameLabel4 = new JLabel("Name : Same Doe");
        panel4.add(nameLabel4);
        // Email Label
        JLabel emailLabel4 = new JLabel("Email : samdoe55@gmail.com");
        panel4.add(emailLabel4);
        // Phone Number Label
        JLabel phoneLabel4 = new JLabel("Contact : +94 70 125 4215");
        panel4.add(phoneLabel4);
        dateLabel4.setBounds(130, 10, 200, 20);
        itemNameLabel4.setBounds(130, 35, 200, 20);
        nameLabel4.setBounds(130, 60, 200, 20);
        emailLabel4.setBounds(130, 85, 200, 20);
        phoneLabel4.setBounds(130, 110, 200, 20);
        ImageIcon deleteIcon4 = new ImageIcon("assets/delete_icon.png");
        JButton deleteButton4 = new JButton(deleteIcon4);
        deleteButton4.setBounds(280, 10, 20, 20);
        deleteButton4.setOpaque(false);
        deleteButton4.setContentAreaFilled(false);
        deleteButton4.setBorderPainted(false);
        deleteButton4.setFocusPainted(false);
        deleteButton4.setToolTipText("Delete");
        deleteButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your deletion logic here
                System.out.println("Delete button clicked");
            }
        });
        panel4.add(deleteButton4);


        // PANEL 5
        JPanel panel5 = new JPanel();
        panel5.setBackground(new Color(146, 144, 195, 100));
        panel5.setBounds(100, 500, 310, 140);
        panel5.setLayout(null);
        ImageIcon imageIcon5 = new ImageIcon("assets/wardrobes/wardrobe1.png");
        Image image5 = imageIcon5.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon5 = new ImageIcon(image5);
        JLabel imageLabel5 = new JLabel(imageIcon5);
        imageLabel5.setBounds(10, 20, 100, 100);
        panel5.add(imageLabel5);
        // Date Label
        JLabel dateLabel5= new JLabel("Date : 2024/01/07");
        panel5.add(dateLabel5);
        // Item Name Label
        JLabel itemNameLabel5 = new JLabel("Type : Wardrobe 1");
        panel5.add(itemNameLabel5);
        // Name Label
        JLabel nameLabel5 = new JLabel("Name : Sarah Williams");
        panel5.add(nameLabel5);
        // Email Label
        JLabel emailLabel5 = new JLabel("Email : sarahw@gmail.com");
        panel5.add(emailLabel5);
        // Phone Number Label
        JLabel phoneLabel5 = new JLabel("Contact : +94 70 668 1235");
        panel5.add(phoneLabel5);
        dateLabel5.setBounds(130, 10, 200, 20);
        itemNameLabel5.setBounds(130, 35, 200, 20);
        nameLabel5.setBounds(130, 60, 200, 20);
        emailLabel5.setBounds(130, 85, 200, 20);
        phoneLabel5.setBounds(130, 110, 200, 20);
        ImageIcon deleteIcon5 = new ImageIcon("assets/delete_icon.png");
        JButton deleteButton5 = new JButton(deleteIcon5);
        deleteButton5.setBounds(280, 10, 20, 20);
        deleteButton5.setOpaque(false);
        deleteButton5.setContentAreaFilled(false);
        deleteButton5.setBorderPainted(false);
        deleteButton5.setFocusPainted(false);
        deleteButton5.setToolTipText("Delete");
        deleteButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your deletion logic here
                System.out.println("Delete button clicked");
            }
        });
        panel5.add(deleteButton5);

        panelTop.add(title);
        panelTop.add(backButton);
        panelTop.add(userImage);
        panelTop.add(usernameLb);;

        f.add(panelTop);
        f.add(panel1);
        f.add(panel2);
        f.add(panel3);
        f.add(panel4);
        f.add(panel5);
        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);
    }

}
