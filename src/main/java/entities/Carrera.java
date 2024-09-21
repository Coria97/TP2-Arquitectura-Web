package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_carrera;

    private String nombre;
    private String area;

    private int duracion;
    @OneToMany(mappedBy = "carrera")
    private Set<EstudianteCarrera> setCarrera = new HashSet<>();


    public Carrera() {

    }

    public Carrera(String nombre, String area, int duracion) {
        this.nombre = nombre;
        this.area = area;
        this.duracion = duracion;
    }


    public Set<EstudianteCarrera> getSetCarrera() {
        return setCarrera;
    }


    public int getId_carrera() {
        return id_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
