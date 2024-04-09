import components.RoundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Instructions {
    JFrame f;
    Instructions() {

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900, 600);
        f.setLocationRelativeTo(null);

        // TOP PANEL
        JPanel panelTop = new JPanel();
        panelTop.setBounds(0, 0, 900, 80);
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
        userImage.setBounds(770, 20, 40, 40);
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
        usernameLb.setBounds(820,25,50,30);
        usernameLb.setFont(usernameLb.getFont().deriveFont(usernameLb.getFont().getSize() * 1.2f));
        usernameLb.setForeground(Color.white);

        // TITLE
        JLabel title;
        title = new JLabel("ROOM CONFIGURATION");
        Font currentFont = title.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f);
        title.setFont(newFont);
        title.setForeground(Color.white);
        title.setBounds(75, 20, 250, 40);

        // LEFT PANEL
        JPanel panelRight = new JPanel();
        panelRight.setBounds(0, 0, 500, 600);
        panelRight.setBackground(Color.white);
        panelRight.setLayout(null);

        JLabel text1;
        text1 = new JLabel("INSTRUCTIONS FOR USE", SwingConstants.CENTER);
        text1.setFont(text1.getFont().deriveFont(currentFont.getSize() * 1.5f));
        text1.setForeground(new Color(27, 26, 85));
        text1.setBounds(125, 210, 250, 30);
        panelRight.add(text1);

        JLabel text2 = new JLabel("PLEASE READ THE INSTRUCTIONS", SwingConstants.CENTER);
        text2.setFont(currentFont.deriveFont(currentFont.getSize() * 1.4f));
        text2.setForeground(new Color(27, 26, 85));
        text2.setBounds(50, 270, 400, 30); // Adjust the bounds as needed
        panelRight.add(text2);

        // Line 2
        JLabel text3 = new JLabel("CAREFULLY TO OPERATE THE", SwingConstants.CENTER);
        text3.setFont(currentFont.deriveFont(currentFont.getSize() * 1.4f));
        text3.setForeground(new Color(27, 26, 85));
        text3.setBounds(50, 300, 400, 30); // Adjust the bounds as needed
        panelRight.add(text3);

        // Line 3
        JLabel text4 = new JLabel("VISUALIZATION SECTION.", SwingConstants.CENTER);
        text4.setFont(currentFont.deriveFont(currentFont.getSize() * 1.4f));
        text4.setForeground(new Color(27, 26, 85));
        text4.setBounds(50, 330, 400, 30); // Adjust the bounds as needed
        panelRight.add(text4);

        JButton goBtn = new JButton("GO >");
        goBtn.setBounds(215, 390, 70, 30);
        goBtn.setBackground(new Color(54, 48, 98));
        goBtn.setForeground(Color.white);
        goBtn.setFocusPainted(false);
        goBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = "assets/User instructions.pdf";
                File pdfFile = new File(filePath);

                if (pdfFile.exists()) {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            // Open the PDF file.
                            Desktop.getDesktop().open(pdfFile);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                            JOptionPane.showMessageDialog(f, "An error occurred while opening the file.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(f, "Desktop is not supported on this platform.");
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "The file does not exist.");
                }
            }
        });
        panelRight.add(goBtn);



        // RIGHT PANEL
        JPanel panelLeft = new JPanel();
        panelLeft.setBounds(500, 0, 400, 600);
        panelLeft.setBackground(new Color(54, 48, 98));
        panelLeft.setLayout(null);


        ImageIcon imageIconLogo = new ImageIcon("assets/logo.png");
        JLabel imageLabelLogo = new JLabel(imageIconLogo);
        imageLabelLogo.setBounds(65, 140, imageIconLogo.getIconWidth(), imageIconLogo.getIconHeight()); // Adjust position as needed
        panelLeft.add(imageLabelLogo);

        panelTop.add(title);
        panelTop.add(backButton);
        panelTop.add(userImage);
        panelTop.add(usernameLb);

        f.add(panelTop);
        f.add(panelRight);
        f.add(panelLeft);
        f.setLayout(null);
        f.setVisible(true);
    }

}
