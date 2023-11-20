package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
	예외처리를 할때 필요에 따라 여러개의 catch블럭을 사용할 수 있다. 
	이 경우 반드시 자식 예외 클래스부터 catch블럭을 추가해야한다.
	Exception클래슨는 모든 예외를 catch할수 있기때문에 반드시 마지막
	블럭에 사용해야 한다. 
	클래스의 상속구조를 보고싶다면 Ctrl+t로 확인할 수 있다.
 */
public class Ex04MultiCatch {

public static void main(String[] args) {
 
		Scanner scanner = new Scanner(System.in);
		//크기가 3인 정수형 배열을 생성한다. 
		int array[] = new int[3];		
		try {
			//3개의 문자열을 입력받는다. 
			for(int i=0 ; i<array.length ; i++) {
				System.out.print("array["+ i +"]에 저장할 숫자입력:");
				//입력한 문자열을 정수로 변경한 후 배열에 저장한다.
				//"1a"와 같이 입력하면 정수로 변경할 수 없어 예외발생됨.
				array[i] = Integer.parseInt(scanner.nextLine());
			}

			//1번 인덱스에 0을 입력했다면 예외발생됨.
			System.out.println("배열에 저장된 두 숫자나누기:"+
					array[0]/array[1]);  

			//나이 입력시 문자를 입력하면 예외발생됨
			System.out.print("나이를 입력하세요:");
			int age = scanner.nextInt();			 
			System.out.println("당신의 나이는:"+ age);
			
			//배열의 크기가 3이므로 인덱스는 2까지만 존재하므로 예외발생됨
			array[3] = age;
		}
		catch(InputMismatchException e) {
			System.out.println("숫자로만 입력해야 합니다.");
		}
		catch(ArithmeticException e) {
			System.out.println("산술연산이 불가능 합니다.");
		}
		catch(NumberFormatException e) {
			System.out.println("숫자형태의 문자만 입력가능합니다.");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스를 초과하였습니다");
		}
		catch(Exception e) {	
			/*
			Exception클래스는 모든 예외클래스의 부모이므로 catch절의 
			마지막에 기술해야 한다. 위로 이동시키면 에러가 발생한다. 
			 */
			System.out.println("예외가 발생하였습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		/*
		앞에서 예외가 발생하더라도 예외처리를 했으므로 프로그램은 
		끝까지 실행된 후 정상적으로 종료된다. 실행의 흐름이 마지막까지
		이어지게 하는것이 예외처리의 목적이다. 
		 */
		System.out.println("===프로그램 끝===");
	}

}
