package LeetCodeDaily;

import java.util.Deque;
import java.util.LinkedList;

/*
思路：两个队列分别存储动物编号
*/
class AnimalShelf {

    Deque<Integer> cat;
    Deque<Integer> dog;

    public AnimalShelf() {
        cat = new LinkedList<>();
        dog = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            cat.offer(animal[0]);
        } else {
            dog.offer(animal[0]);
        }
    }

    public int[] dequeueAny() {
        if (!dog.isEmpty() && !cat.isEmpty()) {
            return cat.peek() < dog.peek() ? new int[] { cat.poll(), 0 } : new int[] { dog.poll(), 1 };
        }
        return cat.isEmpty() ? dequeueDog() : dequeueCat();
    }

    public int[] dequeueDog() {
        return dog.isEmpty() ? new int[] { -1, -1 } : new int[] { dog.poll(), 1 };
    }

    public int[] dequeueCat() {
        return cat.isEmpty() ? new int[] { -1, -1 } : new int[] { cat.poll(), 0 };
    }
}
