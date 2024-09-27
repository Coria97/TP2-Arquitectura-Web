package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Carrera {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_carrera;

    private String nombre;

    private String area;

    private Integer duracion;

    @OneToMany(mappedBy = "carrera")
    private Set<EstudianteCarrera> estudiantes = new HashSet<>();

    // Metodos
    public Carrera() { }

    public Carrera(String nombre, String area, Integer duracion) {
        this.nombre = nombre;
        this.area = area;
        this.duracion = duracion;
    }

    public Integer getId() { return this.id_carrera; }

    public Set<EstudianteCarrera> getEstudiantes() {
        return estudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public String getArea() {
        return area;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
