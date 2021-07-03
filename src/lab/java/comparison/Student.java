package lab.java.comparison;

public class Student implements Comparable<Student> {

    String name;
    int rollNumber;
    int totalMarks;

    Student(String name, int rollNo, int marks) {
        this.name = name;
        this.rollNumber = rollNo;
        this.totalMarks = marks;

    }


    //Collection.sort()
    public int compareTo(Student student) {

        if (this.totalMarks < student.totalMarks) {
            return -1;
        } else if (this.totalMarks == student.totalMarks) {
            return 0;
        } else {
            return 1;
        }


    }


    public static void main(String args[]) {

        Student s1 = new Student("Tony", 23, 345);
        Student s2 = new Student("Tina", 18, 365);


        int c = s1.compareTo(s2);
        if (c == 0) {

            System.out.println(s1.name + " and " + s2.name + " got the same marks");

        } else if (c == 1) {
            System.out.println(s1.name + " got more marks than " + s2.name);
        } else {
            System.out.println(s1.name + " got less marks than " + s2.name);
        }


    }


}
