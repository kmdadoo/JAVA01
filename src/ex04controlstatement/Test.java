package ex04controlstatement;

public class Test {

	public static void main(String[] args) {


int x=1;  
while(x<=4) {
	int y=1;  
	while(y<=4) {
		if(x==y) { 
			System.out.print("1 ");
		}				
		else { 
			System.out.print("0 ");
		}
		y++;
	}
	System.out.println(); 
	x++;
}	

		
		
		
		
		
	}

}
