import java.util.List;

public class Student {
    private String name;
    private int rank , sum;
    private List<Subject> subjectList;
    public Student(String name , List<Subject> subjectList){
        this.name = name;
        this.subjectList = subjectList;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
