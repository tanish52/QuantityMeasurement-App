import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TestUC12 {
  
  @Test
    void testSubtraction_SameUnit_FeetMinusFeet() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(new Quantity<>(5.0, LengthUnit.FEET), result);
    }

    @Test
    void testSubtraction_SameUnit_LitreMinusLitre() {
        Quantity<VolumeUnit> q1 = new Quantity<>(10.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(3.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = q1.subtract(q2);
        assertEquals(new Quantity<>(7.0, VolumeUnit.LITRE), result);
    }

    @Test
    void testSubtraction_CrossUnit_FeetMinusInches() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(new Quantity<>(9.5, LengthUnit.FEET), result);
    }

    @Test
    void testSubtraction_CrossUnit_InchesMinusFeet() {
        Quantity<LengthUnit> q1 = new Quantity<>(120.0, LengthUnit.INCH);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(new Quantity<>(60.0, LengthUnit.INCH), result);
    }

    @Test
    void testSubtraction_ExplicitTargetUnit_Feet() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = q1.subtract(q2, LengthUnit.FEET);
        assertEquals(new Quantity<>(9.5, LengthUnit.FEET), result);
    }

    @Test
    void testSubtraction_ExplicitTargetUnit_Inches() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = q1.subtract(q2, LengthUnit.INCH);
        assertEquals(new Quantity<>(114.0, LengthUnit.INCH), result);
    }

    @Test
    void testSubtraction_ExplicitTargetUnit_Millilitre() {
        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = q1.subtract(q2, VolumeUnit.MILLILITRE);
        assertEquals(new Quantity<>(3000.0, VolumeUnit.MILLILITRE), result);
    }

    @Test
    void testSubtraction_ResultingInNegative() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(new Quantity<>(-5.0, LengthUnit.FEET), result);
    }

    @Test
    void testSubtraction_ResultingInZero() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(120.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(new Quantity<>(0.0, LengthUnit.FEET), result);
    }

    @Test
    void testSubtraction_WithZeroOperand() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(new Quantity<>(5.0, LengthUnit.FEET), result);
    }

    @Test
    void testSubtraction_WithNegativeValues() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(-2.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(new Quantity<>(7.0, LengthUnit.FEET), result);
    }

    @Test
    void testSubtraction_NonCommutative() {
        Quantity<LengthUnit> a = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(5.0, LengthUnit.FEET);
        assertNotEquals(a.subtract(b), b.subtract(a));
    }

    @Test
    void testSubtraction_WithLargeValues() {
        Quantity<WeightUnit> q1 = new Quantity<>(1e6, WeightUnit.KG);
        Quantity<WeightUnit> q2 = new Quantity<>(5e5, WeightUnit.KG);
        Quantity<WeightUnit> result = q1.subtract(q2);
        assertEquals(new Quantity<>(5e5, WeightUnit.KG), result);
    }

    @Test
    void testSubtraction_WithSmallValues() {
        Quantity<LengthUnit> q1 = new Quantity<>(0.001, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.0005, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(new Quantity<>(0.0005, LengthUnit.FEET), result);
    }

    @Test
    void testSubtraction_NullOperand() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> q1.subtract(null));
    }

    @Test
    void testSubtraction_NullTargetUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> q1.subtract(q2, null));
    }

    @Test
    void testSubtraction_CrossCategory() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<WeightUnit> q2 = new Quantity<>(5.0, WeightUnit.KG);
        assertThrows(IllegalArgumentException.class, () -> q1.subtract((Quantity) q2));
    }

    @Test
    void testSubtraction_ChainedOperations() {
        Quantity<LengthUnit> q = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q.subtract(new Quantity<>(2.0, LengthUnit.FEET))
                                           .subtract(new Quantity<>(1.0, LengthUnit.FEET));
        assertEquals(new Quantity<>(7.0, LengthUnit.FEET), result);
    }

    @Test
    void testDivision_SameUnit_FeetDividedByFeet() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        assertEquals(5.0, q1.divide(q2));
    }

    @Test
    void testDivision_SameUnit_LitreDividedByLitre() {
        Quantity<VolumeUnit> q1 = new Quantity<>(10.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(5.0, VolumeUnit.LITRE);
        assertEquals(2.0, q1.divide(q2));
    }

    @Test
    void testDivision_CrossUnit_FeetDividedByInches() {
        Quantity<LengthUnit> q1 = new Quantity<>(24.0, LengthUnit.INCH);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        assertEquals(1.0, q1.divide(q2));
    }

    @Test
    void testDivision_CrossUnit_KilogramDividedByGram() {
        Quantity<WeightUnit> q1 = new Quantity<>(2.0, WeightUnit.KG);
        Quantity<WeightUnit> q2 = new Quantity<>(2000.0, WeightUnit.GM);
        assertEquals(1.0, q1.divide(q2));
    }

    @Test
    void testDivision_RatioGreaterThanOne() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        assertTrue(q1.divide(q2) > 1);
    }

    @Test
    void testDivision_RatioLessThanOne() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);
        assertTrue(q1.divide(q2) < 1);
    }

    @Test
    void testDivision_RatioEqualToOne() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);
        assertEquals(1.0, q1.divide(q2));
    }

    @Test
    void testDivision_NonCommutative() {
        Quantity<LengthUnit> a = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(5.0, LengthUnit.FEET);
        assertNotEquals(a.divide(b), b.divide(a));
    }

    @Test
    void testDivision_ByZero() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.0, LengthUnit.FEET);
        assertThrows(ArithmeticException.class, () -> q1.divide(q2));
    }

    @Test
    void testDivision_WithLargeRatio() {
        Quantity<WeightUnit> q1 = new Quantity<>(1e6, WeightUnit.KG);
        Quantity<WeightUnit> q2 = new Quantity<>(1.0, WeightUnit.KG);
        assertEquals(1e6, q1.divide(q2));
    }

    @Test
    void testDivision_WithSmallRatio() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KG);
        Quantity<WeightUnit> q2 = new Quantity<>(1e6, WeightUnit.KG);
        assertEquals(1e-6, q1.divide(q2));
    }

    @Test
    void testDivision_NullOperand() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> q1.divide(null));
    }

    @Test
    void testDivision_CrossCategory() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<WeightUnit> q2 = new Quantity<>(5.0, WeightUnit.KG);
        assertThrows(IllegalArgumentException.class, () -> q1.divide((Quantity) q2));
    }

    @Test
    void testSubtractionAndDivision_Integration() {
        Quantity<LengthUnit> a = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> c = new Quantity<>(5.0, LengthUnit.FEET);
        double result = a.subtract(b).divide(c);
        assertEquals(1.0, result);
    }

    @Test
    void testSubtractionAddition_Inverse() {
        Quantity<LengthUnit> a = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = a.add(b).subtract(b);
        assertEquals(a, result);
    }

    @Test
    void testSubtraction_Immutability() {
        Quantity<LengthUnit> a = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(5.0, LengthUnit.FEET);
        a.subtract(b);
        assertEquals(new Quantity<>(10.0, LengthUnit.FEET), a);
    }

    @Test
    void testDivision_Immutability() {
        Quantity<LengthUnit> a = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(5.0, LengthUnit.FEET);
        a.divide(b);
        assertEquals(new Quantity<>(10.0, LengthUnit.FEET), a);
    }
}
