public class Subject {
    private String name;
    private int mark , term;
    private double GPA;
    public Subject(String name , int mark , double GPA , int term){
        this.name = name;
        this.mark = mark;
        this.GPA = GPA;
        this.term = term;
    }

    public double getGPA() {
        return GPA;
    }

    public int getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public int getTerm() {
        return term;
    }
}
