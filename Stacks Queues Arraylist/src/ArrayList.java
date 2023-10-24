public class ArrayList {

    private Object[] arrayList = new Object[100000000];
    private int elements = 0;

    public void add(Object obj){
        arrayList[elements] = obj;
        elements++;
    }

    public void insert(Object obj, int index){

        elements++;

        Object temp = obj;
        Object temp2 = arrayList[index];

        for(int i = 0; i < elements; i++){
            arrayList[index+i] = temp;
            temp = temp2;
            temp2 = arrayList[index+i+1];
        }

    }

    public Object remove(int index){

        Object objAtIndex = arrayList[index];

        for(int i = 0; i < elements; i++){
            if(elements > index)
               arrayList[index+i] = arrayList[index+i+1];
        }
        elements--;
        return objAtIndex;
    }

    public int size(){
        return elements+1;
    }

    public String toString(){
        System.out.print("[" +arrayList[0]);
        for(int i = 1; i < elements; i++){
            System.out.print(" ," +arrayList[i]);
        }
        return "]";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean isEmpty(){
        return elements == 0;
    }

    public int indexOf(Object obj){
        for(int i = 0; i < elements; i++){
            Object temp = arrayList[i];
            if(temp.equals(obj))
                return i;
        }
        return -1;
    }

    public Object get(int index){
        return arrayList[index];
    }
}
