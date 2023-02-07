import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class Credit extends JPanel {
	private JTextField amount;
	private JTextField textField_Pin;
	int pincounter =0;
	

	/**
	 * Create the panel.
	 */
	public Credit(LinkedList<Accounts> accounts,Accounts ac ,JFrame frame) {
		setLayout(null);
		setBounds(10, 45, 582, 287);
		JLabel lblNewLabel = new JLabel("Amount ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(44, 91, 97, 45);
		add(lblNewLabel);
		
		amount = new JTextField();
		amount.setColumns(10);
		amount.setBounds(163, 107, 254, 19);
		add(amount);
		
		JButton btnCredit = new JButton("Credit");
		btnCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int getPin = Integer.parseInt(textField_Pin.getText());
				if(pincounter<3) {
					if(getPin == ac.getPin()) {
						if(ac.getBalance()>0) {
							double amnt = Double.parseDouble(amount.getText());
							double finalamnt = ac.getBalance();
							finalamnt += amnt;
							ac.setBalance(finalamnt);
							String str = " Credit : "+amnt+" , Current Balance : "+finalamnt+" \n";
							ac.setHistory(str);
							JOptionPane.showMessageDialog(null," Transaction Succesfull ");
								
							
							
							// for  close window and redirect Menu page 
							Menu m = new Menu(accounts,ac,frame);
							frame.getContentPane().add(m);
							setVisible(false);
							m.setVisible(true);
							
						}
						else {
							JOptionPane.showMessageDialog(null," please Insert some amount !");

						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Incorect Pin");
						pincounter++;
						
					}
				}else {
					JOptionPane.showMessageDialog(null,"you are bloked");
				}
				
				

				
			}
		});
		btnCredit.setBackground(new Color(0, 204, 204));
		btnCredit.setBounds(359, 210, 168, 43);
		add(btnCredit);
		
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
		btnBack.setBounds(44, 208, 168, 43);
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
		
		textField_Pin = new JTextField();
		textField_Pin.setColumns(10);
		textField_Pin.setBounds(163, 153, 254, 19);
		add(textField_Pin);
		
		JLabel lblPin = new JLabel("Pin");
		lblPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPin.setBounds(44, 137, 97, 45);
		add(lblPin);
			
	}
}
