/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.util.*;
public class Main
{
    static class HighestAverageCalculatorService {
        private Map<String, Student> students;
        private PriorityQueue<Student> maxHeap;

        public HighestAverageCalculatorService(String[][] studs) {
            students = new HashMap<>();
            for(String[] stud : studs) {
                Student s = new Student(stud[0], Integer.parseInt(stud[1]));
                this.addStudent(s);
                //maxHeap = new PriorityQueue<>(10, Comparator.comparingDouble(User::getAvgMarks));
            }
        }

        public void addStudent(Student s1) {
            if(students.containsKey(s1.getName())) {
                Student fromDict = students.get(s1.getName());
                s1.setNoOfSubjects(fromDict.getNoOfSubjects() + s1.getNoOfSubjects());
                s1.setMarks(fromDict.getMarks() + s1.getMarks());
            }
            s1.setAvgMarks((double)s1.getMarks() / s1.getNoOfSubjects());
            students.put(s1.getName(), s1);
            //maxHeap.offer(s1);
        }

        public Student getHighestAverage() {
            return students.entrySet().stream().max(
                    (e1, e2) -> Double.compare(e1.getValue().getAvgMarks(), e2.getValue().getAvgMarks())).get().getValue();
        }

        //public St


    }
    static class Student {
        private int marks;
        private double avgMarks;
        private String name;
        private int noOfSubjects;

        public Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
            this.noOfSubjects = 1;
        }

        public String getName() {
            return name;
        }

        public int getMarks() {
            return marks;
        }

        public int getNoOfSubjects() {
            return noOfSubjects;
        }

        public void setNoOfSubjects(int noOfSubjects) {
            this.noOfSubjects = noOfSubjects;
        }


        public void setMarks(int marks) {
            this.marks = marks;
        }

        public void setAvgMarks(double avgMarks) {
            this.avgMarks = avgMarks;
        }

        public double getAvgMarks() {
            return this.avgMarks;
        }

        public void print() {
            System.out.println("name = " + this.getName() + "average=" + this.getAvgMarks());
        }
    }
    public static void main(String[] args) {
        String student[][] = {{"jerry","65"}, {"bob","1"}, {"jerry","23"},{"jerry","23"}, {"jerry","100"},{"Eric","50"}};
        HighestAverageCalculatorService hs = new HighestAverageCalculatorService(student);
        Student highest = hs.getHighestAverage();
        highest.print();
    }
}
