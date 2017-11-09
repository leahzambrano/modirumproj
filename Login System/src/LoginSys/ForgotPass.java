package LoginSys;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class ForgotPass {

	private JFrame frm_forgotpass;
	private JTextField txt_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPass window = new ForgotPass();
					window.frm_forgotpass.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ForgotPass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm_forgotpass = new JFrame();
		frm_forgotpass.setType(Type.POPUP);
		frm_forgotpass.setResizable(false);
		frm_forgotpass.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frm_forgotpass.getContentPane().setBackground(Color.BLACK);
		frm_forgotpass.setBounds(0, 0, 588, 254);
		frm_forgotpass.setLocationRelativeTo(null);
		frm_forgotpass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_forgotpass.getContentPane().setLayout(null);

		JLabel lblPleaseInputYour = new JLabel("Please input your email address:");
		lblPleaseInputYour.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPleaseInputYour.setForeground(Color.WHITE);
		lblPleaseInputYour.setBounds(30, 11, 332, 26);
		frm_forgotpass.getContentPane().add(lblPleaseInputYour);

		txt_email = new JTextField();
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_email.setBounds(30, 47, 310, 43);
		frm_forgotpass.getContentPane().add(txt_email);
		txt_email.setColumns(10);

		JButton btn_submit = new JButton("Submit");
		btn_submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String inputemail = txt_email.getText();

				if (inputemail.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Cannot be blank!", "Forgot Password Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (inputemail.equals("sample@email.com")) {
					JOptionPane.showMessageDialog(null, "Please check your email to reset your password",
							"Forgot Password", JOptionPane.INFORMATION_MESSAGE);

					frm_forgotpass.dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Invalid Email!", "Forgot Password Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btn_submit.setBounds(30, 125, 127, 39);
		frm_forgotpass.getContentPane().add(btn_submit);
	}
}
