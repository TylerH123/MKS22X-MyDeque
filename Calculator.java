import java.util.*;

public class Calculator{

  //check if input is Integer
  public static boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
    }
    catch(NumberFormatException e) {
      return false;
    }
    return true;
  }
  /*Evaluate a postfix expression stored in s.
    *Assume valid postfix notation, separated by spaces.
    */
  public static double eval(String s){
    String[] sc = s.split(" ");
    @SuppressWarnings("rawtypes")
    MyDeque deq = new MyDeque(sc.length);
    for (int i = 0; i < deq.size(); i++){
      if (isInteger(sc[i])){
        deq.addLast(Integer.parseInt(sc[i]));
      }
      else{
        
      }
    }
    double total = 0.0;

    return total;
  }
}
