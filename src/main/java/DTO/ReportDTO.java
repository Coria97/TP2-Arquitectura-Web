package DTO;

public class ReportDTO {
    private Integer idCareer;
    private String name;
    private int year;
    private int inscriptionAmount;
    private int graduatesAmount;

    public ReportDTO(Integer idCareer, String name, int year, int inscriptionAmount, int graduatesAmount) {
        this.idCareer = idCareer;
        this.name = name;
        this.year = year;
        this.inscriptionAmount = inscriptionAmount;
        this.graduatesAmount = graduatesAmount;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getInscriptionAmount() {
        return inscriptionAmount;
    }

    public void setInscriptionAmount(int inscriptionAmount) {
        this.inscriptionAmount = inscriptionAmount;
    }

    public int getGraduatesAmount() {
        return graduatesAmount;
    }

    public void setGraduatesAmount(int graduatesAmount) {
        this.graduatesAmount = graduatesAmount;
    }

    @Override
    public String toString() {
        return  "ReportDTO{" +
                "idCarrera=" + idCareer +
                ", nombre='" + name + ' ' +
                ", anio=" + year +
                ", cantInscriptos=" + inscriptionAmount +
                ", cantRecibidos=" + graduatesAmount +
                '}';
    }
}
