package markup;

import java.util.List;

public class Paragraph {

    List<Content> list;

    public Paragraph(List<Content> list) {
        this.list = list;
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        for (Content element : list) {
            element.toMarkdown(stringBuilder);
        }
    }
    public void toHtml(StringBuilder stringBuilder) {
        for (Content element : list) {
            element.toHtml(stringBuilder);
        }
    }
    public void toBBCode(StringBuilder stringBuilder) {
        for (Content element : list) {
            element.toBBCode(stringBuilder);
        }
    }
}
