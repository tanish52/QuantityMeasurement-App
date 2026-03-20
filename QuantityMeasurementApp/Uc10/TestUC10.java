package Uc10;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TestUC10 {
  
  @Test
void testIMeasurableInterface_LengthUnitImplementation() {
    IMeasureable unit = LengthUnit.FEET;

    assertEquals(12.0, unit.getconversionfactor());
    assertEquals(24.0, unit.toBaseUnit(2));
    assertEquals(1.0, unit.fromBaseUnit(12));
}

@Test
void testIMeasurableInterface_WeightUnitImplementation() {
    IMeasureable unit = WeightUnit.KG;

    assertEquals(1.0, unit.getconversionfactor());
    assertEquals(2.0, unit.toBaseUnit(2));
    assertEquals(1.0, unit.fromBaseUnit(1));
}

@Test
void testGenericQuantity_LengthOperations_Equality() {
    Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
    Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);

    assertTrue(q1.equals(q2));
}

@Test
void testGenericQuantity_WeightOperations_Equality() {
    Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KG);
    Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GM);

    assertTrue(q1.equals(q2));
}




    

    @Test
    void testGenericQuantity_LengthOperations_Conversion() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q.convertTo(LengthUnit.INCH);

        assertEquals(12.0, result.getValue(), 1e-3);
    }

    @Test
    void testGenericQuantity_WeightOperations_Conversion() {
        Quantity<WeightUnit> q = new Quantity<>(1.0, WeightUnit.KG);
        Quantity<WeightUnit> result = q.convertTo(WeightUnit.GM);

        assertEquals(1000.0, result.getValue(), 1e-3);
    }

    

    @Test
    void testGenericQuantity_LengthOperations_Addition() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);

        Quantity<LengthUnit> result = q1.add(q2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), 1e-3);
    }

    @Test
    void testGenericQuantity_WeightOperations_Addition() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KG);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GM);

        Quantity<WeightUnit> result = q1.add(q2, WeightUnit.KG);

        assertEquals(2.0, result.getValue(), 1e-3);
    }

    

    @Test
    void testCrossCategoryPrevention_LengthVsWeight() {
        Quantity<LengthUnit> l = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> w = new Quantity<>(1.0, WeightUnit.KG);

        assertFalse(l.equals(w));
    }

    

    @Test
    void testGenericQuantity_ConstructorValidation_NullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null));
    }

    @Test
    void testGenericQuantity_ConstructorValidation_InvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(Double.NaN, LengthUnit.FEET));
    }

    

    @Test
    void testGenericQuantity_Conversion_AllUnitCombinations() {
        for (LengthUnit from : LengthUnit.values()) {
            for (LengthUnit to : LengthUnit.values()) {
                Quantity<LengthUnit> q = new Quantity<>(1.0, from);
                Quantity<LengthUnit> result = q.convertTo(to);

                assertTrue(result.getValue() > 0);
            }
        }
    }

    @Test
    void testGenericQuantity_Addition_AllUnitCombinations() {
        for (WeightUnit u1 : WeightUnit.values()) {
            for (WeightUnit u2 : WeightUnit.values()) {
                Quantity<WeightUnit> q1 = new Quantity<>(1.0, u1);
                Quantity<WeightUnit> q2 = new Quantity<>(1.0, u2);

                Quantity<WeightUnit> result = q1.add(q2, u1);

                assertTrue(result.getValue() > 0);
            }
        }
    }

    

    @Test
    void testHashCode_GenericQuantity_Consistency() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCH);

        assertEquals(q1.hashCode(), q2.hashCode());
    }

  

    @Test
    void testEquals_GenericQuantity_ContractPreservation() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCH);

        assertTrue(a.equals(a)); 
        assertTrue(a.equals(b)); 
        assertTrue(b.equals(a));
    }

    

    @Test
    void testTypeWildcard_FlexibleSignatures() {
        Quantity<?> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<?> q2 = new Quantity<>(1.0, WeightUnit.KG);

        assertNotNull(q1);
        assertNotNull(q2);
    }



    @Test
    void testImmutability_GenericQuantity() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = q1.convertTo(LengthUnit.INCH);

        assertNotSame(q1, q2);
    }

    

    @Test
    void testEnumAsUnitCarrier_BehaviorEncapsulation() {
        IMeasureable unit = LengthUnit.FEET;

        double base = unit.toBaseUnit(1);
        double back = unit.fromBaseUnit(base);

        assertEquals(1.0, back, 1e-3);
    }

  

    @Test
    void testTypeErasure_RuntimeSafety() {
        Quantity<LengthUnit> l = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> w = new Quantity<>(1.0, WeightUnit.KG);

        assertFalse(l.equals(w));
    }



    enum VolumeUnit implements IMeasureable {
        LITER(1.0),
        ML(0.001);

        private final double factor;

        VolumeUnit(double f) {
            factor = f;
        }

        public double getconversionfactor() {
            return factor;
        }
    }

    @Test
    void testScalability_NewUnitEnumIntegration() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITER);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.ML);

        assertTrue(q1.equals(q2));
    }


    @Test
    void testCompositionOverInheritance_Flexibility() {
        Quantity<LengthUnit> q = new Quantity<>(5.0, LengthUnit.FEET);

        assertNotNull(q);
    }





}
