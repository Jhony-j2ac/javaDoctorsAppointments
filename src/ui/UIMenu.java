package ui;

import model.Doctor;
import model.Patient;
import model.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * UI elements for menu and load system
 */
public class UIMenu {

    public final static String[] MONTHS= {"Enero", "Febrero", "Marzo", "Abril" , "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static User logged;
    /**
     * Show main application menu
     */
    public static void showMenu(){
        System.out.println("Welcome  to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("*** Doctor ***");
                    authUser(1);
                    UIDoctor.showDoctorMenu();
                    break;
                case 2:
                    System.out.println("*** Patient ***");
                    response = 0;
                    authUser(2);
                    UIPatient.showPatientMenu();

                    //showPatientMenu();
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    /**
     * UI patient menu
     */
    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }

    /**
     * Check if current user type is logged in
     * @param userType <br>1: Doctor,<br>2: Patient
     */
    public static void authUser(int userType){
        ArrayList<Doctor> doctors =  new ArrayList<>();
        doctors.add( new Doctor("Alejandro Martinez",  "alejandro.martinez@mail.com"));
        doctors.add( new Doctor("Karen Sosa",  "Karen@mail.com"));
        doctors.add( new Doctor("Rocio Gómez",  "rocio@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Anahí Salgado", "anahi@mail.com"));
        patients.add(new Patient("Carlos Sanchez", "carlos@mail.com"));
        patients.add(new Patient("Roberto Hernandez", "roberto@mail.com"));

        boolean emailCorrect = false;
        do{
            System.out.println("Ingrese su correo [mail@mail.com]");
            Scanner scn = new Scanner(System.in);
            String email = String.valueOf((scn.nextLine()));

            ArrayList<? extends User> users = new ArrayList<>();
            if(userType == 1){
                users= doctors;
            }else if(userType == 2){
                users= patients;
            }
            //emailCorrect = users.stream().anyMatch(user -> Objects.equals(user.getEmail(), email));
            for (User user: users){
                if(Objects.equals(user.getEmail(), email)){
                    emailCorrect = true;
                    logged = user;
                }
            }
        }while(!emailCorrect);
        System.out.println("Valid email");
    }
}
