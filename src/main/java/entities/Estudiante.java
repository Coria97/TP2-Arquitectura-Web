package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_estudiante;

    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "estudiante")
    private Set<EstudianteCarrera> setEstudiante = new HashSet<>();

    @Column(name = "ciudad_residencia")
    private String ciudad;
    private int edad;

    private char genero;
    private int nro_documento;
    private int nro_libreta_universitaria;


    public Estudiante() {

    }

    public Estudiante(String nombre, String apellido, String ciudad, int edad, char genero, int nro_documento, int nro_libreta_universitaria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.edad = edad;
        this.genero = genero;
        this.nro_documento = nro_documento;
        this.nro_libreta_universitaria = nro_libreta_universitaria;
    }

    public int getId_estudiante() { return id_estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(int nro_documento) {
        this.nro_documento = nro_documento;
    }

    public int getNro_libreta_universitaria() {
        return nro_libreta_universitaria;
    }

    public void setNro_libreta_universitaria(int nro_libreta_universitaria) {
        this.nro_libreta_universitaria = nro_libreta_universitaria;
    }

    public Set<EstudianteCarrera> getSetEstudiante() {
        return setEstudiante;
    }

}