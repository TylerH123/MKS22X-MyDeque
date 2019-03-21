public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 10;
    start = 0;
    end = data.length -1;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = initialCapacity;
    start = 0;
    end = data.length -1;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String output = "{";
    for (int i = 0; i < data.length; i++){
      if (i == data.length - 1){
        output += data[i];
      }
      else{
        output += data[i] + " ";
      }
    }
    return output + "}"; 
  }
  public void addFirst(E element){ }
  public void addLast(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
}
