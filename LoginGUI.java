import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents the graphical user interface for the admin login screen
public class LoginGUI extends JFrame {
   
	private JTextField idTextField;    // Text field for entering the ID
    private JPasswordField pwTextField; // Password field for entering the password
    private int totalSales;             // Total sales information passed from the HomeScreen
    private String totalOrderList;      // Total order list information passed from the HomeScreen

    // Constructor to initialize the LoginGUI with total sales and total order list information
    public LoginGUI(int totalSales, String totalOrderList) {
    	this.totalSales = totalSales;
    	this.totalOrderList = totalOrderList;
        initialize();
    }

    // Method to initialize the graphical components of the login screen
    private void initialize() {
        setTitle("Welcome back, Manager!");
        setBounds(100, 100, 400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 부모 프레임을 닫고 현재 프레임만 닫도록 변경

        JPanel panel = new JPanel(new GridBagLayout());
        getContentPane().add(panel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel idLabel = new JLabel("ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);

        idTextField = new JTextField(25);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(idTextField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        pwTextField = new JPasswordField(25);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(pwTextField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(loginButton, gbc);

        // ActionListener for the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                char[] passwordChars = pwTextField.getPassword();
                String pw = new String(passwordChars);

                try {
                    if (id.equals("") || pw.equals("")) {
                        throw new EmptyTextFieldException();
                    }
                    if (id.equals("subway_manager") && pw.equals("1234")) {
                        JOptionPane.showMessageDialog(null, "Welcome! You have successfully logged in.", "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        
                        // Open the AdminMenuScreen
                        AdminMenuScreen admit = new AdminMenuScreen(totalSales, totalOrderList);
                        admit.setVisible(true);
                        
                        
                        
                    } else {
                        throw new InvalidTrialException();
                    }
                } catch (InvalidTrialException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid login. Double-check your ID and password.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
                } catch (EmptyTextFieldException ex) {
                    JOptionPane.showMessageDialog(null, "Please ensure that both the ID and password fields are filled before attempting to log in.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        
        setVisible(true);
    }
}
