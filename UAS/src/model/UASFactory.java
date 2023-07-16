/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.UASController;
import dal.DALManager;
import model.dto.Response;

/**
 *
 * @author fawad
 */
public class UASFactory {
    public static Response getResponseInstance() {
        return new Response();
    }
    public static UASController getUASControllerInstance(){
        return new UASController();
    }
    public static DALManager getDALManagerInstance(){
        return new DALManager();
    }
}
