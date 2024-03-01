
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Point {
    final double x;
    final double y;
    //constructor
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double distance(Point that)
    {
        /* Compute the distance between this and that */
        double distance = Math.sqrt((that.x - this.x) * (that.x - this.x) + (this.y - that.y) * (this.y - that.y));
        //return the distance
        return distance;
    }
}
class Pair
{
    Point one;
    Point two;
    //constructor
    public Pair(Point one, Point two)
    {
        this.one = one; this.two = two;
    }
}

public class ClosestPair {

    private static Pair findClosestPair(List<Point> points)
    {
        //to keep track of the minimum distance between two points
        double min_distance = Double.POSITIVE_INFINITY;

        // created an empty pair, so we can store the two cloest points to this
        Pair closet_pairs = new Pair(points.get(0), points.get(0));

        /*  DO THE THING! */
        //loop through the first and second point
        for(int i = 0; i< points.size();i++) {
            //starts at the second point and compares it to every other point until the end of the list
            for (int j = i + 1; j < points.size(); j++)
            {
                //get the first point
                Point point_one = points.get(i);
                //get the second point
                Point point_two = points.get(j);
                double distance_between_two_points = point_one.distance(point_two); // checks the distance between the first two

                //if the distance is less than the min_distance do the following code, else dont do anything
                if(distance_between_two_points < min_distance)
                {
                    //update minDistance
                    min_distance = distance_between_two_points;
                    //store the two points to this pair
                    closet_pairs = new Pair(point_one, point_two);

                }
            }
        }
        //return the two closest pairs
        return closet_pairs;


    }

    public static void main(String[] args)
    {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Enter the amount of points: ");
        int N = scanner.nextInt();
        List<Point> points = new ArrayList<>();
        System.out.println("Now Enter the Points: ");
        for (int i = 0; i < N; i+=1) {

            points.add(new Point(scanner.nextDouble(), scanner.nextDouble()));
        }


        Pair closest = findClosestPair(points);

        System.out.println();
        System.out.println("The two closets pairs are: ");
        System.out.println(closest.one.x + " " + closest.one.y);
        System.out.println(closest.two.x + " " + closest.two.y);
    }

}

