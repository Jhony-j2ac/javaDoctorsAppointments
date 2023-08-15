package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    /** Autoincrement new id for each doctor */

    private String speciality;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    /** model.Doctor default name */
    public Doctor(){
        super( "Default name",  "General doctor");

    }
    /**
     * @param name New doctors name
     * @param speciality Doctors speciality
     */
    public Doctor(String name, String speciality){
        super( name, speciality);
    }
    //behaviors

    /**
     * Shows on console doctor's name
     */
    public void showName(){
        System.out.println(name);
    }

    public void showId(){
        System.out.println("This doctor id is "+ id);
    }

    public void addAvailableAppointment(String date,String time){

        availableAppointments.add(new AvailableAppointment(date,time));
    }

    /**
     * Return all the doctors available appointments
     * @return
     */
    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }


    @Override
    public String toString(){
        return super.toString() + "\nSpeciality: " + speciality + "\nAvailable: " + availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz roja");
        System.out.println("Departamento: Cancerologia");
    }

    public static class AvailableAppointment {
        private int id;
        private Date date;
        private String time;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }
        public String getDate(String DATE) {
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        AvailableAppointment(String date, String time){
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        @Override
        public String toString(){
            return "Available appointments \nDate: "+ date + "\nTime: " + time;
        }
    }


}
