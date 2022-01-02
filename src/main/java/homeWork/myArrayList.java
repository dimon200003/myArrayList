package homeWork;


import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Collection;

public interface myArrayList<E> {
    void add(E e);
    void add(int index, E e);
    void remove(E E);
    void remove(int index);
    Object get(int index);
    void set(int index, E e);
    int size();
    void grow();
    void sort();


}
