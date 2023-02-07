import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Debit extends JPanel {
	private JTextField amount;
	private JPasswordField textField_Pin;
	int pincounter;
	
	

	/**
	 * Create the panel.
	 */
	public Debit(LinkedList<Accounts> accounts,Accounts ac,JFrame frame) {
		
		
		setLayout(null);
		setBounds(10, 45, 582, 287);
		
		JLabel lblNewLabel = new JLabel("Amount ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(42, 85, 97, 45);
		add(lblNewLabel);
		
		amount = new JTextField();
		amount.setBounds(173, 101, 254, 19);
		add(amount);
		amount.setColumns(10);
		
		
		
		
		JButton btnNewButton = new JButton("Debit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double  amnt = Double.parseDouble(amount.getText());		 // for convert String to double 
				@SuppressWarnings("deprecation")
				int getPin = Integer.parseInt(textField_Pin.getText());
				
				// code for debit amount in bank 
				if(pincounter<3) {
					if(getPin == ac.getPin()) {
						if( amnt <= ac.getBalance()) {
							double bal = ac.getBalance();
							bal -= amnt;
							ac.setBalance(bal);
							String str = "Debit "+ amnt+ " , Curent Balance : "+bal+" \n";
							ac.setHistory(str);
							
							JOptionPane.showMessageDialog(null," Transaction Succesfull ");
							Menu m = new Menu(accounts,ac,frame);
							frame.getContentPane().add(m);
							setVisible(false);
							m.setVisible(true);
							
							
//							System.out.println(ac.getHistory());                      // for cmd test run
						}else {
							JOptionPane.showMessageDialog(null," Insufficent Balance !");
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"Incorect Pin !");
						pincounter++;
					}

					
				}else {
					JOptionPane.showMessageDialog(null,"you are block");
					
					
				}
								

				
			}
		});
		btnNewButton.setBackground(new Color(0, 204, 204));
		btnNewButton.setBounds(387, 222, 168, 43);
		add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu h = new Menu(accounts,ac,frame);
				frame.getContentPane().add(h);
				h.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBackground(new Color(0, 204, 204));
		btnBack.setBounds(45, 222, 168, 43);
		add(btnBack);
		
		JLabel lblNewLabel_name = new JLabel("Name : ");
		lblNewLabel_name.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_name.setBounds(32, 10, 63, 23);
		add(lblNewLabel_name);
		
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
		
		textField_Pin = new JPasswordField();
		textField_Pin.setColumns(10);
		textField_Pin.setBounds(173, 156, 254, 19);
		add(textField_Pin);
		
		JLabel lblPin = new JLabel("Pin");
		lblPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPin.setBounds(42, 140, 97, 45);
		add(lblPin);
		
		
		
	}
}
