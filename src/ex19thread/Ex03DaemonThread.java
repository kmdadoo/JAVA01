package ex19thread;

/*
쓰레드로 구현하지 않은 일반적인 클래스
	: 하나의 클래스가 작업을 완료해야 다음 클래스의 작업을 진행할수있다. 
	즉 동시에 작업을 진행할 수 없다. 
 */
class NormalClass
{
	String title;
	public NormalClass(String title) 
	{
		this.title = title;
	}
	
	//단순 10번 반복
	void classMethod() 
	{
		for(int i=1 ; i<=10 ; i++) {
			System.out.printf("%s]i=%d%n", title, i);
		}
	}
}

/*
독립쓰레드(Non Daemon Thread)
	: 메인쓰레드와 Working쓰레드(개발자가 정의한 쓰레드)를 일컫는 것으로
	메인쓰레드가 종료되어도 계속 실행되며, Dead상태가 되어야 실행이 종료되는
	쓰레드를 말한다. 해당 쓰레드는 main() 메서드가 종료된 이후에도 계속 
	실행되는것을 볼수있다. 
 */
class NormalThread extends Thread
{	 
	// 기본생성자를 통해 객체를 생성하면 쓰레드명이 JVM에 의해 자동으로
	// 부여된다.
	public NormalThread() {}

	/*
	Thread클래스의 생성자를 호출할때 전달하는 인수를 통해 해당 쓰레드의 
	이름을 지정할 수 있다. 이때 지정된 이름을 getName()을 통해 반환할수
	있다. 
	 */
	public NormalThread(String title) 
	{
		super(title);
	}
	
	/*
	쓰레드 동작중 비정상적으로 종료될때 InterruptedException이 발생할수
	있다. 여기서는 예외를 처리하지않고 무시한다. 
	 */
	void threadMethod() throws InterruptedException
	{
		/*
		10번 반복중 2초씩 block상태로 들어가므로 총 20초간 반복된다. 
		반복횟수와 쓰레드명을 출력한다. 
		 */
		for(int i=1 ; i<=10 ; i++) {
			System.out.printf("%s]i=%d%n", getName(), i);
			sleep(2000); 
		}
	}
	
	@Override
	public void run() 
	{
		try {
			threadMethod();
		}
		catch(InterruptedException e) {}
	}
}

/*
종속쓰레드(Daemon Thread)
	: 모든 독립쓰레드가 종료되면 자동으로 종료되는 쓰레드를 말한다. 
	메인메서드도 하나의 독립쓰레드이므로, 다른 독립쓰레드가 남아있다면
	종료될때까지는 프로그램이 종료된것은 아니다. 
	주로 프로그램의 보조역할로 배경음악재생, 로그자동저장 등의 업무를
	처리한다. 프로그램이 종료될때 자동으로 종료되므로 주로 무한루프로 구성한다.
 */
class DaemonThread extends Thread
{
	@Override
	public void run() {
		// 무한루프로 구성되어있고 별도의 탈출조건을 만들지 않는다. 
		// getName() : 쓰레드명을 반환한다. 
		while(true) {
			System.out.printf("[쓰레드명:%s]Jazz가 흘러요~%n", getName());
			try {
				sleep(3000);
				System.out.println("3초마다 자동저장!!");
			}
			catch(InterruptedException e) {
				System.out.println("자동저장시 오류발생 ㅜㅜ");
			}
		}
	}
}
public class Ex03DaemonThread
{
	public static void main(String[] args)
	{
		/*
		쓰레드로 구현하지 않는 일반적인 클래스의 작업으로
		순차적으로 진행되어 1번객체가 작업을 마쳐야만 2번객체가 실행된다. 
		 */
		NormalClass nt1 = new NormalClass("첫번째 클래스");
		nt1.classMethod();
		new NormalClass("두번째 클래스").classMethod();
		
		// 첫번째 독립 쓰레드 생성 및 시작(우선순위가 없으므로 5로 지정된다)
		// 쓰레드명 부여1 : 생성자를 이용한다. 
		NormalThread yt1 = new NormalThread("1st 쓰레드");
		//쓰레드명 부여2 : setName() 메서드를 이용한다. 
//		yt1.setName("First 쓰레드");
		yt1.start(); 
		
		// 두번째 독립쓰레드 생성 및 시작
		// 쓰레드명을 부여하지 않았으므로 JVM이 자동으로 이름을 부여한다.
		NormalThread yt2 = new NormalThread();
		//우선순위를 10으로 지정한다. 
		yt2.setPriority(Thread.MAX_PRIORITY); 
		yt2.start();
		
		// 먼저 독립쓰레드를 생성한 후 setDaemon() 메서드로 데몬쓰레드로
		// 만들어준다.
		DaemonThread dt = new DaemonThread();
		// 쓰레드명을 지정한다.
		dt.setName("데몬쓰레드");
		// 여기서 데몬쓰레드가 된다. 
		dt.setDaemon(true); 
		dt.start();

		// Thread클래스의 정적메소드를 통해 쓰레드의 여러상태를 확인할수있다.
		System.out.println("현재 활성화 된 상태의 쓰레드수"+
				Thread.activeCount());
		System.out.println("현재 실행중인 쓰레드명:"+
				Thread.currentThread().getName());
		System.out.println("메인함수의 우선순위:"+
				Thread.currentThread().getPriority());
		System.out.println("메인함수(Main Thread) 종료");
	}
}