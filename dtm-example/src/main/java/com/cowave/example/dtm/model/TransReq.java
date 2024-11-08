/*
 * Copyright (c) 2017～2024 Cowave All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package com.cowave.example.dtm.model;

import lombok.Data;

/**
 * @author lixiaoshuang
 */
@Data
public class TransReq {

    /**
     * 用户id
     */
    private int userId;

    /**
     * 转入/转出金额
     */
    private int amount;

    /**
     * jackson 必须使用无参构造
     */
    public TransReq(){
    }

    public TransReq(int userId, int amount) {
        this.userId = userId;
        this.amount = amount;
    }
}
