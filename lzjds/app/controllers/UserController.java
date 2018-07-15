package controllers;

import com.alibaba.fastjson.JSONObject;
import models.Person;
import models.User;
import play.mvc.Controller;

import java.util.List;

public class UserController extends Controller {

    public static void UserSave(String name,String password,String department,String phone) {
        User user = new User(name,password,department,phone);
        user.save();
        renderText("ok");
    }

    public static void UserQueryByID(int id) {
        User user = User.findById(Long.valueOf(id));
        renderText(user.name);
    }

    public static void UserQueryAll() {

        List<User> users = User.findAll();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("list",users);
        renderJSON(json);

    }


    public static void UserDeleteByID(String id) {
        User user = User.findById(id);
        user.delete();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        renderJSON(json);
    }

    public static void testHtml(){
       render("test.html");
    }
}
