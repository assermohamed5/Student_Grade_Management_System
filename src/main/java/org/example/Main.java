package org.example;

import java.util.Arrays;
import java.util.Scanner;




public class Main {
    public static double calcAvgOneSubject(int [][] grade, int subjectNumber){
       int sum=0;

        for(int i = 0; i <grade.length; i++){
           sum+=grade[i][subjectNumber];
        }
        double avg=(double)sum/grade.length;
        return avg;
    }
    public static double calcAvgAllSubjects(int [][] grade,int studentNumber){

        int sum=0;
        for(int i =0;i<grade[0].length;i++){
            sum+=grade[studentNumber][i];
        }
        double avg=(double)sum/grade[0].length;
        return avg;

    }
    public static char grading(double avg){
        if (avg >= 85) {
            return 'A';
        } else if (avg >= 75) {
            return 'B';
        } else if (avg >= 65) {
            return 'C';
        } else if (avg >= 50) {
            return 'D';
        } else {
            return 'F';
        }

    }



    public static int maxGrade(int [][] grade, int subjectNumber){
    int max=grade[0][subjectNumber];
        for(int i =0;i<grade.length;i++){
            if (grade[i][subjectNumber]>max){
                max=grade[i][subjectNumber];
            }
        }
        return max;
}


     public static void main(String[] args) {
//        5 students -> grades in 3 subjects
//        user enters 5 names and their grades
//        display
//        Step 2 - Main Menu
//        Display the below menu:
//        1. Show All Students names.
//        2. Show all Students grades in each subject.
//        3. Search Student by name.
//        4. Count Passed Students
//        0. Exit
//        Grades must be between 0 and 100. If an invalid grade is entered, print 'Invalid grade.' and
//        ask again.


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter The Student Names And Their Grades ->");
//        String firstStudent=scanner.nextLine();
//        int gradeOne=scanner.nextInt();
//        int gradeTwo=scanner.nextInt();
//        int gradeThree=scanner.nextInt();
         String [] student= new String[5];
        int [][] grade = new int [5][3];


        for(int i=0 ;i<student.length;i++) {
            System.out.println("Student Name ");
            student[i]= scanner.next();

            for (int j = 0; j < grade[i].length; j++) {

                System.out.println("Enter Grade For Subject Number " + (j+1) + ":");
                grade[i][j] = scanner.nextInt();
                while(grade[i][j]<0 || grade[i][j]>100){

                        System.out.println("Invalid Grade,Please Enter Grade For Subject Number  " + (j + 1) + " Again :");

                        grade[i][j] = scanner.nextInt();

                    }



            }


            //System.out.println(calcAvg(grade[5][3]));
        }
//         System.out.println("The max of grades for subject  number "+1+" is: "+maxGrade(grade,0));
//         System.out.println("The max of grades for subject  number "+1+" is: "+maxGrade(grade,1));
//         System.out.println("The max of grades for subject  number "+1+" is: "+maxGrade(grade,2));
//
//         System.out.println("The average of grades for subject number "+1+" is: "+calcAvgOneSubject(grade,0));
//         System.out.println("The average of grades for subject number "+2+" is: "+calcAvgOneSubject(grade,1));
//         System.out.println("The average of grades for subject number "+3+" is: "+calcAvgOneSubject(grade,2));
//
//         System.out.println("The average of grade for subject number " +1+ " is: "+calcAvgAllSubjects(grade,0));
//         System.out.println("The average of grade for subject number " +1+ " is: "+calcAvgAllSubjects(grade,1));
//         System.out.println("The average of grade for subject number " +1+ " is: "+calcAvgAllSubjects(grade,2));
//         System.out.println("The average of grade for subject number " +1+ " is: "+calcAvgAllSubjects(grade,3));
//         System.out.println("The average of grade for subject number " +1+ " is: "+calcAvgAllSubjects(grade,4));


//         double studentOne=calcAvgAllSubjects(grade,0);
//         double studentTwo=calcAvgAllSubjects(grade,1);
//         double studentThree=calcAvgAllSubjects(grade,2);
//         double student4=calcAvgAllSubjects(grade,3);
//         double student5=calcAvgAllSubjects(grade,4);

        //menu
        int option;
        do {
            System.out.println("====================");
            System.out.println("Main Menu");
            System.out.println("1. Show All Students Names.");
            System.out.println("2. Show all Students Grades In Each Subject.");
            System.out.println("3. Search Student By Name.");
            System.out.println("4. Count Passed Students");
            System.out.println("0. Exit");
            System.out.println("====================");
            option=scanner.nextInt();
            switch(option){
                case 1->{
                    System.out.println(Arrays.toString(student));
                }
                case 2 ->{
                    System.out.println(Arrays.deepToString(grade));
                }
                case 3 ->{
                    System.out.println("Enter The Student Name Please");
                    String targetStudent=scanner.next();
                    boolean found=false;
                    for(int i =0;i< student.length;i++){
                        if (student[i].equals(targetStudent)){
                            System.out.println(student[i]+" Was Found.");
                            found=true;
                        }

                    }
                    if(!found){
                        System.out.println("Student Not Found");
                    }

                }
                case 4 ->{
                    int count=0;
                    for(int i=0;i<grade.length;i++){
                       double avg= calcAvgAllSubjects(grade,i);
                        char letter=grading(avg);
                        System.out.println(student[i] +"'s Grade Is "+letter);
                        if(avg>=50){
                            count++;
                        }
                    }
                    System.out.println("The Number Of Students That Passed Is :"+count);
                }
                case 5->{

                }
                case 0 ->{
                    System.out.println("Exiting Menu.");
                }
                default -> {
                    System.out.println("Wrong Input");
                }
            }

        }while(option!=0);
    }

}