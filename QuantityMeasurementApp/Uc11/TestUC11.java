

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestUC11 {

    

    @Test
    void testEquality_LitreToLitre_SameValue() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertEquals(q1, q2);
    }

    @Test
    void testEquality_LitreToLitre_DifferentValue() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        assertNotEquals(q1, q2);
    }

    @Test
    void testEquality_LitreToMillilitre_EquivalentValue() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        assertEquals(q1, q2);
    }

    @Test
    void testEquality_MillilitreToLitre_EquivalentValue() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertEquals(q1, q2);
    }

    @Test
    void testEquality_LitreToGallon_EquivalentValue() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(0.264172, VolumeUnit.GALLON);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_GallonToLitre_EquivalentValue() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> q2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        assertTrue(q1.equals(q2));
    }


    @Test
  public void testEquality_NullComparison() {
    Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
    assertFalse(q1.equals(null));
}

    @Test
    void testEquality_SameReference() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertEquals(q1, q1);
    }

    @Test
    void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity<>(1.0, null);
        });
    }

    @Test
    void testEquality_TransitiveProperty() {
        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> b = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> c = new Quantity<>(1.0, VolumeUnit.LITRE);

        assertEquals(a, b);
        assertEquals(b, c);
        assertEquals(a, c);
    }

    @Test
    void testEquality_ZeroValue() {
        Quantity<VolumeUnit> q1 = new Quantity<>(0.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(0.0, VolumeUnit.MILLILITRE);
        assertEquals(q1, q2);
    }

    @Test
    void testEquality_NegativeVolume() {
        Quantity<VolumeUnit> q1 = new Quantity<>(-1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(-1000.0, VolumeUnit.MILLILITRE);
        assertEquals(q1, q2);
    }

    @Test
    void testEquality_LargeVolumeValue() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1_000_000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.LITRE);
        assertEquals(q1, q2);
    }

    @Test
    void testEquality_SmallVolumeValue() {
        Quantity<VolumeUnit> q1 = new Quantity<>(0.001, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1.0, VolumeUnit.MILLILITRE);
        assertEquals(q1, q2);
    }


    

    @Test
    void testConversion_LitreToMillilitre() {
        Quantity<VolumeUnit> q = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> converted = q.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), converted);
    }

    @Test
    void testConversion_MillilitreToLitre() {
        Quantity<VolumeUnit> q = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> converted = q.convertTo(VolumeUnit.LITRE);
        assertEquals(new Quantity<>(1.0, VolumeUnit.LITRE), converted);
    }

    @Test
    void testConversion_GallonToLitre() {
        Quantity<VolumeUnit> q = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> converted = q.convertTo(VolumeUnit.LITRE);
        assertTrue(converted.equals(new Quantity<>(3.78541, VolumeUnit.LITRE)));
    }

    @Test
    void testConversion_LitreToGallon() {
        Quantity<VolumeUnit> q = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> converted = q.convertTo(VolumeUnit.GALLON);
        assertTrue(converted.equals(new Quantity<>(1.0, VolumeUnit.GALLON)));
    }

    @Test
    void testConversion_MillilitreToGallon() {
        Quantity<VolumeUnit> q = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> converted = q.convertTo(VolumeUnit.GALLON);
        assertTrue(converted.equals(new Quantity<>(0.264172, VolumeUnit.GALLON)));
    }

        @Test
    void testEquality_VolumeVsLength_Incompatible() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<LengthUnit> q2 = new Quantity<>(1.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_VolumeVsWeight_Incompatible() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<WeightUnit> q2 = new Quantity<>(1.0, WeightUnit.KG);
        assertFalse(q1.equals(q2));
    }
    
    @Test
    void testConversion_SameUnit() {
        Quantity<VolumeUnit> q = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> converted = q.convertTo(VolumeUnit.LITRE);
        assertEquals(q, converted);
    }

    @Test
    void testConversion_ZeroValue() {
        Quantity<VolumeUnit> q = new Quantity<>(0.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> converted = q.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(new Quantity<>(0.0, VolumeUnit.MILLILITRE), converted);
    }

    @Test
    void testConversion_NegativeValue() {
        Quantity<VolumeUnit> q = new Quantity<>(-1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> converted = q.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(new Quantity<>(-1000.0, VolumeUnit.MILLILITRE), converted);
    }

    @Test
    void testConversion_RoundTrip() {
        Quantity<VolumeUnit> q = new Quantity<>(1.5, VolumeUnit.LITRE);
        Quantity<VolumeUnit> converted = q.convertTo(VolumeUnit.MILLILITRE).convertTo(VolumeUnit.LITRE);
        assertTrue(q.equals(converted));
    }


    

    @Test
    void testAddition_SameUnit_LitrePlusLitre() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> sum = q1.add(q2);
        assertEquals(new Quantity<>(3.0, VolumeUnit.LITRE), sum);
    }

    @Test
    void testAddition_SameUnit_MillilitrePlusMillilitre() {
        Quantity<VolumeUnit> q1 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sum = q1.add(q2);
        assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), sum);
    }

    @Test
    void testAddition_CrossUnit_LitrePlusMillilitre() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sum = q1.add(q2);
        assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), sum);
    }

    @Test
    void testAddition_CrossUnit_MillilitrePlusLitre() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> sum = q1.add(q2);
        assertEquals(new Quantity<>(2000.0, VolumeUnit.MILLILITRE), sum);
    }

    @Test
    void testAddition_CrossUnit_GallonPlusLitre() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> q2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> sum = q1.add(q2);
        assertTrue(sum.equals(new Quantity<>(2.0, VolumeUnit.GALLON)));
    }

    @Test
    void testAddition_ExplicitTargetUnit_Litre() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sum = q1.add(q2, VolumeUnit.LITRE);
        assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), sum);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Millilitre() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sum = q1.add(q2, VolumeUnit.MILLILITRE);
        assertEquals(new Quantity<>(2000.0, VolumeUnit.MILLILITRE), sum);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Gallon() {
        Quantity<VolumeUnit> q1 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> sum = q1.add(q2, VolumeUnit.GALLON);
        assertTrue(sum.equals(new Quantity<>(2.0, VolumeUnit.GALLON)));
    }

    @Test
    void testAddition_Commutativity() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sum1 = q1.add(q2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> sum2 = q2.add(q1, VolumeUnit.LITRE);

            assertEquals(sum1, sum2); 
        assertTrue(sum1.convertTo(sum2.getUnit()).equals(sum2));
    }

    @Test
    void testAddition_WithZero() {
        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(0.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sum = q1.add(q2);
        assertEquals(new Quantity<>(5.0, VolumeUnit.LITRE), sum);
    }

    @Test
    void testAddition_NegativeValues() {
        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(-2000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sum = q1.add(q2);
        assertEquals(new Quantity<>(3.0, VolumeUnit.LITRE), sum);
    }

    @Test
    void testAddition_LargeValues() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1e6, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1e6, VolumeUnit.LITRE);
        Quantity<VolumeUnit> sum = q1.add(q2);
        assertEquals(new Quantity<>(2e6, VolumeUnit.LITRE), sum);
    }

    @Test
    void testAddition_SmallValues() {
        Quantity<VolumeUnit> q1 = new Quantity<>(0.001, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(0.002, VolumeUnit.LITRE);
        Quantity<VolumeUnit> sum = q1.add(q2);
        assertTrue(Math.abs(sum.getValue() - 0.003) < 1e-6);
    }


    

    @Test
    void testVolumeUnitEnum_LitreConstant() {
        assertEquals(1.0, VolumeUnit.LITRE.getconversionfactor());
    }

    @Test
    void testVolumeUnitEnum_MillilitreConstant() {
        assertEquals(0.001, VolumeUnit.MILLILITRE.getconversionfactor());
    }

    @Test
    void testVolumeUnitEnum_GallonConstant() {
        assertEquals(3.78541, VolumeUnit.GALLON.getconversionfactor());
    }


    

    @Test
    void testConvertToBaseUnit_LitreToLitre() {
        assertEquals(5.0, VolumeUnit.LITRE.toBaseUnit(5.0), 1e-6);
    }

    @Test
    void testConvertToBaseUnit_MillilitreToLitre() {
        assertEquals(1.0, VolumeUnit.MILLILITRE.toBaseUnit(1000.0), 1e-6);
    }

    @Test
    void testConvertToBaseUnit_GallonToLitre() {
        assertEquals(3.78541, VolumeUnit.GALLON.toBaseUnit(1.0), 1e-6);
    }

    @Test
    void testConvertFromBaseUnit_LitreToLitre() {
        assertEquals(2.0, VolumeUnit.LITRE.fromBaseUnit(2.0), 1e-6);
    }

    @Test
    void testConvertFromBaseUnit_LitreToMillilitre() {
        assertEquals(1000.0, VolumeUnit.MILLILITRE.fromBaseUnit(1.0), 1e-6);
    }

    @Test
    void testConvertFromBaseUnit_LitreToGallon() {
        assertEquals(1.0, VolumeUnit.GALLON.fromBaseUnit(3.78541), 1e-3);
    }
}