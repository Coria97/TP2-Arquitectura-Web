package DTO;

public class CarreraConInscriptosDTO {

    private Integer idCarrera;
    private String nombre;
    private Long cantInscriptos;

    public CarreraConInscriptosDTO(Integer idCarrera, String nombre, Long cantInscriptos) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.cantInscriptos = cantInscriptos;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCantInscriptos() {
        return cantInscriptos;
    }

    public void setCantInscriptos(Long cantInscriptos) {
        this.cantInscriptos = cantInscriptos;
    }

    @Override
    public String toString() {
        return "CarreraDTO{" +
                "idCarrera=" + idCarrera +
                ", nombre='" + nombre + ' ' +
        ", cantInscriptos=" + cantInscriptos +
                '}';
    }
}
