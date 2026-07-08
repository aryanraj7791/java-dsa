import java.util.*;

public class PrioQueForObjects{

    public static class Student implements Comparable<Student>{

        String name;
        int rank;
        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }

    public static void main(String[] args){
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Aryan",5962));
        pq.add(new Student("Himanshu",45821));
        pq.add(new Student("Karan",9212));
        pq.add(new Student("Raghav",7253));
        while(!pq.isEmpty()){
            Student curr = pq.remove();
            System.out.println(curr.name+"->"+curr.rank);
        }
    }
}