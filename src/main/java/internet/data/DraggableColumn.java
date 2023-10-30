package internet.data;

public enum DraggableColumn {

    COLUMN_A("#column-a"),
    COLUMN_B("#column-b");

    private final String cssSelector;

    DraggableColumn(String cssSelector) {
        this.cssSelector = cssSelector;
    }

    public String getCssSelector() {
        return cssSelector;
    }
}
