package com.ujn.hxl.controller;

import com.ujn.hxl.inter.IUserOperation;
import com.ujn.hxl.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lss on 2017/5/30.
 */
@Controller
@RequestMapping("/article")
public class UserController {
    @Autowired
    IUserOperation userMapper;

    @RequestMapping("/list")
    public ModelAndView listAll(HttpServletRequest request, HttpServletResponse response){
        List<Article> articles = userMapper.getUserArticles(1);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("articles",articles);
        return modelAndView;
    }
}
