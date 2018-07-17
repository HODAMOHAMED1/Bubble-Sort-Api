/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_interfaces;

import Pojo.Data;
import Pojo.DataList;
import java.util.ArrayList;

/**
 *
 * @author hoda.CO
 */
public interface DataDaoInt {
    public Boolean insertNum(Data num);
    public DataList retrieveAll();
    
}
