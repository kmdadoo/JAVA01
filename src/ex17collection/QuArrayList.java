package ex17collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import common.Student;

public class QuArrayList {

	public static void main(String[] args) {

		//ArrayList<Student> list = new ArrayList<Student>();
		LinkedList<Student> list = new LinkedList<Student>();
		
		//저장할 객체 생성
		Student st1 = new Student("가길동", 10, "2018");
		Student st2 = new Student("나길동", 20, "2017");
		Student st3 = new Student("다길동", 30, "2016");
		Student st4 = new Student("마길동", 40, "2015");
		
		//객체 추가(컬렉션에 저장)
		list.add(st1);//index 0
		list.add(st2);//index 1
		list.add(st3);//index 2
		list.add(st4);//index 3
			
		//1.검색할 이름을 입력받음
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String delName = scanner.nextLine();
			
		//다길동 삭제할때 2가지 방법
//		list.remove(2);//index사용
//		list.remove(st3);//참조변수 사용
		
		
		//2.확장 for문으로 컬렉션 전체를 접근
		//List의 인덱스는 0부터 시작이므로 초깃값은 -1로 해준다. 
		int index = -1;
		for(Student st : list) {
			//입력한 이름과 일치하는 객체를 찾는다. 
			if(delName.equals(st.getName())) {
				//찾았다면 객체를 정보를 출력한다. 
				System.out.println("찾았습니다.");
				System.out.println(st);
				//찾은 객체의 인덱스를 얻어온다. 
				index = list.indexOf(st);
				System.out.println("찾은인덱스:"+ index);
			}
		}
		
		//3.검색결과 유/무에 따라 
		if(index!=-1) {
			//검색결과 있을때…검색된 데이터 삭제
			Student st = list.remove(index);
			System.out.println("다음 객체가 삭제되었습니다.");
			System.out.println(st);
		}
		else {
			//검색결과 없을때...검색결과가 없다고 출력
			System.out.println("검색결과가 없습니다.");
		}

		//4.전체정보 출력
		//System.out.println(list);
		System.out.println("전체정보를 출력합니다.");
		Iterator<Student> itr = list.iterator();
		while (itr.hasNext()) {
			Student st = itr.next();
			//toString()을 통해 정보가 출력된다. 
			System.out.println(st);
		}
	}
}
