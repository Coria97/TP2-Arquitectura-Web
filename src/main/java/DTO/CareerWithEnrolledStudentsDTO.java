package DTO;

public class CareerWithEnrolledStudentsDTO {

    private Integer idCareer;
    private String name;
    private Long incriptionAmount;

    public CareerWithEnrolledStudentsDTO(Integer idCareer, String name, Long incriptionAmount) {
        this.idCareer = idCareer;
        this.name = name;
        this.incriptionAmount = incriptionAmount;
    }

    public Integer getIdCareer() {
        return idCareer;
    }

    public void setIdCareer(Integer idCareer) {
        this.idCareer = idCareer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIncriptionAmount() {
        return incriptionAmount;
    }

    public void setIncriptionAmount(Long incriptionAmount) {
        this.incriptionAmount = incriptionAmount;
    }

    @Override
    public String toString() {
        return "CarreraDTO{" +
            "idCarrera=" + idCareer +
            ", nombre='" + name +
            ", cantInscriptos=" + incriptionAmount +
            '}';
    }
}
