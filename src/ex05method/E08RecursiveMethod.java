package ex05method;

/*
재귀함수(Recursive method)
: 하나의 함수에서 자신을 다시 호출하여 작업을 수행하는 방식으로 
문제를 해결하는 메서드를 말한다. 순환호출이라고 표현하기도 한다.
 */
public class E08RecursiveMethod {

	static int factorial(int number) {
		int result;
		if(number==1) {
			result = 1;
		}
		else {
			//1이 아닌 경우에는 자신의 함수를 재귀호출한다. 
			result = number * factorial(number-1);
		}
		//계산과정을 출력해보면 1부터 콘솔에 나오게된다. 
		System.out.println("계산과정:number="+ number
				+", result="+ result);
		return result;
	}

	public static void main(String[] args) {

		System.out.println("재귀함수를 이용한 팩토리얼 구하기");
		System.out.println("4factorial:"+ factorial(4));
		System.out.println("10factorial:"+ factorial(10));
	}
}
