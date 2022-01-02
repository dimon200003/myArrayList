package homeWork;


import java.util.Iterator;

public class RealisedMyArrayList<E> implements myArrayList<E> {

    private E[] value;
    private int size;
    private final int INIT_SIZE = 10;
    private final int CUT_SIZE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int indicator = 0;
    private int cnt = 0;


    public RealisedMyArrayList() {
        value = (E[]) new Object();
    }

    @Override
    public void add(Object o) {
        for (int i = 0; i < value.length; i++) {
            if (value[i] == null) {
                value[i] = (E) o;
                size++;
                break;
            }
        }
        if (size > value.length - 1) {
            grow();
        }

    }
    @Override
    public void add(int index, Object o) {
        if(index > INIT_SIZE || index < 0)
            throw new IndexOutOfBoundsException("Неверно указан индекс");

        final int s;
        Object[] array;
        if ((s = cnt) == (array = this.array).length)

        System.arraycopy(array, index,
                array, index + 1,
                s + index);
        array[index] = o;
        cnt = s + 1;
    }

    @Override
    public void remove(Object o) {
        final Object[] ar = array;
        final int size = this.cnt;
        int i = 0;
        found: {
            if (o == null) {
                for (; i < size; i++)
                    if (ar[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(ar[i]))
                        break found;
            }
        }
    }

    @Override
    public void remove(int index) {
        for (int i = index; i<indicator; i++)
            array[i] = array[i+1];
        array[indicator] = null;
        indicator--;
        if (size > value.length - 1) {
            grow();
        }
    }

    @Override
    public Object get(int index) {
        return value[index];
    }

    @Override
    public void set(int index, E e) {
        value[index] = e;
    }

    @Override
    public int size() {
        return value.length;
    }

    @Override
    public void grow() {
        E[] newArray = (E[]) new Object[value.length*2];
        System.arraycopy(value, 0, newArray, 0, value.length);
        value = newArray;
    }

    @Override
    public void sort() {
        int[] arr = new int[value.length];
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) { //прохождение по элементам
                if (arr[i + 1] < arr[i]) {
                    temp = arr[i]; //меняем местами
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }


}






