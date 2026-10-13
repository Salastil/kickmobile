package com.google.re2j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class Pattern implements Serializable {
    public static final int CASE_INSENSITIVE = 1;
    public static final int DISABLE_UNICODE_GROUPS = 8;
    public static final int DOTALL = 2;
    public static final int LONGEST_MATCH = 16;
    public static final int MULTILINE = 4;
    private static final long serialVersionUID = 0;
    private final int flags;
    private final String pattern;
    private final transient RE2 re2;

    Pattern(String str, int i, RE2 re2) {
        if (str == null) {
            throw new NullPointerException("pattern is null");
        }
        if (re2 == null) {
            throw new NullPointerException("re2 is null");
        }
        this.pattern = str;
        this.flags = i;
        this.re2 = re2;
    }

    public void reset() {
        this.re2.reset();
    }

    public int flags() {
        return this.flags;
    }

    public String pattern() {
        return this.pattern;
    }

    RE2 re2() {
        return this.re2;
    }

    public static Pattern compile(String str) {
        return compile(str, str, 0);
    }

    public static Pattern compile(String str, int i) {
        String str2;
        if ((i & 1) != 0) {
            str2 = "(?i)" + str;
        } else {
            str2 = str;
        }
        if ((i & 2) != 0) {
            str2 = "(?s)" + str2;
        }
        if ((i & 4) != 0) {
            str2 = "(?m)" + str2;
        }
        if ((i & (-32)) != 0) {
            throw new IllegalArgumentException("Flags should only be a combination of MULTILINE, DOTALL, CASE_INSENSITIVE, DISABLE_UNICODE_GROUPS, LONGEST_MATCH");
        }
        return compile(str2, str, i);
    }

    private static Pattern compile(String str, String str2, int i) {
        return new Pattern(str2, i, RE2.compileImpl(str, (i & 8) != 0 ? 84 : 212, (i & 16) != 0));
    }

    public static boolean matches(String str, CharSequence charSequence) {
        return compile(str).matcher(charSequence).matches();
    }

    public static boolean matches(String str, byte[] bArr) {
        return compile(str).matcher(bArr).matches();
    }

    public boolean matches(String str) {
        return matcher(str).matches();
    }

    public boolean matches(byte[] bArr) {
        return matcher(bArr).matches();
    }

    public Matcher matcher(CharSequence charSequence) {
        return new Matcher(this, charSequence);
    }

    public Matcher matcher(byte[] bArr) {
        return new Matcher(this, MatcherInput.utf8(bArr));
    }

    Matcher matcher(MatcherInput matcherInput) {
        return new Matcher(this, matcherInput);
    }

    public String[] split(String str) {
        return split(str, 0);
    }

    public String[] split(String str, int i) {
        return split(new Matcher(this, str), i);
    }

    private String[] split(Matcher matcher, int i) {
        ArrayList arrayList = new ArrayList();
        int iEnd = 0;
        int i2 = 0;
        while (matcher.find()) {
            if (iEnd == 0 && matcher.end() == 0) {
                iEnd = matcher.end();
            } else {
                if (i > 0 && arrayList.size() == i - 1) {
                    break;
                }
                if (iEnd != matcher.start()) {
                    while (i2 > 0) {
                        arrayList.add("");
                        i2--;
                    }
                } else if (i == 0) {
                    i2++;
                    iEnd = matcher.end();
                }
                arrayList.add(matcher.substring(iEnd, matcher.start()));
                iEnd = matcher.end();
            }
        }
        if (i == 0 && iEnd != matcher.inputLength()) {
            while (i2 > 0) {
                arrayList.add("");
                i2--;
            }
            arrayList.add(matcher.substring(iEnd, matcher.inputLength()));
        }
        if (i != 0 || arrayList.isEmpty()) {
            arrayList.add(matcher.substring(iEnd, matcher.inputLength()));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static String quote(String str) {
        return RE2.quoteMeta(str);
    }

    public String toString() {
        return this.pattern;
    }

    public int groupCount() {
        return this.re2.numberOfCapturingGroups();
    }

    public Map<String, Integer> namedGroups() {
        return Collections.unmodifiableMap(this.re2.namedGroups);
    }

    Object readResolve() {
        return compile(this.pattern, this.flags);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Pattern pattern = (Pattern) obj;
            if (this.flags == pattern.flags && this.pattern.equals(pattern.pattern)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.pattern.hashCode() * 31) + this.flags;
    }
}
