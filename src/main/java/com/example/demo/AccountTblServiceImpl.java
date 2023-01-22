package com.example.demo;

import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//@Service
public class AccountTblServiceImpl /*extends ServiceImpl<AccountTblMapper, AccountTbl>*/ implements AccountTblService {

    private static final Logger log = LoggerFactory.getLogger(AccountTblServiceImpl.class);

    @Override
    public Object prepareBuy(String userId, String code, Long count) {
        log.info("开始TCC xid:" + RootContext.getXID());
        throw new RuntimeException();
        //return "执行完毕！";
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        log.info("xid = " + actionContext.getXid() + "提交成功");
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {

        log.info("xid = " + actionContext.getXid() + "进行回滚操作");
        return true;
    }
}

