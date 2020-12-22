package markup;
import java.util.List;
public abstract class AbstractElement implements Content {
    private List<Content> markUpElements;
    protected AbstractElement(List<Content> list) {
        this.markUpElements = list;
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append(getMarkdownBorder());
        for (Content element : markUpElements) {
            element.toMarkdown(stringBuilder);
        }
        stringBuilder.append(getMarkdownBorder());
    }

    @Override
    public void toHtml(StringBuilder stringBuilder) {
        stringBuilder.append(getOpenHtml());
        for (Content element : markUpElements) {
            element.toHtml(stringBuilder);
        }
        stringBuilder.append(getCloseHtml());
    }

    @Override
    public void toBBCode(StringBuilder stringBuilder) {
        stringBuilder.append(getOpenBBCode());
        for (Content element : markUpElements) {
            element.toBBCode(stringBuilder);
        }
        stringBuilder.append(getCloseBBCode());
    }

    public abstract String getOpenHtml();
    public abstract String getCloseHtml();
    public abstract String getOpenBBCode();
    public abstract String getCloseBBCode();
    public abstract String getMarkdownBorder();
}
