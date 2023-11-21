package ex17collection;

import java.util.HashSet;

import common.Teacher;

public class Ex04HashSet2 {

	public static void main(String[] args) {
		
		HashSet<Teacher> hashSet = new HashSet<Teacher>();
		
		Teacher t1 = new Teacher("정우성", 40, "국어");
		Teacher t2 = new Teacher("황정민", 42, "영어");
		Teacher t3 = new Teacher("관우", 44, "역사");
		
		hashSet.add(t1);
		hashSet.add(t2);
		hashSet.add(t3);
		
		System.out.println("hashSet의크기:"+ hashSet.size());//3개
		System.out.println();
		Teacher t3Same = new Teacher("이정재", 44, "역사");
		/*
		현재 Teacher클래스는 나이와 과목이 같다면 동일한 객체로
		판단하도록 hashCode(), equals()메서드가 오버라이딩 되어있다. 
		따라서 이름만 틀린 경우라면 동일한 객체로 판단한다. 
		 */
		System.out.println("t3Same저장여부:"+ hashSet.add(t3Same));
		System.out.println("hashSet의크기:"+ hashSet.size());		
	}
}
