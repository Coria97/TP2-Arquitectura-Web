package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EstudianteCarrera {
    // Atributos
    @EmbeddedId
    private EstudianteCarreraPK id;

    @ManyToOne
    @MapsId("idCarrera")
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne
    @MapsId("idEstudiante")
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    private Date antiguedad;

    private boolean graduado;

    // Metodos

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
