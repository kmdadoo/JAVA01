package ex04controlstatement;

/*
if문 형식3
	if(조건1){
		조건1이 참일때 실행문장;
	}
	else if(조건2){
		조간2가 참일때 실행문장;
	}
	else {
		위 모든 조건에 만족하지 않을때 실행문장;
	}
	단, else 문에는 조건식이 들어가면 에러가 발생한다.
*/
public class E01If03
{
	public static void main(String[] args)
	{
		/*
		 시나리오] 국 영, 수 점수의 평균값을 구하여 학점을 출력하는 
		 	프로그램을 작성하시오. 90점이상은 A학점...
		 	60점 미만은 F학점을 출력하면 된다.
		 */
		// 국영수 점수는 정수형으로 선언 및 초기화
		int kor=99, eng=70, math=64;
		/*
		평균값은 소수점이 나올수 있으므로 실수형으로 선언하는것이 
		좋다. 따라서 double형의 결과를 얻기위해 3.0으로 나눠준다.
		 */
		double avg = (kor+eng+math) / 3.0;
		//계산된 결과를 그대로 출력한다.
		System.out.println("평균점수는(그대로):"+ avg);
		//서식문자를 이용해서 소수 이하 2자리까지만 표현한다.
		System.out.printf("평균점수는(소수2자리):%.2f\n", avg);
		//if~else if를 이용해서 여러개의 조건을 사용할 수 있다.
		if(avg>=90) {
			System.out.println("A학점");
		}
		else if(avg>=80) {
			System.out.println("B학점");
		}
		else if(avg>=70) {  
			System.out.println("C학점");
		}
		else if(avg>=60) {
			System.out.println("D학점");
		}
		else {
			System.out.println("F학점. 학사경고ㅜㅠ;");
		}
		
		/*
		 if~else 구문을 구성할때는 조건의 구간을 어떻게 설정하느냐에 
		 따라 전혀 다른 결과가 나올수 있다.
		 아래의 경우 높은 점수라 할지라도 60점이상의 조건에 만족하므로 
		 무조건 D학점이 출력될것이다.
		 */
		System.out.println("잘못된 조건식의 if문");
		if(avg>=60) {
			System.out.println("D학점");
		}
		else if(avg>=70) {
			System.out.println("C학점");
		}
		else if(avg>=80) {  
			System.out.println("B학점");
		}
		else if(avg>=90) {
			System.out.println("A학점");
		}
		else {
			System.out.println("F학점. 학사경고ㅜㅠ;");
		}
		
		/*
		 조건식의 순서를 정하기 애매한 경우에는 아래와 같이 점수의
		 구간을 정한 조건식으로 작성할 수 있다. 이때 논리연산자를 
		 같이 사용한다. xx이상~xx미만과 같은 조건식이 만들어지게 된다.
		 */
		System.out.println("세번째 if문의 블럭(구간적용)");
		if(avg>=60 && avg <70) {
			System.out.println("D학점");
		}
		else if(avg>=70 && avg <80) {
			System.out.println("C학점");
		}
		else if(avg>=80 && avg <90) {  
			System.out.println("B학점");
		}
		else if(avg>=90) {
			System.out.println("A학점");
		}
		else {
			System.out.println("F학점. 학사경고ㅜㅠ;");
		}
	}
}