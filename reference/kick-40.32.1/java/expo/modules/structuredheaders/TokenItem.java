package expo.modules.structuredheaders;

import java.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public class TokenItem implements Item<String> {
    private final Parameters params;
    private final String value;

    private TokenItem(String str, Parameters parameters) {
        this.value = checkParam((String) Objects.requireNonNull(str, "value must not be null"));
        this.params = (Parameters) Objects.requireNonNull(parameters, "params must not be null");
    }

    public static TokenItem valueOf(String str) {
        return new TokenItem(str, Parameters.EMPTY);
    }

    @Override // expo.modules.structuredheaders.Item, expo.modules.structuredheaders.Parametrizable
    public TokenItem withParams(Parameters parameters) {
        return ((Parameters) Objects.requireNonNull(parameters, "params must not be null")).isEmpty() ? this : new TokenItem(this.value, parameters);
    }

    @Override // expo.modules.structuredheaders.Parametrizable
    public Parameters getParams() {
        return this.params;
    }

    @Override // expo.modules.structuredheaders.Type
    public StringBuilder serializeTo(StringBuilder sb) {
        sb.append(this.value);
        this.params.serializeTo(sb);
        return sb;
    }

    @Override // expo.modules.structuredheaders.Type
    public String serialize() {
        return serializeTo(new StringBuilder()).toString();
    }

    @Override // androidx.core.util.Supplier
    public String get() {
        return this.value;
    }

    private static String checkParam(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Token can not be empty");
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((i == 0 && cCharAt != '*' && !Utils.isAlpha(cCharAt)) || cCharAt <= ' ' || cCharAt >= 127 || "\"(),;<=>?@[\\]{}".indexOf(cCharAt) >= 0) {
                throw new IllegalArgumentException(String.format("Invalid character in Token at position %d: '%c' (0x%04x)", Integer.valueOf(i), Character.valueOf(cCharAt), Integer.valueOf(cCharAt)));
            }
        }
        return str;
    }
}
