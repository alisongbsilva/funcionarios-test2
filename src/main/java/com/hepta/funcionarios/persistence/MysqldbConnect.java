package com.hepta.funcionarios.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqldbConnect {
    
    public static Connection createMySQLConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection newConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/funcionarios?useTimezone=true&serverTimezone=UTC","root","Alison14");
        return newConnection;
    }

}
