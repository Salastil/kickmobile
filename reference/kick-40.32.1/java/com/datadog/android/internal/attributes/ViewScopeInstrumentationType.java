package com.datadog.android.internal.attributes;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ViewScopeInstrumentationType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0006\u0007R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/datadog/android/internal/attributes/ViewScopeInstrumentationType;", "Lcom/datadog/android/internal/attributes/LocalAttribute$Constant;", "value", "", "getValue", "()Ljava/lang/String;", "Custom", "Native", "Lcom/datadog/android/internal/attributes/ViewScopeInstrumentationType$Custom;", "Lcom/datadog/android/internal/attributes/ViewScopeInstrumentationType$Native;", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ViewScopeInstrumentationType extends LocalAttribute.Constant {
    String getValue();

    /* JADX INFO: compiled from: ViewScopeInstrumentationType.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/internal/attributes/ViewScopeInstrumentationType$Native;", "", "Lcom/datadog/android/internal/attributes/ViewScopeInstrumentationType;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "key", "Lcom/datadog/android/internal/attributes/LocalAttribute$Key;", "getKey", "()Lcom/datadog/android/internal/attributes/LocalAttribute$Key;", "getValue", "()Ljava/lang/String;", "MANUAL", "COMPOSE", "ACTIVITY", "FRAGMENT", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Native implements ViewScopeInstrumentationType {
        MANUAL("manual"),
        COMPOSE("compose"),
        ACTIVITY("activity"),
        FRAGMENT("fragment");

        private final LocalAttribute.Key key = LocalAttribute.Key.VIEW_SCOPE_INSTRUMENTATION_TYPE;
        private final String value;

        Native(String str) {
            this.value = str;
        }

        @Override // com.datadog.android.internal.attributes.ViewScopeInstrumentationType
        public String getValue() {
            return this.value;
        }

        @Override // com.datadog.android.internal.attributes.LocalAttribute.Constant
        public LocalAttribute.Key getKey() {
            return this.key;
        }
    }

    /* JADX INFO: compiled from: ViewScopeInstrumentationType.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/datadog/android/internal/attributes/ViewScopeInstrumentationType$Custom;", "Lcom/datadog/android/internal/attributes/ViewScopeInstrumentationType;", "customValue", "", "(Ljava/lang/String;)V", "key", "Lcom/datadog/android/internal/attributes/LocalAttribute$Key;", "getKey", "()Lcom/datadog/android/internal/attributes/LocalAttribute$Key;", "value", "getValue", "()Ljava/lang/String;", "Companion", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Custom implements ViewScopeInstrumentationType {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String customValue;

        public Custom(String customValue) {
            Intrinsics.checkNotNullParameter(customValue, "customValue");
            this.customValue = customValue;
        }

        @Override // com.datadog.android.internal.attributes.ViewScopeInstrumentationType
        public String getValue() {
            return this.customValue;
        }

        @Override // com.datadog.android.internal.attributes.LocalAttribute.Constant
        public LocalAttribute.Key getKey() {
            return LocalAttribute.Key.VIEW_SCOPE_INSTRUMENTATION_TYPE;
        }

        /* JADX INFO: compiled from: ViewScopeInstrumentationType.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/internal/attributes/ViewScopeInstrumentationType$Custom$Companion;", "", "()V", "create", "Lcom/datadog/android/internal/attributes/ViewScopeInstrumentationType$Custom;", "type", "", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Custom create(String type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return new Custom(StringsKt.trim((CharSequence) type).toString());
            }
        }
    }
}
