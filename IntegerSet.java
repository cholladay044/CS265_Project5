public class IntegerSet {
    private int size;
    private Node head;
    
    IntegerSet(){
        this.head = null;
        this.size = 0;
    }
    IntegerSet(int size){
        this.size = size;
        this.head = null;
    }
    public int getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        boolean flag = false;
        if (size == 0)
            flag = true;
        return flag;
    }
    public boolean isMember(int item){
        boolean flag = false;
        Node current  = head;   
        while(current != null){
            if(current.data == item){
                flag = true;
                break;
            }
            current = current.next;
            }
            return flag;                
       }
    public boolean add(int item){
        boolean flag = false;
        if (head == null){
            head = new Node(item);
            return flag;
        }
        Node current = head;
        while (current.next != null){
            if (current.data == item){
                flag = false;
                break;
            }
            else{
                current = current.next;
            }    
        }
        current.next = new Node(item);
        size++;
        return flag;
    }
    public boolean remove(int item){
        boolean flag = false;
        if (head.data == item){
            head = head.next;
            size--;
            return flag;
        }
        Node current = head;
        while (current.next != null){
            if (current.next.data == item){
                current.next = current.next.next;
                size--;
                flag = true;
            }
            current = current.next;
        }
        return flag;
    }
    public boolean isSubnet(IntegerSet s2){
        boolean flag = true;
        sortAscending(s2);
        sortAscending(this);
        Node thisCurrent = this.head;
        Node s2Current = s2.head;
        while (thisCurrent.next != null && s2Current.next != null){
            if (thisCurrent.data != s2Current.data){
                flag = false;
                break;
            }
            thisCurrent = thisCurrent.next;
            s2Current = s2Current.next;
        }
        return flag;
    }
    /*
    Some logic in this code is referenced on https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
    Title: Union and Intersection of two Linked Lists
    */
    public IntegerSet intersection(IntegerSet s2){
        IntegerSet temp = new IntegerSet();
        Node current = s2.head;
        
        while (current.next != null){
            if (this.isMember(current.data)){
                temp.add(current.data);
            }
            current = current.next;
        }
        return temp;
    }
    /*
    Some logic in this code is referenced on https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
    Title: Union and Intersection of two Linked Lists
    */
    public IntegerSet union(IntegerSet s2){
        IntegerSet temp = new IntegerSet();
        Node current = this.head;
        Node tempCurrent = temp.head;
        Node s2Current = s2.head;
        while (current.next != null){
            temp.add(current.data);
            current = current.next;
        }
        while (s2Current.next != null){
            if (!(temp.isMember(s2Current.data))){
                temp.add(s2Current.data);
            }
            s2Current = s2Current.next;
        }
        return temp;
    }
    /*
    Some logic in this code is referenced on https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
    Title: Union and Intersection of two Linked Lists
    */
    public IntegerSet difference(IntegerSet s2){
        IntegerSet temp = new IntegerSet();
        Node current = this.head;
        Node s2Current = s2.head;
        while (current.next != null){
            temp.add(current.data);
            current = current.next;
        }
        Node tempCurrent = temp.head;
        while (s2Current.next != null){
            if (temp.isMember(s2Current.data)){
                temp.remove(s2Current.data);
            }
            s2Current = s2Current.next;
        }
        return temp;
    }
    public void display(){
        Node current = this.head;
        String results = "";
        while (current != null){
            results += current.data + "->";
            current = current.next;
        }
        System.out.println(results);
    }
    private static void sortAscending(IntegerSet s){
        for (Node i = s.head; i !=null; i = i.next ){
            for (Node j = i.next; j != null; j = j.next){
                if (i.data > j.data){
                    i.data = j.data;
                }
            }
        }
    }
    class Node {
        private int data;
        private Node next;
    
        Node(){
        }
        Node(int data){
            this.data = data;
        }
        public Node getNext(){
            return this.next;
        }
        public int getData(){
            return this.data;
        }
        public void setNext(Node n){
            this.next = n;
        }
    }
}
