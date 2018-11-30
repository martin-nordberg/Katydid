//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing;

public class KotlinToken {

    private final int channel;
    private final KotlinTokenOrigin origin;
    private final String text;
    private final EKotlinTokenType type;
    private final Object value;

    ////

    public KotlinToken(EKotlinTokenType type, String text, int zline, int zcolumn, Object value, int channel) {
        this.type = type;
        this.text = text;
        this.origin = new KotlinTokenOrigin(zline + 1, zcolumn + 1, text.length());
        this.value = value == null ? text : value;
        this.channel = channel;
    }

    ////

    public int getChannel() {
        return channel;
    }

    public int getColumn() {
        return origin.getColumn();
    }

    public int getLine() {
        return origin.getLine();
    }

    public KotlinTokenOrigin getOrigin() {
        return origin;
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
