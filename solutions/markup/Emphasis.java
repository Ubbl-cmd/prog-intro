package markup;

import java.util.List;

public class Emphasis extends AbstractElement {

    public Emphasis(List<Content> list) {
        super(list);
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        super.toMarkdown(stringBuilder);
    }

    @Override
    public void toHtml(StringBuilder stringBuilder) {
        super.toHtml(stringBuilder);
    }

    @Override
    public String getMarkdownBorder() {
        return "*";
    }

    @Override
    public String getOpenHtml() {
        return "<em>";
    }
    @Override
    public String getCloseHtml() {
        return "</em>";
    }
    @Override
    public String getOpenBBCode() {
        return "[i]";
    }
    @Override
    public String getCloseBBCode() {
        return "[/i]";
    }
}
