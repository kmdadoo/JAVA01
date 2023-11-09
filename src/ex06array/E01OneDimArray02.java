package ex06array;

import java.util.Random;

public class E01OneDimArray02
{
	public static void main(String[] args)
	{
		/*
		 난수 생성 방법1
		 	: Math.random()은 0~1사이의 실수를 랜덤하게 반환하는 메서
		 	드로 정수형태의 난수를 생성할때는 10, 100과 같은 정수를 
		 	곱해주면 된다.
		 */
		double rndNumber = Math.random();
		System.out.println("생성된난수[실수]:"+ rndNumber);
		/*
		 정수와 실수를 연산하면 실수의 결과가 되므로 int로 강제형변환 
		한다.
		 */
		int intNumber = (int)(Math.random()*100);
		System.out.println("생성된낭수[정수]:"+ intNumber);
		
		/*
		 난수 생성 방법2
		 	: Random클래스를 사용한다. 사용법은 Scanner와 동일하게 
		 	정수형 난수를 생성하고 싶다면 nextInt()를 호출한다.
		 */
		Random random = new Random();
		// 음수, 양수의 정수가 랜덤하게 생성된다.
		System.out.println("생성된난수:"+ random.nextInt());
		System.out.println("==============================");
		
		/*
		 로또번호처럼 1~45사이의 난수를 생성하는 방법
		 1. 0.xxxx현태의 난수를 생성한 후 정수로 변경하기 위해 100을 
		 	곱한다.
		 2. 45로 %연산하여 나머지를 구한다. 특정 정수는 45로 나누면 
		 	나머지는 0~44까지만 나오게 된다.
	 	 3. 0은 구간에 포함되지 않으므로 2번의 결과에 1을 더한다.
	 	 4. 정수의 결과값을 구하기 위해 int로 강제형변환한다.
		 */
		System.out.println("1~45사이의 난수생성:"+
				((int)((Math.random()*100) % 45)+1) );		
		System.out.println("==============================");
		
		System.out.println("크기가 6인 배열에 난수 입력");		
		int[] lottoNum = new int[6];
	
		// 크기만큼 반복해서 난수 생성 후 배열의 각 원소에 입력
		for(int i=0 ; i<lottoNum.length ; i++) {
			lottoNum[i] = (int)((Math.random()*100 % 45) + 1);						
		}
		// 배열 전체 출력
		for(int i=0 ; i<lottoNum.length ; i++) {
			System.out.printf("%d ", lottoNum[i]);
		}
	}
}