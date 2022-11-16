package survey;

import java.util.ArrayList;
import java.util.Scanner;

public class Survey {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Participant> participants = new ArrayList<>();

        do{
            System.out.println(SurveyQuestions.askToJoin);
            String join = scan.nextLine();
            if(join.toLowerCase().equals("y")) {
                Participant.addParticipants();

                System.out.println(SurveyQuestions.askName);
                String name = scan.nextLine();

                System.out.println(SurveyQuestions.askAge);
                int age = scan.nextInt();
                scan.nextLine();

                System.out.println(SurveyQuestions.askGender);
                String gender = scan.nextLine().toLowerCase();

            Participant participant = new Participant(name,age,gender);
            participants.add(participant);
            }
        }while (Participant.totalNumberOfParticipants < 3); System.out.println("End of Survey");

        System.out.println(participants);

        for (Participant p : participants) {
            if(p.gender.equals("m")) Participant.addMaleParticipants();
            else Participant.addFemaleParticipants();
        }
        System.out.println("Total number of male participants = " + Participant.totalNumberOfMaleParticipants);
        System.out.println("Total number of female participants = " +Participant.totalNumberOfFemaleParticipants);

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (Participant p : participants) {
            if(p.age > max) max = p.age;
            if(p.age < min ) min = p.age;
        }
        System.out.println("The age of the youngest person is " + min);
        System.out.println("The age of the eldest person is " + max);

    }
            /*
        Write a program that will get information from 3 participants and
        -Print information for each participant
        -Print how many participants were male
        -Print how many participants were female
        -Print the age of the youngest person
        -Print the age of the eldest person
         */

}
