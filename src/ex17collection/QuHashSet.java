package ex17collection;

import java.util.HashSet;
import java.util.Objects;

class Avengers {
	String name;
	String heroName;
	String weapon;

	public Avengers(String name, String heroName, String weapon) {
		super();
		this.name = name;
		this.heroName = heroName;
		this.weapon = weapon;
	}

	@Override
	public String toString() {
		return "Avengers [본명=" + name + ", 닉네임=" + heroName + ", "
				+ "능력=" + weapon +"]";
	}
	
	/*
	Set계열의 컬렉션에 객체 입력시 중복을 제거하기 위해 hashCode(), 
	equals()메서드를 적절히 오버라이딩 해야한다. 
	 */
	@Override
	public int hashCode() {
		//방법1 : 각 객체의 hash값을 얻어온 후 적당히 연산하여 반환한다. 
//		int hcode = this.name.hashCode()+this.heroName.hashCode()
//			+this.weapon.hashCode();
		
		//방법2 : Objects클래스의 hash()메서드를 이용한다. 
		int hcode = Objects.hash(this.name, this.heroName, this.weapon);
		
		return hcode;
	}
	@Override
	public boolean equals(Object obj) {
		//매개변수로 전달된 객체를 다운캐스팅 한다. 
		Avengers av = (Avengers) obj;
		//각 멤버변수를 비교한다. 
		if(this.heroName.equals(av.heroName) 
				&& this.name.equals(av.name) 
				&& this.weapon.equals(av.weapon)) {
			//멤버변수의 값이 동일하면 true를 반환한다. 
			return true;
		}
		else {
			return false;
		}
	}
}

public class QuHashSet {
	
	public static void main(String[] args) {

		HashSet<Avengers> set = new HashSet<Avengers>();

		Avengers hero1 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
		Avengers hero2 = new Avengers("스티브로져스", "캡틴아메리카", "비브라늄 방패");
		Avengers hero3 = new Avengers("브루스배너", "헐크", "강한피부&점프");
		Avengers hero4 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
		
		set.add(hero1);
		set.add(hero2);
		set.add(hero3);
		set.add(hero4);		 

		System.out.println("[최초 전체 정보출력]");
		for(Avengers av : set)
		{
			System.out.println(av.toString());			
		}
	}

}
