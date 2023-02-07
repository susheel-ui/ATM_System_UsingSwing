import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transactions extends JPanel {
	DefaultListModel m  = new DefaultListModel();
	JList list;
	/**
	 * Create the panel.
	 */
	
	// function for add in list 
	
//	private void  add(int n ) {
//		list.setModel(m);
//		m.addElement(n);
//	}
	
	public Transactions(LinkedList<Accounts> accounts,Accounts ac ,JFrame frame) {
		
		setBounds(10, 45, 582, 287);
		setLayout(null);
		
		JButton btnBack = new JButton("Back");
		
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBackground(new Color(0, 204, 204));
		btnBack.setBounds(404, 234, 168, 43);
		add(btnBack);
		
		
		
		JList list = new JList();
		list.setBounds(29, 35, 499, 223);

		
		 list.setModel(m);
		 frame.getContentPane().add(list);
		 ArrayList<String> history = new ArrayList<>();
		 history = ac.getHistory();
		 
		for(int i = 0; i<history.size();i++) {
			
			 m.addElement((1+i)+"  "+history.get(i));
			
			
		}
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu(accounts,ac,frame);
				frame.getContentPane().add(m);
				setVisible(false);
				m.setVisible(true);
				list.setVisible(false);
			}
		});
		 
		
		
		
		
		
		
		

	}
}
