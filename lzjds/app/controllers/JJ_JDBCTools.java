package controllers;


import com.alibaba.fastjson.JSONObject;
import models.Device_HK;
import play.mvc.Controller;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


/**
 * 获取远程数据库信息
 * Created by kong on 2017/3/9.
 */
public class JJ_JDBCTools extends Controller {

    //oracle连接信息
   public static final String url = "jdbc:oracle:thin:@192.168.127.21:1521:orcl";
    public static final String name = "oracle.jdbc.OracleDriver";
    public static final String user = "ivms_thr";
    public static final String password = "ivms_thr";


    public static final String url1 = "jdbc:mysql://127.0.0.1:3306/zqsw";
    public static final String user1 = "root";
    public static final String password1 = "123";

    public static Connection conn = null;
    public static PreparedStatement pst = null;

    public JJ_JDBCTools(String sql) {
        try {
            //Class.forName(name);//指定连接类型
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url1, user1, password1);//获取连接
            pst = conn.prepareStatement(sql);//准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JJ_JDBCTools() {

    }

    public void close() {
        try {
            conn.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //获取设备信息
    public static List<Device_HK> Device_HKQueryAllRemoteORACLE() {
        String sql = "select pcs from map_area group by pcs";
        JJ_JDBCTools db = new JJ_JDBCTools(sql);
        ResultSet ret = null;
        List<Device_HK> list = new LinkedList<>();
        try {
            ret = db.pst.executeQuery();//执行语句，得到结果集
            while (ret.next()) {
                Device_HK device_hk = new Device_HK();
                list.add(device_hk);
            }//显示数据
            db.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //获取设备信息
    public static void JJ_JDBCQueryAll() {
        String sql = "select * from device_hk";
                //"where name like '%"+sbmc+"%'";

        JJ_JDBCTools db = new JJ_JDBCTools(sql);
        ResultSet ret = null;
        // List<Device_HK> device_hks = Device_HK.findAll();
        JSONObject json = new JSONObject();

        List<Device_HK> list = new LinkedList<>();

        try {
            ret = db.pst.executeQuery();//执行语句，得到结果集
            while (ret.next()) {
                Device_HK device_hk = new Device_HK(ret.getString(3),ret.getString(6),ret.getString(4),ret.getString(2),ret.getString(5));
                list.add(device_hk);
            }//显示数据
            json.put("status", 200);
            json.put("list",list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();//关闭连接
        renderJSON(json);
    }

    //模糊查询设备名称
    public static void JJ_JDBCQueryByID(String sbmc) {
        String sql = "select * from device_hk where name like '%"+sbmc+"%'";
        //"where name like '%"+sbmc+"%'";

        JJ_JDBCTools db = new JJ_JDBCTools(sql);
        ResultSet ret = null;
        // List<Device_HK> device_hks = Device_HK.findAll();
        JSONObject json = new JSONObject();

        List<Device_HK> list = new LinkedList<>();

        try {
            ret = db.pst.executeQuery();//执行语句，得到结果集
            while (ret.next()) {
                Device_HK device_hk = new Device_HK(ret.getString(3),ret.getString(6),ret.getString(4),ret.getString(2),ret.getString(5));
                list.add(device_hk);
            }//显示数据
            json.put("status", 200);
            json.put("list",list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();//关闭连接
        renderJSON(json);
    }


}
