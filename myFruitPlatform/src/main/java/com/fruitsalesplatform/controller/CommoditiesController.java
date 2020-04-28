package com.fruitsalesplatform.controller;

import com.alibaba.fastjson.JSONObject;
import com.fruitsalesplatform.entity.Commodities;
import com.fruitsalesplatform.service.CommoditiesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CommoditiesController extends BaseController {

    @Resource
    CommoditiesService commoditiesService;

    @RequestMapping("/commodities/list.action")
    public String list(Model model, Commodities commodities, String startTime, String endTime,
    @RequestParam(defaultValue ="0.0") double startPrice,    @RequestParam(defaultValue ="0.0") double endPrice){
        Map<String,Object> map = this.commditiesToMap(commodities);
        List<Commodities> commoditiesList = commoditiesService.find(map);
        if(startTime!=null&&!startTime.equals("")){
            map.put("startTime", startTime);
        }
        if(endTime!=null&&!endTime.equals("")){
            map.put("endTime", endTime);
        }
        if (startPrice>0.0){
            map.put("startPrice", startPrice);
        }
        if (endPrice>0.0){
            map.put("endPrice", endPrice);
        }
        model.addAttribute("list",commoditiesList);
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        model.addAttribute("startPrice",startPrice);
        model.addAttribute("endPrice",endPrice);
        model.addAttribute("commodities",commodities);
        model.addAttribute("currentPage",commodities.getCurrentPage());
        model.addAttribute("startPages",commodities.getStartPage());
        // 数据总和
        int countNumber = commoditiesService.count(map);
        model.addAttribute("countNumber",countNumber);
        // 每页数据条数
        int pageSize = commodities.getPageSize();
        model.addAttribute("pageSize",pageSize);
        // 总的页数
        int sumPageNumber = countNumber%pageSize==0?(countNumber/pageSize):(countNumber/pageSize+1);
        model.addAttribute("sumPageNumber",sumPageNumber);
        return "/commodities/commoditiesHome.jsp";
    }

    // 查询
    @RequestMapping("/commodities/editCommodities.action")
    public @ResponseBody Commodities editCommodities(@RequestBody String json){
        String id = JSONObject.parseObject(json).getString("id");
        return commoditiesService.get(id);
    }

    // 修改
    @RequestMapping("/commodities/edit.action")
    public String edit(Model model,Commodities commodities){
        commoditiesService.update(commodities);
        Commodities queryCommodities = new Commodities();
        queryCommodities.setStartPage(commodities.getStartPage());
        queryCommodities.setCurrentPage(commodities.getCurrentPage());
        queryCommodities.setPageSize(commodities.getPageSize());
        return list(model,queryCommodities,null,null,0.0,0.0);
    }

    @RequestMapping("/commodities/add.action")
    public String add(Model model,Commodities commodities){
        commodities.setFruitId(UUID.randomUUID().toString());
        commodities.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        commoditiesService.insert(commodities);
        return list(model,commodities,null,null,0.0,0.0);


    }

    private Map<String, Object> commditiesToMap(Commodities commodities) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", checkStringIsEmpty(commodities.getName()));
        map.put("locality", checkStringIsEmpty(commodities.getLocality()));
        map.put("createTime", checkStringIsEmpty(commodities.getCreateTime()));
        map.put("startPage", commodities.getStartPage());
        map.put("pageSize", commodities.getPageSize());
        return map;
    }

    private String checkStringIsEmpty(String param) {
        return param==null?null:(param==""?null:"%"+param+"%");
    }
}
