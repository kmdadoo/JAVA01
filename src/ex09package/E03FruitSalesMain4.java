package ex09package;

import ex09package.study.buyer.FruitBuyer4;
import ex09package.study.seller.FruitSeller4;

/*
ex08class 패키지의 E06FruitSalesMain3 클래스를 그대로 복사한 후 
E03FruitSalesMain4로 파일명을 변경한다. 

연습문제] 해당 프로그램을 아래의 지시에 따라 패키지로 구분하여 정상 
실행되도록 변경하시오.

FruitSeller4 클래스 -> ex09package.study.seller 패키지에 묶는다.
FruitBuyer4 클래스 -> ex09package.study.buyer 패키지에 묶는다.

두 클래스를 적절히 import 하여 정상동작 할수 있도록 E03FruitSalesMain4 
클래스를 구성하시오.
 */
public class E03FruitSalesMain4 {

	public static void main(String[] args) {
		
		// 판매자1 : 사과100개, 단가 1000원으로 정의
		FruitSeller4 seller1 = new FruitSeller4(0, 100, 1000);
		// 판매자2 : 사과 80개, 단가 500원
		FruitSeller4 seller2 = new FruitSeller4(0, 80, 500);
		// 구매자 : 보유금액 10000원
		FruitBuyer4 buyer = new FruitBuyer4(10000, 0);
		
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