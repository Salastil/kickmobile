package com.datadog.trace.core.propagation.ptags;

/* JADX INFO: loaded from: classes6.dex */
abstract class TagElement implements CharSequence {
    abstract CharSequence forType(Encoding encoding);

    TagElement() {
    }

    public enum Encoding {
        DATADOG("_dd.p."),
        W3C("t.");

        private static final Encoding[] cachedValues;
        private static final int numValues;
        private final String prefix;

        static {
            Encoding[] encodingArrValues = values();
            cachedValues = encodingArrValues;
            numValues = encodingArrValues.length;
        }

        Encoding(String str) {
            this.prefix = str;
        }

        public String getPrefix() {
            return this.prefix;
        }

        public int getPrefixLength() {
            return this.prefix.length();
        }

        static Encoding[] getCachedValues() {
            return cachedValues;
        }

        static int getNumValues() {
            return numValues;
        }
    }
}
