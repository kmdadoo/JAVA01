package ex19thread;

class Increment {
	int num=0;

	/*
	1. 동기화 처리가 되지 않은 메서드 : 결과는 비정상적으로 나온다. 
		대신 실행속도는 매우 빠르다. 
	 */
//	public void increment() {
//		num++;
//	}

	/*
	2. 동기화메서드 : 메서드 전체를 동기화 한다. 이 경우 실행시간이 
		엄청나게 길어진다. 하지만 결과는 정상적으로 출력된다. 
	 */
//	synchronized public void increment() {
//		num++;
//	}
	
	/*
	3. 동기화블럭 : 메서드 내에서 필요한 코드만 동기화한다. 동기화메서드
		보다는 좋은 성능을 보여준다. 
	 */
	public void increment() {
		synchronized(this) {
			num++;
		}
	}
	
	public int getNum() {
		return num;
	}
}

class IncThread extends Thread {
	
	Increment inc;

	public IncThread(Increment inc) {
		this.inc = inc;
	}
	//1억번 실행되는 메소드
	public void run() {
		for(int i=1 ; i<=10000 ; i++) {
			for(int j=1 ; j<=10000 ; j++) {
				inc.increment();
			}
		}
	}
}

public class Ex05Sync2Longtime
{
	public static void main(String[] args)
	{
		Increment inc = new Increment();	
		
		IncThread it1 = new IncThread(inc);
		IncThread it2 = new IncThread(inc);
		IncThread it3 = new IncThread(inc);		
		
		it1.start();
		it2.start();
		it3.start();		
		try {
			it1.join();
			it2.join();
			it3.join();
		}
		catch (InterruptedException e) {}
		System.out.println("결과:"+ inc.getNum());
	}	
}









