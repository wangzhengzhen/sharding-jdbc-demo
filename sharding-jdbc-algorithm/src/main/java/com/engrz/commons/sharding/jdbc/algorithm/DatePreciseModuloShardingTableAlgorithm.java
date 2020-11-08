package com.engrz.commons.sharding.jdbc.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * 日期精确匹配
 */
public class DatePreciseModuloShardingTableAlgorithm implements PreciseShardingAlgorithm<Date> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {

        Date date = preciseShardingValue.getValue();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String year = String.valueOf(c.get(Calendar.YEAR));

        String tableName = null;
        for (String tmp : collection) {
            if (tmp.endsWith(year)) {
                // 如果以当前年份结尾
                tableName = tmp;
                break;
            }
        }

        if (null == tableName) {
            String str = collection.iterator().next();
            tableName = str.substring(0, str.lastIndexOf("_"));
        }

        return tableName;
    }
}
