package ex17collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import common.Student;

public class Ex03ArrayList2 
{
	public static void main(String[] args) 
	{
		/*
		아래 2개의 컬렉션은 내부적인 자료구조만 다를뿐 구현방법에는 차이가
		없다. 객체 생성시 Student형의 타입매개변수를 사용한다. 
		 */
		LinkedList<Student> list2 = new LinkedList<Student>();
		//ArrayList<Student> list2 = new ArrayList<Student>();
		 
		//저장할 객체 생성. 외부패키지에 정의되었으므로 반드시 import해야된다.
		Student st1 = new Student("정우성", 10, "2018");
		Student st2 = new Student("원빈", 20, "2017");
		Student st3 = new Student("장동건", 30, "2016");
		Student st4 = new Student("공유", 40, "2015");
		 
		//컬렉션에 인스턴스 추가
		list2.add(st1); //인덱스 0
		list2.add(st2);
		list2.add(st3);
		list2.add(st4); //인덱스 3
		//List컬렉션이므로 중복저장이 가능하다. 인덱스로 구분할 수 있다.
		list2.add(st2); 
		
		/*
		일반 for문 사용을 위해 size()메서드로 추가된 객체의 갯수를 반환받는
		다. 또한 index로 객체에 접근해야 하므로 get()메서드를 사용한다. 
		 */
		System.out.println("[출력1-일반for문]");
		/*
		컬렉션의 각 인덱스에 저장된 객체의 참조값을 그대로 출력한다. 
		toString()메서드를 오버라이딩 하였으므로 객체에 저장된 멤버변수값이
		출력된다. 
		 */
		for(int i=0 ; i<list2.size() ; i++) {			
			System.out.println(list2.get(i));
		}
		System.out.println();
		
		/*
		객체의 참조값을 통해 삭제하는 경우 boolean값이 반환된다. 
		또한 동일한 객체가 존재한다면 앞에 있는 객체가 먼저 삭제된다. 
		즉 동시에 삭제되지 않는다. 
		 */
		boolean removeOk = list2.remove(st2);//원빈삭제
		System.out.println("인스턴스를 통한 삭제:"+ removeOk); 
		System.out.println();
		
		/*
		컬렉션에 저장된 내용을 이터레이터에게 알려준 후 출력할 원소가 
		있는지 확인하여 true가 반환되면 해당 객체를 출력한다. 
		 */
		System.out.println("[출력2-이터레이터]");
		Iterator<Student> it2 = list2.iterator();
		while(it2.hasNext()) {	
			//참조값을 출력하면 toString() 오버라이딩한 내용이 출력된다.
			System.out.println(it2.next());
			//만약 이름만 출력하고 싶다면 getter()를 사용하면 된다. 
//			System.out.println(it2.next().getName());
		} 
		
		/*
		시나리오] 컬렉션에 저장된 객체를 이름으로 검색하여 삭제할 수 
		있는 코드를 작성하시오. 이때 반복문은 확장for문을 사용하시오.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");	 
		String removeName = scanner.nextLine();
		//리스트에 저장된 객체의 갯수만큼 반복한다.  
		for(Student st : list2) { 
			/*
			이름으로 검색시 멤버변수 name은 private으로 선언되었으므로
			getter를 통해 접근해야 한다. 
			삭제를 위해 입력한 이름과 Student객체에 저장된 name과 일치하는지
			확인한 후 해당 객체를 찾을수 있다. 
			 */
			if(removeName.equals(st.getName())) {
				//정보가 일치하는 객체를 찾았다면 참조값을 통해 삭제한다.
				list2.remove(st); 
				//객체를 삭제하면 즉시 반복문을 탈출한다. 
				break;
			}
		}
		System.out.println("현제 객체수:"+ list2.size()); 
		System.out.println();
		
		/*
		인스턴스의 인덱스를 통해 삭제하면 객체자체(참조값)가 반환된다. 
		따라서 삭제된 객체의 정보를 출력할 수 있다. 
		 */
		System.out.println("삭제된 객체의 이름:"+ 
				list2.remove(2).getName());
		
		System.out.println("[출력3-확장for문]");
		for(Student st : list2) {
			System.out.println(st);
		}
	}
}
