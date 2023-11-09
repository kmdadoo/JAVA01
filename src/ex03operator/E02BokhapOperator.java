package ex03operator;

public class E02BokhapOperator
{
	/*
	복합대입연산자
		: 산술연산자와 대입연산자를 연결해놓은 형태로 좌우측의 값을
		연산하여 좌측의 변수에 대입하는 구조를 가진다. 
		문법의 구조상 항상 현재의 타입을 유지하는 특성을 가지고있다.
	 */
	public static void main(String[] args)
	{
		double e = 3.1;
		//3.1 + 2.1 = 5.2
		e += 2.1; 	
		System.out.println(e);
		//5.2 * 2 = 10.4
		e *= 2;	
		System.out.println(e);
		//10.4 + 10.4 = 20.8
		e += e ;  	
		System.out.println("e의 결과값:"+ e); 
		
		
		int n = 5;
		/*
		정수와 실수를 연산하면 실수의 결과가 나오므로 n에 대입할 수 없어
		에러가 발생한다.
		 */
//		n = n * 2.7;
		n = (int)(n * 2.7); 
		System.out.println(n);
		
		/*
		복합대입연산자를 사용하면 문법의 구조상 변수의 기존 자료형을 
		그대로 유지하는 특성이 있다.
		따라서 연산의 결과는 정수가 된다.
		복합 대입 연산자는 강제 형변환하지 않아도 형변환되서 
		연산된다.
		 */
		n=5;
//		n = n * 2.7;
		n *= 2.7;
		System.out.println("n의 결과값:"+ n);
	}
}