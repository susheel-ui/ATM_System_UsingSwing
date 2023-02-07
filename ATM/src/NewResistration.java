import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.SystemColor;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewResistration extends JPanel {
	private JTextField Name;
	private JTextField amount;
	private HomePanel h;
	private JTextField Pin;

	/**
	 * Create the panel.
	 */
	
	
	
	public int findAccount(long ac,LinkedList<Accounts> list) {
		for(int i = 0 ; i<list.size();i++) {
			if(list.get(i).getAccountNo()==ac) {
				return i;
				
			}
			
			
		}
		return -1;
	}
	
	
	public long GenrateAccount(LinkedList<Accounts> accounts ) {
		Accounts ac = accounts.getLast();
		long lastAccount = ac.getAccountNo();
		return lastAccount+1;
		
	}
	
	public NewResistration(LinkedList<Accounts> accounts,JFrame frame) {
		setLayout(null);
		setBounds(10, 45, 582, 287);
		
		
		JLabel lblNewLabel = new JLabel("New Account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(204, 20, 167, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(59, 82, 79, 25);
		add(lblNewLabel_1);
		
		Name = new JTextField();
		Name.setBounds(148, 85, 282, 19);
		add(Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Amount :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(71, 129, 67, 19);
		add(lblNewLabel_2);
		
		amount = new JTextField();
		amount.setBounds(147, 129, 283, 19);
		add(amount);
		amount.setColumns(10);
		
		JButton btnNewButton = new JButton("Resister ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name =  Name.getText().toString();
					double Amnt = Double.parseDouble(amount.getText());
					long AccountNo  = GenrateAccount(accounts);
					if(name.isEmpty()&&Amnt<=0&&AccountNo<=0) {
						JOptionPane.showMessageDialog(null," pls insert values ");

					
					}
					else {
						int find_account =findAccount(AccountNo, accounts);
						if(find_account == -1) {
							int p = Integer.parseInt(Pin.getText());
							
							accounts.add(new Accounts(AccountNo,name,Amnt,p));
							JOptionPane.showMessageDialog(null,"Account is added  Your details are : \n"+"Account No : -"+AccountNo+" \n keep your deatails safe . ");
							h = new HomePanel(accounts,frame);
							h.setVisible(true);
							setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null," Sorry Account is already exit ");

						}
					
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"Invalid entry or insert values");
					
				} catch (HeadlessException e1) {
					
				}
				
				
				
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(446, 244, 101, 33);
		add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h = new HomePanel(accounts,frame);
				frame.getContentPane().add(h);
				h.setVisible(true);
				setVisible(false);
			}
			
		});
		btnBack.setBackground(SystemColor.desktop);
		btnBack.setBounds(59, 244, 101, 33);
		add(btnBack);
		
		Pin = new JTextField();
		Pin.setColumns(10);
		Pin.setBounds(148, 176, 283, 19);
		add(Pin);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pin");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2_1.setBounds(71, 179, 67, 19);
		add(lblNewLabel_2_1);
				
	}
}
