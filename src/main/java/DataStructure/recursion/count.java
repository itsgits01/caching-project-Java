package DataStructure.recursion;

public class count {
    public static void main(String[] args) {
        printname(10,"Cohort Mthree");
    }

    public static void printname(int n, String name){
        if(n==0){
            return;
        }
        System.out.println(name);
        printname(n-1, name);
    }
}
