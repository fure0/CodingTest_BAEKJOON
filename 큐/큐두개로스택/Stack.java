import java.util.LinkedList;
import java.util.Queue;

public class Stack<T> {

  Queue<T> queue1 = new LinkedList<>();
  Queue<T> queue2 = new LinkedList<>();

  public void push(T t) {
    queue1.add(t);
  }

  public T pop() {
    while (queue1.size() > 1) {
      queue2.add(queue1.poll());
    }
    // queue1 = 3
    // queue2 = 1,2

    Queue<T> temp = queue1;
    queue1 = queue2;
    queue2 = temp;

    return queue2.poll();
    
  }

  public static void main(String[] args) {
    Stack<Integer> myStack = new Stack<Integer>();

    myStack.push(1);
    myStack.push(2);
    myStack.push(3);
    System.out.println(myStack.pop());
  }

}
