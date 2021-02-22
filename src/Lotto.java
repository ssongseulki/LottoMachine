import java.util.Random;
import java.util.Scanner;

class Lotto {
	private Scanner sc = new Scanner(System.in);
	private final int MAX = 6;
	private int num = 0;
	private int [] lotto;
	private Random random;
	
	Lotto() {
		lotto = new int [MAX];
		random = new Random();
		
		printMain();
		execute();
		lineNum();
	}
	public void execute() {
		makeLotto();
		sortLotto();
		printLotto();
	}
	public void printMain() {
		System.out.println("���Ͻô� �ζ� �� ���� �Է��ϼ���.");
		
		for(num = 1 ; num <= 5 ; num++) 
			System.out.println(num + "." + num + "��");
			num = sc.nextInt();
	}
	
	public boolean chkNum(int idx) {
		for(int i = 0 ; i < idx ; i++ ) {
			if( lotto[idx] == lotto[i]) {
				return false;
			}
		}
		return true;
	}
	
	public void makeLotto() {
		for ( int i = 0 ; i < lotto.length ; i++) {
			lotto[i] = random.nextInt(45) + 1; 
			if(!chkNum(i)) {
				i--;
			}
		}
	}
	
	public void sortLotto() {
		int tmp; 
		
		for( int i = 0 ; i < lotto.length-1 ; i++ ) {
			for( int j = i + 1 ; j < lotto.length ; j++ ) {
				if( lotto[i] > lotto[j] )
				{
					tmp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				}
			}
		}
	}
	
	public void printLotto() {
			for( int i = 0 ; i < lotto.length ; i++ ) {
				System.out.print( lotto[i] + " " );
			}
			System.out.println();
	}
	
	public void lineNum() {
		for(int l = 1 ; l < num ; l++) {
			execute();
		}
		System.out.println();
		System.out.println("Good Luck! ");
	}
	
}
