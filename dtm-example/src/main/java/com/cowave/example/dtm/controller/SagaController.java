/*
 * Copyright (c) 2017～2099 Cowave All Rights Reserved.
 *
 * For licensing information, please contact: https://www.cowave.com.
 *
 * This code is proprietary and confidential.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.cowave.example.dtm.controller;

import com.cowave.commons.dtm.DtmClient;
import com.cowave.commons.dtm.impl.Saga;
import com.cowave.commons.dtm.DtmResult;
import com.cowave.commons.tools.HttpException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/api"))
public class SagaController {

    private final DtmClient dtmClient;

    @RequestMapping("/saga")
    public DtmResult saga() throws HttpException {
        Saga saga = dtmClient.saga(UUID.randomUUID().toString());
        saga.step("http://localhost:8081/api/TransOut", "http://localhost:8081/api/TransOutCompensate", "");
        saga.step("http://localhost:8081/api/TransIn", "http://localhost:8081/api/TransInCompensate", "");
        saga.enableWaitResult();
        return saga.submit();
    }
}
