package model;

public class Nurse extends User {
    private String speciality;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Nurse(String speciality){
        super("Nurse", "email");
        this.speciality =speciality;
    }


    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz blanca");
        System.out.println("Departamento: Nutriologia");

    }
}
