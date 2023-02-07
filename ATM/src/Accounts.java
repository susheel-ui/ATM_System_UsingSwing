import java.util.ArrayList;

public class Accounts {
		private long AccountNo;
		private String name;
		private double Balance;
		private int pin;
		
		private ArrayList<String> History = new ArrayList<>();
		public Accounts(long accountNo, String name, double balance,int pin) {
			
			AccountNo = accountNo;
			this.name = name;
			Balance = balance;
			this.pin = pin;
			
		}
		
		
		public void setBalance(double balance) {
			Balance = balance;
		}


		public void setHistory(String str) {
			History.add(str);
			
		}


		public int getPin() {
			return pin;
		}


		public long getAccountNo() {
			return AccountNo;
		}
		public String getName() {
			return name;
		}
		public double getBalance() {
			return Balance;
		}
		public ArrayList<String> getHistory() {
			return History;
		}
		
		
		
		
}
