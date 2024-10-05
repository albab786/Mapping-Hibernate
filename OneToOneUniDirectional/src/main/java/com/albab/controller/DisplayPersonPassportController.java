package com.albab.controller;

import com.albab.dao.PersonPassportDao;
import com.albab.entity.Person;

import java.util.List;

public class DisplayPersonPassportController {
    public static void main(String[] args) {
        PersonPassportDao dao =new PersonPassportDao();
        List<Person> allDetails = dao.getAllDetails();
        allDetails.stream().forEach(n-> System.out.println(n));

    }
}
