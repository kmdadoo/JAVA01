package ex09package.study.perimeter;

//원의 둘레를 계산하기 위한 클래스
public class Circle {
	//멤버변수 : 반지름
	double rad;
	//멤버상수 : 원주율
	final double PI;
	
	//생성자 : 멤버변수를 초기화한다.
	public Circle(double rad){
		//this는 멤버를 가리킨다. 
		this.rad = rad;
		//생성자에서는 멤버상수를 초기화할 수 있다. 
		PI = 3.14159;
	}	
	//원의 둘레를 계산하여 반환하는 멤버메서드
	public double getPerimeter(){	
		return 2 * PI * rad;
	}
}
