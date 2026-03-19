import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TestUC9 {
  @Test
  void testEquality_KilogramToKilogram_SameValue(){
    UC9.Weight w=new UC9.Weight(1.0,WeightUnit.KG);
    UC9.Weight w2=new UC9.Weight(1.0,WeightUnit.KG);
    assertEquals(w, w2);

  }

  @Test
  void testEquality_KilogramToKilogram_DifferentValue(){
    UC9.Weight w=new UC9.Weight(1.0,WeightUnit.KG);
    UC9.Weight w2=new UC9.Weight(2.0,WeightUnit.KG);
    assertNotEquals(w, w2);

  }
  
    @Test
  void testEquality_KilogramToGram_EquivalentValue() {
    UC9.Weight w=new UC9.Weight(1.0,WeightUnit.KG);
    UC9.Weight w2=new UC9.Weight(1000.0,WeightUnit.GM);
    assertEquals(w, w2);

  }


   @Test
  void testEquality_GramToKilogram_EquivalentValue() {
    UC9.Weight w=new UC9.Weight(1000.0,WeightUnit.GM);
    UC9.Weight w2=new UC9.Weight(1.0,WeightUnit.KG);
    assertEquals(w, w2);

  }


  
   @Test
  void testEquality_WeightVsLength_Incompatible()  {
    UC9.Weight w=new UC9.Weight(1000.0,WeightUnit.GM);
    UC9.Length l=new UC9.Length(1.0,LengthUnit.FEET);
    assertFalse(w.equals(l));

  }

  
   @Test
  void testEquality_NullComparison(){
    UC9.Weight w=new UC9.Weight(1000.0,WeightUnit.GM);
   
    assertFalse(w.equals(null));

  }


  @Test
  void testEquality_SameReference(){
    UC9.Weight w=new UC9.Weight(1000.0,WeightUnit.GM);
   
    assertTrue(w.equals(w));

  }


  
  @Test
  void testEquality_NullUnit(){
    assertThrows(IllegalArgumentException.class, ()->{
      UC9.Weight w=new UC9.Weight(1.0, null);
    });

  }


   @Test
  void testEquality_TransitiveProperty() {
    UC9.Weight w=new UC9.Weight(1000.0,WeightUnit.GM);
    UC9.Weight w2=new UC9.Weight(1.0,WeightUnit.KG);
    assertEquals(new UC9.Weight(1000.0, WeightUnit.GM),new UC9.Weight(1.0, WeightUnit.KG));
    assertEquals(new UC9.Weight(1.0, WeightUnit.KG),new UC9.Weight(1.0, WeightUnit.KG));

  }


   @Test
  void testEquality_ZeroValue() {
    
  assertEquals(new UC9.Weight(0.0, WeightUnit.KG),new UC9.Weight(0.0, WeightUnit.GM));
    

  }


   @Test
  void testEquality_NegativeWeight()  {
    UC9.Weight w=new UC9.Weight(-1000.0,WeightUnit.GM);
    UC9.Weight w2=new UC9.Weight(-1.0,WeightUnit.KG);
    assertEquals(w, w2);

  }

  
   @Test
  void testEquality_LargeWeightValue()  {
    UC9.Weight w=new UC9.Weight(1000000.0,WeightUnit.GM);
    UC9.Weight w2=new UC9.Weight(1000.0,WeightUnit.KG);
    assertEquals(w, w2);

  }

     @Test
  void testEquality_SmallWeightValue()  {
    UC9.Weight w=new UC9.Weight(0.001,WeightUnit.KG);
    UC9.Weight w2=new UC9.Weight(1.0,WeightUnit.GM);
    assertEquals(w, w2);

  }


@Test
void testEquality_PoundToKilogram() {
    assertEquals(
        new UC9.Weight(2.20462, WeightUnit.LB),
        new UC9.Weight(1.0, WeightUnit.KG)
    );
}


@Test
void testConversion_KilogramToPound() {
    assertEquals(
        new UC9.Weight(1.0, WeightUnit.KG),
        new UC9.Weight(2.20462, WeightUnit.LB)
    );
}

@Test
void testConversion_SameUnit() {
  UC9.Weight w=new UC9.Weight(1.0,WeightUnit.KG);

    assertEquals(w,w.convertTo(WeightUnit.KG));
}

@Test
void testConversion_ZeroValue() {
  UC9.Weight w=new UC9.Weight(0.0,WeightUnit.KG);

    assertEquals(w,w.convertTo(WeightUnit.GM));
}

@Test
void testConversion_RoundTrip() {
  UC9.Weight w=new UC9.Weight(0.0,WeightUnit.KG);

    assertEquals(w,w.convertTo(WeightUnit.GM).convertTo(WeightUnit.KG));
}

@Test
void testAddition_SameUnit_KilogramPlusKilogram() {
    UC9.Weight w = new UC9.Weight(1.0, WeightUnit.KG);
    UC9.Weight w2 = new UC9.Weight(1.0, WeightUnit.KG);

    UC9.Weight expected = new UC9.Weight(2.0, WeightUnit.KG);
    assertEquals(expected, w.add(w2)); 
}

@Test
void testAddition_CrossUnit_KilogramPlusGram()  {
    UC9.Weight w = new UC9.Weight(1.0, WeightUnit.KG);
    UC9.Weight w2 = new UC9.Weight(1000.0, WeightUnit.GM);

    UC9.Weight expected = new UC9.Weight(2.0, WeightUnit.KG);
    assertEquals(expected, w.add(w2)); 
}


@Test
void testAddition_CrossUnit_PoundPlusKilogram()   {
    UC9.Weight w = new UC9.Weight(2.20462, WeightUnit.LB);
    UC9.Weight w2 = new UC9.Weight(1.0, WeightUnit.KG);

    UC9.Weight expected = new UC9.Weight(4.40924, WeightUnit.LB);
    assertEquals(expected, w.add(w2)); 
}


@Test
    void testAddition_Commutativity() {
        UC9.Weight w1 = new UC9.Weight(1.0, WeightUnit.KG);
        UC9.Weight w2 = new UC9.Weight(1000.0, WeightUnit.GM);

        
        UC9.Weight sum1 = w1.add(w2);
        UC9.Weight sum2 = w2.add(w1);

     
        sum2 = sum2.convertTo(WeightUnit.KG);

        assertEquals(sum1, sum2); 
    }

    @Test
    void testAddition_WithZero() {
        UC9.Weight w1 = new UC9.Weight(5.0, WeightUnit.KG);
        UC9.Weight w2 = new UC9.Weight(0.0, WeightUnit.GM);

        UC9.Weight sum = w1.add(w2);

        assertEquals(new UC9.Weight(5.0, WeightUnit.KG), sum);
    }

    @Test
    void testAddition_NegativeValues() {
        UC9.Weight w1 = new UC9.Weight(5.0, WeightUnit.KG);
        UC9.Weight w2 = new UC9.Weight(-2000.0, WeightUnit.GM); // -2 KG

        UC9.Weight sum = w1.add(w2);

        assertEquals(new UC9.Weight(3.0, WeightUnit.KG), sum);
    }

    @Test
    void testAddition_LargeValues() {
        UC9.Weight w1 = new UC9.Weight(1e6, WeightUnit.KG);
        UC9.Weight w2 = new UC9.Weight(1e6, WeightUnit.KG);

        UC9.Weight sum = w1.add(w2);

        assertEquals(new UC9.Weight(2e6, WeightUnit.KG), sum);
    }



















   
















  




}
