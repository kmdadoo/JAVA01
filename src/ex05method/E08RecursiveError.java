package ex05method;

public class E08RecursiveError {
	
	public static void main(String[] args) {
		showHi(3);
	}
	/*
	재귀메서드의 오류코드
	1.감소연산자로 인해 cnt의 값은 차감되지만
	2.조건식의 위치가 잘못되어
	3.재귀호출을 하기전에 종료체크를 할수있도록 수정해야 한다.
	
	StackOverflow : 스택오버플로우. 스택은 함수가 종료되기 전까지의
		모든 정보를 저장하는 메모리로써 무한한 공간이 아니기 때문에
		무한루프에 빠지면 저장능력을 초과해서 해당 에러가 발생하게된다.
	 */
	public static void showHi(int cnt) {
		System.out.println("Hi~!");
		System.out.println("cnt="+ cnt);
//		showHi(--cnt); //해당위치에서는 에러가 발생한다. 
		if(cnt==1) {
			return;
		}	
		showHi(--cnt); //정상적으로 실행되는 위치..
	}
}


