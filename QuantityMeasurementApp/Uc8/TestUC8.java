package Uc8;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestUC8 {

    double epsilon = 1e-3;

    @Test
    void testLengthUnitEnum_FeetConstant() {
        assertEquals(12.0, LengthUnit.FEET.getConversionFactor());
    }

    @Test
    void testLengthUnitEnum_InchConstant() {
        assertEquals(1.0, LengthUnit.INCH.getConversionFactor());
    }

    @Test
    void testLengthUnitEnum_YardConstant() {
        assertEquals(36.0, LengthUnit.YARD.getConversionFactor());
    }

    @Test
    void testLengthUnitEnum_CentimeterConstant() {
        assertTrue(Math.abs(LengthUnit.CM.getConversionFactor() - 0.393701) < epsilon);
    }

    @Test
    void testConvertToBaseUnit_FeetToInch() {
        assertEquals(60.0, LengthUnit.FEET.BaseUnit(5.0));
    }

    @Test
    void testConvertToBaseUnit_InchToInch() {
        assertEquals(12.0, LengthUnit.INCH.BaseUnit(12.0));
    }

    @Test
    void testConvertToBaseUnit_YardToInch() {
        assertEquals(36.0, LengthUnit.YARD.BaseUnit(1.0));
    }

    @Test
    void testConvertToBaseUnit_CmToInch() {
        double result = LengthUnit.CM.BaseUnit(2.54);
        assertTrue(Math.abs(result - 1.0) < epsilon);
    }

    @Test
    void testConvertFromBaseUnit_InchToFeet() {
        assertEquals(1.0, LengthUnit.FEET.conversionFromBaseUnit(12.0));
    }

    @Test
    void testConvertFromBaseUnit_InchToYard() {
        assertEquals(1.0, LengthUnit.YARD.conversionFromBaseUnit(36.0));
    }

    @Test
    void testConvertFromBaseUnit_InchToCm() {
        double result = LengthUnit.CM.conversionFromBaseUnit(1.0);
        assertTrue(Math.abs(result - 2.54) < epsilon);
    }

    @Test
    void testQuantityLengthRefactored_Equality() {
        UC8.Length l1 = new UC8.Length(1.0, LengthUnit.FEET);
        UC8.Length l2 = new UC8.Length(12.0, LengthUnit.INCH);
        assertTrue(l1.equals(l2));
    }

    @Test
    void testQuantityLengthRefactored_ConvertTo() {
        UC8.Length l = new UC8.Length(1.0, LengthUnit.FEET);
        assertEquals(new UC8.Length(12.0, LengthUnit.INCH), l.convertTo(LengthUnit.INCH));
    }

    @Test
    void testQuantityLengthRefactored_Add() {
        UC8.Length l1 = new UC8.Length(1.0, LengthUnit.FEET);
        UC8.Length l2 = new UC8.Length(12.0, LengthUnit.INCH);
        assertEquals(new UC8.Length(2.0, LengthUnit.FEET),
                UC8.Length.add(l1, l2, LengthUnit.FEET));
    }

@Test
void testQuantityLengthRefactored_AddWithTargetUnit() {
    UC8.Length l1 = new UC8.Length(1.0, LengthUnit.FEET);
    UC8.Length l2 = new UC8.Length(12.0, LengthUnit.INCH);

    UC8.Length result = UC8.Length.add(l1, l2, LengthUnit.YARD);

    double expected = 0.6666667;
    assertEquals(expected, result.convertTo(LengthUnit.YARD).getValue(), 1e-6);
}

    @Test
    void testQuantityLengthRefactored_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UC8.Length(1.0, null);
        });
    }

    @Test
    void testQuantityLengthRefactored_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UC8.Length(Double.NaN, LengthUnit.FEET);
        });
    }

    @Test
    void testRoundTripConversion() {
        double value = 5.0;
        double toInch = LengthUnit.FEET.BaseUnit(value);
        double backToFeet = LengthUnit.FEET.conversionFromBaseUnit(toInch);
        assertTrue(Math.abs(value - backToFeet) < epsilon);
    }
}