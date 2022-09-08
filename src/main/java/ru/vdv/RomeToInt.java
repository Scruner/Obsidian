package ru.vdv;

public class RomeToInt {

  public static void main(String[] args) {
    RomeToInt RomeToInt = new RomeToInt();
    System.out.println(RomeToInt.romanToInt("VIII"));
  }

  public int romanToInt(String s) {
    int value = 0;
    int len = s.length();
    //запускаем итератор по входящему параметру
    for (int i = 0; i < len; i++) {

      //присваиваем переменной ch значение каждого символа строки s, на каждом
      // шаге
      char ch = s.charAt(i);

      //присваиваем переменной cur значение результат работы метода getValue
      // () с параметром очередного значения, в строке s
      int cur = getValue(ch);

      //Условие:
      //1. если мы ещё не дошли до конца строки s
      //2. и при этом, число возвращаемое методом getValue() меньше, числа,
      // которое вернёт этот метод, при вхождении параметра s равного
      // следующему (после значения под индексом i) значению.
      if (i < len - 1 && cur < getValue(s.charAt(i + 1))) {

        //тогда значение, которое возвращает метод romanToInt() будет равно
        // разнице value - результат работы метода getValue(). То есть
        // отнимаем от переменной, результат обработки очередного символа в
        // строке s
        value -= cur;
      } else {

        //в ином случае значение value будет равно сумме value + результат
        // работы метода getValue(). То есть складываем в переменную value
        // результат обработки очередного символа в строке s
        value += cur;
      }
    }
    return value;
  }

  public int getValue(char ch) {
    return switch (ch) {
      case 'I' -> 1;
      case 'V' -> 5;
      case 'X' -> 10;
      case 'L' -> 50;
      case 'C' -> 100;
      case 'D' -> 500;
      case 'M' -> 1000;
      default -> 0;
    };
  }
}
