package com.datadog.android.api.feature;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.datastore.DataStoreHandler;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FeatureScope.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H&J\u0017\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000bH&¢\u0006\u0002\u0010\fJ;\u0010\r\u001a\u00020\u00072\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0012H'Jl\u0010\u0017\u001a\u00020\u00072\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2R\u0010\u0011\u001aN\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012/\u0012-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00070\u0012\u0012\u0004\u0012\u00020\u00070\u0012j\u0002`\u001a¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00070\u0018H'Jl\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2R\u0010\u0011\u001aN\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012/\u0012-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00070\u0012\u0012\u0004\u0012\u00020\u00070\u0012j\u0002`\u001a¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00070\u0018H'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/api/feature/FeatureScope;", "", "dataStore", "Lcom/datadog/android/api/storage/datastore/DataStoreHandler;", "getDataStore", "()Lcom/datadog/android/api/storage/datastore/DataStoreHandler;", "sendEvent", "", "event", "unwrap", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/datadog/android/api/feature/Feature;", "()Lcom/datadog/android/api/feature/Feature;", "withContext", "withFeatureContexts", "", "", "callback", "Lkotlin/Function1;", "Lcom/datadog/android/api/context/DatadogContext;", "Lkotlin/ParameterName;", "name", "datadogContext", "withWriteContext", "Lkotlin/Function2;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "Lcom/datadog/android/api/feature/EventWriteScope;", "write", "withWriteContextSync", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FeatureScope {
    DataStoreHandler getDataStore();

    void sendEvent(Object event);

    <T extends Feature> T unwrap();

    void withContext(Set<String> withFeatureContexts, Function1<? super DatadogContext, Unit> callback);

    void withWriteContext(Set<String> withFeatureContexts, Function2<? super DatadogContext, ? super Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>, Unit> callback);

    boolean withWriteContextSync(Set<String> withFeatureContexts, Function2<? super DatadogContext, ? super Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>, Unit> callback);

    /* JADX INFO: compiled from: FeatureScope.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void withWriteContext$default(FeatureScope featureScope, Set set, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withWriteContext");
            }
            if ((i & 1) != 0) {
                set = SetsKt.emptySet();
            }
            featureScope.withWriteContext(set, function2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void withContext$default(FeatureScope featureScope, Set set, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withContext");
            }
            if ((i & 1) != 0) {
                set = SetsKt.emptySet();
            }
            featureScope.withContext(set, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean withWriteContextSync$default(FeatureScope featureScope, Set set, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withWriteContextSync");
            }
            if ((i & 1) != 0) {
                set = SetsKt.emptySet();
            }
            return featureScope.withWriteContextSync(set, function2);
        }
    }
}
