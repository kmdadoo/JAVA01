package ex17collection;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import common.Teacher;

/*
HashSet<E> : Set계열의 컬렉션
	- Set계열의 인터페이스를 구현한 컬렉션
	- 객체가 순서없이 저장된다. 
	- 객체의 중복저장을 허용하지 않는다. 
	- 단 기본클래스(String, Integer등)가 아닌 개발자가 새롭게 정의한 클래스라면
		hashCode(), equals() 메서드를 적절히 오버라이딩하여 중복에 대한 기준을 
		설정해야한다. 
	- List가 배열의 특성을 가진다면, Set은 집합의 특성을 가진다. 
 */
public class Ex04HashSet1 
{
	public static void main(String[] args) 
	{
		// Object를 기반으로 Set컬렉션을 생성했으므로 모든 객체를 저장할수
		// 있다.
		HashSet<Object> set = new HashSet<Object>();
		
		//다양한 기본클래스와 우리가 정의한 Teacher클래스의 객체생성
		String varString1 = "JAVA";		
		String varString2 = new String("개발자");
		Date varDate = new Date();
		int varInt = 100;
		Teacher varTeacher = new Teacher("김봉두", 55, "체육");
		
		/*
		객체저장  
			: add()메서드를 통해 저장되고, 성공하면 true를 반환한다.
		 */
		System.out.println("add결과:"+set.add(varString1));  
		set.add(varString2);
		set.add(varDate);
		set.add(varInt); //new Integer(varInt)와 같이 Boxing되어 추가된다. 
		set.add(varTeacher);
		
		
		System.out.println("[중복 저장전 객체수]:"+ set.size());//5개
		/*
		기본클래스의 객체 중복저장
			: 기본 클래스인 경우 별도의 오버라이딩 없이도 중복이 제거된다.
			따라서 아래의 add()메서드는 false를 반환한다. 
		 */
		System.out.println(set.add(new String("개발자")) ? "저장성공":"저장실패");
		//저장에 실패이므로 5개 출력
		System.out.println("[중복 저장후 객체수]:"+ set.size());
		
		/*
		이터레이터를 통한 객체 출력
			: 순서없이 저장되므로 출력의 순서도 정할 수 없다.
		 */
		// 1.set참조변수를 통해 Iterator객체를 생성한다. 
		Iterator itr = set.iterator();
		// 2.추출할 데이터가 있는지 확인한다.
		while(itr.hasNext()) {
			// 3.데이터가 있어 true이면 next()를 통해 추출한다. 
			Object object = itr.next();
			/*
			HashSet<E>에 저장시 모두 Object형으로 자동형변환되어 저장되므로
			우리가 직접 정의한 클래스에 대해서만 instanceof를 통해 타입을 
			확인한 후 다운캐스팅하여 출력한다. 만약 다운캐스팅 하지않으면 
			자식객체로의 접근이 불가능하므로 getName()을 호출할 수 없다.
			 */
			if(object instanceof Teacher) {
				System.out.println("Teacher객체=>"+ ((Teacher)object).getName());
			}
			else {
				System.out.println("저장된객체:"+ object);				
			}
		}//end of while
		System.out.println();
		
		/*
		포함여부 확인
			: set 컬렉션 내에 해당 객체가 있는지만 확인한다. 
		 */
		System.out.println(set.contains(varString1) ? 
				"varString1 있음" : "varString1 없음");
		
		/*
		객체삭제
			: set컬렉션은 인덱스가 없으므로 객체의 참조값을 통해서만
			삭제할 수 있다. 
		 */
		System.out.println(set.remove(varString2) ?
				"varString2 삭제 성공" : "varString2 삭제 실패");
		
		/*
		전체삭제
			: List컬렉션과 동일하다. 
		 */
		System.out.println("전체삭제:"+ set.removeAll(set));
		System.out.println("[전체 삭제후 객체 수]:"+ set.size());
	}	
}