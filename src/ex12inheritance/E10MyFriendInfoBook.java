package ex12inheritance;

import java.util.Scanner;

/*
친구를 표현한 최상위 클래스로 해당 프로그램에서는 Friend클래스로
객체생성은 하지 않는다. 기본정보를 저장하고 상속할 목적으로 정의된
클래스이다.
이와같은 클래스를 VO(Value Object)라고 부른다. 즉 값만 가진 객체라는 
뜻이다.
 */
class Friend 
{
	// 멤버변수 : 이름, 전화번호, 주소 기본정보 3가지를 표현
	String name;
	String phone;
	String addr;

	// 인수생성자 : 멤버변수 초기화
	public Friend(String name, String phone, String addr)
	{
		super();
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	
	// 멤버변수 전체를 출력하기 위한 멤버메서드
	public void showAllData()
	{
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
		System.out.println("주소:"+ addr);
	}
	
	/*
	간략 정보를 출력하기 위한 메서드로 실행부가 없는 상태로 정의한다.
	해당 프로그램에서는 오버라이딩의 목적으로만 사용하기 위해 정의
	한다. 
	추상메서드 => 실행부가 없는 메서드, 오버라이딩의 목적으로 만듬.
	 */
	public void showBasicInfo()	{}
}
// 고등학교 친구정보를 저장할 클래스
class HighFrind extends Friend
{
	// 자식에서 확장한 멤버변수 : 별명
	String nickname;

	// 인수생성자
	public HighFrind(String name, String phone, String addr, String nickname)
	{
		/*
		자식객체에는 부모객체를 초기화 할수 없는 인수까지 모두 받은 후 
		super()를 통해 부모생성자를 먼저 호출한다.
		 */
		super(name, phone, addr);
		this.nickname = nickname;
	}
	/*
	고딩친구의 전체정보를 출력하기 위해 부모에서 정의된 메서드를 
	super를 통해 호출하고, 자식에서 확장한 변수를 별도의 print()문을
	통해 출력한다.
	 */
	@Override
	public void showAllData()
	{
		System.out.println("===고딩친구(전체정보)===");
		super.showAllData();
		System.out.println("별명:"+ nickname);
	}
	
	/*
	자식에서 오버라이딩 하여 제정의한 매서드를 고딩친구의 간략한 
	정보를 출력한다. 
	 */
	@Override
	public void showBasicInfo()
	{
		System.out.println("===고딩친구===");
		System.out.println("별명:"+ nickname);
		System.out.println("전화번호:"+ phone);
	}
}

// 대학교 친구 정보를 저장하기 위한 클래스
class UnivFriend extends Friend
{
	// 확장한 멤버변수로 전공과목을 표현
	String major;

	// 생성자와 멤버메서드 모두 HighFriend 클래스와 동일하게 정의됨
	public UnivFriend(String name, String phone, String addr, String major)
	{
		super(name, phone, addr);
		this.major = major;
	}

	@Override
	public void showAllData()
	{
		System.out.println("===대딩친구===");
		super.showAllData();
		System.out.println("전공:"+ major);
	}

	@Override
	public void showBasicInfo()
	{
		System.out.println("===대딩친구===");
		System.out.println("전공:"+ major);
		System.out.println("전화번호:"+ phone);
	}
}

public class E10MyFriendInfoBook
{
	/*
	매개변수가 없고 반화타입도 없는 메서드
		: 해당 프로그램에서 메뉴를 출력하는 용도로 정의한다.
	main() 메서드에서 직접 호출하기 위해서는 해당 메서드도 static으로
	선언되어야 한다.
	 */
	public static void menuShow()
	{
		System.out.println("###### 메뉴를 입력하세요 ######");
		System.out.print("1.고딩친구입력   ");
		System.out.println("2.대딩친구입력");
		System.out.print("3.전체정보 출력  ");
		System.out.println("4.간략정보 출력");
		System.out.print("5.검색  ");
		System.out.print("6.삭제  ");
		System.out.println("7.프로그램 종료");
		System.out.print("메뉴선택>>>>>");
	}
	
	/*
	메인 메서드는 해당 프로그램의 시작점(Entry point)이므로 복잡한
	로직의 구성보다는 프로그램의 전반적인 흐름에 대해서만 기술하는 것이
	좋다. 따라서 선택한 메뉴에 따라 핸들러 클래스의 메서드만 호출하는 
	형태로 구현되었다.
	 */
	public static void main(String[] args)
	{
		// 사용자 입력응 위한 객체 생성
		Scanner scan = new Scanner(System.in);
		/*
		 기능을 담당하는 핸들러(메니저) 클래스의 객체를 생성
		 */
		FrienInfoHandler handler = new FrienInfoHandler(100);
		/*
		 무한루프 조건으로 특정 입력에만 종료할 수 있는 구조를 만들어준다.
		 break문은 반복문을 탈출시키는 기능이 있으므로 이와 같은 
		 무한루프에서 자주 사용한다.
		 for(;;) 문을 통해 무한루프를 구현할 수 있으나 반복의 횟수가 
		 명확하지 않는 경우 주로 while문을 사용한다.  
		 */
		while(true)
		{
			// 메뉴를 출력한다.
			menuShow();
			
			// 사용자는 수행할 기능의 메뉴를 선택한다.
			int choice = scan.nextInt();
			// 선택한 번호에 따라 switch문으로 각 메서드를 호출한다.
			switch (choice)
			{
			case 1: case 2: 
				handler.addFriend(choice);
				break;
			case 3:
				handler.showAllData();
				break;
			case 4:
				handler.showSimpleData();
				break;
			case 5:
				handler.searchInfo();
				break;
			case 6:
				handler.deleteInfo();
				break;
			case 7:
				System.out.println("프로그램 종료");
				return;
			}	//// switch 끝
		}	////while 끝
	}	/// main 끝
} 


