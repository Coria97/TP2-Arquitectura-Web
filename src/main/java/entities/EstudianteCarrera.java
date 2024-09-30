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

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @ManyToOne
    @MapsId("idEstudiante")
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    private Date antiguedad;

    private boolean graduado;

    // Metodos
    public EstudianteCarrera() {}

    public EstudianteCarrera(Estudiante estudiante, Carrera carrera, Date antiguedad, Boolean graduado) {
        this.id = new EstudianteCarreraPK(estudiante.getId(), carrera.getId());
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.antiguedad = antiguedad;
        this.graduado = graduado;
    }

    public EstudianteCarrera(EstudianteCarreraPK id, Date antiguedad, Boolean graduado) {
        this.id = id;
        this.antiguedad = antiguedad;
        this.graduado = graduado;
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
