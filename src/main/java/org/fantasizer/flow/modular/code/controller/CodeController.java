package org.fantasizer.flow.modular.code.controller;

import org.fantasizer.flow.core.base.controller.BaseController;
import org.fantasizer.flow.core.datasource.HikariProperties;
import org.fantasizer.flow.generator.action.config.WebGeneratorConfig;
import org.fantasizer.flow.generator.action.model.GenQo;
import org.fantasizer.flow.modular.code.factory.DefaultTemplateFactory;
import org.fantasizer.flow.modular.code.service.TableService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 代码生成控制器
 *
 * @author fengshuonan
 * @Date 2017年11月30日16:39:19
 */
@Controller
@RequestMapping("/code")
public class CodeController extends BaseController {

    private static String PREFIX = "/code";

    @Autowired
    private TableService tableService;

    @Autowired
    private HikariProperties hikariProperties;

    /**
     * 跳转到代码生成主页
     */
    @RequestMapping("")
    public String blackboard(Model model) {
        model.addAttribute("tables", tableService.getAllTables());
        model.addAttribute("params", DefaultTemplateFactory.getDefaultParams());
        model.addAttribute("templates", DefaultTemplateFactory.getDefaultTemplates());
        return PREFIX + "/code.html";
    }

    /**
     * 生成代码
     */
    @ApiOperation("生成代码")
    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    @ResponseBody
    public Object generate(GenQo genQo) {
        genQo.setUrl(hikariProperties.getJdbcUrl());
        genQo.setUserName(hikariProperties.getUsername());
        genQo.setPassword(hikariProperties.getPassword());
        WebGeneratorConfig webGeneratorConfig = new WebGeneratorConfig(genQo);
        webGeneratorConfig.doMpGeneration();
        webGeneratorConfig.doGunsGeneration();
        return SUCCESS_TIP;
    }
}
