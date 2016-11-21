package question;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Random;

public class Test {
    public static void main(String args[]) {
        Question[] qmass;
        qmass = new Question[5];                        //заполнение массива вопросов
        qmass[1] = new Question("2+2= ", new Option[4]);
        qmass[2] = new Question("8*8=", new Option[4]);

        qmass[1].option[0] = new Option("", false);    // варианты ответа на первый вопрос
        qmass[1].option[1] = new Option("3", false);
        qmass[1].option[2] = new Option("4", true);
        qmass[1].option[3] = new Option("5", false);


        qmass[2].option[0] = new Option("", false);      //варианты ответа на второй вопрос
        qmass[2].option[1] = new Option("56", false);
        qmass[2].option[2] = new Option("32", false);
        qmass[2].option[3] = new Option("64", true);


        Calendar c = Calendar.getInstance();
        c.getTime(); //Время начала теста

        int s=0;
        for (int i = 1; i < 3; i++) {
            System.out.println("Вопрос " + i + ":");

            Random random = new Random();
            s= s+calculate(qmass[random.nextInt(2)+1]);  //счетчик правильных ответов, номер вопроса выбирается случайным образом

        }

        Calendar c1 = Calendar.getInstance();
        c1.getTime();//Время завершения теста


        long cDiff = c1.getTimeInMillis()-c.getTimeInMillis();
        System.out.println("Потрачено времени - " + (cDiff/(1000*60))+ "мин " + ((cDiff/1000)%60)+ "c");

      System.out.println("Количество правильных ответов - "+s);
    }


    //методика расчета правильности ответа
    public static int calculate(Question a) {
        System.out.println(a.getQuestion());//вывод текста вопроса

        for (int i = 1; i < a.option.length; i++) {//вывод вариантов ответа
            System.out.println(i + ")" + a.option[i].getAnswer());
        }

        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();//ответ пользователя

        int m = 0;

        // проверка правильности, введенного ответа
        if (a.option[p].getCorrect() == true) {
            m++;
            return m;
        }

        return m;
    }
}


