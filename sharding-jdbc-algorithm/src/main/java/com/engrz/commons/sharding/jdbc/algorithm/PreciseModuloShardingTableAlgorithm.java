package com.engrz.commons.sharding.jdbc.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class PreciseModuloShardingTableAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(final Collection<String> tableNames, final PreciseShardingValue<Long> shardingValue) {

        int m = tableNames.size();
        for (String each : tableNames) {
            if (each.endsWith(shardingValue.getValue() % m + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}
