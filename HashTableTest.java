
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HashTableTest {
    // Tests adding a single record.
    @Test
    public void testPutOneRecord() {

        RecordHashTable table = new RecordHashTable();

        Record r = new Record("Rock", 1977,
                "Fleetwood Mac", "Dreams");

        table.put(r);

        assertEquals(1, table.size());
    }

    // Tests if multiple records can be added.
    @Test
    public void testPutMultipleRecords() {

        RecordHashTable table = new RecordHashTable();

        table.put(new Record("Rock", 1977,
                "Fleetwood Mac", "Dreams"));

        table.put(new Record("Pop", 1982,
                "Michael Jackson", "Thriller"));

        assertEquals(2, table.size());
    }

    // Tests removing a record.
    @Test
    public void testRemoveRecord() {

        RecordHashTable table = new RecordHashTable();

        Record r = new Record("Rock", 1977,
                "Fleetwood Mac", "Dreams");

        table.put(r);
        table.remove(r);

        assertFalse(table.contains(r));
    }

    // Tests removing from empty table.
    @Test
    public void testRemoveEmptyTable() {

        RecordHashTable table = new RecordHashTable();

        Record r = new Record("Rock", 1977,
                "Fleetwood Mac", "Dreams");

        table.remove(r);

        assertEquals(0, table.size());
    }

    // Tests contains() when record exists.
    @Test
    public void testContainsTrue() {

        RecordHashTable table = new RecordHashTable();

        Record r = new Record("Rock", 1977,
                "Fleetwood Mac", "Dreams");

        table.put(r);

        assertTrue(table.contains(r));
    }

    // Tests contains() when record does not exist.
    @Test
    public void testContainsFalse() {

        RecordHashTable table = new RecordHashTable();

        Record r = new Record("Rock", 1977,
                "Fleetwood Mac", "Dreams");

        assertFalse(table.contains(r));
    }

    // Tests get() returns correct record.
    @Test
    public void testGetRecord() {

        RecordHashTable table = new RecordHashTable();

        Record r = new Record("Rock", 1977,
                "Fleetwood Mac", "Dreams");

        table.put(r);

        assertEquals(r, table.get("Dreams"));
    }

    @Test
    public void testGetMissingRecord() {

        RecordHashTable table = new RecordHashTable();

        assertNull(table.get("Nothing"));
    }

    // Tests isEmpty() on empty table.
    @Test
    public void testIsEmptyTrue() {

        RecordHashTable table = new RecordHashTable();

        assertTrue(table.isEmpty());
    }

    // Tests isEmpty() after adding item.
    @Test
    public void testIsEmptyFalse() {

        RecordHashTable table = new RecordHashTable();

        table.put(new Record("Rock", 1977,
                "Fleetwood Mac", "Dreams"));

        assertFalse(table.isEmpty());
    }
}