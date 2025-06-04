package thread;

public class Week08_p601_SleepTest extends Thread{
    public void run() {
        for(int i=0;i<10;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(i + "\t");
        }
    }

    public static void main(String[] args) {
        Week08_p601_SleepTest test = new Week08_p601_SleepTest();
        test.start();
    }
}
