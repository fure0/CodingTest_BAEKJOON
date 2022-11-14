import java.util.Stack;

public class Queue<T> {

  Stack<T> stack1 = new Stack<>();
  Stack<T> stack2 = new Stack<>();

  private void moveIfAbsent() {
    if (stack2.size() == 0)
      while (stack1.size() != 0)
        stack2.add(stack1.pop());
  }

  public void add(T t) {
    stack1.add(t);
  }

  public T peek() {
    moveIfAbsent();
    return stack2.peek();
  }

  public T poll() {
    moveIfAbsent();
    return stack2.pop();
  }

  public int size() {
    return stack1.size() + stack2.size();
  }

  public static void main(String[] args) {
    Queue<Integer> myQueue = new Queue<Integer>();

    myQueue.add(1);
    myQueue.add(2);
    myQueue.add(3);
    System.out.println(myQueue.poll());
    //System.out.println(myQueue.peek());
    // System.out.println(myQueue.size());
  }
  }

/*
https://deveric.tistory.com/79

add : 1번 스택에 원소를 넣는다.
poll : 1번 스택에 있는 원소들을 모드 2번 스택으로 옮긴다. 이 때 원소들의 순서가 바뀐다. (큐의 순서와 동일하게 됨)
       2번 스택에서 pop시킨다.

       만약 2번 스택이 비어있지 않다면 1번 과정을 생략한다.
       2번 스택이 비어있지 않은 상태로 1번 과정을 진행하면 원소들의 순서가 뒤죽박죽으로 섞일 수 있다.

size : 두 스택에 있는 원소들의 합을 반환합니다.
*/