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
    }
    
    