package com.edu.controller;

/*
 *@PackageName:com.edu.controller
 *@ClassName:RegisterController
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-16 22:10
 */

import com.edu.dao.InvoiceDAO;
import com.edu.entity.*;
import com.edu.service.InvoiceService;
import com.edu.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理挂号相关的业务
 */
@RestController
@CrossOrigin
@RequestMapping("register")
@Slf4j
public class RegisterController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private RegisterService registerService;

    @PostMapping("/init")
    public Map<String,Object> register(){
        Map<String, Object> map = new HashMap<>();
        //获取发票号
        int invoiceNum = invoiceService.findMaxInvoiceNum()+1;
        map.put("invoiceNum",invoiceNum);
        //获取病历号
        int caseNumber =registerService.findMaxCaseNum()+1;
        map.put("caseNumber",caseNumber);
        //获取科室分类数组
        List<Constantitem> depTypeList = registerService.findConstantitemsByConstantTypeID(1);
        map.put("depTypeList",depTypeList);
        //获取挂号级别数组
        List<Registlevel>  registlevelList = registerService.findAllRegistlevel();
        map.put("registlevelList",registlevelList);
        //获取结算类型数组
        List<Settlecategory> settlecategoryList =registerService.findAllSettlecategory();
        map.put("settlecategoryList",settlecategoryList);
        return map;
    }

    @GetMapping("/changeDepType")
    public List<Department> changeDepType(Integer id){
        return registerService.findDepartmentsByTypeId(id);
    }
    @GetMapping("/changeDoc")
    public List<User> changeDoc(Integer levID,Integer deptID){
        return registerService.findAllDocByDeptID(levID,deptID);
    }
    @GetMapping("/checkNum")
    public Register checkNum(Integer caseNumber){
        if(!registerService.findRegistersByCaseNumber(caseNumber).isEmpty()){
            return registerService.findRegistersByCaseNumber(caseNumber).get(0);
        }else {
            return null;
        }
    }
    @GetMapping("/quota")
    public int quota(Integer state,Integer id){
        return registerService.countAllByVisitStateAndUserID_Id(state,id);
    }
    /**
     * 存储挂号信息
     */

    @PostMapping("/save")
    public Map<String,Object> register(@RequestBody Register register,Integer invoice){
        //存储在register表中
        log.info("挂号信息：[{}]",register.toString());
        Map<String, Object> map = new HashMap<>();
        register.setRegistTime(new Date());
        registerService.save(register);
        //发票表记录
        Invoice invoiceTemp = new Invoice();
        invoiceTemp.setInvoiceNum(invoice);
        invoiceTemp.setMoney(register.getRegistLeID().getRegistFee());
        invoiceTemp.setState(1);
        invoiceTemp.setCreationTime(register.getRegistTime());
        invoiceTemp.setUserID(register.getRegisterID());
        invoiceTemp.setRegistID(register);
        Constantitem constantitem = new Constantitem();
        constantitem.setId(51);
        invoiceTemp.setFeeType(constantitem);
        invoiceTemp.setDailyState(0);
        invoiceService.saveInvoice(invoiceTemp);
        map.put("status",true);
        map.put("msg","提示：挂号成功");
        return map;
    }
}
