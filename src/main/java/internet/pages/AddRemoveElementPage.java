package internet.pages;

import static com.codeborne.selenide.*

public class AddRemoveElementPage {

    public String getUrl(){
        return "/add_remove_elements/";{
        }
    }

    public AddRemoveElementPage klikiMituKorda(int kogus){
        for (int i = 0; i < kogus; i++){
            clickElement();
        }
        return this;
    }

        public AddRemoveElementPage clickElement(){
            $("button[onclick=´addElement()´]").click();
            return this;}

    public int getDeleteButtonCount() {
$(cs)


    }
}
