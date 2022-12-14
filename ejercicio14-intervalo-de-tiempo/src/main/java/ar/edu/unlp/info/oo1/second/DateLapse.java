package ar.edu.unlp.info.oo1.second;

import ar.edu.unlp.info.oo1.IDateLapse;

import java.time.LocalDate;

public class DateLapse implements IDateLapse {

    private LocalDate from;
    private int sizeInDays;

    public DateLapse(LocalDate from, int sizeInDays) {
        this.from = from;
        this.sizeInDays = sizeInDays;
    }

    private LocalDate getFrom() {
        return this.from;
    }

    private int getSizeInDays() {
        return this.sizeInDays;
    }

    private LocalDate getTo() {
        return this.getFrom().plusDays(this.getSizeInDays());
    }

    public int sizeInDays() {
        return this.getFrom().until(this.getTo()).getDays();
    }

    public boolean includesDate(LocalDate date) {
        return this.getFrom().equals(date) || this.getTo().equals(date)
                || (this.getFrom().isBefore(date) && this.getTo().isAfter(date));
    }
}
