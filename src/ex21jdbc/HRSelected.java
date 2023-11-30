package ex21jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/*
Statement
	- 단순한 정적 SQL문을 사용할 경우에 좋다.
	- SQL문을 직접적으로 작성하기 때문에 쉽게 분석할 수 있다.
*/
import java.sql.Statement;

public class HRSelected
{
	public static void main(String[] args)
	{
		try {
			// 오라클 데이터베이스 연결
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String pass = "1234";
					
			Connection con = DriverManager.getConnection(url,id,pass);
			if(con!=null) {
				System.out.println("Oracle 연결성공");
				/*
				1. 쿼리문 작성
					: 작성시 줄바꿈 할때 앞뒤로 스페이스를 삽입하는 것이 
					좋다. 그렇지 않으면 문장이 서로 이어지게 되어 
					SyntaxError가 발생하게 된다.
				*/
				String sql = "SELECT * FROM employees WHERE "
						+ " department_id=60 "
						+ " ORDER BY employee_id DESC";
				/*
				2. 쿼리문 전송을 위해 Statment인터페이스를 통해 객체를
				생성한다.
				*/
				Statement stmt = con.createStatement();				 
				/*
				3. 뭐리문을 오라클 데이터베이스로 전송한다. 실행한 결과는
				ResultSet객체를 통해 반환받는다.
				*/
				ResultSet rs = stmt.executeQuery(sql);
				/*
				4. 반환된 결과를 갯수만큼 반복하여 출력한다. next()메서드는
				출력할 레코드가 남았는지 확인하고, 더 이상 레코드가 
				만아있지 않다면 false를 반환하여 while문을 탈출한다.
				*/
				while(rs.next()) {
					/*
					5. getXXX() 메서드를 통해 각 컬럼에 접근한다. 오라클의
					자료형은 문자, 숫자, 날짜 3가지 형태이므로 메서드도
					이와 동일한 형태를 가지고 있다.
					*/
					String emp_id = rs.getString(1);
					// 인덱스 2를 써도 됨.
					String f_name = rs.getString("first_name");
					String l_name = rs.getString("last_name"); 
					java.sql.Date h_date = rs.getDate("hire_date");
					int sal = rs.getInt("salary");
					System.out.printf("%s %s %s %s %s\n",
							emp_id, f_name, l_name, h_date, sal);
				}
				/*
				6. 자원반납(해제) : 모든 작업을 마친후에는 메모리 절약을
				위해 연결했던 자원을 반납한다.
				*/
				rs.close();
				stmt.close();
				con.close();				
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
