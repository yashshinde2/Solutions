class StackArr{

    int arr[] = new int[5];
    int top = -1;

    public void push(int data){

        if(top == arr.length - 1){

            System.out.println("Stack Overflow");
            return;
        }

        top++;
        arr[top] = data;
    }

    public int pop(){

        if(top == -1){

            System.out.println("Stack is empty");
            return -1;
        }

        int value = arr[top];
        top--;
        return value;

    }

    public int peek(){

        if(top == -1){

            return -1;
        }
        return arr[top];
    }

    public void display(){

        for(int i = top; i >= 0; i--){

            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args){

        StackArr s = new StackArr();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        s.display();

        s.pop();
        s.display();

        s.peek();

    }
}