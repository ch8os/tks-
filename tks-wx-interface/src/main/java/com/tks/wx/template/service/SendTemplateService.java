package com.tks.wx.template.service;

import com.tks.resource.common.entity.SnUserBloodsuger;

public interface SendTemplateService {
    Boolean sendTemplateMsgs(SnUserBloodsuger subs, String openId);
}
