package com.engrz.commons.sharding.jdbc.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.*;

/**
 * 日期范围查询
 */
public class DateRangeModuloShardingTableAlgorithm implements RangeShardingAlgorithm<Date> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Date> rangeShardingValue) {

        // 这里可以处理日期字段，避免多余查询
        Range<Date> range = rangeShardingValue.getValueRange();

        Integer start = null;
        if (range.hasLowerBound()) {
            Date lowerEndpoint = range.lowerEndpoint();
            Calendar c = Calendar.getInstance();
            c.setTime(lowerEndpoint);
            start = Calendar.YEAR;
        }
        Integer end = null;
        if (range.hasUpperBound()) {
            Date upperEndpoint = range.upperEndpoint();
            Calendar c = Calendar.getInstance();
            c.setTime(upperEndpoint);
            end = Calendar.YEAR;
        }

        if (null == start && null == end) {
            return collection;
        }

        List<String> list = new ArrayList<>();
        for (String tableName : collection) {
            int suffix = Integer.parseInt(tableName.substring(tableName.lastIndexOf("_") + 1));
            if (null != start && suffix < start) {
                continue;
            }
            if (null != end && suffix > end) {
                continue;
            }
            list.add(tableName);
        }

        return list;
    }
}
