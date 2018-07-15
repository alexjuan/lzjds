package controllers;

import com.alibaba.fastjson.JSONObject;
import models.Plan;
import models.Plan_Features;
import play.mvc.Controller;

import java.util.Date;
import java.util.List;

public class PlanController extends Controller {

    public static void PlanSave(String name_plan, String use_plan, String person_plan, String date_plan, String remark) {
        Plan plan = new Plan(name_plan,person_plan,date_plan,remark);
        plan.save();
        renderText(plan.id);
    }

    public static void Plan_FeaturesSave(String name, String planID,String type, String positions) {
        Plan_Features plan_features = new Plan_Features(name,planID,type,positions);
        plan_features.save();
        renderText("ok");
    }

    public static void PlanQueryByID(int id) {
        Plan plan = Plan.findById(Long.valueOf(id));
        renderText(plan.name_plan);
    }

    public static void Plan_FeaturesQueryByID(String id) {
        Plan_Features plan_features = Plan_Features.findById(id);
        renderText(plan_features.name);
    }

    public static void PlanDeleteById(String id) {
        Plan user = Plan.findById(id);
        user.delete();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        renderJSON(json);
    }

    public static void PlanQueryAll() {

        List<Plan> plans = Plan.findAll();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("list",plans);
        renderJSON(json);

    }

    public static void Plan_FeaturesQueryAll() {

        List<Plan_Features> plan_features = Plan_Features.findAll();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("list",plan_features);
        renderJSON(json);

    }

    public static void Plan_FeaturesQueryAllByPlanID(String planID) {
;
        List<Plan_Features> plan_features = Plan_Features.find("planID=?",planID).fetch();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("list",plan_features);
        renderJSON(json);

    }

    public static void PlanDeleteByID(int id) {
        Plan plan = Plan.findById(Long.valueOf(id));
        plan.delete();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        renderJSON(json);
    }

    public static void Plan_FeaturesDeleteByID(int id) {
        Plan_Features plan_features = Plan_Features.findById(Long.valueOf(id));
        plan_features.delete();
        JSONObject json = new JSONObject();
        json.put("status", 200);
        renderJSON(json);
    }

    public static void testHtml(){
       render("test.html");
    }
}
