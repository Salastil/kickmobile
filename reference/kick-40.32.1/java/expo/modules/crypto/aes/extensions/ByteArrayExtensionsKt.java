package expo.modules.crypto.aes.extensions;

import android.util.Base64;
import expo.modules.crypto.aes.enums.DataFormat;
import expo.modules.crypto.aes.enums.KeyEncoding;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ByteArrayExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a)\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0001\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\t*\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"copiedArray", "", "Ljava/nio/ByteBuffer;", "init", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "base64Encoded", "", "hexEncoded", "encoded", "encoding", "Lexpo/modules/crypto/aes/enums/KeyEncoding;", "formatted", "", "format", "Lexpo/modules/crypto/aes/enums/DataFormat;", "expo-crypto_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ByteArrayExtensionsKt {

    /* JADX INFO: compiled from: ByteArrayExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[KeyEncoding.values().length];
            try {
                iArr[KeyEncoding.HEX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KeyEncoding.BASE64.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DataFormat.values().length];
            try {
                iArr2[DataFormat.BYTES.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[DataFormat.BASE64.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final byte[] copiedArray(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static final byte[] init(byte[] bArr, Function1<? super ByteBuffer, Unit> block) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNull(byteBufferWrap);
        block.invoke(byteBufferWrap);
        return bArr;
    }

    public static final String base64Encoded(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        String strEncodeToString = Base64.encodeToString(bArr, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    public static final String hexEncoded(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: expo.modules.crypto.aes.extensions.ByteArrayExtensionsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ByteArrayExtensionsKt.hexEncoded$lambda$3(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence hexEncoded$lambda$3(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String encoded(byte[] bArr, KeyEncoding encoding) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        int i = WhenMappings.$EnumSwitchMapping$0[encoding.ordinal()];
        if (i == 1) {
            return hexEncoded(bArr);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return base64Encoded(bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object formatted(byte[] bArr, DataFormat dataFormat) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i = dataFormat == null ? -1 : WhenMappings.$EnumSwitchMapping$1[dataFormat.ordinal()];
        if (i == -1 || i == 1) {
            return (Serializable) bArr;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return base64Encoded(bArr);
    }
}
