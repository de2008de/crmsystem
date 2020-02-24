package com.vanpanda.crmsystem.builders;

import com.alibaba.fastjson.JSONObject;

public interface Builder {
    public <T> T buildWithParams(Class<T> clazz, JSONObject params);
}
