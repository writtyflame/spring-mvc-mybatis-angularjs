package com.crell.common.controller;

import com.crell.common.model.Dictionary;
import com.crell.common.service.BaseDataSer;
import com.crell.core.constant.BaseResources;
import com.crell.core.constant.ResponseState;
import com.crell.core.controller.AbstractController;
import com.crell.core.dto.ReturnBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by crell on 2016/1/11.
 */
@RestController
public class BaseDataController extends AbstractController {

    @Autowired
    BaseDataSer baseDataSer;

    @RequestMapping(value = {"/baseData/{type}"},method = RequestMethod.GET)
    @ResponseBody
    public ReturnBody getByType(@PathVariable("type") String type){

        List<Dictionary> dictList = baseDataSer.getListByType(type);
        ReturnBody returnBody = new ReturnBody();
        returnBody.setStatus(ResponseState.SUCCESS);
        returnBody.setData(dictList);

        return  returnBody;
    }

    @RequestMapping(value = {"/appData"},method = RequestMethod.GET)
    @ResponseBody
    public ReturnBody getAppData(){

        Map<String,String> map = BaseResources.getDomains();
        ReturnBody returnBody = new ReturnBody();
        returnBody.setStatus(ResponseState.SUCCESS);
        returnBody.setData(map);

        return  returnBody;
    }
}
