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



}
