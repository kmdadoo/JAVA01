package ex14innerclass;
/*
익명클래스(Anonymous class)
-이름이 없는 클래스를 말한다. 
-내부클래스처럼 이벤트 기반의 프로그래밍에서 많이 사용된다.(안드로이드)
-부모클래스의 메서드를 오버라이딩 하는것이 목적이다. 
-클래스를 정의하는 것이 마치 메서드를 정의하는것과 비슷하다. 
-마지막에 세미콜론을 반드시 기술해야 한다. 
형식]
	부모클래스명 참조변수 = new 부모클래스명(){
		익명클래스의 실행부;
		부모클래스의 메서드 오버라이딩();
	};
	※부모클래스를 상속받아 이름없는 자식클래스를 생성하는
	개념으로 이해하면된다. 상속되기 때문에 오버라이딩이 가능하다. 
	즉, {} 안쪽은 "자식"의 영역이다.
 */
//가수를 표현한 부모클래스 
class Singer {
	String name;
	public Singer(String name) {
		this.name = name;
	}	
	/*
	Object클래스에 정의된 메서드로 객체가 가진 값을 문자열로
	반환해주는 메서드이다. Java에서 정의하는 모든 클래스는 Object
	클래스를 상속하므로 이와같이 즉시 오버라이딩이 가능하다.
	 */
	@Override
	public String toString() {
		return "이름:"+name;
	}
}
//걸그룹을 표현한 자식클래스 
class GirlGroup extends Singer {
	String team;
	public GirlGroup(String name, String team) {
		super(name);
		this.team = team;
	}
	//부모의 toString()메서드 호출을 위해 super를 사용한다.
	@Override
	public String toString() {
		//이름과 팀명을 같이 반환한다. 
		return super.toString()+", 팀명:"+team;
	}
}
/*
인터페이스 정의
: 기능이 없는 추상메서드만 멤버메서드로 정의할 수 있다. 
또한 메서드 앞에는 public abstract가 생략되어 있다. 
 */
interface ISinger {
	public void dancing();
}
public class E02AnonymousClass {

	public static void main(String[] args) {
		
		//부모클래스를 통해 객체를 생성한다. 
		Singer s1 = new Singer("조용필");
		//객체 자체를 출력하면 toString()메서드를 통해 반환값이 출력된다.
		System.out.println(s1);
		
		//자식클래스를 통해 객체 생성 및 정보출력
		Singer s2 = new GirlGroup("츄", "이달의소녀");
		//자식쪽의 toString()이 호출되어 팀명까지 출력된다. 
		System.out.println(s2);
		
		/*
		GirlGroup클래스를 상속받은 익명클래스 정의
		: Singer타입의 변수에 GirlGroup을 상속받은 익명클래스를 생성해서
		그 주소를 할당한다. 
		개념적으로 new GirlGroup(){}; ==> 익명 extends GirlGroup();
		형태로 생각하면 된다. 
		이름이 없는 객체이므로 부모클래스의 이름을 빌려서 객체를 생성한
		다고 생각하자. 
		 */
		Singer s3 = new GirlGroup("아이린", "레드벨벳") {
			//자식에서 확장한 멤버변수
			boolean mic = true;
			@Override
			public String toString() {
				return super.toString()+", 소속사:SM";
			}
		};
		/*
		부모객체로 자식을 참조할 수 있으나, 접근범위가 부모객체까지로
		제한된다. 따라서 아래와 같이 자식에서 확장한 멤버변수는 접근
		할수 없어 에러가 발생한다. 
		접근을 위해서는 다운캐스팅(강제형변환)을 해야하지만 익명클래스는
		클래스의 이름이 없기때문에 다운캐스팅도 불가능하다.
		따라서 익명클래스에서는 멤버의 확장은 거의 사용되지 않는다.
		 */
//		System.out.println(s3.mic);//에러발생됨
		System.out.println(s3);
		
		/*
		인터페이스를 구현(상속)하여 생성한 익명클래스
		추상메서드는 기능이 없지만 오버라이딩의 목적으로 생성하므로 
		아래처럼 구현하는게 일반적이다. 
		 */
		ISinger s4 = new ISinger() {
			@Override
			public void dancing() {
				System.out.println("춤추는게 좋아요~~");
			}
		};
		s4.dancing();
		
		/*
		결론]
			상속의 목적은 "확장"
			익명클래스의 목적은 "오버라이딩"이다. 
			따라서 익명클래스는 주로 interface를 통해 구현한다. 
		 */
	}
}





