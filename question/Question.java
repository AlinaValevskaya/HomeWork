package question;
import java.util.Scanner;

class Option { // класс вариатов ответа
    private String answer;//текст ответа
    private boolean correct;//переменная, определяющая правильный ответ

    public Option(String answer, boolean correct) { //конструктор
      this.answer=answer;
      this.correct=correct;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean getCorrect() {
        return correct;
    }
}
public class Question {//класс вопросов
    String question;//текст вопроса
    public Option[] optionQ;//массив вариантов ответа


    public static void main (String args[]) {
        Question q1 = new Question();
        q1.question = "2+2=";

        Option[] option = new Option[4];//Массив вариантов ответа
        option[0] = new Option("", false);
        option[1] = new Option("3", false);
        option[2] = new Option("4", true);
        option[3] = new Option("5", false);
        q1.optionQ = option;

        System.out.println(q1.question);

        for (int i = 1; i < option.length; i++) {
            System.out.println(i + ")" + q1.optionQ[i].getAnswer());
        }

        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();

        if (q1.optionQ[p].getCorrect() == true)
            System.out.println("Верно");
        else
            System.out.println("Не верно");
    }
}


