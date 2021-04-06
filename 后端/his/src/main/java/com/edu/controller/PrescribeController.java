package com.edu.controller;

import com.edu.entity.*;
import com.edu.service.PrescribeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@PackageName:com.edu.controller
 *@ClassName:PrescribeController
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-18 17:00
 */
@RestController
@CrossOrigin
@RequestMapping("prescribe")
@Slf4j
public class PrescribeController {
    @Autowired
    private PrescribeService prescribeService;
    @PostMapping("/init")
    public Map<String,Object> findAllTemplates(){
        Map<String, Object> map = new HashMap<>();
        List<Drugstemplate> drugstemplates = prescribeService.findTemplatesAll();
        map.put("drugstemplates",drugstemplates);
        return map;
    }

    @PostMapping("/check")
    public Map<String,Object> check(String checkName){
        Map<String, Object> map = new HashMap<>();
        List<Drugstemplate> drugstemplates = prescribeService.findDrugstemplatesByName(checkName);
        map.put("drugstemplates",drugstemplates);
        return map;
    }

    @PostMapping("/saveCase")
    public Map<String,Object> saveCase(@RequestBody Prescription prescription){
        Map<String, Object> map = new HashMap<>();
        prescription.setPrescriptionTime(new Date());
        //存储处方到患者成药处方表
        prescribeService.save(prescription);
        map.put("msg","提示：添加处方成功!");
        return map;
    }

    @PostMapping("/select")
    public Map<String,Object> select(Integer id){
        Map<String, Object> map = new HashMap<>();
        List<Drugsdetailed> drugsdetaileds = prescribeService.findDrugsdetailedsByDrugsTempID_Id(id);
        map.put("drugsdetaileds",drugsdetaileds);
        return map;
    }

    @GetMapping("/updatePreList")
    public Map<String,Object> updatePreList(Integer id){
        Map<String, Object> map = new HashMap<>();
        List<Prescription> prescriptions = prescribeService.findPrescriptionsByRegistID_Id(id);
        map.put("prescriptions",prescriptions);
        return map;
    }


    @PostMapping("/deleteCase")
    public Map<String,Object> deleteCase(Integer id){
        log.info("数组:[{}]",id);
        Map<String, Object> map = new HashMap<>();
        //删除处方对应的药品
        prescribeService.deletePrescriptiondetailedsByPrescriptionID_Id(id);
        prescribeService.deleteCase(id);
        map.put("msg","提示：删除处方成功!");
        return map;
    }

    @PostMapping("/deleteDrug")
    public Map<String,Object> deleteDrug(Integer id){
        Map<String, Object> map = new HashMap<>();
        //删除处方对应的药品
        prescribeService.deletedetail(id);
        map.put("msg","提示：删除药品成功!");
        return map;
    }

    @GetMapping("/findCase")
    public Map<String,Object> findCase(Integer id){
        Map<String, Object> map = new HashMap<>();
        List<Prescriptiondetailed> prescriptiondetaileds = prescribeService.findPrescriptiondetailedsByPrescriptionID_Id(id);
        map.put("prescriptiondetaileds",prescriptiondetaileds);
        return map;
    }
    @GetMapping("/getMedicalRecord")
    public Medicalrecord getMedicalRecord(Integer id){
        Medicalrecord medicalrecord = prescribeService.findMedicalrecordByRegistID_Id(id);
        return medicalrecord;
    }

    @PostMapping("/save1")
    public Integer save1(@RequestBody Prescription prescription){
        log.info("处方:[{}]",prescription);
        prescription.setPrescriptionTime(new Date());
        //存储处方到患者成药处方表
        Prescription temp = prescribeService.save(prescription);
        return temp.getId();
    }
    @PostMapping("/save2")
    public Map<String,Object> save2(@RequestBody List<Prescriptiondetailed> drugsList){
        log.info("处方:[{}]",drugsList);
        prescribeService.savedetails(drugsList);
        Map<String, Object> map = new HashMap<>();
        map.put("status",true);
        map.put("msg","提示：处方模板加入成功");
        return map;
    }

    @PostMapping("/saveDrug")
    public Map<String, Object>  saveDrug(@RequestBody Prescriptiondetailed prescriptiondetailed){
        Map<String, Object> map = new HashMap<>();
        prescribeService.savedetail(prescriptiondetailed);
        map.put("status",true);
        map.put("msg","提示：药品添加成功");
        return map;
    }

    @GetMapping("/findAllDrug")
    public Map<String,Object> findAllDrug(Integer page,Integer rows){
        page = page ==null?1:page;
        rows = rows ==null?5:rows;
        HashMap<String,Object> map = new HashMap<>();
        //分页处理
        List<Drugs> drugs = prescribeService.findByPage(page,rows);
        //计算总页数
        Long totals = prescribeService.findTotals();
        Long totalPage = totals%rows==0?totals/rows:totals/rows+1;
        map.put("drugs",drugs);
        map.put("totals",totals);
        map.put("totalPage",totalPage);
        map.put("page",page);
        return map;
    }

    @PostMapping("/checkDrug")
    public Map<String,Object> checkDrug(String checkName){
        Map<String, Object> map = new HashMap<>();
        List<Drugs> drugs = prescribeService.findDrugsByMnemonicCode(checkName);
        map.put("drugs",drugs);
        return map;
    }

    /**
     * 开立患者处方操作
     * @param id
     * @return
     */
    @GetMapping("/open")
    public Map<String,Object> open(Integer id){
        Map<String, Object> map = new HashMap<>();
        //根据挂号id获取所有处方并更改状态
        List<Prescription> prescriptions = prescribeService.findPrescriptionsByRegistID_Id(id);
        for(Prescription item:prescriptions){
            if(item.getPrescriptionState()==2){
                map.put("status",true);
                map.put("msg","提示：处方已完成开立，无法继续开立");
                return map;
            }
            item.setPrescriptionState(2);
            prescribeService.save(item);
            //更新处方明细表的具体药品开立状态
            List<Prescriptiondetailed> prescriptiondetaileds = prescribeService.findPrescriptiondetailedsByPrescriptionID_Id(item.getId());
            for(Prescriptiondetailed temp:prescriptiondetaileds){
                temp.setState(2);
                prescribeService.savedetail(temp);
            }
        }
        map.put("status",true);
        map.put("msg","提示：处方开立成功");
        return map;
    }
}
