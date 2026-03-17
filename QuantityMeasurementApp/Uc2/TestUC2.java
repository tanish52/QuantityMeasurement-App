package Uc2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Uc1.UC1;


public class TestUC2 {
  @Test
  void checkFeetEquality(){
    UC2.Feet f1=new UC2.Feet(1.0);
    UC2.Feet f2=new UC2.Feet(1.0);
    assertEquals(f1,f2);
  }
  
  @Test
  void checkFeetDifferent(){
    UC2.Feet f1=new UC2.Feet(1.0);
    UC2.Feet f2=new UC2.Feet(2.0);
    assertNotEquals(f1,f2);
  } 

  @Test
  void checkfeetNull(){
    UC2.Feet f1=new UC2.Feet(1.0);
    assertFalse(f1.equals(null));
  }
 
  @Test
    void isNumericValue(){
      UC2.Feet f1=new UC2.Feet(1.0);
      String str="Hello";
      assertFalse(f1.equals(str));
    }
    @Test
    void isSameReference(){
      UC2.Feet f1=new UC2.Feet(5.0);
      assertTrue(f1.equals(f1));
    }

    @Test
  void checkInchEquality(){
    UC2.Inches f1=new UC2.Inches(1.0);
    UC2.Inches f2=new UC2.Inches(1.0);
    assertEquals(f1,f2);
  }
  
  @Test
  void checkInchDifferent(){
    UC2.Inches f1=new UC2.Inches(1.0);
    UC2.Inches f2=new UC2.Inches(2.0);
    assertNotEquals(f1,f2);
  } 

  @Test
  void checkInchtNull(){
    UC2.Inches f1=new UC2.Inches(1.0);
    assertFalse(f1.equals(null));
  }
  @Test
  void DifferentInchClass(){
    UC2.Inches f1=new UC2.Inches(1.0);
    UC2.Inches f2=new UC2.Inches(1.0);
    assertTrue(f1.getClass()==f2.getClass());
  }
  @Test
    void isNumericInchValue(){
      UC2.Inches f1=new UC2.Inches(1.0);
      String str="Hello";
      assertFalse(f1.equals(str));
    }
    @Test
    void isSameinInchesReference(){
      UC2.Inches f1=new UC2.Inches(5.0);
      assertTrue(f1.equals(f1));
    }
}
