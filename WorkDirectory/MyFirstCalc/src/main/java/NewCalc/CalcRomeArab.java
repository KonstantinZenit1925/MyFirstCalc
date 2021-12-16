package NewCalc;

import java.util.Arrays;    // подключаем данный пакет для работы с массивами
import java.util.List;      // подключаем данный пакет для упорядоченного (последовательного) просмотра объектов

public class CalcRomeArab {

    private int number1, number2;     // это целые числа в операции
    private String operation;        // операции в выражении, по условиям задачи могут быть + - * /.


    // выполенение арифметической операции сделаем с помощью специальный оператора выбора — switch case

    // Создадим метод для арифметических операций

    private int calcExp(int a, String operation, int b) {
        int result;
        switch (operation) {
            case "+":
                result = a + b;            // сложение
                break;                     // используем данный оператор для прерывания цикла
            case "-":
                result = a - b;            // вычитание
                break;
            case "*":
                result = a * b;            // умножение
                break;
            case "/":
                result = a / b;            // деление
                break;
            default:
                throw new AssertionError();       // если введена неправильная операция сообщаем ошибку
        }
        return result;        // возвращеаем результат в консоль
    }

    // Создадим метод для проверок того что введено в консоль (используем конструкцию if else)
    public String result(String exp) throws CalcExcept {
        boolean isRomanExp;                                 // укажем что это Римские числа
        CalcParse parse = new CalcParse();

        // разбиваем исходное данные String по разделителю " " нужно чтобы при вводе все не сливалось в строчку
        // взял эту готовую конструкцию из сети!!!

        List<String> expItems = Arrays.asList(exp.split(" "));

        // далее соответсвенно проверяем арифметическую операцию, по условиям калькулятор умеет: + - * /
        if (parse.checkOperator(expItems.get(1))) {
            operation = expItems.get(1);
        } else {
            throw new CalcExcept("ERROR. Выражение арифметической операции '" + expItems.get(1) + "' ошибочно, должны быть: + - * / ");
        }
        // далее сделаем проверку для того чтобы убедиться что оба числа арабские и соотвественно римские


        if (parse.arabic(expItems.get(0)) && parse.arabic(expItems.get(2))) {
            number1 = Integer.parseInt(expItems.get(0));    // используем метод Интеджер для преобразования т.к у нас есть символы римские цифры
            number2 = Integer.parseInt(expItems.get(2));
            isRomanExp = false;
        } else if (parse.rome(expItems.get(0)) && parse.rome(expItems.get(2))) {
            number1 = parse.romeArabicConverter(expItems.get(0));  //здесь Римские цифры через конвертацию из арабских
            number2 = parse.romeArabicConverter(expItems.get(2));
            isRomanExp = true;

            // если введеные числа не соответствуют требованиям ввода то выводим
        } else {
            throw new CalcExcept("ERROR. Оба числа должны быть из одной системы исчисления");
        }

        // сделем проверку чтобы числа 1 и 2 были от 1 до 10 в обоих системах исчисления
        if (!(number1 >= 1 && number1 <= 10)) {
            throw new CalcExcept("ERROR. Число №1 должно быть от 1 до 10 (от I до Х)");
        }

        if (!(number2 >= 1 && number2 <= 10)) {
            throw new CalcExcept("ERROR. Число №2 должно быть от 1 до 10 (от I до Х)");
        }

        int result = calcExp(number1, operation, number2); // получаем итоговый результат

        // сделаем проверку если числа римские, то конвертируем в римские и возвращаем результат

        if (isRomanExp){
            String sign = result < 0 ? " ERROR. Римские цифры не могут быть отрицательными " : "";
            return sign + parse.arabicRomeConverter(result);
        }

            // получаем ответ - арабское число
            // метод возвращает строковое представление переданного аргумента, т.е в нашем случае результат
            return String.valueOf(result);
        }
    }

