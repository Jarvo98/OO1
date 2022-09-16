package ar.edu.unlp.info.oo1.redAlumbrado;

import java.util.ArrayList;
import java.util.Collection;

public class Farola {
    private boolean isTurnedOn;
    private Collection<Farola> neighbors;

    private Farola setIsTurnedOn(boolean isTurnedOn) {
        this.isTurnedOn = isTurnedOn;
        return this;
    }

    public Farola() {
        this.neighbors = new ArrayList<>();
    }

    public void pairWithNeighbor(Farola unaFarola) {
        if (!this.isFarolaNeighbor(unaFarola)) {
            this.neighbors.add(unaFarola);
            unaFarola.pairWithNeighbor(this);
        }
    }

    public Collection<Farola> getNeighbors() {
        return this.neighbors;
    }

    public void turnOn() {
        if (!this.isOn())
            this.setIsTurnedOn(true)
                    .getNeighbors()
                    .forEach(neighbor -> neighbor.turnOn());
    }

    public void turnOff() {
        if (this.isOn())
            this.setIsTurnedOn(false)
                    .getNeighbors()
                    .forEach(neighbor -> neighbor.turnOff());
    }

    public boolean isOn() {
        return this.isTurnedOn;
    }

    private boolean isFarolaNeighbor(Farola unaFarola) {
        return this.neighbors.contains(unaFarola);
    }
}
