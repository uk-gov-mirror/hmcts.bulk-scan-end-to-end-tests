package uk.gov.hmcts.reform.bulkscan.endtoendtests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import uk.gov.hmcts.reform.bulkscan.endtoendtests.helper.Await;
import uk.gov.hmcts.reform.bulkscan.endtoendtests.helper.Container;
import uk.gov.hmcts.reform.bulkscan.endtoendtests.helper.StorageHelper;
import uk.gov.hmcts.reform.bulkscan.endtoendtests.helper.ZipFileHelper;
import uk.gov.hmcts.reform.bulkscan.endtoendtests.model.Classification;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.reform.bulkscan.endtoendtests.utils.ProcessorEnvelopeStatusChecker.getZipFileStatus;

public class ExceptionRecordTest {

    @ParameterizedTest
    @EnumSource(Classification.class)
    public void should_dispatch_blob_and_create_exception_record_for_classification(Classification classification)
        throws Exception {

        var zipArchive = ZipFileHelper.createZipArchive("test-data/" + classification, Container.BULKSCAN);

        StorageHelper.uploadZipFile(Container.BULKSCAN, zipArchive);

        Await.envelopeDispatched(zipArchive.fileName);
        Await.envelopeCompleted(zipArchive.fileName);

        assertThat(getZipFileStatus(zipArchive.fileName))
            .map(status -> status.envelopeCcdAction)
            .isEqualTo("EXCEPTION_RECORD");
    }
}
