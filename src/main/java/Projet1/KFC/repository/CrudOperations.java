package Projet1.KFC.repository;

import java.util.List;

public interface CrudOperations <T>{

    T findById();
    List<T> findAll();
    T save(T toSave);
}
