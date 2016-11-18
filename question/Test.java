package question;

import java.util.Scanner;

public class Test {
    public static void main (String args[]) {
        Question q1 = new Question();
        q1.question = "2+2=";

        q1.option = new Option[4];//Массив вариантов ответа
        q1.option[0] = new Option("", false);                       // первый вопрос и варианты ответа
        q1.option[1] = new Option("3", false);
        q1.option[2] = new Option("4", true);
        q1.option[3] = new Option("5", false);


        Question q2 = new Question();
        q2.question = "8*8=";

        q2.option = new Option[4];//Массив вариантов ответа
        q2.option[0] = new Option("", false);                       //второй вопрос и варианты ответа
        q2.option[1] = new Option("56", false);
        q2.option[2] = new Option("32", false);
        q2.option[3] = new Option("64", true);


        System.out.println("Вопрос 1: " );
        calculate(q1);
        System.out.println("\nВопрос 2: " );
        calculate(q2);

    }

    //методика расчета правильности ответа
    private static void calculate(Question a) {
            System.out.println(a.question);//вывод текста вопроса

            for (int i = 1; i < a.option.length; i++) {//вывод вариантов ответа
                System.out.println(i + ")" + a.option[i].getAnswer());
            }

            Scanner sc = new Scanner(System.in);
            int p = sc.nextInt();//ответ пользователя

            if (a.option[p].getCorrect() == true)// проверка правильности, введенного ответа
                System.out.println("Верно");
            else
                System.out.println("Не верно");
        }
    }

