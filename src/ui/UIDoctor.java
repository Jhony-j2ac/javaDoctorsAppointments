package ui;

import model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UIDoctor {

    public static Doctor doctorLogged;

    public static ArrayList<Doctor> doctorsAvailableAppointment = new ArrayList<>();
    /**
     * Show doctors ui options
     */
    public static void showDoctorMenu(){
        int response = 0;
        do {
            doctorLogged = (Doctor) UIMenu.logged;
            System.out.println("Welcome doctor "+ doctorLogged.getName());

            System.out.println("1. Add Available appointment");
            System.out.println("2. My scheduled appointments");
            System.out.println("0. Loggout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response){
                case 1:
                    showAddAvailableAppointments();
                    break;
                case 2:

                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    break;
            }





        }while(response != 0);
    }

    public  static  void showAddAvailableAppointments(){
        int response = 0;
        do{
            System.out.println();
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select a month");

            for (int i = 0; i < UIMenu.MONTHS.length; i++) {
                System.out.println( (i+1)+ ": " + UIMenu.MONTHS[i]);
            }
            System.out.println("0: return");
            Scanner sc  = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if(response > 0 && response <= UIMenu.MONTHS.length ){
                int monthSelected = response -1;
                System.out.println(UIMenu.MONTHS[monthSelected] + "selected");
                System.out.println("Insert the available date [dd/mm/yyyy]");
                String date =  String.valueOf(sc.nextLine());
                System.out.println("Your date is "+ date);
                System.out.println("1: Confirm\n2: Repeat");

                int responseDate = Integer.valueOf(sc.nextLine());
                if(responseDate == 2) continue;

                int responseTime;
                String time;
                do{

                System.out.println("Insert the available time [H:i:s]");
                time =  String.valueOf(sc.nextLine());
                System.out.println("Your time is "+ time);
                System.out.println("1: Confirm\n2: Repeat");

                responseTime = Integer.valueOf(sc.nextLine());

                }while (responseTime != 1);

                doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointments(doctorLogged);


            } else if (response == 0) {
                showDoctorMenu();
            }

        }while (response != 0);
    }


    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if(!doctor.getAvailableAppointments().isEmpty()
        && !doctorsAvailableAppointment.contains(doctor)){
            doctorsAvailableAppointment.add(doctor);
        }

    }
}
