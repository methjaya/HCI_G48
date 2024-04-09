import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Logout {


    JFrame f;

    Logout() {

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(900, 600);
        f.setLocationRelativeTo(null);

        //LEFT PANEL
        JPanel panelLeft = new JPanel();
        panelLeft.setBounds(0, 0, 400, 600);
        panelLeft.setBackground(new Color(54, 48, 98));
        panelLeft.setLayout(null);

        // Load and display image
        ImageIcon imageIconLogo = new ImageIcon("assets/logo.png"); // Modify with your image path
        JLabel imageLabelLogo = new JLabel(imageIconLogo);
        imageLabelLogo.setBounds(70, 140, imageIconLogo.getIconWidth(), imageIconLogo.getIconHeight());
        panelLeft.add(imageLabelLogo);

        //Right PANEL
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(385, 0, 500, 600);
        panel.setLayout(null);


        JLabel title;
        title = new JLabel("ARE YOU SURE");
        Font currentFont = title.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f); // increase by 1.5 times
        // Set the new font to the JLabel
        title.setFont(newFont);
        title.setForeground(new Color(27, 26, 85));
        title.setBounds(190, 295, 250, 30);

        JLabel title2;
        title2 = new JLabel("YOU WANT TO LOGOUT?");
        Font currentFont2 = title2.getFont();
        Font newFont2 = currentFont.deriveFont(currentFont2.getSize() * 1.5f); // increase by 1.5 times
        // Set the new font to the JLabel
        title2.setFont(newFont2);
        title2.setForeground(new Color(27, 26, 85));
        title2.setBounds(152, 320, 250, 30);


        // Load and display image
        ImageIcon imageIcon = new ImageIcon("assets/logout.png"); // Modify with your image path
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(200, 140, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        panel.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent me) {
            }

            public void mouseReleased(MouseEvent me) {
            }

            public void mouseEntered(MouseEvent me) {
            }

            public void mouseExited(MouseEvent me) {
            }

            public void mouseClicked(MouseEvent me) {
                int x = me.getX();
                int y = me.getY();
                System.out.println("X:" + x + " Y:" + y);

            }
        });

        //BTN YES
        JButton b = new JButton("YES");
        b.setBounds(140, 380, 100, 30);
        b.setBackground(new Color(54, 174, 124));
        b.setForeground(Color.white);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    f.dispose();
                    // Open the home page window
                    new Profile();
                } catch (Exception err) {
//                        output.setText("Error");
                }

            }
        });

        //BTN NO
        JButton btnNo = new JButton("NO");
        btnNo.setBounds(280, 380, 100, 30);
        btnNo.setBackground(new Color(250, 112, 112));
        btnNo.setForeground(Color.white);
        btnNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                } catch (Exception err) {
//                        output.setText("Error");
                }

            }
        });


        panel.add(title);
        panel.add(title2);
        panel.add(imageLabel);
        panel.add(b);
        panel.add(btnNo);
        f.add(panelLeft);
        f.add(panel);
        f.setLayout(null);
        f.setVisible(true);
    }

}