package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Estudiante {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_estudiante;

    @OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY)
    private Set<EstudianteCarrera> carreras = new HashSet<>();

    @Column(name = "ciudad_residencia")
    private String ciudad;

    private String nombre;

    private String apellido;

    private Integer edad;

    private char genero;

    private Integer nro_documento;

    private Integer nro_libreta_universitaria;

    // Metodos
    public Estudiante() { }

    public Estudiante(String nombre, String apellido, String ciudad, Integer edad, char genero, Integer nro_documento, Integer nro_libreta_universitaria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.edad = edad;
        this.genero = genero;
        this.nro_documento = nro_documento;
        this.nro_libreta_universitaria = nro_libreta_universitaria;
    }

    public Integer getId() { return this.id_estudiante; }

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

    public int getNroDocumento() {
        return nro_documento;
    }

    public void setNroDocumento(int nro_documento) {
        this.nro_documento = nro_documento;
    }

    public int getNro_libreta_universitaria() {
        return nro_libreta_universitaria;
    }

    public void setNro_libreta_universitaria(int nro_libreta_universitaria) {
        this.nro_libreta_universitaria = nro_libreta_universitaria;
    }

    public Set<EstudianteCarrera> getCarreras() {
        return carreras;
    }

}