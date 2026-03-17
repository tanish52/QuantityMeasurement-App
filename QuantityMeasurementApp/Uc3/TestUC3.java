package Uc3;
import Uc3.UC3;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Uc3.UC3.Length.LengthUnit;
public class TestUC3 {
  @Test
  void testEquality_FeetToFeet_SameValue(){
    UC3.Length l1=new UC3.Length(1.0, LengthUnit.FEET);
    UC3.Length l2=new UC3.Length(1.0, LengthUnit.FEET);
    assertEquals(l1,l2);
  }

   @Test
  void testEquality_InchToInch_SameValue(){
    UC3.Length l1=new UC3.Length(1.0, LengthUnit.INCH);
    UC3.Length l2=new UC3.Length(1.0, LengthUnit.INCH);
    assertEquals(l1,l2);
  }
  @Test
  void testEquality_NullComparison(){
    UC3.Length l1=new UC3.Length(1.0, LengthUnit.FEET);
   
    assertFalse(l1.equals(null));
  }
   @Test
    void testEquality_InchToFeet(){
        UC3.Length q1 = new UC3.Length(12.0, LengthUnit.INCH);
        UC3.Length q2 = new UC3.Length(1.0, LengthUnit.FEET);

        assertEquals(q1,q2);
    }

    @Test
    void testEquality_FeetToFeet_DifferentValue() {
      UC3.Length l1=new UC3.Length(1.0, LengthUnit.FEET);
    UC3.Length l2=new UC3.Length(2.0, LengthUnit.FEET);
    assertFalse(l1.equals(l2));
    }
    @Test
    void testEquality_InchToInch_DifferentValue() {
      UC3.Length l1=new UC3.Length(1.0, LengthUnit.INCH);
    UC3.Length l2=new UC3.Length(2.0, LengthUnit.INCH);
    assertFalse(l1.equals(l2));
    }
     @Test
    void testInvalidUnit(){
        assertThrows(IllegalArgumentException.class, () -> {
            new UC3.Length(1.0, null);
        });

}
  @Test
  void isSameReference(){
    UC3.Length l1=new UC3.Length(1.0, LengthUnit.FEET);
    assertTrue(l1.equals(l1));
}




}