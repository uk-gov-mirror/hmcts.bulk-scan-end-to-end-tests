package uk.gov.hmcts.reform.bulkscan.endtoendtests.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class TestConfiguration {

    public final String storageAccountName;
    public final String storageAccountKey;
    public final String storageAccountUrl;

    public TestConfiguration() {
        Config config = ConfigFactory.load();

        this.storageAccountName = config.getString("storage-account-name");
        this.storageAccountKey = config.getString("storage-account-key");
        this.storageAccountUrl = config.getString("storage-account-url");
    }
}
