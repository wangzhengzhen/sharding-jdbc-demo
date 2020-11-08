package com.engrz.commons.sharding.jdbc.algorithm;

import com.engrz.commons.sharding.jdbc.ShardingDateUtil;
import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.*;

/**
 * 季度范围查询
 */
public class QuarterRangeModuloShardingTableAlgorithm implements RangeShardingAlgorithm<Date> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Date> shardingValue) {

        // 这里可以处理日期字段，避免多余查询
        Range<Date> range = shardingValue.getValueRange();

        Integer start = null;
        if (range.hasLowerBound()) {
            Date lowerEndpoint = range.lowerEndpoint();
            Calendar c = Calendar.getInstance();
            c.setTime(lowerEndpoint);
            String year = String.valueOf(c.get(Calendar.YEAR));
            int month = c.get(Calendar.MONTH) + 1;
            String quarter = String.valueOf(ShardingDateUtil.getQuarter(month));
            start = Integer.parseInt(year + quarter);
        }
        Integer end = null;
        if (range.hasUpperBound()) {
            Date upperEndpoint = range.upperEndpoint();
            Calendar c = Calendar.getInstance();
            c.setTime(upperEndpoint);
            String year = String.valueOf(c.get(Calendar.YEAR));
            int month = c.get(Calendar.MONTH) + 1;
            String quarter = String.valueOf(ShardingDateUtil.getQuarter(month));
            end = Integer.parseInt(year + quarter);
        }

        if (null == start && null == end) {
            return availableTargetNames;
        }

        List<String> list = new ArrayList<>();
        for (String tableName : availableTargetNames) {
            int suffix = Integer.parseInt(tableName.substring(tableName.lastIndexOf("_") + 1));
            if (null != start && suffix < start) {
                continue;
            }
            if (null != end && suffix > end) {
                continue;
            }
            list.add(tableName);
        }

        // 默认表
        if (list.isEmpty()) {
            String str = availableTargetNames.iterator().next();
            String tableName = str.substring(0, str.lastIndexOf("_"));
            list.add(tableName);
        }

        return list;
    }

}
