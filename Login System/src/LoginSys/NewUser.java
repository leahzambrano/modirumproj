package LoginSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.util.Scanner;
import java.io.File;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

public class NewUser {

	private JFrame frm_newuser;
	private JTextField txt_newuser;
	private JPasswordField txt_newpass;
	private JPasswordField txt_cpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser window = new NewUser();
					window.frm_newuser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm_newuser = new JFrame();
		frm_newuser.setResizable(false);
		frm_newuser.getContentPane().setBackground(Color.BLACK);
		frm_newuser.setBounds(0, 0, 610, 401);
		frm_newuser.setLocationRelativeTo(null);
		frm_newuser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_newuser.getContentPane().setLayout(null);

		JLabel lbl_newuser = new JLabel("Username");
		lbl_newuser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_newuser.setForeground(Color.WHITE);
		lbl_newuser.setBounds(15, 31, 122, 26);
		frm_newuser.getContentPane().add(lbl_newuser);

		JLabel lbl_newpass = new JLabel("Password");
		lbl_newpass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_newpass.setForeground(Color.WHITE);
		lbl_newpass.setBounds(15, 89, 122, 17);
		frm_newuser.getContentPane().add(lbl_newpass);

		txt_newuser = new JTextField();
		txt_newuser.setBounds(199, 28, 270, 37);
		frm_newuser.getContentPane().add(txt_newuser);
		txt_newuser.setColumns(10);

		JButton btn_submit = new JButton("Submit");
		btn_submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String logfile = "D:\\1.txt";
				String inputuser = txt_newuser.getText();
				String inputpassword = txt_newpass.getText();
				String inputcpassword = txt_cpass.getText();


				if (inputuser.isEmpty() || inputpassword.isEmpty() || inputcpassword.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Cannot be blank!", "Create User", JOptionPane.ERROR_MESSAGE);
				} else if (!inputpassword.equals(inputcpassword)) {
					JOptionPane.showMessageDialog(null, "Password Confirmation is incorrect!", "Create User",
							JOptionPane.ERROR_MESSAGE);
				}

				else {
					try {

						Scanner fileScan = new Scanner(new File(logfile));
						boolean found = false;
						while (fileScan.hasNextLine()) {

							String line = fileScan.nextLine();
							String username = line.substring(0, line.indexOf(','));

							if (inputuser.equals(username)) {
								found = true; // added this to set found
								break;
							}
						}

						if (found) {
							JOptionPane.showMessageDialog(null, "Username already exists!", "Create User",
									JOptionPane.ERROR_MESSAGE);
						}

						else {
							// Assume default encoding.
							FileWriter fileWriter = new FileWriter(logfile, true);

							BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

							bufferedWriter.newLine();
							bufferedWriter.write(inputuser);
							bufferedWriter.write(",");
							bufferedWriter.write(inputpassword);

							JOptionPane.showMessageDialog(null, "User has been created.", "Create User",
									JOptionPane.INFORMATION_MESSAGE);
							
							frm_newuser.dispose();
							
							bufferedWriter.close();
							fileScan.close();
						}
					} catch (IOException ex) {
						System.out.println("Error writing to file '" + logfile + "'");
					}

					catch (Exception ea) {
						System.out.println("Error");
					}

				}
			}
				
				
			
		});
		btn_submit.setBounds(72, 266, 122, 36);
		frm_newuser.getContentPane().add(btn_submit);

		JButton btn_clear = new JButton("Clear");
		btn_clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txt_newuser.setText(null);
				txt_newpass.setText(null);
				txt_cpass.setText(null);
			}
		});
		btn_clear.setBounds(230, 266, 122, 36);
		frm_newuser.getContentPane().add(btn_clear);

		JLabel lbl_confirmpass = new JLabel("Confirm Password");
		lbl_confirmpass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_confirmpass.setForeground(Color.WHITE);
		lbl_confirmpass.setBounds(15, 142, 169, 17);
		frm_newuser.getContentPane().add(lbl_confirmpass);
		
		txt_newpass = new JPasswordField();
		txt_newpass.setBounds(199, 81, 270, 37);
		frm_newuser.getContentPane().add(txt_newpass);
		
		txt_cpass = new JPasswordField();
		txt_cpass.setBounds(199, 134, 270, 37);
		frm_newuser.getContentPane().add(txt_cpass);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(46, 233, 477, 7);
		frm_newuser.getContentPane().add(separator);
		
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_newuser.dispose();
				
			}
		});
		btn_cancel.setBounds(385, 266, 122, 37);
		frm_newuser.getContentPane().add(btn_cancel);
	}
}
