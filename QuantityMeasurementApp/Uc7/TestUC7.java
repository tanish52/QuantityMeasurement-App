package Uc7;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TestUC7 {

  @Test
  void testAddition_SameUnit_FeetPlusFeet(){
    UC7.Length l1=new UC7.Length(1.0 ,UC7.Length.LengthUnit.FEET);
    UC7.Length l2=new UC7.Length(1.0 ,UC7.Length.LengthUnit.FEET);
    

    assertEquals(new UC7.Length(2.0, UC7.Length.LengthUnit.FEET),UC7.Length.add(l1,l2,UC7.Length.LengthUnit.FEET));
  }

 @Test
  void testAddition_SameUnit_InchPlusInch() {
  UC7.Length l1=new UC7.Length(1.0 ,UC7.Length.LengthUnit.INCH);
    UC7.Length l2=new UC7.Length(1.0 ,UC7.Length.LengthUnit.INCH);
    

    assertEquals(new UC7.Length(2.0, UC7.Length.LengthUnit.INCH),UC7.Length.add(l1,l2,UC7.Length.LengthUnit.INCH));
  }

  @Test
  void testAddition_CrossUnit_FeetPlusInches() {
    UC7.Length l1=new UC7.Length(1.0 ,UC7.Length.LengthUnit.FEET);
    UC7.Length l2=new UC7.Length(1.0 ,UC7.Length.LengthUnit.INCH);
    

    assertEquals(new UC7.Length(13.0, UC7.Length.LengthUnit.INCH),UC7.Length.add(l1,l2,UC7.Length.LengthUnit.INCH));
  }

   @Test
  void testAddition_CrossUnit_InchPlusFeet() {
    UC7.Length l1=new UC7.Length(12.0 ,UC7.Length.LengthUnit.INCH);
    UC7.Length l2=new UC7.Length(1.0 ,UC7.Length.LengthUnit.FEET);
    

    assertEquals(new UC7.Length(2.0, UC7.Length.LengthUnit.FEET),UC7.Length.add(l1,l2,UC7.Length.LengthUnit.FEET));
  }

  
   @Test
  void testAddition_CrossUnit_YardPlusFeet() {
    UC7.Length l1=new UC7.Length(1.0 ,UC7.Length.LengthUnit.YARD);
    UC7.Length l2=new UC7.Length(3.0 ,UC7.Length.LengthUnit.FEET);
    

    assertEquals(new UC7.Length(2.0, UC7.Length.LengthUnit.YARD),UC7.Length.add(l1,l2,UC7.Length.LengthUnit.YARD));
  }

  @Test
void testAddition_SmallValues() {
    UC7.Length l1 = new UC7.Length(0.001, UC7.Length.LengthUnit.FEET);
    UC7.Length l2 = new UC7.Length(0.002, UC7.Length.LengthUnit.FEET);

    UC7.Length expected = new UC7.Length(0.003, UC7.Length.LengthUnit.FEET);
    UC7.Length result = UC7.Length.add(l1, l2, UC7.Length.LengthUnit.FEET);


    double epsilon = 1e-6;
    assertTrue(Math.abs(result.BaseUnit() - expected.BaseUnit()) < epsilon);
  }


    @Test
  void testAddition_Commutativity()  {
    UC7.Length l1=new UC7.Length(12.0 ,UC7.Length.LengthUnit.INCH);
    UC7.Length l2=new UC7.Length(1.0 ,UC7.Length.LengthUnit.FEET);
    
    UC7.Length l3=UC7.Length.add(l1, l2,UC7.Length.LengthUnit.FEET );
    UC7.Length l4=UC7.Length.add(l2, l1,UC7.Length.LengthUnit.FEET);
    assertEquals(l3,l4);
  }


  @Test
  void testAddition_WithZero() {
    UC7.Length l1=new UC7.Length(5.0 ,UC7.Length.LengthUnit.FEET);
    UC7.Length l2=new UC7.Length(0.0 ,UC7.Length.LengthUnit.INCH);
    

    assertEquals(new UC7.Length(5.0, UC7.Length.LengthUnit.FEET),UC7.Length.add(l1,l2,UC7.Length.LengthUnit.FEET));
  }

   @Test
  void testAddition_NegativeValues() {
    UC7.Length l1=new UC7.Length(5.0 ,UC7.Length.LengthUnit.FEET);
    UC7.Length l2=new UC7.Length(-3.0 ,UC7.Length.LengthUnit.FEET);
    

    assertEquals(new UC7.Length(2.0, UC7.Length.LengthUnit.FEET),UC7.Length.add(l1,l2,UC7.Length.LengthUnit.FEET));
  }


  @Test
  void testAddition_NullSecondOperand() {
   assertThrows(IllegalArgumentException.class,()->{
      UC7.Length.add(new UC7.Length(5.0 ,UC7.Length.LengthUnit.FEET), null,UC7.Length.LengthUnit.FEET);
    });
  }


  @Test
void testAddition_LargeValues() {
    UC7.Length l1 = new UC7.Length(1e6, UC7.Length.LengthUnit.FEET);
    UC7.Length l2 = new UC7.Length(1e6, UC7.Length.LengthUnit.FEET);

    UC7.Length expected = new UC7.Length(2e6, UC7.Length.LengthUnit.FEET);
    UC7.Length result = UC7.Length.add(l1, l2, UC7.Length.LengthUnit.FEET);

    assertEquals(expected, result);
}

  @Test
void testAddition_CrossUnit_CentimeterPlusInch() {
    UC7.Length l1 = new UC7.Length(2.54, UC7.Length.LengthUnit.CM);
    UC7.Length l2 = new UC7.Length(1.0, UC7.Length.LengthUnit.INCH);

    UC7.Length result = UC7.Length.add(l1, l2, UC7.Length.LengthUnit.CM);
    UC7.Length expected = new UC7.Length(5.08, UC7.Length.LengthUnit.CM);

    double epsilon = 1e-3;
    double resultInCM = result.BaseUnit() / UC7.Length.LengthUnit.CM.getConversionFactor();
    double expectedInCM = expected.BaseUnit() / UC7.Length.LengthUnit.CM.getConversionFactor();

    assertTrue(Math.abs(resultInCM - expectedInCM) < epsilon);
}








  
}
