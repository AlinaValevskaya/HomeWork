//package Home;
import java.util.Scanner;

public class Student {
    public static void main (String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.println("Введите размер стипендии:");
        double N = sc.nextDouble();//размер стипендии
        System.out.println("Введите размер расходов:");
        double M = sc.nextDouble();// размер ежемесячных расходов студента

        double Z = 0;

        for (int i=0; i<10; i++){
            M = M + M * 0.03; //расчет увеличения расходов студента каждый месяц
            Z = Z + M; //общая сумма расходов за 10 месяцев
        }
        double S = Z - N*10; //расчет суммы, которую нужно одолжить у родителей
        System.out.println("у родителей необходимо попросить сумму: "+S);
    }
}
