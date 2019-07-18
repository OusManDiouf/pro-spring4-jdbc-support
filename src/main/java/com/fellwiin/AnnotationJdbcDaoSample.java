package com.fellwiin;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class AnnotationJdbcDaoSample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        ContactDAO contactDAO = ctx.getBean("contactDAO", ContactDAO.class);


//        Testing the findAll() Method
        List<Contact> contactListFindAll = contactDAO.findAll();
//        listContact(contactListFindAll);

//        Testing the findByFirstName() Method
        List<Contact> contactListByFirstName = contactDAO.findByFirstName("Chris");
//        listContact(contactListByFirstName);


//        Testing the update() Method
        Contact contactToUpdate = new Contact();
        contactToUpdate.setId(1L);
        contactToUpdate.setFirstName("Chris");
        contactToUpdate.setLastName("John");
        contactToUpdate.setBirthDate(new Date(
                (new GregorianCalendar(1997, Calendar.DECEMBER, 12))
                        .getTime().getTime())
        );
//        contactDAO.update(contactToUpdate);
//        listContact(contactListByFirstName);


//        Testing the insert() Method
        Contact contactToInsert = new Contact();
        contactToInsert.setFirstName("Augustus");
        contactToInsert.setLastName("Gibond");
        contactToInsert.setBirthDate(new Date(
                (new GregorianCalendar(2019, Calendar.DECEMBER, 1))
                        .getTime().getTime())
        );
//        contactDAO.insert(contactToInsert);  // one shot !!
//        listContact(contactDAO.findAll());

//        Testing the insertWithDetail() Method
        Contact contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date(
                (new GregorianCalendar(1964, Calendar.NOVEMBER, 1))
                        .getTime().getTime())
        );

        List<ContactTelDetail> contactTelDetails = new ArrayList<>();
        ContactTelDetail contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Home");
        contactTelDetail.setTelNumber("11111111");
        contactTelDetails.add(contactTelDetail);
        contactTelDetail = new ContactTelDetail();
        contactTelDetail.setTelType("Mobile");
        contactTelDetail.setTelNumber("22222222");
        contactTelDetails.add(contactTelDetail);
        contact.setContactTelDetails(contactTelDetails);

//        contactDAO.insertWithDetail(contact); // one shot !

//        listContact(contactDAO.findAllWithDetail());

//        Testing the Stored Function in MySQL
        System.out.println("---> "+ contactDAO.findFirstNameById(6L));

    }

    private static void listContact(List<Contact> contactList) {
        System.out.println("====================================================>");
        for (Contact contact : contactList) {
            System.out.println(contact);

            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println("--->" + contactTelDetail);
                }
            }
        }
        System.out.println("====================================================>");
    }
}
