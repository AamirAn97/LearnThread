public class ThreadTester {

    public static void main(String[] args) {
        System.out.println("Main is starting");
        Thread t1 = new Thread1();
        // start() method doesn't start the thread immediately, it notifies the JVM that it should start t1
        // thread now and depending on the mercy of JVM, whenever it wants it can start the thread
        t1.start();
        System.out.println("Main is exiting");

/*        output:
        Main is starting
        Main is exiting
        Inside Thread1, iteration: 0
        Inside Thread1, iteration: 1
        Inside Thread1, iteration: 2
        Inside Thread1, iteration: 3
        Inside Thread1, iteration: 4
        There won't be any specific order of the output that we are receiving, it totally depends on the JVM*/
    }
}

/*
In the above program 2 threads will be running, one is the main thread and other is t1 thread, hence t1 will
be the child thread of main thread since it was born from the main thread. So if we start another thread from an
already existing thread then there will be a parent child relation between the 2 threads.*/
