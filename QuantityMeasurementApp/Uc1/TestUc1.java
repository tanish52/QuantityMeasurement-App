package Uc1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestUc1 {
  @Test
  void testEquality(){
    UC1.Feet f1=new UC1.Feet(1.0);
    UC1.Feet f2=new UC1.Feet(1.0);
    assertTrue(f1.equals(f2));
  }
   @Test
    void testDifferentFeet() {
        UC1.Feet f1 = new UC1.Feet(1.0);
        UC1.Feet f2 = new UC1.Feet(2.0);

        assertFalse(f1.equals(f2));
    }
    @Test
    void isNull(){
      UC1.Feet f1=new  UC1.Feet(1.0);
      
      assertFalse(f1.equals(null));
    }
    @Test
    void isNumericValue(){
      UC1.Feet f1=new UC1.Feet(1.0);
      String str="Hello";
      assertFalse(f1.equals(str));
    }
    @Test
    void isSameReference(){
      UC1.Feet f1=new UC1.Feet(5.0);
      assertTrue(f1.equals(f1));
    }


}
