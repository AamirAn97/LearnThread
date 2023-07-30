public class Stack {
    private  int[] array;
    private  int stackTop;
    // which ever thread will have access to this lock will be able to entre the synchronized block
    Object lock;

    public Stack(int capacity) {
        array = new int[capacity];
        stackTop = -1;
        lock = new Object();
    }

//    // t1, t2, t3
//    public boolean push(int element) {
//        synchronized (lock) {
//            if(isFull()) return false;
//            ++stackTop;
//
//            try { Thread.sleep(1000); } catch (Exception e) { }
//            array[stackTop] = element;
//            return true;
//        }
//    }

    public synchronized boolean push(int element) {

        if(isFull()) return false;
        ++stackTop;

        try { Thread.sleep(1000); } catch (Exception e) { }
        array[stackTop] = element;
        return true;

    }

//    //t1, t4, t5
//    public int pop() {
//        synchronized (lock) {
//            if (isEmpty()) return Integer.MIN_VALUE;
//            int obj = array[stackTop];
//            array[stackTop] = Integer.MIN_VALUE;
//
//            try { Thread.sleep(1000); } catch (Exception e) { }
//
//            stackTop--;
//            return obj;
//        }
//    }

    public synchronized int pop() {
        if (isEmpty()) return Integer.MIN_VALUE;
        int obj = array[stackTop];
        array[stackTop] = Integer.MIN_VALUE;

        try { Thread.sleep(1000); } catch (Exception e) { }
        stackTop--;
        return obj;
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return  stackTop >= array.length - 1;
    }
}

/*
* Let's take an example where t1,t2 and t3 threads are trying to access the synchronized block inside push() and
* t1, t4 and t5 threads are trying to access the synchronized block inside pop(). Since, both the synchronized methods
* are bound by same 'lock' object hence, only one thread at a time could have the lock to access any synchronized
* block, even though push() and pop() could be completely different from each other. For example, if t2 is having
* the lock to access push() and t1 needs to access pop(), but since, both push() and pop() are bounded by same lock
* object then, t1 will have to wait for t2's execution to end so that it could have the lock to access pop().
* Even if we try to provide 2 different locks to push() and pop(), (lock1 and lock2) then it won't serve the purpose
* of synchronized block. Since, we are trying to avoid push() and pop() to access shared resource simultaneously,
* if we try to provide 2 different locks to these methods then, we are letting 2 threads to access push() and pop()
* simultaneously, nullifying the purpose of synchronized block. In order to avoid inconsistency, we need to make sure
* that both push() and pop() are bounded by same lock.
* */