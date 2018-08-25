package com.kajie88.bootexplore.controller;

import com.kajie88.base.dto.req.BasePageInfoReqDTO;
import com.kajie88.base.dto.resp.BaseRespDTO;
import com.kajie88.base.enums.common.SqlSortType;
import com.kajie88.base.utils.StringUtil;
import com.kajie88.system.domain.NoticeDomain;
import com.kajie88.system.service.NoticeService;
import com.kajie88.user.domain.UserInfoDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("notice")
public class NoticeController{
    @Autowired
    private NoticeService noticeService;


    @RequestMapping("getNoticeList")
    public Map<String,Object> getNoticeList(@RequestBody BasePageInfoReqDTO<Map<String,String>> reqDTO){
        NoticeDomain noticeDomain = new NoticeDomain();
        noticeDomain.setPageInfo(reqDTO.getPage());
        noticeDomain.setCreateTimeSortType(SqlSortType.DESC);
        List<NoticeDomain> noticeList = noticeService.getDomainList(noticeDomain);
        noticeList.forEach(noticeInfo->{
            //列表里不传信息。
            noticeInfo.setNoticeContent(null);
//            noticeInfo.setPicturePath(null);
        });
        return new BaseRespDTO().page(noticeDomain.getPageInfo()).success("noticeList",noticeList).result();
    }
    @RequestMapping("getNoticeInfo")
    public Map<String,Object> getNoticeInfo(@RequestBody BasePageInfoReqDTO<Map<String,String>> reqDTO){
        NoticeDomain noticeDomain = new NoticeDomain();
        noticeDomain.setId(Integer.valueOf(reqDTO.getParam().get("id")));
        NoticeDomain noticeInfo = noticeService.getDomainByQuery(noticeDomain);
        return new BaseRespDTO().success("noticeInfo",noticeInfo).result();
    }

    @RequestMapping("delNoticeById")
    public Map<String,Object> delNoticeById(@RequestBody BasePageInfoReqDTO<Map<String,String>> reqDTO){
        String id = reqDTO.getParam().get("id");
        noticeService.deleteDomain(Integer.valueOf(id));
        return new BaseRespDTO().success().result();
    }
//    id:'',
//    noticeAbstract:'',
//    picturePath:'',
//    noticeContent:''
    @RequestMapping("upNoticeInfo")
    public Map<String,Object> upNoticeInfo(@RequestParam("file") MultipartFile file,String id,String noticeAbstract,String noticeContent,String title) throws IOException {
        NoticeDomain query = new NoticeDomain();

        query.setNoticeAbstract(noticeAbstract);
        query.setNoticeContent(noticeContent);
        query.setPicturePath(file.getBytes());
        query.setTitle(title);
        if(StringUtil.isEmptyForTrim(id)){
            noticeService.insertDomain(query);
        }else{
            query.setId(Integer.valueOf(id));
            noticeService.updateDomainById(query);
        }
        return new BaseRespDTO().success().result();
    }
    @RequestMapping("upNoticeInfoNoFile")
    public Map<String,Object> upNoticeInfo(@RequestBody BasePageInfoReqDTO<Map<String,String>> reqDTO){
        String id = reqDTO.getParam().get("id");
        String noticeAbstract = reqDTO.getParam().get("noticeAbstract");
        String noticeContent = reqDTO.getParam().get("noticeContent");
        String title = reqDTO.getParam().get("title");
        NoticeDomain query = new NoticeDomain();
        query.setNoticeAbstract(noticeAbstract);
        query.setNoticeContent(noticeContent);
        query.setTitle(title);
        if(StringUtil.isEmptyForTrim(id)){
            noticeService.insertDomain(query);
        }else{
            query.setId(Integer.valueOf(id));
            noticeService.updateDomainById(query);
        }
        return new BaseRespDTO().success().result();
    }
}
