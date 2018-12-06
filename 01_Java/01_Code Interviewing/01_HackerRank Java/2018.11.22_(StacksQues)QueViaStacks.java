//https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem

public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
            if(stackOldestOnTop.isEmpty()){
                upEndStack();
            }
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            if(stackOldestOnTop.isEmpty()){
                upEndStack();
            }
            return stackOldestOnTop.pop();
        }

        public void upEndStack(){
            if(stackNewestOnTop.isEmpty()){
                throw new EmptyStackException();
            }
            while(!stackNewestOnTop.isEmpty()){
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }