/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.UASController;
import dal.DALManager;
import model.dto.Response;
import dal.DBReader;
import dal.ObjectAdder;
import dal.ObjectMapper;
import dal.ObjectRemover;
import dal.ObjectModifier;

/**
 *
 * @author fawad
 */
public class UASFactory {
    public static Response getResponseInstance() {
        return new Response();
    }

    public static UASController getUASControllerInstance() {
        return new UASController();
    }

    public static DALManager getDALManagerInstance() {
        return new DALManager();
    }

    public static DBReader getInstanceOfDBReader() {
        return new DBReader();
    }

    public static ObjectAdder getInstanceOfObjectAdder() {
        return new ObjectAdder();
    }

    public static ObjectMapper getInstanceOfObjectMapper() {
        return new ObjectMapper();
    }

    public static ObjectRemover getInstanceOfObjectRemover() {
        return new ObjectRemover();
    }

    public static ObjectModifier getInstanceOfObjectModifier() {
        return new ObjectModifier();
    }
}
