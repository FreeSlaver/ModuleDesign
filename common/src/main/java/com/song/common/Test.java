package com.song.common;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by 00013708 on 2017/8/15.
 */
public class Test {

    public static void main(String[] args){
        SqlSessionFactory s = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");

        Configuration configuration = s.getConfiguration();
        MappedStatement ms = configuration.getMappedStatement("MyStatementId");


        BoundSql boundSql = ms.getBoundSql(parameters); // pass parameters for the SQL statement
        System.out.println("SQL" + boundSql.getSql());
    }
}
