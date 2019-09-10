package com.userLogin.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhang_htao on 2019/9/8.
 */

@Controller
@RequestMapping("product")
public class ProductController {

    @RequestMapping("/add")
    public String add() {
        return "product/add";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "product/delete";
    }
    @RequestMapping("/update")
    public String update() {
        return "product/update";
    }
    @RequestMapping("/list")
    public String list() {
        return "product/list";
    }
}
