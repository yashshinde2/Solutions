class LL{
    Node head;
    private int size;

    LL(){

        size = 0;
    }

    class Node{

        String data;
        Node next;

        Node(String data){

            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(String data){

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }

    public void addLast(String data){

        Node newNode = new Node(data);

        if(head == null){

            head = newNode;
            return;
        }

        Node lastNode = head;

        while(lastNode.next != null){

            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public void printList(){

        Node currNode = head;

        while(currNode != null){

            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
            System.out.println("null");
    }

    public void deleteFirst(){

        if(head == null){

            System.out.println("List is empty");
            return;
        }

        head = this.head.next;
        size--;

    }

    public void deleteLast(){
        
        if(head == null){

            System.out.println("List is empty");
            return;
        }

        size--;

        if(head.next == null){

            head = null;
            return;
        }

        Node currNode = head;
        Node lastNode = head.next;

        while(lastNode.next != null){

            currNode = currNode.next;
            lastNode = lastNode.next;
        }

        currNode.next = null;
    }

    public int getSize(){

        return size;
    }

    public static void main(String[] arrgs){

        LL list = new LL();
        list.addFirst("this");
        list.addFirst("a");
        list.addFirst("linked");
        list.addFirst("list");

        list.printList();

        list.deleteFirst();
        list.printList();

        System.out.println(list.getSize());

        list.deleteLast();
        list.printList();

        System.out.println(list.getSize());

    }
}