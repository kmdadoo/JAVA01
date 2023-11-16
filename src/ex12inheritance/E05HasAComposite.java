package ex12inheritance;

/*
구성관계로 표현하기에 적합한 Has-A관계	
	: X has a Y => X가 Y를 소유(포함)하다.
	여기서는 권총을 소유한 경찰을 표현한다.
	
	Has-A와 같이 소유의 관계를 상속으로 표현하면 클래스간의 강한 연결
	고리가 형성되어 권총이 없는 경찰을 표현하기가 힘들어진다.
	따라서 이 경우에는 구성(Composition)관계로 표현하는것이 적합하다.
	구성관계란 클래스의 멤버로 다른 객체를 사용하는 것을 말한다.
*/
//권총을 표현한 클래스
class Gun {
	// 탄환수
	int bullet;
	// 생성자
	public Gun(int bNum) {
		bullet = bNum;
	}
	// 멤버메서드 : 총을 발사한 후 탄환이 감소함 
	public void shutGun() {
		System.out.println("빵야~~!"); 
		bullet--; 
	}
}
//경찰을 표현한 클래스
class Police {
	// 수갑의 보유갯수
	int handCuffs;
	// 권총을 표현하기 위한 객체형 멤버변수
	Gun gun;  
	
	// 생성자
	public Police(int bNum, int hCuff) {
		handCuffs = hCuff;
		/*
		 권총의 보유여부 초기화
		 	: 만약 총알이 없는 상태라면 보유한 권총이 없는것으로 표현
		 	하기 위해 멤버변수를 null로 초기화한다.
		 	참조변수가 null이라는 것은 참조할 객체가 없는 것을 의미한다.
		 	즉 Heap(힙)영역에 생성된 객체가 아예 없으므로 소유하지 않는
		 	것을 표현할 수 있다.
		 */
		if(bNum<=0) {
			gun = null;
		}
		else {
			gun = new Gun(bNum);
		}
	}
	// 수갑을 채우다 : 갯수가 차감된다.
	public void putHandcuff() {
		System.out.println("수갑채움~!넌콩밥~!");
		handCuffs--; 	
	}
	// 권총을 발사한다 : 단 소유한 총이 있을때만 쏠수있다.
	public void shut() {
		if(gun==null) {
			System.out.println("보유한 권총없음. 헛빵~!");
		}
		else {
			// 보유하고 있으므로 Gun객체의 멤버메서드를 통해 실행한다.
			gun.shutGun(); // 권총발사~
		}
	}
}

public class E05HasAComposite {

	public static void main(String[] args) {
		// 권총을 보유한 경찰을 표현
		System.out.println("==경찰1==");
		Police police1 = new Police(5, 3);
		police1.shut(); //발사 가능
		police1.putHandcuff();
		
		System.out.println("==경찰2==");
		Police police2 = new Police(0, 3);
		police2.shut(); //발사할 수 없음
		police2.putHandcuff();
	}
}