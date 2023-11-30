package ex21jdbc.connect;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
/*
PreparedStatement
	- SQl문장을 미리 컴파일할 수 있도록 개선되었다.
	- 작은 따옴표 같은 문자열 등을 자동적으로 처리한다.
	- 재사용하기 편리한다.
	- 수행속도가 빠르다.
*/
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
인터페이스를 구현한 클래스로  extends대신 implements를 사용한다.
또한 용어 '상속' 이 아닌 '구현'이라 표현한다.
*/
public class IConnectImpl implements IConnect 
{
	//멤버변수
	// DB 연결
	public Connection con;
	// 동적 쿼리 실행
	public PreparedStatement psmt;
	// 정적 쿼리 실행
	public Statement stmt;
	// 서브프로그램(저장 프로시져, 함수) 실행
	public CallableStatement csmt; 
	// select 실행후 반환 결과
	public ResultSet rs; 
	
	// 기본 생성자
	public IConnectImpl() {
		System.out.println("IConnectImpl 기본생성자 호출");
	}
	// 인수생성자1 : 아이디, 패스워드를 매개변수로 받음
	public IConnectImpl(String user, String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		try {
			// 인터페이스에 선언된 멤버상수를 그대로 사용함.
			Class.forName(ORACLE_DRIVER);
			// 인수로 받은 계정정보를 통해 DB 연걸
			connect(user, pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	// 인수생성자2 : 드라이버명까지 매개변수로 받음.
	public IConnectImpl(String driver, String user, String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		try {
			Class.forName(driver);
			connect(user, pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	// 오라클에 연결
	@Override
	public void connect(String user, String pass) {
		try {
			// 인터페이스에 선언된 멤버 상수를 그대로 사용함.
			con = DriverManager.getConnection(ORACLE_URL, user, pass);
		}
		catch(SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
	}
	// 오버라이딩 목적으로 정의한 메서드로 각 클래스에서 목적에
	// 맞게 재정의하게 된다.
	@Override
	public void execute() {
		// 실행부 없음
	}
	// 자원반납
	@Override	
	public void close() {
		try {
			if(con!=null) con.close();
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();
			
			if(stmt!=null) stmt.close();
			if(csmt!=null) csmt.close();
			System.out.println("자원 반납 완료");
		}
		catch(Exception e) {
			System.out.println("자원 반납시 오류발생");
			e.printStackTrace();
		}
	}
	// 사용자로부터 입력값을 받기위한 메서드
	@Override
	public String scanValue(String title) {		
		Scanner scan = new Scanner(System.in);
		System.out.print(title +"을(를) 입력(exit->종료):");
		String inputStr = scan.nextLine();
		/*
		equalsIgnoreCase() : equals()와 동일하게 문자열이 동일한지
			비교하는 메서드로 대소문자를 구분하지 않고 비교한다.
			즉, EXIT와 exit는 같은 문자열로 판단한다.
		*/
		if("EXIT".equalsIgnoreCase(inputStr)) {   
			System.out.println("프로그램을 종료합니다.");

			close();			
			System.exit(0);
		}
		// 종료가 아니라면 사용자가 입력한 값을 반환한다.
		return inputStr; 
	}
}
