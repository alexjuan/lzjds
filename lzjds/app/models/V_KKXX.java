package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="v_kkxx")
public class V_KKXX extends baseModel {
    @Column
    public String KKDM; //卡口代码
    @Column
    public String KKMC; //卡口名称
    @Column
    public String wd; //纬度
    @Column
    public String Jd;   //经度

    public V_KKXX(String KKDM, String KKMC, String wd, String Jd){

        this.KKDM = KKDM;
        this.KKMC = KKMC;
        this.wd = wd;
        this.Jd = Jd;
    }
    public V_KKXX(){

    }
}
