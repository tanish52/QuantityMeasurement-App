package Uc5;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.Test.*;

import Uc5.UC5.Length;

public class TestUC5 {
  
  @Test
   public  void testConversion_FeetToInches(){
    assertEquals(12.0,Length.convert(1.0,UC5.Length.LengthUnit.FEET,UC5.Length.LengthUnit.INCH));
}

@Test
   public  void testConversion_InchesToFeet(){
    assertEquals(2.0,Length.convert(24.0,UC5.Length.LengthUnit.INCH,UC5.Length.LengthUnit.FEET));
}

@Test
   public  void testConversion_YardsToInches(){
    assertEquals(36.0,Length.convert(1.0,UC5.Length.LengthUnit.YARD,UC5.Length.LengthUnit.INCH));
}

@Test
   public  void testConversion_InchesToYards(){
    assertEquals(1.0,Length.convert(36.0,UC5.Length.LengthUnit.INCH,UC5.Length.LengthUnit.YARD));
}

@Test
   public  void testConversion_CentimetersToInches(){
    assertEquals(1.0,Length.convert(2.54,UC5.Length.LengthUnit.CM,UC5.Length.LengthUnit.INCH),1e-4);
}

@Test
   public  void testConversion_FeatToYard(){
    assertEquals(2.0,Length.convert(6.0,UC5.Length.LengthUnit.FEET,UC5.Length.LengthUnit.YARD));
}

@Test
   public  void testConversion_RoundTrip_PreservesValue(){
    double value=2.0;
    double first=Length.convert(value,UC5.Length.LengthUnit.YARD,UC5.Length.LengthUnit.FEET);
    double second=Length.convert(first,UC5.Length.LengthUnit.FEET,UC5.Length.LengthUnit.YARD);
    assertEquals(value,second);
}

@Test
   public  void testConversion_ZeroValue(){
    assertEquals(0.0,Length.convert(0.0,UC5.Length.LengthUnit.FEET,UC5.Length.LengthUnit.INCH));
}

@Test
   public  void testConversion_NegativeValue(){
    assertEquals(-12.0,Length.convert(-1.0,UC5.Length.LengthUnit.FEET,UC5.Length.LengthUnit.INCH));
}

@Test
   public  void testConversion_InvalidUnit_Throws(){
    assertThrows(IllegalArgumentException.class,()->{
      UC5.Length.convert(1.0,null,UC5.Length.LengthUnit.INCH);
    });
}

@Test
   public  void testConversion_NaNOrInfinite_Throws(){
    assertThrows(IllegalArgumentException.class,()->{
      UC5.Length.convert(Double.NaN,null,UC5.Length.LengthUnit.INCH);
    });
}

@Test
public  void estConversion_PrecisionTolerance(){
    double result = UC5.Length.convert(1.0, UC5.Length.LengthUnit.CM, UC5.Length.LengthUnit.INCH);
        assertTrue(Math.abs(result - 0.393701) < 1e-6);
} 







}
