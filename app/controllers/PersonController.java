package controllers;

import com.alibaba.fastjson.JSONObject;
import models.Person;
import play.mvc.Controller;

import java.util.List;

public class PersonController extends Controller {

    public static void PersonSave(String name,String personID,String standAddress,String doubleInfoID,double lat,double lon,double height,double lat_view,double lon_view,double height_view,String remark) {
        Person person = new Person(name,personID,standAddress,doubleInfoID,lat,lon,height,lat_view,lon_view,height_view,remark);
        person.save();
        renderText("ok");
    }

    public static void PersonQueryByID(int id) {
        Person person = Person.findById(Long.valueOf(id));
        renderText(person.name);
    }

    public static void PersonQueryAll() {

        List<Person> persons = Person.findAll();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("list",persons);
        renderJSON(json);

    }

    public static void PersonDeleteByID(String id) {
        Person user = Person.findById(id);
        user.delete();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        renderJSON(json);
    }

    public static void DeviceDeleteByID(int id) {
        Person person = Person.findById(Long.valueOf(id));
        person.delete();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        renderJSON(json);
    }

    public static void testHtml(){
       render("test.html");
    }
}
