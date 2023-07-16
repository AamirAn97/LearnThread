public class ThreadTester {

    public static void main(String[] args) {
        System.out.println("Main is starting");

//        If we want we can pass thread name in construct or leave it as it is
//        Thread thread = new Thread(new Thread2());
//        Since Runnable is a functional interface, we can also create thread using lambda expression
//        as shown below.
        Thread thread = new Thread(()->{
            for(int i=0; i<5; i++){
                // Thread.currentThread() returns the current instance of the thread, will return
                // [current thread instance, priority, parent thread]
                System.out.println("Inside " + Thread.currentThread() + " iteration: " + i);
                //if you want to get only current thread name then use Thread.currentThread().getName()

            }
        }, "thread2");
        thread.start();

        System.out.println("Main is exiting");

/*        output:
Main is starting
Main is exiting
Inside Thread[thread2,5,main] iteration: 0
Inside Thread[thread2,5,main] iteration: 1
Inside Thread[thread2,5,main] iteration: 2
Inside Thread[thread2,5,main] iteration: 3
Inside Thread[thread2,5,main] iteration: 4
There won't be any specific order of the output that we are receiving, it totally depends on the JVM*/
    }
}

/*
* Implementing Runnable interface is mostly preferred, since extending the Thread class has a constraint
* If we create a thread by extending then JVM will not let us extend any more class as multiple inheritance
* is not allowed. But if we implement runnable interface then we can implement multiple interfaces as it is
* allowed. Hence, implementing runnable interface is preferred.
* */