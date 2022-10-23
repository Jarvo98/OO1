package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateLapseTest {
    private DateLapse dateLapse;

    @BeforeEach
    public void setUp() {
        this.dateLapse = new DateLapse(this.createFrom(), this.createTo());
    }

    @Test
    public void sizeInDaysTest() {
        assertEquals(7, this.dateLapse.sizeInDays());
    }

    @Test
    public void includesDateTestWithDateInRange() {
        assertTrue(this.dateLapse.includesDate(LocalDate.of(2022, 10, 1)));
    }

    @Test
    public void includesDateTestWithDateOutOfRange() {
        assertFalse(this.dateLapse.includesDate(LocalDate.of(2022, 10, 30)));
    }

    @Test
    public void overlapsTestWithOverlappingDate() {
        assertTrue(this.dateLapse.overlaps(
                new DateLapse(LocalDate.of(2022, 10, 4), LocalDate.of(2022, 10, 11))));
    }

    @Test
    public void overlapsTestWithNonOverlappingDate() {
        assertFalse(this.dateLapse.overlaps(
                new DateLapse(LocalDate.of(2022, 10, 7), LocalDate.of(2022, 10, 11))));
        assertFalse(this.dateLapse.overlaps(
                new DateLapse(LocalDate.of(2022, 9, 21), LocalDate.of(2022, 9, 28))));
    }

    @Test
    public void includesDateTestWithDateInLimit() {
        assertTrue(this.dateLapse.includesDate(this.createFrom()));
        assertTrue(this.dateLapse.includesDate(this.createTo()));
    }

    private LocalDate createFrom() {
        return LocalDate.of(2022, 9, 29);
    }

    private LocalDate createTo() {
        return LocalDate.of(2022, 10, 6);
    }
}
