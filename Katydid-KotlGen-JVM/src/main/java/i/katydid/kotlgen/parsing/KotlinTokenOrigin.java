//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.parsing;

public class KotlinTokenOrigin {

    private final int column;

    private final int length;

    private final int line;

    ////

    public KotlinTokenOrigin(int line, int column, int length) {
        this.line = line;
        this.column = column;
        this.length = length;
    }

    ////

    public int getColumn() {
        return column;
    }

    public int getLength() {
        return length;
    }

    public int getLine() {
        return line;
    }

    @Override
    public boolean equals(Object other) {

        if (this == other) {
            return true;
        }

        if (other instanceof KotlinTokenOrigin) {
            KotlinTokenOrigin that = (KotlinTokenOrigin) other;
            return this.line == that.line &&
                    this.column == that.column &&
                    this.length == that.length;
        }

        return false;

    }

    @Override
    public int hashCode() {
        return line * 1000 + column * 10 + length;
    }

    @Override
    public String toString() {
        return "(" + line + "," + column + "," + length + ")";
    }

}
