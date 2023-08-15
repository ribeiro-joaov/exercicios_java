package application;

import entities.Student;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        int n, sumUnder16;
        double averageHeight, sumHeight, underPercent;

        System.out.println("Quantos itens serão digitados?");
        n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < students.length; i++) {
            System.out.println("Digite os dados do estudante " + i);
            sc.nextLine();
            String name = sc.nextLine();
            int age = sc.nextInt();
            double height = sc.nextDouble();
            students[i] = new Student(name, age, height);
        }

        sumHeight = 0;
        for (Student student : students) {
            sumHeight += student.getHeight();
        }
        averageHeight = sumHeight / students.length;

        sumUnder16 = 0;
        ArrayList<String> studentsUnder16 = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() < 16) {
                sumUnder16++;
                studentsUnder16.add(student.getName());
            }
        }

        System.out.println(sumUnder16);
        underPercent = (double) (sumUnder16 * 100) / students.length;


        System.out.printf("Altura Média: %.2f%n", averageHeight);
        System.out.printf("Pessoas com menos de 16 anos: %.1f%% \n", underPercent);
        System.out.printf(String.join(", ", studentsUnder16));


        sc.close();
    }
}