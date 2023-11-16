package ex12inheritance;

/*
Is-A관계	
	: X is a Y => X는 Y의 일종이다로 표현가능한 관게
	- 노트북은 컴퓨터의 일종이다.
	- 휴대폰은 전화기의 일종이다.
	이와같이 Is-A관계가 성립하는 개체를 상속으로 표현하기에 적합하다.
*/
//컴퓨터 : 기본적인 컴퓨팅 환경을 제공하여 입력된 내용을 계산한다.
class Computer{
	// 소유주를 표현한 멤버변수
	String owner;  
	
	// 디폴트 생성자
//	public Computer() {}  
	/*
	개발자가 임의로 생성자를 추가하면 디폴트 생성자는 추가되지 않는다.
	 */
	// 인수 생성자
	public Computer(String name) {
		owner = name;
	}
	/*
	 private접근지정자로 선언된 멤버메서드는 외부클래스 혹은 상속받은
	 클래스에서 접근이 불가능하므로, public으로 선언된 메서드를 통해
	 간접적으로 호출해야 한다. 상속관계라면 protected로 선언된 메서드
	 로 호출할 수 있다.
	 */
	private void keyboardTouch() {
		System.out.println("키보드를 통해서 입력한 ");
	}
	private void calculate() {
		System.out.println("요청된 내용을 계산한다.");
	} 
	/*
	 private메서드를 외부에서 호출하기 위해 public으로 선언된 메서드를
	 별도로 선언한다. 메서드의 호출순서까지 고려해서 정의하였으므로
	 캡슐화 처리된 메서드라 할 수 있다.
	 */
	public void calculateFunc() {
		keyboardTouch();
		calculate();
	}
}

/*
컴퓨터를 상속한 노트북 컴퓨터	
 	: 컴퓨터가 가진 기본 연산기능에 휴대성 부분을 확장하여 정의한다.
 	휴대성을 위해 배터리 멤버변수가 추가된다.
*/
class NotebookComputer extends Computer {	
	// 자식 클래스에서 기능 확장을 위해 정의한 멤버변수 : 배터리
	int battary;  
	
	/*
	 부모 클래스의 생성자를 호출하기 위해 사용하는 super()는 생략 
	 가능하지만 앞에 다른 문장이 먼저 기술되면 에러가 발생한다. 
	 즉, 항상 부모의 생성자를 우선적으로 호출해야 한다.
	 */
	public NotebookComputer(String name, int initCharge) {
		/*
		여기서 아래 super문장을 삭제하면 에러가 발생한다. 부모클래스
		에서 인자생성자를 정의하였으므로 디폴트생성자가 자동으로 추가
		되지 않기 때문이다.
		 */
		super(name);   // 반드시 있어야 함.인자값도 있어야 함.
		battary = initCharge;
	}
	// 배터리 충전을 표현한 멤버메서드
	public void charging() {
		battary += 5;
	}
	// 휴대하면서 컴퓨팅을 하는 것을 표현
	public void movigCal() {
		// 사용전 배터리 확인 후 사용여부 판단
		if(battary < 1) {
			System.out.println("배터리가 방전되어 사용불가");
			// 메서드에서 return은 종료를 의미한다.
			return;
		}
		
		System.out.print("이동하면서 ");		
		/*
		아래 2개의 메서드는 private이므로 외부클래스에서는 호출할 수
		없다. 따라서 접근가능한 public메서드를 통해 간접 호출해야한다.
		 */
//		keyboardTouch(); 	// 에러발생
//		calculate();		// 에러발생
		calculateFunc();
		// 배터리 차감		
		battary -= 1;  
	}
}
/*
테플릿 노트북 : 컴퓨터의 기본기능인 연산과, 휴대이용 가능 및 펜으로
	드로잉 할수있는 기능까지 추가된 컴퓨터를 추상화한다.
*/
class TabletNotebook extends NotebookComputer{  // 펜이 있음
	
	// 테블릿을 사용하기 위한 펜슬을 표현한 멤버변수
	String registPencil;  
	
	// 생성자 
	public TabletNotebook(String name, int initCharge, String pen) {
		// 2개의 값을 부모로 전달한다.(부모생성자 호출)
		super(name, initCharge);
		// 1개는 자신의 멤버변수를 초기화한다.
		registPencil = pen;
	}
	// 테블릿 사용을 위해 배터리량 체크 및 등록된 펜인지 확인한다.
	public void write(String penInfo) {
		if(battary<1) {
			System.out.println("배터리가 방전되어 사용불가");
			return;
		}
		/*
		 A.compareTo(B)
		 	: 문자열 A 와 B를 비교하여 0이 반환되면 같은 문자열로 판단
		 	하고 -1 혹은 1이 반환되면 서로 다른 문자열로 판단하는 
		 	String클래스에 정의된 메서드.
		 */		
		if(registPencil.compareTo(penInfo)!=0) {
			System.out.println("등록된 펜이 아닙니다.");
			return;
		}
		/*
		부모클래스에 정의된 메서드를 호출한다. 상속받은 자식 클래스
		에서는 이와같이 부모의 멤버메서드를 호출하여 자신의 기능처럼 
		사용할수 있다. 단, 접근이 가능한 접근지정자로 지정되어야한다.
		 */
		movigCal();
		System.out.println("스크린에 펜으로 그림을 그린다.");
		battary -= 1;
	}
}

public class E04ISAInheritance {
	
	public static void main(String[] args) {
		
		// 노트북 객체 생성
		NotebookComputer noteBook = new NotebookComputer("공유", 5);
		// 테블릿 객체 생성
		TabletNotebook tablet = 
						new TabletNotebook("이동욱", 5, "ISE-1234");

		System.out.println("==노트북컴퓨터사용==");	
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal(); //배터리가 1씩 차감되므로 여기까지 사용가능
		noteBook.movigCal(); //배터리가 모두 소모되어 사용불가
		noteBook.movigCal();
		noteBook.movigCal();
		
		System.out.println("==ISE-1234 펜으로 테블릿사용==");
		tablet.write("ISE-1234");  //사용가능
		
		System.out.println("==XYZ-9876 펜으로 테블릿사용=="); 
		tablet.write("XYZ-9876"); // 사용불가
	}
}
