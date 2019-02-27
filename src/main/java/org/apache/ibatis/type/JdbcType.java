/**
 * Copyright 2009-2018 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.type;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Clinton Begin
 * <p>
 * 这里包裹了{@link java.sql.Types}的定义的类型
 * 变成了枚举类
 */
public enum JdbcType {
    /*
     * This is added to enable basic support for the
     * ARRAY data type - but a custom type handler is still required
     */
    ARRAY(Types.ARRAY),
    /**
     * bit 类型
     */
    BIT(Types.BIT),
    /**
     * tinyint 类型
     */
    TINYINT(Types.TINYINT),
    /**
     * smallint 类型
     */
    SMALLINT(Types.SMALLINT),
    /**
     * integer 类型
     */
    INTEGER(Types.INTEGER),
    /**
     * bigint 类型
     */
    BIGINT(Types.BIGINT),
    /**
     * float 类型
     */
    FLOAT(Types.FLOAT),
    /**
     * real 类型
     */
    REAL(Types.REAL),
    /**
     * double 类型
     */
    DOUBLE(Types.DOUBLE),
    /**
     * numeric 类型
     */
    NUMERIC(Types.NUMERIC),
    /**
     * decimal 类型
     */
    DECIMAL(Types.DECIMAL),
    /**
     * char 类型
     */
    CHAR(Types.CHAR),
    /**
     * varchar 类型
     */
    VARCHAR(Types.VARCHAR),
    /**
     * logvarchar 类型
     */
    LONGVARCHAR(Types.LONGVARCHAR),
    /**
     * date 类型
     */
    DATE(Types.DATE),
    /**
     * time 类型
     */
    TIME(Types.TIME),
    /**
     * timestamp 类型
     */
    TIMESTAMP(Types.TIMESTAMP),
    /**
     * binary 类型
     */
    BINARY(Types.BINARY),
    /**
     * varbinary 类型
     */
    VARBINARY(Types.VARBINARY),
    /**
     * longvarbinary 类型
     */
    LONGVARBINARY(Types.LONGVARBINARY),
    /**
     * null 类型
     */
    NULL(Types.NULL),
    /**
     * other 类型
     */
    OTHER(Types.OTHER),
    /**
     * blob 类型
     */
    BLOB(Types.BLOB),
    /**
     * clob 类型
     */
    CLOB(Types.CLOB),
    /**
     * boolean 类型
     */
    BOOLEAN(Types.BOOLEAN),
    /**
     * cursor 类型 oracle
     */
    CURSOR(-10), // Oracle
    /**
     * undefined int最大值+1000
     */
    UNDEFINED(Integer.MIN_VALUE + 1000),
    /**
     * nvarchar 类型 JDK6
     */
    NVARCHAR(Types.NVARCHAR), // JDK6
    /**
     * nchar 类型 JDK6
     */
    NCHAR(Types.NCHAR), // JDK6
    /**
     * nclob 类型 JDK6
     */
    NCLOB(Types.NCLOB), // JDK6
    /**
     * struct 类型
     */
    STRUCT(Types.STRUCT),
    /**
     * java_object 类型
     */
    JAVA_OBJECT(Types.JAVA_OBJECT),
    /**
     * distinct 类型
     */
    DISTINCT(Types.DISTINCT),
    /**
     * ref 类型
     */
    REF(Types.REF),
    /**
     * datalink 类型
     */
    DATALINK(Types.DATALINK),
    /**
     * rowid 类型 JDK6
     */
    ROWID(Types.ROWID), // JDK6
    /**
     * longbvarchar 类型 JDK6
     */
    LONGNVARCHAR(Types.LONGNVARCHAR), // JDK6
    /**
     * sqlxml 类型 JDK6
     */
    SQLXML(Types.SQLXML), // JDK6
    /**
     * datetimeoffset 类型 SQL Server 2008
     */
    DATETIMEOFFSET(-155), // SQL Server 2008
    /**
     * time_witg_timezone 类型 JDK4.2 jdk8
     */
    TIME_WITH_TIMEZONE(Types.TIME_WITH_TIMEZONE), // JDBC 4.2 JDK8
    /**
     * timestamo_witg_timezone 类型 JDK4.2 jdk8
     */
    TIMESTAMP_WITH_TIMEZONE(Types.TIMESTAMP_WITH_TIMEZONE); // JDBC 4.2 JDK8

    /**
     * 类型码
     */
    public final int TYPE_CODE;
    private static Map<Integer, JdbcType> codeLookup = new HashMap<>();

    static {
        for (JdbcType type : JdbcType.values()) {
            codeLookup.put(type.TYPE_CODE, type);
        }
    }

    JdbcType(int code) {
        this.TYPE_CODE = code;
    }

    public static JdbcType forCode(int code) {
        return codeLookup.get(code);
    }

}
