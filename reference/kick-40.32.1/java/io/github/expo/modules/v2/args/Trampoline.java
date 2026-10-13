package io.github.expo.modules.v2.args;

import androidx.emoji2.text.flatbuffer.Utf8Old$$ExternalSyntheticThreadLocal1;
import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.binary.BinaryBufferExtensionKt;
import io.github.expo.modules.v2.converters.TypeConverter;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Trampoline.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\n\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005H\u0007J\u0015\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010%H\u0007¢\u0006\u0002\u0010&J\u001a\u0010'\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010(\u001a\u00020)H\u0007J)\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010(\u001a\u00020)H\u0000¢\u0006\u0004\b,\u0010-J\n\u0010.\u001a\u0004\u0018\u00010\u0001H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R2\u0010\b\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR2\u0010\u000f\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00100\u0010 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R2\u0010\u0017\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00180\u0018 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\n \u000b*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR2\u0010\u001c\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u001d0\u001d \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\n \u000b*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lio/github/expo/modules/v2/args/Trampoline;", "", "<init>", "()V", "MAX_ARGUMENTS", "", "OVERFLOW_ARGUMENTS", "OVERFLOW_RESULT", "_overflowArguments", "Ljava/lang/ThreadLocal;", "io/github/expo/modules/v2/args/Trampoline$_overflowArguments$1$1", "kotlin.jvm.PlatformType", "overflowArguments", "getOverflowArguments", "()Lio/github/expo/modules/v2/args/Trampoline$_overflowArguments$1$1;", "_overflowResult", "io/github/expo/modules/v2/args/Trampoline$_overflowResult$1$1", "value", "overflowResult", "getOverflowResult", "()Ljava/lang/Object;", "setOverflowResult", "(Ljava/lang/Object;)V", "_argumentsView", "Lio/github/expo/modules/v2/args/BufferTrampolineArguments;", "argumentsView", "getArgumentsView", "()Lio/github/expo/modules/v2/args/BufferTrampolineArguments;", "_resultView", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "resultView", "getResultView-Oo0jTjA", "()Ljava/nio/ByteBuffer;", "arguments", "Lio/github/expo/modules/v2/args/TrampolineArguments;", "payloadLength", "prepareOverflowArguments", "", "()[Ljava/lang/Object;", "writeResult", "type", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "writeResultTo", "buf", "writeResultTo-i6ZDxrg$react_release", "(Ljava/nio/ByteBuffer;Ljava/lang/Object;Lio/github/expo/modules/v2/types/TypeDescriptor;)I", "takeOverflowResult", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Trampoline {
    public static final int MAX_ARGUMENTS = 8;
    public static final int OVERFLOW_ARGUMENTS = -1;
    public static final int OVERFLOW_RESULT = -1;
    public static final Trampoline INSTANCE = new Trampoline();
    private static final ThreadLocal<Trampoline$_overflowArguments$1$1> _overflowArguments = new Utf8Old$$ExternalSyntheticThreadLocal1(new Supplier() { // from class: io.github.expo.modules.v2.args.Trampoline$$ExternalSyntheticLambda0
        @Override // java.util.function.Supplier
        public final Object get() {
            return Trampoline._overflowArguments$lambda$0();
        }
    });
    private static final ThreadLocal<Trampoline$_overflowResult$1$1> _overflowResult = new Utf8Old$$ExternalSyntheticThreadLocal1(new Supplier() { // from class: io.github.expo.modules.v2.args.Trampoline$$ExternalSyntheticLambda1
        @Override // java.util.function.Supplier
        public final Object get() {
            return Trampoline._overflowResult$lambda$1();
        }
    });
    private static final ThreadLocal<BufferTrampolineArguments> _argumentsView = new Utf8Old$$ExternalSyntheticThreadLocal1(new Supplier() { // from class: io.github.expo.modules.v2.args.Trampoline$$ExternalSyntheticLambda2
        @Override // java.util.function.Supplier
        public final Object get() {
            return Trampoline._argumentsView$lambda$2();
        }
    });
    private static final ThreadLocal<BinaryBuffer> _resultView = new Utf8Old$$ExternalSyntheticThreadLocal1(new Supplier() { // from class: io.github.expo.modules.v2.args.Trampoline$_resultView$1
        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            ByteBuffer byteBufferM12313getOo0jTjA = m12313getOo0jTjA();
            if (byteBufferM12313getOo0jTjA != null) {
                return BinaryBuffer.m12244boximpl(byteBufferM12313getOo0jTjA);
            }
            return null;
        }

        /* JADX INFO: renamed from: get-Oo0jTjA, reason: not valid java name */
        public final ByteBuffer m12313getOo0jTjA() {
            return BinaryBufferExtensionKt.newSharedView$default(BinaryBuffer.INSTANCE, 0, 1, null);
        }
    });

    private Trampoline() {
    }

    static final Trampoline$_overflowArguments$1$1 _overflowArguments$lambda$0() {
        return new Trampoline$_overflowArguments$1$1();
    }

    private final Trampoline$_overflowArguments$1$1 getOverflowArguments() {
        return _overflowArguments.get();
    }

    static final Trampoline$_overflowResult$1$1 _overflowResult$lambda$1() {
        return new Trampoline$_overflowResult$1$1();
    }

    private final Object getOverflowResult() {
        return _overflowResult.get().getValue();
    }

    private final void setOverflowResult(Object obj) {
        _overflowResult.get().setValue(obj);
    }

    static final BufferTrampolineArguments _argumentsView$lambda$2() {
        return new BufferTrampolineArguments(BinaryBufferExtensionKt.newSharedView$default(BinaryBuffer.INSTANCE, 0, 1, null), null);
    }

    private final BufferTrampolineArguments getArgumentsView() {
        return _argumentsView.get();
    }

    /* JADX INFO: renamed from: getResultView-Oo0jTjA, reason: not valid java name */
    private final ByteBuffer m12311getResultViewOo0jTjA() {
        BinaryBuffer binaryBuffer = _resultView.get();
        ByteBuffer buffer = binaryBuffer != null ? binaryBuffer.getBuffer() : null;
        Intrinsics.checkNotNull(buffer != null ? BinaryBuffer.m12244boximpl(buffer) : null);
        BinaryBufferExtensionKt.m12315rewinduOnPpUM$default(buffer, 0, 1, null);
        if (binaryBuffer != null) {
            return binaryBuffer.getBuffer();
        }
        return null;
    }

    @JvmStatic
    public static final TrampolineArguments arguments(int payloadLength) {
        if (payloadLength == -1) {
            return new OverflowTrampolineArguments(INSTANCE.getOverflowArguments().getSlots());
        }
        BufferTrampolineArguments argumentsView = INSTANCE.getArgumentsView();
        argumentsView.rewind(payloadLength);
        Intrinsics.checkNotNullExpressionValue(argumentsView, "also(...)");
        return argumentsView;
    }

    @JvmStatic
    public static final Object[] prepareOverflowArguments() {
        return INSTANCE.getOverflowArguments().prepare();
    }

    @JvmStatic
    public static final int writeResult(Object value, TypeDescriptor type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Trampoline trampoline = INSTANCE;
        ByteBuffer byteBufferM12311getResultViewOo0jTjA = trampoline.m12311getResultViewOo0jTjA();
        BinaryBuffer binaryBufferM12244boximpl = byteBufferM12311getResultViewOo0jTjA != null ? BinaryBuffer.m12244boximpl(byteBufferM12311getResultViewOo0jTjA) : null;
        Intrinsics.checkNotNullExpressionValue(binaryBufferM12244boximpl, "getResultView-Oo0jTjA(...)");
        return trampoline.m12312writeResultToi6ZDxrg$react_release(binaryBufferM12244boximpl.getBuffer(), value, type);
    }

    @JvmStatic
    public static final Object takeOverflowResult() {
        return INSTANCE.getOverflowResult();
    }

    /* JADX INFO: renamed from: writeResultTo-i6ZDxrg$react_release, reason: not valid java name */
    public final int m12312writeResultToi6ZDxrg$react_release(ByteBuffer buf, Object value, TypeDescriptor type) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        Intrinsics.checkNotNullParameter(type, "type");
        TypeConverter<?> converter = type.getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        try {
            converter.mo12333writeToBufferuOnPpUM(buf, value);
            return BinaryBuffer.m12269getPositionimpl(buf);
        } catch (BufferOverflowException unused) {
            if (!converter.isPassthrough()) {
                value = converter.toJni(value);
            }
            setOverflowResult(value);
            return -1;
        }
    }
}
