package com.fellwiin;

import java.util.List;

public interface ContactDAO {
    List<Contact> findAll();

    List<Contact> findByFirstName(String firstName);
//
//    String findFirstNameById(Long id);
//
//    List<Contact> findAllWithDetail();
//
//    void insert(Contact contact);
//
//    void insertWithDetail(Contact contact);
//
//    void update(Contact contact);
}