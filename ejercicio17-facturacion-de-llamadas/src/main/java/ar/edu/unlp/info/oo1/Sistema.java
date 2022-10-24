package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Integer> numerosDisponibles;
    private List<Cliente> clientes;

    public Sistema() {
        this.numerosDisponibles = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void agregarNumero(int numero) {
        this.numerosDisponibles.add(numero);
    }

    public PersonaFisica darDeAltaAPersonaFisica(String nombre, String direccion, int dni) {
        return (PersonaFisica) this.darDeAltaACliente(new PersonaFisica(nombre, direccion, this.numerosDisponibles.remove(0), dni));
    }

    public PersonaJuridica darDeAltaAPersonaJuridica(String nombre, String direccion, int cuit, String tipo) {
        return (PersonaJuridica) this.darDeAltaACliente(new PersonaJuridica(nombre, direccion, this.numerosDisponibles.remove(0), cuit, tipo));
    }

    public LlamadaLocal registrarLlamadaLocal(LocalDateTime fechaHora, double duracion, int numeroEmisor, int numeroReceptor) {
        return this
                .buscarClientePorNumeroAsignado(numeroEmisor)
                .registrarLlamadaLocal(fechaHora, duracion, numeroReceptor);
    }

    public LlamadaInterurbana registrarLlamadaInterurbana(LocalDateTime fechaHora, double duracion, int numeroEmisor, int numeroReceptor, double distancia) {
        return this
                .buscarClientePorNumeroAsignado(numeroEmisor)
                .registrarLlamadaInterurbana(fechaHora, duracion, numeroReceptor, distancia);
    }

    public LlamadaInternacional registrarLlamadaInternacional(LocalDateTime fechaHora, double duracion, int numeroEmisor, int numeroReceptor, String paisOrigen, String paisDestino) {
        return this
                .buscarClientePorNumeroAsignado(numeroEmisor)
                .registrarLlamadaInternacional(fechaHora, duracion, numeroReceptor, paisOrigen, paisDestino);
    }

    public Factura facturarACliente(Cliente cliente, LocalDate fechaDeInicio, LocalDate fechaDeFin) {
        return this.clientes.get(this.clientes.indexOf(cliente)).facturar(fechaDeInicio, fechaDeFin);
    }

    private Cliente buscarClientePorNumeroAsignado(int numeroAsignado) {
        return this.clientes
                .stream()
                .filter(cliente -> cliente.tieneElNumero(numeroAsignado))
                .findFirst()
                .get();
    }

    private Cliente darDeAltaACliente(Cliente cliente) {
        this.clientes.add(cliente);
        return cliente;
    }
}
