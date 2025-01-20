package com.hub.foro.modelo;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table (name = "topico")
public class Topico {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Size(min = 5, max = 100)
        private String titulo;

        @NotNull
        @Size(min = 10, max = 500)
        private String mensaje;

        @NotNull
        private String autor;

        @NotNull
        private String curso;

        private LocalDateTime creacionDato = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public LocalDateTime getCreacionDato() {
        return creacionDato;
    }

    public void setCreacionDato(LocalDateTime creacionDato) {
        this.creacionDato = creacionDato;
    }



    }





