package com.design_pattern;

public class DBConnection {
    private static DBConnection dbConnection =new DBConnection();

    private DBConnection(){}

    public  void dbConnect(){

    }

    public void dbClose(){

    }
     public  static DBConnection getInstance(){
        return  dbConnection;
     }
}
