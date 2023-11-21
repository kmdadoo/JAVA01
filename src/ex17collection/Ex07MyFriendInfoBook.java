package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ex01start.SystemOutPrintln;

/*
해당 프로그램에서 Friend클래스는 최상위 클래스로써 상속의 목적으로
제작되었다. 따라서 객체를 생성할 필요가 없으므로 추상클래스로 정의한다.
 */
abstract class Friend 
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
	오버라이딩의 목적으로 정의된 해당 메서드는 기능이 없으므로
	추상메서드로 정의하는것이 좋다. 
	해당 클래스를 상속받는 하위클래스에서는 반드시 추상메서드를 
	오버라이딩 해야한다. 
	 */
	abstract public void showBasicInfo();
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
	해당 메서드는 추상메서드를 상속한게 아니므로 오버라이딩은 필수가
	아닌 선택사항이다. 
	 */
	@Override
	public void showAllData()
	{
		System.out.println("===고딩친구(전체정보)===");
		super.showAllData();
		System.out.println("별명:"+ nickname);
	}
	
	/*
	부모클래스에 있는 추상메서드를 상속했으므로 반드시 오버라이딩해야
	에러가 발생하지 않는다. 즉 추상메서드를 포함한 클래스를 상속하면 
	반드시 오버라이딩해야 된다는 규칙이 생기게 된다. 
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

/*
해당 프로그램에서 기능을 담당하는 클래스를 핸들러 혹은 메니져 클래스
라고 한다. 
 */
class FrinendInfoHandler
{
	// 멤버변수
//	private Friend[] lists;
//	private int numOfFriends;
	
	/*
		기존 객체 배열에 저장하던 방식을 List 컬렉션으로 변경한다.
		우리는 배열과 동일한 특성을 가지고있는 ArrayList<E>로 객체를 생성한다.
		해당 컬랙션에는 Friend타입의 객체를 저장할 것이므로 상속관계가
		있는 하위 객체는 모주 저장할 수 있다.
		또한 List컬렉션은 인덱스가 존재하긴 하나 자동 인덱싱을 지원하므로
		인덱스 저장을 위한 변수는 필요하지 않다.
	*/
	private ArrayList<Friend> lists;

	// 생성자 : List컬렉션을 초기화 한다.
	public FrinendInfoHandler()
	{
		lists = new ArrayList<Friend>();
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
			lists.add(high);
		}else if(choice==2)
		{
			// 대딩을 선택한 경우
			System.out.print("전공"); iMajor = scan.nextLine();
			// 객체 생성과 동시에 참조값을 객체배열에 추가한다.
			lists.add(new UnivFriend(iName, iPhone, iAddr, iMajor));
		}
		System.out.println("친구정보 입력이 완료되었습니다.");
	}
	
	/*
		일반 for문을 통해 접근할때는 인덱스를 이용한다. 인덱스를 통한
		접근을 할때는 get()메서드를 사용하면 된다.
	*/
	// 친구의 전체 정보를 출력한다.
	public void showAllData()
	{
		for(int i =0; i<lists.size() ; i++)
		{
			lists.get(i).showAllData();
		}
		System.out.println("===전체정보가 출력되었습니다.===");
	}	/// end of showAllData
	
	/*
		확장된 for문을 통해 접근할때는 인덱스가 필요하지 않고, 단순히 
		컬렉션에 저장된 객체의 갯수만큼 자동으로 반복하게된다. 즉 fr
		이라는 참조변수에 0번 인덱스의 객체부터 마지막가지의 객체가
		대입되게 된다.
	*/
	// 친구의 간략정보를 출력한다.
	public void showSimpleData()
	{
		for(Friend fr : lists)
		{
			fr.showBasicInfo();
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
		
		// 이터레이토ㅓ를 통한 검색기능 구현
		// 1. 컬렉션을 통해 이터레이터 객체를 생성한다.
		Iterator<Friend> itr = lists.iterator();
		// 2. 원소(객체)가 있는지 확인한다.
		while(itr.hasNext())
		{
			// 3.있다면 next()를 통해 객체의 참조값을 투툴한다.
			/*
				하지만 next)_를 두번 호출하면 그 다음 객체로 넘아가
				버리게 되므로 while루프네에서 한번만 호출해야 정상적
				으로 출력된다. 
			*/
			Friend fr = itr.next();
			if(searchName.equals(fr.name))
			{
				fr.showAllData();
				System.out.println("**귀하가 요청하는 정보를 찾앗습니다.**");
				isFind = true;
			}
		}
		// 만약 검색된 정보가 없다면 아래와 같이 출력한다.
		if(isFind == false)
			System.out.println("****찾는 정보가 없습니다.****");
	} 	/// end of searchInfo
	
	// 주소록 삭제
	public void deleteInfo()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		boolean isDelete = false;
		
		//  삭제할 객체를 찾기위해 저장된 데이터 개수만큼 반복
		for(Friend fr : lists)
			// 입력된 이름과 같은지 비교
		{
			if(deleteName.compareTo(fr.name)==0)
			{
				// 해당 반복회차에 추출된 객체의 참조값을 통해 삭제한다.
				lists.remove(fr);
				System.out.println("# 정보가 삭제되었습니다. #");
				//삭제가 완료된 경우 true로 변경한다. 
				isDelete = true;
				//삭제되면 즉시 반복문을 탈출한다. 
				break;
			}
		}
		// 검색된 데이터가 없어 삭제되지 않았다면 -1을 유지한다.
		if(isDelete==false)
		{
			System.out.println("===삭제된 데이터가 없습니다.===");
		}else
		{
			System.out.println("===데이터가 삭제 되었습니다.===");
		}
	}	/// end of deleteInfo
}


public class Ex07MyFriendInfoBook
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
		FrinendInfoHandler handler = new FrinendInfoHandler();
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

