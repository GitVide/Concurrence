package homework.student;

public class Student {
    private int number;
    private int state;
    private int score;

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", state=" + state +
                ", score=" + score +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(int number, int state, int score) {
        this.number = number;
        this.state = state;
        this.score = score;
    }

    public static void main(String[] args) {
        Student[] students = new Student[20];
        for (int i = 0; i < 20; i++) {
            int sore = (int) (Math.random() * 100);
            int state = (int) (Math.random() * 3 + 1);
            students[i] = new Student(i + 1, state, sore);
        }
        System.out.println("3年级的学生信息");
        for (Student s : students) {
            if (s.getState() == 3) {
                System.out.println(s);
            }

        }
        System.out.println("冒泡排序:");
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].getScore() > students[j + 1].getScore()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
