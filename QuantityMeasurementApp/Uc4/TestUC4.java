package Uc4;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Uc4.UC4;
public class TestUC4 {
  
  @Test
  void testEquality_YardToYard_SameValue() {
    UC4.Length l1=new UC4.Length(1.0, UC4.Length.LengthUnit.YARD);
    UC4.Length l2=new UC4.Length(1.0,  UC4.Length.LengthUnit.YARD);
    assertEquals(l1, l2);
  }

   
  @Test
  void testEquality_YardToYard_DifferentValue() {
    UC4.Length l1=new UC4.Length(1.0, UC4.Length.LengthUnit.YARD);
    UC4.Length l2=new UC4.Length(2.0,  UC4.Length.LengthUnit.YARD);
    assertNotEquals(l1, l2);
  }

   
  @Test
  void testEquality_YardToFeet_EquivalentValue() {
    UC4.Length l1=new UC4.Length(1.0, UC4.Length.LengthUnit.YARD);
    UC4.Length l2=new UC4.Length(3.0,  UC4.Length.LengthUnit.FEET);
    assertEquals(l1, l2);
  }

@Test
  void testEquality_FeetToYard_EquivalentValue()  {
    UC4.Length l1=new UC4.Length(3.0, UC4.Length.LengthUnit.FEET);
    UC4.Length l2=new UC4.Length(1.0,  UC4.Length.LengthUnit.YARD);
    assertEquals(l1, l2);
  }

  @Test
  void testEquality_YardToInches_EquivalentValue()  {
    UC4.Length l1=new UC4.Length(1.0, UC4.Length.LengthUnit.YARD);
    UC4.Length l2=new UC4.Length(36.0,  UC4.Length.LengthUnit.INCH);
    assertEquals(l1, l2);
  }

  @Test
  void testEquality_InchesToYard_EquivalentValue()   {
    UC4.Length l1=new UC4.Length(36.0, UC4.Length.LengthUnit.INCH);
    UC4.Length l2=new UC4.Length(1.0,  UC4.Length.LengthUnit.YARD);
    assertEquals(l1, l2);
  }

  @Test
  void testEquality_YardToFeet_NonEquivalentValue()   {
    UC4.Length l1=new UC4.Length(1.0, UC4.Length.LengthUnit.YARD);
    UC4.Length l2=new UC4.Length(4.0,  UC4.Length.LengthUnit.FEET);
    assertNotEquals(l1, l2);
  }

  
  @Test
  void testEquality_centimetersToInches_EquivalentValue()   {
    UC4.Length l1=new UC4.Length(1.0, UC4.Length.LengthUnit.CM);
    UC4.Length l2=new UC4.Length(.393701,  UC4.Length.LengthUnit.INCH);
    assertEquals(l1, l2);
  }

   @Test
  void testEquality_centimetersToFeet_NonEquivalentValue()  {
    UC4.Length l1=new UC4.Length(1.0, UC4.Length.LengthUnit.CM);
    UC4.Length l2=new UC4.Length(1.0,  UC4.Length.LengthUnit.FEET);
    assertNotEquals(l1, l2);
  }

   @Test
  void testEquality_MultiUnit_TransitiveProperty() {
    UC4.Length l1=new UC4.Length(1.0, UC4.Length.LengthUnit.YARD);
    UC4.Length l2=new UC4.Length(3.0,  UC4.Length.LengthUnit.FEET);
     UC4.Length l3=new UC4.Length(36.0,  UC4.Length.LengthUnit.INCH);
     assertEquals(l1, l2);
     assertEquals(l2, l3);
    assertEquals(l1, l3);
  }

   @Test
  void testEquality_YardWithNullUnit() {
    UC4.Length l1=new UC4.Length(1.0, UC4.Length.LengthUnit.YARD);
    assertFalse(l1.equals(null));    
  }
   @Test
  void testEquality_YardSameReference(){
    UC4.Length l1=new UC4.Length(1.0, UC4.Length.LengthUnit.YARD);
    assertTrue(l1.equals(l1));    
  } 

   @Test
  void testEquality_CentimetersWithNullUnit() {
    UC4.Length l1=new UC4.Length(1.0, UC4.Length.LengthUnit.CM);
    assertFalse(l1.equals(null));    
  }


@Test
  void testEquality_CentimetersSameReference(){
    UC4.Length l1=new UC4.Length(1.0, UC4.Length.LengthUnit.CM);
    assertTrue(l1.equals(l1));    
  } 


  @Test
  void testEquality_AllUnits_ComplexScenario() {
    UC4.Length l1=new UC4.Length(1.0, UC4.Length.LengthUnit.YARD);
    UC4.Length l2=new UC4.Length(3.0,  UC4.Length.LengthUnit.FEET);
     UC4.Length l3=new UC4.Length(36.0,  UC4.Length.LengthUnit.INCH);
     assertEquals(l1, l2);
     assertEquals(l2, l3);
    assertEquals(l1, l3);    
  } 

}
