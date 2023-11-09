package ex02variable;

public class E04StringType
{
	public static void main(String[] args) 
	{
		/*
		String클래스 : 참조형 변수로써 기본자료형이 아닌 클래스.
			문자열을 저장하고, 조작하는 기능을 가지고있다.
			자바에서는 문자열을 표현할때  " 으로 감싸주면 되고 
			연결시에는 ' + '기호를 사용한다. 
		 */
		int number;
		number = 99;		 
		 
		/*
		클래스를 통해 생성한 참조형 변수와 기본자료형 변수 사이에서는 
		형변환이 불가능하다. 
		서로 사용하는 메모리 공간이 다르기 때문이다. 
		-기본자료형 : 스택(Stack)영역을 사용함
		-참조형(클래스)변수 : 힙(Heap)영역을 사용함
		 */
		//아래 2개의 문장은 모두 에러가 발생됨.
//		int stringNumber1 = (int)"100"; 	// 에러
//		String stringNumber2 = (String)100;	// 에러

		//String자료 + int자료 => 단순연결되어 출력된다.
		String strNumber = "100";
		System.out.println(strNumber + number);
		
		//String은 클래스이므로 new키워드를 사용해서 변수를 생성한다.
		String newString = new String("new 키워드 사용");
		System.out.println(newString);

		//문자열 변수를 생성할때는 더블쿼테이션을 주로 사용한다.
		String stringBasic = "클래스지만";
		String plusString = "기본자료형처럼 사용";	
		//모두 문자열이므로 연결되어 출력된다.
		//Java에서는 스페이스(공백)도 하나의 문자로 인식된다.
		System.out.println(stringBasic +" "+ plusString);
		
		/*
		문자열 + 정수 : 우선순위가 없다면 일반적으로 문자열로 출력된다. 
			단, 산술연산의 결과를 출력하고 싶다면 아래와 같이 소괄호로
			묶어 우선순위에 대한 변화를 주면된다. 
		 */
		int kor=100, eng=99, math=98;
		//String + int + int + int => 전체가 문자열로 연결됬다.
		System.out.println("총점:"+kor+eng+math); 
		//String + (int + int + int => int) : 괄호안에서 먼저 덧셈연산
		//이 된 후 문자열로 연결됬다.
		System.out.println("총점:"+(kor+eng+math)); 
		
		System.out.println(8/2*(2+2)); 
	}
}
