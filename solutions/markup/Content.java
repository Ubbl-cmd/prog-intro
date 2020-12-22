package markup;

public interface Content {
    void toMarkdown(StringBuilder stringBuilder);
    void toHtml(StringBuilder stringBuilder);
    void toBBCode(StringBuilder stringBuilder);
}
