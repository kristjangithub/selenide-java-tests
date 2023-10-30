package internet.tests;

import internet.BaseTest;
import internet.pages.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @Test
    public void canUploadFileTest() {
        var fileUploadPage = new FileUploadPage();

        visit(fileUploadPage.getUrl());

        fileUploadPage
            .chooseFile("upload-file.txt")
            .tryUpload();

        var isFileUploadSuccess = fileUploadPage.isFileUploaded();

        Assert.assertTrue(isFileUploadSuccess);
    }
}
