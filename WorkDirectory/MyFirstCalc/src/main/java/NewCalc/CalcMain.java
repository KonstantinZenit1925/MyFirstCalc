package NewCalc;

 // Создаем главный метод. Для того чтобы считывать входящий поток данных с клавиатуры
 // Использовал очень подробные статьи с Явараш
 // https://javarush.ru/groups/posts/1919-schitihvanie-s-klaviaturih--riderih
 // https://javarush.ru/groups/posts/isklyucheniya-java


 // подключил пакеты
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CalcMain {
  // воспользуемся специальной конструкцие как Обработка исключений
    public static void main(String[] args) {
        try {                                     // в этом блоке указываем основной путь
            System.out.println("Здравствуйте. Вас приветсвует консольный калькулятор простых операций с арабскими и римскими цифрами");
            System.out.println("Данный калькулятор разрешает Вам вводить числа от 1 до 10 или от I до X включительно. Вводите числа через пробел.");
            System.out.print("Прошу Вас ввести операцию: ");
            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
            String calcString = bReader.readLine();

            CalcRomeArab calc = new CalcRomeArab();
            String result = calc.result(calcString);
            System.out.println("Ответ: " + result);
            System.out.println("Спасибо что воспользовались моим калькулятором!! ");
        } catch (CalcExcept | IOException e) {           // запасной  ход событий с исключениями

        }

    }
}
