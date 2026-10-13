package com.amazonaws.ivs.player;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class TextCue extends Cue {
    public final float line;
    public final float position;
    public final float size;
    public final String text;
    public final TextAlignment textAlign;

    public enum TextAlignment {
        START,
        MIDDLE,
        END;

        static TextAlignment fromInt(int i) {
            if (i < 0 || i >= values().length) {
                return START;
            }
            return values()[i];
        }
    }

    TextCue(long j, long j2, float f, float f2, float f3, int i, String str) {
        super(j, j2);
        this.line = f;
        this.size = f2;
        this.position = f3;
        this.textAlign = TextAlignment.fromInt(i);
        this.text = str;
    }

    @Override // com.amazonaws.ivs.player.Cue
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextCue) || !super.equals(obj)) {
            return false;
        }
        TextCue textCue = (TextCue) obj;
        return Float.compare(textCue.line, this.line) == 0 && Float.compare(textCue.size, this.size) == 0 && Float.compare(textCue.position, this.position) == 0 && this.textAlign == textCue.textAlign && Objects.equals(this.text, textCue.text);
    }

    @Override // com.amazonaws.ivs.player.Cue
    public int hashCode() {
        return Objects.hash(Long.valueOf(this.startTime), Long.valueOf(this.endTime), Float.valueOf(this.line), Float.valueOf(this.size), Float.valueOf(this.position), this.textAlign, this.text);
    }

    public String toString() {
        return "TextCue{startTime=" + this.startTime + ", endTime=" + this.endTime + ", line=" + this.line + ", size=" + this.size + ", position=" + this.position + ", textAlign=" + this.textAlign + ", text='" + this.text + "'}";
    }
}
