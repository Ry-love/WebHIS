package com.edu.controller;
import com.edu.entity.*;
import com.edu.service.DiseaseService;
import com.edu.service.PrescribeService;
import com.edu.service.RegisterService;
import com.edu.service.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@PackageName:com.edu.controller
 *@ClassName:VisitController
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-17 22:56
 */
@RestController
@CrossOrigin
@RequestMapping("visit")
@Slf4j
public class VisitController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private VisitService visitService;
    @Autowired
    private DiseaseService diseaseService;
    @PostMapping("/init")
    public Map<String,Object> register(Integer docID){
        Map<String, Object> map = new HashMap<>();
        List<Register> registerList = registerService.findRegistersByUserID_Id(docID);
        map.put("registerList",registerList);
        return map;
    }

    @PostMapping("/check")
    public Map<String,Object> check(Integer docID,String checkName){
        Map<String, Object> map = new HashMap<>();
        List<Register> registerList = registerService.findRegistersByUserID_IdAndRealName(docID,checkName);
        map.put("registerList",registerList);
        return map;
    }
    @PostMapping("/checkDisease")
    public Map<String,Object> checkDisease(String checkName){
        Map<String, Object> map = new HashMap<>();
        List<Disease> diseases = diseaseService.findDiseasesByDiseaseName(checkName);
        map.put("diseases",diseases);
        return map;
    }

    @GetMapping("/findAllDisease")
    public Map<String,Object> findAllDisease(Integer page,Integer rows){
        page = page ==null?1:page;
        rows = rows ==null?5:rows;
        HashMap<String,Object> map = new HashMap<>();
        //分页处理
        List<Disease> diseases = visitService.findByPage(page,rows);
        //计算总页数
        Long totals = visitService.findTotals();
        Long totalPage = totals%rows==0?totals/rows:totals/rows+1;
        map.put("diseases",diseases);
        map.put("totals",totals);
        map.put("totalPage",totalPage);
        map.put("page",page);
        return map;
    }

    @GetMapping("/findRecord")
    public Medicaldisease findRecord(Integer registID){
        return visitService.findByRegistId(registID);
    }

    @PostMapping("/save")
    public Map<String,Object> save(@RequestBody Medicaldisease medicalDisease){
       //存储在病例首页表
        Medicalrecord medicalrecord = medicalDisease.getMedicalID();
        visitService.saveMedicalRecord(medicalrecord);
        //存储在患者诊断表
        visitService.saveMedicalDisease(medicalDisease);
        //更改挂号单的用户状态
        Register register = medicalDisease.getRegistID();
        register.setVisitState(2);
        registerService.save(register);
        HashMap<String,Object> map = new HashMap<>();
        map.put("status",true);
        map.put("msg","提示：病例存储成功");
        return map;
    }
}
