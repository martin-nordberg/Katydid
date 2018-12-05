//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing;

public class KotlinToken {

    private final int channel;

    private final int column;

    private final int line;

    private final String text;

    private final EKotlinTokenType type;

    private final Object value;

    ////

    public KotlinToken(
            EKotlinTokenType type,
            String text,
            int zeroBasedLine,
            int zeroBasedColumn,
            Object value,
            int channel
    ) {
        this.type = type;
        this.text = text;
        this.column = zeroBasedColumn + 1;
        this.line = zeroBasedLine + 1;
        this.value = value == null ? text : value;
        this.channel = channel;
    }

    ////

    public int getChannel() {
        return channel;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLength() {
        return text.length();
    }

    public int getLine() {
        return this.line;
    }

    public String getText() {
        return text;
    }

    public EKotlinTokenType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

}
