package ex21jdbc;

/*
Connection
	- 특정 데이터 원본과 연결된 커넥션을 나타낸다.
	- SQL문장을 정의하고 실행시킬 수 있는 STatement객체를 생성할 때
	Connection객체를 사용한다.
*/
import java.sql.Connection;
/*
DriverManager  
	- 데이터 원본에 JDBC드라이버를 통하여 커넥션을 만드는 역할을 한다.
 	- Class.forName() 메소드를 통해서 생성된다.
*/
import java.sql.DriverManager;	

public class DBConnect
{
	public static void main(String[] args)
	{
		/*
		JDBC프로그래밍 절차
		1. 오라클용 JDBC 드라이버를 메모리에 로드한다.
		: new를 상요하지 않고 클래스명으로 직접 객체를 생성한 후 메모리에
		로드하는 forName()이라는 정적 메서드를 사용한다. 
		메모리에 로드된 드라이버가 Drivermanger라는 클래스에 등록한다.
		
		2. 오라클 연결을 위해 커넥션URL, 계정아이디, 패스워드를 준비한다.
		커넥션URL => jdbc:oracle:thin:@오라클 서버의 IP주소:포트번호:SID명
		* 서버환경에 따라 ip주소, 포트번호, sid는 변경될수 있다.
		
		3. DriverManger 클래스의 정적메서드인 getConnection()을 통해
		데이터 베이스에 연결을 시도하고, 연결에 성공하면 Connection객체를 
		반환한다.
		
		4. 우리는 반환된 Connection객체를 통해 DB작업(CRUD)을 처리하게 된다.
		*/
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String pass = "1234";

			Connection con = DriverManager.getConnection(url,id,pass);
			if(con!=null) {
				System.out.println("Oracle 연결성공");
			}
			else {
				System.out.println("Oracle 연결실패");
			}
		}
		catch(Exception e) {
			System.out.println("Oracle 연결시 예외발생");
			e.printStackTrace();
		}
	}
}
