import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HomePanel extends JPanel {

	private JFrame frame;
	private JTextField textField;
	int account_find;
	
	
	public int findAccount(long ac,LinkedList<Accounts> list) {
		for(int i = 0 ; i<list.size();i++) {
			if(list.get(i).getAccountNo()==ac) {
				return i;
				
			}
			
			
		}
		return -1;
	}
	
	/**
	 * Create the panel.
	 */
	public HomePanel(LinkedList<Accounts> accounts,JFrame frame) {
		
		
		
		
		
		
        JPanel home = new JPanel();
		
		home.setBounds(10, 45, 582, 287);
		frame.getContentPane().add(home);
		home.setLayout(null);
		home.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Account No");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(35, 94, 111, 31);
		home.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Enter");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    
				 try {
					long AccountNo = Integer.parseInt(textField.getText());
					account_find = findAccount(AccountNo,accounts);
					 
					 if(account_find == -1) {
						 JOptionPane.showMessageDialog(null,"There is no Such that Account ");
					 }else {
						 Menu m = new Menu(accounts,accounts.get(account_find),frame);
						 frame.getContentPane().add(m);
						 
						 home.setVisible(false);
						 m.setVisible(true);
//					 m.setBounds(10, 45, 582, 287);
						 
					 }
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
//					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"pls enter value");
					
					
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}
		});
		
	
		
		btnNewButton.setBackground(new Color(0, 204, 204));
		btnNewButton.setBounds(392, 220, 106, 31);
		home.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(195, 98, 303, 27);
		home.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewResistration r = new NewResistration(accounts,frame);
				frame.getContentPane().add(r);
				home.setVisible(false);
				r.setVisible(true);
				
			}
			
		});
		
		
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setForeground(new Color(102, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnNewButton_1.setBounds(113, 220, 175, 31);
		home.add(btnNewButton_1);

	}

}
