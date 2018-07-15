package controllers;

import com.alibaba.fastjson.JSONObject;
import models.Device_HK;
import models.Device_HK1;
import play.mvc.Controller;

import java.util.List;

public class Device_HKController1 extends Controller {

    public static void Device_HKSave(String name,String type,String port,String ip,String serialnumber) {
        Device_HK1 device_hk = new Device_HK1(name,type,port,ip,serialnumber);
        device_hk.save();
        renderText("ok");
    }

    public static void Device_HKQueryByID(int id) {
        Device_HK1 device_hk = Device_HK1.findById(Long.valueOf(id));
        renderText(device_hk.name);
    }
    //从本地读取设备信息，主要是监控信息
    public static void Device_HKQueryAll() {

        List<Device_HK1> device_hks = Device_HK1.findAll();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("list",device_hks);
        renderJSON(json);

    }

    public static void DeviceSbmc(String sbmc){
        JSONObject json = new JSONObject();

        List<Device_HK1> device_hks =Device_HK1.find("name like ?","%"+sbmc+"%").fetch();
        json.put("status", 200);
        json.put("list",device_hks);

        renderJSON(json);
    }

    //从海康读取配置信息，主要是卡口信息
    public static void Device_HKQueryAllRemoteORACLE() {

//        jdbc.type=oracle
//        jdbc.driver=oracle.jdbc.driver.OracleDriver
//#jdbc.url=jdbc:oracle:thin:@56.21.200.35:1521:orcl
//        jdbc.url=jdbc:oracle:thin:@127.0.0.1:1521:orcl
//        jdbc.username=jeesite
//        jdbc.password=126726
//

//           String url = "jdbc:jtds:sqlserver://127.0.0.1:1433/ZQSS1.0";
//           String name = "net.sourceforge.jtds.jdbc.Driver";
//           String user = "sa";
//           String password = "987";


    }

    public static void Device_HKDeleteByID(int id) {
        Device_HK1 device_hk = Device_HK1.findById(Long.valueOf(id));
        device_hk.delete();
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
