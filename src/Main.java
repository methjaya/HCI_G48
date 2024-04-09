import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) {
        new Activity();
    }

    public static class Activity{
        JFrame f;
        Activity(){

            f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(900,600);
            f.setLocationRelativeTo(null);

            // LEFT PANEL
            JPanel panelLeft = new JPanel();
            panelLeft.setBounds(0,0,400,600);
            panelLeft.setBackground(new Color(54,48,98));
            panelLeft.setLayout(null);

            // Load and display logo image
            ImageIcon imageIcon = new ImageIcon("assets/logo.png"); // Update path to your image
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(70, 140, imageIcon.getIconWidth(), imageIcon.getIconHeight());
            panelLeft.add(imageLabel);

            // RIGHT PANEL
            JPanel panel = new JPanel();
            panel.setBackground(Color.white);
            panel.setBounds(385,0,500,600);
            panel.setLayout(null);

            // Email TextField
            final JTextField tfEmail = new JTextField();
            tfEmail.setBounds(135,220,270,40);

            // Password Field (obscure text)
            final JPasswordField pfPassword = new JPasswordField();
            pfPassword.setBounds(135,315,270,40);

            JLabel title = new JLabel("LOGIN TO YOUR ACCOUNT");
            Font currentFont = title.getFont();
            Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f);
            title.setFont(newFont);
            title.setForeground(new Color(27,26,85));
            title.setBounds(152,125,250,30);

            JLabel lbEmail = new JLabel("Email");
            lbEmail.setBounds(135,180,100,30);

            JLabel lbPassword = new JLabel("Password");
            lbPassword.setBounds(135,275,100,30);

            JButton bLogin = new JButton("Login");
            bLogin.setBounds(190,385,140,40);
            bLogin.setBackground(new Color(51,58,115));
            bLogin.setForeground(Color.white);
            bLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Validate input
                    String email = tfEmail.getText();
                    String password = new String(pfPassword.getPassword());

                    if(email.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(f, "Email and password must not be empty.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // TODO: Perform more sophisticated validation/authentication here
                        f.dispose();
                        new Dashboard(); // Proceed to dashboard if validation is successful
                    }
                }
            });

            panel.add(title);
            panel.add(lbEmail);
            panel.add(lbPassword);
            panel.add(tfEmail);
            panel.add(pfPassword);
            panel.add(bLogin);
            f.add(panelLeft);
            f.add(panel);
            f.setLayout(null);
            f.setVisible(true);
        }
    }
}

