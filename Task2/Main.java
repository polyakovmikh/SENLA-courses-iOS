/*
Имеется М различных предметов, известны вес каждого предмета и его стоимость.
Необходимо написать программу, которая определяет какие предметы надо положить
в рюкзак, чтобы общий вес не превышал заданной границы, а общая стоимость была
максимальна. Разрешается добавлять дополнительный̆ полезный̆ функционал и всё,
что посчитаете необходимым и/или полезным по своему усмотрению.
 */

import item.Item;
import backpack.Backpack;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/in.txt"));
            int W = scanner.nextInt();  // Вместимость рюкзака
            Backpack backpack = new Backpack(W);
            int M = scanner.nextInt();  // Количество предметов
            ArrayList<Item> items = new ArrayList<>(M);
            for (int i = 0; i < M; i++) {
                items.add(new Item(scanner.next(), scanner.nextInt(), scanner.nextInt()));
            }
            scanner.close();
            backpack.fill(items);
            backpack.print();
        } catch (IOException e) {
            System.out.println("IOError");
        }
    }
}