package ex12inheritance;

/*
오버라이딩(overriding)
	: 클래스가 상속관계에 있을때 하위클래스에서 상위클래스의 멤버메서드와
	완전히 동일한 모양으로 재정의하는 것을 말한다.
	오버로딩과 다른점은 매개변수의 갯수, 반환타입 등이 완전히 똑같은 
	형태로 재정의 하는 것이다.
	하위클래스에서 오버라이딩 한 메서드는 상위클래스의 메서드를 가리게
	되므로 항상 최하위 클래스에서 오버라이딩한 메서드가 호출된다. 
*/
//부모글래스 : 일반적인 스피커를 추상화한다.
class Speaker {
	// 볼륨
	private int volumnRate;
	
	// 멤버변수가 private이므로 외부에서 설정할수 있도록 setter 정의함.
	public void setVolumn(int vol) {
		volumnRate = vol;
	}
	// 상속관계에서 오버라이딩을 목적으로 정의한 메서드
	public void showState() {
		System.out.println("스피커의 볼륨크기:"+ volumnRate);
	}
}

//자식클래스 : 스피커의 기능에 중저음이 보강된 스피커를 추상화
class BaseSpeaker extends Speaker {
	// 베이스 기능을 확장하고 설정을 위한 setter 정의
	private int baseRate;
	public void setBase(int bas) {
		baseRate = bas;
	}
	
	/*
	 @Override : 어노테이션이라 부르고, 오버라이딩된 메서드에 추가하여
	 	컴파일러에게 알려주는 역할을 한다. 필수사항은 아니므로 생략할 
	 	수 있다.
	 */
	@Override
	public void showState() {
		/*
		 super를 통해 부모클래스에 정의된 멤버메서드를 호출한다.
		 특히, 오버라이딩 된 메서드를 호출할때에는 super가 없으면
		 안되므로 주의해야 한다.
		 */
		super.showState();
		System.out.println("베이스의 볼륨크기:"+ baseRate);
	}
	
}
public class E06Overriding {

	public static void main(String[] args) {
		// 자식클래스를 통해 객체를 생성한다.
		BaseSpeaker baseSpeaker = new BaseSpeaker();
		
		/*
		 자식객체를 생성했으므로 부모의 멤버와 자식의 멤버 모두 호출할 
		 수 있다. 단 오버라이딩 된 showState()메서드는 부모의 메서드가 
		 가려지게 되므로 자식쪽의 메서드가 호출된다.
		 */
		baseSpeaker.setVolumn(10);
		baseSpeaker.setBase(20);
		baseSpeaker.showState();	// 볼륨과 베이스가 출력된다.
			
		System.out.println(); 
		
		/*
		부모클래스의 참조변수로 자식글래스의 객체를 참조할 수 있다.
		이것은 상속관계이기 때문에 가능하다. 
		 
		단, 부모 참조변수로 자식객체를 참조하면 접근범위가 부모객체
		까지로 제한된다. 즉, setBase()는 자식쪽 멤버이므로 호출할 수
		없다.
		 */
		Speaker speaker = new BaseSpeaker();
		speaker.setVolumn(30);
//		speaker.setBase(40);	// [에러발생]
		/*
		 showState()는 상속관계에서 오버라이딩한 메서드이다.
		 부모로 자식을 참조했을때 접근범위는 부모객체로 제한되지만
		 오버라이딩한 메서드가 있으면 항상 자식쪽이 호출된다.
		 */
		speaker.showState();	// 볼륨과 베이스가 출력됨.
	}
}
