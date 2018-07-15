package models;

import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name="plan")
public class Plan extends baseModel {
    @Column
    public String name_plan; //预案名称
    @Column
    public String person_plan; //创建人员
    @Column
    public String date_plan; //创建时间
    @Column
    public String remark;   //预案备注


    public Plan(String name_plan, String person_plan, String date_plan, String remark){

        this.name_plan = name_plan;
        this.person_plan = person_plan;
        this.date_plan = date_plan;
        this.remark = remark;
    }
    public Plan(){

    }
}
