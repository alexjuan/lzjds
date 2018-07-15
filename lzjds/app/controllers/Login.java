package controllers;

import play.*;
import play.mvc.*;

//import play.data.DynamicForm;
//import play.data.Form;
//import static play.data.Form.form;

public class Login extends Controller{
    public static void login() {
        render();
    }
    public static void checkLogin(){
        //提取数据

//        DynamicForm in   = Form.form().bindFromRequest();
//        String result    = in.get("content");
//        if

        Application.index();


    }

    public static void test(){

            render();

    }


    public static void projectionImage(){

        render();

    }
}
