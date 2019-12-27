package org.humki.baiduueditor.controller;


import org.humki.baiduueditor.model.RequestParameter;
import org.humki.baiduueditor.action.DefaultAction;
import org.humki.baiduueditor.action.UeditorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Kael
 */
@RestController
@RequestMapping("/ueditor")
public class UeditorController {

    private final DefaultAction action;

    @Autowired
    public UeditorController(DefaultAction action) {
        this.action = action;
    }

    /**
     * ueditor 后台主方法
     */
    @RequestMapping(value = "/main", method = {RequestMethod.GET, RequestMethod.POST})
    public String main(RequestParameter parameter, HttpServletRequest request, HttpServletResponse response) {
        // 使用默认action，也可以实现Action来自定义
        return UeditorHandler.execute(parameter, action, request, response);
    }


}
