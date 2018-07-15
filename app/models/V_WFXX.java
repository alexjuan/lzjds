package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="v_wfxx")
public class V_WFXX extends baseModel {
    @Column
    public String kkbh; //卡口编号
    @Column
    public String kkmc; //卡口名称
    @Column
    public String wd; //纬度
    @Column
    public String Jd; //经度
    @Column
    public String jgsk; //经过时间
    @Column
    public String cdbh; //车道编号
    @Column
    public String hphm; //号牌号码
    @Column
    public String hpys; //号牌颜色[0	白色1	黄色2	蓝色3	黑色4	其它颜色]
    @Column
    public String xsfxdm; //行驶方向代码
    @Column
    public String xsfx; //行驶方向
    @Column
    public String cllx; //车辆类型[ga24.4]
    @Column
    public String csys; //车身颜色[ga24.8]
    @Column
    public String hpzl; //号牌种类[ga24.7]
    @Column
    public String clsd; //车辆速度
    @Column
    public String wfxw; //违法代码[新国标]
    @Column
    public String hptp; //车牌图片
    @Column
    public String qjtp; //过车图片

    public V_WFXX(String kkbh, String kkmc, String wd, String Jd, String jgsk,String cdbh,String hphm,String hpys,String xsfxdm,String xsfx,String cllx,String csys,String hpzl,String clsd,String wfxw,String hptp,String qjtp){

        this.kkbh = kkbh;
        this.kkmc = kkmc;
        this.wd = wd;
        this.Jd = Jd;
        this.jgsk = jgsk;
        this.cdbh = cdbh;
        this.hphm = hphm;
        this.cdbh = cdbh;
        this.hphm = hphm;
        this.xsfxdm = xsfxdm;
        this.xsfx = xsfx;
        this.cllx = cllx;
        this.csys = csys;
        this.hpzl = hpzl;
        this.clsd = clsd;
        this.wfxw = wfxw;
        this.hptp = hptp;
        this.qjtp = qjtp;

    }
    public V_WFXX(){

    }
}
