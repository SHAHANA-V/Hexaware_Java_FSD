package com.design_pattern;

public class ProductDao {
    DBConnection dbConnection= DBConnection.getInstance();

    public void getData(){
        System.out.println("In ProductDAO");
        System.out.println("DBConnections is at location: "+ dbConnection);
        dbConnection.dbConnect();
        //logic comes here

        dbConnection.dbClose();
    }
}
