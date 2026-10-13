package com.datadog.android.rum.internal.utils;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.tracking.ComponentPredicate;
import com.datadog.trace.bootstrap.instrumentation.api.Tags;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ComponentPredicateExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0080\b¢\u0006\u0002\u0010\u0006\u001aK\u0010\u0007\u001a\u00020\b\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b0\fH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"resolveViewName", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/datadog/android/rum/tracking/ComponentPredicate;", Tags.COMPONENT, "(Lcom/datadog/android/rum/tracking/ComponentPredicate;Ljava/lang/Object;)Ljava/lang/String;", "runIfValid", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "operation", "Lkotlin/Function1;", "(Lcom/datadog/android/rum/tracking/ComponentPredicate;Ljava/lang/Object;Lcom/datadog/android/api/InternalLogger;Lkotlin/jvm/functions/Function1;)V", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ComponentPredicateExtKt {
    public static final /* synthetic */ <T> void runIfValid(ComponentPredicate<T> componentPredicate, T component, InternalLogger internalLogger, Function1<? super T, Unit> operation) {
        Intrinsics.checkNotNullParameter(componentPredicate, "<this>");
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (componentPredicate.accept(component)) {
            try {
                operation.invoke(component);
            } catch (Exception e) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) AnonymousClass1.INSTANCE, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
    }

    /* JADX INFO: renamed from: com.datadog.android.rum.internal.utils.ComponentPredicateExtKt$runIfValid$1, reason: invalid class name */
    /* JADX INFO: compiled from: ComponentPredicateExt.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass1 extends Lambda implements Function0<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "Internal operation failed on ComponentPredicate";
        }
    }

    public static final /* synthetic */ <T> String resolveViewName(ComponentPredicate<T> componentPredicate, T component) {
        Intrinsics.checkNotNullParameter(componentPredicate, "<this>");
        Intrinsics.checkNotNullParameter(component, "component");
        String viewName = componentPredicate.getViewName(component);
        String str = viewName;
        return (str == null || StringsKt.isBlank(str)) ? ViewUtilsKt.resolveViewUrl(component) : viewName;
    }
}
