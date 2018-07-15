package controllers;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

import models.Device;

import play.mvc.Controller;

public class DeviceController extends Controller {


    public static void DeviceSave(String name,String cameraType,String indexCode,double xRoll,double yRoll,double zRoll,double scale,double lat,double lon,double height,double heading,double pitch,double roll,double lat_view,double lon_view,double height_view,String remark) {
        Device device = new Device(name,cameraType,indexCode,xRoll,yRoll,zRoll,scale,lat,lon,height,heading,pitch,roll,lat_view,lon_view,height_view,remark);
        device.save();
        renderText("ok");
    }

    public static void DeviceQueryByID(int id) {
        Device device = Device.findById(Long.valueOf(id));
        renderText(device.name);
    }

    public static void DeviceQueryAll() {

        List<Device> devices = Device.findAll();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("list",devices);
        renderJSON(json);

    }

    public static  void DeviceSbmc(String sbmc){
        System.out.print(sbmc);
        JSONObject json = new JSONObject();
            List<Device> devices =Device.find("name like ?","%"+sbmc+"%").fetch();
            json.put("status", 200);
            json.put("list",devices);
        renderJSON(json);
    }

    public static void DeviceDeleteByID(String id) {
        Device device = Device.findById(id);

        device.delete();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        renderJSON(json);
    }
//
//    public static void TestUpdate(String id, String data) {
//        Test test = Test.findById(id);
//        test.test = data;
//        test.save();
//        JSONObject json = new JSONObject();
//        json.put("status", 200);
//        renderJSON(json);
//    }

    public static void testHtml(){
       render("test.html");
    }
}
