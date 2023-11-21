package ex18lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
Java에서 제공하는 기본 함수형 인터페이스는 아래 4가지 정도가 있다. 
차이점이라면 매개변수의 유무와 리턴값 정도이다.

Predicate<T> : 매개변수O, 리턴값 boolean
Supplier<T> : 매개변수X, 리턴값O
Consumer<T> : 매개변수O, 리턴값X
Function<T,E> : 둘다있음
 */
public class Ex06Define1Predicate 
{
	public static void main(String[] args) 
	{
		/*
		 Predicate<T>
			-사전적의미 : ~에 근거를 두다.
			-매개변수와 boolean 리턴값이 있는 test() 추상메서드가 정의되어있다.
			-파라미터를 조사해 true / false 를 반환한다. 
		 */
//		interface Predicate<T> 
//		{
//			boolean test(T t);
//		}

		// Human객체를 생성한다. 
		Human p1 = new Human("케이윌", "남", 80);
		Human p2 = new Human("에일리", "여", 77);

		/*
		인터페이스에 정의된 test() 추상메서드를 오버라이딩하여 아래와 같은
		람다식을 정의한다. 매개변수로 Human객체를 전달하고, 성별을 판단하여
		남자인 경우 true, 여자인 경우 fasle를 반환한다. 
		 */
		Predicate<Human> pre = (Human h) -> {
			/*
			매개변수로 전달된 Human객체의 getter()를 통해 성별을 얻어온후
			"남"인지 판단한다. 
			 */
			return h.getGender().equals("남"); 
		};
		System.out.println("p.test(p1) => "+ pre.test(p1)); //true
		System.out.println("p.test(p2) => "+ pre.test(p2)); //false
		
		System.out.println("===============================");
		
		Human p3 = new Human("임재범", "남", 97);
		Human p4 = new Human("아이유", "여", 99);
		
		/*
		인자로 주어진 4개의 객체를 List컬렉션으로 반환해준다. 단 해당 
		컬렉션은 값을 변경할수없고 참조만 가능하다.
		 */
		List<Human> list1 = Arrays.asList(p1, p2, p3, p4);
		
		/*
		Predicate<Human> aaa = a -> a.getGender().equals("남");
		이와같은 람다식을 정의한 후 참조변수인 aaa를 전달하는것과 
		아래처럼 람다식 자체를 매개변수로 작성하는것은 동일하다. 
		*/
		/*
		남자인지 판단하는 람다식은 추상메서드를 통해 매개변수의 타입을
		유추할 수 있어 String이 생략되었다.
		 */
		double maleAvg = avg(a -> a.getGender().equals("남"), list1);
		System.out.println("남자 평균:"+ maleAvg);
		
		/*
		위와 같이 매개변수의 타입을 생략하는것도 가능하지만 가독성이
		떨어지므로 타입정도는 아래의 람다식처럼 명시하는것이 좋다. 
		여기서는 여자인지를 판단한다. 
		 */
		double femaleAvg = 
				avg((Human b) -> b.getGender().equals("여"), list1);
		System.out.println("여자 평균:"+ femaleAvg);
	}
	
	/*
	매개변수로 성별을 판단하는 람다식과 List컬렉션을 전달받는다.
	 */
	public static double avg(Predicate<Human> ph, List<Human> li) 
	{
		int pCount = 0;
		int tCount = 0;
		//컬렉션에 저장된 Human객체의 갯수만큼 4번 반복한다. 
		for(Human h : li) {
			//람다식을 통해 각 Human객체의 성별을 판단한다. 
			if(ph.test(h)==true) {
				//각 성별을 판단한 후 +1한다.
				pCount++;
				//Human클래스의 score멤버변수값을 반환하는 getter를 통해
				//점수를 합산한다. 
				tCount += h.getScore();
			}
		}
		//평균값을 구해서 반환한다.
		return (double)tCount / pCount;
	}////end of avg
}
