/*
 패키지선언부 : 현재 작성하는 클래스의 위치를 결정하기 위한 선언으로
 	해당 클래스를 ex09package 패키지에 하위에 묶어서 생성하겠다는 
 	의미이다.
 */
package ex09package;

/*
임포트선언부 : 현재 작성중인 클래스에서 다른 패키지에 있는 클래스를 
	가져다 쓰기위한 선언으로, 사용할 클래스의 위치를 지정하는 것으로
	생각하면 된다.
	패키지명과 클래스명을 함께 기술한다.
	만약 해당 패키지 하위에 선언된 모든 클래스를 한꺼번에 임포트하고 
	싶다면 import java.util.* 와 같이 선언하면 된다.
*/
import java.util.Date;
import ex09package.study.util.CommonUtil;
/*
import java.util.*;
import ex09package.study.util.*;  => 이와같이 임포트 해도 된다.
*/

public class E01PackageMain
{
	public static void main(String[] args)
	{
		/*
		 하나의 클래스안에서 패키지는 다르나 같은 이름의 클래스를 
		 사용해야 한다면...
		 방법1 : 클래스명 앞에 패키지명 전체를 기술한다. 
		 방법2 : 하나의 클래스는 import하고, 다른 하나는 풀 패키지
		 	경로를 기술한다.  <= 이것을 이파일에서 사용함.
		 */
		// 클래스를 import한 후 객체생성
		Date utilDate = new Date();
		System.out.println("utilDate="+ utilDate);
		
		// 패키지의 풀경로를 이용해서 객체생성
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("sqlDate="+ sqlDate);
		
		/*
		 ex09package 하위에 ex09package.study.util 패키지가 생성
		 되지만	이 둘은 서로 다른 패키지로 인식한다.		 
		 따라서 isNumber() 메서드를 호출하기 위해서는 반드시 해당 
		 패키지를 import해야 한다.
		 */
		// 문자열 전체가 숫자이므로 true를 반환한다.
		String strValue = "987654321";
		
		/*
		static으로 선언된 메서드는 new를 통한 객체생성없이	클래스명
		으로 직접 메서드를 호출할 수 있다.
		Java에서 제공하는 클래스 중 대표적으로 Math를 예로들수 있다. 
		난수생성을 위해 별도의 객체생성없이 Math.random()을 통해
		0~1사이의 실수값을 난수로 반환한다.
		 */
		boolean isNum = CommonUtil.isNumber(strValue);
		if(isNum==true)
			System.out.println("문자열은 숫자입니다.");
		else
			System.out.println("숫자가 아닙니다.");
		
		// 문자열에 한글이 포함되어 있으므로 false를 반환한다.
		System.out.println(
				ex09package.study.util.CommonUtil.isNumber("백20"));
	}
}