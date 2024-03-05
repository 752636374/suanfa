package 牛客网.一期.yaoheng.basic_class_01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yaoheng5
 * @Classname Code_09_Comparator
 * @Description TODO
 * @date 2022/7/26 7:43
 * @Created by yaoheng5
 */
public class Code_09_Comparator extends AbstractSort {
    public static void main(String[] args) {
        Student s1 = new Student(1, 1, "1");
        Student s2 = new Student(2, 2, "2");
        Student s3 = new Student(3, 3, "3");

        Student[] students = new Student[]{s1, s2, s3};

        Arrays.sort(students, new IdDescComparator());
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].toString());
        }

    }


    @Override
    protected void sort(int[] arr) {


    }

    private static class Student {
        public int id;
        public int age;
        public String name;

        public Student(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "{id:" + id + ",age:" + age + ",name:" + name + "}";
        }

    }

    private static class IdAscComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    private static class IdDescComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }
}
