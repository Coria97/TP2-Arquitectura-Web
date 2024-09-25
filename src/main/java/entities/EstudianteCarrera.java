package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EstudianteCarrera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_estudiante_carrera;

    @ManyToOne
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    private Date antiguedad;
    private boolean graduado;

    public int getId_estudiante_carrera() {
        return id_estudiante_carrera;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public Date getAntiguedad() {
        return antiguedad;
    }

    public boolean isGraduado() {
        return graduado;
    }
}
