/*
 * Copyright (c) 2017～2099 Cowave All Rights Reserved.
 *
 * For licensing information, please contact: https://www.cowave.com.
 *
 * This code is proprietary and confidential.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.cowave.commons.dtm;

import com.cowave.commons.dtm.impl.Saga;
import com.cowave.commons.dtm.impl.Tcc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author shanhuiming
 *
 */
@Slf4j
@RequiredArgsConstructor
public class DtmClient {

    private final DtmService dtmService;

    /**
     * 创建saga
     */
    public Saga saga() {
        return new Saga(null, dtmService);
    }

    /**
     * 创建saga，并指定gid
     */
    public Saga saga(String gid) {
        return new Saga(gid, dtmService);
    }

    /**
     * 创建tcc
     */
    public DtmResult tcc(DtmOperator<Tcc> function) throws Exception {
        Tcc tcc = new Tcc("",null, dtmService);
        return tcc.prepare(function);
    }

    /**
     * 创建tcc，并指定gid
     */
    public DtmResult tcc(String gid, DtmOperator<Tcc> function) throws Exception {
        Tcc tcc = new Tcc("", gid, dtmService);
        return tcc.prepare(function);
    }

    /**
     * 创建tcc
     */
    public DtmResult tcc(String gid, DtmOperator<Tcc> function, String branchPrefix) throws Exception {
        Tcc tcc = new Tcc(branchPrefix,null, dtmService);
        return tcc.prepare(function);
    }
}
