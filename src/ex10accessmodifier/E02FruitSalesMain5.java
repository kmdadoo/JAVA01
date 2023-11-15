package ex10accessmodifier;

class FruitSeller5{
	
	int numOfApple;
	int myMoney;
	final int APPLE_PRICE;
		
	public FruitSeller5(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price;
	}
	 
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
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

class FruitBuyer5{
	int myMoney;
	int numOfApple;
	
	public FruitBuyer5(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	 
	public void buyApple(FruitSeller5 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	
	// 구매자의 현재상태 출력
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과갯수:"+ numOfApple);		
	}
}

public class E02FruitSalesMain5 
{
	public static void main(String[] args) 
	{
		// 판매자1 : 사과100개, 단가 1000원으로 정의
		FruitSeller5 seller1 = new FruitSeller5(0, 100, 1000);
		// 판매자2 : 사과 80개, 단가 500원
		FruitSeller5 seller2 = new FruitSeller5(0, 80, 500);
		// 구매자 : 보유금액 10000원
		FruitBuyer5 buyer = new FruitBuyer5(10000, 0);
		
		System.out.println("구매행위가 일어나기 전의 상태");
		System.out.println("판매자의 1000원짜리 사과");
		seller1.showSaleResult();  // 사과100개, 금액 0원
		System.out.println("판매자의 500원짜리 사과");
		seller2.showSaleResult();  // 사과80개, 금액 0원
		System.out.println("손님은 왕이다.");
		buyer.showBuyResult();	// 사관0개, 금액 5000원
		
		/*
			아래의 코드는 문법적으로 오류가 없으나 지불금액과 구매한 사관의
			관계가 전쳐 맞지 않는 논리적 오류가 발생되었다.
			즉, 코드(메서드)로 구현한 규칙이 완전히 무너지게 된다.
			객체지향 프로그래밍에서는 이런 오류를 막기위해 멤버변수에 대한
			"정보은닉"을 권장하고 있다.
			멤버변수의 외부접근을 원척적으로 차단하고, 멤버메서드를 통해
			서만 접근하게 하여 프로그래밍의 논리적오류를 차단하는 역할을 
			한다. 
		*/
		// 각가의 판매자에게 1000원을 지불하고 사과를 구매한다.
		seller1.myMoney += 1000;	// 판매자1에게 1000원을 지불한다.
		seller1.numOfApple -= 50;	// 사과 50개를 구매했다.
		buyer.numOfApple += 50;	// 구매자는 50개의 사과가 증가한다.

		seller2.myMoney += 1000;	// 판매자2에게 1000원을 지불한다.
		seller2.numOfApple -= 70;	// 사과 70개를 구매했다.
		buyer.numOfApple += 70;	// 구매자는 70개의 사과가 증가한다.
						// 하지만 구매자의 금액은 차감되지 않는다.
		
		System.out.println("구매행위가 일어난 후의 상태");
		System.out.println("첫번째 판매자1");
		seller1.showSaleResult();  
		System.out.println("두번재 판매자2");
		seller2.showSaleResult(); 
		System.out.println("손님은 왕이다.");
		buyer.showBuyResult();
	}
}