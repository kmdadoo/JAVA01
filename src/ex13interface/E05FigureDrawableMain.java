package ex13interface;

//해당 클래스와 인터페이스는 다른 패키지에 정의되었으므로 사용을 위해
//반드시 import해야한다.
import ex13interface.figure.Circle;
import ex13interface.figure.IDrawable;
import ex13interface.figure.IFigure;
import ex13interface.figure.Rectangle;
import ex13interface.figure.Triangle;

public class E05FigureDrawableMain {

	public static void main(String[] args) {
		
		//부모인터페이스의 참조변수로 자식객체를 참조한다.(이질화)
		IFigure figure = new Circle(30);
		//오버라이딩 되었으므로 별도의 형변환 없이 사용할수있다. 
		//자식쪽에 재정의한 메서드가 호출되어 원의 넓이를 출력한다. 
		figure.area("원");
		/*
		IFigure 인터페이스에는 area() 추상메서드만 정의되어 있으므로
		draw()를 호출하려면 다운캐스팅 후 호출해야한다. 
		 */
		((Circle)figure).draw("나도 원");
		
		//Circle객체와 동일한 방식으로 각 메서드를 호출한다. 
		IFigure fig1 = new Rectangle(100, 90);
		fig1.area("사각형");
		((Rectangle)fig1).draw("나도 사각형");

		/*
		IDrawable 인테페이스는 draw() 추상메서드만 정의되어 있으므로
		area()를 호출하려면 다운캐스팅이 필요하다.
		 */
		IDrawable draw = new Triangle(100, 90);
		draw.draw("삼각형");
		((Triangle)draw).area("나도 삼각형");
		
		/*
		Circle 참조변수를 통해 동일 객체를 참조한다.(동질화)
		 */ 
		Circle circle = new Circle(40);
		//이 경우 모든 메서드를 호출할 수 있다.
		circle.area("원"); 
		circle.draw("나도 원"); 
	}
}
