package NewCalc;

         /* методов по конвертации цифр из арбских в римские и наоборот
         в сети великое множество, изобретать велосипед не стал.
         */
import java.util.HashMap;
import java.util.Map;

public class CalcParse {

                 //соответствие римские-арабские числа (I..X, 1..10)
    private final Map<String, Integer> arabianRomanMap = new HashMap<>(); // специальная конструкция мэп с ключами

                 //соответствие римские-арабские наименования чисел
    private final int[] arabNumeral = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] romeNumeral = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public CalcParse() {
        arabianRomanMap.put("I", 1);
        arabianRomanMap.put("II", 2);
        arabianRomanMap.put("III", 3);
        arabianRomanMap.put("IV", 4);
        arabianRomanMap.put("V", 5);
        arabianRomanMap.put("VI", 6);
        arabianRomanMap.put("VII", 7);
        arabianRomanMap.put("VIII", 8);
        arabianRomanMap.put("IX", 9);
        arabianRomanMap.put("X", 10);
    }

                   // проверка что число арабское
    public boolean arabic (String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

                   // проверка, что число римское (ограничение I..X)
    public boolean rome (String str) {
        return arabianRomanMap.containsKey(str);
    }

                   // перевод из римского в арабское число (ограничение I..X)
    public Integer romeArabicConverter(String st){
        if (arabianRomanMap.containsKey(st)){
            return arabianRomanMap.get(st);
        }
        return null;
    }

                    //   перевод арабского числа в римское число
    public String arabicRomeConverter(Integer num){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<arabNumeral.length; i++){
            while((num - arabNumeral[i])>=0){
                num -= arabNumeral[i];
                result.append(romeNumeral[i]);
            }
        }
        return result.toString();
    }

                   // проверка операции
    public boolean checkOperator(String op){
        return "*".equals(op) || "/".equals(op) || "+".equals(op) || "-".equals(op);
    }


}
