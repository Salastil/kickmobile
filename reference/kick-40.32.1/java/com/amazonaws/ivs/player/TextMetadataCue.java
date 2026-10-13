package com.amazonaws.ivs.player;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class TextMetadataCue extends Cue {
    public static final String INBAND_METADATA_ID = "inband.metadata.live-video.net";
    public static final String METADATA_ID = "metadata.live-video.net";
    public final String description;
    public final String owner;
    public final String text;

    public TextMetadataCue(long j, long j2, String str, String str2, String str3) {
        super(j, j2);
        this.description = str;
        this.text = str2;
        this.owner = str3;
    }

    @Override // com.amazonaws.ivs.player.Cue
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextMetadataCue) || !super.equals(obj)) {
            return false;
        }
        TextMetadataCue textMetadataCue = (TextMetadataCue) obj;
        return Objects.equals(this.description, textMetadataCue.description) && Objects.equals(this.text, textMetadataCue.text) && Objects.equals(this.owner, textMetadataCue.owner);
    }

    @Override // com.amazonaws.ivs.player.Cue
    public int hashCode() {
        return Objects.hash(Long.valueOf(this.startTime), Long.valueOf(this.endTime), this.description, this.text, this.owner);
    }
}
