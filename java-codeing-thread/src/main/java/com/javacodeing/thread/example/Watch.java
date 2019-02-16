package com.javacodeing.thread.example;

import lombok.Data;

/**
 * 通知类
 */
@Data
public class Watch {

    // 是否读
    private Boolean read = true;

    // 是否写
    private Boolean write = true;

}
