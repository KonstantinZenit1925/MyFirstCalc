package NewCalc;

// Создадим класс для обработки исключений. Отсюда мы будем наследоваться при создании своих исключений

public class CalcExcept extends Exception {
    public CalcExcept() {
        System.out.println("Не правильно введена арифметическая операция");
    }

    public CalcExcept(String message){
        this();
        System.out.println(message);
    }
}
