package com.engrz.commons.sharding.jdbc.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class PreciseModuloShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(final Collection<String> databaseNames, final PreciseShardingValue<Long> shardingValue) {

        int m = databaseNames.size();
        for (String each : databaseNames) {
            if (each.endsWith(shardingValue.getValue() % m + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}
