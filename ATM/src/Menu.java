import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class Menu extends JPanel {
	Accounts ac;
	long selected_acont;
	

	/**
	 * Create the panel.
	 */
	public Menu(LinkedList<Accounts> accounts,Accounts ac,JFrame  frame) {
		
		this.ac = ac;
		this.selected_acont = ac.getAccountNo();
		setLayout(null);
		
		setBounds(10, 45, 582, 287);
		
		JButton btnNewButton = new JButton("Debit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Debit d = new Debit(accounts,ac,frame);
				frame.getContentPane().add(d);
				setVisible(false);
				d.setVisible(true);
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 204, 204));
		btnNewButton.setBounds(10, 163, 168, 43);
		add(btnNewButton);
		
		JButton btnCredit = new JButton("Credit");
		btnCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Credit c = new Credit(accounts,ac,frame);
				frame.getContentPane().add(c);
				setVisible(false);
				c.setVisible(true);
			}
		});
		btnCredit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCredit.setBackground(new Color(0, 204, 204));
		btnCredit.setBounds(10, 222, 168, 43);
		add(btnCredit);
		
		JButton btnStatements = new JButton("Statements");
		btnStatements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// action on Transtaction button 
				
				Transactions t = new Transactions(accounts,ac,frame);
				frame.getContentPane().add(t);
				setVisible(false);
				t.setVisible(true);
			
				
				
				
				
			}
		});
		btnStatements.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStatements.setBackground(new Color(0, 204, 204));
		btnStatements.setBounds(387, 110, 168, 43);
		add(btnStatements);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePanel h = new HomePanel(accounts,frame);
				frame.getContentPane().add(h);
				h.setVisible(true);
				setVisible(false);
				
			}
		});
		btnBack.setFont(new Font("Tahoma",Font.BOLD,15));
		btnBack.setBackground(new Color(0, 204, 204));
		btnBack.setBounds(387, 222, 168, 43);
		add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Name : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(32, 10, 63, 23);
		add(lblNewLabel);
		
		JLabel lblAccountNo = new JLabel("Account No");
		lblAccountNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAccountNo.setBounds(32, 44, 103, 23);
		add(lblAccountNo);
		
		JLabel lblNewLabel_1 = new JLabel(ac.getName());
		lblNewLabel_1.setBounds(188, 17, 225, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(""+ac.getAccountNo());
		lblNewLabel_1_1.setBounds(188, 51, 225, 13);
		add(lblNewLabel_1_1);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double  bal = ac.getBalance();
				JOptionPane.showMessageDialog(null, "Your Current Balance:  \n "+ac.getBalance());
			}
		});
		btnBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBalance.setBackground(new Color(0, 204, 204));
		btnBalance.setBounds(387, 163, 168, 43);
		add(btnBalance);
			
	}
}
