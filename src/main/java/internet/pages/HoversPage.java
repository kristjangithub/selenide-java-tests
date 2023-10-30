package internet.pages;

import com.codeborne.selenide.Condition;
import internet.interfaces.IPageObject;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$$;

public class HoversPage implements IPageObject {

    @Override
    public String getUrl() {
        return "/hovers";
    }

    public HoversPage hoverUserPicture(int nth) {
        $$("div.figure").get(nth).hover();
        return this;
    }

    public ArrayList<String> getVisibleUserData() {
        var list = new ArrayList<String>();

        var parentSelector = ".figcaption";
        list.add($$(parentSelector + " h5").findBy(Condition.visible).getText());
        list.add($$(parentSelector + " a").findBy(Condition.visible).getAttribute("href"));
        return list;
    }
}
