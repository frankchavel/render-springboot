package com.example.demo.model;
//Importamos las anotaciones necesarias para JPA(Java Persistence API)
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //Indicamos que esta clase es una entidad de JPA
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicamos que el ID se generará automáticamente
    
    private Long id; //Atributo para el ID del usuario
    private String nombre; //Atributo para el nombre del usuario
    private String correo;

    //Metoddos getter y setter para acceder y modificar los campos privados
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
