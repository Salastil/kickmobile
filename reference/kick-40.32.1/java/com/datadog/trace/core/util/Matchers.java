package com.datadog.trace.core.util;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public final class Matchers {
    private Matchers() {
    }

    public static Matcher compileGlob(String str) {
        if (str == null || str.equals("*")) {
            return null;
        }
        if (isExact(str)) {
            return new ExactMatcher(str);
        }
        return new PatternMatcher(GlobPattern.globToRegexPattern(str));
    }

    public static boolean matches(Matcher matcher, String str) {
        return matcher == null || matcher.matches(str);
    }

    public static boolean matches(Matcher matcher, CharSequence charSequence) {
        return matcher == null || matcher.matches(charSequence);
    }

    static boolean isExact(String str) {
        return str.indexOf(42) == -1 && str.indexOf(63) == -1;
    }

    static final class ExactMatcher implements Matcher {
        private final String exact;

        ExactMatcher(String str) {
            this.exact = str;
        }

        @Override // com.datadog.trace.core.util.Matcher
        public boolean matches(String str) {
            return this.exact.equals(str);
        }

        @Override // com.datadog.trace.core.util.Matcher
        public boolean matches(CharSequence charSequence) {
            return this.exact.contentEquals(charSequence);
        }
    }

    static final class PatternMatcher implements Matcher {
        private final Pattern pattern;

        PatternMatcher(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // com.datadog.trace.core.util.Matcher
        public boolean matches(CharSequence charSequence) {
            return this.pattern.matcher(charSequence).matches();
        }

        @Override // com.datadog.trace.core.util.Matcher
        public boolean matches(String str) {
            return this.pattern.matcher(str).matches();
        }
    }
}
