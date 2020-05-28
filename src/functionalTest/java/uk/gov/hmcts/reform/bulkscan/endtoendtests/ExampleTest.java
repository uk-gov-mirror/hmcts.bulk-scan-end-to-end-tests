package uk.gov.hmcts.reform.bulkscan.endtoendtests;

import org.junit.jupiter.api.Test;
import uk.gov.hmcts.reform.bulkscan.endtoendtests.config.TestConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ExampleTest {
    private static TestConfiguration config = new TestConfiguration();

    @Test
    public void testConfig() {
        assertEquals(config.storageAccountName, "reformscanaat", "Storage Account name loaded from Keyvault");
        assertNotNull(config.storageAccountKey, "Storage Account Key is not null");
        assertNotNull(config.storageAccountUrl, "Storage Account URL is not null");
    }

}
