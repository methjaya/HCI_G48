import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        new Login();
    }

    public static class Login {
        JFrame f;

        Login() {
            f = new JFrame();
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setSize(900, 600);
            f.setLocationRelativeTo(null);

            // LEFT PANEL
            JPanel panelLeft = new JPanel();
            panelLeft.setBounds(0, 0, 400, 600);
            panelLeft.setBackground(new Color(54, 48, 98));
            panelLeft.setLayout(null);

            // Load and display logo image
            ImageIcon imageIcon = new ImageIcon("assets/logo.png");
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(70, 140, imageIcon.getIconWidth(), imageIcon.getIconHeight());
            panelLeft.add(imageLabel);

            // RIGHT PANEL
            JPanel panel = new JPanel();
            panel.setBackground(Color.white);
            panel.setBounds(385, 0, 500, 600);
            panel.setLayout(null);

            // Email TextField
            final JTextField tfEmail = new JTextField();
            tfEmail.setBounds(135, 220, 270, 40);

            // Password Field (obscure text)
            final JPasswordField pfPassword = new JPasswordField();
            pfPassword.setBounds(135, 315, 270, 40);

            JLabel title = new JLabel("LOGIN TO YOUR ACCOUNT");
            Font currentFont = title.getFont();
            Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5f);
            title.setFont(newFont);
            title.setForeground(new Color(27, 26, 85));
            title.setBounds(152, 125, 250, 30);

            JLabel lbEmail = new JLabel("Email");
            lbEmail.setBounds(135, 180, 100, 30);

            JLabel lbPassword = new JLabel("Password");
            lbPassword.setBounds(135, 275, 100, 30);

            JButton bLogin = new JButton("Login");
            bLogin.setBounds(190, 385, 140, 40);
            bLogin.setBackground(new Color(51, 58, 115));
            bLogin.setForeground(Color.white);
            bLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Validate input
                    String email = tfEmail.getText();
                    String password = new String(pfPassword.getPassword());

                    if (email.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(f, "Email and password must not be empty.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!isValidEmail(email)) {
                        JOptionPane.showMessageDialog(f, "Please enter a valid email address.", "Invalid Email", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Proceed with the login
                        f.dispose();
                        new Dashboard();
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

        private boolean isValidEmail(String email) {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pat = Pattern.compile(emailRegex);
            return pat.matcher(email).matches();
        }
    }
}

