package com.spaceship.person;

import com.spaceship.passport.Passport;

import java.util.Objects;
import java.util.UUID;

public class Person {
    private String id;
    private String name;
    private String email;
    private long phoneNumber;
    private Passport passport;

    public Person(String name, String email, long phoneNumber, Passport passport) {
        // don't need to add UID bc it's autogenerated
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passport = passport;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", passport=" + passport.getPassportNumber() +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Person person = (Person) object;
        return phoneNumber == person.phoneNumber && java.util.Objects.equals(id, person.id) && java.util.Objects.equals(name, person.name) && java.util.Objects.equals(email, person.email) && java.util.Objects.equals(passport, person.passport);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, email, phoneNumber, passport);
    }
}
