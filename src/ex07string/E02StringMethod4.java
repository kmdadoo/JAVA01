package ex07string;

public class E02StringMethod4
{

	public static void main(String[] args)
	{
		/*
		시나리오] 주민등록번호를 이용하여 성별을 판단하는
		프로그램을 charAt()을 이용해서 작성하시오.
		200419-3000000 => 남자
		200419-4000000 => 여자
		*/
		System.out.println("#####  시나리오 #1 #####");
		String juminNum = "010419-2000000";
		/*
			주민번호로 주어진 문자열의 8번째 문자 즉 인덱스 7에 해당하는 
			문자가 성별을 표현하므로, 이를 통해 판단할 수 있다.
			이때 문자를 비교해야 하므로 '(싱글쿼테이션)을 사용해야 한다.
		*/
		if (juminNum.charAt(7)=='1' || juminNum.charAt(7)=='3')
		{
			System.out.println("남자입니다.");
		} else if(juminNum.charAt(7)=='2' || juminNum.charAt(7)=='4')
		{
			System.out.println("여자입니다.");
		} else if(juminNum.charAt(7)=='5' || juminNum.charAt(7)=='6')
		{
			System.out.println("외국인입니다.");
		} else 
		{
			System.out.println("주민번호가 잘못됬습니다.");
		}
		
		/*
		시나리오] 해당 문자열이 이메일 형식인지 검사하는
		프로그램을 contains()를 이용해서 작성하시오.
		hong@daum.net => 이메일형식임
		not@naver => 이메일형식이아님
		*/
		System.out.println("##### 시나리오 2 #####");
		String email1 = "honh@daum.net";
		String email2 = "hong@naver";
		
		// 이메일에 @와 .이 동시에 포함된 경우에만 이메일 형식이라 볼수 있다.
		if (email1.contains("@") && email1.contains("."))
		{
			System.out.println("이메일 형식입니다.");
		} else
		{
			System.out.println("이메일 형식이 아닙니다.");
		}
		if (email2.contains("@") && email2.contains("."))
		{
			System.out.println("이메일 형식입니다.");
		} else
		{
			System.out.println("이메일 형식이 아닙니다.");
		}
		
		/*
		시나리오]주민등록번호로 성별을 구분하는 프로그램을 indexOf()를
		이용해서 작성하시오.
		*/	
		System.out.println("##### 시나리오 3 #####");
		// 주민번호에서 -(하이픈)의 위치를 찾아 1을 더한다.
		String juminNum1 = "010419-3123456";
		int index = juminNum1.indexOf("-") +1;
		// 성별을 표현하는 문자를 찾아 남/여를 판단한다.
		if (juminNum.charAt(index)=='1' || juminNum.charAt(index)=='3')
		{
			System.out.println("남자입니다.");
		} else if(juminNum.charAt(index)=='2' || juminNum.charAt(index)=='4')
		{
			System.out.println("여자입니다.");
		} else if(juminNum.charAt(index)=='5' || juminNum.charAt(index)=='6')
		{
			System.out.println("외국인입니다.");
		} else 
		{
			System.out.println("주당신은 소중합니다.");
		}
		
		/*
		시나리오] 다음 파일명에서 확장자를 잘라내는 프로그램을
		작성하시오. 
		파일명 : 2023.03.30.르세라핌.안티프레져.mp3
		*/
		System.out.println("##### 시나리오 4 #####");
		// 파일명은 중간에 .(닷)이 몇개든 들어갈 수 있으므로 뒤에서프터
		// 찾아야 한다.
		String filename = "2023.03.30.르세라핌.안티프레져.mp3";
		int beginIndex =  filename.lastIndexOf('.')+1;
		System.out.println("파일의 확장자는 : " 
				+ filename.substring(beginIndex));
	}

}
