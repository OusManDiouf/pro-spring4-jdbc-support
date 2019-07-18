package com.fellwiin;

import java.util.List;

public interface ContactDAO {

    List<Contact> findAll();

    List<Contact> findByFirstName(String firstName);

    void update(Contact contact);

    void insert(Contact contact);

    void insertWithDetail(Contact contact);

    List<Contact> findAllWithDetail();

    String findFirstNameById(Long id);
}