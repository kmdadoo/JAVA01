package ex12inheritance;

/*
상속(Inheritance)
	: 기존에 정의된 클래스에 메서드와 변수를 추가하여 새로운 클래스를
	정의하는것을 말한다. 부모클래스를 자식클래스가 상속할때는 extends
	키워드를 사용한다. 
 */
//부모(상위)클래스 : 사람의 일반적인 형태를 추상화한다.
class Man{
	// 멤버변수는 private이므로 클래스 내부에서만 접근할 수 있다.
	private String name;
	
	// 생성자는 오버로딩을 통해 2개를 정의한다.
	public Man() 
	{
		System.out.println("Man클래스 디폴트 생성자 호출됨");
	}
	public Man(String name)
	{
		this.name = name;
		System.out.println("Man 클래스 인자 생성자 호출됨");
	}
	
	// 멤버메서드 정의
	public void tellYourName() 
	{
		//private 멤버라도 동일 클래스내에서는 접근할 수 있다.
		System.out.println("내 이름은 "+ name +"입니다.");
	}
}

//자식(하위)클래스 : Man클래스를 상속받아서 회사원을 추상화한다.
class BusinessMan extends Man
{
	// 멤버변수로 회사명, 직급을 선언한다.
	private String company;
	private String position;
	
	// 생성자 : 멤버변수는 2개지만 매개변수는 3개로 선언한다.
	public BusinessMan(String name, String company, String position) 
	{
		/*
		 상속받은 자식클래스는 부모클래스의 생성자를 호출하여 부모
		 객체가 먼저 메모리에 생성되도록 해야한다.
		 super()는 부모클래스의 생성자를 호출하는 역할을 한다.
		 만약 super()를 기술하지 않으면 컴파일러에 의해 자동으로 삽입
		 되어 부모의 디폴트 생성자가 호출된다.
		 */
		super(name);  // super()를 아래로 이동하면 에러가 발생한다.
		// 부모클래스의 매개변수 1개인 생성자를 호출한다.
		//남은 2개를 통해 나머지 멤버변수를 초기화 한다.
		this.company = company;
		this.position = position;
		System.out.println("BusinessMan 생성자 호출");
	}
	
	public void tellYourInfo() 
	{
		// 같은 클래스의 멤버이므로 접근할 수 있다.
		System.out.println("회사명은 "+ company +" 입니다.");
		System.out.println("직업은 "+ position +" 입니다.");
		/*
		 부모측의 멤버변수 name은 private으로 선언되었으므로 상속받은
		 자식에게도 접근할 수 없다. private은 무조건 자신의 클래스 
		 내부에서만 접근할 수 있다.
		 */
//		System.out.println("이름은 "+ name +" 입니다.");	// 에러발생
		// 부모쪽에서 정의된 public 메서드 이므로 접근할 수 있다.
		tellYourName();		
	}	
}

public class E01BusinessManMain 
{
	public static void main(String[] args) 
	{
		//자식클래스를 통해 2개의 객체를 생성한다.
		BusinessMan man1 = new BusinessMan("김천국", "NAVER", "팀장");
		BusinessMan man2 = new BusinessMan("이낙원", "DAUM", "부장");
		// 둘다 public메서드 이므로 호출할 수 있다.
		man1.tellYourInfo();
		man1.tellYourName();
		
		man2.tellYourInfo();
		man2.tellYourName();
	}
}
