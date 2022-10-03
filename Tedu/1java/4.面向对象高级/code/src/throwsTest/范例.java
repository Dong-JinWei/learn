package throwsTest;

/**
 * @author 26465
 * @create 2022-01-25 11:34
 */
public class 范例 {
    public static void main(String[] args) {
        Student[] arr = {
                new Student(1001, "aa", '男'),
                new Student(1002, "bb", '女'),
                new Student(1003, "cc", '男'),
                new Student(1004, "dd", '女'),
                new Student(1005, "aa", '女')
        };
        try {
            Student stu = search(arr, "aa", '女');
            System.out.println(stu);
        } catch (NameOkException e) {
            System.out.println("名字找到了，性别不匹配");
        } catch (NameNoException e){
            System.out.println("名字没找到");
        }

    }

    public static Student search(Student[] arr, String name, char sex) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].name.equals(name)  && arr[i].sex == sex) {
                return arr[i];
            }
            if (arr[i].name.equals(name)  && arr[i].sex != sex) {
                flag = true;
            }
        }
        if (flag){
            throw new NameOkException();
        }else{
            throw new NameNoException();
        }
    }
}

class Student {
    int id;
    String name;
    char sex;

    public Student(int id, String name, char sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}

class NameOkException extends RuntimeException {

}

class NameNoException extends RuntimeException {

}