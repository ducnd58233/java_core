package service;

public interface GeneralService<T> {

    void add(T t);

    void update(T t, int id);

    void print();

    void sort();

    void deleteById(int id);

}
