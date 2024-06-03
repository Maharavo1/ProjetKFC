package Projet1.KFC.repository;

import java.util.List;

public interface CrudOperations <T>{

    T findById(int id);
    List<T> findAll();
    T save(T toSave);
    T Update(T toUpdate);
}
