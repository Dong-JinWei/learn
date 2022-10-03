package ObjectIOStream;

import java.io.Serializable;

class Student implements Serializable {
    int id;
    String name;
    float score;
    MyDate birth;

    public Student(int id, String name, float score, MyDate birth) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", birth=" + birth +
                '}';
    }
}
