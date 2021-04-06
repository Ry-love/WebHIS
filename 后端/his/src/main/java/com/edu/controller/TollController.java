package com.edu.controller;

/*
 *@PackageName:com.edu.controller
 *@ClassName:TollController
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-19 13:20
 */

import com.edu.dao.InvoiceDAO;
import com.edu.entity.*;
import com.edu.service.InvoiceService;
import com.edu.service.PrescribeService;
import com.edu.service.RegisterService;
import com.edu.service.TollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理收费相关的业务
 */
@RestController
@CrossOrigin
@RequestMapping("toll")
@Slf4j
public class TollController {
    @Autowired
    private TollService tollService;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private PrescribeService prescribeService;
    @GetMapping("findAll")
    public Map<String,Object> findAll(Integer caseNumber){
        HashMap<String,Object> map = new HashMap<>();
        List<Prescriptiondetailed> prescriptiondetaileds = tollService.findPrescriptiondetailedsByPrescriptionID_RegistID_CaseNumber(caseNumber);
        map.put("prescriptiondetaileds",prescriptiondetaileds);
        return map;
    }

    @PostMapping("/init")
    public Map<String,Object> init(){
        HashMap<String,Object> map = new HashMap<>();
        //获取最大发票号
        Integer invoiceNum = tollService.findMaxInvoiceNum();
        map.put("invoiceNum",invoiceNum+1);
        //初始化支付方式数组
        List<Constantitem> freeType= registerService.findConstantitemsByConstantTypeID(5);
        map.put("freeType",freeType);
        return map;
    }
    @PostMapping("/save1")
    public Integer save1(@RequestBody Invoice invoice){
        invoice.setCreationTime(new Date());
        //存储发票信息到发票表
        Invoice temp = invoiceService.saveInvoice(invoice);
        return temp.getId();
    }

    @PostMapping("/save2")
    public Map<String,Object> save2(@RequestBody List<Patientcosts> costsList){
        for(Patientcosts temp:costsList){
            temp.setPayTime(new Date());
        }
        tollService.saveCosts(costsList);
        Map<String, Object> map = new HashMap<>();
        map.put("status",true);
        map.put("msg","提示：收费成功");
        return map;
    }
    @PostMapping("/save3")
    public Map<String,Object> save3(@RequestBody List<Prescriptiondetailed> drugsList){
        prescribeService.savedetails(drugsList);
        Map<String, Object> map = new HashMap<>();
        map.put("status",true);
        map.put("msg","提示：更新成功");
        return map;
    }

}
