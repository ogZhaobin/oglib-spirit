package com.oglib.spirit.boot.source.disruptor.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 秒杀
 */
@Data
@NoArgsConstructor
public class SecKillEvent implements Serializable {
    private static final long serialVersionUID = -6875775954492163250L;
    private long killId;
    private long userId;
}
