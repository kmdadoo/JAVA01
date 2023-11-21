package ex16exception;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
시나리오]
5번의 게임을 완료한 후 재시작 여부를 물어볼때 만약 0, 1이 아닌
숫자를 입력했을때 개발자정의 예외클래스를 통해 예외처리는 해보자.
 */
class ChoiceException extends Exception {
	public ChoiceException() {
		super("[예외발생]숫자를 잘못 선택하셨습니다.");
	}
}

public class QuRPSException {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		//게임 카운트용 변수
		int gameCount = 0; 
		
		while(true) {
			//1.난수생성
			int com = random.nextInt(10000) % 3 + 1;//1~3사이의 난수
			System.out.println("컴퓨터:"+ com);
			
			//2.사용자입력
			int user = 0;
			System.out.println("가위바위보를 입력하세요.");
			System.out.print("가위(1), 바위(2), 보(3)=>");
			
			/*
			nextInt()는 정수만 입력받을 수 있는 메서드이다. 만약 문자를 
			잘못입력하는 경우 예외가 발생하게되고 입력을 위해 누른 엔터키가
			버퍼에 남게되어 무한루프에 빠지게된다. 이때 nextLine()을 통해
			엔터키를 제거해야 한다. 
			 */
			try {
				user = scanner.nextInt();
				
				//3.승부판단
				//사용자가 정상적으로 입력한 경우
				if(!(user<1 || user>3)) {					
					//승부판단 로직2 : 입력한 수의 차를 이용해 승부를 판단한다. 
					System.out.printf("사용자:%s, 컴퓨터:%s ", 
							displayRPS(user), displayRPS(com));	
					switch(user - com) {
					case 0:
						System.out.println("비겼습니다.");break;
					case 1: case -2:
						System.out.println("이겼습니다.");break;
					case 2: case -1:
						System.out.println("졌습니다.");break;
					}				
					
					gameCount++;//게임카운트 증가		
				}
				else {					
					//1,2,3 이외에 정수를 입력하면 개발자정의 예외객체를
					//생성한 후 throw한다. 
					ChoiceException ce = new ChoiceException();
					throw ce;
				}
			}
			catch(ChoiceException e) {
				//ChoiceException객체를 throw하면 여기서 catch한다. 
				System.out.println("ChoiceException 발생됨");
				System.out.println("가위바위보 할줄 몰라요?? 제대로 내세요 ㅋ");
			}
			catch(InputMismatchException e) {
				/*
				문자를 잘못 입력해서 예외가 발생하는 경우에만 엔터키를 
				제거해주면 된다. 
				 */
				scanner.nextLine();
				//e.printStackTrace();
				System.out.println("입력 예외가 발생하였습니다.");
			}
		
			//4.게임재시작 여부 확인			 
			if(gameCount>=5) {
				/*
				게임재시작을 위한 입력은 몇번이 진행될지 모르므로
				while문으로 무한루프를 만들어 준다. 
				 */
				while(true) {
					//0과 1을 입력하지 않아도 게임은 재시작된다. 
					System.out.print("게임재시작(1), 종료(0):");
					try {
						int restart = scanner.nextInt();
						if(restart==0) {
							//프로그램 자체의 종료이므로 게임은 종료된다.
							System.exit(0);
						}
						else if(restart==1) {
							System.out.println("게임 재시작^^");
							gameCount=0;						
							/*
							break는 가장 가까운 반복문을 탈출하므로 여기서의
							탈출은 게임 재시작이 된다. 
							 */
							break;
						}
						else {
							/*
							정수입력시 음수나 0과1이 아닌 값을 입력할때는
							컴파일러가 인식하지 못하므로 우리가 직접 확인후
							예외객체를 생성하고 throw 해야한다. 
							 */
							ChoiceException ce = new ChoiceException();
							throw ce;
						}
					}
					catch (InputMismatchException e) {
						System.out.println("[예외]문자 입력 안되용~!");
						/*
						문자 입력시 예외가 발생하여 엔터키가 버퍼에 남아
						무한루프에 빠지는 오류가 있으므로 버퍼를 비워줘야
						한다. 
						 */
						scanner.nextLine();
					}
					catch (ChoiceException e) {
						System.out.println("[예외]0과 1만 입력하세용~!");
					}
				}
			}
		}	
	}

	public static String displayRPS(int n) {
		String str = "";
		switch(n) {
		case 1: str="가위";break;
		case 2: str="바위";break;
		case 3: str="보";break;
		}
		return str;
	}
}
