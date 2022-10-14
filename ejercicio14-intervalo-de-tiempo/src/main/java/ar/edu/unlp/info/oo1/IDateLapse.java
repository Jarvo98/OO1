package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public interface IDateLapse {
    int sizeInDays();
    boolean includesDate(LocalDate date);
}
