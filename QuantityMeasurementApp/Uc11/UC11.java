import java.util.*;
interface iMeasureable{
  double getconversionfactor();
  default double toBaseUnit(double value){
    return value*getconversionfactor();
  }
  default double fromBaseUnit(double baseval){
    return baseval/getconversionfactor();
  }


}

enum VolumeUnit implements iMeasureable{
  LITRE(1.0),
  MILLILITRE(0.001),
  GALLON(3.78541);
  private final double conversionFactor;
  VolumeUnit(double c){
    conversionFactor=c;
  }
  public double getconversionfactor(){
    return conversionFactor;
  }

}

 enum LengthUnit implements iMeasureable{
      INCH(1.0),
      FEET(12.0),
      YARD(36.0),
      CM(0.393701);

    private final double conversionfactor;
    LengthUnit(double c){
      conversionfactor=c;
    }

    public double getconversionfactor(){
      return conversionfactor;
    }

}

 enum WeightUnit implements iMeasureable{
      KG(1.0),
    GM(0.001),
    LB(0.453592);

    private final double conversionfactor;
    WeightUnit(double c){
      conversionfactor=c;
    }

    public double getconversionfactor(){
      return conversionfactor;
    }




}

 class Quantity<U extends iMeasureable>{
  private final double value;
  private final U unit;
  Quantity(double v,U u){
    if(u==null){
      throw new IllegalArgumentException("Unit Cannot be null");
    }
    if(!Double.isFinite(v)){
      throw new IllegalArgumentException("Invalid number");
    }
    value=v;
    unit=u;
  }

  public double getValue() {
    return value;
}

public U getUnit() {
    return unit;
}

  public boolean equals(Object obj){
    if(this==obj)return true;
    if(obj==null || !(obj instanceof Quantity<?> a))return false;
    
    if(!this.unit.getClass().equals(a.unit.getClass()))return false;
    double v1 = this.unit.toBaseUnit(this.value);
double v2 = a.unit.toBaseUnit(a.value);

return Math.abs(v1 - v2) < 1e-3;
  }

   public int hashCode() {
        double baseValue = unit.toBaseUnit(value);
        return Objects.hash(baseValue, unit.getClass());
    }

    Quantity<U> convertTo(U target){
      double basevalue=this.unit.toBaseUnit(value);
      return new Quantity<>(target.fromBaseUnit(basevalue), target);
    }

    Quantity<U> add(Quantity<U> other){
      if (other == null) {
    throw new IllegalArgumentException("Other quantity cannot be null");
}
      double a=this.unit.toBaseUnit(value);
      double b=other.unit.toBaseUnit(other.value);
      double c=a+b;
      return new Quantity<>(unit.fromBaseUnit(c), unit);
    }

    Quantity<U> add(Quantity<U> other,U target){
      if (other == null) {
    throw new IllegalArgumentException("Other quantity cannot be null");
}
       double a=this.unit.toBaseUnit(value);
      double b=other.unit.toBaseUnit(other.value);
      double c=a+b;
      return new Quantity<>(target.fromBaseUnit(c), target);
    }


 }
public class UC11{
  public static void main(String[] args) {
    
  }
}