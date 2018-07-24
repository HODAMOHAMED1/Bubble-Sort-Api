/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api_interfaces;

import Pojo.Data;
import Pojo.DataList;
import Pojo.ResponseMessage;
import java.util.ArrayList;

/**
 *
 * @author hoda.CO
 */
public interface DataApiInt {
    public ResponseMessage insertNum(Data number);
    public DataList getAllReviews();
    
}
