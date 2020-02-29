package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new int[]{};
        } else {
            int last = inputArray[inputArray.length - 1];
            System.arraycopy(inputArray, 0, inputArray, 1, inputArray.length - 1);
            inputArray[0] = last;
            return inputArray;
        }
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        } else {
            int max = inputArray[0], secondMax = 1;
            for (int i = 1; i < inputArray.length; i++) {
                if (max < inputArray[i]) {
                    secondMax = max;
                    max = inputArray[i];
                } else if (secondMax < inputArray[i]) {
                    secondMax = inputArray[i];
                }
            }
            return max * secondMax;
        }
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        } else {
            float percentage = 0;
            String lower = input.toLowerCase();
            for (int i = 0; i < lower.length(); i++) {
                if (lower.charAt(i) == 'a' || lower.charAt(i) == 'b') {
                    percentage += 100;
                }
            }
            return (int) percentage / lower.length();
        }
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        } else {
            for (int i = 0; i < input.length() / 2; i++) {
                if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        } else {
            int count = 1;
            StringBuilder res = new StringBuilder();
            res.append(input.charAt(0));
            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i) != input.charAt(i - 1)) {
                    res.append(count);
                    res.append(input.charAt(i));
                    count = 1;
                } else {
                    count++;
                }
            }
            res.append(count);
            return res.toString();
        }
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() == 0 || two.length() == 0) {
            return false;
        } else {
            char[] chars = one.toCharArray();
            Arrays.sort(chars);
            String sortedOne = new String(chars);
            chars = two.toCharArray();
            Arrays.sort(chars);
            String sortedTwo = new String(chars);
            return sortedOne.equals(sortedTwo);
        }
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m[0].length == 0) {
            return new int[][]{{}, {}};
        } else {
            int[][] newM = new int[m.length][m.length];
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    newM[i][j] = m[j][i];
                }
            }
            return newM;
        }
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0) {
            return "";
        }
        if (separator == null) {
            separator = ' ';
        }
        StringBuilder res = new StringBuilder(inputStrings[0]);
        for (int i = 1; i < inputStrings.length; i++) {
            res.append(separator);
            res.append(inputStrings[i]);
        }
        return res.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) {
            return 0;
        } else {
            int count = 0;
            for (String inputString : inputStrings) {
                if (!inputString.startsWith(prefix)) {
                    continue;
                }
                count++;
            }
            return count;
        }
    }
}
