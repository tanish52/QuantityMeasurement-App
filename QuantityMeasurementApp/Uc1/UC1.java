package Uc1;
import java.util.*;
public class UC1{

  static class Feet{
  private final double value;
  
  Feet(double v1){
    value=v1;
 
  }

  public boolean equals(Object obj){
    if(this==obj)return true;
    if(obj==null || getClass()!=obj.getClass() )return false;
      Feet other=(Feet)obj;
      return Double.compare(this.value, other.value)==0;
  }
  

  }
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    double d=sc.nextDouble();
    double d1=sc.nextDouble();
    Feet f1=new Feet(d);
    Feet f2=new Feet(d1);
    System.out.println(f1.equals(f2));

  }
}