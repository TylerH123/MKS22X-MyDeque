import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String output = "{";
    if (size == 0){
      return "{}";
    }
    int s = start;
    for (int i = 0; i < size; i++){
      output += data[s%data.length] + " ";
      s++;
    }
    return output.substring(0,output.length()-1) + "}";
  }
  @SuppressWarnings("unchecked")
  private void resize() {
    E[] arr = (E[])new Object[data.length * 2 + 1];
    int idx = 0;
    if (start < end) {
      for (int i = start; i <= end; i++) {
        arr[idx] = data[i];
        idx++;
      }
    }
    else {
      for (int i = start; i < data.length; i++) {
        arr[idx] = data[i];
        idx++;
      }
      for (int i = 0; i <= end; i++) {
        arr[idx] = data[i];
        idx++;
      }
    }
    data = arr;
    start = 0;
    end = size-1;
  }
  public void addFirst(E element){
    if (element == null){
      throw new NullPointerException();
    }
    if (size == data.length){
      resize();
    }
    if (size != 0){
      if (start == 0){
        start = data.length-1;
      }
      else{
        start--;
      }
    }
    data[start-1] = element;
    size++;
  }
  public void addLast(E element){
    if (element == null){
      throw new NullPointerException();
    }
    if (size == data.length){
      resize();
    }
    if (size != 0){
      if (end == size-1){
        end = 0;
      }
      else{
        end++;
      }
    }
    data[start-1] = element;
    size++;
  }
  public E removeFirst(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    E og = data[start];
    if (start == size-1){
      start = 0;
      size--;
      return og;
    }
    start++;
    size--;
    return og;
  }
  public E removeLast(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    E og = data[end];
    if (end == 0){
      end = size-1;
      size--;
      return og;
    }
    size--;
    end--;
    return og;
  }
  public E getFirst(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    return data[start];
  }
  public E getLast(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    return data[end];
  }

  public static void main(String[] args){
    @SuppressWarnings("rawtypes")
    MyDeque m = new MyDeque();
    //System.out.println(m.size());
    /**m.addFirst(2);
    m.addFirst(5);
    m.addFirst(7);
    m.removeFirst();
    m.removeLast();**/
    //m.addLast(3);
    //System.out.println(m.size());
    //m.resize();
    //jSystem.out.println(m.size());
    System.out.println(m.toString());
  }
}
