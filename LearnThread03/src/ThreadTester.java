public class ThreadTester {

    public static void main(String[] args) {
        System.out.println("Main is starting");

//        If we want we can pass thread name in construct or leave it as it is
//        Thread thread = new Thread(new Thread2());
        /*
        * Case 1: extending Thread class
        * Since Thread class has its own implementation for run(), so either we need to pass Runnable object (Discussed
        * in Case 2) to the constructor of Thread class, or we need to extend the Thread class (as done in Thread1 class)
        * so that we could override the run() to provide our own implementation.
        * Case 2: implementing Runnable interface
        * The below Thread class is itself implementing a runnable interface. Hence, it has a implementation od run()
        * of its own, but new Thread().run() would return nothing.
        * The Thread class has a field "private Runnable target;"
        * Implementation of run() in Thread class:
        *@Override
        *public void run() {
        *    if (target != null) {
        *        target.run();
        *    }
        *}
        * So, in order to make the run() work, we need to provide our own Runnable object i.e. new Thread2()
        * with our own implementation for run() method. "target" is being the Runnable object that we are passing,
        * since it won't be null, so it will execute target.run(), that contains our implementation for run() method.
        * */
        Thread thread = new Thread(new Thread2(), "thread2");
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