package services;


import models.Device_HK;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * 获取远程数据库信息
 * Created by kong on 2017/3/9.
 */
public class JJ_JDBCTools {

    //oracle连接信息
    public static final String url = "jdbc:oracle:thin:@192.168.127.21:1521:orcl";
    public static final String name = "oracle.jdbc.OracleDriver";
    public static final String user = "ivms_thr";
    public static final String password = "ivms_thr";

    public static Connection conn = null;
    public static PreparedStatement pst = null;

    public JJ_JDBCTools(String sql) {
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
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

    public static void main(String[] args) {

//        List<MapArea> list = JDBCTools.selectPcs();
//        List<MapArea> list = JDBCTools.selectJwq("城关派出所");
//        List<Device_HK> list = JDBCTools.selectZrqy("城关警务区");
//        for (Device_HK mapArea : list) {
//
//        }
        List<Device_HK> list = JJ_JDBCTools.Device_HKQueryAllRemoteORACLE();

        for( Device_HK device_hk : list){
            System.out.print(device_hk.id);
        }

    }
}
