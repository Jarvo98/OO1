package ar.edu.unlp.info.oo1.first;

import ar.edu.unlp.info.oo1.IDateLapse;

import java.time.LocalDate;

public class DateLapse implements IDateLapse {

    private LocalDate from;
    private LocalDate to;

    public DateLapse(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return this.from;
    }

    public LocalDate getTo() {
        return this.to;
    }

    public int sizeInDays() {
        return this.getFrom().until(this.getTo()).getDays();
    }

    public boolean includesDate(LocalDate date) {
        return this.getFrom().equals(date) || this.getTo().equals(date)
                || (this.getFrom().isBefore(date) && this.getTo().isAfter(date));
    }
}
