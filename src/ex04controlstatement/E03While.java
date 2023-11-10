package ex04controlstatement;

/*
while문
	: 반복의 횟수가 명확하게 정해져있지 않았을때 주로 사용하는 
	반복문으로 반복을 위한 초기값, 조건, 증감식을 따로 작성하는 
	형식을 가지고 있다. 
 	형식]
 		반복을 위한 변수의 초기값;
 		while(반복의조건){
 			실행문장;
			증감식; <= 반복문 탈출을 위한 문장
		}
	조건이 true일때 반복하게되고, 반복문의 처음으로 돌아가면 조건을 
	확인한다.
	반복의 조건이 false일때 while문을 탈출하게 된다.
*/
public class E03While
{

	public static void main(String[] args)
	{
		// 반복을 위한 변수 i를 생성한 후 1로 초기화
		int i = 1;
		// 반복을 위한 조건식을 작성 : i가 10이하일때만 반복
		while(i<=10) {
			System.out.println("변수i="+ i);
			// 반복문 탈출을 위한 증감식
			i++;
		}
		
		/*
		시나리오] 1~10까지의 합을 구하는 프로그램을 while문으로
			작성하시오.
		 */	
		// 누적합을 계산하기 위한 변수 생성
		int sum = 0;
		// 반복의 초기값
		int j = 1;
		// 반복의 조건
		while(j<=10) {
			// 복합대입연산자를 통해 증가하는 j를 sum에 누적해서 더함.
			sum += j;    
			// 일반적인 방식의 누적합
			//sum = sum + j; 
			// 반복의 증가식
			j++;
		}
		
		System.out.println("1~10까지의합sum="+ sum);
		
		/*
		시나리오] 1~100까지의 정수중 3의배수이거나 4의배수인
		정수의 합을 구하는 프로그램을 while문을 이용해서 작성하시오.
		 */	
		// 누적합을 계산하기 위한 변수
		int total = 0;
		// k가 100이하일때만 반복하므로 100번 반복이 된다.
		int k = 1;
		while(k<=100) {
			// 3이배수 혹은 4의배수이므로 논리Or가 사용된다.
			if(k%3==0 || k%4==0) {
				total += k;
				System.out.println("k="+ k);
			}
			k++;			
		}
		System.out.println("3또는4의배수의합:"+ total);
		
		/*
		시나리오] 구구단을 출력하는 프로그램을
		while문으로 작성하시오.
		 */	
		// 단을 표현하는 변수
		int dan = 2;
		// 단의 대한 조건(2~9단까지)
		while(dan<=9) {
			// 수를 표현한 변수
			int su = 1;
			// 수에 대한 조건(1~9까지 단이 고정된 상태에서 증가한다)
			while(su<=9) {
				// 구구단을 출력한다.
				System.out.printf("%-2d*%-2d=%2d", dan, su, (dan*su));
				// 숫자하나를 출력한 후 스페이스(공백)를 출력한다.
				System.out.print(" ");
				// 수에 대한 증가
				su++;
			}
			System.out.println();	// 줄바꿈
			// 단을 1증가 시킨다.
			dan++;			
		}
		System.out.println("\n=========================\n");
		
		int su1 = 1;
		// 수의 대한 조건(1~9까지)
		while(su1<=9) {
			// 단를 표현한 변수
			int dan1 = 2;
			// 단에 대한 조건(2~9까지 수가 고정된 상태에서 증가한다)
			while(dan1<=9) {
				// 구구단을 출력한다.
				System.out.printf("%-2d*%-2d=%2d", dan1, su1, (dan1*su1));
				// 숫자하나를 출력한 후 스페이스(공백)를 출력한다.
				System.out.print(" ");
				// 수에 대한 증가
				dan1++;
			}
			System.out.println();	// 줄바꿈
			// 단을 1증가 시킨다.
			su1++;			
		}
		System.out.println("\n=========================\n");
		
		
		/*
		시나리오] 아래와 같은 모양을 출력하는 while문을 작성하시오.
			출력결과
				1  0  0  0
				0  1  0  0
				0  0  1  0
				0  0  0  1
		 */		
		// 행으로 4번 반복하기 위한 변수
		int x=1;
		// 행의 조건
		while(x<=4) {
			// 행이 고정된 상태에서 열을 4번 반복하기 위한 변수
			int y=1;
			// 열의 조건
			while(y<=4) {
				// 행과 열의 번호가 동일할때 1을 출력한다.
				if(x==y) {
					System.out.print("1  ");
				}
				else {
					// 그 외에는 0을 출력한다.
					System.out.print("0  ");
				}
				// 열의 증가식
				y++;
			}
			// 하나의 행을 출력한 후 줄바꿈 처리
			System.out.println();
			// 행의 증가식
			x++;			
		}
	}
}