import org.jetbrains.annotations.Contract;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
/*
    Класс PiClass предназначен для реализации вычисления числа Пи
    с необходимой точностью методом бесконечного ряда Нилаканта.
 */
public class PiClass {
    public static void main(String[] args) {
        System.out.println("Введите желаемое количество знаков после запятой для вывода числа Пи");
        Scanner scanner = new Scanner(System.in);
        int strNumber = scanner.nextInt();

        BigDecimal res = BigDecimal.valueOf(piNilakantha(strNumber)); // вызов метода вычисления
        String result = res.setScale(strNumber, RoundingMode.HALF_EVEN).toString(); // перевод этого результата в строку и "обрезание" до нужного знака
        System.out.println(result);
    }

    public static double piNilakantha(int numberOfDecimals) {
        double result = 3.0D;
        double startNumber = 2.0D;
        boolean parity = false; // переменная для определения, прибавить или вычесть следующий член ряда
        while (numberOfDecimals > 0) {
            if (!parity) {
                result = result + 4/(startNumber * (startNumber + 1) * (startNumber + 2));
                startNumber += 2;
                parity = !parity;
            }
            else {
                result -= 4/(startNumber * (startNumber + 1) * (startNumber + 2));
                startNumber += 2;
                parity = !parity;
            }
            --numberOfDecimals;
        }
        return result;
    }
}
