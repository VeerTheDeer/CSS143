/** for Class Design - IntList  */

public class ObjectList {   //or IntList, caps at 100 elements with no bullet-proofing or bounds checks, etc.
    private int numElements = 0;
    private Object[] myShapes = new Object[100];

    public void add(Object nx) {
        myShapes[numElements++] = nx;
    }

    public String toString() {
        String retVal = "";
        for(int i = 0; i < numElements; i++) {
            retVal += myShapes[i];
        }
        return retVal + " ";
    }

    //main goes here from the lab
}
