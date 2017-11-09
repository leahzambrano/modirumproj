package LoginSys;

import java.awt.EventQueue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class LandingPage {

	private JFrame frm_landingpage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandingPage window = new LandingPage();
					window.frm_landingpage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LandingPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		frm_landingpage = new JFrame();
		frm_landingpage.setResizable(false);
		frm_landingpage.getContentPane().setBackground(Color.BLACK);
		frm_landingpage.setBounds(0, 0, 609, 379);
		frm_landingpage.setLocationRelativeTo(null);
		frm_landingpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_landingpage.getContentPane().setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWelcome.setBounds(15, 17, 115, 48);
		frm_landingpage.getContentPane().add(lblWelcome);

		JLabel lblYouHaveSuccessfully = new JLabel("You have successfully login in our system at:");
		lblYouHaveSuccessfully.setForeground(Color.WHITE);
		lblYouHaveSuccessfully.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblYouHaveSuccessfully.setBounds(26, 100, 510, 32);
		frm_landingpage.getContentPane().add(lblYouHaveSuccessfully);

		JLabel lbl_time = new JLabel(dtf.format(now));
		lbl_time.setForeground(Color.WHITE);
		lbl_time.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_time.setBounds(26, 135, 266, 37);
		frm_landingpage.getContentPane().add(lbl_time);

		JButton btn_Exit = new JButton("Exit");
		btn_Exit.setBorder(new EmptyBorder(0, 0, 0, 0));
		btn_Exit.setBackground(SystemColor.activeCaptionBorder);
		btn_Exit.setForeground(Color.BLACK);
		btn_Exit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frm_landingpage = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frm_landingpage, "Are you sure you want to exit?", "Login Systems",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}

			}
		});
		btn_Exit.setBounds(463, 254, 90, 35);
		frm_landingpage.getContentPane().add(btn_Exit);

		JButton btn_change = new JButton("Change User");
		btn_change.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btn_change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Login.main(null);
				frm_landingpage.dispose();
			}
		});
		btn_change.setBackground(SystemColor.activeCaptionBorder);
		btn_change.setForeground(Color.BLACK);
		btn_change.setBounds(26, 257, 175, 32);
		frm_landingpage.getContentPane().add(btn_change);

		JLabel lbl_currentuser = new JLabel("");

		String loguser = "D:\\currentuser.txt";

		try {
			Scanner fileScan = new Scanner(new File(loguser));
			while (fileScan.hasNextLine()) {

				String line = fileScan.nextLine();
				String currentuser = line.substring(0, line.length());

				lbl_currentuser.setText(currentuser+"!");

				fileScan.close();
			}
		} catch (Exception e) {
			System.out.println("Error");

			lbl_currentuser.setForeground(Color.WHITE);
			lbl_currentuser.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lbl_currentuser.setBounds(125, 17, 115, 48);
			frm_landingpage.getContentPane().add(lbl_currentuser);

		}
	}
}
