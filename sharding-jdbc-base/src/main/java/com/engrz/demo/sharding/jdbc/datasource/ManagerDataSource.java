package com.engrz.demo.sharding.jdbc.datasource;

/**
 * 治理
 */
public class ManagerDataSource {

    /*DataSource getDataSource() throws SQLException {
        // OrchestrationShardingDataSourceFactory 可替换成 OrchestrationMasterSlaveDataSourceFactory 或 OrchestrationEncryptDataSourceFactory
        return OrchestrationShardingDataSourceFactory.createDataSource(
                createDataSourceMap(), createShardingRuleConfig(), new HashMap<String, Object>(), new Properties(),
                new OrchestrationConfiguration("orchestration-sharding-data-source", getRegistryCenterConfiguration(), false));
    }

    private RegistryCenterConfiguration getRegistryCenterConfiguration() {
        RegistryCenterConfiguration regConfig = new RegistryCenterConfiguration();
        regConfig.setServerLists("localhost:2181");
        regConfig.setNamespace("sharding-sphere-orchestration");
        return regConfig;
    }*/
}
