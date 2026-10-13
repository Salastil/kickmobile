package com.amazonaws.ivs.player;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class TextTrack {
    private final String id;
    private final String label;
    private final String language;

    TextTrack(String str, String str2, String str3) {
        this.id = str;
        this.label = str2;
        this.language = str3;
    }

    public String getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public String getLanguage() {
        return this.language;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrack)) {
            return false;
        }
        TextTrack textTrack = (TextTrack) obj;
        return Objects.equals(this.id, textTrack.id) && Objects.equals(this.label, textTrack.label) && Objects.equals(this.language, textTrack.language);
    }

    public int hashCode() {
        return Objects.hash(this.id, this.label, this.language);
    }

    public String toString() {
        return "TextTrack{id=" + this.id + ", label=" + this.label + ", language=" + this.language + "}";
    }
}
