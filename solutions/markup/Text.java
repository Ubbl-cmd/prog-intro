package markup;

public class Text implements Content {

    private String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append(text);
    }
    @Override
    public void toHtml(StringBuilder stringBuilder) {
        stringBuilder.append(text);
    }
    @Override
    public void toBBCode(StringBuilder stringBuilder) {
        stringBuilder.append(text);
    }    
}
