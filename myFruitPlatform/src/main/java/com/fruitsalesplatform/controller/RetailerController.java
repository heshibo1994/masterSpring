package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.entity.Retailer;
import com.fruitsalesplatform.service.RetailerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RetailerController extends BaseController {
    @Resource
    RetailerService retailerService;

    @RequestMapping("/retailer/list.action")
    public String list(Model model, Retailer retailer, String startTime,String endTime){
        Map<String,Object> map = this.retailerToMap(retailer);
        if(startTime!=null && startTime.equals("")){
            map.put("startTime",startTime);
        }
        if(endTime!=null && endTime.equals("")){
            map.put("endTime",endTime);
        }
        List<Retailer> retailerList = retailerService.find(map);
        model.addAttribute("list",retailerList);
        return "/retailer/retailerHome.jsp";   //转向首页
    }

    private Map<String,Object> retailerToMap(Retailer retailer){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name",checkStringIsEmpty(retailer.getName()));
        map.put("telephone",checkStringIsEmpty(retailer.getTelephone()));
        map.put("address",checkStringIsEmpty(retailer.getAddress()));
        map.put("createTime",checkStringIsEmpty(retailer.getCreateTime()));
        map.put("status",retailer.getStatus()==-1?null:retailer.getStatus());
        map.put("startPage",retailer.getStartPage());
        map.put("pageSize",retailer.getPageSize());
        return map;
    }

    private String checkStringIsEmpty(String param){
        return param==null?null:(param.equals("")?null:"%"+param+"%");
    }
}
