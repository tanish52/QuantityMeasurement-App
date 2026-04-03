

import org.apps.quantitymeasurement.controller.QuantityMeasurementController;
import org.apps.quantitymeasurement.repository.IQuantityMeasurementRepository;
import org.apps.quantitymeasurement.repository.QuantityMeasurementDatabaseRepository;
import org.apps.quantitymeasurement.service.IQuantityMeasurementService;
import org.apps.quantitymeasurement.service.QuantityMeasurementServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTestUC16 {

    // Common setup method
    private QuantityMeasurementController getController() {
        IQuantityMeasurementRepository repo = new QuantityMeasurementDatabaseRepository();
        IQuantityMeasurementService service = new QuantityMeasurementServiceImpl(repo);
        return new QuantityMeasurementController(service);
    }

    // 1. Test Save + Fetch
    @Test
    public void testSaveAndFetch() {

        QuantityMeasurementController controller = getController();
        controller.deleteAll();

        controller.addMeasurement("Length", "ADD", 10);

        List<?> list = controller.showAll();

        assertEquals(1, list.size());
    }

    // 2. Test Multiple Insert
    @Test
    public void testMultipleSave() {

        QuantityMeasurementController controller = getController();
        controller.deleteAll();

        controller.addMeasurement("Length", "ADD", 10);
        controller.addMeasurement("Weight", "COMPARE", 5);

        List<?> list = controller.showAll();

        assertEquals(2, list.size());
    }

    // 3. Test Count
    @Test
    public void testCount() {

        IQuantityMeasurementRepository repo = new QuantityMeasurementDatabaseRepository();
        IQuantityMeasurementService service = new QuantityMeasurementServiceImpl(repo);

        service.deleteAll();

        service.saveMeasurement("Length", "ADD", 10);
        service.saveMeasurement("Weight", "COMPARE", 5);

        assertEquals(2, service.getTotalCount());
    }

    // 4. Test Delete All
    @Test
    public void testDeleteAll() {

        QuantityMeasurementController controller = getController();

        controller.addMeasurement("Length", "ADD", 10);
        controller.deleteAll();

        List<?> list = controller.showAll();

        assertEquals(0, list.size());
    }

    // 5. Test Empty Database
    @Test
    public void testEmptyDatabase() {

        QuantityMeasurementController controller = getController();
        controller.deleteAll();

        List<?> list = controller.showAll();

        assertTrue(list.isEmpty());
    }

    // 6. Test Large Data
    @Test
    public void testLargeDataSet() {

        QuantityMeasurementController controller = getController();
        controller.deleteAll();

        for (int i = 0; i < 50; i++) {
            controller.addMeasurement("Length", "ADD", i);
        }

        List<?> list = controller.showAll();

        assertEquals(50, list.size());
    }

    // 7. Test Different Types
    @Test
    public void testDifferentMeasurementTypes() {

        QuantityMeasurementController controller = getController();
        controller.deleteAll();

        controller.addMeasurement("Length", "ADD", 10);
        controller.addMeasurement("Volume", "COMPARE", 20);

        List<?> list = controller.showAll();

        assertEquals(2, list.size());
    }

    // 8. Test Negative Values (edge case)
    @Test
    public void testNegativeValues() {

        QuantityMeasurementController controller = getController();
        controller.deleteAll();

        controller.addMeasurement("Length", "ADD", -5);

        List<?> list = controller.showAll();

        assertEquals(1, list.size());
    }

    // 9. Test Zero Value
    @Test
    public void testZeroValue() {

        QuantityMeasurementController controller = getController();
        controller.deleteAll();

        controller.addMeasurement("Length", "ADD", 0);

        List<?> list = controller.showAll();

        assertEquals(1, list.size());
    }

    // 10. Test Repeated Delete
    @Test
    public void testRepeatedDelete() {

        QuantityMeasurementController controller = getController();

        controller.deleteAll();
        controller.deleteAll();

        List<?> list = controller.showAll();

        assertEquals(0, list.size());
    }
}