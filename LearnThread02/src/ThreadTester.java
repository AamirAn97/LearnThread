public class ThreadTester {

    public static void main(String[] args) {
        System.out.println("Main is starting");
        Thread t1 = new Thread1("Thread1");
        //To make a thread daemon thread we need to explicitly mention it by calling setDaemon(true)
        //t1.setDaemon(true);
        // start() method doesn't start the thread immediately, it notifies the JVM that it should start t1
        // thread now and depending on the mercy of JVM, whenever it wants it can start the thread
        t1.start();
        System.out.println("Main is exiting");

/*        output:
Main is starting
Main is exiting
Inside Thread[Thread1,5,main] iteration: 0
Inside Thread[Thread1,5,main] iteration: 1
Inside Thread[Thread1,5,main] iteration: 2
Inside Thread[Thread1,5,main] iteration: 3
Inside Thread[Thread1,5,main] iteration: 4
There won't be any specific order of the output that we are receiving, it totally depends on the JVM*/
    }
}

/*
In the above program 2 threads will be running, one is the main thread and other is t1 thread, hence t1 will
be the child thread of main thread since it was born from the main thread. So if we start another thread from an
already existing thread then there will be a parent child relation between the 2 threads.*/

/*
Even though the main thread got completed but the program didn't terminate as there was one user thread running,
the program will terminate if there was no user thread running, even though there could be daemon threads running.
Program termination totally depends on the mercy of JVM if there is only daemon thread running.*/
