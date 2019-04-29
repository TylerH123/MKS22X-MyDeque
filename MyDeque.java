import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = -1;
    end = -1;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = -1;
    end = -1;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String output = "{";
    if (size == 0){
      return "{}";
    }
    if (start == end){
      output += data[0];
    }
    else{
      for (int i = start; start < data.length; i++){
        output += data[i] + " ";
      }
      for (int i = 0; i < end; i++){
        output += data[i] + " ";
      }
    }
    return output + "}";
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
    end = size - 1;
  }
  public void addFirst(E element){
    if (element == null){
      throw new NullPointerException();
    }
    if (start == end + 1 || start == end - 1 && start == data.length){
      resize();
      addFirst(element);
    }
    else if (size == 0){
      data[0] = element;
      start = 0;
      end = 0;
    }
    else if (start == 0 && size < data.length){
      start = data.length - 1;
      data[start] = element;
    }
    else if (start > end + 1){
      start--;
      data[start] = element;
    }
    else if (start > 0 && start < end){
      start--;
      data[start] = element;
    }
    size++;
  }
  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if (end == start + 1 || end == start - 1 && size == data.length || size == data.length) {
      resize();
      addLast(element);
    }
    else if (size == 0) {
      data[0] = element;
      start = 0;
      end = 0;
    }
    else if (start == end && size == 1){
      end++;
      data[end] = element;
    }
    else if (end < start - 1){
      end++;
      data[end] = element;
    }
    else if (end > start && end < data.length-1){
      end++;
      data[end] = element;
    }
    size++;
  }
  public E removeFirst(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    E og = data[start];
    if (start == size-1){
      start = 0;
    }
    else{
      start++;
    }
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
    }
    else{
      end--;
    }
    size--;
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
    MyDeque<Integer> m = new MyDeque();
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
    for (int i = 0; i < 50; i++){
      m.addFirst(i);
      System.out.println(m.toString());
      m.removeLast();
    }
    //System.out.println(m.toString());
  }
}
