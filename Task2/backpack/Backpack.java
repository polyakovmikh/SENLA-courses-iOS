package backpack;

import item.Item;
import java.util.ArrayList;
import java.util.Comparator;

public class Backpack {
    private int capacity;
    private ArrayList<Item> content;

    public Backpack(int capacity) {
        this.capacity = capacity;
        content = new ArrayList<>();
    }

    public void fill(ArrayList<Item> items) {
        int currCapacity = 0;

        items.sort(Comparator.comparing(Item::getCost).reversed());
        for (Item item : items) {
            if (currCapacity + item.getWeight() <= capacity) {
                content.add(item);
                currCapacity += item.getWeight();
            } else {
                continue;
            }
        }
    }

    public void print() {
        for (Item item : content) {
            System.out.printf("%s(%d, %d)\n", item.getName(), item.getWeight(), item.getCost());
        }
    }
}