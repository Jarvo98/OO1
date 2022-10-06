package ar.edu.unlp.info.oo1.first;

import ar.edu.unlp.info.oo1.IDateLapse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;

public class DateLapseTest {

    private IDateLapse dateLapse;

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
