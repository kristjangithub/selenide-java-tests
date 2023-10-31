package internet.pages;

import static com.codeborne.selenide.Selenide.*;

public class AddElementsPage {

    public String getUrl() {
        return "/add_remove_elements/";
    }

    public AddElementsPage klikiMituKorda(int kogus) {
        for (int i = 1; i <= kogus; i++) {
            clickElement();
        }

        return this;
    }

    private AddElementsPage clickElement() {
        $("button[onclick='addElement()']").click();
        return this;
    }

    public int getDeleteButtonCount() {
        return $$("button[onclick='deleteElement()']").size();
    }
}
