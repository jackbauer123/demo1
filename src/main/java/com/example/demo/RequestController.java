package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RequestController {

    @Autowired
    HandleService handleService;

    @RequestMapping(value = "/demo/save", method = RequestMethod.GET)
    public String save() {
        handleService.save("jack","001",100);
        return "demo save";
    }

    @RequestMapping(value = "/demo/tccSave", method = RequestMethod.GET)
    public String tccSave() {
        handleService.tccSave();
        return "demo save";
    }
}
