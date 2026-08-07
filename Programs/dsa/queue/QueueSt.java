import java.util.*;

class QueueSt{

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public boolean isEmpty(){

        return s1.isEmpty(); 
    }

    public void enqueue(int data){

        while(!s1.isEmpty()){

            s2.push(s1.pop());
        }

        s1.push(data);

        while(!s2.isEmpty()){

            s1.push(s2.pop());
        }
    }

    public int dequeue(){

        if(isEmpty()){

            System.out.println("Queue is underflow");
            return -1;
        }

        return s1.pop();
    }

    public int peek(){

        if(isEmpty()){

            System.out.println("Queue is underflow");
            return -1;
        }

        return s1.peek();
    }

    public static void main(String[] args){

        QueueSt q = new QueueSt();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        while(!q.isEmpty()){

            System.out.println(q.peek());
            q.dequeue();
        }
    }
}