package question;
import java.util.Scanner;


public class Question {//класс вопросов
    private String question;//текст вопроса
    public Option[] option;//массив вариантов ответа

    public Question(String question, Option [] option){//конструктор
        this.question = question;
        this.option = option;
    }
    public String getQuestion() {
        return question;
    }

 }


