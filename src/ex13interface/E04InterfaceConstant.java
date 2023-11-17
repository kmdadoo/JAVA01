package ex13interface;

import java.util.Scanner;

public class E04InterfaceConstant {

	public static void main(String[] args) {
		
		System.out.println("가위(1) 바위(2) 보(3) 게임입니다.");
		System.out.print("선택하세요(정수입력): ");
		
		Scanner sc = new Scanner(System.in);
		int sel = sc.nextInt();
		
		switch (sel) {
		/*
		가위, 바위, 보를 1, 2, 3으로 설정했지만 설정값이 많은 경우 모두
		기억하기 힘들 수 있으므로 명시적인 단어를 통한 상수를 사용하면
		코드의 가독성이 높아진다.
		 */
		case Game.SCISSORS: 
			System.out.println("가위를 냈습니다.");
			break;
		case Game.ROCK: 
			System.out.println("바위를 냈습니다.");
			break;
		case Game.PAPER: 
			System.out.println("보자기를 냈습니다.");
			break;		
		default:
			System.out.println("잘못 냈습니다.");
		}
	}
}