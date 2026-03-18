package Uc7;
import java.util.*;
public class UC7 {
  static class Length {
    private final double value;
    private final LengthUnit unit;
    public enum LengthUnit{
      INCH(1.0),
      FEET(12.0),
      YARD(36.0),
      CM(0.393701);

      private final double conversionFactor;
      LengthUnit(double conversionFactor){
        this.conversionFactor=conversionFactor;
      }
      double getConversionFactor(){
        return this.conversionFactor;
      }
    }
    
    Length(double v,LengthUnit l){
      if(l==null){
        throw new IllegalArgumentException("Unit cannnot be null");
      }
      if (!Double.isFinite(v)) {
    throw new IllegalArgumentException("Invalid value");
}
      value=v;
      unit=l;
    }

    double BaseUnit(){
      return value*unit.getConversionFactor();
    }
  public  Length convertTo(LengthUnit target){
      
      double newval=convert(value,unit,target);
      return new Length(newval, target);
    }

     static  double convert(double val,LengthUnit source,LengthUnit target){
    
        if(source ==null || target ==null){
        throw new   IllegalArgumentException("Source and Target cannot be Null");
      };
      if(!Double.isFinite(val)){
          throw new   IllegalArgumentException("Invalid Value");
      }
      if (source == target) {
                return val;
            }
      double newval=val *source.getConversionFactor();
      return newval/target.getConversionFactor();

    }

   public  boolean equals(Object obj){
      if(this==obj)return true;
      if(obj ==null || this.getClass()!=obj.getClass())return false;
      Length other=(Length)obj;
      return Double.compare(this.BaseUnit(), other.BaseUnit())==0;
    }

     public static void demonstrateLengthConversion(double value, Length.LengthUnit from, Length.LengthUnit to) {
        double result = convert(value, from, to);
        System.out.println(value + " " + from + " = " + result + " " + to);
    }
    public static void demonstrateLengthConversion(Length length, Length.LengthUnit to) {
        Length converted = length.convertTo(to);
        System.out.println(length + " = " + converted);
    }

    public static Length add(Length l1,Length l2, LengthUnit target){
      if(l1==null || l2==null){
        throw new IllegalArgumentException("Operands cannot be Null");
      }
      if(l1.unit==null || l2.unit==null){
       throw new IllegalArgumentException("Unit cannot be Null");
      }
      if(target ==null){
        throw new IllegalArgumentException("Target Unit cannot be Null");
      }
        if (!Double.isFinite(l1.value) || !Double.isFinite(l2.value)) {
        throw new IllegalArgumentException("Invalid numeric value");
    }
      

        
        double ans=l1.BaseUnit() +l2.BaseUnit();
        return new Length(ans/target.getConversionFactor(), target);
       
      }

    
   

  }
  public static void main(String[] args) {
    
  }
}
