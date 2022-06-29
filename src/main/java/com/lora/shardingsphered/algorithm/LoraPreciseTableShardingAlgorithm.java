package com.lora.shardingsphered.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.Collection;

/**
 * PreciseTableShardingAlgorithm
 *
 * @author zy
 * @version 1.0
 * @description 针对查询 精确分表策略，可以实现范围查询
 * @date 2022/6/30 0:17
 */
public class LoraPreciseTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {


    /**
     *
     * 实现分片 策略
     * @param availableTargetNames 所有真实的表目标  参数 actual-data-nodes
     * @param shardingValue 条件
     * @return
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        //preciseShardingValue 泛型为 分区的 primaryKey


        //shardingValue 分片键对象信息,泛型为分片键的类型
        //逻辑表名
        String logicTableName = shardingValue.getLogicTableName();
        //字段名称
        String columnName = shardingValue.getColumnName();
        //字段值值
        Long value = shardingValue.getValue();


        String key = logicTableName+"_"+ BigInteger.valueOf(value).mod(new BigInteger("2")).add(new BigInteger("1"));
        if (availableTargetNames.contains(key)){
            return key;
        }

        throw new UnsupportedOperationException("route"+ key + "is not support , please check your config");
    }
}
