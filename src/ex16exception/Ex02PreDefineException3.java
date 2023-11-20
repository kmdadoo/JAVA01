package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02PreDefineException3 {
 
	public static void main(String[] args)  {	

		// nextInt()는 정수를 입력받기 위한 메서드인데 문자를 
		// 입력하는 경우 발생되는 예외
		System.out.println("### InputMismatchException ###");
		Scanner sc = new Scanner(System.in);
		try {
			//정수가 아닌 문자를 입력하면 예외가 발생된다.
			System.out.print("나이를 입력하세요:");
			/*
			예외가 발생하는 지점은 해당 메서드 이지만 관련있는 로직들은
			하나의 블럭으로 간주하여 try문으로 감싸는게 좋다. 그렇지 
			않으면 가독성이 떨어지는 코드가 될수 있다. 
			 */
			int intAge = sc.nextInt(); 	// 예외가 발생할수 있는 지역
			int ageAfter10 = intAge + 10;
			System.out.println("당신의 10년후 나이는:"+ ageAfter10);
		}
		catch(InputMismatchException e) {	// 예외가 발생하면 실행.
			System.out.println("나이를 문자형태로 입력하면 앙데요");
			System.out.println("예외메세지:"+e.getMessage());
			e.printStackTrace();
		} 
		
	}////end of main 
}
