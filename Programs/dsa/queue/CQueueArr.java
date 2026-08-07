class CQueueArr {

    int size = 5;
    int arr[] = new int[size];

    int front = -1;
    int rear = -1;

    public void enqueue(int data) {

        if ((rear + 1) % size == front) {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % size;
        }

        arr[rear] = data;
    }

    public int dequeue() {

        if (front == -1) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int result = arr[front];

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }

        return result;
    }

    public int peek() {

        if (front == -1)
            return -1;

        return arr[front];
    }

    public void display() {

        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        int i = front;

        while (true) {

            System.out.print(arr[i] + " ");

            if (i == rear)
                break;

            i = (i + 1) % size;
        }

        System.out.println();
    }

    public static void main(String args[]) {

        CQueueArr q = new CQueueArr();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Dequeued = " + q.dequeue());

        q.display();

        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);

        q.display();
    }
}