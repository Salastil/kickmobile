package expo.modules.camera;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.AudioManager;
import android.media.MediaActionSound;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.Size;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraState;
import androidx.camera.core.DisplayOrientedMeteringPointFactory;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ZoomState;
import androidx.camera.core.resolutionselector.ResolutionFilter;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.lifecycle.ProcessCameraProviderExtKt;
import androidx.camera.video.FallbackStrategy;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.PendingRecording;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.LiveData;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.uimanager.ViewProps;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import expo.modules.camera.analyzers.BarcodeAnalyzer;
import expo.modules.camera.analyzers.BarcodeAnalyzerKt;
import expo.modules.camera.common.BarcodeScannedEvent;
import expo.modules.camera.common.CameraMountErrorEvent;
import expo.modules.camera.common.PictureSavedEvent;
import expo.modules.camera.common.RecordingProgressEvent;
import expo.modules.camera.records.BarcodeSettings;
import expo.modules.camera.records.BarcodeType;
import expo.modules.camera.records.CameraMode;
import expo.modules.camera.records.CameraRatio;
import expo.modules.camera.records.CameraType;
import expo.modules.camera.records.FlashMode;
import expo.modules.camera.records.FocusMode;
import expo.modules.camera.records.VideoQuality;
import expo.modules.camera.records.VideoStabilizationMode;
import expo.modules.camera.utils.BarCodeScannerResult;
import expo.modules.camera.utils.CameraUtils;
import expo.modules.camera.utils.FileSystemUtils;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.interfaces.camera.CameraViewInterface;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.runtime.Runtime;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoView;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: ExpoCameraView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000ÿ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u000e\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u009d\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u009e\u0001\u001a\u00020W2\u0007\u0010\u009f\u0001\u001a\u00020WH\u0014J7\u0010 \u0001\u001a\u00030\u0085\u00012\u0007\u0010¡\u0001\u001a\u00020+2\u0007\u0010¢\u0001\u001a\u00020W2\u0007\u0010£\u0001\u001a\u00020W2\u0007\u0010¤\u0001\u001a\u00020W2\u0007\u0010¥\u0001\u001a\u00020WH\u0014J\u0016\u0010¦\u0001\u001a\u00030\u0085\u00012\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0016J0\u0010©\u0001\u001a\u00030\u0085\u00012\b\u0010ª\u0001\u001a\u00030«\u00012\b\u0010¬\u0001\u001a\u00030\u00ad\u00012\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010°\u0001\u001a\u00030±\u0001J\u0011\u0010²\u0001\u001a\u00030\u0085\u00012\u0007\u0010³\u0001\u001a\u000209J\u0013\u0010´\u0001\u001a\u00030\u0085\u00012\u0007\u0010µ\u0001\u001a\u00020+H\u0002J&\u0010¶\u0001\u001a\u00030\u0085\u00012\b\u0010ª\u0001\u001a\u00030·\u00012\b\u0010¬\u0001\u001a\u00030\u00ad\u00012\b\u0010®\u0001\u001a\u00030¯\u0001J\b\u0010¸\u0001\u001a\u00030\u0085\u0001J\b\u0010¹\u0001\u001a\u00030\u0085\u0001J\b\u0010º\u0001\u001a\u00030\u0085\u0001J\u0011\u0010»\u0001\u001a\u00030\u0085\u0001H\u0082@¢\u0006\u0003\u0010¼\u0001J\u0011\u0010½\u0001\u001a\u00030\u0085\u0001H\u0083@¢\u0006\u0003\u0010¼\u0001J\t\u0010¾\u0001\u001a\u00020 H\u0002J\n\u0010¿\u0001\u001a\u00030\u0085\u0001H\u0002J\n\u0010À\u0001\u001a\u00030Á\u0001H\u0002J\u0015\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020jH\u0002J\u001c\u0010Å\u0001\u001a\t\u0012\u0004\u0012\u00020$0Æ\u00012\n\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u0001H\u0002J\u0015\u0010É\u0001\u001a\u00020+2\n\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030\u0085\u0001H\u0002J\u0012\u0010Ë\u0001\u001a\u00030\u0085\u00012\u0006\u00102\u001a\u00020EH\u0002J\u0014\u0010Ì\u0001\u001a\u00030\u0085\u00012\b\u0010Ç\u0001\u001a\u00030È\u0001H\u0002J\u000f\u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00020j0&H\u0007J\b\u0010Î\u0001\u001a\u00030\u0085\u0001J\b\u0010Ï\u0001\u001a\u00030\u0085\u0001J\u0011\u0010Ð\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u009c\u0001\u001a\u00020+J\u0014\u0010Ñ\u0001\u001a\u00030\u0085\u00012\n\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001J\u0014\u0010Ô\u0001\u001a\u00030\u0085\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0002JD\u0010×\u0001\u001a$\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030Ú\u00010Ù\u0001j\n\u0012\u0005\u0012\u00030Ú\u0001`Û\u0001\u0012\u0005\u0012\u00030Ú\u00010Ø\u00012\r\u0010Ü\u0001\u001a\b\u0012\u0004\u0012\u00020W0&2\b\u0010Ý\u0001\u001a\u00030Þ\u0001H\u0002J\u0014\u0010\u008e\u0001\u001a\u00030\u0085\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0002J\u0015\u0010ß\u0001\u001a\u00030\u0085\u00012\t\u0010à\u0001\u001a\u0004\u0018\u00010)H\u0016J\n\u0010á\u0001\u001a\u00030â\u0001H\u0016J\u0012\u0010\u0092\u0001\u001a\u00030\u0085\u00012\b\u0010ã\u0001\u001a\u00030Ú\u0001J\n\u0010ä\u0001\u001a\u00030å\u0001H\u0002J\b\u0010æ\u0001\u001a\u00030\u0085\u0001R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00104\u001a\u0002032\u0006\u00102\u001a\u000203@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010:\u001a\u0002092\u0006\u00102\u001a\u000209@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u00020?2\u0006\u00102\u001a\u00020?@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u00020E2\u0006\u00102\u001a\u00020E@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010L\u001a\u00020K2\u0006\u00102\u001a\u00020K@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010R\u001a\u00020Q2\u0006\u00102\u001a\u00020Q@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR*\u0010X\u001a\u0004\u0018\u00010W2\b\u00102\u001a\u0004\u0018\u00010W@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R$\u0010_\u001a\u00020^2\u0006\u00102\u001a\u00020^@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR(\u0010e\u001a\u0004\u0018\u00010d2\b\u00102\u001a\u0004\u0018\u00010d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR$\u0010k\u001a\u00020j2\u0006\u00102\u001a\u00020j@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010p\u001a\u00020+2\u0006\u00102\u001a\u00020+@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010r\"\u0004\bw\u0010tR\u001a\u0010x\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010r\"\u0004\bz\u0010tR,\u0010|\u001a\u00020+2\u0006\u0010{\u001a\u00020+8F@FX\u0086\u008e\u0002¢\u0006\u0013\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0004\b}\u0010r\"\u0004\b~\u0010tR\u000f\u0010\u0081\u0001\u001a\u00020WX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020WX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0083\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R(\u0010\u008a\u0001\u001a\n\u0012\u0005\u0012\u00030\u008b\u00010\u0084\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008d\u0001\u0010\u0089\u0001\u001a\u0006\b\u008c\u0001\u0010\u0087\u0001R(\u0010\u008e\u0001\u001a\n\u0012\u0005\u0012\u00030\u008f\u00010\u0084\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0089\u0001\u001a\u0006\b\u0090\u0001\u0010\u0087\u0001R(\u0010\u0092\u0001\u001a\n\u0012\u0005\u0012\u00030\u0093\u00010\u0084\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u0089\u0001\u001a\u0006\b\u0094\u0001\u0010\u0087\u0001R(\u0010\u0096\u0001\u001a\n\u0012\u0005\u0012\u00030\u0097\u00010\u0084\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0099\u0001\u0010\u0089\u0001\u001a\u0006\b\u0098\u0001\u0010\u0087\u0001R\u0010\u0010\u009a\u0001\u001a\u00030\u009b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0001\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ç\u0001"}, d2 = {"Lexpo/modules/camera/ExpoCameraView;", "Lexpo/modules/kotlin/views/ExpoView;", "Lexpo/modules/interfaces/camera/CameraViewInterface;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "currentActivity", "Landroidx/appcompat/app/AppCompatActivity;", "getCurrentActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "orientationEventListener", "expo/modules/camera/ExpoCameraView$orientationEventListener$2$1", "getOrientationEventListener", "()Lexpo/modules/camera/ExpoCameraView$orientationEventListener$2$1;", "orientationEventListener$delegate", "Lkotlin/Lazy;", "camera", "Landroidx/camera/core/Camera;", "getCamera", "()Landroidx/camera/core/Camera;", "setCamera", "(Landroidx/camera/core/Camera;)V", "activeRecording", "Landroidx/camera/video/Recording;", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "imageCaptureUseCase", "Landroidx/camera/core/ImageCapture;", "imageAnalysisUseCase", "Landroidx/camera/core/ImageAnalysis;", "barcodeAnalyzer", "Lexpo/modules/camera/analyzers/BarcodeAnalyzer;", "recorder", "Landroidx/camera/video/Recorder;", "barcodeFormats", "", "Lexpo/modules/camera/records/BarcodeType;", "glSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "isRecording", "", "previewView", "Landroidx/camera/view/PreviewView;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "shouldCreateCamera", "previewPaused", "value", "Lexpo/modules/camera/records/CameraType;", "lensFacing", "getLensFacing", "()Lexpo/modules/camera/records/CameraType;", "setLensFacing", "(Lexpo/modules/camera/records/CameraType;)V", "Lexpo/modules/camera/records/FlashMode;", "flashMode", "getFlashMode", "()Lexpo/modules/camera/records/FlashMode;", "setFlashMode", "(Lexpo/modules/camera/records/FlashMode;)V", "Lexpo/modules/camera/records/CameraMode;", "cameraMode", "getCameraMode", "()Lexpo/modules/camera/records/CameraMode;", "setCameraMode", "(Lexpo/modules/camera/records/CameraMode;)V", "", "zoom", "getZoom", "()F", "setZoom", "(F)V", "Lexpo/modules/camera/records/FocusMode;", "autoFocus", "getAutoFocus", "()Lexpo/modules/camera/records/FocusMode;", "setAutoFocus", "(Lexpo/modules/camera/records/FocusMode;)V", "Lexpo/modules/camera/records/VideoQuality;", "videoQuality", "getVideoQuality", "()Lexpo/modules/camera/records/VideoQuality;", "setVideoQuality", "(Lexpo/modules/camera/records/VideoQuality;)V", "", "videoEncodingBitrate", "getVideoEncodingBitrate", "()Ljava/lang/Integer;", "setVideoEncodingBitrate", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Lexpo/modules/camera/records/VideoStabilizationMode;", "videoStabilizationMode", "getVideoStabilizationMode", "()Lexpo/modules/camera/records/VideoStabilizationMode;", "setVideoStabilizationMode", "(Lexpo/modules/camera/records/VideoStabilizationMode;)V", "Lexpo/modules/camera/records/CameraRatio;", "ratio", "getRatio", "()Lexpo/modules/camera/records/CameraRatio;", "setRatio", "(Lexpo/modules/camera/records/CameraRatio;)V", "", "pictureSize", "getPictureSize", "()Ljava/lang/String;", "setPictureSize", "(Ljava/lang/String;)V", "mirror", "getMirror", "()Z", "setMirror", "(Z)V", "mute", "getMute", "setMute", "animateShutter", "getAnimateShutter", "setAnimateShutter", "<set-?>", "enableTorch", "getEnableTorch", "setEnableTorch", "enableTorch$delegate", "Lkotlin/properties/ReadWriteProperty;", "lastWidth", "lastHeight", "onCameraReady", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "", "getOnCameraReady", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onCameraReady$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "onMountError", "Lexpo/modules/camera/common/CameraMountErrorEvent;", "getOnMountError", "onMountError$delegate", "onBarcodeScanned", "Lexpo/modules/camera/common/BarcodeScannedEvent;", "getOnBarcodeScanned", "onBarcodeScanned$delegate", "onPictureSaved", "Lexpo/modules/camera/common/PictureSavedEvent;", "getOnPictureSaved", "onPictureSaved$delegate", "onRecordingProgress", "Lexpo/modules/camera/common/RecordingProgressEvent;", "getOnRecordingProgress", "onRecordingProgress$delegate", "lastRecordingProgressTimestamp", "", "shouldScanBarcodes", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "onViewAdded", "child", "Landroid/view/View;", "takePicture", "options", "Lexpo/modules/camera/PictureOptions;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "cacheDirectory", "Ljava/io/File;", "runtime", "Lexpo/modules/kotlin/runtime/Runtime;", "setCameraFlashMode", "mode", "setTorchEnabled", "enabled", "record", "Lexpo/modules/camera/RecordingOptions;", "stopRecording", "toggleRecording", "recreateCamera", "createCamera", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureAndBindCamera", "createImageAnalyzer", "releaseBarcodeAnalyzer", "buildResolutionSelector", "Landroidx/camera/core/resolutionselector/ResolutionSelector;", "parseSizeSafely", "Landroid/util/Size;", ContentDisposition.Parameters.Size, "createVideoCapture", "Landroidx/camera/video/VideoCapture;", "cameraInfo", "Landroidx/camera/core/CameraInfo;", "isVideoStabilizationEnabled", "startFocusMetering", "setCameraZoom", "observeCameraState", "getAvailablePictureSizes", "resumePreview", "pausePreview", "setShouldScanBarcodes", "setBarcodeScannerSettings", "settings", "Lexpo/modules/camera/records/BarcodeSettings;", "transformBarcodeScannerResultToViewCoordinates", OptionalModuleUtils.BARCODE, "Lexpo/modules/camera/utils/BarCodeScannerResult;", "getCornerPointsAndBoundingBox", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "cornerPoints", "boundingBox", "Lexpo/modules/camera/utils/BarCodeScannerResult$BoundingBox;", "setPreviewTexture", "surfaceTexture", "getPreviewSizeAsArray", "", "response", "cancelCoroutineScope", "", "cleanupCamera", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpoCameraView extends ExpoView implements CameraViewInterface {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ExpoCameraView.class, "enableTorch", "getEnableTorch()Z", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onCameraReady", "getOnCameraReady()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onMountError", "getOnMountError()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onBarcodeScanned", "getOnBarcodeScanned()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onPictureSaved", "getOnPictureSaved()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onRecordingProgress", "getOnRecordingProgress()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    private Recording activeRecording;
    private boolean animateShutter;
    private FocusMode autoFocus;
    private BarcodeAnalyzer barcodeAnalyzer;
    private List<? extends BarcodeType> barcodeFormats;
    private Camera camera;
    private CameraMode cameraMode;
    private ProcessCameraProvider cameraProvider;

    /* JADX INFO: renamed from: enableTorch$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty enableTorch;
    private FlashMode flashMode;
    private SurfaceTexture glSurfaceTexture;
    private ImageAnalysis imageAnalysisUseCase;
    private ImageCapture imageCaptureUseCase;
    private boolean isRecording;
    private int lastHeight;
    private long lastRecordingProgressTimestamp;
    private int lastWidth;
    private CameraType lensFacing;
    private boolean mirror;
    private boolean mute;

    /* JADX INFO: renamed from: onBarcodeScanned$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onBarcodeScanned;

    /* JADX INFO: renamed from: onCameraReady$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onCameraReady;

    /* JADX INFO: renamed from: onMountError$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onMountError;

    /* JADX INFO: renamed from: onPictureSaved$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onPictureSaved;

    /* JADX INFO: renamed from: onRecordingProgress$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onRecordingProgress;

    /* JADX INFO: renamed from: orientationEventListener$delegate, reason: from kotlin metadata */
    private final Lazy orientationEventListener;
    private String pictureSize;
    private boolean previewPaused;
    private PreviewView previewView;
    private CameraRatio ratio;
    private Recorder recorder;
    private final CoroutineScope scope;
    private boolean shouldCreateCamera;
    private boolean shouldScanBarcodes;
    private Integer videoEncodingBitrate;
    private VideoQuality videoQuality;
    private VideoStabilizationMode videoStabilizationMode;
    private float zoom;

    /* JADX INFO: compiled from: ExpoCameraView.kt */
    /* JADX INFO: loaded from: classes.dex */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CameraState.Type.values().length];
            try {
                iArr[CameraState.Type.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PreviewView.ScaleType.values().length];
            try {
                iArr2[PreviewView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[PreviewView.ScaleType.FILL_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: expo.modules.camera.ExpoCameraView$configureAndBindCamera$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExpoCameraView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.camera.ExpoCameraView", f = "ExpoCameraView.kt", i = {}, l = {471}, m = "configureAndBindCamera", n = {}, s = {})
    static final class C08081 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08081(Continuation<? super C08081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExpoCameraView.this.configureAndBindCamera(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.camera.ExpoCameraView$createCamera$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExpoCameraView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.camera.ExpoCameraView", f = "ExpoCameraView.kt", i = {}, l = {458}, m = "createCamera", n = {}, s = {})
    static final class C08091 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08091(Continuation<? super C08091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExpoCameraView.this.createCamera(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoCameraView(Context context, final AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.orientationEventListener = LazyKt.lazy(new Function0() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExpoCameraView.orientationEventListener_delegate$lambda$0(appContext, this);
            }
        });
        this.barcodeFormats = CollectionsKt.emptyList();
        PreviewView previewView = new PreviewView(context);
        previewView.setElevation(0.0f);
        this.previewView = previewView;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new ExpoCameraView$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE)));
        this.lensFacing = CameraType.BACK;
        this.flashMode = FlashMode.OFF;
        this.cameraMode = CameraMode.PICTURE;
        this.autoFocus = FocusMode.OFF;
        this.videoQuality = VideoQuality.VIDEO1080P;
        this.videoStabilizationMode = VideoStabilizationMode.AUTO;
        this.pictureSize = "";
        this.animateShutter = true;
        Delegates delegates = Delegates.INSTANCE;
        final boolean z = false;
        this.enableTorch = new ObservableProperty<Boolean>(z) { // from class: expo.modules.camera.ExpoCameraView$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                boolean zBooleanValue = newValue.booleanValue();
                oldValue.booleanValue();
                this.setTorchEnabled(zBooleanValue);
            }
        };
        ExpoCameraView expoCameraView = this;
        this.onCameraReady = new ViewEventDelegate(expoCameraView, null);
        this.onMountError = new ViewEventDelegate(expoCameraView, null);
        this.onBarcodeScanned = new ViewEventDelegate(expoCameraView, new Function1() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Short.valueOf(ExpoCameraView.onBarcodeScanned_delegate$lambda$5((BarcodeScannedEvent) obj));
            }
        });
        this.onPictureSaved = new ViewEventDelegate(expoCameraView, new Function1() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Short.valueOf(ExpoCameraView.onPictureSaved_delegate$lambda$6((PictureSavedEvent) obj));
            }
        });
        this.onRecordingProgress = new ViewEventDelegate(expoCameraView, null);
        getOrientationEventListener().enable();
        this.previewView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: expo.modules.camera.ExpoCameraView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View parent, View child) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View parent, View child) {
                if (parent != null) {
                    parent.measure(View.MeasureSpec.makeMeasureSpec(ExpoCameraView.this.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ExpoCameraView.this.getMeasuredHeight(), 1073741824));
                }
                if (parent != null) {
                    parent.layout(0, 0, parent.getMeasuredWidth(), parent.getMeasuredHeight());
                }
            }
        });
        addView(this.previewView, new ViewGroup.LayoutParams(-1, -1));
    }

    private final AppCompatActivity getCurrentActivity() throws Exceptions.MissingActivity {
        Activity throwingActivity = getAppContext().getThrowingActivity();
        Intrinsics.checkNotNull(throwingActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        return (AppCompatActivity) throwingActivity;
    }

    private final ExpoCameraView$orientationEventListener$2$1 getOrientationEventListener() {
        return (ExpoCameraView$orientationEventListener$2$1) this.orientationEventListener.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [expo.modules.camera.ExpoCameraView$orientationEventListener$2$1] */
    static final ExpoCameraView$orientationEventListener$2$1 orientationEventListener_delegate$lambda$0(AppContext appContext, final ExpoCameraView expoCameraView) throws Exceptions.MissingActivity {
        final Activity throwingActivity = appContext.getThrowingActivity();
        return new OrientationEventListener(throwingActivity) { // from class: expo.modules.camera.ExpoCameraView$orientationEventListener$2$1
            {
                super(throwingActivity);
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                int i;
                if (orientation == -1) {
                    return;
                }
                if (45 <= orientation && orientation < 135) {
                    i = 3;
                } else if (135 > orientation || orientation >= 225) {
                    i = (225 > orientation || orientation >= 315) ? 0 : 1;
                } else {
                    i = 2;
                }
                ImageAnalysis imageAnalysis = this.this$0.imageAnalysisUseCase;
                if (imageAnalysis != null) {
                    imageAnalysis.setTargetRotation(i);
                }
                ImageCapture imageCapture = this.this$0.imageCaptureUseCase;
                if (imageCapture != null) {
                    imageCapture.setTargetRotation(i);
                }
            }
        };
    }

    public final Camera getCamera() {
        return this.camera;
    }

    public final void setCamera(Camera camera) {
        this.camera = camera;
    }

    public final CameraType getLensFacing() {
        return this.lensFacing;
    }

    public final void setLensFacing(CameraType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.lensFacing = value;
        this.shouldCreateCamera = true;
    }

    public final FlashMode getFlashMode() {
        return this.flashMode;
    }

    public final void setFlashMode(FlashMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.flashMode = value;
        setCameraFlashMode(value);
    }

    public final CameraMode getCameraMode() {
        return this.cameraMode;
    }

    public final void setCameraMode(CameraMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.cameraMode = value;
        this.shouldCreateCamera = true;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
        setCameraZoom(f);
    }

    public final FocusMode getAutoFocus() {
        return this.autoFocus;
    }

    public final void setAutoFocus(FocusMode value) {
        CameraControl cameraControl;
        Intrinsics.checkNotNullParameter(value, "value");
        this.autoFocus = value;
        Camera camera = this.camera;
        if (camera == null || (cameraControl = camera.getCameraControl()) == null) {
            return;
        }
        if (this.autoFocus == FocusMode.OFF) {
            Intrinsics.checkNotNull(cameraControl.cancelFocusAndMetering());
        } else {
            startFocusMetering();
        }
    }

    public final VideoQuality getVideoQuality() {
        return this.videoQuality;
    }

    public final void setVideoQuality(VideoQuality value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.videoQuality = value;
        this.shouldCreateCamera = true;
    }

    public final Integer getVideoEncodingBitrate() {
        return this.videoEncodingBitrate;
    }

    public final void setVideoEncodingBitrate(Integer num) {
        this.videoEncodingBitrate = num;
        this.shouldCreateCamera = true;
    }

    public final VideoStabilizationMode getVideoStabilizationMode() {
        return this.videoStabilizationMode;
    }

    public final void setVideoStabilizationMode(VideoStabilizationMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.videoStabilizationMode = value;
        this.shouldCreateCamera = true;
    }

    public final CameraRatio getRatio() {
        return this.ratio;
    }

    public final void setRatio(CameraRatio cameraRatio) {
        this.ratio = cameraRatio;
        this.shouldCreateCamera = true;
    }

    public final String getPictureSize() {
        return this.pictureSize;
    }

    public final void setPictureSize(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.pictureSize = value;
        this.shouldCreateCamera = true;
    }

    public final boolean getMirror() {
        return this.mirror;
    }

    public final void setMirror(boolean z) {
        this.mirror = z;
        this.shouldCreateCamera = true;
    }

    public final boolean getMute() {
        return this.mute;
    }

    public final void setMute(boolean z) {
        this.mute = z;
    }

    public final boolean getAnimateShutter() {
        return this.animateShutter;
    }

    public final void setAnimateShutter(boolean z) {
        this.animateShutter = z;
    }

    public final boolean getEnableTorch() {
        return ((Boolean) this.enableTorch.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setEnableTorch(boolean z) {
        this.enableTorch.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    private final ViewEventCallback<Unit> getOnCameraReady() {
        return this.onCameraReady.getValue(this, $$delegatedProperties[1]);
    }

    private final ViewEventCallback<CameraMountErrorEvent> getOnMountError() {
        return this.onMountError.getValue(this, $$delegatedProperties[2]);
    }

    private final ViewEventCallback<BarcodeScannedEvent> getOnBarcodeScanned() {
        return this.onBarcodeScanned.getValue(this, $$delegatedProperties[3]);
    }

    static final short onBarcodeScanned_delegate$lambda$5(BarcodeScannedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return (short) (event.getData().hashCode() % 32767);
    }

    private final ViewEventCallback<PictureSavedEvent> getOnPictureSaved() {
        return this.onPictureSaved.getValue(this, $$delegatedProperties[4]);
    }

    static final short onPictureSaved_delegate$lambda$6(PictureSavedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String string = event.getData().getString("uri");
        return (short) ((string != null ? string.hashCode() : -1) % 32767);
    }

    private final ViewEventCallback<RecordingProgressEvent> getOnRecordingProgress() {
        return this.onRecordingProgress.getValue(this, $$delegatedProperties[5]);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChild(this.previewView, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(ViewGroup.resolveSize(this.previewView.getMeasuredWidth(), widthMeasureSpec), ViewGroup.resolveSize(this.previewView.getMeasuredHeight(), heightMeasureSpec));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i = right - left;
        int i2 = bottom - top;
        if (i == this.lastWidth && i2 == this.lastHeight) {
            return;
        }
        this.previewView.layout(0, 0, i, i2);
        SurfaceTexture surfaceTexture = this.glSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i, i2);
        }
        this.lastWidth = i;
        this.lastHeight = i2;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        if (Intrinsics.areEqual(child, this.previewView)) {
            return;
        }
        if (child != null) {
            child.bringToFront();
        }
        removeView(this.previewView);
        addView(this.previewView, 0);
    }

    public final void takePicture(final PictureOptions options, final Promise promise, final File cacheDirectory, final Runtime runtime) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(cacheDirectory, "cacheDirectory");
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Object systemService = getContext().getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        final int streamVolume = ((AudioManager) systemService).getStreamVolume(3);
        final boolean shutterSound = options.getShutterSound();
        ImageCapture imageCapture = this.imageCaptureUseCase;
        if (imageCapture != null) {
            imageCapture.m1074lambda$takePicture$1$androidxcameracoreImageCapture(ContextCompat.getMainExecutor(getContext()), new ImageCapture.OnImageCapturedCallback() { // from class: expo.modules.camera.ExpoCameraView.takePicture.1
                @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
                public void onCaptureStarted() {
                    if (shutterSound && streamVolume != 0) {
                        new MediaActionSound().play(0);
                    }
                    if (this.getAnimateShutter()) {
                        FlashShutterKt.flashShutter(this);
                    }
                }

                @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
                public void onCaptureSuccess(ImageProxy image) {
                    Intrinsics.checkNotNullParameter(image, "image");
                    ImageProxy.PlaneProxy[] planes = image.getPlanes();
                    Intrinsics.checkNotNullExpressionValue(planes, "getPlanes(...)");
                    byte[] byteArray = BarcodeAnalyzerKt.toByteArray(planes);
                    if (options.getFastMode()) {
                        promise.resolve((Object) null);
                    }
                    File file = cacheDirectory;
                    ExpoCameraView expoCameraView = this;
                    BuildersKt__Builders_commonKt.launch$default(expoCameraView.scope, null, null, new ExpoCameraView$takePicture$1$onCaptureSuccess$1$1(expoCameraView, byteArray, promise, options, runtime, file, null), 3, null);
                    image.close();
                }

                @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
                public void onError(ImageCaptureException exception) {
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    promise.reject(new CameraExceptions.ImageCaptureFailed());
                }
            });
        }
    }

    public final void setCameraFlashMode(FlashMode mode) {
        Activity currentActivity;
        Window window;
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (mode == FlashMode.SCREEN && this.lensFacing != CameraType.FRONT) {
            mode = FlashMode.ON;
        }
        if (mode == FlashMode.SCREEN && (currentActivity = getAppContext().getCurrentActivity()) != null && (window = currentActivity.getWindow()) != null) {
            this.previewView.setScreenFlashWindow(window);
            ImageCapture imageCapture = this.imageCaptureUseCase;
            if (imageCapture != null) {
                imageCapture.setScreenFlash(this.previewView.getScreenFlash());
            }
        }
        ImageCapture imageCapture2 = this.imageCaptureUseCase;
        if (imageCapture2 != null) {
            imageCapture2.setFlashMode(mode.mapToLens());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTorchEnabled(boolean enabled) {
        CameraInfo cameraInfo;
        Camera camera;
        CameraControl cameraControl;
        Camera camera2 = this.camera;
        if (camera2 == null || (cameraInfo = camera2.getCameraInfo()) == null || !cameraInfo.hasFlashUnit() || (camera = this.camera) == null || (cameraControl = camera.getCameraControl()) == null) {
            return;
        }
        cameraControl.enableTorch(enabled);
    }

    public final void record(final RecordingOptions options, final Promise promise, File cacheDirectory) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(cacheDirectory, "cacheDirectory");
        FileOutputOptions fileOutputOptionsBuild = ((FileOutputOptions.Builder) ((FileOutputOptions.Builder) new FileOutputOptions.Builder(FileSystemUtils.INSTANCE.generateOutputFile(cacheDirectory, "Camera", ".mp4")).setFileSizeLimit(options.getMaxFileSize())).setDurationLimitMillis(((long) options.getMaxDuration()) * 1000)).build();
        Intrinsics.checkNotNullExpressionValue(fileOutputOptionsBuild, "build(...)");
        final long jMax = (long) (Math.max(0.1d, options.getProgressUpdateInterval()) * 1000.0d);
        Recorder recorder = this.recorder;
        if (recorder != null) {
            if (!this.mute && ActivityCompat.checkSelfPermission(getContext(), "android.permission.RECORD_AUDIO") != 0) {
                promise.reject(new Exceptions.MissingPermissions("android.permission.RECORD_AUDIO"));
                return;
            }
            PendingRecording pendingRecordingPrepareRecording = recorder.prepareRecording(getContext(), fileOutputOptionsBuild);
            if (!this.mute) {
                PendingRecording.withAudioEnabled$default(pendingRecordingPrepareRecording, false, 1, null);
            }
            Executor mainExecutor = ContextCompat.getMainExecutor(getContext());
            Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(...)");
            this.activeRecording = pendingRecordingPrepareRecording.start(mainExecutor, new Consumer() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda8
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ExpoCameraView.record$lambda$12$lambda$11(this.f$0, jMax, options, promise, (VideoRecordEvent) obj);
                }
            });
            return;
        }
        promise.reject("E_RECORDING_FAILED", "Starting video recording failed - could not create video file.", null);
    }

    static final void record$lambda$12$lambda$11(ExpoCameraView expoCameraView, long j, RecordingOptions recordingOptions, Promise promise, VideoRecordEvent event) {
        String message;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof VideoRecordEvent.Pause) {
            expoCameraView.isRecording = false;
            return;
        }
        if (event instanceof VideoRecordEvent.Resume) {
            expoCameraView.isRecording = true;
            return;
        }
        if (event instanceof VideoRecordEvent.Start) {
            expoCameraView.isRecording = true;
            expoCameraView.lastRecordingProgressTimestamp = 0L;
            return;
        }
        if (event instanceof VideoRecordEvent.Status) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (!expoCameraView.isRecording || jUptimeMillis - expoCameraView.lastRecordingProgressTimestamp < j) {
                return;
            }
            expoCameraView.lastRecordingProgressTimestamp = jUptimeMillis;
            ViewEventCallback<RecordingProgressEvent> onRecordingProgress = expoCameraView.getOnRecordingProgress();
            VideoRecordEvent.Status status = (VideoRecordEvent.Status) event;
            double recordedDurationNanos = status.getRecordingStats().getRecordedDurationNanos() / 1.0E9d;
            long numBytesRecorded = status.getRecordingStats().getNumBytesRecorded();
            Integer numValueOf = Integer.valueOf(recordingOptions.getMaxDuration());
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            onRecordingProgress.invoke(new RecordingProgressEvent(recordedDurationNanos, numBytesRecorded, numValueOf != null ? Double.valueOf(numValueOf.intValue()) : null));
            return;
        }
        if (event instanceof VideoRecordEvent.Finalize) {
            VideoRecordEvent.Finalize finalize = (VideoRecordEvent.Finalize) event;
            int error = finalize.getError();
            if (error == 0 || error == 2 || error == 4 || error == 9) {
                Bundle bundle = new Bundle();
                bundle.putString("uri", finalize.getOutputResults().getOutputUri().toString());
                promise.resolve(bundle);
            } else {
                Throwable cause = finalize.getCause();
                if (cause == null || (message = cause.getMessage()) == null) {
                    message = "Unknown error";
                }
                promise.reject(new CameraExceptions.VideoRecordingFailed(message));
            }
        }
    }

    public final void stopRecording() {
        this.isRecording = false;
        Recording recording = this.activeRecording;
        if (recording != null) {
            recording.close();
        }
    }

    public final void toggleRecording() {
        Recording recording = this.activeRecording;
        if (recording != null) {
            if (this.isRecording) {
                recording.pause();
            } else {
                recording.resume();
            }
        }
    }

    /* JADX INFO: renamed from: expo.modules.camera.ExpoCameraView$recreateCamera$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExpoCameraView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.camera.ExpoCameraView$recreateCamera$1", f = "ExpoCameraView.kt", i = {}, l = {448}, m = "invokeSuspend", n = {}, s = {})
    static final class C08101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08101(Continuation<? super C08101> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExpoCameraView.this.new C08101(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ExpoCameraView.this.createCamera(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void recreateCamera() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C08101(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final Object createCamera(Continuation<? super Unit> continuation) {
        C08091 c08091;
        if (continuation instanceof C08091) {
            c08091 = (C08091) continuation;
            if ((c08091.label & Integer.MIN_VALUE) != 0) {
                c08091.label -= Integer.MIN_VALUE;
            } else {
                c08091 = new C08091(continuation);
            }
        } else {
            c08091 = new C08091(continuation);
        }
        Object obj = c08091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08091.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.shouldCreateCamera || this.previewPaused) {
                    return Unit.INSTANCE;
                }
                this.shouldCreateCamera = false;
                c08091.label = 1;
                Object objConfigureAndBindCamera = configureAndBindCamera(c08091);
                this = objConfigureAndBindCamera;
                if (objConfigureAndBindCamera == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this = this;
            }
        } catch (Exception e) {
            this.shouldCreateCamera = true;
            ViewEventCallback<CameraMountErrorEvent> onMountError = this.getOnMountError();
            String message = e.getMessage();
            if (message == null) {
                message = e.getClass().getSimpleName();
            }
            onMountError.invoke(new CameraMountErrorEvent("Camera could not be started, it may be unavailable or in use by another app: " + message));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object configureAndBindCamera(Continuation<? super Unit> continuation) {
        C08081 c08081;
        FlashMode flashMode;
        ImageCapture.ScreenFlash screenFlash;
        Activity currentActivity;
        Window window;
        PreviewView.ScaleType scaleType;
        if (continuation instanceof C08081) {
            c08081 = (C08081) continuation;
            if ((c08081.label & Integer.MIN_VALUE) != 0) {
                c08081.label -= Integer.MIN_VALUE;
            } else {
                c08081 = new C08081(continuation);
            }
        } else {
            c08081 = new C08081(continuation);
        }
        Object objAwaitInstance = c08081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08081.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitInstance);
            ProcessCameraProvider.Companion companion = ProcessCameraProvider.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            c08081.label = 1;
            objAwaitInstance = ProcessCameraProviderExtKt.awaitInstance(companion, context, c08081);
            if (objAwaitInstance == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwaitInstance);
        }
        ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) objAwaitInstance;
        CameraRatio cameraRatio = this.ratio;
        if (cameraRatio != null) {
            PreviewView previewView = this.previewView;
            if (cameraRatio == CameraRatio.FOUR_THREE || this.ratio == CameraRatio.SIXTEEN_NINE) {
                scaleType = PreviewView.ScaleType.FIT_CENTER;
            } else {
                scaleType = PreviewView.ScaleType.FILL_CENTER;
            }
            previewView.setScaleType(scaleType);
        }
        ResolutionSelector resolutionSelectorBuildResolutionSelector = buildResolutionSelector();
        Preview previewBuild = new Preview.Builder().setResolutionSelector(resolutionSelectorBuildResolutionSelector).build();
        previewBuild.setSurfaceProvider(this.previewView.getSurfaceProvider());
        Intrinsics.checkNotNullExpressionValue(previewBuild, "also(...)");
        final SurfaceTexture surfaceTexture = this.glSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(this.previewView.getWidth(), this.previewView.getHeight());
            previewBuild.setSurfaceProvider(new Preview.SurfaceProvider() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda6
                @Override // androidx.camera.core.Preview.SurfaceProvider
                public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
                    ExpoCameraView.configureAndBindCamera$lambda$18$lambda$17(surfaceTexture, this, surfaceRequest);
                }
            });
        }
        CameraSelector cameraSelectorBuild = new CameraSelector.Builder().requireLensFacing(this.lensFacing.mapToCharacteristic()).build();
        Intrinsics.checkNotNullExpressionValue(cameraSelectorBuild, "build(...)");
        if (this.flashMode == FlashMode.SCREEN && this.lensFacing != CameraType.FRONT) {
            flashMode = FlashMode.ON;
        } else {
            flashMode = this.flashMode;
        }
        if (flashMode == FlashMode.SCREEN && (currentActivity = getAppContext().getCurrentActivity()) != null && (window = currentActivity.getWindow()) != null) {
            this.previewView.setScreenFlashWindow(window);
        }
        ImageCapture.Builder flashMode2 = new ImageCapture.Builder().setResolutionSelector(resolutionSelectorBuildResolutionSelector).setFlashMode(flashMode.mapToLens());
        Intrinsics.checkNotNullExpressionValue(flashMode2, "setFlashMode(...)");
        if (flashMode == FlashMode.SCREEN && (screenFlash = this.previewView.getScreenFlash()) != null) {
            flashMode2.setScreenFlash(screenFlash);
        }
        this.imageCaptureUseCase = flashMode2.build();
        List<CameraInfo> listFilter = cameraSelectorBuild.filter(processCameraProvider.getAvailableCameraInfos());
        Intrinsics.checkNotNullExpressionValue(listFilter, "filter(...)");
        VideoCapture<Recorder> videoCaptureCreateVideoCapture = createVideoCapture((CameraInfo) CollectionsKt.firstOrNull((List) listFilter));
        releaseBarcodeAnalyzer();
        this.imageAnalysisUseCase = this.shouldScanBarcodes ? createImageAnalyzer() : null;
        UseCaseGroup.Builder builder = new UseCaseGroup.Builder();
        builder.addUseCase(previewBuild);
        if (this.cameraMode == CameraMode.PICTURE) {
            ImageCapture imageCapture = this.imageCaptureUseCase;
            if (imageCapture != null) {
                builder.addUseCase(imageCapture);
            }
            ImageAnalysis imageAnalysis = this.imageAnalysisUseCase;
            if (imageAnalysis != null) {
                builder.addUseCase(imageAnalysis);
            }
        } else {
            builder.addUseCase(videoCaptureCreateVideoCapture);
        }
        UseCaseGroup useCaseGroupBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(useCaseGroupBuild, "build(...)");
        processCameraProvider.unbindAll();
        Camera cameraBindToLifecycle = processCameraProvider.bindToLifecycle(getCurrentActivity(), cameraSelectorBuild, useCaseGroupBuild);
        this.camera = cameraBindToLifecycle;
        if (cameraBindToLifecycle != null) {
            CameraInfo cameraInfo = cameraBindToLifecycle.getCameraInfo();
            Intrinsics.checkNotNullExpressionValue(cameraInfo, "getCameraInfo(...)");
            observeCameraState(cameraInfo);
        }
        setCameraZoom(this.zoom);
        this.cameraProvider = processCameraProvider;
        return Unit.INSTANCE;
    }

    static final void configureAndBindCamera$lambda$18$lambda$17(SurfaceTexture surfaceTexture, ExpoCameraView expoCameraView, SurfaceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        final Surface surface = new Surface(surfaceTexture);
        request.provideSurface(surface, ContextCompat.getMainExecutor(expoCameraView.getContext()), new Consumer() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                surface.release();
            }
        });
    }

    private final ImageAnalysis createImageAnalyzer() {
        ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setResolutionSelector(new ResolutionSelector.Builder().setResolutionStrategy(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY).build()).setBackpressureStrategy(0).build();
        Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild, "build(...)");
        if (this.shouldScanBarcodes && CameraUtils.INSTANCE.isMLKitBarcodeScannerAvailable()) {
            try {
                BarcodeAnalyzer barcodeAnalyzer = new BarcodeAnalyzer(this.barcodeFormats, (Function1<? super BarCodeScannerResult, Unit>) new Function1() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExpoCameraView.createImageAnalyzer$lambda$27$lambda$25(this.f$0, (BarCodeScannerResult) obj);
                    }
                });
                imageAnalysisBuild.setAnalyzer(ContextCompat.getMainExecutor(getContext()), barcodeAnalyzer);
                this.barcodeAnalyzer = barcodeAnalyzer;
                return imageAnalysisBuild;
            } catch (Exception e) {
                Log.e(CameraViewModule.INSTANCE.getTAG$expo_camera_release(), "Failed to initialize BarcodeAnalyzer: " + e.getMessage());
            }
        }
        return imageAnalysisBuild;
    }

    static final Unit createImageAnalyzer$lambda$27$lambda$25(ExpoCameraView expoCameraView, BarCodeScannerResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        expoCameraView.onBarcodeScanned(it);
        return Unit.INSTANCE;
    }

    private final void releaseBarcodeAnalyzer() {
        ImageAnalysis imageAnalysis = this.imageAnalysisUseCase;
        if (imageAnalysis != null) {
            imageAnalysis.clearAnalyzer();
        }
        BarcodeAnalyzer barcodeAnalyzer = this.barcodeAnalyzer;
        if (barcodeAnalyzer != null) {
            barcodeAnalyzer.close();
        }
        this.barcodeAnalyzer = null;
    }

    private final ResolutionSelector buildResolutionSelector() {
        ResolutionStrategy HIGHEST_AVAILABLE_STRATEGY;
        if (this.pictureSize.length() > 0) {
            Size sizeSafely = parseSizeSafely(this.pictureSize);
            if (sizeSafely != null) {
                HIGHEST_AVAILABLE_STRATEGY = new ResolutionStrategy(sizeSafely, 3);
            } else {
                HIGHEST_AVAILABLE_STRATEGY = ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY;
                Intrinsics.checkNotNullExpressionValue(HIGHEST_AVAILABLE_STRATEGY, "HIGHEST_AVAILABLE_STRATEGY");
            }
        } else {
            HIGHEST_AVAILABLE_STRATEGY = ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY;
            Intrinsics.checkNotNull(HIGHEST_AVAILABLE_STRATEGY);
        }
        if (this.ratio == CameraRatio.ONE_ONE) {
            ResolutionSelector resolutionSelectorBuild = new ResolutionSelector.Builder().setResolutionFilter(new ResolutionFilter() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda5
                @Override // androidx.camera.core.resolutionselector.ResolutionFilter
                public final List filter(List list, int i) {
                    return ExpoCameraView.buildResolutionSelector$lambda$30(list, i);
                }
            }).setResolutionStrategy(HIGHEST_AVAILABLE_STRATEGY).build();
            Intrinsics.checkNotNull(resolutionSelectorBuild);
            return resolutionSelectorBuild;
        }
        ResolutionSelector.Builder builder = new ResolutionSelector.Builder();
        CameraRatio cameraRatio = this.ratio;
        if (cameraRatio != null) {
            builder.setAspectRatioStrategy(cameraRatio.mapToStrategy());
        }
        builder.setResolutionStrategy(HIGHEST_AVAILABLE_STRATEGY);
        ResolutionSelector resolutionSelectorBuild2 = builder.build();
        Intrinsics.checkNotNull(resolutionSelectorBuild2);
        return resolutionSelectorBuild2;
    }

    static final List buildResolutionSelector$lambda$30(List supportedSizes, int i) {
        Intrinsics.checkNotNullParameter(supportedSizes, "supportedSizes");
        ArrayList arrayList = new ArrayList();
        for (Object obj : supportedSizes) {
            Size size = (Size) obj;
            if (size.getWidth() == size.getHeight()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final Size parseSizeSafely(String size) {
        if (!new Regex("\\d+x\\d+").matches(size)) {
            return null;
        }
        try {
            return Size.parseSize(size);
        } catch (Throwable unused) {
            return null;
        }
    }

    private final VideoCapture<Recorder> createVideoCapture(CameraInfo cameraInfo) {
        Quality qualityMapToQuality = this.videoQuality.mapToQuality();
        FallbackStrategy fallbackStrategyHigherQualityOrLowerThan = FallbackStrategy.higherQualityOrLowerThan(qualityMapToQuality);
        Intrinsics.checkNotNullExpressionValue(fallbackStrategyHigherQualityOrLowerThan, "higherQualityOrLowerThan(...)");
        QualitySelector qualitySelectorFrom = QualitySelector.from(qualityMapToQuality, fallbackStrategyHigherQualityOrLowerThan);
        Intrinsics.checkNotNullExpressionValue(qualitySelectorFrom, "from(...)");
        Recorder.Builder builder = new Recorder.Builder();
        Integer num = this.videoEncodingBitrate;
        if (num != null) {
            builder.setTargetVideoEncodingBitRate(num.intValue());
        }
        Recorder recorderBuild = builder.setExecutor(ContextCompat.getMainExecutor(getContext())).setQualitySelector(qualitySelectorFrom).build();
        this.recorder = recorderBuild;
        Intrinsics.checkNotNullExpressionValue(recorderBuild, "also(...)");
        VideoCapture.Builder builder2 = new VideoCapture.Builder(recorderBuild);
        if (this.mirror) {
            builder2.setMirrorMode(2);
        }
        builder2.setVideoStabilizationEnabled(isVideoStabilizationEnabled(cameraInfo));
        VideoCapture<Recorder> videoCaptureBuild = builder2.build();
        Intrinsics.checkNotNullExpressionValue(videoCaptureBuild, "build(...)");
        return videoCaptureBuild;
    }

    private final boolean isVideoStabilizationEnabled(CameraInfo cameraInfo) {
        return (cameraInfo != null ? Recorder.getVideoCapabilities(cameraInfo).isStabilizationSupported() : false) && this.videoStabilizationMode.isEnabled();
    }

    private final void startFocusMetering() {
        Camera camera = this.camera;
        if (camera != null) {
            FocusMeteringAction focusMeteringActionBuild = new FocusMeteringAction.Builder(new DisplayOrientedMeteringPointFactory(this.previewView.getDisplay(), camera.getCameraInfo(), this.previewView.getWidth(), this.previewView.getHeight()).createPoint(1.0f, 1.0f), 1).build();
            Intrinsics.checkNotNullExpressionValue(focusMeteringActionBuild, "build(...)");
            camera.getCameraControl().startFocusAndMetering(focusMeteringActionBuild);
        }
    }

    private final void setCameraZoom(float value) {
        CameraControl cameraControl;
        CameraInfo cameraInfo;
        LiveData<ZoomState> zoomState;
        ZoomState value2;
        Camera camera = this.camera;
        float maxZoomRatio = (camera == null || (cameraInfo = camera.getCameraInfo()) == null || (zoomState = cameraInfo.getZoomState()) == null || (value2 = zoomState.getValue()) == null) ? 1.0f : value2.getMaxZoomRatio();
        float fMax = Float.max(1.0f, Float.min(maxZoomRatio, RangesKt.coerceIn(value, 0.0f, 1.0f) * maxZoomRatio));
        Camera camera2 = this.camera;
        if (camera2 == null || (cameraControl = camera2.getCameraControl()) == null) {
            return;
        }
        cameraControl.setZoomRatio(fMax);
    }

    private final void observeCameraState(CameraInfo cameraInfo) {
        cameraInfo.getCameraState().observe(getCurrentActivity(), new ExpoCameraViewKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExpoCameraView.observeCameraState$lambda$39(this.f$0, (CameraState) obj);
            }
        }));
    }

    static final Unit observeCameraState$lambda$39(ExpoCameraView expoCameraView, CameraState cameraState) {
        if (WhenMappings.$EnumSwitchMapping$0[cameraState.getType().ordinal()] == 1) {
            expoCameraView.getOnCameraReady().invoke(Unit.INSTANCE);
            expoCameraView.setTorchEnabled(expoCameraView.getEnableTorch());
        }
        return Unit.INSTANCE;
    }

    public final List<String> getAvailablePictureSizes() {
        CameraInfo cameraInfo;
        ArrayList arrayList;
        Size[] outputSizes;
        Camera camera = this.camera;
        if (camera != null && (cameraInfo = camera.getCameraInfo()) != null) {
            Camera2CameraInfo camera2CameraInfoFrom = Camera2CameraInfo.INSTANCE.from(cameraInfo);
            CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
            Intrinsics.checkNotNullExpressionValue(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) camera2CameraInfoFrom.getCameraCharacteristic(SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null || (outputSizes = streamConfigurationMap.getOutputSizes(256)) == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList(outputSizes.length);
                for (Size size : outputSizes) {
                    String string = size.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    arrayList2.add(string);
                }
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                return arrayList;
            }
        }
        return CollectionsKt.emptyList();
    }

    public final void resumePreview() {
        this.shouldCreateCamera = true;
        this.previewPaused = false;
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C08111(null), 3, null);
    }

    /* JADX INFO: renamed from: expo.modules.camera.ExpoCameraView$resumePreview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExpoCameraView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.camera.ExpoCameraView$resumePreview$1", f = "ExpoCameraView.kt", i = {}, l = {714}, m = "invokeSuspend", n = {}, s = {})
    static final class C08111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08111(Continuation<? super C08111> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExpoCameraView.this.new C08111(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ExpoCameraView.this.createCamera(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void pausePreview() {
        this.previewPaused = true;
        ProcessCameraProvider processCameraProvider = this.cameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
        }
    }

    public final void setShouldScanBarcodes(boolean shouldScanBarcodes) {
        this.shouldScanBarcodes = shouldScanBarcodes;
        this.shouldCreateCamera = true;
    }

    public final void setBarcodeScannerSettings(BarcodeSettings settings) {
        List<BarcodeType> listEmptyList;
        if (settings == null || (listEmptyList = settings.getBarcodeTypes()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        this.barcodeFormats = listEmptyList;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0065  */
    private final void transformBarcodeScannerResultToViewCoordinates(BarCodeScannerResult barcode) {
        float f;
        float f2;
        float f3;
        List<Integer> cornerPoints = barcode.getCornerPoints();
        float width = this.previewView.getWidth();
        float height = this.previewView.getHeight();
        float width2 = barcode.getWidth();
        float height2 = barcode.getHeight();
        float f4 = 0.0f;
        if (width <= 0.0f || height <= 0.0f || width2 <= 0.0f || height2 <= 0.0f) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[this.previewView.getScaleType().ordinal()];
        if (i == 1) {
            if (width / height > width2 / height2) {
                f = height / height2;
                f2 = 0.0f;
                f4 = (width - (width2 * f)) / 2.0f;
            } else {
                f = width / width2;
                f2 = (height - (height2 * f)) / 2.0f;
            }
            f3 = f;
        } else if (i != 2) {
            f = width / width2;
            f3 = height / height2;
            f2 = 0.0f;
        } else {
            if (width / height > width2 / height2) {
                f = width / width2;
                f2 = (height - (height2 * f)) / 2.0f;
            } else {
                f = height / height2;
                f2 = 0.0f;
                f4 = (width - (width2 * f)) / 2.0f;
            }
            f3 = f;
        }
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, cornerPoints.size()), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                cornerPoints.set(first, Integer.valueOf(MathKt.roundToInt((cornerPoints.get(first).intValue() * f) + f4)));
                if (first == last) {
                    break;
                } else {
                    first += step;
                }
            }
        }
        IntProgression intProgressionStep2 = RangesKt.step(RangesKt.until(1, cornerPoints.size()), 2);
        int first2 = intProgressionStep2.getFirst();
        int last2 = intProgressionStep2.getLast();
        int step2 = intProgressionStep2.getStep();
        if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
            while (true) {
                cornerPoints.set(first2, Integer.valueOf(MathKt.roundToInt((cornerPoints.get(first2).intValue() * f3) + f2)));
                if (first2 == last2) {
                    break;
                } else {
                    first2 += step2;
                }
            }
        }
        barcode.setCornerPoints(cornerPoints);
        barcode.setHeight((int) height);
        barcode.setWidth((int) width);
    }

    private final Pair<ArrayList<Bundle>, Bundle> getCornerPointsAndBoundingBox(List<Integer> cornerPoints, BarCodeScannerResult.BoundingBox boundingBox) {
        float f = this.previewView.getResources().getDisplayMetrics().density;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, cornerPoints.size() - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                float fIntValue = cornerPoints.get(i).intValue() / f;
                float fIntValue2 = cornerPoints.get(i + 1).intValue() / f;
                Bundle bundle = new Bundle();
                bundle.putFloat(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, fIntValue);
                bundle.putFloat(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, fIntValue2);
                arrayList.add(bundle);
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle3.putFloat(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, boundingBox.getX() / f);
        bundle3.putFloat(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, boundingBox.getY() / f);
        Unit unit = Unit.INSTANCE;
        bundle2.putParcelable("origin", bundle3);
        Bundle bundle4 = new Bundle();
        bundle4.putFloat(ViewProps.WIDTH, boundingBox.getWidth() / f);
        bundle4.putFloat(ViewProps.HEIGHT, boundingBox.getHeight() / f);
        Unit unit2 = Unit.INSTANCE;
        bundle2.putParcelable(ContentDisposition.Parameters.Size, bundle4);
        return TuplesKt.to(arrayList, bundle2);
    }

    private final void onBarcodeScanned(BarCodeScannerResult barcode) {
        if (this.shouldScanBarcodes) {
            transformBarcodeScannerResultToViewCoordinates(barcode);
            Pair<ArrayList<Bundle>, Bundle> cornerPointsAndBoundingBox = getCornerPointsAndBoundingBox(barcode.getCornerPoints(), barcode.getBoundingBox());
            getOnBarcodeScanned().invoke(new BarcodeScannedEvent(getId(), String.valueOf(barcode.getValue()), String.valueOf(barcode.getRaw()), BarcodeType.INSTANCE.mapFormatToString(barcode.getType()), cornerPointsAndBoundingBox.component1(), cornerPointsAndBoundingBox.component2(), barcode.getExtra()));
        }
    }

    @Override // expo.modules.interfaces.camera.CameraViewInterface
    public void setPreviewTexture(SurfaceTexture surfaceTexture) {
        this.glSurfaceTexture = surfaceTexture;
        this.shouldCreateCamera = true;
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C08121(null), 3, null);
    }

    /* JADX INFO: renamed from: expo.modules.camera.ExpoCameraView$setPreviewTexture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExpoCameraView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.camera.ExpoCameraView$setPreviewTexture$1", f = "ExpoCameraView.kt", i = {}, l = {860}, m = "invokeSuspend", n = {}, s = {})
    static final class C08121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08121(Continuation<? super C08121> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExpoCameraView.this.new C08121(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ExpoCameraView.this.createCamera(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // expo.modules.interfaces.camera.CameraViewInterface
    public int[] getPreviewSizeAsArray() {
        return new int[]{this.previewView.getWidth(), this.previewView.getHeight()};
    }

    public final void onPictureSaved(Bundle response) {
        Intrinsics.checkNotNullParameter(response, "response");
        ViewEventCallback<PictureSavedEvent> onPictureSaved = getOnPictureSaved();
        int i = response.getInt("id");
        Bundle bundle = response.getBundle("data");
        Intrinsics.checkNotNull(bundle);
        onPictureSaved.invoke(new PictureSavedEvent(i, bundle));
    }

    private final Object cancelCoroutineScope() {
        try {
            CoroutineScopeKt.cancel(this.scope, new ModuleDestroyedException(null, 1, null));
            return Unit.INSTANCE;
        } catch (Exception unused) {
            return Integer.valueOf(Log.e(CameraViewModule.INSTANCE.getTAG$expo_camera_release(), "The scope does not have a job in it"));
        }
    }

    public final void cleanupCamera() {
        getOrientationEventListener().disable();
        cancelCoroutineScope();
        ProcessCameraProvider processCameraProvider = this.cameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
        }
        releaseBarcodeAnalyzer();
        SurfaceTexture surfaceTexture = this.glSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }
}
