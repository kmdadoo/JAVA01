package ex11static;

/*
싱글톤 디자인 패턴	
	: 클래스를 설계하는 디자인패턴의 하나로써 하나의 인스턴스 즉
	하나의 메모리를 생성해 이를 공유해서 사용하고자 할때 쓰는 패턴이다.

작성방법	
	1.생성자의 접근지정자를 private으로 선언한다.
	2.클래스 외부에서는 생성자에 접근할 수 없으므로 new를 통해 객체
		생성은 할 수 없다.
	3.클래스 내부에 정적메서드로 해당 클래스의 참조값를 반환하도록
		정의한다. 주로 getInstance() 메서드로 작성한다.
	4.위 방법을 통해 객체를 사용하면 메모리에 딱 하나의 객체만 만들
		어지게된다.
*/

//일반적인 클래스 정의
class NoSingleTone {
	int instVar;
	/*
	생성자는 거의 대부분 public으로 선언한다. 이유는 public으로 선언
	해야지만 클래스 외부에서 new를 통해 객체를 생성할 수 있다.
	 */
	public NoSingleTone() {}
}

//싱글턴 패턴이 적용된 클래스
class SingleTone {
	// 맴버변수
	int shareVar;
	/*
	 JVM(자바가상머신)에 의해 프로그램이 시작될때 정적변수는 미리 
	 메서드영역에 로딩되어 사용할 준비를 마치게된다.
	 */
	private static SingleTone single = new SingleTone();
	/*
	 생성자를 private으로 선언하면 클래스 외부에서는 호출할 수 없으므로
	 new를 통해 객체를 생성할 수 없게 된다.
	 */
	
	// 기본생성자
	private SingleTone() {
	}
	/*
	 정적메서드로 선언된 getInstance()를 통해 해당 객체(참조값)를 외부로
	 반환한다. 이런 함수를 "유틸리티 메서드"라고 한다,
	 */
	public static SingleTone getInstance() {
		return single;
	}
	//멤버변수 출력용 멤버메서드
	void print() {
		System.out.println(String.format("shareVar=%d", shareVar));
	}
}
public class E03SingleToneDesignPattern {

	public static void main(String[] args) {
		
		/*
		 일반적인 방식의 객체생성이므로 객체를 생성할때마다 새로운 
		 참조값(주소값)을 할당받는 인스턴스가 된다.
		 */
		NoSingleTone nst1 = new NoSingleTone();
		nst1.instVar = 100;
		System.out.println("nst1="+ nst1);
		
		NoSingleTone nst2 = new NoSingleTone();
		nst2.instVar = 200;
		System.out.println("nst2="+ nst2);
		
		// 생성자가 private이므로 새로운 객체를 생성할 수 없다.
//		SingleTone st1 = new SingleTone(); //에러발생
		
		/*
		정적메서드이므로 클래스명으로 직접 호출할 수 있다.
		해당 메서드 호출을 통해 싱글톤 객체의 참조값을 얻어온다.
		 */
		SingleTone st2 = SingleTone.getInstance();
		st2.shareVar = 100;
		st2.print();
		//여기서 얻어오는 참조값은 둘 다 동일하다.
		SingleTone st3 = SingleTone.getInstance();
		st3.shareVar = 200;
		st3.print();
		
		// 싱글턴 객체이므로 참조값은 동일하게 출력된다.
		System.out.println(String.format("st2의주소:%s", st2)); 
		System.out.println(String.format("st3의주소:%s", st3));
		/*
		결국 동일한 객체를 사용한 것이므로 마지막에 할당된 값이 
		출력된다.
		 */
		System.out.println(String.format("st2의 shareVar:%d",
				st2.shareVar));  // 200
		System.out.println(String.format("st3의 shareVar:%d",
				st3.shareVar));  // 200
	}
}