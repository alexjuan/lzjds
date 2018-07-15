package controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import models.Device;
import models.Device_HK;
import play.mvc.Controller;

import java.util.*;

public class ArtemisTest extends Controller {

    private static String ARTEMIS_PATH;
    static {
        ARTEMIS_PATH = "/artemis";
    }
    public static void ArtemisAll(String start,String size){

        if (ARTEMIS_PATH.equals("/artemis")) {

            JSONObject json = new JSONObject();
            /**
             * url组装说明：
             *         能力开放标签页里提供的api地址一般如：
             *         /api/common/v1/userAuthRestService/getUserByUsername，
             *         url必须由ARTEMIS_PATH + api地址组成。
             *         所以url最后应如下格式：
             *         /artemis/api/common/v1/userAuthRestService/getUserByUsername。
             */
            String url = ARTEMIS_PATH + "/api/common/v1/remoteCameraInfoRestService/findCameraInfoPage"; //加法服务的请求路径
            /**
             * host说明：
             *         如果是公网对接，ArtemisConfig.host = "open8200.hikvision.com"
             *         如果是现场对接，ArtemisConfig.host = "{现场ip}:9999"
             */
            System.err.print(url);
            ArtemisConfig.host ="172.21.224.1:9999"; //artemis网关服务器ip端口
            ArtemisConfig.appKey ="26208115";     //秘钥appkey
            ArtemisConfig.appSecret ="Q9GM11oUW74AkOcc0Gq9";//秘钥appSecret
            Map<String,String> paramMap = new HashMap<String,String>();//post请求Form表单参数
            paramMap.put("start", start);
            paramMap.put("size", size);
            Map<String, String> path = new HashMap<String, String>(2){
                {
                    put("https://", url);
                }
            };
            String result = ArtemisHttpUtil.doPostFormArtemis(path, null,paramMap,null,null);
            //System.err.print(result.length());
            JSONObject jsonobject = JSON.parseObject(result);
            System.out.print("原始"+jsonobject+"\n");
            //JSONObject jsonobject = (JSONObject) JSONObject.parseObject(result).getJSONObject("data").getJSONObject("appCode");
//            Object obj = jsonobject.get("data");
            //Object appCode =jsonobject.get("data");
           // JSONArray jsonArray = jsonobject.getJSONArray("data");
            JSONArray jsonarray = jsonobject.getJSONArray("data");
            System.out.println("长度"+jsonarray.size()+"\n");
            List<Device_HK> list = new ArrayList<>();
            for (int i = 0;i<jsonarray.size();i++){
                JSONObject AO = jsonarray.getJSONObject(i);

                System.out.print("名称"+AO.getJSONObject("extraField").get("nameStr"));
                System.out.print("设备"+AO.getString("indexCode")+",");
                System.out.print("类型"+AO.getString("cameraType")+",");
                //接收数据放进实体类里面
                String name = AO.getJSONObject("extraField").get("nameStr")+"";
                String cameraId = AO.getString("indexCode");
                String type = AO.getString("cameraType");
                Device_HK hk = new Device_HK(name,cameraId,type);
                list.add(hk);
            }
            json.put("list",list);
            renderJSON(json);
        }
    }


    //获取时间戳
    public static void ArtemisDatetime(){

        if (ARTEMIS_PATH.equals("/artemis")) {

            JSONObject json = new JSONObject();
            String url =ARTEMIS_PATH + "/api/artemis/v1/agreementService/securityParam/appKey/26208115"; //加法服务的请求路径
            ArtemisConfig.host ="172.21.224.1:9999"; //artemis网关服务器ip端口
            ArtemisConfig.appKey ="26208115";     //秘钥appkey
            ArtemisConfig.appSecret ="Q9GM11oUW74AkOcc0Gq9";//秘钥appSecret
            Map<String, String> path = new HashMap<String, String>(2){
                {
                    put("https://", url);
                }
            };
            String result = ArtemisHttpUtil.doGetArtemis(path, null,null,null);
            JSONObject jsonobject = JSON.parseObject(result);
            Object time = jsonobject.get("data");
            //List<Device_HK> list = new ArrayList<>();
            //JSONObject jsonobject = JSON.parseObject(result);
            //json.put("timeSecret",time.gets);
            json.put("time",time);
            renderJSON(json);
        }
    }


    //根据监控点获取监控信息
    public static void ArtemisJkd(String indexcode){
        if (ARTEMIS_PATH.equals("/artemis")) {

            JSONObject json = new JSONObject();
            String url =ARTEMIS_PATH + "/api/common/v1/remoteCameraInfoRestService/findCameraInfoByIndexCode"; //加法服务的请求路径
            ArtemisConfig.host ="172.21.224.1:9999"; //artemis网关服务器ip端口
            ArtemisConfig.appKey ="26208115";     //秘钥appkey
            ArtemisConfig.appSecret ="Q9GM11oUW74AkOcc0Gq9";//秘钥appSecret
            Map<String,String> paramMap = new HashMap<String,String>();//post请求Form表单参数
            paramMap.put("start", indexcode);
            Map<String, String> path = new HashMap<String, String>(2){
                {
                    put("https://", url);
                }
            };
            String result = ArtemisHttpUtil.doGetArtemis(path, paramMap,null,null);
        }
    }

}
