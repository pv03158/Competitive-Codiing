public class Problem {
    public static void main(String[] args) {
        long config = 102334155;
        System.out.println(config);

        // SHOULD PRINT 
        System.out.println("\nResult using * operator : " + config*config);
        System.out.println("\nResult using Pow Function : " + Math.pow(config ,2));
    }
}