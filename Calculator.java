import java.util.*;

public class Calculator{

  //check if input is a mathematical sign
  private static boolean isMath(String s) {
    return (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-") || s.equals("%"));
  }
  //do the math
  private static double doMath(String s, double x, double y){
    if (s.equals("*")){
      return x * y;
    }
    if (s.equals("/")){
      return x / y;
    }
    if (s.equals("+")){
      return x + y;
    }
    if (s.equals("-")){
      return x - y;
    }
    else if (s.equals("%")){
      return x % y;
    }
    return 0.0;
  }
  /*Evaluate a postfix expression stored in s.
    *Assume valid postfix notation, separated by spaces.
    */
  public static double eval(String s){
    String[] sc = s.split(" ");
    MyDeque<Double> deq = new MyDeque<Double>(sc.length);
    for (int i = 0; i < deq.size(); i++){
      if (isMath(sc[i])){
        double num1 = deq.getLast();
        deq.removeLast();
        double num2 = deq.getLast();
        deq.removeLast();
        deq.addLast(doMath(sc[i],num1,num2));
      }
      else{
        deq.addLast((double)Integer.parseInt(sc[i]));
      }
    }
    return deq.getLast();
  }
}
