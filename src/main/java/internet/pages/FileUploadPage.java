package internet.pages;

import internet.interfaces.IPageObject;

import static com.codeborne.selenide.Selenide.$;

public class FileUploadPage implements IPageObject {

    private String fileName = null;

    @Override
    public String getUrl() {
        return "/upload";
    }

    public FileUploadPage chooseFile(String filePath) {
        $("#file-upload").uploadFromClasspath(filePath);
        fileName = filePath;
        return this;
    }

    public FileUploadPage tryUpload() {
        $("#file-submit").click();
        return this;
    }

    public boolean isFileUploaded() {
        return $("#uploaded-files").getText().equals(fileName);
    }
}
