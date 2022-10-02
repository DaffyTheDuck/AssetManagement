package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import db_driver.Assetdb;

/*Shows the login dialog*/
public class Login_Dialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField textbox_password;
	private JTextField textbox_username;

	/* Generates layout */
	public Login_Dialog() {
		/* Create layout */
		super((JDialog)null);
		getContentPane().setBackground(new Color(40, 40, 40));
		setModal(true);
		setResizable(false);
		setTitle("Please Login");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		Assetdb db = new Assetdb();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setForeground(new Color(40, 40, 40));
		setBounds(720, 480, 720, 480);
		setLocation(x, y);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		textbox_username = new JTextField();
		textbox_username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textbox_username.setBounds(285, 130, 180, 35);
		getContentPane().add(textbox_username);
		textbox_username.setColumns(10);
		textbox_password = new JPasswordField();
		textbox_password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textbox_password.setBounds(285, 205, 180, 35);
		getContentPane().add(textbox_password);

		JButton submitbtn = new JButton("SUMBIT");
		submitbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		submitbtn.setBackground(new Color(65, 105, 225));
		submitbtn.setForeground(new Color(255, 255, 255));
		submitbtn.setBounds(285, 279, 180, 35);
		submitbtn.setMnemonic(KeyEvent.VK_ENTER);
		getContentPane().add(submitbtn);
		submitbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!db.checkCreds(getUsername(), getPassword())) {
					JOptionPane.showMessageDialog(Login_Dialog.this, "Invalid username or password", "Login",
							JOptionPane.ERROR_MESSAGE);
				} else {
					dispose();
				}
			}
		});

		lblNewLabel = new JLabel("Log in");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(316, 38, 120, 57);
		getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(160, 138, 78, 18);
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(160, 213, 78, 18);
		getContentPane().add(lblNewLabel_2);

		JButton exitbtn = new JButton("EXIT");
		exitbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		exitbtn.setBackground(new Color(65, 105, 225));
		exitbtn.setForeground(new Color(225, 114, 111));
		exitbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(ABORT);
			}
		});
		exitbtn.setBounds(285, 343, 180, 35);
		getContentPane().add(exitbtn);

	}

	public String getPassword() {
		return new String(textbox_password.getPassword());
	}

	public String getUsername() {
		return textbox_username.getText().trim();
	}

	/* Displays the GUI to user */
	public void showDialog() {
		this.setVisible(true);
	}
}
