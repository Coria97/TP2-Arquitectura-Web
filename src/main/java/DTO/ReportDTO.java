package DTO;

public class ReportDTO {
    private Integer idCarrera;
    private String nombre;
    private int anio;
    private int cantInscriptos;
    private int cantRecibidos;

    public ReportDTO(Integer idCarrera, String nombre, int anio, int cantInscriptos, int cantRecibidos) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.anio = anio;
        this.cantInscriptos = cantInscriptos;
        this.cantRecibidos = cantRecibidos;
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantInscriptos() {
        return cantInscriptos;
    }

    public void setCantInscriptos(int cantInscriptos) {
        this.cantInscriptos = cantInscriptos;
    }

    public int getCantRecibidos() {
        return cantRecibidos;
    }

    public void setCantRecibidos(int cantRecibidos) {
        this.cantRecibidos = cantRecibidos;
    }

    @Override
    public String toString() {
        return  "ReportDTO{" +
                "idCarrera=" + idCarrera +
                ", nombre='" + nombre + ' ' +
                ", anio=" + anio +
                ", cantInscriptos=" + cantInscriptos +
                ", cantRecibidos=" + cantRecibidos +
                '}';
    }
}
