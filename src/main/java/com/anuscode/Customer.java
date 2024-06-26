package com.anuscode;

import jakarta.persistence.*;

import java.util.Objects;

// 1st Step: Creating Models

 @Entity             // need to connect JPA
 public class Customer {

    //By using @Entity we are mapping customer class to our database and creating table called customer having four variables declared below
    // and by doing @Id @SequenceGenerator and @GeneratedValue  used for sequence

    @Id
    @SequenceGenerator( // this is used for postgresql
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    //Constructor with args
    public Customer(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    //no arg Constructors
    public Customer() {
    }

    // getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //equals method
    @Override
    public boolean equals(Object o) {

        //Conditions in equals methods
        //1) the object is compared to itself
        if (this == o) return true;

        //2) the object we passed in argument is null
        if (o == null ) return false;

        //3) the datatype of object do not match.
        if (getClass() != o.getClass()) return false;

        //4) the objects are of same datatype
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(age, customer.age);
    }

    //hashcode method
    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, age);
    }

    //toString method
    // We use toString method to return our class variables as a string otherwise it returns the memory location of variables
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
