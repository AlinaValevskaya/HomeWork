package question;

import java.io.*;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Random;
import java.util.InputMismatchException;

public class Test {
    public static void main(String args[]) throws FileNotFoundException {
// заполнение данными
//---------------------------------------------------------------------------------------------------------------------------
        Question[] qmass;
        qmass = new Question[5];                        //заполнение массива вопросов для первого теста
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

        Question[] qmass2;
        qmass2 = new Question[5];                        //заполнение массива вопросов для второго варианта
        qmass2[1] = new Question("5*5= ", new Option[4]);
        qmass2[2] = new Question("9-1= ", new Option[4]);

        qmass2[1].option[0] = new Option("", false);    // варианты ответа на первый вопрос
        qmass2[1].option[1] = new Option("3", false);
        qmass2[1].option[2] = new Option("25", true);
        qmass2[1].option[3] = new Option("5", false);

        qmass2[2].option[0] = new Option("", false);    // варианты ответа на первый вопрос
        qmass2[2].option[1] = new Option("8", true);
        qmass2[2].option[2] = new Option("25", false);
        qmass2[2].option[3] = new Option("5", false);


        Edition [] editions1;
        editions1 = new Edition[5];                      // массив тестов по математике
        editions1[1] = new Edition(qmass);  //вариант теста №1 с двумя вопросами
        editions1[2] = new Edition(qmass2);  // вариант теста №2 с одним вопросом

        Edition [] editions2;
        editions2 = new Edition[5];                      // массив тестов по русскому

        Subject [] subjects; //массив предметов
        subjects= new Subject[4];
        subjects[1] = new Subject("Математика",editions1); //создание объекта предмет математика, массив тестов по этому предмету
        subjects[2] = new Subject("Русский язык",editions1);//создание объекта предмет русский, массив тестов по этому предмету
//---------------------------------------------------------------------------------------------------------------------
        System.out.println("Выберите предмет, по которому хотели бы пройти тестирование:");
        for (int i=1; i<3;i++)
            System.out.println(i+")"+subjects[i].nameSubject);

        Scanner sc = new Scanner(System.in);
        int numberSubject = sc.nextInt();


        showEdition (subjects[numberSubject].editions); //вызов массива с тестами по выбранному предмету

    }



    public static void showEdition(Edition[] editions) throws FileNotFoundException {
        Calendar c = Calendar.getInstance();
        c.getTime(); //Время начала теста

        FileOutputStream fileOutputStream = new FileOutputStream("c:/Test/test.txt");
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        Random random = new Random();
        showQuestion (editions[random.nextInt(2)+1],printWriter ); //случайный выбор теста по конкретному предмету


        Calendar c1 = Calendar.getInstance();
        c1.getTime();//Время завершения теста

        //расчет времени прохождения теста
        long cDiff = c1.getTimeInMillis()-c.getTimeInMillis();
        System.out.println("Потрачено времени - " + (cDiff/(1000*60))+ "мин " + ((cDiff/1000)%60)+ "c");
        printWriter.println("Потрачено времени - " + (cDiff/(1000*60))+ "мин " + ((cDiff/1000)%60)+ "c");

    }

    //подсчет правильных ответов
    public static void showQuestion(Edition edition,PrintWriter printWriter ) {
        int s=0;
        for (int i = 1; i < 3; i++) {
            System.out.println("Вопрос " + i + ":");

            Random random = new Random();
            s= s+calculate(edition.questions[random.nextInt(2)+1],printWriter);  //счетчик правильных ответов, номер вопроса выбирается случайным образом

        }
        System.out.println("Количество правильных ответов - "+s);
        printWriter.println("Количество правильных ответов - "+s);
        printWriter.close();
    }


    //методика расчета правильности ответа
    public static int calculate(Question a,PrintWriter printWriter ) {

        System.out.println(a.getQuestion());//вывод текста вопроса

        printWriter.println(a.getQuestion());

        for (int i = 1; i < a.option.length; i++) {//вывод вариантов ответа
            System.out.println(i + ")" + a.option[i].getAnswer());
            printWriter.println(i + ")" + a.option[i].getAnswer());
        }



        int p = correct(new Scanner(System.in));;//ответ пользователя


        printWriter.println("Ответ пользователя - "+p);

        int m = 0;

        // проверка правильности, введенного ответа
        if (a.option[p].getCorrect() == true) {
            m++;
            return m;
        }


        return m;
    }


    public static int correct(Scanner sc){   //проверка на ошибки
        int p = 0;

        while(true) {
            try {
                p = sc.nextInt();

                // p = Integer.parseInt(sc.nextLine());
                if (p < 1 || p > 3) throw new IllegalArgumentException();
                break;
            } catch (InputMismatchException e) {
                System.out.println("введена не цифра: ");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("Введен не существующий вариант: ");
                continue;
            }

        }
        return p;

    }
}


