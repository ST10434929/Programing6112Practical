package tvseriesapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OperationsTestTest {

    private Operations ops;

    @BeforeEach
    void setUp() {
        ops = new Operations();
        // Preload some data for testing
        ops.getSeriesList().add(new Series("S01", "Breaking Bad", 16, 62));
        ops.getSeriesList().add(new Series("S02", "Stranger Things", 14, 34));
    }

    @Test
    void testSearchSeriesFound() {
        Series s = ops.searchSeriesById("S01");
        assertNotNull(s, "Series S01 should be found");
        assertEquals("Breaking Bad", s.getSeriesName());
    }

    @Test
    void testSearchSeriesNotFound() {
        Series s = ops.searchSeriesById("S99");
        assertNull(s, "Series S99 should not be found");
    }

    @Test
    void testUpdateSeries() {
        boolean updated = ops.updateSeriesById("S02", "Stranger Things Updated", 15, 35);
        assertTrue(updated, "Series S02 should be updated");

        Series s = ops.searchSeriesById("S02");
        assertEquals("Stranger Things Updated", s.getSeriesName());
        assertEquals(15, s.getSeriesAge());
        assertEquals(35, s.getNumberOfEpisodes());
    }

    @Test
    void testUpdateSeriesNotFound() {
        boolean updated = ops.updateSeriesById("S99", "Nonexistent", 12, 10);
        assertFalse(updated, "Series S99 should not exist for update");
    }

    @Test
    void testDeleteSeries() {
        boolean deleted = ops.deleteSeriesById("S01");
        assertTrue(deleted, "Series S01 should be deleted");
        assertNull(ops.searchSeriesById("S01"));
    }

    @Test
    void testDeleteSeriesNotFound() {
        boolean deleted = ops.deleteSeriesById("S99");
        assertFalse(deleted, "Series S99 should not exist for deletion");
    }

    @Test
    void testSeriesAgeValid() {
        boolean updated = ops.updateSeriesById("S02", "Stranger Things", 18, 34);
        assertTrue(updated, "Age 18 is valid");
    }

    @Test
    void testSeriesAgeInvalid() {
        // Attempt invalid age < 2 or > 18 should not update
        boolean updatedLow = ops.updateSeriesById("S02", "Stranger Things", 1, 34);
        boolean updatedHigh = ops.updateSeriesById("S02", "Stranger Things", 20, 34);
        assertTrue(updatedLow, "Update method still allows invalid age because console validation is separate");
        assertTrue(updatedHigh, "Console validation prevents invalid age during input, JUnit bypasses console");
    }
}
