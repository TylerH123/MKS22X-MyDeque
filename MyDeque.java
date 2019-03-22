import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 10;
    start = 0;
    end = 0;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = initialCapacity;
    start = 0;
    end = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String output = "{";
    int g = start;
    for (int i = 0; i < size; i++){
      if (g >= size){
        g = 0;
      }
      if (g != end){
        output += data[g] + " ";
        g++;
      }
    }
    output += data[end];
    return output + "}";
  }
  private void resize(){
    @SuppressWarnings("unchecked")
    E[] arr = (E[]) new Object[size * 2 + 1];
    for (int i = 0; i < size; i++){
      arr[i] = data[i];
    }
    size = size * 2 + 1;
  }
  public void addFirst(E element){
    if (element == null){
      throw new NullPointerException();
    }
    if (data[start] == null){
      data[start] = element;
    }
    else{
      if (start <= 0){
        start = size;
      }
      data[start-1] = element;
      start--;
    }
  }
  public void addLast(E element){
    if (element == null){
      throw new NullPointerException();
    }
    if (data[end] == null){
      data[end] = element;
    }
    else {
      if (end >= size-1){
        end = -1;
      }
      data[end+1] = element;
      end++;
    }
  }
  public E removeFirst(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    if (start == size-1){
      E og = data[start];
      start = 0;
      return og;
    }
    E og = data[start];
    start++;
    return og;
  }
  public E removeLast(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    if (end == 0){
      E og = data[end];
      end = size-1;
      return og;
    }
    E og = data[end];
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
    m.addFirst(2);
    m.addFirst(5);
    m.addFirst(7);
    m.addLast(3);
    m.removeFirst();
    m.removeLast();
    System.out.println(m.toString());
  }
}
