// Creating a thread by extending Thread class
public class Thread1 extends Thread {

    @Override
    public void run() {

        for(int i=0; i<5; i++){
            System.out.println("Inside Thread1, iteration: " + i);
        }
    }
}
