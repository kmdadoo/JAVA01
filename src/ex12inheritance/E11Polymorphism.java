package ex12inheritance;

/*
다형성(Polymorphism)
	: 하나의 객체를 여러 타입의 참조변수를 통해 참조할 때 참조변수의
	타입에 따라 다양한 객체를 이용할 수 있는 특성을	말한다. 
	단 객체간에는 상속관계가 있어야 한다.
	
- 부모타입의 참조변수로 자식객체를 참조
	1. 이경우 부모타입의 참조변수는 부모로부터 상속받은 멤버까지만 접근할
	수 있다.
	2. 자식에서 오버라이딩한 메서드가 가려서 자식 메서드가 보인다.
	3. 자식에서 새롭게 정의한 멤버는 접근할 수 없다.
	4. 이런 형태를 이질화(Heterogeneous : 헤태로지니어스)라고 한다.
	
- 같은 타입의 참조변수로 객체를 참조
	1. 객체 전체를 접근할 수 있다. 즉 클래스의 일반적인 규칙을 따른다.
	2. 이런 형태를 동질화(Homogeneous : 호모지니어스)라고 한다.
 */
//부모클래스
class Parent {
	int parentMember;
	void parentMethod() {
		System.out.println("부모의 메소드:parentMethod()");
	}
}
//자식클래스
class Child extends Parent {
	// 확장한 멤버변수와 멤버메서드
	int childMember;
	void childMethod() {
		System.out.println("자식의 메소드:childmethod()");
	}
	// 부모에서 정의한 메서드를 오버라이딩해서 재정의한 멤버메서드
	@Override
	void parentMethod() {
		System.out.println("자식에서 Overriding한 메소드"
				+ "parentMethod()");
	}
	// 오버로딩해서 정의한 확장메서드
	void parentMethod(int childMember) {
		this.childMember = childMember;
		System.out.println("Overloading:자식에서 확장한 메소드"
				+ ":parentMethod("+childMember+")");
	}
}
public class E11Polymorphism {

	public static void main(String[] args) {
		
		System.out.println("[자식으로 자식객체 참조 - 동질화]");
		// 동질화 : 자신의 참조변수로 자신의 객체를 참조한다.
		Child homeChild = new Child();
		// 동질화의 경우 객체 전체를 접근할 수 있다.
		homeChild.childMember = 10;
		homeChild.parentMember =100;
		homeChild.childMethod();
		homeChild.parentMethod(1000);	// 오버로딩한 메서드
		homeChild.parentMethod();	// 오버라이딩 한 메서드
		
		/*
		이질화 : 부모타입의 변수로 자식객체를 참조하는 것을 말한다.
			이경우 자식에서 새롭게 정의한 멤버에는 접근할 수 없다.
			만약 접근해야 한다면 자식타입으로 강제형변환(다운캐스팅)
			해야한다.
		 */
		System.out.println("[부모타입에 자식타입의 메모리 주소 복사]");
		Parent parent1 = homeChild;
		parent1.parentMember = 1;
		// 부모타입의 참조변수로 자식객체에 접근할 수 없으므로 에러발생.
//		parent1.childMember = 1;
		// 오버라이딩 한 메서드이므로 자식쪽이 보여진다.
		parent1.parentMethod();
		
		// 부모 참조변수로 자식객체를 참조한 두번째 변수 생성
		Parent parent2 =  new Child();
		parent2.parentMember = 1;
		parent2.parentMethod();
		/*
		부모로 자식에 접근하려면 강제형변환 해야한다.
		하지만 아래와 같이 기술하면 에러가 발생한다.
		소괄호를 하나 더 추가해서 parent2를 자식타입으로 형변환 후
		멤버변수에 접근해야 한다.
		 */
//		(Child)parent2.childMember = 1;
		((Child)parent2).childMember = 1;
		((Child)parent2).childMethod();
		((Child)parent2).parentMethod();
		
		// 자식타입으로 형변환 이후에 해당 참조변수를 통해 자식멤버에
		// 접근한다. 위와 동일한 방법이다.
		Child child2 = (Child)parent2;
//		int a = (int)3.14;	// 위의 내용이 이와 비슷하다.
		child2.childMember = 1;
		child2.childMethod();
		child2.parentMethod(1);
		
		/*
		java에서 생성한 모든 클래스는 직/간접적으로 Object클래스를
		상속한다. 따라서 모든 객체는 Object의 참조변수로 참조가
		가능하다. 또한 Object클래스에 정의된 모든 메서드를 별도의
		선언없이 사용할 수 있다.
		 */
		System.out.println("[클래스의 끝판왕 Object]");
		Object object = new Child();
		((Parent)object).parentMethod();
	}
}