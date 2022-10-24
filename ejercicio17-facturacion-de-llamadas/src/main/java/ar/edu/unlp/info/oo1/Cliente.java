package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

    private String nombre;
    private String direccion;
    private int numero;
    private List<Llamada> llamadasRealizadas;

    protected Cliente(String nombre, String direccion, int numero) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numero = numero;
        this.llamadasRealizadas = new ArrayList<>();
    }

    public LlamadaLocal registrarLlamadaLocal(LocalDateTime fechaHora, double duracion, int numeroReceptor) {
        return (LlamadaLocal) this.registrarLlamada(new LlamadaLocal(fechaHora, duracion, this.numero, numeroReceptor));
    }

    public LlamadaInterurbana registrarLlamadaInterurbana(LocalDateTime fechaHora, double duracion, int numeroReceptor, double distancia) {
        return (LlamadaInterurbana) this.registrarLlamada(new LlamadaInterurbana(fechaHora, duracion, this.numero, numeroReceptor, distancia));
    }

    public LlamadaInternacional registrarLlamadaInternacional(LocalDateTime fechaHora, double duracion, int numeroReceptor, String paisOrigen, String paisDestino) {
        return (LlamadaInternacional) this.registrarLlamada(new LlamadaInternacional(fechaHora, duracion, this.numero, numeroReceptor, paisOrigen, paisDestino));
    }

    public Factura facturar(LocalDate fechaDeInicio, LocalDate fechaDeFin) {
        return new Factura(fechaDeInicio, fechaDeFin, this.calcularMontoTotalEnPeriodo(fechaDeInicio, fechaDeFin), this);
    }

    public boolean tieneElNumero(int numero) {
        return this.numero == numero;
    }

    protected abstract double calcularMontoTotalEnPeriodo(LocalDate desde, LocalDate hasta);

    protected double calcularValorDeLlamadasEnPeriodo(LocalDate desde, LocalDate hasta) {
        return this.llamadasRealizadas
                .stream()
                .filter(llamada -> llamada.fueHechaEnPeriodo(desde, hasta))
                .mapToDouble(Llamada::calcularCosto)
                .sum();
    }

    private Llamada registrarLlamada(Llamada llamada) {
        this.llamadasRealizadas.add(llamada);
        return llamada;
    }
}
