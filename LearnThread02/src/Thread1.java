// Creating a thread by extending Thread class
public class Thread1 extends Thread {

    public Thread1(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            // Thread.currentThread() returns the current instance of the thread, will return
            // [current thread instance, priority, parent thread]
            System.out.println("Inside " + Thread.currentThread() + " iteration: " + i);
            //if you want to get only current thread name then use Thread.currentThread().getName()

        }
    }
}
