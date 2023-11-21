package common;

import java.util.Objects;

public class Teacher extends Person
{
	private String subject;
	public Teacher(String name, int age, String subject)
	{
		super(name, age);
		this.subject = subject;
	}
	@Override
	public String toString()
	{
		return super.toString() +", 과목:"+ subject;
	}
	
	/*
	시나리오] Teacher객체는 나이와 과목이 같으면 동일한 객체로 처리하도록 
		hashCode 와 equals 메서드를 적절히 오버라이딩 하시오. 
	 */
	
	/*
	hashCode() 
		: 객체가 가진 고유한 주소값을 정수형으로 반환해준다. 
		따라서 서로 다른 객체라면 다른값을 반환하게된다. 
		정수형 멤버변수의 경우는 그냥 사용하면되고, 객체형 멤버변수의
		경우 hashCode()메서드를 통해 정수값으로 반환되는 참조값을 
		사용하면 된다. 
	 */
	@Override
	public int hashCode() {
		//방법1 : 정수형변수와 객체의 해시코드값을 더해서 반환한다. 
		int returnCode1 = super.getAge() + this.subject.hashCode();
		System.out.println("returnCode1="+ returnCode1);
		 
		/*
		방법2 : 방법1이 번거롭다면 Objects 클래스의 정적메서드인 hash()를
			이용해도 된다. 멤버변수의 갯수만큼 인수로 사용하면된다. 
			형식] int Objects.hash(멤버1, 멤버2, ...., 멤버N)
			결국 이 방법도 객체형 멤버변수의 고유한 주소값을 사용하는것이다. 
		 */
		int returnCode2 = Objects.hash(super.getAge(), this.subject);
		System.out.println("returnCode2="+ returnCode2);
		
		return returnCode2;
	}
	/*
	equals() 
		: 객체가 가진 멤버변수의 값을 비교한다. 값이 같을때는 true, 
		다를때는 false를 반환하도록 오버라이딩한다. 
	 */
	@Override
	public boolean equals(Object obj) {
		Teacher teacher = (Teacher)obj;
		//과목과 나이가 같은지 비교하고 있다. 
		if( (teacher.getAge()==super.getAge()) 
				&& teacher.subject.equals(this.subject) ) {
			return true;
		}
		else {
			return false;
		}
	}
}
