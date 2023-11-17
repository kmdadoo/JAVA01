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
		// 사용자 입력을 위한 객체 생성
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

class FrienInfoHandler
{
	// 멤버변수
	/*
	Friend 클래스는 Univ, High클래스의 부모이므로 해당 타입으로 배열을
	생성하면 하위객체를 저장할 있다.
	 */
	private  Friend[] myFriends;
	/*
	 친구정보를 저장한 객체를 생성한 후 배열에 저장할때 인덱스로 사용할
	 멤버변수로 생성자에서 0으로 초기화한다.
	 */
	private int numOfFriends;
	
	// 생성자 :  객체배열의 크기를 인수로 받은 후 초기화한다.
	public FrienInfoHandler(int num)
	{
		myFriends = new Friend[num];
		// 배열의 인덱스는 0부터 시작이므로 0으로 초기화 한다.
		numOfFriends = 0;
	}
	
	// 친구정보를 추가를 위한 멤버 메서드
	public void addFriend(int choice)
	{
		// 친구의 기본정보를 먼저 입력 받는다.
		Scanner scan = new Scanner(System.in);
		String iName, iPhone, iAddr,iNickname, iMajor;
		System.out.print("이름"); iName = scan.nextLine();
		System.out.print("전화번호"); iPhone = scan.nextLine();
		System.out.print("주소"); iAddr = scan.nextLine();
		
		if(choice==1)
		{
			// 고딩을 선택한 경우...
			System.out.print("별명"); iNickname = scan.nextLine();
			// 객체를 생성한 후 참조변수에 저장한다.
			HighFrind high = new HighFrind(iName, iPhone, iAddr, iNickname);
			/*
			 참조값을 객체배열에 추가한다. 이때 인덱스로 사용할 변수를
			 후의 증가 하므로 0번 인덱스에 객체가 먼저 저장된 후 1증가
			 하게 된다.
			 */
			myFriends[numOfFriends++] = high;
		}else if(choice==2)
		{
			// 대딩을 선택한 경우
			System.out.print("전공"); iMajor = scan.nextLine();
			// 객체 생성과 동시에 참조값을 객체배열에 추가한다.
			myFriends[numOfFriends++] = 
					new UnivFriend(iName, iPhone, iAddr, iMajor);
		}
		/*
		 더이상 실행할 문장이 없다면 해당 메서드는 메모리에서 소멸
		 되고 호출한 지점으로 돌아가게 된다.
		 */
		System.out.println("친구정보 입력이 완료되었습니다.");
	}	/// end of addFriend
	
	/*
	친구의 정보를 출력하기 위한 멤버메서드
		1. 친구정보를 추가할때 High 또는 Univ객체를 배열에 저정한다.
		2. 이때 객체는 Friend로 자동형변환(업캐스팅)되어 저장한다.
		3. 정보 출력시 배열에 입력된 객체수만큼 반복하여 각 원소를 통해
			정보(멤버변수에 저장된 값)를 출력한다.
		4. 출력을 위한 멤버메서드는 상속관계에서 오버라이딩 처리되어
			있으므로 참조변수의 영향을 받지않고 항상 자식객체에 오버라이딩
			정의한 멤버메서드가 호출된다.
		5. 즉, 저장된 객체는 Friend타입이지만 오버라이딩을 통해 별도의
			형변환이 필요하지 않다. 항상 원하는 정보를 출력할 수 있게된다.
	 */
	// 친구의 전체 정보를 출력한다.
	public void showAllData()
	{
		for(int i =0; i<numOfFriends ; i++)
		{
			myFriends[i].showAllData();
		}
		System.out.println("===전체정보가 출력되었습니다.===");
	}	/// end of showAllData
	
	// 친구의 간략정보를 출력한다.
	public void showSimpleData()
	{
		for(int i =0; i<numOfFriends ; i++)
		{
			myFriends[i].showBasicInfo();
		}
		System.out.println("===간략정보가 출력되었습니다.===");
	}  /// end of showSimpleData
	
	// 주소록 검색
	public void searchInfo()
	{
		// 검색한 정보가 존재하는지 확인하기 위한 변수
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		/*
		정보검색을 위해 주로 배열의 크기만큼 반복하는 것이 일반적이나
		해당 프로그램에서 아래와 같이 배열.length를 사용하지 않는 
		이유는 정보가 없는 인덱스는 모두 null이기 때문이다. 따라서
		정보의 갯수를 지정한 numOfFriendss 변수를 사용해야 한다.
		 */
//		for(int i = 0; i< myFriends.length ;  i++)
		// 객체배열에 저장된 정보의 갯수만큼 반복하여 검색한다.
		for(int i =0; i<numOfFriends ; i++)
		{
			/*
			배열의 각 인덱스에 저장된 객체의 참조값을 통해 멤버변수에
			접근한다. 검색을 위해 입력한 이름과 비교해서 일치하는 
			경우에만 정보를 출력한다. 이때 compareTo() 대신 equals()
			를 사용해도 된다.
			 */
//			if(searchName.compareTo(myFriends[i].name)==0)
			if(searchName.equals(myFriends[i].name))
			{
				/*
				일치하는 이름이 있다면 오버라이딩 된 메서드를 통해
				정보를 출력한다.
				 */
				myFriends[i].showAllData();
				System.out.println("**귀하가 요청하는 정보를 찾앗습니다.**");
				// 그리도 변수를 true로 변경한다.
				isFind = true;
			}
		}
		// 만약 검색된 정보가 없다면 아래와 같이 출력한다.
		if(isFind == false)
			System.out.println("****찾는 정보가 없습니다.****");
		System.out.println("===전체정보가 출력되었습니다.===");
	} 	/// end of searchInfo
	
	// 주소록 삭제
	public void deleteInfo()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		/*
		배열의 원소 중 삭제된 원소의 인덱스값을 저장하기 위한 변수로
		원소를 삭제한 후 빈자리를 채워넣을 때 사용한다.
		배열의 인덱스는 0부터 시작이므로 -1로 초기화 한다.
		 */
		int deleteIndex = -1;
		
		//  삭제할 객체를 찾기위해 저장된 데이터 개수만큼 반복
		for(int i =0; i<numOfFriends ; i++)
			// 입력된 이름과 같은지 비교
		{
			if(deleteName.compareTo(myFriends[i].name)==0)
			{
				/*
				객체배열에서 삭제는 null로변경하면 된다. 객체의 
				참조값이 null이라는 것은 참조할 객체가 없다는 것이므로
				이와같이 처리하면 된다.
				 */
				myFriends[i] = null;
				// 삭제된 원소의 index를 저장한다.
				deleteIndex = i;
				// 전체 카운터를 1 차감한다.
				numOfFriends--;
				// 하나의 객체를 삭제하였다면 즉시 for 문을 탈출한다.
				break;
			}
		}
		// 검색된 데이터가 없어 삭제되지 않았다면 -1을 유지한다.
		if(deleteIndex==-1)
		{
			System.out.println("===삭제된 데이터가 없습니다.===");
		}else
		{
			/*
			객체배열에서 검색된 원소를 삭제한 후 바로 뒤에 있는
			원소들을 앞으로 하나씩 복사한다.
			numOfFriend는 앞에서 1 차감되므로 마지막 원소는 검색이나
			출력에서 무시된다.
			 */
			for(int i = deleteIndex ; i<numOfFriends ; i++)
			{
				myFriends[i] = myFriends[i+1];
			}
			System.out.println("===데이타(" + deleteIndex 
					+ "번)가 삭제되었습니다.===");
		}
	}	/// end of deleteInfo
}
