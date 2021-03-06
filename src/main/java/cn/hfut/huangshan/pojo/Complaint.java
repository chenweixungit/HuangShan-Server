package cn.hfut.huangshan.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户投诉
 * @author pcy
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complaint implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private long id;
    private String complaintTime;//投诉时间
    private String complaintObject;//投诉对象
    private String spot;//事发地
    private String complaintType;//投诉类型，写死：景区、住宿、餐饮、旅行社、导游
    private String complaintReason;//投诉原因
    private String evidencePhoto;//照片凭据
    private String complainantName;//投诉人
    private String complainantPhone;//投诉人联系电话
    private String isHandle;//是否处理
    private String handleAdminName;//处理的管理员名
    private String handleTime;//处理时间
    private String handleMessage;//反馈消息

}
