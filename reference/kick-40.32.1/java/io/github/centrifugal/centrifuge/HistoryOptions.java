package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class HistoryOptions {
    private final int limit;
    private final boolean reverse;
    private final StreamPosition since;

    private HistoryOptions(Builder builder) {
        this.limit = builder.limit;
        this.since = builder.since;
        this.reverse = builder.reverse;
    }

    public int getLimit() {
        return this.limit;
    }

    public StreamPosition getSince() {
        return this.since;
    }

    public boolean getReverse() {
        return this.reverse;
    }

    public String toString() {
        return "HistoryOptions: " + this.limit + ", " + this.since.toString() + ", reverse " + this.reverse;
    }

    public static class Builder {
        private int limit = 0;
        private StreamPosition since = null;
        private boolean reverse = false;

        public Builder withLimit(int i) {
            this.limit = i;
            return this;
        }

        public Builder withSince(StreamPosition streamPosition) {
            this.since = streamPosition;
            return this;
        }

        public Builder withReverse(boolean z) {
            this.reverse = z;
            return this;
        }

        public HistoryOptions build() {
            return new HistoryOptions(this);
        }
    }
}
