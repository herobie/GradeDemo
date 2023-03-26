import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Constant {

    /**
     * 主操作页面
     * @return 功能选择
     */
    public static int singleOperatePanel(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择操作:\n" +
                "1、成绩录入\n" +
                "2、成绩查看\n" +
                "3、查看分析\n" +
                "4、退出");
        int choose = scanner.nextInt();
        return choose;
    }

    /**
     * 成绩输入页面
     * @param subjectList 存放科目类的集合
     */
    public static void inputPanel(List<Subject> subjectList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入科目名:");
        String name = scanner.next();
        System.out.println("请输入成绩:");
        int mark = scanner.nextInt();
        System.out.println("请输入绩点:");
        double GPA = scanner.nextDouble();
        System.out.println("请输入学期:");
        int term = scanner.nextInt();
        subjectList.add(new Subject(name , mark , GPA , term));
        System.out.println("==============  操作结束  ============");
    }

    /**
     * 查询页面
     * @param subjectList 目标集合
     */
    public static void retrievePanel(List<Subject> subjectList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学期:");
        int term = scanner.nextInt();
        System.out.println("请输入科目名:");
        String name = scanner.next();
        boolean isExist = false;
        for (int i = 0 ; i < subjectList.size(); i++){
            if (subjectList.get(i).getTerm() == term && subjectList.get(i).getName().equals(name)){
                System.out.println("科目名:" + name
                + "\n成绩:" + subjectList.get(i).getMark()
                + "\n绩点:" + subjectList.get(i).getGPA());
                isExist = true;
                break;
            }
        }
        if (!isExist){
            System.out.println("找不到该科目");
        }
        System.out.println("==============  操作结束  ============");
    }

    /**
     * 学期分析
     * @param subjectList 科目集合
     * @param term 学期
     */
    public static void analyzeMark(Student student , List<Subject> subjectList , int term){
        int subjectNum = 0;
        int highestMark = 0;
        String advantageSubject = null;
        int sum = 0;
        for (int i = 0 ; i < subjectList.size(); i ++){
            if (subjectList.get(i).getTerm() == term){
                subjectNum++;
                sum += subjectList.get(i).getMark();
                if (subjectList.get(i).getMark() >= highestMark){
                    highestMark = subjectList.get(i).getMark();
                    advantageSubject = subjectList.get(i).getName();
                }
            }
        }
        student.setSum(sum);
        if (!subjectList.isEmpty()){
            System.out.println("当前录入科目数为: " + subjectNum);
            System.out.println("学期总分:" + sum);
            System.out.println("平均分:" + sum/subjectNum);
            System.out.println("最好科目:" + advantageSubject);
            System.out.println("最高分:" + highestMark);
        }else {
            System.out.println("尚未录入任何成绩！");
        }
        System.out.println("==============  操作结束  ============");
    }

    /**
     * 主页面
     * @return 功能选择
     */
    public static int mainPanel(){
        int function = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择功能:");
        System.out.println("1、输入名字");
        System.out.println("2、奖学金获取分析");
        function = scanner.nextInt();
        return function;
    }

    /**
     * 检查学生是否已经录入,如果未录入，返回-1，如果已经录入，返回存在位置
     * @param name 学生名字
     * @param studentList 学生列表
     * @return 存在情况
     */
    public static int isStudentExist(String name , List<Student> studentList){
        int isExist = -1;
        for (int i = 0 ; i < studentList.size() ; i++){
            if (studentList.get(i).getName().equals(name)){
                isExist = i;
                break;
            }
        }
        return isExist;
    }

    public static void bonusEstimate(List<Student> studentList){
        System.out.println("预计一等奖学金人数: 1");
        System.out.println("预计二等奖学金人数: 3");
        System.out.println("预计三等奖学金人数: 2");
    }
}
