import java.util.Scanner;
import java.lang.Math;

public class CircleManiac {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        long x1 = scn.nextLong();
        long y1 = scn.nextLong();
        long x2 = scn.nextLong();
        long y2 = scn.nextLong();
        double r1 = scn.nextDouble();
        double r2 = scn.nextDouble();


        double distanceBWCenters = distance(x1, y1, x2, y2);
        double sumOfRadius = r1 + r2;
        // checking for concentric case
        if(x1 == x2 && y1 == y2)
            System.out.println("concentric");

        // checking for overlapping condition
        else if( r1 > r2 && distanceBWCenters < r1 || r1 < r2 && distanceBWCenters < r2 )
            System.out.println("overlaps");

        // checking for far apart case
        else if( distanceBWCenters > sumOfRadius )
            System.out.println("far-apart");

        // checking for touches 1 point case
        else if( distanceBWCenters == sumOfRadius )
            System.out.println("touches at 1 point");

        else if( distanceBWCenters < sumOfRadius )
            System.out.println("touches at 2 points");
    }

    public static double distance(long x1,long y1, long x2, long y2) {
        double sqrOfDiffOfX = Math.pow(x1-x2,2);
        double sqrOfDiffOfY = Math.pow(y1-y2,2);
        return Math.sqrt(sqrOfDiffOfX+sqrOfDiffOfY);
    }
}