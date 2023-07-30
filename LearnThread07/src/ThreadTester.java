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
* In order to avoid inconsistency during method calls where multiple threads are trying to alter a shared resource,
* we need to provide a locking mechanism where only one thread could access the shared resource block at a time.
*/
/*
* In order to avoid inconsistency when 2 threads are trying to access the same resource, we can use synchronized keyword
* There are multiple ways to use synchronized keyword:
* Case 1: By declaring the synchronized block inside the method that is trying to access the shared resource and passing
* any object as lock to the parameter of the synchronized block. Any object in Java can be used as a lock except
* primitive data types. We can't use int as a lock, but we can use instance of a wrapper class Integer as a lock.
* This case is used when we want to make a specific code synchronized. Here, we need to explicitly provide the lock.
* Case 2: By declaring the entire method as a synchronized block. Here, we don't need to explicitly provide the lock,
* the object itself (this) will be considered as a lock. So, if we are having multiple synchronized methods in a class
* then, at a time only one thread will be able to access all the synchronized methods. 'this' current object is used
* inside a non-static methods, as a lock. For static blocks, if we want to use synchronized keyword then CLASS_NAME.class
*  is used as a lock, since there is no object instantiation for a static block.
* */

/*
* Compiler will be translating :
* public synchronized boolean push(int element) {}
* into :
* public boolean push(int element) {
*   synchronized(this){}
* }
* */