package com.escar.main;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.EnumSet;

public class HibernateSchemaGeneration {

    public static void main(String[] args) throws Exception {
        StandardServiceRegistryImpl serviceRegistry = (StandardServiceRegistryImpl) new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        //add package does not work(
        for (Class<?> entityClass : new Reflections("com.escar.model").getTypesAnnotatedWith(Entity.class)) {
            metadataSources.addAnnotatedClass(entityClass);
        }

        SchemaExport schemaExport = new SchemaExport()
                .setOutputFile("src/main/resources/hbm2schema.sql")
                .setOverrideOutputFileContent()
                .setFormat(true);

        schemaExport.create(EnumSet.of(TargetType.SCRIPT), metadataSources.buildMetadata());
        serviceRegistry.destroy();
    }
}
