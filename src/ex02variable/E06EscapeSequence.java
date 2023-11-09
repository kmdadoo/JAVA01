package ex02variable;

public class E06EscapeSequence
{
	public static void main(String[] args)
	{
		//tab(탭)기능. 스페이스 4칸이 띄워진다.
		System.out.println("4월엔 벚꽃~~!");
		System.out.println("4월엔\t벚꽃~~!");	//4칸
		
		//줄바꿈(Line feed) 기능
		System.out.print("더조은에 오신걸 환영합니다.\n");
		System.out.print("열심히\n해봅시다.\n");
		
		//문자열 사이에 더블쿼테이션을 표현하고 싶을때 사용.
		System.out.println("나는 \"개발자\"가 되고싶어요");
//		System.out.println("나는 "개발자"가 되고싶어요");

		/*
		printf() : 문자열을 서식에 맞춰 출력할때 사용한다.
		 */
		int kor=81, eng=97, math=79;
		
		//정수는 %d로 출력한다. %n은 줄바꿈 기능이 있다.
		System.out.printf("국어:%d, 영어:%d, 수학:%d%n", 
				kor, eng, math);
		// println()을 같이 사용하면 문장이 조금 지저분해진다.
		System.out.println("\n국어:"+ kor +", 영어:"+ eng 
				+", 수학:"+ math);
		
		/*
		실수는 %f를 사용한다. 또한 정수와 실수의 연산이므로 결과는 
		실수가 반환되어 double형으로 선언한 변수에 대입할 수 있다.
		 */
		double avg = (kor+eng+math) / 3.0;
		System.out.printf("평균점수:%f%n", avg);
		
		/*
		자리수 지정하기
		예) %4d : 정수 출력시 전체자리수를 4자리로 표현한다. 
			%6.2f : 실수 출력시 전체자리수는 6자리, 소수이하 2자리로
				표현한다.
			또한 양수는 우측정렬, 음수는 좌측정렬 된다.			
		 */
		System.out.printf("국어:%d, 영어:%d, 수학:%d,"
				+ " 평균:%f %n",	kor, eng, math, avg);
		System.out.printf("국어:%6d, 영어:%6d, 수학:%6d,"
				+ " 평균:%7.4f %n", kor, eng, math, avg);
		System.out.printf("국어:%-6d, 영어:%-6d, 수학:%-6d,"
				+ " 평균:%-7.2f %n",	kor, eng, math, avg);
	}
}