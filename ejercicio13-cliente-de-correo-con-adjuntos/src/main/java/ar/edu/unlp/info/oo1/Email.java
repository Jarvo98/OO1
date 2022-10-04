package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Email {

    private String titulo;
    private String cuerpo;
    private Collection<Archivo> adjuntos;

    public Email(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.adjuntos = new ArrayList<Archivo>();
    }

    public void agregarAdjunto(Archivo archivo) {
        this.adjuntos.add(archivo);
    }

    public int espacioOcupado() {
        return this.titulo.length() + this.cuerpo.length() + this.espacioOcupadoPorAdjuntos();
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getCuerpo() {
        return this.cuerpo;
    }

    public List<Archivo> adjuntos() {
        return new ArrayList<>(this.adjuntos);
    }

    public boolean contieneTexto(String texto) {
        return this.titulo.contains(texto) || this.cuerpo.contains(texto);
    }

    private int espacioOcupadoPorAdjuntos() {
        return this.adjuntos
                .stream()
                .mapToInt(Archivo::tamanio)
                .sum();
    }
}
