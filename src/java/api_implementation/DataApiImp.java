/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api_implementation;

import Pojo.Data;
import Pojo.DataList;
import Pojo.ResponseMessage;
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
    public ResponseMessage insertNum(Data number) {
        ResponseMessage response = new ResponseMessage();
        DataDaoInt revv = new DataDaoImp();
        Boolean stat =revv.insertNum(number);
        if (stat)
        {
        System.out.print("inserted");
           response.setMessage("review added");
           response.setStatus(true);
           response.setError("200");
           return response;
        }
        else
        {
          response.setMessage("review not added");
           response.setStatus(false);
           response.setError("404");
           return response;
        }
    }
    @GET
    @Path("/retrieve")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public DataList getAllReviews() {
        DataDaoInt revv = new DataDaoImp();
        DataList all =revv.retrieveAll();
        ArrayList<Data> data = all.getList_numbers();
        int length = data.size(); 
        for (int i=0 ; i<length-1;i++)
        {
            for (int j=0;j<length-i-1;j++)
          {
              if ((data.get(j+1).getNumber()) < (data.get(j).getNumber()))
            {
              Data temp = data.get(j);
                data.set(j, data.get(j+1));
                data.set(j+1, temp);
              System.out.print(data);
            }
          
          }
        }
        DataList sorted =new DataList();
        sorted.setList_numbers(data);
        return sorted;
    }
    
}
