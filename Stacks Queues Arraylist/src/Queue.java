public class Queue {
    private Object[] queue= new Object[10000000];
    private Object front, back;
    private int elements = 0;


    public void enqueue(Object obj){
        elements++;

        queue[elements-1] = obj;

        front = queue[0];
        back = queue[elements-1];
    }

    public Object dequeue(){

        front = queue[0];
        back = queue[elements-1];

        for(int i = 0; i < elements; i++){
                queue[i] = queue[i+1];
        }
        elements--;
        return front;
    }

    public int size(){
        return elements;
    }

    public String toString(){
        System.out.print("[" + queue[0]);
        for(int i = 1; i < elements; i++){
            System.out.print(" ," +queue[i]);
        }
        return "]";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean isEmpty(){
        front = queue[0];
        back = queue[elements];
        return front == null && back == null;
    }
}
