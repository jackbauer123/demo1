package com.example.demo;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

//@LocalTCC
public interface AccountTblService /* extends IService<AccountTbl> */{

    /**
     * 执行资源检查及预留操作
     */
    @TwoPhaseBusinessAction(name = "prepareBuy", commitMethod = "commit", rollbackMethod = "rollback")
    Object prepareBuy(@BusinessActionContextParameter(paramName = "userId") String userId, String code, @BusinessActionContextParameter(paramName = "count") Long count);

    /**
     * 全局事物进行提交
     */
    boolean commit(BusinessActionContext actionContext);

    /**
     * 全局事务进行回滚
     */
    boolean rollback(BusinessActionContext actionContext);
}

