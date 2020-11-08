package com.engrz.commons.sharding.jdbc.algorithm;

import com.engrz.commons.sharding.jdbc.ShardingDateUtil;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * 季度精确匹配
 */
public class QuarterPreciseModuloShardingTableAlgorithm implements PreciseShardingAlgorithm<Date> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {

        Date date = preciseShardingValue.getValue();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String year = String.valueOf(c.get(Calendar.YEAR));
        int month = c.get(Calendar.MONTH) + 1;
        int quarter = ShardingDateUtil.getQuarter(month);

        String suffix = year + quarter;

        String tableName = null;
        for (String tmp : collection) {
            if (tmp.endsWith(suffix)) {
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
