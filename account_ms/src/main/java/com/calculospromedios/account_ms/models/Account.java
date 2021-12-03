package com.calculospromedios.account_ms.models;

import org.springframework.data.annotation.Id;
public class Account {

    @Id
    private String codigo;
    private String nombreMateria;
    private Float calificacionMateria;
    private Integer creditosMateria;

    public Account(String codigo, String nombreMateria, Float calificacionMateria, Integer creditosMateria) {
        this.codigo = codigo;
        this.nombreMateria = nombreMateria;
        this.calificacionMateria = calificacionMateria;
        this.creditosMateria = creditosMateria;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }
    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Float getCalificacionMateria() {
        return calificacionMateria;
    }
    public void setCalificacionMateria(Float calificacionMateria) {
        this.calificacionMateria = calificacionMateria;
    }

    public Integer getCreditosMateria() {
        return creditosMateria;
    }
    public void setCreditosMateria(Integer creditosMateria) {
        this.creditosMateria = creditosMateria;
    }

    }

