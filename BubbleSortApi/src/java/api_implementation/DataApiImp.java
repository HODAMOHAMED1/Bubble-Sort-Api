/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api_implementation;

import Pojo.Data;
import Pojo.DataList;
import api_interfaces.DataApiInt;
import dao_implementation.DataDaoImp;
import dao_interfaces.DataDaoInt;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hoda.CO
 */
@Path("/numbers")
public class DataApiImp implements DataApiInt{
    
    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void insertNum(Data number) {
        DataDaoInt revv = new DataDaoImp();
        Boolean stat =revv.insertNum(number);
        if (stat)
        {
        System.out.print("inserted");
        }
        else
        {
         System.out.print("not inserted");
        }
    }
    @GET
    @Path("/retrieve")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public DataList getAllReviews() {
        DataDaoInt revv = new DataDaoImp();
        DataList all =revv.retrieveAll();
        return all;
    }
    
}
