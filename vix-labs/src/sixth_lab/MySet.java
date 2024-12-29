package sixth_lab;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Клас, що реалізує інтерфейс Set з типізованою колекцією на основі масиву.
 * Масив автоматично збільшується на 30% при переповненні.
 *
 * @param <T> тип елементів у колекції
 */
public class MySet<T> implements Set<T> {
    private Object[] elements;
    private int size;

    private static final double GROWTH_FACTOR = 1.3;
    private static final int DEFAULT_SIZE = 15;

    /**
     * Порожній конструктор, що ініціалізує колекцію з 15 елементами.
     */
    public MySet() {
        this.elements = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    /**
     * Конструктор, що ініціалізує колекцію на основі переданого об'єкта TypedSet.
     *
     * @param other колекція TypedSet, яка буде скопійована
     */
    public MySet(MySet<T> other) {
        this.elements = Arrays.copyOf(other.elements, other.elements.length);
        this.size = other.size;
    }

    /**
     * Конструктор, що ініціалізує колекцію з переданою стандартною колекцією.
     *
     * @param collection колекція, що містить елементи для ініціалізації
     */
    public MySet(Collection<T> collection) {
        this.elements = new Object[15];
        this.size = 0;
        for (T item : collection) {
            add(item);
        }
    }

    /**
     * Додає елемент у колекцію.
     * Якщо масив заповнений, він збільшується на 30%.
     *
     * @param t елемент, який додається
     * @return true, якщо елемент успішно додано
     */
    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = t;
        return true;
    }

    /**
     * Збільшує розмір масиву на 30%.
     */
    private void increaseCapacity() {
        int newCapacity = (int) (elements.length * GROWTH_FACTOR);
        elements = Arrays.copyOf(elements, newCapacity);
    }

    /**
     * Перевіряє, чи містить колекція переданий елемент.
     *
     * @param o елемент для перевірки
     * @return true, якщо елемент міститься в колекції
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Перевіряє, чи містить колекція всі елементи переданої колекції.
     *
     * @param c колекція для перевірки
     * @return true, якщо колекція містить усі елементи
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * Видаляє елемент з колекції.
     *
     * @param o елемент, який потрібно видалити
     * @return true, якщо елемент був успішно видалений
     */
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                // Сдвиг елементів після видаленого
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Очищає колекцію.
     */
    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    /**
     * Повертає кількість елементів у колекції.
     *
     * @return кількість елементів
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Перевіряє, чи є колекція порожньою.
     *
     * @return true, якщо колекція порожня
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Повертає ітератор для колекції.
     *
     * @return ітератор
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                return (T) elements[currentIndex++];
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }


}
