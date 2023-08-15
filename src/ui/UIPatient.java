package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatient {
    public static Patient patientLogged;

    public static ArrayList<Doctor> doctorsAvailableAppointment = new ArrayList<>();

    public static void showPatientMenu(){
        int response = 0;
        patientLogged = (Patient) UIMenu.logged;
        do{
            System.out.println("Welcome patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        }while (response != 0);
    }

    private  static void showBookAppointmentMenu(){
        int response = 0;

        do {
            System.out.println(":: Book an appointment");
            System.out.println(":: Select date:");

            /* Indice de el registro completo <br>Indice de la disponibilidad del doctor<br></bt>Referencia del doctor disponible */
            Map<Integer,Map<Integer,Doctor> > doctors = new TreeMap<>();

            /*Indice de la fecha seleccionada */
            int k = 0;

            //se iteran los doctores con fechas disponibles
            for (int i = 0; i < UIDoctor.doctorsAvailableAppointment.size() ; i++) {

                // Se obtiene uno a uno los doctores que colocaron su disponibilidad
                final Doctor availableDoctor = UIDoctor.doctorsAvailableAppointment.get(i);


                ArrayList<Doctor.AvailableAppointment> availableAppointments =
                        availableDoctor.getAvailableAppointments();
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size() ; j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), availableDoctor);
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }

            //El usuario selecciona su fecha preferida

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = null;

            for (Map.Entry<Integer,Doctor> doc: doctorAvailableSelected.entrySet()){
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    "\n Date: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    "\n Time: " + doctorSelected.getAvailableAppointments().get(indexDate).getTime()
            );

            System.out.println("Confirm 1: ok, 2: repeat");
            response = Integer.valueOf(sc.nextLine());

            if(response == 1){
                patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime()
                );
                showPatientMenu();
            }


        }while (response != 0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;

        do {
            System.out.println("::My Appointments");
            if(patientLogged.getAppointmentDoctors().isEmpty()){
               break;
            }else{
                for (int i = 0; i < patientLogged.getAppointmentDoctors().size(); i++) {
                    System.out.println((i+1) + ". " +
                            "Doctor: + " + patientLogged.getAppointmentDoctors().get(i).getDoctor().toString() +
                            "Date: + " + patientLogged.getAppointmentDoctors().get(i).getDate() +
                            "Time: + " + patientLogged.getAppointmentDoctors().get(i).getTime()
                    );
                }
            }

        }while (response != 0);
    }
}
