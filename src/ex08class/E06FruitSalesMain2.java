package ex08class;

/*
	첫번째 버전은 각 클래스의 멤버변수가 고정된 초깃값으로 선언되어 상태가 
	다른 객체를 생성할 수 없는 단점이 있었다.
	두번째 버전에서는 다양한 초기값을 부여할 수 있도록 초기화 메서드를 도입
	한다. 
*/
class FruitSeller2{
	
	int numOfApple;
	int myMoney;
	//기존에 상수로 선언했던 부분을 일반 멤버변수로 변경한다. 
	int apple_price;
	
	/*
		사과의 단가를 표현하는 멤버변수가 상수로 선언되면 선언과 동시에
		초기화해야한다. 또한 초깃값이 없는 상태로 선언 자체가 불가능하다. 
		따라서 기존의 상수를 일반 변수로 변경해야 한다. 
	 */
	
	/*
		초기화 메서드를 선언하여 객체 생성후 다양한 형태의 초기화가 가능
		하다.
	 */
	public void initMember(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		apple_price = price;
	}
	 
	public int saleApple(int money) {
		int num = money / apple_price;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	
	// 판매자의 현재상태를 출력한다.
	public void showSaleResult() {
		System.out.println("[판매자]남은사과갯수:"+ numOfApple);
		System.out.println("[판매자]판매수익:"+ myMoney);
	}
}

class FruitBuyer2{
	int myMoney;
	int numOfApple;
	
	// 초기화메서드 정의
	public void initMember(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	 
	public void buyApple(FruitSeller2 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	
	// 구매자의 현재상태 출력
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과갯수:"+ numOfApple);		
	}
}

public class E06FruitSalesMain2 {

	public static void main(String[] args) {
		
		/*
			초기화 메서드가 정의되었으므로 상태가 다른 객체를 생성할 수 
			있다.
			하지만 객체생성과 초기화를 각각 진행해야 한다는 단점이 존재한다.
		 */
		// 판매자1 : 사과100개, 단가 1000원으로 정의
		FruitSeller2 seller1 = new FruitSeller2();
		seller1.initMember(0, 100, 1000);
		// 판매자2 : 사과 80개, 단가 500원
		FruitSeller2 seller2 = new FruitSeller2();
		seller2.initMember(0, 80, 500);
		// 구매자 : 보유금액 10000원
		FruitBuyer2 buyer = new FruitBuyer2();
		buyer.initMember(10000, 0);
		
		System.out.println("구매행위가 일어나기 전의 상태");
		System.out.println("판매자의 1000원짜리 사과");
		seller1.showSaleResult();  // 사과100개, 금액 0원
		System.out.println("판매자의 500원짜리 사과");
		seller2.showSaleResult();  // 사과80개, 금액 0원
		System.out.println("손님은 왕이다.");
		buyer.showBuyResult();	// 사관0개, 금액 5000원
		
		// 구매자가 판매자에게 각각의 사과를 5000원씩 지불하고 
		// 사과를 구매한다.
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);
		
		System.out.println("구매행위가 일어난 후의 상태");
		System.out.println("판매자의 1000원짜리 사과");
		seller1.showSaleResult();  // 사과95개, 금액 5000원
		System.out.println("판매자의 500원짜리 사과");
		seller2.showSaleResult();  // 사과70개, 금액 5000원
		System.out.println("손님은 왕이다.");
		buyer.showBuyResult();	// 사관15개, 금액 0원
	}
}