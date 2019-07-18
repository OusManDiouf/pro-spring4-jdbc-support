package com.fellwiin;

import java.util.List;

public interface ContactDAO {

    List<Contact> findAll();

    List<Contact> findByFirstName(String firstName);

    void update(Contact contact);

    void insert(Contact contact);

//    String findFirstNameById(Long id);
//
//    List<Contact> findAllWithDetail();
//
//    void insertWithDetail(Contact contact);
//
}