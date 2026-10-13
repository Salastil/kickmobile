package io.datazoom.sdk;

import androidx.exifinterface.media.ExifInterface;
import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.datadog.android.rum.internal.instrumentation.gestures.GesturesListener;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.datazoom.sdk.ad.AdManager;
import io.datazoom.sdk.ad.DzAd;
import io.datazoom.sdk.ad.DzAdEvent;
import io.datazoom.sdk.ad.DzAdEventType;
import io.datazoom.sdk.ad.DzAdKt;
import io.datazoom.sdk.ad.DzAdSessionMetadata;
import io.datazoom.sdk.data.memory.ConfigStore;
import io.datazoom.sdk.data.memory.FluxDataStoreExtensionsKt;
import io.datazoom.sdk.data.memory.MetaDataStore;
import io.datazoom.sdk.data.memory.MetaDataStoreExtensionsKt;
import io.datazoom.sdk.data.memory.PreferenceStore;
import io.datazoom.sdk.data.memory.PreferenceStoreExtKt;
import io.datazoom.sdk.di.ExtensionsKt;
import io.datazoom.sdk.domain.SessionManager;
import io.datazoom.sdk.domain.StateTransitionProcessor;
import io.datazoom.sdk.domain.TimerState;
import io.datazoom.sdk.domain.heartbeat.HeartBeat;
import io.datazoom.sdk.domain.milestones.Milestone;
import io.datazoom.sdk.domain.milestones.MilestoneImp;
import io.datazoom.sdk.domain.milestones.QualifiedMilestoneImp;
import io.datazoom.sdk.logs.Logger;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.model.AppConfig;
import io.datazoom.sdk.model.Event;
import io.datazoom.sdk.model.EventKt;
import io.datazoom.sdk.model.FluxData;
import io.datazoom.sdk.model.Media;
import io.datazoom.sdk.model.MetaData;
import io.datazoom.sdk.model.VideoType;
import io.datazoom.sdk.stateMachine.StateMachine;
import io.datazoom.sdk.stateMachine.StateMachineExtKt;
import io.datazoom.sdk.stateMachine.Transition;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import io.datazoom.sdk.time.Time;
import io.datazoom.sdk.utils.AdapterCallbackListener;
import io.datazoom.sdk.utils.DurationsManager;
import io.datazoom.sdk.utils.DzPlaybackEvent;
import io.datazoom.sdk.utils.PrimitiveExtensionsKt;
import io.datazoom.sdk.utils.SafeList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.koin.core.Koin;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.qualifier.StringQualifier;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: DzAdapter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Ì\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0004ü\u0001ý\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u00103\u001a\u00020\n2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000207H\u0014J\u0013\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u000205H\u0002J\n\u0010\u0088\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010\u0089\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010\u008a\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010\u008b\u0001\u001a\u00030\u0083\u0001H\u0002J\u001e\u0010\u008f\u0001\u001a\u00030\u0083\u00012\u0014\u0010\u0090\u0001\u001a\u000f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00010\u0091\u0001J\u0014\u0010\u0092\u0001\u001a\u000f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00010\u0091\u0001J\b\u0010\u0093\u0001\u001a\u00030\u0083\u0001J'\u0010\u0094\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0095\u0001\u001a\u0002052\u0014\u0010\u0096\u0001\u001a\u000f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00010\u0091\u0001J\n\u0010\u0097\u0001\u001a\u00030\u0083\u0001H\u0017J\n\u0010\u0098\u0001\u001a\u00030\u0083\u0001H\u0002J\u0012\u0010\u0099\u0001\u001a\u00030\u0083\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001J\u0016\u0010\u009c\u0001\u001a\u00030\u0083\u00012\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0002J\u0014\u0010\u009f\u0001\u001a\u00030\u0083\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0002J\n\u0010 \u0001\u001a\u00030\u0083\u0001H\u0002J\t\u0010¡\u0001\u001a\u00020\u000fH\u0002J\u0012\u0010¢\u0001\u001a\u00030\u0083\u00012\b\u0010£\u0001\u001a\u00030¤\u0001J(\u0010¥\u0001\u001a\u0005\u0018\u0001H¦\u0001\"\u0005\b\u0000\u0010¦\u00012\r\u0010§\u0001\u001a\b0¨\u0001j\u0003`©\u0001H\u0002¢\u0006\u0003\u0010ª\u0001J\u0014\u0010«\u0001\u001a\u00030\u0083\u00012\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0004J\u001d\u0010«\u0001\u001a\u00030\u0083\u00012\b\u0010§\u0001\u001a\u00030®\u00012\u0007\u0010¯\u0001\u001a\u00020\u0001H\u0004JC\u0010°\u0001\u001a\u00030\u0083\u00012\b\u0010±\u0001\u001a\u00030²\u00012-\b\u0002\u0010\u0096\u0001\u001a&\u0012\u0004\u0012\u000205\u0012\u0016\u0012\u00140\u0001¢\u0006\u000f\b´\u0001\u0012\n\bµ\u0001\u0012\u0005\b\t0¶\u00010³\u0001j\u0003`·\u0001H\u0004J\u0012\u0010¸\u0001\u001a\u00030\u0083\u00012\b\u0010¹\u0001\u001a\u00030º\u0001J\u001a\u0010»\u0001\u001a\u00030\u0083\u00012\u0007\u0010¼\u0001\u001a\u0002052\u0007\u0010½\u0001\u001a\u00020\u0015J\n\u0010¾\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010¿\u0001\u001a\u00030\u0083\u0001H\u0002J\u0013\u0010À\u0001\u001a\u00030\u0083\u00012\u0007\u0010Á\u0001\u001a\u00020\u000fH\u0014J\u0013\u0010Â\u0001\u001a\u00030\u0083\u00012\u0007\u0010Ã\u0001\u001a\u00020\nH\u0014J\u0013\u0010Ä\u0001\u001a\u00030\u0083\u00012\u0007\u0010Å\u0001\u001a\u00020\u007fH\u0002J\u0013\u0010Æ\u0001\u001a\u00030\u0083\u00012\u0007\u0010Å\u0001\u001a\u00020\u007fH\u0002J\n\u0010Ç\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010È\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010É\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030\u0083\u0001H\u0002J\u0013\u0010Ë\u0001\u001a\u00020\u000f2\b\u0010\u009a\u0001\u001a\u00030Ì\u0001H\u0002J\n\u0010Í\u0001\u001a\u00030\u0083\u0001H\u0002J\u0013\u0010Î\u0001\u001a\u00030\u0083\u00012\u0007\u0010Ï\u0001\u001a\u00020\u000fH\u0002J\n\u0010Ð\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010Ñ\u0001\u001a\u00030\u0083\u0001H\u0016J\u0014\u0010Ò\u0001\u001a\u00030\u0083\u00012\b\u0010¹\u0001\u001a\u00030º\u0001H\u0016J\u0010\u0010Ó\u0001\u001a\u00030\u0083\u0001H\u0010¢\u0006\u0003\bÔ\u0001J\u0010\u0010Õ\u0001\u001a\u00030\u0083\u0001H\u0010¢\u0006\u0003\bÖ\u0001J\u0010\u0010×\u0001\u001a\u00030\u0083\u0001H\u0010¢\u0006\u0003\bØ\u0001J\u0011\u0010Ù\u0001\u001a\u00030\u0083\u00012\u0007\u0010Ú\u0001\u001a\u00020\nJ\u0011\u0010Û\u0001\u001a\u00030\u0083\u00012\u0007\u0010Ü\u0001\u001a\u00020\nJ\u0018\u0010Ý\u0001\u001a\u00030\u0083\u00012\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u0011\u0010Þ\u0001\u001a\u00030\u0083\u00012\u0007\u0010ß\u0001\u001a\u000205J)\u0010ã\u0001\u001a\u00030\u0083\u00012\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0007\u0010ä\u0001\u001a\u00020\u0015H\u0000¢\u0006\u0003\bå\u0001J\u0013\u0010æ\u0001\u001a\u00030\u0083\u00012\u0007\u0010Ú\u0001\u001a\u00020\nH\u0002J\u0012\u0010ç\u0001\u001a\u00030\u0083\u00012\u0006\u0010\u001e\u001a\u00020\nH\u0004J\u001b\u0010ê\u0001\u001a\u00030\u0083\u00012\u0006\u0010B\u001a\u00020\u00152\u0007\u0010ë\u0001\u001a\u00020\u0015H\u0002J\u0007\u0010ì\u0001\u001a\u00020\u000fJ\u0014\u0010í\u0001\u001a\u00030\u0083\u00012\b\u0010\u009a\u0001\u001a\u00030î\u0001H\u0002J\u0014\u0010ï\u0001\u001a\u00030\u0083\u00012\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0004J\u0011\u0010ò\u0001\u001a\u00030\u0083\u00012\u0007\u0010ó\u0001\u001a\u000201J\u0011\u0010ô\u0001\u001a\u00030\u0083\u00012\u0007\u0010ó\u0001\u001a\u000201R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f8D@BX\u0084\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00158B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00158B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR(\u0010\u001e\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020,00X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\fR\u0012\u0010:\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\fR\u0012\u0010;\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\fR\u0012\u0010<\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0012R\u0012\u0010>\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0012R\u0012\u0010@\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0012R\u0012\u0010B\u001a\u00020\u0015X¤\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0018R\u0012\u0010D\u001a\u00020\u0015X¤\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u0018R\u0014\u0010F\u001a\u0004\u0018\u00010GX¤\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0012\u0010J\u001a\u00020KX¤\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0012\u0010N\u001a\u00020\u0015X¤\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0018R\u0012\u0010P\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\fR\u0012\u0010Q\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\bR\u0010\fR\u0012\u0010S\u001a\u00020TX¤\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0012\u0010W\u001a\u000205X¤\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0012\u0010Z\u001a\u000205X¤\u0004¢\u0006\u0006\u001a\u0004\b[\u0010YR\u0012\u0010\\\u001a\u000205X¦\u0004¢\u0006\u0006\u001a\u0004\b]\u0010YR\u001b\u0010^\u001a\u00020_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\b`\u0010aR\u001b\u0010d\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010c\u001a\u0004\bf\u0010gR\u0014\u0010i\u001a\u00020j8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010lR\u000e\u0010m\u001a\u00020nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010s\u001a\u00020r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010c\u001a\u0004\bt\u0010uR\u000e\u0010w\u001a\u00020xX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020zX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020zX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020zX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020zX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010~\u001a\u0004\u0018\u00010\u007f8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010\u0085\u0001\u001a\n\u0012\u0005\u0012\u00030\u0087\u00010\u0086\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u008c\u0001\u001a\u0002058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010c\u001a\u0005\b\u008d\u0001\u0010YR\u001a\u0010à\u0001\u001a\u0005\u0018\u00010\u009e\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bá\u0001\u0010â\u0001R\u0016\u0010è\u0001\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\bè\u0001\u0010\fR\u0016\u0010é\u0001\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\bé\u0001\u0010\fR\u0016\u0010õ\u0001\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\bõ\u0001\u0010\fR\u0013\u0010ö\u0001\u001a\u00020\n8F¢\u0006\u0007\u001a\u0005\b÷\u0001\u0010\fR\u0018\u0010ø\u0001\u001a\u00030ù\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bú\u0001\u0010û\u0001¨\u0006þ\u0001"}, d2 = {"Lio/datazoom/sdk/DzAdapter;", "", "baseContext", "Lio/datazoom/sdk/BaseContext;", "<init>", "(Lio/datazoom/sdk/BaseContext;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/datazoom/sdk/DzAdapter$AdapterState;", "value", "", "isDestroyed", "()Z", "setDestroyed", "(Z)V", "", "adDuration", "getAdDuration", "()J", "setAdDuration", "(J)V", "", ViewProps.WIDTH, "getWidth", "()I", "setWidth", "(I)V", ViewProps.HEIGHT, "getHeight", "setHeight", "isLive", "()Ljava/lang/Boolean;", "setLive", "(Ljava/lang/Boolean;)V", "lastPlayHeadDuration", "getLastPlayHeadDuration", "setLastPlayHeadDuration", "env", "Lio/datazoom/sdk/StateEnv;", "heartBeat", "Lio/datazoom/sdk/domain/heartbeat/HeartBeat;", "stateEventProcessor", "Lio/datazoom/sdk/domain/StateTransitionProcessor;", "configStoreJob", "Lkotlinx/coroutines/Job;", "stateMachineJob", "timerJob", "playbackCallbacks", "Lio/datazoom/sdk/utils/SafeList;", "Lio/datazoom/sdk/utils/AdapterCallbackListener;", "milestoneJobs", "warnIfDestroyed", "action", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "playWhenReady", "getPlayWhenReady", "isPlaying", "isPause", "playHeadDuration", "getPlayHeadDuration", "contentDurationMs", "getContentDurationMs", "bufferDuration", "getBufferDuration", "bitrate", "getBitrate", "audioBitrate", "getAudioBitrate", "currentMedia", "Lio/datazoom/sdk/model/Media;", "getCurrentMedia", "()Lio/datazoom/sdk/model/Media;", "currentWindowStart", "", "getCurrentWindowStart", "()D", MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, "getVolume", "isMuted", "defaultMuted", "getDefaultMuted", "speed", "", "getSpeed", "()F", "playerName", "getPlayerName", "()Ljava/lang/String;", "sdkVersion", "getSdkVersion", "playerId", "getPlayerId", "globalStore", "Lio/datazoom/sdk/data/memory/MetaDataStore;", "getGlobalStore", "()Lio/datazoom/sdk/data/memory/MetaDataStore;", "globalStore$delegate", "Lkotlin/Lazy;", "configStore", "Lio/datazoom/sdk/data/memory/ConfigStore;", "getConfigStore", "()Lio/datazoom/sdk/data/memory/ConfigStore;", "configStore$delegate", "stateMachine", "Lio/datazoom/sdk/stateMachine/StateMachine;", "getStateMachine", "()Lio/datazoom/sdk/stateMachine/StateMachine;", "contentSessionManager", "Lio/datazoom/sdk/domain/SessionManager;", "adSessionManager", "adBreakSessionManager", "prefStore", "Lio/datazoom/sdk/data/memory/PreferenceStore;", "globalPrefStore", "getGlobalPrefStore", "()Lio/datazoom/sdk/data/memory/PreferenceStore;", "globalPrefStore$delegate", "adManager", "Lio/datazoom/sdk/ad/AdManager;", "adMilestone", "Lio/datazoom/sdk/domain/milestones/Milestone;", "contentMilestone", "qualifiedView", "adQualifiedView", "currentConfigDto", "Lio/datazoom/sdk/model/AppConfig;", "getCurrentConfigDto", "()Lio/datazoom/sdk/model/AppConfig;", "startNewContentSession", "", "it", "milestoneCollectors", "", "Lio/datazoom/sdk/DzAdapter$MilestoneCollector;", "startMilestoneCollectors", "stopMilestoneCollectors", "attachPlaybackCoordinator", "detachPlaybackCoordinator", "id", "getId", "id$delegate", "setMetadata", "metadata", "", "getMetadata", "clearMetadata", "generateEvent", "name", "payload", "onDestroy", "resetGlobalPref", "sendEvent", "event", "Lio/datazoom/sdk/model/Event;", "defineVideoType", "mediaType", "Lio/datazoom/sdk/model/VideoType;", "addMetadataInfo", "calculateFluxData", "calculateEngagementDuration", "setFluxData", "fd", "Lio/datazoom/sdk/model/FluxData;", "getFluxData", ExifInterface.GPS_DIRECTION_TRUE, "type", "Lio/datazoom/sdk/model/FluxData$Type;", "Lio/datazoom/sdk/model/FD;", "(Lio/datazoom/sdk/model/FluxData$Type;)Ljava/lang/Object;", "setMetaData", "md", "Lio/datazoom/sdk/model/MetaData;", "Lio/datazoom/sdk/model/MetaData$Type;", "data", "setState", "state", "Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "Ljava/util/HashMap;", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Lio/datazoom/sdk/utils/DataMap;", "onAdEvent", "adEvent", "Lio/datazoom/sdk/ad/DzAdEvent;", "onAdError", "message", "code", "onAdSkip", "populateAdBreakInfo", "onVolumeChanged", "playerVolume", "onMuteChange", "mute", "onConfigArrived", "configDto", "updateMilestones", "onRoutineJobCheck", "checkIfPlaybackChanged", "updateRoutinePlayerData", "updateTimeStamps", "getTimeSince", "Lio/datazoom/sdk/model/Event$Type;", "validateContentMilestones", "validateAdMilestones", "progress", "fireHeartbeatEvent", "calculatePlayerData", "populateAdInfo", "clearPlayerInfo", "clearPlayerInfo$base", "onAdCompleted", "onAdCompleted$base", "onAdBreakEnded", "onAdBreakEnded$base", "sendCastEvent", "isCasting", "sendFullScreenEvent", "isFullScreen", "setPlayerDimensions", "setPlayerVersion", "versionName", "videoType", "getVideoType", "()Lio/datazoom/sdk/model/VideoType;", "onTrackChange", "newBitrate", "onTrackChange$base", "setCasting", "setIsLive", "isPlayingAd", "isAdLoaded", "sendResolutionChangeEvent", "lastBitrate", "getPlayHead", "onPlaybackEvent", "Lio/datazoom/sdk/utils/DzPlaybackEvent;", "notifyAdInitialise", "adSessionMetadata", "Lio/datazoom/sdk/ad/DzAdSessionMetadata;", "addPlaybackListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removePlaybackListener", "isSessionAlive", "omEnabled", "getOmEnabled", "spaceImp", "Lio/datazoom/sdk/BaseContextImp;", "getSpaceImp", "()Lio/datazoom/sdk/BaseContextImp;", "AdapterState", "MilestoneCollector", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class DzAdapter {
    private final MutableStateFlow<AdapterState> _state;
    private final SessionManager adBreakSessionManager;
    private final AdManager adManager;
    private final Milestone adMilestone;
    private final Milestone adQualifiedView;
    private final SessionManager adSessionManager;
    private final BaseContext baseContext;

    /* JADX INFO: renamed from: configStore$delegate, reason: from kotlin metadata */
    private final Lazy configStore;
    private volatile Job configStoreJob;
    private final Milestone contentMilestone;
    private final SessionManager contentSessionManager;
    private volatile StateEnv env;

    /* JADX INFO: renamed from: globalPrefStore$delegate, reason: from kotlin metadata */
    private final Lazy globalPrefStore;

    /* JADX INFO: renamed from: globalStore$delegate, reason: from kotlin metadata */
    private final Lazy globalStore;
    private volatile HeartBeat heartBeat;

    /* JADX INFO: renamed from: id$delegate, reason: from kotlin metadata */
    private final Lazy id;
    private final List<MilestoneCollector> milestoneCollectors;
    private final SafeList<Job> milestoneJobs;
    private final SafeList<AdapterCallbackListener> playbackCallbacks;
    private final PreferenceStore prefStore;
    private final Milestone qualifiedView;
    private volatile StateTransitionProcessor stateEventProcessor;
    private volatile Job stateMachineJob;
    private volatile Job timerJob;

    protected abstract int getAudioBitrate();

    protected abstract int getBitrate();

    protected abstract long getBufferDuration();

    protected abstract long getContentDurationMs();

    protected abstract Media getCurrentMedia();

    protected abstract double getCurrentWindowStart();

    protected abstract boolean getDefaultMuted();

    protected abstract long getPlayHeadDuration();

    protected abstract boolean getPlayWhenReady();

    public abstract String getPlayerId();

    protected abstract String getPlayerName();

    protected abstract String getSdkVersion();

    protected abstract float getSpeed();

    protected abstract int getVolume();

    protected abstract boolean isMuted();

    protected abstract boolean isPause();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isPlaying();

    /* JADX WARN: Multi-variable type inference failed */
    public DzAdapter(BaseContext baseContext) {
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        this.baseContext = baseContext;
        this._state = StateFlowKt.MutableStateFlow(new AdapterState(false, 0L, 0, 0, null, 0L, 63, null));
        this.playbackCallbacks = new SafeList<>();
        this.milestoneJobs = new SafeList<>();
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.globalStore = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<MetaDataStore>() { // from class: io.datazoom.sdk.DzAdapter$special$$inlined$inject$default$1
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.data.memory.MetaDataStore, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MetaDataStore invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(MetaDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode2 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.configStore = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode2, (Function0) new Function0<ConfigStore>() { // from class: io.datazoom.sdk.DzAdapter$special$$inlined$inject$default$2
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.data.memory.ConfigStore, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ConfigStore invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(ConfigStore.class), objArr2, objArr3);
            }
        });
        this.contentSessionManager = new SessionManager();
        this.adSessionManager = new SessionManager();
        this.adBreakSessionManager = new SessionManager();
        this.prefStore = new PreferenceStore();
        final StringQualifier stringQualifierNamed = QualifierKt.named("GLOBAL_PREF_MANAGER");
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode3 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        this.globalPrefStore = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode3, (Function0) new Function0<PreferenceStore>() { // from class: io.datazoom.sdk.DzAdapter$special$$inlined$inject$default$3
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.data.memory.PreferenceStore, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PreferenceStore invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(PreferenceStore.class), stringQualifierNamed, objArr4);
            }
        });
        this.adManager = new AdManager();
        MilestoneImp milestoneImp = new MilestoneImp();
        this.adMilestone = milestoneImp;
        MilestoneImp milestoneImp2 = new MilestoneImp();
        this.contentMilestone = milestoneImp2;
        QualifiedMilestoneImp qualifiedMilestoneImp = new QualifiedMilestoneImp();
        this.qualifiedView = qualifiedMilestoneImp;
        QualifiedMilestoneImp qualifiedMilestoneImp2 = new QualifiedMilestoneImp();
        this.adQualifiedView = qualifiedMilestoneImp2;
        this.milestoneCollectors = CollectionsKt.listOf((Object[]) new MilestoneCollector[]{new MilestoneCollector(milestoneImp.getStateUpdate(), new DzAdapter$milestoneCollectors$1(this, null)), new MilestoneCollector(milestoneImp2.getStateUpdate(), new DzAdapter$milestoneCollectors$2(this, null)), new MilestoneCollector(qualifiedMilestoneImp.getStateUpdate(), new DzAdapter$milestoneCollectors$3(this, null)), new MilestoneCollector(qualifiedMilestoneImp2.getStateUpdate(), new DzAdapter$milestoneCollectors$4(this, null))});
        this.heartBeat = new HeartBeat(new Function0() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DzAdapter._init_$lambda$0(this.f$0);
            }
        }, new Function0() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DzAdapter._init_$lambda$1(this.f$0));
            }
        }, new Function0() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DzAdapter._init_$lambda$2(this.f$0));
            }
        }, new Function0() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(this.f$0.isPlaying());
            }
        });
        startMilestoneCollectors();
        AppConfig appConfig = ConfigStore.get$default(getConfigStore(), null, 1, null);
        if (appConfig != null) {
            onConfigArrived(appConfig);
        }
        attachPlaybackCoordinator();
        this.id = LazyKt.lazy(new Function0() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.getSpaceImp().getId();
            }
        });
    }

    /* JADX INFO: compiled from: DzAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JL\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\t\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006#"}, d2 = {"Lio/datazoom/sdk/DzAdapter$AdapterState;", "", "isDestroyed", "", "adDuration", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "isLive", "lastPlayHeadDuration", "<init>", "(ZJIILjava/lang/Boolean;J)V", "()Z", "getAdDuration", "()J", "getWidth", "()I", "getHeight", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLastPlayHeadDuration", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZJIILjava/lang/Boolean;J)Lio/datazoom/sdk/DzAdapter$AdapterState;", "equals", "other", "hashCode", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final /* data */ class AdapterState {
        private final long adDuration;
        private final int height;
        private final boolean isDestroyed;
        private final Boolean isLive;
        private final long lastPlayHeadDuration;
        private final int width;

        public AdapterState() {
            this(false, 0L, 0, 0, null, 0L, 63, null);
        }

        public static /* synthetic */ AdapterState copy$default(AdapterState adapterState, boolean z, long j, int i, int i2, Boolean bool, long j2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z = adapterState.isDestroyed;
            }
            if ((i3 & 2) != 0) {
                j = adapterState.adDuration;
            }
            if ((i3 & 4) != 0) {
                i = adapterState.width;
            }
            if ((i3 & 8) != 0) {
                i2 = adapterState.height;
            }
            if ((i3 & 16) != 0) {
                bool = adapterState.isLive;
            }
            if ((i3 & 32) != 0) {
                j2 = adapterState.lastPlayHeadDuration;
            }
            Boolean bool2 = bool;
            int i4 = i;
            return adapterState.copy(z, j, i4, i2, bool2, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsDestroyed() {
            return this.isDestroyed;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getAdDuration() {
            return this.adDuration;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getIsLive() {
            return this.isLive;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getLastPlayHeadDuration() {
            return this.lastPlayHeadDuration;
        }

        public final AdapterState copy(boolean isDestroyed, long adDuration, int width, int height, Boolean isLive, long lastPlayHeadDuration) {
            return new AdapterState(isDestroyed, adDuration, width, height, isLive, lastPlayHeadDuration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdapterState)) {
                return false;
            }
            AdapterState adapterState = (AdapterState) other;
            return this.isDestroyed == adapterState.isDestroyed && this.adDuration == adapterState.adDuration && this.width == adapterState.width && this.height == adapterState.height && Intrinsics.areEqual(this.isLive, adapterState.isLive) && this.lastPlayHeadDuration == adapterState.lastPlayHeadDuration;
        }

        public int hashCode() {
            int iHashCode = ((((((Boolean.hashCode(this.isDestroyed) * 31) + Long.hashCode(this.adDuration)) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31;
            Boolean bool = this.isLive;
            return ((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + Long.hashCode(this.lastPlayHeadDuration);
        }

        public String toString() {
            return "AdapterState(isDestroyed=" + this.isDestroyed + ", adDuration=" + this.adDuration + ", width=" + this.width + ", height=" + this.height + ", isLive=" + this.isLive + ", lastPlayHeadDuration=" + this.lastPlayHeadDuration + ")";
        }

        public AdapterState(boolean z, long j, int i, int i2, Boolean bool, long j2) {
            this.isDestroyed = z;
            this.adDuration = j;
            this.width = i;
            this.height = i2;
            this.isLive = bool;
            this.lastPlayHeadDuration = j2;
        }

        public /* synthetic */ AdapterState(boolean z, long j, int i, int i2, Boolean bool, long j2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 0L : j, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? null : bool, (i3 & 32) != 0 ? 0L : j2);
        }

        public final boolean isDestroyed() {
            return this.isDestroyed;
        }

        public final long getAdDuration() {
            return this.adDuration;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }

        public final Boolean isLive() {
            return this.isLive;
        }

        public final long getLastPlayHeadDuration() {
            return this.lastPlayHeadDuration;
        }
    }

    public final boolean isDestroyed() {
        return this._state.getValue().isDestroyed();
    }

    private final void setDestroyed(boolean z) {
        MutableStateFlow<AdapterState> mutableStateFlow = this._state;
        while (true) {
            AdapterState value = mutableStateFlow.getValue();
            boolean z2 = z;
            if (mutableStateFlow.compareAndSet(value, AdapterState.copy$default(value, z2, 0L, 0, 0, null, 0L, 62, null))) {
                return;
            } else {
                z = z2;
            }
        }
    }

    protected final long getAdDuration() {
        return this._state.getValue().getAdDuration();
    }

    private final void setAdDuration(long j) {
        MutableStateFlow<AdapterState> mutableStateFlow = this._state;
        while (true) {
            AdapterState value = mutableStateFlow.getValue();
            long j2 = j;
            if (mutableStateFlow.compareAndSet(value, AdapterState.copy$default(value, false, j2, 0, 0, null, 0L, 61, null))) {
                return;
            } else {
                j = j2;
            }
        }
    }

    private final int getWidth() {
        return this._state.getValue().getWidth();
    }

    private final void setWidth(int i) {
        MutableStateFlow<AdapterState> mutableStateFlow = this._state;
        while (true) {
            AdapterState value = mutableStateFlow.getValue();
            int i2 = i;
            if (mutableStateFlow.compareAndSet(value, AdapterState.copy$default(value, false, 0L, i2, 0, null, 0L, 59, null))) {
                return;
            } else {
                i = i2;
            }
        }
    }

    private final int getHeight() {
        return this._state.getValue().getHeight();
    }

    private final void setHeight(int i) {
        MutableStateFlow<AdapterState> mutableStateFlow = this._state;
        while (true) {
            AdapterState value = mutableStateFlow.getValue();
            int i2 = i;
            if (mutableStateFlow.compareAndSet(value, AdapterState.copy$default(value, false, 0L, 0, i2, null, 0L, 55, null))) {
                return;
            } else {
                i = i2;
            }
        }
    }

    private final Boolean isLive() {
        return this._state.getValue().isLive();
    }

    private final void setLive(Boolean bool) {
        MutableStateFlow<AdapterState> mutableStateFlow = this._state;
        while (true) {
            AdapterState value = mutableStateFlow.getValue();
            Boolean bool2 = bool;
            if (mutableStateFlow.compareAndSet(value, AdapterState.copy$default(value, false, 0L, 0, 0, bool2, 0L, 47, null))) {
                return;
            } else {
                bool = bool2;
            }
        }
    }

    private final long getLastPlayHeadDuration() {
        return this._state.getValue().getLastPlayHeadDuration();
    }

    private final void setLastPlayHeadDuration(long j) {
        MutableStateFlow<AdapterState> mutableStateFlow = this._state;
        while (true) {
            AdapterState value = mutableStateFlow.getValue();
            long j2 = j;
            if (mutableStateFlow.compareAndSet(value, AdapterState.copy$default(value, false, 0L, 0, 0, null, j2, 31, null))) {
                return;
            } else {
                j = j2;
            }
        }
    }

    private final boolean warnIfDestroyed(String action) {
        if (!isDestroyed()) {
            return false;
        }
        Logger_androidKt.getLogger().w("DzAdapter(" + getId() + ") is already destroyed; ignoring " + action + ". Call release/onDestroy only once per adapter instance.");
        return true;
    }

    protected CoroutineScope coroutineScope() {
        return getSpaceImp().getCoroutineScope();
    }

    private final MetaDataStore getGlobalStore() {
        return (MetaDataStore) this.globalStore.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConfigStore getConfigStore() {
        return (ConfigStore) this.configStore.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StateMachine getStateMachine() {
        return getSpaceImp().get_stateMachine();
    }

    private final PreferenceStore getGlobalPrefStore() {
        return (PreferenceStore) this.globalPrefStore.getValue();
    }

    private final AppConfig getCurrentConfigDto() {
        return ConfigStore.get$default(getConfigStore(), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startNewContentSession(String it) {
        clearPlayerInfo$base();
        getStateMachine().clearHistory();
        getSpaceImp().getFluxData().clear();
        this.prefStore.clear();
        AppConfig appConfig = ConfigStore.get$default(getConfigStore(), null, 1, null);
        if (appConfig != null) {
            updateMilestones(appConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DzAdapter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J*\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJD\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032$\b\u0002\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0004HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR/\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lio/datazoom/sdk/DzAdapter$MilestoneCollector;", "", "flow", "Lkotlinx/coroutines/flow/StateFlow;", "", "emit", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/jvm/functions/Function2;)V", "getFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "getEmit", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "component1", "component2", "copy", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/jvm/functions/Function2;)Lio/datazoom/sdk/DzAdapter$MilestoneCollector;", "equals", "", "other", "hashCode", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    static final /* data */ class MilestoneCollector {
        private final Function2<Integer, Continuation<? super Unit>, Object> emit;
        private final StateFlow<Integer> flow;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MilestoneCollector copy$default(MilestoneCollector milestoneCollector, StateFlow stateFlow, Function2 function2, int i, Object obj) {
            if ((i & 1) != 0) {
                stateFlow = milestoneCollector.flow;
            }
            if ((i & 2) != 0) {
                function2 = milestoneCollector.emit;
            }
            return milestoneCollector.copy(stateFlow, function2);
        }

        public final StateFlow<Integer> component1() {
            return this.flow;
        }

        public final Function2<Integer, Continuation<? super Unit>, Object> component2() {
            return this.emit;
        }

        public final MilestoneCollector copy(StateFlow<Integer> flow, Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> emit) {
            Intrinsics.checkNotNullParameter(flow, "flow");
            Intrinsics.checkNotNullParameter(emit, "emit");
            return new MilestoneCollector(flow, emit);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MilestoneCollector)) {
                return false;
            }
            MilestoneCollector milestoneCollector = (MilestoneCollector) other;
            return Intrinsics.areEqual(this.flow, milestoneCollector.flow) && Intrinsics.areEqual(this.emit, milestoneCollector.emit);
        }

        public int hashCode() {
            return (this.flow.hashCode() * 31) + this.emit.hashCode();
        }

        public String toString() {
            return "MilestoneCollector(flow=" + this.flow + ", emit=" + this.emit + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MilestoneCollector(StateFlow<Integer> flow, Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> emit) {
            Intrinsics.checkNotNullParameter(flow, "flow");
            Intrinsics.checkNotNullParameter(emit, "emit");
            this.flow = flow;
            this.emit = emit;
        }

        public final StateFlow<Integer> getFlow() {
            return this.flow;
        }

        public final Function2<Integer, Continuation<? super Unit>, Object> getEmit() {
            return this.emit;
        }
    }

    private final void startMilestoneCollectors() {
        if (this.milestoneJobs.size() > 0) {
            return;
        }
        CoroutineScope coroutineScope = coroutineScope();
        Iterator<T> it = this.milestoneCollectors.iterator();
        while (it.hasNext()) {
            this.milestoneJobs.add(BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DzAdapter$startMilestoneCollectors$1$job$1((MilestoneCollector) it.next(), null), 3, null));
        }
    }

    private final void stopMilestoneCollectors() {
        this.milestoneJobs.forEach(new Function1() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DzAdapter.stopMilestoneCollectors$lambda$0((Job) obj);
            }
        });
        this.milestoneJobs.clear();
    }

    static final Unit stopMilestoneCollectors$lambda$0(Job it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Job.DefaultImpls.cancel$default(it, (CancellationException) null, 1, (Object) null);
        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$0(DzAdapter dzAdapter) {
        dzAdapter.fireHeartbeatEvent();
        return Unit.INSTANCE;
    }

    static final long _init_$lambda$1(DzAdapter dzAdapter) {
        AppConfig currentConfigDto = dzAdapter.getCurrentConfigDto();
        if (currentConfigDto != null) {
            return currentConfigDto.getHeartbeatIntervalMs();
        }
        return 0L;
    }

    static final boolean _init_$lambda$2(DzAdapter dzAdapter) {
        return !dzAdapter.isSessionAlive();
    }

    private final void attachPlaybackCoordinator() {
        detachPlaybackCoordinator();
        this.stateEventProcessor = new StateTransitionProcessor(this.contentSessionManager, this.adSessionManager, this.adBreakSessionManager, this.prefStore, getGlobalPrefStore(), getConfigStore(), getSpaceImp().getFluxData(), getSpaceImp().getGlobalFluxData(), getSpaceImp().getMetadata(), new AnonymousClass1(this), new Function1() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DzAdapter.attachPlaybackCoordinator$lambda$0((String) obj);
            }
        }, new AnonymousClass3(this), new AnonymousClass4(this), new AnonymousClass5(this), new AnonymousClass6(this), new AnonymousClass7(this));
        this.configStoreJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope(), null, null, new AnonymousClass8(null), 3, null);
        this.stateMachineJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope(), null, null, new AnonymousClass9(null), 3, null);
        this.timerJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope(), null, null, new AnonymousClass10(null), 3, null);
        this.env = new StateEnv(this.stateEventProcessor, new Function1() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DzAdapter.attachPlaybackCoordinator$lambda$1(this.f$0, (Event) obj);
            }
        });
        StateEnv stateEnv = this.env;
        if (stateEnv != null) {
            StateMachineExtKt.defineAndProcessStates(getStateMachine(), stateEnv);
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.DzAdapter$attachPlaybackCoordinator$1, reason: invalid class name */
    /* JADX INFO: compiled from: DzAdapter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, DzAdapter.class, "startNewContentSession", "startNewContentSession(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((DzAdapter) this.receiver).startNewContentSession(p0);
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.DzAdapter$attachPlaybackCoordinator$3, reason: invalid class name */
    /* JADX INFO: compiled from: DzAdapter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass3(Object obj) {
            super(0, obj, DzAdapter.class, "onAdCompleted", "onAdCompleted$base()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((DzAdapter) this.receiver).onAdCompleted$base();
        }
    }

    static final Unit attachPlaybackCoordinator$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.DzAdapter$attachPlaybackCoordinator$4, reason: invalid class name */
    /* JADX INFO: compiled from: DzAdapter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass4(Object obj) {
            super(0, obj, DzAdapter.class, "onAdBreakEnded", "onAdBreakEnded$base()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((DzAdapter) this.receiver).onAdBreakEnded$base();
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.DzAdapter$attachPlaybackCoordinator$5, reason: invalid class name */
    /* JADX INFO: compiled from: DzAdapter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<DzPlaybackEvent, Unit> {
        AnonymousClass5(Object obj) {
            super(1, obj, DzAdapter.class, "onPlaybackEvent", "onPlaybackEvent(Lio/datazoom/sdk/utils/DzPlaybackEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DzPlaybackEvent dzPlaybackEvent) {
            invoke2(dzPlaybackEvent);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DzPlaybackEvent p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((DzAdapter) this.receiver).onPlaybackEvent(p0);
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.DzAdapter$attachPlaybackCoordinator$6, reason: invalid class name */
    /* JADX INFO: compiled from: DzAdapter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass6(Object obj) {
            super(0, obj, DzAdapter.class, "onAdSkip", "onAdSkip()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((DzAdapter) this.receiver).onAdSkip();
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.DzAdapter$attachPlaybackCoordinator$7, reason: invalid class name */
    /* JADX INFO: compiled from: DzAdapter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<Event.Type, Long> {
        AnonymousClass7(Object obj) {
            super(1, obj, DzAdapter.class, "getTimeSince", "getTimeSince(Lio/datazoom/sdk/model/Event$Type;)J", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Long invoke(Event.Type p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return Long.valueOf(((DzAdapter) this.receiver).getTimeSince(p0));
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.DzAdapter$attachPlaybackCoordinator$8, reason: invalid class name */
    /* JADX INFO: compiled from: DzAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.DzAdapter$attachPlaybackCoordinator$8", f = "DzAdapter.kt", i = {}, l = {301}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass8(Continuation<? super AnonymousClass8> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DzAdapter.this.new AnonymousClass8(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<AppConfig> configDtoState = DzAdapter.this.getConfigStore().getConfigDtoState();
                final DzAdapter dzAdapter = DzAdapter.this;
                this.label = 1;
                if (configDtoState.collect(new FlowCollector() { // from class: io.datazoom.sdk.DzAdapter.attachPlaybackCoordinator.8.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((AppConfig) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(AppConfig appConfig, Continuation<? super Unit> continuation) {
                        dzAdapter.onConfigArrived(appConfig);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.DzAdapter$attachPlaybackCoordinator$9, reason: invalid class name */
    /* JADX INFO: compiled from: DzAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.DzAdapter$attachPlaybackCoordinator$9", f = "DzAdapter.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass9(Continuation<? super AnonymousClass9> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DzAdapter.this.new AnonymousClass9(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass9) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<Transition> transitions = DzAdapter.this.getStateMachine().getTransitions();
                final DzAdapter dzAdapter = DzAdapter.this;
                this.label = 1;
                if (transitions.collect(new FlowCollector() { // from class: io.datazoom.sdk.DzAdapter.attachPlaybackCoordinator.9.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Transition) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Transition transition, Continuation<? super Unit> continuation) {
                        PreferenceStoreExtKt.setCurrState(dzAdapter.prefStore, transition.getNewState());
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.DzAdapter$attachPlaybackCoordinator$10, reason: invalid class name */
    /* JADX INFO: compiled from: DzAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.DzAdapter$attachPlaybackCoordinator$10", f = "DzAdapter.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass10(Continuation<? super AnonymousClass10> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DzAdapter.this.new AnonymousClass10(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass10) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<TimerState> timerTick$base = DzAdapter.this.getSpaceImp().getTimerTick$base();
                final DzAdapter dzAdapter = DzAdapter.this;
                this.label = 1;
                if (timerTick$base.collect(new FlowCollector() { // from class: io.datazoom.sdk.DzAdapter.attachPlaybackCoordinator.10.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((TimerState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(TimerState timerState, Continuation<? super Unit> continuation) {
                        if (timerState.getState() == TimerState.State.PULSE && !dzAdapter.isDestroyed()) {
                            dzAdapter.onRoutineJobCheck();
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    static final Unit attachPlaybackCoordinator$lambda$1(DzAdapter dzAdapter, Event e) {
        Intrinsics.checkNotNullParameter(e, "e");
        dzAdapter.sendEvent(e);
        return Unit.INSTANCE;
    }

    private final void detachPlaybackCoordinator() {
        Job job = this.configStoreJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.configStoreJob = null;
        Job job2 = this.stateMachineJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.stateMachineJob = null;
        Job job3 = this.timerJob;
        if (job3 != null) {
            Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
        }
        this.timerJob = null;
    }

    public final String getId() {
        return (String) this.id.getValue();
    }

    public final void setMetadata(Map<String, ? extends Object> metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        if (warnIfDestroyed("setMetadata")) {
            return;
        }
        getSpaceImp().setMetadata(metadata);
    }

    public final Map<String, Object> getMetadata() {
        return warnIfDestroyed("getMetadata") ? MapsKt.emptyMap() : getSpaceImp().mo12145getMetadata();
    }

    public final void clearMetadata() {
        if (warnIfDestroyed("clearMetadata")) {
            return;
        }
        getSpaceImp().clearMetadata();
    }

    public final void generateEvent(String name, Map<String, ? extends Object> payload) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (warnIfDestroyed("generateEvent")) {
            return;
        }
        getSpaceImp().generateEvent(name, payload);
    }

    @Deprecated(message = "API warning - Please don't use it directly", replaceWith = @ReplaceWith(expression = "Datazoom.removeContext()", imports = {}))
    public void onDestroy() {
        if (warnIfDestroyed("onDestroy")) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            DzAdapter dzAdapter = this;
            setState$default(this, State.Content.STOPPED.INSTANCE, null, 2, null);
            Result.m12684constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        getSpaceImp().onDestroy();
        getStateMachine().finish();
        this.contentSessionManager.endSession();
        this.adSessionManager.endSession();
        this.adBreakSessionManager.endSession();
        this.prefStore.clear();
        detachPlaybackCoordinator();
        stopMilestoneCollectors();
        this.adMilestone.reset();
        this.contentMilestone.reset();
        this.qualifiedView.reset();
        this.adQualifiedView.reset();
        HeartBeat heartBeat = this.heartBeat;
        if (heartBeat != null) {
            heartBeat.clear();
        }
        this.heartBeat = null;
        setLive(null);
        setAdDuration(0L);
        setWidth(0);
        setHeight(0);
        resetGlobalPref();
        StateEnv stateEnv = this.env;
        if (stateEnv != null) {
            stateEnv.setProcessor(null);
        }
        StateEnv stateEnv2 = this.env;
        if (stateEnv2 != null) {
            stateEnv2.setSender(null);
        }
        this.env = null;
        this.playbackCallbacks.clear();
        StateTransitionProcessor stateTransitionProcessor = this.stateEventProcessor;
        if (stateTransitionProcessor != null) {
            stateTransitionProcessor.reset();
        }
        this.stateEventProcessor = null;
        setDestroyed(true);
        Logger_androidKt.getLogger().v("Context destroyed with adapter ID = " + getId() + " and player id = " + getPlayerId());
    }

    private final void resetGlobalPref() {
        Iterator it = CollectionsKt.listOf((Object[]) new FluxData.Type[]{FluxData.Type.NUM_REQUESTS_CONTENT, FluxData.Type.NUMBER_OF_VIDEOS_PLAYED}).iterator();
        while (it.hasNext()) {
            getSpaceImp().getGlobalFluxData().clear((FluxData.Type) it.next());
        }
    }

    public final void sendEvent(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (warnIfDestroyed("sendEvent")) {
            return;
        }
        try {
            getGlobalStore().put(MetaDataStoreExtensionsKt.to(MetaData.Type.DZ_SDK_VERSION, getSdkVersion()));
            defineVideoType(event.getVideoType());
            calculatePlayerData();
            calculateFluxData();
            updateTimeStamps();
            addMetadataInfo(event);
            getSpaceImp().sendEvent$base(event);
        } catch (Throwable th) {
            Logger logger = Logger_androidKt.getLogger();
            String message = th.getMessage();
            if (message == null) {
                message = "Unable to calculate stamps" + th.getMessage();
            }
            logger.e(message);
        }
    }

    private final void defineVideoType(VideoType mediaType) {
        if (mediaType == null) {
            mediaType = getVideoType();
        }
        if (mediaType != null) {
            setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.MEDIA_TYPE, mediaType.getName()));
        }
    }

    private final void addMetadataInfo(Event event) {
        event.getPlayer().putAll(MetaDataStoreExtensionsKt.player(getSpaceImp().getMetadata()));
        event.getVideo().putAll(MetaDataStoreExtensionsKt.video(getSpaceImp().getMetadata()));
        event.getAd().putAll(MetaDataStoreExtensionsKt.ad(getSpaceImp().getMetadata()));
    }

    private final void calculateFluxData() {
        long jStateTime$default = StateMachine.stateTime$default(getStateMachine(), State.Content.PLAYING.INSTANCE, 0L, 2, null);
        long jAdPlayingStateTime = StateMachineExtKt.adPlayingStateTime(getStateMachine());
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.PLAYBACK_DURATION_CONTENT_MS, Long.valueOf(jStateTime$default)));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.PLAYBACK_DURATION_ADS, Long.valueOf(jAdPlayingStateTime)));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.PLAYBACK_DURATION, Long.valueOf(jStateTime$default + jAdPlayingStateTime)));
        long jStateTime$default2 = StateMachine.stateTime$default(getStateMachine(), State.Content.PAUSED.INSTANCE, 0L, 2, null);
        long jStateTime$default3 = StateMachine.stateTime$default(getStateMachine(), State.Ad.PAUSED.INSTANCE, 0L, 2, null);
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.PAUSE_DURATION_ADS_MS, Long.valueOf(jStateTime$default3)));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.PAUSE_DURATION_CONTENT_MS, Long.valueOf(jStateTime$default2)));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.PAUSE_DURATION_MS, Long.valueOf(jStateTime$default2 + jStateTime$default3)));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.VOLUME_LEVEL, Integer.valueOf(getVolume())));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.PLAYBACK_RATE, Float.valueOf(getSpeed())));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.ENGAGEMENT_DURATION, Long.valueOf(calculateEngagementDuration())));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.BUFFER_LENGTH_MS, Long.valueOf(getBufferDuration())));
    }

    private final long calculateEngagementDuration() {
        Long engagementDuration = DurationsManager.INSTANCE.getEngagementDuration();
        if (engagementDuration == null) {
            return 0L;
        }
        return Time.INSTANCE.now() - engagementDuration.longValue();
    }

    public final void setFluxData(FluxData fd) {
        Intrinsics.checkNotNullParameter(fd, "fd");
        if (warnIfDestroyed("setFluxData")) {
            return;
        }
        getSpaceImp().getFluxData().put(fd);
    }

    private final <T> T getFluxData(FluxData.Type type) {
        return (T) getSpaceImp().getFluxData().get(type);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMetaData(MetaData md) {
        Intrinsics.checkNotNullParameter(md, "md");
        getSpaceImp().getMetadata().put(md);
    }

    protected final void setMetaData(MetaData.Type type, Object data) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        getSpaceImp().getMetadata().put(new MetaData(type, data));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setState$default(DzAdapter dzAdapter, State state, HashMap map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setState");
        }
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        dzAdapter.setState(state, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setState(State state, HashMap<String, Object> payload) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(payload, "payload");
        try {
            StateMachine.setState$default(getStateMachine(), state, payload, 0L, 4, null);
        } catch (Throwable th) {
            Logger logger = Logger_androidKt.getLogger();
            String message = th.getMessage();
            if (message == null) {
                message = "Unable to set state" + th.getMessage();
            }
            logger.e(message);
        }
    }

    public final void onAdEvent(DzAdEvent adEvent) {
        long progress;
        Intrinsics.checkNotNullParameter(adEvent, "adEvent");
        if (warnIfDestroyed("onAdEvent")) {
            return;
        }
        if (adEvent.getType() == DzAdEventType.STARTED) {
            populateAdBreakInfo();
            DzAd ad = adEvent.getAd();
            if (ad != null && DzAdKt.isFirstAd(ad)) {
                setState$default(this, State.Ad.Break.STARTED.INSTANCE, null, 2, null);
            }
            populateAdInfo(adEvent);
        }
        if (adEvent.getType() == DzAdEventType.LOADED) {
            PreferenceStoreExtKt.setAdLoaded(this.prefStore, true);
        }
        this.adManager.processAdEvent(adEvent, new Function1() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DzAdapter.onAdEvent$lambda$0(this.f$0, (Event) obj);
            }
        }, new Function0() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DzAdapter.onAdEvent$lambda$1(this.f$0);
            }
        }, new Function0() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DzAdapter.onAdEvent$lambda$2(this.f$0);
            }
        }, new C09451(this));
        DzAd ad2 = adEvent.getAd();
        if (ad2 != null && ad2.getProgress() == -1) {
            progress = getPlayHeadDuration();
        } else {
            DzAd ad3 = adEvent.getAd();
            progress = ad3 != null ? ad3.getProgress() : 0L;
        }
        validateAdMilestones(progress);
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.DzAdapter$onAdEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DzAdapter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    static final /* synthetic */ class C09451 extends AdaptedFunctionReference implements Function1<State, Unit> {
        C09451(Object obj) {
            super(1, obj, DzAdapter.class, "setState", "setState(Lio/datazoom/sdk/stateMachine/timeSync/model/State;Ljava/util/HashMap;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(State state) {
            invoke2(state);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(State p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            DzAdapter.setState$default((DzAdapter) this.receiver, p0, null, 2, null);
        }
    }

    static final Unit onAdEvent$lambda$1(DzAdapter dzAdapter) {
        if (dzAdapter.isPlaying()) {
            setState$default(dzAdapter, State.Content.PLAYING.INSTANCE, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    static final Unit onAdEvent$lambda$0(DzAdapter dzAdapter, Event it) {
        Intrinsics.checkNotNullParameter(it, "it");
        dzAdapter.sendEvent(it);
        return Unit.INSTANCE;
    }

    static final Unit onAdEvent$lambda$2(DzAdapter dzAdapter) {
        dzAdapter.onAdSkip();
        return Unit.INSTANCE;
    }

    public final void onAdError(String message, int code) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (warnIfDestroyed("onAdError")) {
            return;
        }
        getSpaceImp().getGlobalFluxData().incrementCounter(FluxData.Type.NUMBER_OF_ERRORS_AD);
        getSpaceImp().getGlobalFluxData().computeSum(FluxData.Type.NUMBER_OF_ERRORS, CollectionsKt.listOf((Object[]) new FluxData.Type[]{FluxData.Type.NUMBER_OF_ERRORS_AD, FluxData.Type.NUMBER_OF_ERRORS_CONTENT}));
        sendEvent(EventKt.toAdEvent$default(Event.Type.AdError, 0L, null, MapsKt.hashMapOf(TuplesKt.to(MetaData.Type.ERROR_CODE.getValue(), Integer.valueOf(code)), TuplesKt.to(MetaData.Type.ERROR_MSG.getValue(), message)), null, 11, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAdSkip() {
        onAdCompleted$base();
        PreferenceStoreExtKt.setAdStarted(this.prefStore, false);
        PreferenceStoreExtKt.setPlayingAd(this.prefStore, false);
        PreferenceStoreExtKt.setAdLoaded(this.prefStore, false);
        this.adSessionManager.endSession();
    }

    private final void populateAdBreakInfo() {
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.AD_BREAK_ID, this.adBreakSessionManager.currentSession().getId()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onVolumeChanged(long playerVolume) {
        onMuteChange(playerVolume == 0);
        sendEvent(EventKt.toEvent$default(Event.Type.VolumeChange, 0L, null, null, null, null, 31, null));
    }

    protected void onMuteChange(boolean mute) {
        PreferenceStore preferenceStore = this.prefStore;
        if (mute) {
            PreferenceStoreExtKt.setMuted(preferenceStore, true);
            sendEvent(EventKt.toEvent$default(Event.Type.Mute, 0L, null, null, null, null, 31, null));
        } else {
            if (!PreferenceStoreExtKt.isMuted(preferenceStore) || getVolume() <= 0.0d) {
                return;
            }
            PreferenceStoreExtKt.setMuted(this.prefStore, false);
            sendEvent(EventKt.toEvent$default(Event.Type.Unmute, 0L, null, null, null, null, 31, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onConfigArrived(AppConfig configDto) {
        updateMilestones(configDto);
        getSpaceImp().startTimer(200L);
    }

    private final void updateMilestones(AppConfig configDto) {
        List<Integer> contentQv = configDto.getContentQv();
        if (contentQv != null) {
            this.qualifiedView.setTarget(contentQv);
        }
        List<Integer> adQv = configDto.getAdQv();
        if (adQv != null) {
            this.adQualifiedView.setTarget(adQv);
        }
        List<Integer> contentMilestones = configDto.getContentMilestones();
        if (contentMilestones != null) {
            this.contentMilestone.setTarget(contentMilestones);
        }
        List<Integer> adMilestones = configDto.getAdMilestones();
        if (adMilestones != null) {
            this.adMilestone.setTarget(adMilestones);
        }
    }

    public void onRoutineJobCheck() {
        if (warnIfDestroyed("onRoutineJobCheck")) {
            return;
        }
        StateTransitionProcessor stateTransitionProcessor = this.stateEventProcessor;
        if (stateTransitionProcessor != null) {
            StateTransitionProcessor.updateDurations$default(stateTransitionProcessor, 0L, 1, null);
        }
        updateRoutinePlayerData();
        HeartBeat heartBeat = this.heartBeat;
        if (heartBeat != null) {
            heartBeat.onPlayHeadUpdate();
        }
        HeartBeat heartBeat2 = this.heartBeat;
        if (heartBeat2 != null) {
            heartBeat2.checkHeartbeat();
        }
        validateContentMilestones();
        checkIfPlaybackChanged();
    }

    private final void checkIfPlaybackChanged() {
        if (getLastPlayHeadDuration() != getPlayHeadDuration()) {
            this.playbackCallbacks.forEach(new Function1() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DzAdapter.checkIfPlaybackChanged$lambda$0(this.f$0, (AdapterCallbackListener) obj);
                }
            });
            setLastPlayHeadDuration(getPlayHeadDuration());
        }
    }

    static final Unit checkIfPlaybackChanged$lambda$0(DzAdapter dzAdapter, AdapterCallbackListener it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onPlaybackUpdate(dzAdapter.getPlayHeadDuration(), Intrinsics.areEqual((Object) dzAdapter.isLive(), (Object) true) ? Double.valueOf(dzAdapter.getCurrentWindowStart()) : null);
        return Unit.INSTANCE;
    }

    private final void updateRoutinePlayerData() {
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.PLAY_HEAD_POSITION, Long.valueOf(PrimitiveExtensionsKt.dividedBy(Long.valueOf(getPlayHeadDuration()), 1000L))));
    }

    private final void updateTimeStamps() {
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_AD_BREAK_START, Long.valueOf(getTimeSince(Event.Type.AdBreakStart))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_AD_PAUSED, Long.valueOf(getTimeSince(Event.Type.AdPause))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_AD_STARTED, Long.valueOf(getTimeSince(Event.Type.PlaybackStartAd))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_STARTED, Long.valueOf(getTimeSince(Event.Type.PlaybackStart))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_BUFFER_START, Long.valueOf(getTimeSince(Event.Type.BufferStart))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_BUFFER_START_MS, Long.valueOf(getTimeSince(Event.Type.BufferStart))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_LAST_BUFFER_START_CONTENT_MS, Long.valueOf(getTimeSince(Event.Type.BufferStart))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_LAST_HEARTBEAT, Long.valueOf(getTimeSince(Event.Type.Heartbeat))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_LAST_MILESTONE, Long.valueOf(getTimeSince(Event.Type.Milestone))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_LAST_RENDITION_CHANGE, Long.valueOf(getTimeSince(Event.Type.RenditionChange))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_LAST_STALL_START_CONTENT_MS, Long.valueOf(getTimeSince(Event.Type.StallStarted))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_PAUSED, Long.valueOf(getTimeSince(Event.Type.Pause))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_REQUESTED, Long.valueOf(getTimeSince(Event.Type.MediaRequest))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_SEEK_START, Long.valueOf(getTimeSince(Event.Type.SeekEnd))));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.TIME_SINCE_STALL_START, Long.valueOf(getTimeSince(Event.Type.StallStarted))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getTimeSince(Event.Type event) {
        return getSpaceImp().getEventTimeSince(event);
    }

    private final void validateContentMilestones() {
        long jStateTime$default = StateMachine.stateTime$default(getStateMachine(), State.Content.PLAYING.INSTANCE, 0L, 2, null);
        if (PreferenceStoreExtKt.isPlayingAd(this.prefStore)) {
            return;
        }
        Boolean boolIsLive = isLive();
        if (boolIsLive != null && !boolIsLive.booleanValue()) {
            this.contentMilestone.updateProgress(getPlayHeadDuration(), getContentDurationMs());
        }
        this.qualifiedView.updateProgress(PrimitiveExtensionsKt.dividedBy(Long.valueOf(jStateTime$default), 1000L), 0L);
    }

    private final void validateAdMilestones(long progress) {
        if (PreferenceStoreExtKt.isPlayingAd(this.prefStore)) {
            this.adMilestone.updateProgress(progress, getAdDuration());
            this.adQualifiedView.updateProgress(PrimitiveExtensionsKt.dividedBy(Long.valueOf(progress), 1000L), 0L);
        }
    }

    private final void fireHeartbeatEvent() {
        PreferenceStore preferenceStore = this.prefStore;
        PreferenceStoreExtKt.setHeartbeatCount(preferenceStore, PreferenceStoreExtKt.getHeartbeatCount(preferenceStore) + 1);
        Event.Type type = Event.Type.Heartbeat;
        HashMap map = new HashMap();
        map.put(MetaData.Type.HEARTBEAT_COUNT.getValue(), Integer.valueOf(PreferenceStoreExtKt.getHeartbeatCount(this.prefStore)));
        Unit unit = Unit.INSTANCE;
        sendEvent(EventKt.toEvent$default(type, 0L, null, map, null, null, 27, null));
    }

    public void calculatePlayerData() {
        if (warnIfDestroyed("calculatePlayerData")) {
            return;
        }
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.READY_STATE, Boolean.valueOf(getPlayWhenReady())));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.PLAYER_NAME, getPlayerName()));
        Boolean boolIsLive = isLive();
        if (boolIsLive != null) {
            setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.STREAMING_TYPE, boolIsLive.booleanValue() ? "Live" : "VOD"));
        }
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.DURATION, Long.valueOf(getContentDurationMs() / 1000)));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.DEFAULT_MUTED, Boolean.valueOf(isMuted())));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.MUTED, Boolean.valueOf(isMuted())));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.AUTOSTART, Boolean.valueOf(getPlayWhenReady())));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.CONTROLS, false));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.PLAYER_HEIGHT, Integer.valueOf(getHeight())));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.PLAYER_WIDTH, Integer.valueOf(getWidth())));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.PLAYBACK_RATE_DEFAULT, Float.valueOf(getSpeed())));
        MetaData.Type type = MetaData.Type.CASTING;
        Object obj = getSpaceImp().getMetadata().get(MetaData.Type.CASTING);
        if (obj == null) {
            obj = false;
        }
        setMetaData(type, obj);
    }

    public void populateAdInfo(DzAdEvent adEvent) {
        DzAd ad;
        Intrinsics.checkNotNullParameter(adEvent, "adEvent");
        if (warnIfDestroyed("populateAdInfo") || (ad = adEvent.getAd()) == null) {
            return;
        }
        setAdDuration(ad.getDuration());
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.AD_SESSION_ID, this.adSessionManager.currentSession().getId()));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.AD_ID, ad.getId()));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.AD_POSITION, ad.getPosition().getName()));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.AD_TIME_OFFSET, Long.valueOf(ad.getSkipTimeOffset())));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.AD_SYSTEM, ad.getAdSystem()));
        String adClickUrl = ad.getAdClickUrl();
        if (adClickUrl != null) {
            setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.AD_CLICK_URL, adClickUrl));
        }
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.AD_DURATION_SEC, Long.valueOf(ad.getDuration() / 1000)));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.AD_BREAK_ID, this.adBreakSessionManager.currentSession().getId()));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.AD_CREATIVE_ID, ad.getCreativeId()));
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.AD_PARTNER, ad.getAdvertiserName()));
    }

    public void clearPlayerInfo$base() {
        getSpaceImp().getMetadata().remove(CollectionsKt.listOf((Object[]) new MetaData.Type[]{MetaData.Type.MEDIA_TYPE, MetaData.Type.READY_STATE, MetaData.Type.STREAMING_TYPE, MetaData.Type.DURATION, MetaData.Type.DEFAULT_MUTED, MetaData.Type.MUTED, MetaData.Type.AUTOSTART, MetaData.Type.CONTROLS, MetaData.Type.CASTING, MetaData.Type.PLAYER_HEIGHT, MetaData.Type.PLAYER_WIDTH, MetaData.Type.ORIENTATION}));
    }

    public void onAdCompleted$base() {
        getSpaceImp().getMetadata().remove(CollectionsKt.listOf((Object[]) new MetaData.Type[]{MetaData.Type.AD_ID, MetaData.Type.AD_POSITION, MetaData.Type.AD_TIME_OFFSET, MetaData.Type.AD_SYSTEM, MetaData.Type.AD_CLICK_URL, MetaData.Type.AD_DURATION_SEC, MetaData.Type.AD_CREATIVE_ID, MetaData.Type.AD_PARTNER, MetaData.Type.AD_SESSION_ID}));
        setAdDuration(0L);
        this.adMilestone.reset();
        this.adQualifiedView.reset();
        AppConfig currentConfigDto = getCurrentConfigDto();
        if (currentConfigDto != null) {
            Milestone milestone = this.adMilestone;
            List<Integer> adMilestones = currentConfigDto.getAdMilestones();
            if (adMilestones == null) {
                adMilestones = CollectionsKt.emptyList();
            }
            milestone.setTarget(adMilestones);
            Milestone milestone2 = this.adQualifiedView;
            List<Integer> adQv = currentConfigDto.getAdQv();
            if (adQv == null) {
                adQv = CollectionsKt.emptyList();
            }
            milestone2.setTarget(adQv);
        }
    }

    public void onAdBreakEnded$base() {
        getSpaceImp().getMetadata().remove(CollectionsKt.listOf(MetaData.Type.AD_BREAK_ID));
    }

    public final void sendCastEvent(boolean isCasting) {
        if (warnIfDestroyed("sendCastEvent")) {
            return;
        }
        if (isCasting) {
            sendEvent(EventKt.toEvent$default(Event.Type.CastStart, 0L, null, null, null, null, 31, null));
        } else {
            sendEvent(EventKt.toEvent$default(Event.Type.CastEnd, 0L, null, null, null, null, 31, null));
        }
        setCasting(isCasting);
    }

    public final void sendFullScreenEvent(boolean isFullScreen) {
        if (warnIfDestroyed("sendFullScreenEvent")) {
            return;
        }
        if (isFullScreen) {
            sendEvent(EventKt.toEvent$default(Event.Type.Fullscreen, 0L, null, null, null, null, 31, null));
        } else {
            sendEvent(EventKt.toEvent$default(Event.Type.ExitFullscreen, 0L, null, null, null, null, 31, null));
        }
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.FULLSCREEN, Boolean.valueOf(isFullScreen)));
    }

    public final void setPlayerDimensions(int height, int width) {
        if (warnIfDestroyed("setPlayerDimensions")) {
            return;
        }
        setWidth(width);
        setHeight(height);
    }

    public final void setPlayerVersion(String versionName) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        if (warnIfDestroyed("setPlayerVersion")) {
            return;
        }
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.PLAYER_VERSION, versionName));
    }

    private final VideoType getVideoType() {
        if (PreferenceStoreExtKt.isPlayingAd(this.prefStore)) {
            return VideoType.AD.INSTANCE;
        }
        if (PreferenceStoreExtKt.isContentStarted(this.prefStore)) {
            return VideoType.CONTENT.INSTANCE;
        }
        return null;
    }

    public final void onTrackChange$base(int width, int height, int newBitrate) {
        if (width == 0 || height == 0 || newBitrate == 0) {
            return;
        }
        Integer num = (Integer) getFluxData(FluxData.Type.BITRATE);
        int iIntValue = num != null ? num.intValue() : 0;
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.RENDITION_HEIGHT, Integer.valueOf(height)));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.RENDITION_NAME, height + ContextChain.TAG_PRODUCT));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.RENDITION_WIDTH, Integer.valueOf(width)));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.BITRATE, Integer.valueOf(newBitrate)));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.RENDITION_VIDEO_BITRATE_KBPS, Integer.valueOf(newBitrate)));
        setFluxData(FluxDataStoreExtensionsKt.to(FluxData.Type.RENDITION_AUDIO_BITRATE_KBPS, Integer.valueOf(getAudioBitrate())));
        sendResolutionChangeEvent(newBitrate, iIntValue);
    }

    private final void setCasting(boolean isCasting) {
        setMetaData(MetaDataStoreExtensionsKt.to(MetaData.Type.CASTING, Boolean.valueOf(isCasting)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setIsLive(boolean isLive) {
        setLive(Boolean.valueOf(isLive));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isPlayingAd() {
        return PreferenceStoreExtKt.isPlayingAd(this.prefStore);
    }

    protected final boolean isAdLoaded() {
        return PreferenceStoreExtKt.isAdLoaded(this.prefStore);
    }

    private final void sendResolutionChangeEvent(int bitrate, int lastBitrate) {
        if (lastBitrate <= 0 || bitrate <= 0 || lastBitrate == bitrate) {
            return;
        }
        Event.Type type = Event.Type.RenditionChange;
        Pair[] pairArr = new Pair[1];
        pairArr[0] = TuplesKt.to(MetaData.Type.ABS_SHIFT.getValue(), lastBitrate > bitrate ? GesturesListener.SCROLL_DIRECTION_DOWN : GesturesListener.SCROLL_DIRECTION_UP);
        sendEvent(EventKt.toEvent$default(type, 0L, null, MapsKt.hashMapOf(pairArr), null, null, 27, null));
    }

    public final long getPlayHead() {
        if (warnIfDestroyed("getPlayHead")) {
            return 0L;
        }
        return getPlayHeadDuration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPlaybackEvent(final DzPlaybackEvent event) {
        this.playbackCallbacks.forEach(new Function1() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DzAdapter.onPlaybackEvent$lambda$0(event, (AdapterCallbackListener) obj);
            }
        });
    }

    static final Unit onPlaybackEvent$lambda$0(DzPlaybackEvent dzPlaybackEvent, AdapterCallbackListener it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onAdPlaybackEvents(dzPlaybackEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyAdInitialise(final DzAdSessionMetadata adSessionMetadata) {
        Intrinsics.checkNotNullParameter(adSessionMetadata, "adSessionMetadata");
        this.playbackCallbacks.forEach(new Function1() { // from class: io.datazoom.sdk.DzAdapter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DzAdapter.notifyAdInitialise$lambda$0(adSessionMetadata, this, (AdapterCallbackListener) obj);
            }
        });
    }

    static final Unit notifyAdInitialise$lambda$0(DzAdSessionMetadata dzAdSessionMetadata, DzAdapter dzAdapter, AdapterCallbackListener it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger_androidKt.getLogger().v("Notifying ad initialise for ad id " + dzAdSessionMetadata.getAdId() + ", session id " + dzAdSessionMetadata.getSessionId());
        Double startTimeInSeconds = dzAdSessionMetadata.getStartTimeInSeconds();
        it.onAdInitialise(DzAdSessionMetadata.copy$default(dzAdSessionMetadata, null, null, null, Double.valueOf(startTimeInSeconds != null ? startTimeInSeconds.doubleValue() : PrimitiveExtensionsKt.dividedBy(Long.valueOf(dzAdapter.getPlayHeadDuration()), 1000L)), 7, null));
        return Unit.INSTANCE;
    }

    public final void addPlaybackListener(AdapterCallbackListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (warnIfDestroyed("addPlaybackListener")) {
            return;
        }
        this.playbackCallbacks.add(listener);
    }

    public final void removePlaybackListener(AdapterCallbackListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (warnIfDestroyed("removePlaybackListener")) {
            return;
        }
        this.playbackCallbacks.remove(listener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isSessionAlive() {
        return this.contentSessionManager.isAlive() || this.adSessionManager.isAlive();
    }

    public final boolean getOmEnabled() {
        AppConfig currentConfigDto = getCurrentConfigDto();
        if (currentConfigDto != null) {
            return currentConfigDto.getOmEnabled();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseContextImp getSpaceImp() {
        BaseContext baseContext = this.baseContext;
        BaseContextImp baseContextImp = baseContext instanceof BaseContextImp ? (BaseContextImp) baseContext : null;
        if (baseContextImp != null) {
            return baseContextImp;
        }
        throw new IllegalArgumentException("DzAdapter requires a Internal Space Implementation instance.");
    }
}
