package com.fellwiin;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class AnnotationJdbcDaoSample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        ContactDAO contactDAO = ctx.getBean("contactDAO", ContactDAO.class);

        List<Contact> contactListFindAll = contactDAO.findAll();
        listContact(contactListFindAll);

        List<Contact> contactListByFirstName = contactDAO.findByFirstName("Scott");
        listContact(contactListByFirstName);
    }

    private static void listContact(List<Contact> contactList) {
        System.out.println("====================================================>");
        for (Contact contact: contactList) {
            System.out.println(contact);

            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
                    System.out.println("--->" + contactTelDetail);
                }
            }
        }
        System.out.println("====================================================>");
    }
}
