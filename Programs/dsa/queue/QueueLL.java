class QueueLL{

    class Node{

        int data;
        Node next;

        Node(int data){

            this.data = data;
            this.next = null;

        }
    }

    Node head = null;
    Node tail = null;


    public void enqueue(int data){
        Node newNode = new Node(data);

        if(tail == null){

            tail = head = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public int dequeue(){

        if(tail == null){

            System.out.println("Queue is underflow");
            return -1;
            
        }

        int value = head.data;

        head = head.next;
        return value;

    }

    public void display(){

        Node temp = head;

        while(temp != null){

            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    public int peek(){

        if(tail == null){

            System.out.println("Queue is underflow");
            return -1;  
        }

        return head.data;

    }

    public static void main(String[] args){

        QueueLL q = new QueueLL();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.display();

        q.dequeue();
        q.display();     

        System.out.println(q.peek());
    }
}