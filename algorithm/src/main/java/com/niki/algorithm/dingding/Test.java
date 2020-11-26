package com.niki.algorithm.dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiUserGetDeptMemberRequest;
import com.dingtalk.api.request.OapiUserListbypageRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserGetDeptMemberResponse;
import com.dingtalk.api.response.OapiUserListbypageResponse;
import com.taobao.api.ApiException;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/17
 */
public class Test {

    public static String getToekn() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest req = new OapiGettokenRequest();
//        req.setCorpid("corpid");
//        req.setCorpsecret("corpsecret");
        req.setAppkey("dingrbzbiesihv1xdasa");
        req.setAppsecret("RjyVJ2bzE0AIWAjs8rCvblds8CUiJ1GQrmcroIOiL5kkPt27WjAsKv_0agBqB6Jj");
        req.setHttpMethod("GET");
        OapiGettokenResponse rsp = client.execute(req, "");
        //{"errcode":0,"access_token":"1ada99df69e93911810aa411ca3ec9fb","errmsg":"ok","expires_in":7200}
        System.out.println(rsp.getBody());
        return null;
    }

    /**
     * @Description :获取部门用户详情
     * @Author : yarm.yang
     * @Date : 2020/11/17 10:05
    */
    public static String getDeparetment() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/listbypage");
        OapiUserListbypageRequest req = new OapiUserListbypageRequest();
        req.setLang("zh_CN");
        req.setDepartmentId(1L);
        req.setOffset(1L);
        req.setSize(1L);
        req.setOrder("entry_asc");
        req.setHttpMethod("GET");
        OapiUserListbypageResponse rsp = client.execute(req, "1ada99df69e93911810aa411ca3ec9fb");
        System.out.println(rsp.getBody());
        return null;
    }

    /**
     * @Description :获取部门用户详情
     * @Author : yarm.yang
     * @Date : 2020/11/17 10:05
    */
    public static String getUserIdList() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/getDeptMember");
        OapiUserGetDeptMemberRequest req = new OapiUserGetDeptMemberRequest();
        req.setDeptId("a");
        req.setHttpMethod("GET");
        OapiUserGetDeptMemberResponse rsp = client.execute(req, "1ada99df69e93911810aa411ca3ec9fb");
        System.out.println(rsp.getBody());
        return null;
    }

    public static void main(String[] args) throws ApiException {
//        Test.getToekn();
        Test.getDeparetment();
    }
}
