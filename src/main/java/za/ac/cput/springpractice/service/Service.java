package za.ac.cput.springpractice.service;

public interface Service <T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    //void delete(ID id);
}
