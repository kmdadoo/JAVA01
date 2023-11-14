package ex09package;

import ex09package.study.perimeter.Circle;

/*
만약 넓이계산을 위한 클래스도 임포트 한다면 에러가 발생하게 된다. 
클래스명이 동일하므로 new Circle()을 통해 객체 생성하면 넓이인지 
둘레인지 판단할 수 없기 때문이다.
 */
public class E02CircleMain
{
	public static void main(String[] args)
	{
	/*
	원의 넓이 계산 : 객체 생성을 위해 클래스의 풀패키지 경로를 
	명시하여 기술한다.
	 */
	ex09package.study.area.Circle circle1 = 
			new ex09package.study.area.Circle(6.5);
	System.out.println("반지름이 6.5인 원의넓이:"
			+ circle1.getArea());
	
	/*
	원의 둘레계산 : 이미 상단에서 클래스를 임포트 했으므로 클래
	스명만 명시하여 객체를 생성한다.
	 */
	Circle circle2 = new Circle(4.5);
	System.out.println("반지름이 4.5인 원의둘레:"
			+ circle2.getPerimeter());
		
	}
}