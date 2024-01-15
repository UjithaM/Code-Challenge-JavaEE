package software.ujithamigara.codechallengejavaee.dao;

import org.hibernate.Session;

import java.util.List;

public interface CRUD<T> {
    List<T> getAll() throws Exception;
    boolean save(T t) throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(String id) throws Exception;
}
