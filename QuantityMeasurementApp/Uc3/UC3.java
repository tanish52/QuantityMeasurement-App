package Uc3;
import java.util.*;
public class UC3 {
  static class Length{
    private  double value;
    private LengthUnit unit;
    public enum LengthUnit{
      INCH(1.0),
      FEET(12.0);

      private final double conversionFactor;
      LengthUnit(double conversionFactor){
        this.conversionFactor=conversionFactor;
      }
      double getConversionFactor(){
        return this.conversionFactor;
      }

    }
    Length(double value,LengthUnit unit){
      if(unit==null){
        throw new IllegalArgumentException("Argument cannot be null");
      }
      this.unit=unit;
      this.value=value;
    }

    double toBaseUnit(){
      return value*unit.getConversionFactor();
    }

    public boolean equals(Object obj){
      if(this==obj)return true;
      if(obj==null || obj.getClass()!=this.getClass())return false;
      Length l=(Length) obj;
      return Double.compare(this.toBaseUnit(), l.toBaseUnit())==0;
    }

  }
  public static void main(String[] args) {
   Length q1 =
    new Length(1, Length.LengthUnit.FEET);

Length q2 =
    new Length(12, Length.LengthUnit.INCH);

System.out.println(q1.equals(q2));
  }
}
