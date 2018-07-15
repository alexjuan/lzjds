package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends baseModel {
    @Column
    public String name;
    @Column
    public String password;
    @Column
    public String department;
    @Column
    public String phone;

    public User(String name, String password, String department, String phone){
        this.name = name;
        this.password = password;
        this.department = department;
        this.phone = phone;
    }
    public User(){ }
}
