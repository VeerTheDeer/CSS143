public class Stack extends ArrayBasedDataStructuresDriver{

    private Object[] stack = new Object[10000000];
    private Object stackTop;
    private int elements;


    public void push(Object obj){
        elements++;
        stackTop = obj;

        for(int i = 0; i < elements; i++){
            Object temp = stack[elements-i-1];
            stack[elements-i] = temp;
        }
        stack[0]=obj;
    }

    public Object pop(){
        stackTop = stack[0];
        for(int i = 0; i < elements; i++){
            stack[i] = stack[i+1];
        }
        if(elements == 0)
            stack[0] = null;
        elements--;
        return stackTop;
    }

    public int size(){
        return elements;
    }

    public String toString(){
        System.out.print("[" +stack[0]);
        for(int i = 1; i < elements; i++){
            System.out.print(" ," +stack[i]);
        }
        return "]";
    }

    public boolean isEmpty(){
        return elements == 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
