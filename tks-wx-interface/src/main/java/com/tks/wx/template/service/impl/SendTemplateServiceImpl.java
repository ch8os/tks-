package com.tks.wx.template.service.impl;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tks.resource.common.entity.SnUserBloodsuger;
import com.tks.wx.common.entity.Template;
import com.tks.wx.common.entity.TemplateParam;
import com.tks.wx.common.utils.WxAPiUtils;
import com.tks.wx.common.utils.WxUtils;
import com.tks.wx.template.service.SendTemplateService;

import static com.tks.wx.common.utils.WxAPiUtils.sendTemplateMsg;


@Service
public class SendTemplateServiceImpl implements SendTemplateService {
    @Override
    public Boolean sendTemplateMsgs(SnUserBloodsuger subs, String openId) {
        Template tem=new Template();
        tem.setTemplateId(WxUtils.TemplateId);
        tem.setTopColor("#00DD00");
        tem.setToUser(openId);
        tem.setUrl("");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String formatTestTime = sdf.format(subs.getTesttime());
        subs.setFoodstatus(subs.getFoodstatus().equals("0")?"空腹":"餐后");
        String orderResult=null;
        BigDecimal result1 = subs.getResult();
        if(result1.compareTo(BigDecimal.valueOf(3.9))==-1){
            orderResult="血糖偏低";
        }else if (result1.compareTo(BigDecimal.valueOf(6.1))==1){
            orderResult="血糖偏高";
        }else {
            orderResult="正常";
        }
        List<TemplateParam> paras=new ArrayList<TemplateParam>();
        paras.add(new TemplateParam("first","您在"+formatTestTime+"测量了"+subs.getFoodstatus()+"血糖 ：","#FF3333"));
        paras.add(new TemplateParam("keyword1", subs.getResult()+"mol/L","#0044BB"));
        paras.add(new TemplateParam("keyword2",orderResult,"#0044BB"));
        paras.add(new TemplateParam("remark","您的血糖数据正常！继续保持！","#AAAAAA"));

        tem.setTemplateParamList(paras);
        String accessToken = WxAPiUtils.getAccessToken();
        boolean result=sendTemplateMsg(accessToken,tem);
        return result;
    }
}
