package com.engrz.commons.sharding.jdbc.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class PreciseModuloShardingTableAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(final Collection<String> tableNames, final PreciseShardingValue<Long> shardingValue) {

        int m = tableNames.size();
        for (String name : tableNames) {
            if (name.endsWith(shardingValue.getValue() % m + "")) {
                return name;
            }
        }
        throw new UnsupportedOperationException();
    }
}
