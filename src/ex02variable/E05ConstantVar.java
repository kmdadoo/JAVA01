package ex02variable;

public class E05ConstantVar
{
	/*
	상수 : 저장된 값이 변하지 않는 메모리의 종류로 변수를 선언한
		후 앞에 final을 붙여준다.
	-상수는 한번만 초기화되고, 그 이후에 값을 변경할 수 없다.
	-선언시 전체를 대문자로 기술한다. 만약 연결되는 단어가 있다면 
		가독성을 위해 _(언더바)를 사용한다.
	-주로 프로그램에서 코드의 가독성을 높여주는 역할을 한다.
	 */
	public static void main(String[] args)
	{
		//상수 선언 및 초기화
		final double PI = 3.14;
		System.out.println("PI(원주율)="+ PI);

		//에러발생. 상수는 한번 초기화하면 변경할 수 없다.
//		PI = 3.141592; 	//에러

		//상수는 초기화되지 않은 상태에서 출력하면 에러가 발생된다.
		final String NICK_NAME;
//		System.out.println("우리는 "+ NICK_NAME);	//에러
		NICK_NAME = "더조은";
		System.out.println("우리는 "+ NICK_NAME);

		/*
		가위,바위,보 게임 제작을 위해 개발자는 아래와 같이 설정하였다. 
		가위:1, 바위:2, 보:3 으로 정하고 진행 한다면...
		코드의 가독성을 높이기 위해 상수를 사용.
		 */
		final int SCISSOR = 1;
		final int ROCK = 2;
		final int PAPER = 3;
		int computer, user;		 

		/*
		1과 3은 개발자 본인만 알수있는 내용이므로, 가독성이 떨어진다. 
		 */
		computer = 1;
		user = 3;
		System.out.println("컴퓨터가 이겼습니다.");		
		
		/*
		Paper와 같은 단어는 누가 보더라도 이해할 수 있으므로 가독성이
		높은 명시적인 코드라 할 수 있다. 
		 */
		computer = SCISSOR;
		user = PAPER;
		System.out.println("Computer Win");
	}
}