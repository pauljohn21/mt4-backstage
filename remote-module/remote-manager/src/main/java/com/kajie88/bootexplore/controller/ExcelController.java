package com.kajie88.bootexplore.controller;

import com.kajie88.base.dto.resp.BaseRespDTO;
import com.kajie88.util.excel.ReadWriteExcel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("excel")
public class ExcelController {
    @RequestMapping(value = "receiveExcel")
    public Map<String,Object> changeUserPhone(HttpServletRequest request, MultipartFile file) throws Exception {
        //int a = 1/0;
        String filename = file.getOriginalFilename();
        String filesuff = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        //File f = new File("/workspaces/temp/temp." + filename);
        File f = new File("D://temp." + filename);
        file.transferTo(f);
        Map<String,Object> list = ReadWriteExcel.readExcel(f,0);
        return new BaseRespDTO().success("resultList",list).result();
    }
}
