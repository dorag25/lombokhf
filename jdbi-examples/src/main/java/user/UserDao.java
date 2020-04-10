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
