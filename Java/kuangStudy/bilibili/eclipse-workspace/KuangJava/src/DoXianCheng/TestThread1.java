package DoXianCheng;

public class TestThread1 extends Thread {
    public void run() {
        for (int i=0; i<200; i++){
            System.out.println("���ڿ�����--"+i);
        }
    }

	public static void main(String[] args) {
		
	    TestThread1 testThread1 = new TestThread1();
	    testThread1.start();
	    
	    for (int i=0; i<1000; i++){
	        System.out.println("����ѧϰ���߳�--"+i);
	    }
	}
}