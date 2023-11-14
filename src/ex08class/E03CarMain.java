package ex08class;

//자동차를 추상화한 클래스
class Car {	
	// 멤버변수 : 자동차모델명, 소유주
	String carModel;
	// 소유주를 표현한 멤버변수는 Human타입으로 정의되었다.
	Human owner;
		
	/*
	우리가 직접 작성한 클래스는 객체를 표현하기 위한 용도로 생성하지만 
	Java에서는 하나의 자료형으로 사용된다. 즉 객체를 표현한 또 하나의
	자료형을 생성하는 것이 class를 작성하는 목적이 된다.
	 */
	/*
	 초기화메서드1 : 매개변수가 없는 형태로 항상 고정된 값으로만 객체를
	  	초기화할 수 있다. 따라서 확장성이 없는 형태의 메서드이다.
	 */
	void initialize() {
		carModel = "람보르기니";
		owner = new Human();
		owner.name = "스티브로져스";
		owner.age = 30;
		owner.energy = 10;
	}	
	/*
	 초기화메서드2 : 위와 동일한 이름의 메서드로 오버로딩에 의해 정의
	 	한다. 초기화를 진행하는 역할은 동일하나, 매개변수를 통해 다양한
	 	값으로 초기화 할수 있다.
	 */
	void initialize(String model, int year, String name, int age, int energy) {
		carModel = model;
		/*
		  다른 객체가 멤버변수로 정의되었으므로, 객체를 생성한 후 각각의 
		 멤버변수를 초기화 해야한다.
		 */
		owner = new Human();
		owner.name = name;
		owner.age = age;
		owner.energy = energy;
	}
	
	// 객체의 현재상태를 출력하는 메서드
	void showCarInfo() {
		System.out.println("[차량정보]");
		System.out.printf("모델명:%s\n", carModel);
		/*
		소유주를 표현하는 owner객체는 멤버메서드 호출을 통해 정보를 
		출력할 수 있다. 이름, 나이 등이 출력될 것이다.
		 */
		owner.showState();
	}
}////end of Car Class

public class E03CarMain {

	public static void main(String[] args) {
		
		// 자동차객체1 생성
		Car car1 = new Car();
		// 매개변수가 없는 초기화메서드를 호출하여 "람보르기니"로 
		// 초기화한다
		car1.initialize(); 
		// 자동차객체1의 정보를 출력한다.
		car1.showCarInfo();
		
		/*
		 자동차객체2 생성 : 객체를 생성할때마다 멤버변수를 초기화 해야 
		 	하므로 코드의 중복이 많아지게된다. 즉 코드의 낭비가 심하
		 	므로 효율적인 코드가 아니라고 볼수있다. 따라서 이 방법은 
		 	실무에서 거의 사용하지 않는다.
		 */
		Car car2 = new Car();
		car2.carModel = "밴틀리";
		car2.owner = new Human();
		car2.owner.name = "토니스타크";
		car2.owner.age = 52;
		car2.owner.energy = 8;
		car2.showCarInfo();

		/*
		 자동차객체3 생성 : 매개변수가 있는 초기화 메서드를 사용하여 
		 	객체를 생성한다. 이 경우 매개변수를 통해 다양한 값을 전달할
		 	수 있으므로	여러형태의 객체를 생성할 수 있다.
		 	따라서 해당 파일에서는 가장 효율적이 코드라 할수있다.
		 */
		Car car3 = new Car(); 
		car3.initialize("스포츠카", 2012, "성유겸", 8, 10);
		car3.showCarInfo();	
		
		/*
		 해당 객체는 객체를 생성만 하고 초기화 하지 않은 상태로 출력을
		 시도하므로 예외가 발생하게 된다. 즉 객체는 초기화를 진행한 후 
		 사용해야 한다.
		 */
		Car car4 = new Car(); 		
		car4.showCarInfo();	
	}
}
