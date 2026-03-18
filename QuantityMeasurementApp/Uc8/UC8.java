package Uc8;

   enum LengthUnit{
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
       double BaseUnit(double value){
         if(!Double.isFinite(value)){
          throw new IllegalArgumentException("Value is Null");
         }
      return value*conversionFactor;

    }

    double conversionFromBaseUnit(double basevalue){
      if(!Double.isFinite(basevalue)){
          throw new IllegalArgumentException("Value is Null");
         }
         return basevalue/conversionFactor;
    }
    }
public class UC8 {

  
  static class Length {
    private final double value;
    private final LengthUnit unit;
  
    
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
    double newVal = target.conversionFromBaseUnit(base);

    return new Length(newVal, target);
}
   public  boolean equals(Object obj){
      if(this==obj)return true;
      if(obj ==null || this.getClass()!=obj.getClass())return false;
      Length other=(Length)obj;
      return Double.compare(unit.BaseUnit(value), other.unit.BaseUnit(other.value))==0;
    }
public static void demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
    double base = from.BaseUnit(value);
    double result = to.conversionFromBaseUnit(base);
    System.out.println(value + " " + from + " = " + result + " " + to);
}
    public static void demonstrateLengthConversion(Length length, LengthUnit to) {
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
        return new Length(target.conversionFromBaseUnit(ans), target);
       
      }

    
   

  }
  public static void main(String[] args) {
    
  }
}
