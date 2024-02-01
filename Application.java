import java.util.Collection;
import java.util.Iterator;

/**
 * A class to provide a simple list.
 * List resizes automatically. Used to illustrate 
 * various design and implementation details of 
 * a class in Java.
 * 
 * @author scottm
 *
 */
public class GenericListVersion2 implements Iterable{
    // class constant for default size
    private static final int DEFAULT_CAP = 10;
    
    //instance variables
    // iValues store the elements of the list and 
    // may have extra capacity
    private Object[] iValues;
    private int iSize;
    
    private class GenericListIterator implements Iterator{
        private int position;
        private boolean removeOK;
        
        private GenericListIterator(){
            position = 0;
            removeOK = false;
        }
        
        public boolean hasNext(){
            return position < iSize;
        }
        
        public Object next(){
            Object result = iValues[position];
            position++;
            removeOK = true;
            return result;
        }
		       
        public void remove(){
            if( !removeOK )
                throw new IllegalStateException();
            // which element should be removed??
            removeOK = false;
            GenericListVersion2.this.remove(position - 1);
            position--;
        }
    }
    
    public Iterator iterator(){
        return new GenericListIterator();
    }
    
    public void addAll(Collection c){
       // for each loop
        for(Object obj : c){
            this.add(obj);
        }
		#Add new functionality to the branch feature2.1 by Vivek for the module Reports on Mar.2023
		// create a method
  public int addNumbers(int a, int b) {
    int sum = a + b;
    // return value
    return sum;
  }

  public static void main(String[] args) {
    
    int num1 = 25;
    int num2 = 15;

    // create an object of Main
    Main obj = new Main();
    // calling method
    int result = obj.addNumbers(num1, num2);
    System.out.println("Sum is: " + result);
  }
  #End of feature2.1 code
  
}
    }
    
    