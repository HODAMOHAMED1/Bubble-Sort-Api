/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_implementation;

import Pojo.Data;
import Pojo.DataList;
import dao_interfaces.DataDaoInt;
import dbconnectionfactory.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoda.CO
 */
public class DataDaoImp implements DataDaoInt{

    @Override
    public Boolean insertNum(Data number) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO numbers (number)  VALUES(?)");
            insertPs.setInt(1, number.getNumber());
            System.out.println("DB CONNN " + insertPs.executeUpdate());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public DataList retrieveAll() {
         ArrayList<Data> allreviews = new ArrayList<Data>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement retrieveall = connection.prepareStatement("SELECT * FROM numbers");
            ResultSet retSet = retrieveall.executeQuery();
            while (retSet.next()) {
                Data data = new Data();
                data.setId(retSet.getInt("number_id"));
                data.setNumber(retSet.getInt("number"));
                allreviews.add(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataList all = new DataList();
        all.setList_numbers(allreviews);
        return all;
    }
    
}
