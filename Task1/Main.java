/*
Необходимо написать программу, которая выводит на экран гласные буквы в порядке
не возрастания их общего количества раз использования в словах заданного текста.
Дополнительно можно реализовать следующие возможности:
- использование русского текста помимо английского,
- задание текста в текстовом документе (txt или другой),
- задание ограничения минимальной̆ и максимальной̆ длины проверяемых слов текста.
Пример текста:
"Необходимо написать программу"
Ответ к примеру текста:
"о а и е у" или "о а и у е". Верных вариантов ответа может быть несколько.
 */

import java.util.*;

public class Main {
    public static void main(String args[]) {
        String sample = "Необходимо написать программу. Mojno i na angliskom".toLowerCase().replaceAll("[^аеёиоуыэюяaeiou]", "");
        char[] chararray = sample.toCharArray();
        Arrays.sort(chararray);
        int count = 0;
        ArrayList<Pair> l = new ArrayList<>();
        for (int i = 0; i < chararray.length; i++) {
            for (int j = i; j < chararray.length; j++) {
                if (chararray[i] == chararray[j]) {
                    count++;
                } else {
                    continue;
                }
            }
            l.add(new Pair(chararray[i], count));
            i += count - 1;
            count = 0;
        }
        l.sort(Comparator.comparing(Pair::getValue));
        Collections.reverse(l);
        l.forEach(c -> System.out.printf("%c ", c.getKey()));
    }

    private static class Pair {
        private char key;
        private int value;

        private Pair(char key, int value) {
            this.key = key;
            this.value = value;
        }

        private char getKey() {
            return key;
        }

        private int getValue() {
            return value;
        }
    }
}
