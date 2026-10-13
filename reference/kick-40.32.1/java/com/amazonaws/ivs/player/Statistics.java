package com.amazonaws.ivs.player;

/* JADX INFO: loaded from: classes5.dex */
public class Statistics {
    private int bitRate;
    private int decodedFrames;
    private int droppedFrames;
    private int frameRate;
    private int renderedFrames;

    public int getVideoBitRate() {
        return this.bitRate;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getDroppedFrames() {
        return this.droppedFrames;
    }

    public int getDecodedFrames() {
        return this.decodedFrames;
    }

    public int getRenderedFrames() {
        return this.renderedFrames;
    }

    public void setBitRate(int i) {
        this.bitRate = i;
    }

    public void setDecodedFrames(int i) {
        this.decodedFrames = i;
    }

    public void setDroppedFrames(int i) {
        this.droppedFrames = i;
    }

    public void setFrameRate(int i) {
        this.frameRate = i;
    }

    public void setRenderedFrames(int i) {
        this.renderedFrames = i;
    }

    public String toString() {
        return "Statistics: , bitRate=" + this.bitRate + ", frameRate=" + this.frameRate + ", decodedFrames=" + this.decodedFrames + ", droppedFrames=" + this.droppedFrames + ", renderedFrames=" + this.renderedFrames;
    }
}
