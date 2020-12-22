package markup;

import java.util.List;

public class Strong extends AbstractElement {

    public Strong(List<Content> list) {
        super(list);
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        super.toMarkdown(stringBuilder);
    }


    @Override
    public String getMarkdownBorder() {
        return "__";
    }

    @Override
    public void toHtml(StringBuilder stringBuilder) {
        super.toHtml(stringBuilder);
    }

    @Override
    public String getOpenHtml() {
        return "<strong>";
    }
    @Override
    public String getCloseHtml() {
        return "</strong>";
    }
    @Override
    public String getOpenBBCode() {
        return "[b]";
    }
    @Override
    public String getCloseBBCode() {
        return "[/b]";
    }
}
