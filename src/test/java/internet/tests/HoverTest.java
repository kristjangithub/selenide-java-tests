package internet.tests;

import internet.BaseTest;
import internet.Constants;
import internet.pages.HoversPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest extends BaseTest {

    @Test
    public void hoverRevealsUserDataTest() {
        var hoversPage = new HoversPage();

        visit(hoversPage.getUrl());

        hoversPage
            .hoverUserPicture(1);

        var actualUserData = hoversPage.getVisibleUserData();

        Assert.assertEquals(actualUserData, List.of("name: user2", Constants.BASE_URL + "/users/2"));
    }
}
