package com.fellwiin;

import com.fellwiin.springJdbcOperations.*;
import com.fellwiin.springJdbcOperations.SelectContactByFirstName;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Indique a Spring que cette classe contient des ops
 * relatif l'accés aux données, @Resources indique
 * également a spring d'effectuer les exceptions SQL adequates
 */
@Repository("contactDAO")
public class JdbcContactDAO implements ContactDAO, InitializingBean {

    //    TODO: take a look at the appache logging doc for setting this config.
    private Log log = LogFactory.getLog(JdbcContactDAO.class);
    private DataSource dataSource;
    private SelectAllContacts selectAllContacts;
    private SelectContactByFirstName selectContactByFirstName;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllContacts = new SelectAllContacts(dataSource);
        this.selectContactByFirstName = new SelectContactByFirstName(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Must set dataSource on ContactDAO");
        }
    }


    @Override
    public List<Contact> findAll() {
        return selectAllContacts.execute();
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("first_name",firstName);

        return selectContactByFirstName.executeByNamedParam(paramMap);
    }


}
