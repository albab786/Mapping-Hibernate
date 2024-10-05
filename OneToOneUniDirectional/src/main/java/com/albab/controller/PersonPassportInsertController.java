package com.albab.controller;

import com.albab.dao.PersonPassportDao;
import com.albab.entity.Passport;
import com.albab.entity.Person;

public class PersonPassportInsertController {
    public static void main(String[] args) {
        PersonPassportDao dao =new PersonPassportDao();

        Passport passport=new Passport(202,20,"noida",10045);
        Person person=new Person(420,"xy",passport);
        Person person1 = dao.insertDetails(person, passport);
        System.out.println(person1);
    }
}
