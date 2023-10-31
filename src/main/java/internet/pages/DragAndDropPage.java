package internet.pages;

import internet.interfaces.IPageObject;
import internet.data.DraggableBox;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DragAndDropPage implements IPageObject {

    @Override
    public String getUrl() {
        return "/drag_and_drop";
    }

    public DragAndDropPage dragBoxTo(DraggableBox source, DraggableBox target) {
        $(source.getCssSelector()).dragAndDropTo(target.getCssSelector());
        return this;
    }

    public String getColumnHeaderText(int nth) {
        return $$(".column header").get(nth).getText();
    }
}
