package ex18lambda;

/*
인터페이스와 클래스를 활용한 일반적인 오버라이딩.
 */
//이와 같은 추상클래스를 아래에 있는 인터페이스로 변경할 수 있다. 
//abstract class ISchool1
//{
//	abstract void studyLamda(String str);
//}

//인터페이스 정의
/*
인터페이스에는 추상메서드만 정의할 수 있다. 그리고 자동으로 public abstract
가 붙게된다. 추상메서드는 구현부가 없으므로 기능이 없다. 즉 오버라이딩의
목적으로 생성된다. 
*/
interface ISchool1 
{
	void studyLambda(String str);
}

/*
추상메서드를 포함한 인터페이스를 구현하면 하위 클래스에서는 반드시
오버라이딩 해야한다. 추상메서드를 포함한 클래스는 반드시 abstract로
선언하거나 그렇지 않으면 오버라이딩을 통해 부모 인터페이스의 추상메서드를
재정의해야한다.(가려지게된다) 
 */
class Student1 implements ISchool1 
{
	@Override
	public void studyLambda(String str) 
	{
		System.out.println(str +"을(를) 공부합니다");
	}
}

public class Ex01NormalClass {

	public static void main(String[] args) {
		/*
		단지 메서드 하나를 정의해서 사용하고 싶은데 인터페이스, 상속, 
		오버라이딩, 객체생성까지의 과정을 거쳐야 하므로 너무 복잡하다. 
		
		여기에서는 부모타입의 참조변수를 통해 객체를 생성한 후 오버라이딩
		된 자식쪽의 메서드를 호출하고 있다. 
		 */
		ISchool1 sch = new Student1();
		sch.studyLambda("람다식");	
	}
}