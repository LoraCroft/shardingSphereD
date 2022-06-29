package com.lora.shardingsphered.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * RangeTableShardingAlgorithm
 *
 * @author zy
 * @version 1.0
 * @description
 * @date 2022/6/30 0:18
 */
public class LoraRangeDBShardingAlgorithm implements RangeShardingAlgorithm<Long> {

    /**
     * 返回需要查询的即可目标表
     * @param availableTargetNames
     * @param shardingValue
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        //example:  select * from course where cid between 1 and 100

        String logicTableName = shardingValue.getLogicTableName();

        Long upperEndpoint = shardingValue.getValueRange().upperEndpoint();
        Long lowerEndpoint = shardingValue.getValueRange().lowerEndpoint();

        return Arrays.asList("m1","m2");
    }

}
