package ex04controlstatement;

import java.io.IOException;

/*
if문(조건문) 형식1
	if(조건문){
		실행문장;
	}
-if문의 조건문은 반드시 비교식 혹은 논리식이어야 한다 .
-즉 결과값이 boolean형으로 true 혹은 false를 반환해야한다. 
-실행할 문장이 하나라면 중괄호 생략이 가능하다.
 */
public class E01If01 {

	public static void main(String[] args) throws IOException {

		//정수형 변수선언 및 초기화
		int num = 10;		 
		 
		//아래 문장은 조건식이 아닌 산술식이므로 에러가 발생된다.
//		if(num%2) {
//			System.out.println("잘못된 조건식입니다.");
//		}
//		if(num) {
//			System.out.println("이것도 잘못된 조건식입니다.");
//		}

		/*
		 if문의 조건은 아래와 같이 boolean값을 반환하는 조건식이면
		 된다.		 
		 */
		if(num%2==0) {
			/*
			특정한 수를 2로 나눠서 나머지가 0이라면 짝수로 판단할수
			있다.
			 */
			System.out.printf("%d는 짝수입니다", num);
		}
		// 둘다 만족하여 논리And는 true를 반환한다.
		if(num%2==0 && num>=10) {
			// 따라서 해당문장은 출력된다.
			System.out.printf("%n%d는 짝수이고 10보다 크거나같다.%n", num);
		}
		
		//경우에 따라 무조건 실행되는 if문이 필요한 경우가있다.
		if(true) {
			System.out.println("무조건 실행되는 if문입니다.");
		}
		
		/*
		if(조건식);
			=> 조건식에 상관없이 다음 문장이 실행되는 잘못된 형태의
			세미콜론은 문장의 끝을 나타내므로 사용에 주의해야 한다.
		 */
		if(num%2 != 0);
		/*
		10은 홀수가 아니지만 위 if문이 잘못되었으므로 아래 문장은 
		실행된다. 위 if문과는 상관이 없다.
		 */
		{
			System.out.printf("%d는 홀수입니다.", num);
		}
		
		/*
		조건검사후 실행할 문장이 1개인 경우에는 중괄호({})를 생략할 수 
		있다. 단, 실행문이 2개 이상이라면 한 문장만 if문에 포함되므로 
		반드시 중괄호를 기술해야 한다. 
		 */
		if(num%2 == 0) 
			System.out.println("\n"+ num +"은 짝수이다");
		
		//num은 10이므로 조건식이 false를 반환하여 출력되지 않는다.
		if(num%2 != 0) { 
			System.out.println("num은 "+ num +"입니다.");
			System.out.println(num +"은 홀수입니다.");
		} 

		/*
		시나리오] 사용자가 입력한 문자가 숫자인지 판단하는 프로그램을 
			if문을 이용해서 작성하시오.
			참조) System.in.read() : 키보드를 통해 입력한 문자의 아스
				키코드를 정수형으로 반환하는 메서드. 두글자 이상 입력
				하더라도 첫번째	문자만 입력된다.  
		 */
		System.out.print("하나의 문자를 입력하세요:");
		int asciiCode = System.in.read();
		System.out.println("입력한 문자는:"+ asciiCode);
		
		/*
		아스키코드를 알고있을때 구현방법
		문자 0과 9는 각각 아스키코드 48, 57 이므로 해당 구간안에 
		있다면 숫자로 판단할 수 있다. 
		 */
		if(asciiCode>=48 && asciiCode<=57) {
			System.out.println("입력한 문자는 숫자입니다.");		
		}
		else {
			System.out.println("입력한 문자는 숫자가 아닙니다.");
		}
		
		/*
		아스키코드를 모를때 구현방법으로 문자 '0'과 '9'를 조건에 그대로
		기술한다. 해당 문자가 결국 아스키코드를 반환하므로 위 if문과 
		동일한 결과를 출력하게 된다. 
		 */
		if(asciiCode>='0' && asciiCode<='9') {
			System.out.println("입력한 문자는 숫자입니다.[1]");
		}
		else {
			System.out.println("입력한 문자는 숫자가 아닌 문자입니다.[1]");
		}		
	}
}