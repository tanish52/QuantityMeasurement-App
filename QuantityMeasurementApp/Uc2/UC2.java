package Uc2;

public class UC2 {
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
  }}
  static class Inches{
    private final double val;
    Inches(Double d){
      val=d;
    }
    public boolean equals(Object o){
      if(this==o)return true;
      if(o==null || this.getClass()!=o.getClass())return false;
      Inches other=(Inches)o;
      return Double.compare(this.val, other.val)==0;
    }
  }
  public static boolean compareFeet(double d1,double d2){
    Feet f1=new Feet(d1);
    Feet f2=new Feet(d2);
    return f1.equals(f2);
  }
  public static boolean compareInch(double d1,double d2){
    Inches f1=new Inches(d1);
    Inches f2=new Inches(d2);
    return f1.equals(f2);
  }
  public static void main(String[] args) {
    System.out.println(compareFeet(1.0, 1.0));
  }
}
