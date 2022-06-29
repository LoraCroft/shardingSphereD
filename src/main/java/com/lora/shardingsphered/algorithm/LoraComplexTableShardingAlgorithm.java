package com.lora.shardingsphered.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;

/**
 * LoraComplexTableShardingAlgorithm
 *
 * @author zy
 * @version 1.0
 * @description
 * @date 2022/6/30 1:13
 */
public class LoraComplexTableShardingAlgorithm implements ComplexKeysShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<Long> shardingValue) {
        //sql: select cid,cname,user_id,cstatus from course WHERE cid BETWEEN ? AND ? AND user_id = ?

        //getColumnNameAndRangeValuesMap 获取范围查询数据
        Range<Long> cidRange = shardingValue.getColumnNameAndRangeValuesMap().get("cid");

        Collection<Long> userIdCol = shardingValue.getColumnNameAndShardingValuesMap().get("user_id");

        Long upperVal = cidRange.upperEndpoint();
        Long lowerVal = cidRange.lowerEndpoint();

        Collection<String> dbSet = new HashSet<>();
        for (Long userId : userIdCol) {
            BigInteger ars = BigInteger.valueOf(userId).mod(new BigInteger("2")).add(new BigInteger("1"));
            String dbName = shardingValue.getLogicTableName()+"_"+ars;
            if (!dbSet.contains(dbName)){
                dbSet.add(dbName);
            }
        }

        if (dbSet.size() != 0){
            return dbSet;
        }

        throw new UnsupportedOperationException("route"+ userIdCol + "is not support , please check your config");
    }
}
