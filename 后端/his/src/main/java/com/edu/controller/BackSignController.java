package com.edu.controller;

import com.edu.entity.Constantitem;
import com.edu.entity.Invoice;
import com.edu.entity.Register;
import com.edu.service.BackSignService;
import com.edu.service.InvoiceService;
import com.edu.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@PackageName:com.edu.controller
 *@ClassName:BackSignController
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-17 17:44
 */
@RestController
@CrossOrigin
@RequestMapping("backSign")
@Slf4j
/**
 * 处理退号相关业务
 */
public class BackSignController {
    @Autowired
    private BackSignService backSignService;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("findByPage")
    public Map<String,Object> findByPage(Integer page,Integer rows,Integer caseNumber){
        page = page ==null?1:page;
        rows = rows ==null?3:rows;
        HashMap<String,Object> map = new HashMap<>();
        //分页处理
        List<Register> registers = backSignService.findByPage(page,rows,caseNumber);
        //计算总页数
        Integer totals = backSignService.findTotals(caseNumber);
        Integer totalPage = totals%rows==0?totals/rows:totals/rows+1;
        map.put("registers",registers);
        map.put("totals",totals);
        map.put("totalPage",totalPage);
        map.put("page",page);
        return map;
    }

    @PostMapping("/save")
    public Map<String,Object> backSign(@RequestBody Register register){
        //更新register表中
        log.info("挂号信息：[{}]",register.toString());
        Map<String, Object> map = new HashMap<>();
        registerService.save(register);
        //发票表记录
        Invoice invoiceTemp = new Invoice();
        int invoice= backSignService.findMaxCaseNum();
        invoiceTemp.setInvoiceNum(invoice+1);
        invoiceTemp.setMoney(0-register.getRegistLeID().getRegistFee());
        invoiceTemp.setState(7);
        invoiceTemp.setCreationTime(new Date());
        invoiceTemp.setUserID(register.getRegisterID());
        invoiceTemp.setRegistID(register);
        Constantitem constantitem = new Constantitem();
        constantitem.setId(51);
        invoiceTemp.setFeeType(constantitem);
        invoiceTemp.setDailyState(0);
        //更新原始放票的冲红发票号
        Invoice temp = invoiceService.findInvoiceByRegistID_Id(register.getId());
        temp.setBack(invoice+1);
        invoiceService.saveInvoice(temp);
        invoiceService.saveInvoice(invoiceTemp);
        map.put("status",true);
        map.put("msg","提示：退号成功！退费金额是"+(0-invoiceTemp.getMoney()+"元"));
        return map;
    }
}
