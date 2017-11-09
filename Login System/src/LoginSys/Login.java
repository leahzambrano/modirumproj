package LoginSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.Cursor;
import java.awt.Color;

import LoginSys.LandingPage;



public class Login {

	private JFrame frm_login;
	private JTextField txt_user;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frm_login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm_login = new JFrame();
;
		frm_login.setResizable(false);
		frm_login.getContentPane().setBackground(Color.BLACK);
		frm_login.setBounds(0, 0, 633, 427);
		frm_login.setLocationRelativeTo(null);
		frm_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_login.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("LOGIN SYSTEM");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(209, 8, 257, 30);
		frm_login.getContentPane().add(lblNewLabel);

		JLabel lbl_user = new JLabel("Username");
		lbl_user.setForeground(Color.WHITE);
		lbl_user.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_user.setBounds(53, 79, 151, 35);
		frm_login.getContentPane().add(lbl_user);

		JLabel lbl_password = new JLabel("Password");
		lbl_password.setForeground(Color.WHITE);
		lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_password.setBounds(53, 134, 151, 41);
		frm_login.getContentPane().add(lbl_password);

		txt_user = new JTextField();
		txt_user.setBackground(Color.WHITE);
		txt_user.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txt_user.setBounds(197, 83, 281, 31);
		frm_login.getContentPane().add(txt_user);
		txt_user.setColumns(10);

		txt_password = new JPasswordField();
		txt_password.setBackground(Color.WHITE);
		txt_password.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txt_password.setBounds(197, 139, 281, 35);
		frm_login.getContentPane().add(txt_password);

		JButton btn_login = new JButton("LOGIN");
		btn_login.setForeground(Color.WHITE);
		btn_login.setBackground(new Color(0, 0, 0));
		btn_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_login.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String logfile = "D:\\1.txt";
				String loguser = "D:\\currentuser.txt";
				String inputpassword = txt_password.getText();
				String inputusername = txt_user.getText();

				if (inputusername.isEmpty() || inputpassword.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Cannot be blank!",
							"Login Error", JOptionPane.ERROR_MESSAGE);
				} else {

					try {

						Scanner fileScan = new Scanner(new File(logfile));
						boolean found = false;
						while (fileScan.hasNextLine()) {

							String line = fileScan.nextLine();
							String Username = line.substring(0, line.indexOf(','));
							String Password = line.substring(line.indexOf(',')+1, line.length());

							if (inputusername.equals(Username) && inputpassword.equals(Password)) {
								found = true; // added this to set found
								break;

							} // removed the else statement
						}

						if (found) {
							
							
							FileWriter fileWriter = new FileWriter(loguser);

							BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

							bufferedWriter.write(inputusername);

							
							bufferedWriter.close();
							
							//====================================
							
							txt_password.setText(null);
							txt_user.setText(null);

							LandingPage.main(null);
						
							
							
							frm_login.dispose();
						}

						else {
							JOptionPane.showMessageDialog(null,
									"Invalid Login Credentials!",
									"Login Error", JOptionPane.ERROR_MESSAGE);
							txt_password.setText(null);
							txt_user.setText(null);

						}

						fileScan.close();
					} catch (Exception e) {
						System.out.println("Error");
					}

				}

			}

		
		});
		btn_login.setBounds(77, 305, 121, 32);
		frm_login.getContentPane().add(btn_login);

		JButton btn_clear = new JButton("CLEAR");
		btn_clear.setBackground(Color.BLACK);
		btn_clear.setForeground(Color.WHITE);
		btn_clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_clear.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txt_user.setText(null);
				txt_password.setText(null);

			}

		});
		btn_clear.setBounds(247, 305, 114, 32);
		frm_login.getContentPane().add(btn_clear);

		JButton btn_exit = new JButton("EXIT");
		btn_exit.setForeground(Color.WHITE);
		btn_exit.setBackground(Color.BLACK);
		btn_exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_exit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_login = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frm_login,
						"Are you sure you want to exit?", "Login Systems",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btn_exit.setBounds(407, 305, 121, 32);
		frm_login.getContentPane().add(btn_exit);

		JSeparator separator = new JSeparator();
		separator.setBounds(53, 54, 502, 2);
		frm_login.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(53, 218, 502, 0);
		frm_login.getContentPane().add(separator_1);
		
		JButton btn_forgot = new JButton("Forgot Password?");
		btn_forgot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_forgot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ForgotPass.main(null);
			}
		});
		btn_forgot.setBorder(null);
		btn_forgot.setBackground(Color.BLACK);
		btn_forgot.setForeground(Color.BLUE);
		btn_forgot.setBounds(395, 218, 160, 23);
		frm_login.getContentPane().add(btn_forgot);
		
		JButton btn_newuser = new JButton("Not a user yet?");
		btn_newuser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_newuser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_newuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUser.main(null);
			}
		});
		btn_newuser.setForeground(Color.BLUE);
		btn_newuser.setBorder(null);
		btn_newuser.setBackground(Color.BLACK);
		btn_newuser.setBounds(412, 190, 143, 23);
		frm_login.getContentPane().add(btn_newuser);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(53, 269, 502, 2);
		frm_login.getContentPane().add(separator_2);

	}
	
	
	

	
}