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
    for (int i = start; i != end; i++){
      if (start >= data.length){
        start = 0;
      }
      output += data[i] + " ";
    }
    output += data[end];
    return output + "}";
  }
  private void resize(){
    @SuppressWarnings("unchecked")
    E[] arr = (E[]) new Object[size * 2 + 1];
    for (int i = 0; i < data.length; i++){
      arr[i] = data[i];
    }
    size = size * 2 + 1;
  }
  public void addFirst(E element){
    if (Math.abs(end - start) == 1){
      resize();
    }
    if (start <= 0){
      start = data.length-1;
    }
    data[start-1] = element;
    start--;
  }
  public void addLast(E element){
    if (Math.abs(end - start) == 1){
      resize();
    }
    if (end >= data.length-1){
      end = 0;
    }
    data[end+1] = element;
    end++;
  }
  public E removeFirst(){
    if (start == data.length-1){
      E og = data[start];
      start = 0;
      return og;
    }
    E og = data[start];
    start++;
    return og;
  }
  public E removeLast(){
    if (end == 0){
      E og = data[end];
      end = data.length-1;
      return og;
    }
    E og = data[end];
    end--;
    return og;
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }
}
