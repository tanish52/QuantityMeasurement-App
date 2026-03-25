import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestUC14 {
  
  @Test
void testCelsiusToCelsius_SameValue(){
    assertTrue(new Quantity<>(0.0, TemperatureUnit.CELSIUS)
        .equals(new Quantity<>(0.0, TemperatureUnit.CELSIUS)));
}

@Test
void testFahrenheitToFahrenheit_SameValue(){
    assertTrue(new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT)
        .equals(new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT)));
}



@Test
void testAddThrowsException(){
    Quantity<TemperatureUnit> t1 =
        new Quantity<>(100.0, TemperatureUnit.CELSIUS);

    Quantity<TemperatureUnit> t2 =
        new Quantity<>(50.0, TemperatureUnit.CELSIUS);

    assertThrows(UnsupportedOperationException.class,
        () -> t1.add(t2));
}

@Test
void testSubtractThrowsException(){
    Quantity<TemperatureUnit> t1 =
        new Quantity<>(100.0, TemperatureUnit.CELSIUS);

    Quantity<TemperatureUnit> t2 =
        new Quantity<>(50.0, TemperatureUnit.CELSIUS);

    assertThrows(UnsupportedOperationException.class,
        () -> t1.subtract(t2));
}

@Test
void testDivideThrowsException(){
    Quantity<TemperatureUnit> t1 =
        new Quantity<>(100.0, TemperatureUnit.CELSIUS);

    Quantity<TemperatureUnit> t2 =
        new Quantity<>(50.0, TemperatureUnit.CELSIUS);

    assertThrows(UnsupportedOperationException.class,
        () -> t1.divide(t2));
}

@Test
void testTemperatureVsLength(){
    Quantity<TemperatureUnit> temp =
        new Quantity<>(100.0, TemperatureUnit.CELSIUS);

    Quantity<LengthUnit> len =
        new Quantity<>(100.0, LengthUnit.FEET);

    assertFalse(temp.equals(len));
}

@Test
void testTemperatureVsWeight(){
    Quantity<TemperatureUnit> temp =
        new Quantity<>(50.0, TemperatureUnit.CELSIUS);

    Quantity<WeightUnit> wt =
        new Quantity<>(50.0, WeightUnit.KG);

    assertFalse(temp.equals(wt));
}

@Test
void testNullUnit(){
    assertThrows(IllegalArgumentException.class,
        () -> new Quantity<>(100.0, null));
}

@Test
void testInvalidNumber(){
    assertThrows(IllegalArgumentException.class,
        () -> new Quantity<>(Double.NaN, TemperatureUnit.CELSIUS));
}

@Test
void testEqualsNull(){
    Quantity<TemperatureUnit> q =
        new Quantity<>(10.0, TemperatureUnit.CELSIUS);

    assertFalse(q.equals(null));
}


@Test
void testTemperatureSupportArithmetic(){
    assertFalse(TemperatureUnit.CELSIUS.supportArithmetic());
}
}
