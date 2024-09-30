package entities;

import javax.persistence.*;
import java.time.LocalDate;
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

    private LocalDate fecha_inscripcion;

    private LocalDate fecha_graduacion;

    //date fecha inscripcion y graduacion
    //fecha inscrip tome la fecha

    // Metodos
    public EstudianteCarrera() {}

    public EstudianteCarrera(Estudiante estudiante, Carrera carrera) {
        this.id = new EstudianteCarreraPK(estudiante.getId(), carrera.getId());
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.fecha_inscripcion = LocalDate.now();
        this.fecha_graduacion = null;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

}
