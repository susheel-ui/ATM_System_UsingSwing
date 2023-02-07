import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Home {

	private JFrame frame;
	private JTextField textField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}
	
	// my own functions are here below:-;
/*   */
	public void defaultAccounts(List<Accounts> accounts) {
		accounts.add(new Accounts(151515,"susheel",1000.00,0000));
		accounts.add(new Accounts(151512,"kapil",1200.00,0000));
		
	}
	public int findAccount(int ac,LinkedList<Accounts> list) {
		for(int i = 0 ; i<list.size();i++) {
			if(list.get(i).getAccountNo()==ac) {
				return i;
				
			}
			
			
		}
		return -1;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		/* code for set a LinkList Accounts type  
		 * 
		 * */
	
		LinkedList<Accounts> accounts = new LinkedList<>();
		defaultAccounts(accounts);
		
	
		
		frame = new JFrame();
		frame.setBounds(100, 100, 616, 379);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		HomePanel h = new HomePanel(accounts,frame);
		frame.getContentPane().add(h);
		h.setVisible(true);
		
		
		JLabel lblNewLabel = new JLabel("ATM System");
		lblNewLabel.setForeground(new Color(0, 204, 204));
		lblNewLabel.setBackground(new Color(128, 64, 64));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(177, 10, 213, 25);
		frame.getContentPane().add(lblNewLabel);
		
		
		
	}
}
