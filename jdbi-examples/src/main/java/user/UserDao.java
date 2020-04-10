package user;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import javax.swing.*;
import java.sql.Date;

@RegisterBeanMapper(User.class)
public interface UserDao {
    @SqlUpdate("""CREATE TABLE user(
    id IDENTITY PRIMARYKEY,
    usrename VARCHAR(255),
    password VARCHAR(255),
    name VARCHAR(255),
    email VARCHAR(255),
    gender Enum("MALE","FEMALE"),
    dob Date,
    enabled VARCHAR(255)
    )"""
    )
    void createTable();
}

    /*Long insert(User user): az adott felhasználó mentése az adatbázisba, a felhasználó automatikusan generált azonosítóját adja vissza
        Optional<User> findById(long id): az adott azonosítójú felhasználó betöltése az adatbázisból
        Optional<User> findByUsername(String username): az adott felhasználói nevű felhasználó betöltése az adatbázisból
        void delete(User user): az adott felhasználó törlése az adatbázisból
        List<User> list(): az összes felhasználó betöltése az adatbázisból*/
