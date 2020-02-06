package com.engrz.demo.sharding.jdbc.example.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class DatePreciseModuloShardingTableAlgorithm implements PreciseShardingAlgorithm<Date> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {

        Date date = preciseShardingValue.getValue();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = c.get(Calendar.YEAR);

        return String.valueOf(year);
    }
}
