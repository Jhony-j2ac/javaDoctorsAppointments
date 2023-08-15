package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {

    protected String birthday;
    protected float weight;
    protected float height;
    protected String blood;

    private ArrayList<AppointmentDoctor> appointmentDoctors  = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurse  = new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointment = new AppointmentDoctor(this, doctor,date,time);
        appointment.schedule(date,time);
        appointmentDoctors.add(appointment);
    }



    public ArrayList<AppointmentNurse> getAppointmentNurse() {
        return appointmentNurse;
    }

    public void setAppointmentNurse(ArrayList<AppointmentNurse> appointmentNurse) {
        this.appointmentNurse = appointmentNurse;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
    public Patient(String name, String email){
        super(name,email);
    }

    @Override
    public String toString(){
        return super.toString() + "\nSangre: "+blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial: Completo");
    }

}
