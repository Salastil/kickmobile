package com.datadog.trace.api;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ResolverCacheConfig {
    private static final /* synthetic */ ResolverCacheConfig[] $VALUES = $values();
    public static final ResolverCacheConfig LARGE;
    public static final ResolverCacheConfig LEGACY;
    public static final ResolverCacheConfig MEMOS;
    public static final ResolverCacheConfig NO_MEMOS;
    public static final ResolverCacheConfig SMALL;

    public abstract int memoPoolSize();

    public abstract int noMatchesSize();

    public abstract int outlinePoolSize();

    public abstract int typePoolSize();

    private static /* synthetic */ ResolverCacheConfig[] $values() {
        return new ResolverCacheConfig[]{LARGE, MEMOS, NO_MEMOS, SMALL, LEGACY};
    }

    private ResolverCacheConfig(String str, int i) {
        super(str, i);
    }

    public static ResolverCacheConfig valueOf(String str) {
        return (ResolverCacheConfig) Enum.valueOf(ResolverCacheConfig.class, str);
    }

    public static ResolverCacheConfig[] values() {
        return (ResolverCacheConfig[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: com.datadog.trace.api.ResolverCacheConfig$1, reason: invalid class name */
    final enum AnonymousClass1 extends ResolverCacheConfig {
        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int memoPoolSize() {
            return 4096;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int noMatchesSize() {
            return 65536;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int outlinePoolSize() {
            return 256;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int typePoolSize() {
            return 64;
        }

        private AnonymousClass1(String str, int i) {
            super(str, i);
        }
    }

    static {
        LARGE = new AnonymousClass1("LARGE", 0);
        MEMOS = new AnonymousClass2("MEMOS", 1);
        NO_MEMOS = new AnonymousClass3("NO_MEMOS", 2);
        SMALL = new AnonymousClass4("SMALL", 3);
        LEGACY = new AnonymousClass5("LEGACY", 4);
    }

    /* JADX INFO: renamed from: com.datadog.trace.api.ResolverCacheConfig$2, reason: invalid class name */
    final enum AnonymousClass2 extends ResolverCacheConfig {
        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int memoPoolSize() {
            return 2048;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int noMatchesSize() {
            return 16384;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int outlinePoolSize() {
            return 128;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int typePoolSize() {
            return 32;
        }

        private AnonymousClass2(String str, int i) {
            super(str, i);
        }
    }

    /* JADX INFO: renamed from: com.datadog.trace.api.ResolverCacheConfig$3, reason: invalid class name */
    final enum AnonymousClass3 extends ResolverCacheConfig {
        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int memoPoolSize() {
            return 0;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int noMatchesSize() {
            return 0;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int outlinePoolSize() {
            return 256;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int typePoolSize() {
            return 32;
        }

        private AnonymousClass3(String str, int i) {
            super(str, i);
        }
    }

    /* JADX INFO: renamed from: com.datadog.trace.api.ResolverCacheConfig$4, reason: invalid class name */
    final enum AnonymousClass4 extends ResolverCacheConfig {
        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int memoPoolSize() {
            return 0;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int noMatchesSize() {
            return 0;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int outlinePoolSize() {
            return 32;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int typePoolSize() {
            return 16;
        }

        private AnonymousClass4(String str, int i) {
            super(str, i);
        }
    }

    /* JADX INFO: renamed from: com.datadog.trace.api.ResolverCacheConfig$5, reason: invalid class name */
    final enum AnonymousClass5 extends ResolverCacheConfig {
        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int memoPoolSize() {
            return 0;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int noMatchesSize() {
            return 0;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int outlinePoolSize() {
            return 0;
        }

        @Override // com.datadog.trace.api.ResolverCacheConfig
        public int typePoolSize() {
            return 64;
        }

        private AnonymousClass5(String str, int i) {
            super(str, i);
        }
    }
}
