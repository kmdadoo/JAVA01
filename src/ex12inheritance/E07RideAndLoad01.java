package ex12inheritance;

/*
상속관계에서 오버로딩 vs 오버라이딩

오버로딩 : 메서드명은 같으나 매개변수의 갯수, 타입, 순서가
	다른경우를 말한다. 즉, 서로 다른 메서드이므로 상속받은
	하위클래스에서는 오버로딩 된 모든 메서드가 포함된다. 

오버라이딩 : 메서드명, 매개변수, 반환형까지 모두 동일한 
	메서드를 상속관계에 있는 하위 클래스에서 재정의 한것을
	말한다. 
	이 경우 하위클래스에서 정의한 메서드가 상위클래스의 
	메서드를 가리게 되므로, 항상 최하위 클래스의 메서드가 
	호출된다. 즉 오버라이딩은 참조변수의 타입에 영향을 받지
	않는다. 
 */
class A {
	//생성자를 정의하지 않았으므로 디폴트 생성자가 삽입된다. 
//	public A() {}
	public void rideMethod() {
		System.out.println("A의 rideMethod");
	}
	public void loadMethod() {
		System.out.println("A의 loadMethod");
	}
}
class B extends A {
	//디폴트 생성자 생략
//	public B() {
//		super();
//	}
	@Override
	public void rideMethod() {
		System.out.println("B의 rideMethod");
	}
	public void loadMethod(int num) {
		System.out.println("B의 loadMethod");
	}
}
class C extends B {	
	//디폴트 생성자는 컴파일러에 의해 자동삽입 된다. 
//	public C() {
//		super();
//	}
	/*
	rideMethod()는 오버라이딩 된 메서드로 상위클래스에 정의된
	멤버메서드와 반환형, 메서드명, 매개변수의 갯수 및 타입이 모두
	동일하다. 즉 동일한 메서드이다. 
	 */
	@Override
	public void rideMethod() {
		System.out.println("C의 rideMethod");
	} 
	/*
	loadMethod()는 오버로딩 된 메서드로 상위클래스에 정의된 
	멤버메서드와 메서드명만 동일할뿐 매개변수의 타입, 갯수 등이
	다르게 정의된다. 즉 다른 메서드이다. 
	 */
	public void loadMethod(double num) {
		System.out.println("C의 loadMethod");
	} 
	/*
	따라서 C클래스로 객체를 생성하면 오버라이딩된 메서드는 모두
	가려지게되므로 C클래스에 정의된 메서드 하나만 남게된다. 
	오버로딩 된 메서드는 서로 다르므로 3개 모두 존재하게된다.
	 */
}
public class E07RideAndLoad01 {

	public static void main(String[] args) {

		/*
		부모타입의 참조변수로 자식객체를 참조할 수 있으므로
		아래 문장은 모두 성립된다. 
		 */
		A ref1 = new C();
		B ref2 = new C();
		C ref3 = new C();
		
		/*
		참조변수에 상관없이 항상 최하위에 오버라이딩된 메서드가
		호출된다. 즉 아래 부분은 모두 C클래스에 생성된 rideMethod()가
		호출된다. 
		즉 오버라이딩은 참조변수의 영향을 받지않는다. 
		 */
		System.out.println("오버라이딩 처리된 메소드");
		ref1.rideMethod();// O 
		ref2.rideMethod();// O
		ref3.rideMethod();// O 

		/*
		ref3은 C타입의 참조변수이므로, 객체를 참조할때 모든 영역에
		접근할 수 있다. 따라서 아래 3개의 문장은 모두 실행된다. 
		 */
		System.out.println("오버로딩 처리된 메소드");
		ref3.loadMethod(); 
		ref3.loadMethod(1);  
		ref3.loadMethod(1.1);
		
		//ref2는 B타입이므로 접근범위가 B까지로 제한된다. 
		ref2.loadMethod();
		ref2.loadMethod(1); 
//		ref2.loadMethod(1.1);//C클래스는 접근불가  
		
		//ref1은 A타입이므로 접근범위가 A까지로 제한된다. 
		ref1.loadMethod();  
//		ref1.loadMethod(1);//B클래스 영역은 접근불가 
//		ref1.loadMethod(1.1);//C클래스 영역은 접근불가  
		
		/*
		오버로딩은 동일한 객체를 참조한다 하더라도 참조변수의 
		타입에 따라 접근범위가 달라지게된다. 즉 참조변수의 
		타입 만큼만 접근할 수 있다. 
		 */ 
		
		/////////////////////////////////////////////////////
		//부모 참조변수로 자식객체를 참조할 수 있다. 
		//좌측의 변수는 부모, 우측의 객체는 자식이므로 모두 가능하다.
		A refNum1 = new B(); //참조가능
		A refNum2 = new C(); //참조가능  
		B refNum3 = new C(); //참조가능

		C refAddr1 = new C(); //좌우측 모두 동일한 C타입이므로 참조가능
		B refAddr2 = refAddr1; //B타입 -> C타입 : 참조가능
		A refAddr3 = refAddr1; //A타입 -> C타입 : 참조가능
 
		/*
		참조변수 refId1이 C객체를 참조하고 있으므로 마치 C타입이라고
		착각할 수 있으나, 원래의 타입은 A이다. 
		자식으로 부모를 참조하는것은 불가능 하므로 아래 2개의 문장은
		에러가 발생한다. 
		 */
		A refId1 = new C(); // A -> C : 참조가능
//		B refId2 = refId1; // B -> A : 에러발생
//		C refId3 = refId1; // C -> A : 에러발생
		
/////////////////////////////////////////////////////
//		int a = 10.1;// 에러
		double b = 10;  // 자동형변환
		int c = (int)3.14;  // 강제형변환 후 대입은 가능하다.
		
		/*
		  기본자료형의 겨우 double이 int보다는 더 큰 타입이므로
		  실수를 정수형 변수에 대입할 수 없다.
		  하지만 강제형변화하면 대입할 수 있다.
		 */
		
		/*
		 * 자식으로 부모객체를 참조하는 것은 기본적으로 불가능하다.
		 * 하지만 다운캐스팅(강제형변환)을 하면 참조가 가능해진다.
		 * 즉 부모타입을 자식타입으로 변경하는 것이다. 이는 클래스가
		 * 상속관계에 있기 때문에 가능하고, 방식은 기본자료형과 동일하게
		 * 소괄호를 사용하면 된다.
		 */
		
		B refId2 = (B)refId1; // A타입을 B타입으로 형변환(다운캐스팅)
		C refId3 = (C)refId1;	// A타입을 C타입으로 다운캐스팅
	}
}