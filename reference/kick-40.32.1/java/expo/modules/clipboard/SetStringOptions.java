package expo.modules.clipboard;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PEmptyArrays;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClipboardOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lexpo/modules/clipboard/SetStringOptions;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "<init>", "()V", "inputFormat", "Lexpo/modules/clipboard/StringFormat;", "getInputFormat$annotations", "getInputFormat", "()Lexpo/modules/clipboard/StringFormat;", "setInputFormat", "(Lexpo/modules/clipboard/StringFormat;)V", "isSensitive", "", "isSensitive$annotations", "()Z", "setSensitive", "(Z)V", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-clipboard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetStringOptions implements Record, PIntrospectionProvider {
    public StringFormat inputFormat = StringFormat.PLAIN;
    public boolean isSensitive;

    /* JADX INFO: compiled from: ClipboardOptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/clipboard/SetStringOptions$__Pika;", "", "<init>", "()V", "expo-clipboard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<SetStringOptions> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(SetStringOptions.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("inputFormat", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(StringFormat.class, false, null), 0, __pika, true, true, false), new PProperty("isSensitive", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 1, __pika, true, true, false)}, PEmptyArrays.EMPTY_FUNCTIONS, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.clipboard.SetStringOptions");
                return ((SetStringOptions) obj).getInputFormat();
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.clipboard.SetStringOptions");
            return Boolean.valueOf(((SetStringOptions) obj).getIsSensitive());
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.clipboard.SetStringOptions");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.clipboard.StringFormat");
                ((SetStringOptions) obj).setInputFormat((StringFormat) obj2);
            } else {
                if (i != 1) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.clipboard.SetStringOptions");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((SetStringOptions) obj).setSensitive(((Boolean) obj2).booleanValue());
            }
        }
    }

    @Field
    public static /* synthetic */ void getInputFormat$annotations() {
    }

    @Field
    public static /* synthetic */ void isSensitive$annotations() {
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public final StringFormat getInputFormat() {
        return this.inputFormat;
    }

    public final void setInputFormat(StringFormat stringFormat) {
        Intrinsics.checkNotNullParameter(stringFormat, "<set-?>");
        this.inputFormat = stringFormat;
    }

    /* JADX INFO: renamed from: isSensitive, reason: from getter */
    public final boolean getIsSensitive() {
        return this.isSensitive;
    }

    public final void setSensitive(boolean z) {
        this.isSensitive = z;
    }
}
