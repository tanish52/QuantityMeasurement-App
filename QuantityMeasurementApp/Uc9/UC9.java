
import java.util.*;

  enum WeightUnit{
    KG(1.0),
    GM(0.001),
    LB(0.453592);

    private double conversionFactor;
    WeightUnit(double c){
      conversionFactor=c;
    }
    double getconversionFactor(){
      return conversionFactor;
        }

    double convertToBaseWeight(double val){
       if(!Double.isFinite(val)){
        throw new IllegalArgumentException("Invalid value");
    }
      return val*conversionFactor;
    }
    double convertFromBaseWeight(double baseval){
       if(!Double.isFinite(baseval)){
        throw new IllegalArgumentException("Invalid value");
    }
      return baseval/conversionFactor;
    }
  }
   enum LengthUnit{
      INCH(1.0),
      FEET(12.0),
      YARD(36.0),
      CM(0.393701);

      private final double conversionFactorFactor;
      LengthUnit(double conversionFactorFactor){
        this.conversionFactorFactor=conversionFactorFactor;
      }
      double getconversionFactorFactor(){
        return this.conversionFactorFactor;
      }
       double BaseUnit(double value){
         if(!Double.isFinite(value)){
          throw new IllegalArgumentException("Value is Null");
         }
      return value*conversionFactorFactor;

    }

    double conversionFactorFromBaseUnit(double basevalue){
      if(!Double.isFinite(basevalue)){
          throw new IllegalArgumentException("Value is Null");
         }
         return basevalue/conversionFactorFactor;
    }
    }
public class UC9 {

  
  static class Length {
    private  final double value;
    private  final LengthUnit unit;
  
    
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
    public double getValue() {
    return value;
}
public Length convertTo(LengthUnit target) {
    if (target == null) {
        throw new IllegalArgumentException("Target cannot be null");
    }

    double base = unit.BaseUnit(value);
    double newVal = target.conversionFactorFromBaseUnit(base);

    return new Length(newVal, target);
}
   public  boolean equals(Object obj){
      if(this==obj)return true;
      if(obj ==null || this.getClass()!=obj.getClass())return false;
      Length other=(Length)obj;
      return Double.compare(unit.BaseUnit(value), other.unit.BaseUnit(other.value))==0;
    }
public static void demonstrateLengthconversionFactor(double value, LengthUnit from, LengthUnit to) {
    double base = from.BaseUnit(value);
    double result = to.conversionFactorFromBaseUnit(base);
    System.out.println(value + " " + from + " = " + result + " " + to);
}
    public static void demonstrateLengthconversionFactor(Length length, LengthUnit to) {
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
      

        
        double ans=l1.unit.BaseUnit(l1.value) +l2.unit.BaseUnit(l2.value);
        return new Length(target.conversionFactorFromBaseUnit(ans), target);
       
      }

    
   

  }

  static class Weight{
    private final double val;
    private final WeightUnit unit;
    Weight(double v,WeightUnit w){
      if(w==null){
        throw new IllegalArgumentException("Unit cannot be null");
      }
        if (!Double.isFinite(v)) {
    throw new IllegalArgumentException("Invalid value");
}
      val=v;
      unit=w;
    }
    public double getValue(){
      return this.val;
    }

    public  WeightUnit getWeightUnit(){
      return this.unit;
    }


    public boolean equals(Object obj){
      if(obj==this)return true;
      if(obj==null || this.getClass()!=obj.getClass())return false;
      Weight w=(Weight)obj;
      return Math.abs(unit.convertToBaseWeight(val) -w.unit.convertToBaseWeight(w.val))< 1e-3;
    }
  
public int hashCode() {
    return Double.hashCode(unit.convertToBaseWeight(val));
}

    public Weight convertTo(WeightUnit Target){
      if(Target==null){
        throw new IllegalArgumentException("Target Unit cannot be null");

      }

      double baseweight=this.unit.convertToBaseWeight(val);
      return new Weight(Target.convertFromBaseWeight(baseweight), Target);
    }

    public Weight add(Weight other){
      if(other==null){
        throw new IllegalArgumentException("Weight cannot be null");
      }
      double weight1=this.unit.convertToBaseWeight(val);
      double weight2=other.unit.convertToBaseWeight(other.val);
      double weight3=weight1+weight2;
      return new Weight(this.unit.convertFromBaseWeight(weight3), unit);
    }

     public Weight add(Weight other,WeightUnit target){
      if(other==null || target==null){
        throw new IllegalArgumentException("Weight cannot be null");
      }
      double weight1=this.unit.convertToBaseWeight(val);
      double weight2=other.unit.convertToBaseWeight(other.val);
      double weight3=weight1+weight2;
      return new Weight(target.convertFromBaseWeight(weight3), target);
    }







  }
  public static void main(String[] args) {
    
  }
}
