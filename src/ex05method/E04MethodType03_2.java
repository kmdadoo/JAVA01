package ex05method;

import java.util.Scanner;

/*
연습문제] 사용자로부터 2~9사이의 숫자중 2개를 입력받아
그에 해당하는 구구단을 출력하는 메서드를 작성하시오.
무조건 첫번째 입력받는수가 작아야한다.
입력예]
	첫번째숫자 : 3
	두번째숫자 : 12
	3*1=3 3*2=6........
	........
	...................12*9=108
메소드명 : inputGugudan(int sNum, int eNum)
 */

public class E04MethodType03_2
{
	static void inputGugudan(int sNum, int eNum)
	{
		// 2~9단까지 반복 => sNum~eNum단까지 반복
		for(int dan=sNum ; dan<=eNum ; dan++) {
			// 수에 해당하는 for문(1~9까지 중가한다)
			for(int su=1 ; su<=9 ; su++) {
				// 구구단 출력 후 스페이스 한칸
				System.out.printf("%d*%d=%2d ", dan, su, dan*su);
			}
			// 하나의 단을 출력한 후 줄바꿈 처리
			System.out.println();			
		}
	}
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("시작단:");
		int s = scanner.nextInt();
		System.out.print("끝단:");
		int e = scanner.nextInt();
		/*
		 반환값이 없는 메서드 이므로 단독적으로 호출만한다.
		 앞에서 입력받은 2개의 정수를 인수(Argument)로 전달한다.
		 */
		inputGugudan(s, e);

	}

}
