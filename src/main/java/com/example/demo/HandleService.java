package com.example.demo;

import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class HandleService {

    @Autowired
    private OrderDAO orderDAO;

   @Autowired
    PersonRepository personRepository;

    @Autowired
    TreasureRepository treasureRepository;

    @Transactional
    public void save(String userId, String commodityCode, Integer count){
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        orderDAO.save(order);
        personRepository.save(new Person("jack", "test"));
        treasureRepository.save(new Treasure("yuan", "zhibin"));
    }

    @TwoPhaseBusinessAction(name = "myTestTcc",commitMethod = "confirmCommit",rollbackMethod = "rollBack", useTCCFence = true)
    public void tccSave(){
        System.out.println("tccSave.");
        throw new RuntimeException();
    }


    public void confirmCommit(){
        System.out.println("confirmCommit.");
    }

    public void rollBack(){
        System.out.println("rollBack.");

    }

}
