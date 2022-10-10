package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Main_Menu_Dialog extends JDialog {
	static final long serialVersionUID = -9205958915197635758L;
	public int Choice = 0;

	public Main_Menu_Dialog() {
		super((JDialog)null);
		getContentPane().setBackground(new Color(255, 255, 255));
		setModal(true);
		setResizable(false);
		setTitle("Main Menu");
		setAlwaysOnTop(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setBounds(400, 300, 1229, 720);
		setLocation(x, y);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel Logo = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("logo.png")));
		Logo.setHorizontalAlignment(SwingConstants.CENTER);
		Logo.setBounds(496, 78, 200, 200);
		getContentPane().add(Logo);

		JButton WriteBtn = new JButton("New Entry");

		WriteBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		WriteBtn.setBounds(496, 364, 200, 50);
		getContentPane().add(WriteBtn);

		JButton DisplayBtn = new JButton("Display Entries");
		DisplayBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DisplayBtn.setBounds(213, 364, 200, 50);
		getContentPane().add(DisplayBtn);

		JButton DeleteBtn = new JButton("Delete Entry");
		DeleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DeleteBtn.setBounds(783, 364, 200, 50);
		getContentPane().add(DeleteBtn);

		JButton SearchBtn = new JButton("Search Entries");
		SearchBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SearchBtn.setBounds(213, 463, 200, 50);
		getContentPane().add(SearchBtn);

		JButton btnModifyEntries = new JButton("Modify Entries");

		btnModifyEntries.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModifyEntries.setBounds(496, 463, 200, 50);
		getContentPane().add(btnModifyEntries);

		JButton ExportBtn = new JButton("Export Database");

		ExportBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ExportBtn.setBounds(783, 463, 200, 50);
		getContentPane().add(ExportBtn);

		JButton ExitBtn = new JButton("EXIT");
		ExitBtn.setForeground(new Color(255, 0, 0));
		ExitBtn.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ExitBtn.setBounds(496, 576, 200, 50);
		getContentPane().add(ExitBtn);

		JButton AboutBtn = new JButton("About Project");
		AboutBtn.setForeground(Color.GRAY);
		AboutBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AboutBtn.setBackground(Color.WHITE);
		AboutBtn.setBounds(1065, 632, 138, 38);
		getContentPane().add(AboutBtn);

		ExitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Do you really want to exit?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					Main_Menu_Dialog.this.Choice = 0;
					dispose();
				} else {
					Main_Menu_Dialog.this.Choice = -1;
				}
			}
		});
		DisplayBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main_Menu_Dialog.this.Choice = 1;
				dispose();
			}
		});
		WriteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main_Menu_Dialog.this.Choice = 2;
				dispose();
			}
		});
		DeleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main_Menu_Dialog.this.Choice = 3;
				dispose();
			}
		});

		SearchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main_Menu_Dialog.this.Choice = 4;
				dispose();
			}
		});
		btnModifyEntries.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main_Menu_Dialog.this.Choice = 5;
				dispose();
			}
		});
		ExportBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main_Menu_Dialog.this.Choice = 6;
				dispose();
			}
		});
		AboutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				About_Dialog info = new About_Dialog();
				info.showDialog();
			}
		});
	}

	public void showDialog() {
		this.setVisible(true);
	}
}
