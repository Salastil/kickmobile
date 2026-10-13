package com.datadog.trace.core.util;

import androidx.compose.runtime.GapComposerKt;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class GlobPattern {
    public static Pattern globToRegexPattern(String str) {
        return Pattern.compile(globToRegex(str));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x003a  */
    /* JADX WARN: Switch 'out' block B:17:0x003a for B:11:0x0023 already processed. Defaulting to fallback option. */
    /* JADX WARN: Switch 'out' block B:17:0x003a for B:12:0x0026 already processed. Defaulting to fallback option. */
    private static String globToRegex(String str) {
        StringBuilder sb = new StringBuilder(64);
        sb.append('^');
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '$' && cCharAt != '.') {
                if (cCharAt == '?') {
                    sb.append(FilenameUtils.EXTENSION_SEPARATOR);
                } else {
                    switch (cCharAt) {
                        case '(':
                        case ')':
                            sb.append("\\");
                            sb.append(cCharAt);
                            break;
                        case '*':
                            sb.append(".*");
                            continue;
                        default:
                            switch (cCharAt) {
                                default:
                                    switch (cCharAt) {
                                        case '{':
                                        case '|':
                                        case GapComposerKt.nodeKey /* 125 */:
                                            break;
                                        default:
                                            sb.append(cCharAt);
                                            continue;
                                    }
                                case '[':
                                case '\\':
                                case ']':
                                case '^':
                                    sb.append("\\");
                                    sb.append(cCharAt);
                                    break;
                            }
                            break;
                    }
                }
            } else {
                sb.append("\\");
                sb.append(cCharAt);
            }
        }
        sb.append(Typography.dollar);
        return sb.toString();
    }

    private GlobPattern() {
    }
}
