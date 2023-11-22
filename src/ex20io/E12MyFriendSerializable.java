package ex20io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ex01start.SystemOutPrintln;

/*
	연습문제1] 친구정보를 파일로 직렬화 하기 위한 메서드를 정의하시오.
		현재 친구의 정보를 List컬렉션에 저장되고 있다. 프로그램을 종료할때
		저장된 모든 친구의 정보를 파일로 저장할 수 있는 메서드를 정의하시오.
		파일명 : myfriend_info.obj
		메서드명 : saveFriendInfo()
		※ 해당 메서드는 FriendInfoHandler 클래스에 추가하면 된다.
		
	연습문제2] 프로그램을 다시 시작하면 문제1에서 직렬화 했던 파일을
		역질렬화해서 복원하시오. 만약 3명의 정보가 저장되었다면 다시 
		시작한 직후 정보출력을 하면 3명의 정보가 출력되어야 한다.
		메서드명 : readFriendInfo()
		※ 해당 메서드는 FriendInfoHandler 클래스에 추가하면 된다.
*/
abstract class Friend implements Serializable
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
		super(name, phone, addr);
		this.nickname = nickname;
	}

	@Override
	public void showAllData()
	{
		System.out.println("===고딩친구(전체정보)===");
		super.showAllData();
		System.out.println("별명:"+ nickname);
	}
	
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

class FrinendInfoHandler
{
	private ArrayList<Friend> myFriends;

	// 생성자 : List컬렉션을 초기화 한다.
	public FrinendInfoHandler()
	{
		myFriends = new ArrayList<Friend>();
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
			myFriends.add(high);
		}else if(choice==2)
		{
			// 대딩을 선택한 경우
			System.out.print("전공"); iMajor = scan.nextLine();
			// 객체 생성과 동시에 참조값을 객체배열에 추가한다.
			myFriends.add(new UnivFriend(iName, iPhone, iAddr, iMajor));
		}
		System.out.println("친구정보 입력이 완료되었습니다.");
	}

	// 친구의 전체 정보를 출력한다.
	public void showAllData()
	{
		for(int i =0; i<myFriends.size() ; i++)
		{
			myFriends.get(i).showAllData();
		}
		System.out.println("===전체정보가 출력되었습니다.===");
	}	/// end of showAllData
	
	// 친구의 간략정보를 출력한다.
	public void showSimpleData()
	{
		for(Friend fr : myFriends)
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
		
		Iterator<Friend> itr = myFriends.iterator();
		while(itr.hasNext())
		{
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
		for(Friend fr : myFriends)
			// 입력된 이름과 같은지 비교
		{
			if(deleteName.compareTo(fr.name)==0)
			{
				// 해당 반복회차에 추출된 객체의 참조값을 통해 삭제한다.
				myFriends.remove(fr);
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
	
	// 프로그램 종료시 친구의 정보를 직렬화 한다.
	public void saveFriendInfo()
	{
		try
		{
			ObjectOutputStream out = 
				new ObjectOutputStream(
					new FileOutputStream("src/ex20io/myfriend_info.obj")
				);
			
			// List<E> 컬렉션에 저장된 친구정보의 갯수만큼 반복하여...
			for(Friend fr : myFriends)
			{
				// 파일을 저장한다. 즉, 직렬화 한다.
				out.writeObject(fr);
			}
		} catch (Exception e)
		{
			System.out.println("친구정보 직렬화 중 예외 발생");
		}
	}
	
	// 프로그램이 시작되면 저장된 파일을 통해 복원한 후 컬랙션에 추가한다.
	public void readFriendInfo()
	{
		try
		{
			// 파일을 복원(역직렬화)하기 위해 스트림을 생성한다.
			ObjectInputStream in = 
				new ObjectInputStream(
					new FileInputStream("src/ex20io/myfriend_info.obj")
				);
			// 파일에 친구의 정보가 몇개 저장되었는지 확인할 수 없으므로
			// 무한루프 구선한다.
			while (true)
			{
				// 직렬화 될때 Object기반으로 저장되므로 역직렬화 할때는
				// 반드시 다운 캐스팅 해야 한다.
				Friend fr = (Friend)in.readObject();
				// List<E> 컬렉션에 추가한다.
				myFriends.add(fr);
				// 만약 더이상 복원할 객체가 없다면 예외가 발생한다.
			}
		} catch (Exception e)
		{
			// 예외가 발생하면 catch절로 예외 객체가 던져지므로 while
			// 루프를 탈출할 수 있다.
//			System.out.println("더 이상 복원할 객체가 없습니다.");
//			e.printStackTrace();
		}
		System.out.println("친구의 정보가 복원되었습니다.");
	}
}


public class E12MyFriendSerializable
{
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

	public static void main(String[] args)
	{
		// 사용자 입력을 위한 객체 생성
		Scanner scan = new Scanner(System.in);
		/*
		 기능을 담당하는 핸들러(메니저) 클래스의 객체를 생성
		 */
		FrinendInfoHandler handler = new FrinendInfoHandler();
		
		// 프로그램 시작시 직렬화된 파일이 있다면 즉시 복원하여 컬랙션에
		// 저장한다.
		handler.readFriendInfo();

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
				/*
					프로그램이 종료되는 시점에 컬렉션에 저장된 객체를
					파일의 형태로 저장 즉, 직렬화 해야한다.
					핸들러 클래스에 정의된 메서드를 호출한다.
				*/
				handler.saveFriendInfo();
				return;
			}	//// switch 끝
		}	////while 끝
	}	/// main 끝
} 

