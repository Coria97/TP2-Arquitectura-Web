package entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EstudianteCarreraPK implements Serializable {
    // Atributos
    private Integer idEstudiante;

    private Integer idCarrera;

    // Metodos
    public EstudianteCarreraPK() { }
    
    public EstudianteCarreraPK(Integer idEstudiante, Integer idCarrera) {
        this.idEstudiante = idEstudiante;
        this.idCarrera = idCarrera;
    }
}
