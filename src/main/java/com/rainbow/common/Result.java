package com.rainbow.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfinal.plugin.activerecord.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rainbow on 2016/7/28.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class Result {
    public static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static String exec() {
        return exec(true);
    }

    public static String exec(boolean success) {
        return exec(success, null, null, null, null, null);
    }

    public static String exec(Exception e) {
        if (e.getCause() == null) {
            return exec(false, e.getMessage(), null, null, null, null);
        } else {
            return exec(false, e.getCause().getMessage(), null, null, null, null);
        }
    }
    public static String exec(String message) {
        return exec(false, message, null, null, null, null);
    }

    public static String exec(boolean success, String message) {
        return exec(success, message, null, null, null, null);
    }

    public static String exec(List list) {
        return exec(true, null, null, list, null, null);
    }

    public static String exec(Page<? extends SimpleEntity> page) {
        return exec(true, null, null, null, page, null);
    }

    public static String exec(SimpleEntity entity) {
        return exec(true, null, entity, null, null, null);
    }

    public static String exec_backbone(SimpleEntity entity) {
        return gson.toJson(entity);
    }

    public static String exec_backbone(List<? extends SimpleEntity> list) {
        return gson.toJson(list);
    }

    public static String exec(Map map) {
        return exec(true, null, null, null, null, map);
    }

    public static String exec(boolean success, String message, SimpleEntity entity, List list, Page<? extends SimpleEntity> page, Map map) {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("success", success);
        res.put("message", message);
        if (entity != null) {
            String name = entity.getClass().getSimpleName();
            name = name.substring(0, 1).toLowerCase() + name.substring(1);
            res.put(name, entity);
        }
        if (list != null) {
            res.put("list", list);
        }
        if (page != null) {
            res.put("list", page.getList());
            res.put("pageNumber", page.getPageNumber());
            res.put("pageSize", page.getPageSize());
            res.put("totalPage", page.getTotalPage());
            res.put("totalRow", page.getTotalRow());

        }
        if (map != null) {
            res.put("data", map);
        }
        return gson.toJson(res);
    }
}
