package laba3.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private ArrayList<T> list = new ArrayList<>();
    public int top;

    public Stack() {
        ArrayList<T> stackArray = new ArrayList<>();
        this.top = -1;
    }

    public void push(T object) {
        list.add(0, object);
    }

    public T pop() {
        return list.remove(0);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T top() {
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            throw new EmptyStackException();
        }
    }
}
