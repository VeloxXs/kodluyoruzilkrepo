import java.util.Scanner;

public class Student {
    private String name, stuNo, classes;
    private int average;
    private boolean isPass;
    private String matematik, fizik, kimya;
    public Student(String name, String stuNo, String matematik, String fizik, String kimya, String classes) {
        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.average = 0;
        this.isPass = false;
        this.matematik = matematik;
        this.fizik = fizik;
        this.kimya = kimya;

    }
    void run(){
        System.out.println("Student " + this.name + " is running the course.");
        addBulkExamNote();
        printNote();
    }
    public void addBulkExamNote() {
        
        System.out.println("Adding exam notes for " + this.name);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Mathematics exam note: ");
        int note1 = scanner.nextInt();
        System.out.print("Enter Mathematics verbal note: ");
        int sozlu1 = scanner.nextInt();
        System.out.print("Enter Physics exam note: ");
        int note2 = scanner.nextInt();
        System.out.print("Enter Physics verbal note: ");
        int sozlu2 = scanner.nextInt();
        System.out.print("Enter Chemistry exam note: ");
        int note3 = scanner.nextInt();
        System.out.print("Enter Chemistry verbal note: ");
        int sozlu3 = scanner.nextInt();
        if(note1 < 0 || note1 > 100 || sozlu1 < 0 || sozlu1 > 100 ||
           note2 < 0 || note2 > 100 || sozlu2 < 0 || sozlu2 > 100 ||
           note3 < 0 || note3 > 100 || sozlu3 < 0 || sozlu3 > 100) {
            System.out.println("Invalid input! Please enter notes between 0 and 100.");
            return;
        }
        int matematikAverage = (int)(note1 *0.8 + sozlu1 *0.2);
        int fizikAverage = (int)(note2 *0.8 + sozlu2 *0.2);
        int kimyaAverage = (int)(note3 *0.8 + sozlu3 *0.2);
        this.average = (int)((matematikAverage + fizikAverage + kimyaAverage) / 3);
        
        isPass();
    }
    
    public void printNote() {
        System.out.println("Student: " + this.name);
        System.out.println("Student No: " + this.stuNo);
        System.out.println("Average: " + this.average);
    }
    public void isPass() {
        if (this.average > 60) {
            System.out.println("Student " + this.name + " has passed the course.");
            this.isPass = true;
        } else {
            System.out.println("Student " + this.name + " has not passed the course.");
            this.isPass = false;
        }
    }
}
