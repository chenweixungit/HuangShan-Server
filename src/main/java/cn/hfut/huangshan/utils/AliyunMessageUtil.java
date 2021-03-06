package cn.hfut.huangshan.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 阿里云的短信服务
 * @author pcy
 */
public class AliyunMessageUtil {

    /**
     * 发送短信验证码
     * @param phoneNumber 用户手机号
     * @return 6位验证码
     */
    public static String sendVerificationCode(String phoneNumber){

        String sixNum = String.valueOf((int)((Math.random()*9+1)*100000));

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FiatWgoyLyF5QBwDqzx", "4SLNqJDpkADWMj17pevvn1tfhcoD8x");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "智慧黄山");
        request.putQueryParameter("TemplateCode", "SMS_173474340");
        request.putQueryParameter("TemplateParam", "{code:" + sixNum + "}");
        try {
            //向阿里云发送短信请求
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return sixNum;
    }
}
