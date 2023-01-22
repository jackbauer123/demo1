package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RequestController {


    private static final Logger log = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    HandleService handleService;
    //@Autowired
    //AccountTblServiceImpl accountTblService;

    @RequestMapping(value = "/demo/saveall", method = RequestMethod.GET)
    public String save() {
        log.info("start request....");
        /*try{
            int t = 1/0;
        }catch (Exception e){
            log.error("00123",e);
            throw e;
        }*/
        handleService.save("jack","001",100);
        return "demo save";
    }

    @RequestMapping(value = "/demo/tccSave", method = RequestMethod.GET)
    public String tccSave() {
        //handleService.tccSave(new HashMap<String,String>());
        return "demo save";
    }

    @GetMapping("/demo/testTcc")
    @Transactional
    public Object test() {
        return  null ;//accountTblService.prepareBuy("11111111","iphone11",1L);
    }
}
