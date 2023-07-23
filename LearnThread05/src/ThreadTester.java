public class ThreadTester {

    public static void main(String[] args) {
        System.out.println("Main is starting");

/*        Thread thread = new Thread(()->{
            for(int i=0; i<5; i++){
                // Thread.currentThread() returns the current instance of the thread, will return
                // [current thread instance, priority, parent thread]
                System.out.println("Inside " + Thread.currentThread() + " iteration: " + i);
                //if you want to get only current thread name then use Thread.currentThread().getName()

            }
        }, "thread2");
        thread.start();*/
        Stack stack = new Stack(5);

        new Thread(() -> {
            int counter = 0;
            while (++ counter < 10)
                System.out.println("Pushed: " + stack.push(100));
        }, "Pusher").start();

        new Thread(() -> {
            int counter = 0;
            while (++ counter < 10)
                System.out.println("Popped: " + stack.pop());
        }, "Popper").start();

        System.out.println("Main is exiting");

    }
/*
* Output:
* Main is starting
* Main is exiting
* Pushed: true
* Popped: 0
* Popped: 100
* Popped: -2147483648
* Popped: -2147483648
* Popped: -2147483648
* Popped: -2147483648
* Popped: -2147483648
* Popped: -2147483648
* Popped: -2147483648
* Exception in thread "Pusher" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 5
* 	at Stack.push(Stack.java:15)
* 	at ThreadTester.lambda$main$0(ThreadTester.java:21)
* 	at java.base/java.lang.Thread.run(Thread.java:833)
* */
}

/*
* In this example, it is being demonstrated that when 2 threads try to access same resource then there could be some inconsistency because of which the program
* may throw some exception. push() might have executed its code and went to sleep and during that time pop() might have decreased the stackTop value to some
* negative value, hence the program is throwing ArrayIndexOutOfBoundsException. So there are cases where we cannot let 2 threads access same resources (methods or
* fields/variables) simultaneously. In order to tackle such situations we use thread safe classes to avoid such inconsistency. Since, push() and pop() methods
* are making changes to shared resources, so they may fell into inconsistency, in order to avoid it we need to use methods like lock where when one method is trying
* to access a shared resources then only that method/thread will have the lock with it to access the resources, no other method/thread could access it. Only
* when the first thread will complete its execution and hand over the lock to JVM/CPU Scheduler (based on the scheduling algorithm the scheduler will decide
* which thread it will hand over the lock to) then other thread can have that lock and access the shared resource. This way only one thread can access the
* shared resource at a time and inconsistency can be avoided.
*
* */
