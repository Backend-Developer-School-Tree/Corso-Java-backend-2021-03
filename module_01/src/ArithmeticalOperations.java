
public class ArithmeticalOperations {

    public static void main(String[] args) {
        int a= 5;
        System.out.print("Enter b:");
        int b= 2;
        computeValues(a, b);
    }

    private static void computeValues(int a, int b) {
        int resulta,results,resultm;
        float resultd;
        resulta=a+b;
        results=a-b;
        resultm=a*b;
        resultd=(float)a/b;
        System.out.println("The result of adding is "+resulta);
        System.out.println("The result of subtracting is "+results);
        System.out.println("The result of multiplying is "+resultm);
        System.out.println("The result of dividing is "+resultd);
    }
}
