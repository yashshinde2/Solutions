class QueueArr{
    
    int[] arr = new int[5];
    int rear = -1;

    public void enqueue(int data){

        if(rear == arr.length - 1){

            System.out.println("Queue is full");
            return;
        }

        rear++;
        arr[rear] = data;
    }

    public int dequeue(){

        if(rear == -1){

            System.out.println("Queue is underflow");
            return -1;
        }
        
        int front = arr[0];

        for(int i = 0; i < rear; i++){
                arr[i] = arr[i+1];
        }

        rear--;
        return front;

    }

    public void display(){

        for(int i = 0; i < rear; i++){

            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }


    public int peek(){

        if(rear == -1){

            return -1;
        }
        return arr[0];
    }


    public static void main(String[] args){

            QueueArr q = new QueueArr();

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