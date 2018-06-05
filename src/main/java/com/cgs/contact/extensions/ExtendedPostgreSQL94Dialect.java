package com.cgs.contact.extensions;

import org.hibernate.dialect.PostgreSQL94Dialect;

import java.sql.Types;

public class ExtendedPostgreSQL94Dialect extends PostgreSQL94Dialect {

    public ExtendedPostgreSQL94Dialect() {
        this.registerColumnType(Types.JAVA_OBJECT, "jsonb");
    }
}
