package controllers;

import com.alibaba.fastjson.JSONObject;
import models.DoubleInfo;
import models.Person;
import play.mvc.Controller;

import java.util.List;

public class DoubleInfoController extends Controller {

    public static void DoubleInfoSave(String name_info,String personID,String standAddress,String remark) {
        DoubleInfo doubleIInfo = new DoubleInfo(name_info,personID,standAddress,remark);
        doubleIInfo.save();
        renderText("ok");
    }

    public static void DoubleIInfoQueryByID(int id) {
        DoubleInfo doubleIInfo = DoubleInfo.findById(Long.valueOf(id));
        renderText(doubleIInfo.name_info);
    }

    public static void DoubleIInfoQueryAll() {

        List<DoubleInfo> doubleInfos = DoubleInfo.findAll();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("list",doubleInfos);
        renderJSON(json);

    }

    public static void DoubleIInfoDeleteByID(int id) {
        DoubleInfo doubleIInfo = DoubleInfo.findById(Long.valueOf(id));
        doubleIInfo.delete();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        renderJSON(json);
    }

    public static void testHtml(){
       render("test.html");
    }
}
