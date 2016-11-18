package question;

class Option { // класс вариатов ответа
    private String answer;//текст ответа
    private boolean correct;//переменная, определяющая правильный ответ

    public Option(String answer, boolean correct) { //конструктор
        this.answer = answer;
        this.correct = correct;
    }
    public String getAnswer() {
        return answer;
    }

    public boolean getCorrect() {
        return correct;
    }
}