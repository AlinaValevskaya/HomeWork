
import java.util.Scanner;

public class second {
    public static void main (String args[]){
        Scanner sc = new Scanner (System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();


        if (x<y+z&&y<x+z&&z<x+y)
            System.out.println("Из данных сторон можно построить треугольник");
        else
            System.out.println("Из данных сторон нельзя построить треугольник");
    }
}
