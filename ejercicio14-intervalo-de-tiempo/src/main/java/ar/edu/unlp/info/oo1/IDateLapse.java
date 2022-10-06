package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public interface IDateLapse {
    LocalDate getFrom();
    LocalDate getTo();
    int sizeInDays();
    boolean includesDate(LocalDate date);
}
