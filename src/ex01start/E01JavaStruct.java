/*
주석 : 컴파일러가 코드를 컴파일할때 대상에서 제외하는 문구를 말한다.
	주로 코드의 설명이나 다른 개발자에게 전달할 메세지를 기술한다.
	현재 이부분은 블럭단위 주석이다.
 */

// 라인단위 주석은 2개의 슬러쉬로 표현한다. 단 줄바꿈은 불가능하다. 

/*
 자바파일의 구조
 1. package 선언부 : 클래스를 종류별로 묶어서 관리하기 위한 선언으로
 	디렉토리(폴더)의 의미로 이해하면 된다. 주로 관련있는 클래스끼리 
 	묶어서 관리하기 위한 용도로 사용된다.
 	
 2. import 선언부 : 내가 만든 클래스에 필요한 자바클래스를 가져다가 
 	사용하기 위한 선언으로 JDK에서 제공하는 클래스를 사용할 수 있다.
 	
3. class 선언부 : 자바프로그램은 클래스 단위로 구성되므로 기본적으로 
	필요한 부분으로 클래스는 항상 영문 대문자로 시작하고 파일의 확장자는
	.java로 지정하게 된다.
	또한 public으로 선언된 클래스와 파일명은 반드시 일치해야 한다.
 */
// test 입니다.
package ex01start;

import java.text.SimpleDateFormat;
import java.util.Date;

public class E01JavaStruct
{
	public static void main(String[] args)
	{
		// 오늘날짜와 시간을 Date클래스를 통해 가져온다.
		Date toDayOfDate = new Date();
		System.out.println("오늘날짜:" + toDayOfDate);
		
		/*
		 SimpleDateFormat 클래스를 이용하여 우리가 주로 사용하는
		 날짜포멧인 년-월-일 시:분:초 형태로 변환한 후 출력한다.
		 */	
		SimpleDateFormat simple = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // HH : 24시
		String toDayString = simple.format(toDayOfDate);
		System.out.println("변형된날짜:"+ toDayString);
	}
}
