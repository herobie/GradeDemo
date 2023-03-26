import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        chooseStudent : while (true){
            int feature = Constant.mainPanel();
            switch (feature){
                case 1:
                    System.out.println("请输入学生名字:");
                    String name = scanner.next();
                    List<Subject> subjectList;
                    Student student;
                    int isExist = Constant.isStudentExist(name , studentList);
                    if (isExist == -1){
                        subjectList= new ArrayList<>();
                        student = new Student(name , subjectList);
                        studentList.add(student);
                    }else {
                        student = studentList.get(isExist);
                        subjectList = student.getSubjectList();
                    }
                    panel : while (true){
                        int function = Constant.singleOperatePanel();
                        switch (function){
                            case 1:
                                Constant.inputPanel(subjectList);
                                break;
                            case 2:
                                Constant.retrievePanel(subjectList);
                                break;
                            case 3:
                                System.out.println("请输入学期:");
                                int term = scanner.nextInt();
                                Constant.analyzeMark(student , subjectList , term);
                                break;
                            case 4:
                                System.out.println("操作结束");
                                break panel;
                        }
                    }
                    break;
                case 2:
                    Constant.bonusEstimate(studentList);
                    break;
            }
        }
    }


}