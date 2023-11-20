package ex12inheritance;

/*
	문제4) QuRingMake.java
	다음 Point클래스를 이용하여 다음 문제를 해결하시오. 해당 문제는 
	상속(Inheritance)을 통해 구현하는것이 아니라 구성(Composition)
	관계를 이용하여 해결한다. Point 클래스를 기반으로 원을 의미하는 
	Circle클래스를 정의하자. 그리고 Circle클래스를 기반으로 Ring클
	래스를 정의하자.
*/
// 점을 표현한 클래스
class Point {
	// 2개의 좌표를 통해 하나의 점을 표현한다.
   	int xDot, yDot;
   	// 생성자에서 멤벼변수 초기화
   	public Point(int x, int y) {
 		xDot=x;
 		yDot=y;
   	}
   	// 좌표값을 표현하는 멤버메서드
   	public void showPointInfo() {
         System.out.println("[x좌표:"+xDot+", y좌표"+yDot+"]");
   	}
}

//Point클래스를 기반으로 원(Circle) 클래스 표현하기
class Circle{	
	//멤버변수
	int radian;//반지름
	Point center;
	// 생성자
	public Circle(int radian, int x, int y)
	{
		// 멤버변수 반지름 초기화
		this.radian = radian;
		/*
			상속관계라면 super()가 필요하겠지만, 구성관계이므로 Point형
			객체 생성이 필요하다. 매개변수 x, y를 통해 생성하면 된다.
		*/
		center = new Point(x, y);;
	}
	
	// 멤버메서드
   	public void showCicleInfo() {
   		// 포인트 정보를 먼저 출력한다.
   		center.showPointInfo();
   		// 반지름 정보 출력
        System.out.println("반지름:"+ this.radian);
   	}
}

//원 2개를 겹쳐서 링을 표현하는 클래스
class Ring{
	//멤버변수
	Circle innerCircle;//안쪽의 원
	Circle outerCircle;//바깥쪽의 원
	// 생성자(링은 2개의 원으로 구성되므로 총 6개의 인수가 필요하다.
	public Ring(int inX, int inY, int inR, int outX,int outY, int outR)
	{
		innerCircle = new Circle(inR, inX, inY);
		outerCircle = new Circle(outR, outX, outY);
	}
	
	// 멤버 메서드 : 링의 정보 출력
	public void showRingInfo()
	{
		System.out.println("안쪽원의 정보:");
		innerCircle.showCicleInfo();
		System.out.println("바깥쪽원의 정보:");
		outerCircle.showCicleInfo();	
	}
}

class QuRingMake {
	public static void main(String[] args) {
		Ring c = new Ring(1,1,3,2,2,9);
		c.showRingInfo();
	}
}
