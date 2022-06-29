package com.lora.shardingsphered.algorithm;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * LoraHintTableShardingAlgorithm
 *
 * @author zy
 * @version 1.0
 * @description
 * @date 2022/6/30 1:53
 */
public class LoraHintTableShardingAlgorithm implements HintShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<Integer> shardingValue) {
        String key = shardingValue.getLogicTableName() + "_" + shardingValue.getValues().toArray()[0];
        if (availableTargetNames.contains(key)){
            return Arrays.asList(key);
        }
        throw new UnsupportedOperationException("route"+ key + "is not support , please check your config");
    }
}
