package com.escar.main;

import com.escar.model.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import java.util.EnumSet;

public class HibernateSchemaGeneration {

    public static void main(String[] args) throws Exception {
        StandardServiceRegistryImpl serviceRegistry = (StandardServiceRegistryImpl) new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        MetadataImplementor metadata = (MetadataImplementor) new MetadataSources(serviceRegistry)
                //.addAnnotatedClass("com.carservice")
                //.addPackage(Client.class.getPackage())
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Event.class)
                .addAnnotatedClass(Facility.class)
                .addAnnotatedClass(Price.class)
                .addAnnotatedClass(Service.class)
                .buildMetadata();

        SchemaExport schemaExport = new SchemaExport()
                .setOutputFile("hbm2schema.sql")
                .setOverrideOutputFileContent()
                .setFormat(true);

        schemaExport.create(EnumSet.of(TargetType.SCRIPT), metadata);
        serviceRegistry.destroy();
    }
}
