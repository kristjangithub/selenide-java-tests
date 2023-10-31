package internet.data;

public enum DraggableBox {

    BOX_A("#column-a"),
    BOX_B("#column-b");

    private final String cssSelector;

    DraggableBox(String cssSelector) {
        this.cssSelector = cssSelector;
    }

    public String getCssSelector() {
        return cssSelector;
    }
}
