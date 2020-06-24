package com.util;

import com.model.Item;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    public static SessionFactory createSessionFactory(){
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Item.class);

            configuration.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
            configuration.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@gromcode-lessons.cfzzaolfgt6x.us-east-2.rds.amazonaws.com:1521:ORCL");
            configuration.setProperty("hibernate.connection.username", "main");
            configuration.setProperty("hibernate.connection.password", "2210Dracon1983");

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
