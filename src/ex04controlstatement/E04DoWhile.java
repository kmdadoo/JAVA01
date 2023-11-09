package ex04controlstatement;

import java.io.IOException;
import java.util.Scanner;

/*
do~while문
	: 반드시 한번은 실행해야 할 경우 사용하는 반복문으로 조건검사없이
	무조건 한번은 실행된다.
	형식]
		반복을 위한 변수;
		do {
			실행문장;
			반복문 탈출을 위한 증감식
		}while (조건문); <- 문장의 끝에 세미콜론(;)이 들어간다.
*/
public class E04DoWhile
{
	public static void main(String[] args) throws IOException
	{
		/*
		 시나리오] E03예제의 1~10까지 더하는 수열문제를 do~while문으로
		 변경하여 구현하시오.
		 */
		// 누적합을 저장하기 위한 변수
		int sum = 0;
		// 반복을 위한 변수
		int i = 1;
		// 조건없이 무조건 진입하여 실행
		do {
			// 증가하는 변수 i를 누적해서 sum에 저장한다.
			sum += i;
			// 반복문 탈출을 위한 증가
			i++;
		} while(i<=10);  // 반복을 위한 조건 체크
		System.out.println("1~10까지의 누적합:"+ sum);
		
		/*
		 시나리오] 1부터 1000까지 정수중 4의배수이거나 7의
		 배수인 수의 합을 구하여 출력하는 프로그램을 작성하시오.
		 단, do~while문을 사용해야 한다.
		 */
		int total = 0;
		int j = 1;
		do {
			// 4의배수 이거나 7의배수인지 확인
			if(j%4==0 || j%7==0) {
				// 배수확인용 출력문장(디버깅용)
//				System.out.println("j="+ j);
				// 증가하는 j를 누적해서 더한다.
				total += j;
			}
			j++;
		} while(j<=1000);	// 조건확인
		System.out.println("1~1000사이 4or7의 배수합:"+ total);
		
		/*
		 시나리오] 국어, 영어, 수학 점수를 사용자로부터 입력받은 후
		 평균을 구해 A~F학점을 판단하여 출력하는 프로그램을 작성하시오.
		 단, 사용자가 X, x(대소문자 구분없음)를 입력하면 프로그램이
		 종료되어야 하며 do~while문으로 구현해야 한다.
		 */
		// 사용자로 부터 키보드를 통해 입력값을 받기 위한 클래스 선언
		Scanner scanner = new Scanner(System.in);
		int kor, eng, math, avg;
		// 탈출을 위한 문자(아스키코드)를 입력받기 위한 변수
		int exitCode;
		// 조건 확인없이 무조건 진입하여 점수 입력
		do {
			System.out.print("국어점수:");
			kor = scanner.nextInt();
			System.out.print("영어점수:");
			eng = scanner.nextInt();
			System.out.print("수학점수:");
			math = scanner.nextInt();
			
			/*
			 평균점수의 구간을 정하기 위해 10으로 나누는 연산을 진행한다.
			 switch문은 조건식을 사용할 수 없고 산술식만 사용할 수 있으
			 므로 99점 혹은 91점을 10으로 나눈 몫이 9라는 사실을 통해 
			 구간을 대체하는 산술결과를 얻을 수 있다.
			 */
			avg = (kor+eng+math) / (3 * 10);
			switch(avg) {
			case 10: case 9:
				System.out.println("A학점");break;
			case 8:
				System.out.println("B학점");break;
			case 7:
				System.out.println("C학점");break;
			case 6: 
				System.out.println("D학점");break;
			default:
				System.out.println("F학점");
			}
			
			System.out.println("종료하려면 x(X)를 입력하세요.");
			System.out.println("계속하려면 아무키 입력하세요.");
			exitCode = System.in.read();
		
		} while(!(exitCode=='x' || exitCode=='X'));	
		/*
		 X을 입력한 경우 :
		 	!(false || true) => !(true) => false반환
		 	따라서 반복문을 탈출한다.
		 a를 입력한 경우 :
		 	!(false || false) => !(false) => true반환
		 	반복문의 처음으로 돌아간다.
		 */
	}
}