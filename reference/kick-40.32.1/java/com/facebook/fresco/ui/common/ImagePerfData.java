package com.facebook.fresco.ui.common;

import com.facebook.common.internal.Objects;
import io.ktor.http.LinkHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePerfData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bF\u0018\u0000 s2\u00020\u0001:\u0001sB\u0087\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010!\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010%\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010*\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0.0-\u0012\u0006\u0010/\u001a\u00020\u0014\u0012\b\u00100\u001a\u0004\u0018\u00010\u0005\u0012\b\u00101\u001a\u0004\u0018\u00010\u0005\u0012\b\u00102\u001a\u0004\u0018\u00010\u0016\u0012\b\u00103\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u00104\u001a\u00020\u000b¢\u0006\u0004\b5\u00106J\u0006\u0010r\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010:R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b?\u0010=R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010AR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bC\u0010AR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bD\u0010AR\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bE\u0010AR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010AR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010I\u001a\u0004\bG\u0010HR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010I\u001a\u0004\bJ\u0010HR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010KR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\u0017\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bN\u0010MR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0011\u0010\u001c\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bS\u0010AR\u0011\u0010\u001d\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bT\u0010AR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bY\u0010:R\u0013\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010:R\u001b\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010%¢\u0006\n\n\u0002\u0010]\u001a\u0004\b[\u0010\\R\u0013\u0010&\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b^\u0010:R\u0013\u0010'\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u0010:R\u0013\u0010(\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b`\u0010:R\u0013\u0010)\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\ba\u0010:R\u0015\u0010*\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010I\u001a\u0004\bb\u0010HR\u0013\u0010+\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bc\u0010:R#\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0.0-¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0011\u0010/\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bf\u0010KR\u0013\u00100\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bg\u0010:R\u0013\u00101\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bh\u0010:R\u0015\u00102\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010k\u001a\u0004\bi\u0010jR\u0015\u00103\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010k\u001a\u0004\bl\u0010jR\u0011\u00104\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bm\u0010AR\u0011\u0010n\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bo\u0010MR\u0011\u0010p\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bq\u0010A¨\u0006t"}, d2 = {"Lcom/facebook/fresco/ui/common/ImagePerfData;", "", "infra", "Lcom/facebook/fresco/ui/common/ImageRenderingInfra;", "controllerId", "", "requestId", "imageRequest", "callerContext", "imageInfo", "controllerSubmitTimeMs", "", "intermediateImageLoadTimeMs", "controllerFinalImageSetTimeMs", "controllerFailureTimeMs", "imageRequestStartTimeMs", "imageRequestEndTimeMs", "emptyEventTimestampNs", "releasedEventTimestampNs", "isPrefetch", "", "onScreenWidthPx", "", "onScreenHeightPx", "errorThrowable", "", "visibilityState", "Lcom/facebook/fresco/ui/common/VisibilityState;", "visibilityEventTimeMs", "invisibilityEventTimeMs", "dimensionsInfo", "Lcom/facebook/fresco/ui/common/DimensionsInfo;", "extraData", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "callingClassNameOnVisible", "rootContextNameOnVisible", "contextChainArrayOnVisible", "", "contextChainExtrasOnVisible", "contentIdOnVisible", "surfaceOnVisible", "subSurfaceOnVisible", "msSinceLastNavigationOnVisible", "startupStatusOnVisible", "intermediateImageSetTimes", "", "Lkotlin/Pair;", "newIntermediateImageSetPointAvailable", "errorMessageOnFailure", "errorStacktraceStringOnFailure", "errorCodeOnFailure", "densityDpiOnSuccess", "fallbackImageSetTimeMs", "<init>", "(Lcom/facebook/fresco/ui/common/ImageRenderingInfra;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;JJJJJJLjava/lang/Long;Ljava/lang/Long;ZIILjava/lang/Throwable;Lcom/facebook/fresco/ui/common/VisibilityState;JJLcom/facebook/fresco/ui/common/DimensionsInfo;Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;J)V", "getInfra", "()Lcom/facebook/fresco/ui/common/ImageRenderingInfra;", "getControllerId", "()Ljava/lang/String;", "getRequestId", "getImageRequest", "()Ljava/lang/Object;", "getCallerContext", "getImageInfo", "getControllerSubmitTimeMs", "()J", "getIntermediateImageLoadTimeMs", "getControllerFinalImageSetTimeMs", "getControllerFailureTimeMs", "getImageRequestStartTimeMs", "getImageRequestEndTimeMs", "getEmptyEventTimestampNs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReleasedEventTimestampNs", "()Z", "getOnScreenWidthPx", "()I", "getOnScreenHeightPx", "getErrorThrowable", "()Ljava/lang/Throwable;", "getVisibilityState", "()Lcom/facebook/fresco/ui/common/VisibilityState;", "getVisibilityEventTimeMs", "getInvisibilityEventTimeMs", "getDimensionsInfo", "()Lcom/facebook/fresco/ui/common/DimensionsInfo;", "getExtraData", "()Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "getCallingClassNameOnVisible", "getRootContextNameOnVisible", "getContextChainArrayOnVisible", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getContextChainExtrasOnVisible", "getContentIdOnVisible", "getSurfaceOnVisible", "getSubSurfaceOnVisible", "getMsSinceLastNavigationOnVisible", "getStartupStatusOnVisible", "getIntermediateImageSetTimes", "()Ljava/util/List;", "getNewIntermediateImageSetPointAvailable", "getErrorMessageOnFailure", "getErrorStacktraceStringOnFailure", "getErrorCodeOnFailure", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDensityDpiOnSuccess", "getFallbackImageSetTimeMs", "instanceId", "getInstanceId", "finalImageLoadTimeMs", "getFinalImageLoadTimeMs", "createDebugString", "Companion", "ui-common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImagePerfData {
    public static final long UNSET = -1;
    private final Object callerContext;
    private final String callingClassNameOnVisible;
    private final String contentIdOnVisible;
    private final String[] contextChainArrayOnVisible;
    private final String contextChainExtrasOnVisible;
    private final long controllerFailureTimeMs;
    private final long controllerFinalImageSetTimeMs;
    private final String controllerId;
    private final long controllerSubmitTimeMs;
    private final Integer densityDpiOnSuccess;
    private final DimensionsInfo dimensionsInfo;
    private final Long emptyEventTimestampNs;
    private final Integer errorCodeOnFailure;
    private final String errorMessageOnFailure;
    private final String errorStacktraceStringOnFailure;
    private final Throwable errorThrowable;
    private final ControllerListener2.Extras extraData;
    private final long fallbackImageSetTimeMs;
    private final Object imageInfo;
    private final Object imageRequest;
    private final long imageRequestEndTimeMs;
    private final long imageRequestStartTimeMs;
    private final ImageRenderingInfra infra;
    private final int instanceId;
    private final long intermediateImageLoadTimeMs;
    private final List<Pair<String, Long>> intermediateImageSetTimes;
    private final long invisibilityEventTimeMs;
    private final boolean isPrefetch;
    private final Long msSinceLastNavigationOnVisible;
    private final boolean newIntermediateImageSetPointAvailable;
    private final int onScreenHeightPx;
    private final int onScreenWidthPx;
    private final Long releasedEventTimestampNs;
    private final String requestId;
    private final String rootContextNameOnVisible;
    private final String startupStatusOnVisible;
    private final String subSurfaceOnVisible;
    private final String surfaceOnVisible;
    private final long visibilityEventTimeMs;
    private final VisibilityState visibilityState;

    public ImagePerfData(ImageRenderingInfra infra, String str, String str2, Object obj, Object obj2, Object obj3, long j, long j2, long j3, long j4, long j5, long j6, Long l, Long l2, boolean z, int i, int i2, Throwable th, VisibilityState visibilityState, long j7, long j8, DimensionsInfo dimensionsInfo, ControllerListener2.Extras extras, String str3, String str4, String[] strArr, String str5, String str6, String str7, String str8, Long l3, String str9, List<Pair<String, Long>> intermediateImageSetTimes, boolean z2, String str10, String str11, Integer num, Integer num2, long j9) {
        Intrinsics.checkNotNullParameter(infra, "infra");
        Intrinsics.checkNotNullParameter(visibilityState, "visibilityState");
        Intrinsics.checkNotNullParameter(intermediateImageSetTimes, "intermediateImageSetTimes");
        this.infra = infra;
        this.controllerId = str;
        this.requestId = str2;
        this.imageRequest = obj;
        this.callerContext = obj2;
        this.imageInfo = obj3;
        this.controllerSubmitTimeMs = j;
        this.intermediateImageLoadTimeMs = j2;
        this.controllerFinalImageSetTimeMs = j3;
        this.controllerFailureTimeMs = j4;
        this.imageRequestStartTimeMs = j5;
        this.imageRequestEndTimeMs = j6;
        this.emptyEventTimestampNs = l;
        this.releasedEventTimestampNs = l2;
        this.isPrefetch = z;
        this.onScreenWidthPx = i;
        this.onScreenHeightPx = i2;
        this.errorThrowable = th;
        this.visibilityState = visibilityState;
        this.visibilityEventTimeMs = j7;
        this.invisibilityEventTimeMs = j8;
        this.dimensionsInfo = dimensionsInfo;
        this.extraData = extras;
        this.callingClassNameOnVisible = str3;
        this.rootContextNameOnVisible = str4;
        this.contextChainArrayOnVisible = strArr;
        this.contextChainExtrasOnVisible = str5;
        this.contentIdOnVisible = str6;
        this.surfaceOnVisible = str7;
        this.subSurfaceOnVisible = str8;
        this.msSinceLastNavigationOnVisible = l3;
        this.startupStatusOnVisible = str9;
        this.intermediateImageSetTimes = intermediateImageSetTimes;
        this.newIntermediateImageSetPointAvailable = z2;
        this.errorMessageOnFailure = str10;
        this.errorStacktraceStringOnFailure = str11;
        this.errorCodeOnFailure = num;
        this.densityDpiOnSuccess = num2;
        this.fallbackImageSetTimeMs = j9;
        this.instanceId = str != null ? str.hashCode() : 0;
    }

    public /* synthetic */ ImagePerfData(ImageRenderingInfra imageRenderingInfra, String str, String str2, Object obj, Object obj2, Object obj3, long j, long j2, long j3, long j4, long j5, long j6, Long l, Long l2, boolean z, int i, int i2, Throwable th, VisibilityState visibilityState, long j7, long j8, DimensionsInfo dimensionsInfo, ControllerListener2.Extras extras, String str3, String str4, String[] strArr, String str5, String str6, String str7, String str8, Long l3, String str9, List list, boolean z2, String str10, String str11, Integer num, Integer num2, long j9, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageRenderingInfra, str, str2, obj, obj2, obj3, j, j2, j3, j4, j5, j6, l, l2, z, i, i2, th, visibilityState, j7, j8, dimensionsInfo, extras, str3, str4, strArr, str5, str6, str7, str8, l3, str9, list, z2, str10, str11, num, num2, (i4 & 64) != 0 ? -1L : j9);
    }

    public final ImageRenderingInfra getInfra() {
        return this.infra;
    }

    public final String getControllerId() {
        return this.controllerId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final Object getImageRequest() {
        return this.imageRequest;
    }

    public final Object getCallerContext() {
        return this.callerContext;
    }

    public final Object getImageInfo() {
        return this.imageInfo;
    }

    public final long getControllerSubmitTimeMs() {
        return this.controllerSubmitTimeMs;
    }

    public final long getIntermediateImageLoadTimeMs() {
        return this.intermediateImageLoadTimeMs;
    }

    public final long getControllerFinalImageSetTimeMs() {
        return this.controllerFinalImageSetTimeMs;
    }

    public final long getControllerFailureTimeMs() {
        return this.controllerFailureTimeMs;
    }

    public final long getImageRequestStartTimeMs() {
        return this.imageRequestStartTimeMs;
    }

    public final long getImageRequestEndTimeMs() {
        return this.imageRequestEndTimeMs;
    }

    public final Long getEmptyEventTimestampNs() {
        return this.emptyEventTimestampNs;
    }

    public final Long getReleasedEventTimestampNs() {
        return this.releasedEventTimestampNs;
    }

    /* JADX INFO: renamed from: isPrefetch, reason: from getter */
    public final boolean getIsPrefetch() {
        return this.isPrefetch;
    }

    public final int getOnScreenWidthPx() {
        return this.onScreenWidthPx;
    }

    public final int getOnScreenHeightPx() {
        return this.onScreenHeightPx;
    }

    public final Throwable getErrorThrowable() {
        return this.errorThrowable;
    }

    public final VisibilityState getVisibilityState() {
        return this.visibilityState;
    }

    public final long getVisibilityEventTimeMs() {
        return this.visibilityEventTimeMs;
    }

    public final long getInvisibilityEventTimeMs() {
        return this.invisibilityEventTimeMs;
    }

    public final DimensionsInfo getDimensionsInfo() {
        return this.dimensionsInfo;
    }

    public final ControllerListener2.Extras getExtraData() {
        return this.extraData;
    }

    public final String getCallingClassNameOnVisible() {
        return this.callingClassNameOnVisible;
    }

    public final String getRootContextNameOnVisible() {
        return this.rootContextNameOnVisible;
    }

    public final String[] getContextChainArrayOnVisible() {
        return this.contextChainArrayOnVisible;
    }

    public final String getContextChainExtrasOnVisible() {
        return this.contextChainExtrasOnVisible;
    }

    public final String getContentIdOnVisible() {
        return this.contentIdOnVisible;
    }

    public final String getSurfaceOnVisible() {
        return this.surfaceOnVisible;
    }

    public final String getSubSurfaceOnVisible() {
        return this.subSurfaceOnVisible;
    }

    public final Long getMsSinceLastNavigationOnVisible() {
        return this.msSinceLastNavigationOnVisible;
    }

    public final String getStartupStatusOnVisible() {
        return this.startupStatusOnVisible;
    }

    public final List<Pair<String, Long>> getIntermediateImageSetTimes() {
        return this.intermediateImageSetTimes;
    }

    public final boolean getNewIntermediateImageSetPointAvailable() {
        return this.newIntermediateImageSetPointAvailable;
    }

    public final String getErrorMessageOnFailure() {
        return this.errorMessageOnFailure;
    }

    public final String getErrorStacktraceStringOnFailure() {
        return this.errorStacktraceStringOnFailure;
    }

    public final Integer getErrorCodeOnFailure() {
        return this.errorCodeOnFailure;
    }

    public final Integer getDensityDpiOnSuccess() {
        return this.densityDpiOnSuccess;
    }

    public final long getFallbackImageSetTimeMs() {
        return this.fallbackImageSetTimeMs;
    }

    public final int getInstanceId() {
        return this.instanceId;
    }

    public final long getFinalImageLoadTimeMs() {
        long j = this.imageRequestEndTimeMs;
        if (j != -1) {
            long j2 = this.imageRequestStartTimeMs;
            if (j2 != -1) {
                return j - j2;
            }
        }
        return -1L;
    }

    public final String createDebugString() {
        String string = Objects.toStringHelper(this).add("rendering Infra", this.infra).add("controller ID", this.controllerId).add("request ID", this.requestId).add("controller submit", this.controllerSubmitTimeMs).add("controller final image", this.controllerFinalImageSetTimeMs).add("controller failure", this.controllerFailureTimeMs).add("start time", this.imageRequestStartTimeMs).add("end time", this.imageRequestEndTimeMs).add(LinkHeader.Rel.Prefetch, this.isPrefetch).add("caller context", this.callerContext).add("image request", this.imageRequest).add("image info", this.imageInfo).add("on-screen width", this.onScreenWidthPx).add("on-screen height", this.onScreenHeightPx).add("visibility state", this.visibilityState).add("visibility event", this.visibilityEventTimeMs).add("invisibility event", this.invisibilityEventTimeMs).add("dimensions info", this.dimensionsInfo).add("extra data", this.extraData).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
