package markup;

import java.util.List;

public class Strikeout extends AbstractElement {

    public Strikeout(List<Content> list) {
        super(list);
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        super.toMarkdown(stringBuilder);
    }

    @Override
    public String getMarkdownBorder() {
        return "~";
    }

    @Override
    public void toHtml(StringBuilder stringBuilder) {
        super.toHtml(stringBuilder);
    }

    @Override
    public String getOpenHtml() {
        return "<s>";
    }
    @Override
    public String getCloseHtml() {
        return "</s>";
    }
    @Override
    public String getOpenBBCode() {
        return "[s]";
    }
    @Override
    public String getCloseBBCode() {
        return "[/s]";
    }
}
