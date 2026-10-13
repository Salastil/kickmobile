package androidx.compose.runtime;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableKt;
import androidx.compose.runtime.composer.linkbuffer.changelist.ChangeList;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.ObservableComposition;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.interfaces.permissions.PermissionsResponse;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Composition.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010R\u001a\u00020OH\u0002J\b\u0010S\u001a\u000206H\u0002J \u0010e\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010_J \u0010g\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010_J \u0010h\u001a\u00020i2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010jJ \u0010k\u001a\u00020i2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010jJ\u001d\u0010l\u001a\u00020Z2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010nH\u0000¢\u0006\u0002\bpJ \u0010q\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0002¢\u0006\u0002\u0010_J(\u0010r\u001a\u00020i2\u0006\u0010s\u001a\u00020;2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0002¢\u0006\u0002\u0010tJ \u0010u\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0002¢\u0006\u0002\u0010_J\b\u0010v\u001a\u00020ZH\u0002J\b\u0010w\u001a\u00020;H\u0002J\u0010\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020{H\u0016J\u000e\u0010|\u001a\u00020Z2\u0006\u0010}\u001a\u00020GJ\b\u0010~\u001a\u00020ZH\u0002J\b\u0010\u007f\u001a\u00020ZH\u0002J\t\u0010\u0080\u0001\u001a\u00020ZH\u0002J!\u0010\u0081\u0001\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0017¢\u0006\u0002\u0010_J\u000f\u0010\u0082\u0001\u001a\u00020ZH\u0000¢\u0006\u0003\b\u0083\u0001J\t\u0010\u0084\u0001\u001a\u00020ZH\u0016J\u0018\u0010\u0087\u0001\u001a\u00020Z2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110'H\u0016J\u0018\u0010\u0089\u0001\u001a\u00020;2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110'H\u0016J\u0018\u0010\u008a\u0001\u001a\u00020Z2\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020Z0YH\u0016J,\u0010\u008c\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110\u008d\u0001022\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0000¢\u0006\u0003\b\u0090\u0001J:\u0010\u0091\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110\u008d\u0001022\u0015\u0010\u0092\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u008f\u0001\u0012\u0004\u0012\u00020;0\u0093\u0001H\u0080\b¢\u0006\u0003\b\u0094\u0001J\u001b\u0010\u0095\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020\u00112\u0007\u0010\u0097\u0001\u001a\u00020;H\u0002J!\u0010\u0095\u0001\u001a\u00020Z2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110'2\u0007\u0010\u0097\u0001\u001a\u00020;H\u0002J\t\u0010\u0098\u0001\u001a\u00020ZH\u0002J\u0012\u0010\u0099\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020\u0011H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u009b\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u009c\u0001\u001a\u00020;H\u0016J)\u0010\u009d\u0001\u001a\u00020Z2\u001e\u0010\u009e\u0001\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u009f\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009f\u00010\u008d\u000102H\u0016J\u0012\u0010 \u0001\u001a\u00020Z2\u0007\u0010U\u001a\u00030¡\u0001H\u0016J\u0011\u0010¢\u0001\u001a\u00020Z2\u0006\u00105\u001a\u000206H\u0002J\t\u0010£\u0001\u001a\u00020ZH\u0016J\t\u0010¤\u0001\u001a\u00020ZH\u0016J\t\u0010¥\u0001\u001a\u00020ZH\u0016JL\u0010¦\u0001\u001a\u0003H§\u0001\"\u0005\b\u0000\u0010§\u000122\u0010\u008b\u0001\u001a-\u0012!\u0012\u001f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#¢\u0006\u000e\b¨\u0001\u0012\t\b©\u0001\u0012\u0004\b\b(5\u0012\u0005\u0012\u0003H§\u00010\u0093\u0001H\u0082\b¢\u0006\u0003\u0010ª\u0001J(\u0010«\u0001\u001a\u0003H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000e\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u0003H§\u00010YH\u0082\b¢\u0006\u0003\u0010¬\u0001J\t\u0010\u00ad\u0001\u001a\u00020ZH\u0016J\t\u0010®\u0001\u001a\u00020ZH\u0016J\t\u0010¯\u0001\u001a\u00020ZH\u0016J;\u0010°\u0001\u001a\u0003H±\u0001\"\u0005\b\u0000\u0010±\u00012\t\u0010²\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010³\u0001\u001a\u00020G2\u000e\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u0003H±\u00010YH\u0016¢\u0006\u0003\u0010´\u0001J\u0015\u0010µ\u0001\u001a\u0004\u0018\u00010B2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001e\u0010¶\u0001\u001a\u00030·\u00012\u0007\u0010¸\u0001\u001a\u00020$2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010º\u0001\u001a\u00020Z2\u0007\u0010¸\u0001\u001a\u00020$H\u0016J)\u0010»\u0001\u001a\u0005\u0018\u0001H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000e\u0010}\u001a\n\u0012\u0005\u0012\u0003H§\u00010¼\u0001H\u0016¢\u0006\u0003\u0010½\u0001J\u001d\u0010¾\u0001\u001a\u00020;2\u0007\u0010¸\u0001\u001a\u00020$2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0011H\u0002J(\u0010¿\u0001\u001a\u00030·\u00012\u0007\u0010¸\u0001\u001a\u00020$2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0011H\u0002J!\u0010À\u0001\u001a\u00020Z2\u0007\u0010¹\u0001\u001a\u00020\u00112\u0007\u0010¸\u0001\u001a\u00020$H\u0000¢\u0006\u0003\bÁ\u0001J\u001b\u0010Â\u0001\u001a\u00020Z2\n\u0010U\u001a\u0006\u0012\u0002\b\u00030.H\u0000¢\u0006\u0003\bÃ\u0001J\u001e\u0010Ä\u0001\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#H\u0002¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J(\u0010Ç\u0001\u001a\u0003H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000e\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u0003H§\u00010YH\u0082\b¢\u0006\u0003\u0010¬\u0001J\n\u0010z\u001a\u0004\u0018\u00010{H\u0002J\t\u0010È\u0001\u001a\u00020ZH\u0016J\u000f\u0010É\u0001\u001a\u00020GH\u0000¢\u0006\u0003\bÊ\u0001R\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\u00060\u0011j\u0002`\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110'8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020$0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020$0+X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030.0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110'8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u0010)R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020$028AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001c\u00109\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R \u0010:\u001a\u00020;X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010\u001b\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\u00020IX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010N\u001a\u00020OX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010T\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\bT\u0010>R\u000e\u0010U\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\u00020;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010>R'\u0010X\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[X\u0086\u000e¢\u0006\u0010\n\u0002\u0010`\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010>R\u0014\u0010b\u001a\u00020;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010>R\u0014\u0010c\u001a\u00020;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010>R\u0016\u0010\u0085\u0001\u001a\u00020;8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010>¨\u0006Ë\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "Landroidx/compose/runtime/PausableComposition;", "Landroidx/compose/runtime/tooling/ObservableComposition;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "<init>", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;)V", "getParent", "()Landroidx/compose/runtime/CompositionContext;", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "getAbandonSet$annotations", "()V", "slotStorage", "Landroidx/compose/runtime/SlotStorage;", "getSlotStorage$runtime$annotations", "getSlotStorage$runtime", "()Landroidx/compose/runtime/SlotStorage;", "createSlotStorage", "observations", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/collection/MutableScatterMap;", "observedObjects", "", "getObservedObjects$runtime", "()Ljava/util/Set;", "invalidatedScopes", "Landroidx/collection/MutableScatterSet;", "conditionallyInvalidatedScopes", "derivedStates", "Landroidx/compose/runtime/DerivedState;", "derivedStateDependencies", "getDerivedStateDependencies$runtime", "conditionalScopes", "", "getConditionalScopes$runtime", "()Ljava/util/List;", "changes", "Landroidx/compose/runtime/Changes;", "lateChanges", "observationsProcessed", "invalidations", "pendingInvalidScopes", "", "getPendingInvalidScopes$runtime$annotations", "getPendingInvalidScopes$runtime", "()Z", "setPendingInvalidScopes$runtime", "(Z)V", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "pendingPausedComposition", "Landroidx/compose/runtime/PausedCompositionImpl;", "invalidationDelegate", "invalidationDelegateGroup", "", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "rememberManager", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "composer", "Landroidx/compose/runtime/InternalComposer;", "getComposer$runtime", "()Landroidx/compose/runtime/InternalComposer;", "createComposer", "createChangeList", "isRoot", "state", "areChildrenComposing", "getAreChildrenComposing", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "isComposing", "isDisposed", "hasPendingChanges", "getHasPendingChanges", "setContent", "content", "setContentWithReuse", "setPausableContent", "Landroidx/compose/runtime/PausedComposition;", "(Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/PausedComposition;", "setPausableContentWithReuse", "pausedCompositionFinished", "ignoreSet", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/RememberObserverHolder;", "pausedCompositionFinished$runtime", "composeInitial", "composeInitialPaused", "reusable", "(ZLkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/PausedComposition;", "composeInitialWithReuse", "ensureRunning", "clearDeactivated", "setObserver", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "invalidateGroupsWithKey", "key", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "drainPendingModificationsOutOfBandLocked", "composeContent", "updateMovingInvalidations", "updateMovingInvalidations$runtime", "dispose", "hasInvalidations", "getHasInvalidations", "recordModificationsOf", "values", "observesAnyOf", "prepareCompose", "block", "extractInvalidationsOf", "Lkotlin/Pair;", LinkHeader.Parameters.Anchor, "Landroidx/compose/runtime/Anchor;", "extractInvalidationsOf$runtime", "extractInvalidationsOfGroup", "inGroup", "Lkotlin/Function1;", "extractInvalidationsOfGroup$runtime", "addPendingInvalidationsLocked", "value", "forgetConditionalScopes", "cleanUpDerivedStateObservations", "recordReadOf", "invalidateScopeOfLocked", "recordWriteOf", "recompose", "insertMovableContent", "references", "Landroidx/compose/runtime/MovableContentStateReference;", "disposeUnusedMovableContent", "Landroidx/compose/runtime/MovableContentState;", "applyChangesInLocked", "applyChanges", "applyLateChanges", "changesApplied", "guardInvalidationsLocked", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "guardChanges", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "abandonChanges", "invalidateAll", "verifyConsistent", "delegateInvalidations", "R", "to", "groupIndex", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAndSetShouldPauseCallback", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", PermissionsResponse.SCOPE_KEY, "instance", "recomposeScopeReleased", "getCompositionService", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "tryImminentInvalidation", "invalidateChecked", "removeObservation", "removeObservation$runtime", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime", "takeInvalidations", "takeInvalidations-afanTW4", "()Landroidx/collection/MutableScatterMap;", "trackAbandonedValues", "deactivate", "composerStacksSizes", "composerStacksSizes$runtime", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices, PausableComposition, ObservableComposition {
    public static final int $stable = 8;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final Changes changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final InternalComposer composer;
    private final MutableScatterSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final MutableScatterMap<Object, Object> derivedStates;
    private final MutableScatterSet<RecomposeScopeImpl> invalidatedScopes;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private MutableScatterMap<Object, Object> invalidations;
    private final boolean isRoot;
    private final Changes lateChanges;
    private final MutableScatterMap<Object, Object> observations;
    private final MutableScatterMap<Object, Object> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private PausedCompositionImpl pendingPausedComposition;
    private final RememberEventDispatcher rememberManager;
    private ShouldPauseCallback shouldPause;
    private final SlotStorage slotStorage;
    private int state;
    private final AtomicReference<Object> pendingModifications = new AtomicReference<>(null);
    private final Object lock = new Object();

    private static /* synthetic */ void getAbandonSet$annotations() {
    }

    public static /* synthetic */ void getPendingInvalidScopes$runtime$annotations() {
    }

    public static /* synthetic */ void getSlotStorage$runtime$annotations() {
    }

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier) {
        this.parent = compositionContext;
        this.applier = applier;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i = 0;
        int i2 = 1;
        this.abandonSet = new MutableScatterSet(i, i2, defaultConstructorMarker).asMutableSet();
        SlotStorage slotStorageCreateSlotStorage = createSlotStorage();
        if (compositionContext.getCollectingCallByInformation$runtime()) {
            slotStorageCreateSlotStorage.collectCalledByInformation();
        }
        if (compositionContext.getCollectingSourceInformation()) {
            slotStorageCreateSlotStorage.collectSourceInformation();
        }
        this.slotStorage = slotStorageCreateSlotStorage;
        this.observations = ScopeMap.m6478constructorimpl$default(null, 1, null);
        this.invalidatedScopes = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
        this.conditionallyInvalidatedScopes = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
        this.derivedStates = ScopeMap.m6478constructorimpl$default(null, 1, null);
        this.changes = createChangeList();
        this.lateChanges = createChangeList();
        this.observationsProcessed = ScopeMap.m6478constructorimpl$default(null, 1, null);
        this.invalidations = ScopeMap.m6478constructorimpl$default(null, 1, null);
        this.observerHolder = new CompositionObserverHolder(null, false, compositionContext, 3, null);
        this.rememberManager = new RememberEventDispatcher();
        InternalComposer internalComposerCreateComposer = createComposer();
        compositionContext.registerComposer$runtime(internalComposerCreateComposer);
        this.composer = internalComposerCreateComposer;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$954879418$runtime();
    }

    public final CompositionContext getParent() {
        return this.parent;
    }

    /* JADX INFO: renamed from: getSlotStorage$runtime, reason: from getter */
    public final SlotStorage getSlotStorage() {
        return this.slotStorage;
    }

    private final SlotStorage createSlotStorage() {
        if (ComposeRuntimeFlags.isLinkBufferComposerEnabled) {
            return new SlotTable(0, null, false, false, 15, null);
        }
        return new androidx.compose.runtime.composer.gapbuffer.SlotTable();
    }

    public final Set<Object> getObservedObjects$runtime() {
        return this.observations.asMap().keySet();
    }

    public final Set<Object> getDerivedStateDependencies$runtime() {
        return this.derivedStates.asMap().keySet();
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes.asSet());
    }

    /* JADX INFO: renamed from: getPendingInvalidScopes$runtime, reason: from getter */
    public final boolean getPendingInvalidScopes() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime(boolean z) {
        this.pendingInvalidScopes = z;
    }

    /* JADX INFO: renamed from: getObserverHolder$runtime, reason: from getter */
    public final CompositionObserverHolder getObserverHolder() {
        return this.observerHolder;
    }

    /* JADX INFO: renamed from: getComposer$runtime, reason: from getter */
    public final InternalComposer getComposer() {
        return this.composer;
    }

    private final InternalComposer createComposer() {
        boolean z = ComposeRuntimeFlags.isLinkBufferComposerEnabled;
        Applier<?> applier = this.applier;
        if (z) {
            return new LinkComposer(applier, this.parent, this.abandonSet, SlotTableKt.asLinkBufferSlotTable(this.slotStorage), this.changes, this.lateChanges, this.observerHolder, this);
        }
        return new GapComposer(applier, this.parent, androidx.compose.runtime.composer.gapbuffer.SlotTableKt.asGapBufferSlotTable(this.slotStorage), this.abandonSet, this.changes, this.lateChanges, this.observerHolder, this);
    }

    private final Changes createChangeList() {
        if (ComposeRuntimeFlags.isLinkBufferComposerEnabled) {
            return new ChangeList();
        }
        return new androidx.compose.runtime.composer.gapbuffer.changelist.ChangeList();
    }

    /* JADX INFO: renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composable = function2;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.getIsComposing();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.state == 3;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime;
        synchronized (this.lock) {
            hasPendingChanges$runtime = this.composer.getHasPendingChanges$runtime();
        }
        return hasPendingChanges$runtime;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        boolean zClearDeactivated = clearDeactivated();
        ensureRunning();
        if (zClearDeactivated) {
            composeInitialWithReuse(content);
        } else {
            composeInitial(content);
        }
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void setContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        clearDeactivated();
        ensureRunning();
        composeInitialWithReuse(content);
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContent(Function2<? super Composer, ? super Integer, Unit> content) {
        return composeInitialPaused(clearDeactivated(), content);
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        clearDeactivated();
        ensureRunning();
        return composeInitialPaused(true, content);
    }

    public final void pausedCompositionFinished$runtime(ScatterSet<RememberObserverHolder> ignoreSet) {
        this.pendingPausedComposition = null;
        if (ignoreSet != null) {
            this.rememberManager.ignoreForgotten(ignoreSet);
            this.state = 2;
        }
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> content) {
        this.composable = content;
        this.parent.composeInitial$runtime(this, content);
    }

    private final PausedComposition composeInitialPaused(boolean reusable, Function2<? super Composer, ? super Integer, Unit> content) {
        if (!(this.pendingPausedComposition == null)) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }
        PausedCompositionImpl pausedCompositionImpl = new PausedCompositionImpl(this, this.parent, this.composer, this.abandonSet, content, reusable, this.applier, this.lock);
        this.pendingPausedComposition = pausedCompositionImpl;
        return pausedCompositionImpl;
    }

    private final void composeInitialWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        this.composer.startReuseFromRoot$runtime();
        composeInitial(content);
        this.composer.endReuseFromRoot$runtime();
    }

    private final void ensureRunning() {
        String str;
        int i = this.state;
        if (!(i == 0)) {
            if (i == 1) {
                str = "The composition should be activated before setting content.";
            } else if (i == 2) {
                str = "A previous pausable composition for this composition was cancelled. This composition must be disposed.";
            } else if (i == 3) {
                str = "The composition is disposed";
            } else {
                str = "";
            }
            PreconditionsKt.throwIllegalStateException(str);
        }
        if (this.pendingPausedComposition == null) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
    }

    private final boolean clearDeactivated() {
        boolean z;
        synchronized (this.lock) {
            z = true;
            if (this.state != 1) {
                z = false;
            }
            if (z) {
                this.state = 0;
            }
        }
        return z;
    }

    @Override // androidx.compose.runtime.tooling.ObservableComposition
    public CompositionObserverHandle setObserver(final CompositionObserver observer) {
        synchronized (this.lock) {
            this.observerHolder.setObserver(observer);
            this.observerHolder.setRoot(true);
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.CompositionImpl.setObserver.2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object obj = CompositionImpl.this.lock;
                CompositionImpl compositionImpl = CompositionImpl.this;
                CompositionObserver compositionObserver = observer;
                synchronized (obj) {
                    if (Intrinsics.areEqual(compositionImpl.getObserverHolder().getObserver(), compositionObserver)) {
                        compositionImpl.getObserverHolder().setObserver(null);
                        compositionImpl.getObserverHolder().setRoot(false);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        };
    }

    public final void invalidateGroupsWithKey(int key) {
        List<RecomposeScopeImpl> listInvalidateGroupsWithKey;
        synchronized (this.lock) {
            listInvalidateGroupsWithKey = this.slotStorage.invalidateGroupsWithKey(key);
        }
        if (listInvalidateGroupsWithKey != null) {
            int size = listInvalidateGroupsWithKey.size();
            for (int i = 0; i < size; i++) {
                if (listInvalidateGroupsWithKey.get(i).invalidateForResult(null) != InvalidationResult.IGNORED) {
                }
            }
            return;
        }
        if (this.composer.forceRecomposeScopes$runtime()) {
            this.parent.invalidate$runtime(this);
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet != null) {
            if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set<? extends Object>) andSet, true);
                return;
            }
            if (andSet instanceof Object[]) {
                for (Set<? extends Object> set : (Set[]) andSet) {
                    addPendingInvalidationsLocked(set, true);
                }
                return;
            }
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet(null);
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        if (andSet != null) {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
        if (this.pendingPausedComposition == null) {
            ComposerKt.composeImmediateRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
        }
    }

    private final void drainPendingModificationsOutOfBandLocked() {
        Object andSet = this.pendingModifications.getAndSet(SetsKt.emptySet());
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> content) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                MutableScatterMap<Object, Object> mutableScatterMapM6394takeInvalidationsafanTW4 = m6394takeInvalidationsafanTW4();
                try {
                    this.composer.mo6399composeContentZbOJvo$runtime(mutableScatterMapM6394takeInvalidationsafanTW4, content, this.shouldPause);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th) {
                    this.invalidations = mutableScatterMapM6394takeInvalidationsafanTW4;
                    throw th;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        } catch (Throwable th2) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                    } finally {
                        rememberEventDispatcher.clear();
                    }
                }
                throw th2;
            } catch (Throwable th3) {
                abandonChanges();
                throw th3;
            }
        }
    }

    public final void updateMovingInvalidations$runtime() {
        synchronized (this.lock) {
            drainPendingModificationsOutOfBandLocked();
            MutableScatterMap<Object, Object> mutableScatterMapM6394takeInvalidationsafanTW4 = m6394takeInvalidationsafanTW4();
            try {
                this.composer.mo6401updateComposerInvalidationsRY85e9Y$runtime(mutableScatterMapM6394takeInvalidationsafanTW4);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                this.invalidations = mutableScatterMapM6394takeInvalidationsafanTW4;
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            if (this.composer.getIsComposing()) {
                PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
            }
            if (this.state != 3) {
                this.state = 3;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$1918065384$runtime();
                Changes deferredChanges$runtime = this.composer.getDeferredChanges();
                if (deferredChanges$runtime != null) {
                    applyChangesInLocked(deferredChanges$runtime);
                }
                boolean zIsEmpty = this.slotStorage.isEmpty();
                if (!zIsEmpty || !this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        if (!zIsEmpty) {
                            this.applier.onBeginChanges();
                            this.slotStorage.clear(this.rememberManager);
                            this.applier.clear();
                            this.applier.onEndChanges();
                            rememberEventDispatcher.dispatchRememberObservers();
                        }
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } catch (Throwable th) {
                        rememberEventDispatcher.clear();
                        throw th;
                    }
                }
                this.composer.dispose$runtime();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = ScopeMap.m6486getSizeimpl(this.invalidations) > 0;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        Object objPlus;
        do {
            obj = this.pendingModifications.get();
            if (obj == null || Intrinsics.areEqual(obj, CompositionKt.PendingApplyNoModifications)) {
                objPlus = values;
            } else if (obj instanceof Set) {
                objPlus = new Set[]{obj, values};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                objPlus = ArraysKt.plus((Set<? extends Object>[]) obj, values);
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingModifications, obj, objPlus));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> block) {
        this.composer.prepareCompose$runtime(block);
    }

    public final List<Pair<RecomposeScopeImpl, Object>> extractInvalidationsOf$runtime(Anchor anchor) {
        long[] jArr;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        int i2;
        boolean zIsEmpty;
        int i3;
        int i4;
        long j3;
        if (ScopeMap.m6486getSizeimpl(this.invalidations) > 0) {
            ArrayList arrayList = new ArrayList();
            SlotStorage slotStorage = this.slotStorage;
            MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j4 = jArr3[i5];
                    char c2 = 7;
                    long j5 = -9187201950435737472L;
                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8;
                        int i7 = 8 - ((~(i5 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j4 & 255) < 128) {
                                int i9 = (i5 << 3) + i8;
                                c = c2;
                                Object obj = mutableScatterMap.keys[i9];
                                j2 = j5;
                                Object obj2 = mutableScatterMap.values[i9];
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                                if (obj2 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                    Object[] objArr = mutableScatterSet.elements;
                                    int i10 = i6;
                                    long[] jArr4 = mutableScatterSet.metadata;
                                    jArr2 = jArr3;
                                    int length2 = jArr4.length - 2;
                                    j = j4;
                                    if (length2 >= 0) {
                                        int i11 = i8;
                                        int i12 = 0;
                                        while (true) {
                                            long j6 = jArr4[i12];
                                            long[] jArr5 = jArr4;
                                            Object obj3 = obj;
                                            if ((((~j6) << c) & j6 & j2) != j2) {
                                                int i13 = 8 - ((~(i12 - length2)) >>> 31);
                                                int i14 = 0;
                                                while (i14 < i13) {
                                                    if ((j6 & 255) < 128) {
                                                        i3 = i11;
                                                        int i15 = (i12 << 3) + i14;
                                                        i4 = i14;
                                                        Object obj4 = objArr[i15];
                                                        j3 = j6;
                                                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj3;
                                                        Anchor anchor2 = recomposeScopeImpl.getAnchor();
                                                        if (anchor2 != null && slotStorage.inGroup(anchor, anchor2)) {
                                                            arrayList.add(TuplesKt.to(recomposeScopeImpl, obj4));
                                                            mutableScatterSet.removeElementAt(i15);
                                                        }
                                                    } else {
                                                        i3 = i11;
                                                        i4 = i14;
                                                        j3 = j6;
                                                    }
                                                    j6 = j3 >> i10;
                                                    i14 = i4 + 1;
                                                    i11 = i3;
                                                }
                                                i = i11;
                                                if (i13 != i10) {
                                                    break;
                                                }
                                            } else {
                                                i = i11;
                                            }
                                            if (i12 == length2) {
                                                break;
                                            }
                                            i12++;
                                            obj = obj3;
                                            jArr4 = jArr5;
                                            i11 = i;
                                            i10 = 8;
                                        }
                                    } else {
                                        i = i8;
                                    }
                                    zIsEmpty = mutableScatterSet.isEmpty();
                                } else {
                                    jArr2 = jArr3;
                                    j = j4;
                                    i = i8;
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                    RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
                                    Anchor anchor3 = recomposeScopeImpl2.getAnchor();
                                    if (anchor3 == null || !slotStorage.inGroup(anchor, anchor3)) {
                                        zIsEmpty = false;
                                    } else {
                                        arrayList.add(TuplesKt.to(recomposeScopeImpl2, obj2));
                                        zIsEmpty = true;
                                    }
                                }
                                if (zIsEmpty) {
                                    mutableScatterMap.removeValueAt(i9);
                                }
                                i2 = 8;
                            } else {
                                jArr2 = jArr3;
                                j = j4;
                                c = c2;
                                j2 = j5;
                                i = i8;
                                i2 = i6;
                            }
                            i8 = i + 1;
                            i6 = i2;
                            j4 = j >> i2;
                            c2 = c;
                            j5 = j2;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i7 != i6) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i5 == length) {
                        break;
                    }
                    i5++;
                    jArr3 = jArr;
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    public final List<Pair<RecomposeScopeImpl, Object>> extractInvalidationsOfGroup$runtime(Function1<? super Anchor, Boolean> inGroup) {
        long[] jArr;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        int i2;
        boolean zIsEmpty;
        Object obj;
        long j3;
        Object obj2;
        int i3;
        if (ScopeMap.m6486getSizeimpl(this.invalidations) > 0) {
            ArrayList arrayList = new ArrayList();
            MutableScatterMap mutableScatterMap = this.invalidations;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i4 = 0;
                while (true) {
                    long j4 = jArr3[i4];
                    char c2 = 7;
                    long j5 = -9187201950435737472L;
                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i5 = 8;
                        int i6 = 8 - ((~(i4 - length)) >>> 31);
                        int i7 = 0;
                        while (i7 < i6) {
                            if ((j4 & 255) < 128) {
                                int i8 = (i4 << 3) + i7;
                                c = c2;
                                Object obj3 = mutableScatterMap.keys[i8];
                                j2 = j5;
                                Object obj4 = mutableScatterMap.values[i8];
                                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                                if (obj4 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj4;
                                    Object[] objArr = mutableScatterSet.elements;
                                    long[] jArr4 = mutableScatterSet.metadata;
                                    int i9 = i5;
                                    int length2 = jArr4.length - 2;
                                    jArr2 = jArr3;
                                    j = j4;
                                    if (length2 >= 0) {
                                        int i10 = 0;
                                        while (true) {
                                            long j6 = jArr4[i10];
                                            Object[] objArr2 = objArr;
                                            i = i7;
                                            if ((((~j6) << c) & j6 & j2) != j2) {
                                                int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                                int i12 = 0;
                                                while (i12 < i11) {
                                                    if ((j6 & 255) < 128) {
                                                        j3 = j6;
                                                        int i13 = (i10 << 3) + i12;
                                                        Object obj5 = objArr2[i13];
                                                        obj2 = obj3;
                                                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
                                                        i3 = i12;
                                                        Anchor anchor = recomposeScopeImpl.getAnchor();
                                                        if (anchor != null && inGroup.invoke(anchor).booleanValue()) {
                                                            arrayList.add(TuplesKt.to(recomposeScopeImpl, obj5));
                                                            mutableScatterSet.removeElementAt(i13);
                                                        }
                                                    } else {
                                                        j3 = j6;
                                                        obj2 = obj3;
                                                        i3 = i12;
                                                    }
                                                    j6 = j3 >> i9;
                                                    i12 = i3 + 1;
                                                    obj3 = obj2;
                                                }
                                                obj = obj3;
                                                if (i11 != i9) {
                                                    break;
                                                }
                                            } else {
                                                obj = obj3;
                                            }
                                            if (i10 == length2) {
                                                break;
                                            }
                                            i10++;
                                            i7 = i;
                                            objArr = objArr2;
                                            obj3 = obj;
                                            i9 = 8;
                                        }
                                    } else {
                                        i = i7;
                                    }
                                    zIsEmpty = mutableScatterSet.isEmpty();
                                } else {
                                    jArr2 = jArr3;
                                    j = j4;
                                    i = i7;
                                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                    RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj3;
                                    Anchor anchor2 = recomposeScopeImpl2.getAnchor();
                                    if (anchor2 == null || !inGroup.invoke(anchor2).booleanValue()) {
                                        zIsEmpty = false;
                                    } else {
                                        arrayList.add(TuplesKt.to(recomposeScopeImpl2, obj4));
                                        zIsEmpty = true;
                                    }
                                }
                                if (zIsEmpty) {
                                    mutableScatterMap.removeValueAt(i8);
                                }
                                i2 = 8;
                            } else {
                                jArr2 = jArr3;
                                j = j4;
                                c = c2;
                                j2 = j5;
                                i = i7;
                                i2 = i5;
                            }
                            i7 = i + 1;
                            i5 = i2;
                            j4 = j >> i2;
                            c2 = c;
                            jArr3 = jArr2;
                            j5 = j2;
                        }
                        jArr = jArr3;
                        if (i6 != i5) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i4 == length) {
                        break;
                    }
                    i4++;
                    jArr3 = jArr;
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    private final void addPendingInvalidationsLocked(Object value, boolean forgetConditionalScopes) {
        Object obj = this.observations.get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (!ScopeMap.m6491removeimpl(this.observationsProcessed, value, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(value) != InvalidationResult.IGNORED) {
                                if (recomposeScopeImpl.isConditional() && !forgetConditionalScopes) {
                                    this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                                } else {
                                    this.invalidatedScopes.add(recomposeScopeImpl);
                                }
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (ScopeMap.m6491removeimpl(this.observationsProcessed, value, recomposeScopeImpl2) || recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IGNORED) {
                return;
            }
            if (recomposeScopeImpl2.isConditional() && !forgetConditionalScopes) {
                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
            } else {
                this.invalidatedScopes.add(recomposeScopeImpl2);
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        long j;
        char c;
        long j2;
        long j3;
        long[] jArr;
        long[] jArr2;
        int i;
        long j4;
        char c2;
        long j5;
        int i2;
        boolean zIsEmpty;
        long[] jArr3;
        int i3;
        int i4;
        MutableScatterMap<Object, Object> mutableScatterMap = this.derivedStates;
        long[] jArr4 = mutableScatterMap.metadata;
        int length = jArr4.length - 2;
        long j6 = 255;
        char c3 = 7;
        long j7 = -9187201950435737472L;
        int i5 = 8;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j8 = jArr4[i6];
                j3 = 128;
                if ((((~j8) << c3) & j8 & j7) != j7) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j8 & j6) < 128) {
                            j4 = j6;
                            int i9 = (i6 << 3) + i8;
                            Object obj = mutableScatterMap.keys[i9];
                            Object obj2 = mutableScatterMap.values[i9];
                            c2 = c3;
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.elements;
                                j5 = j7;
                                long[] jArr5 = mutableScatterSet.metadata;
                                int length2 = jArr5.length - 2;
                                if (length2 >= 0) {
                                    int i10 = i5;
                                    int i11 = 0;
                                    while (true) {
                                        long j9 = jArr5[i11];
                                        Object[] objArr2 = objArr;
                                        long[] jArr6 = jArr5;
                                        if ((((~j9) << c2) & j9 & j5) != j5) {
                                            int i12 = 8 - ((~(i11 - length2)) >>> 31);
                                            int i13 = 0;
                                            while (i13 < i12) {
                                                if ((j9 & j4) < 128) {
                                                    jArr3 = jArr4;
                                                    int i14 = (i11 << 3) + i13;
                                                    i3 = i8;
                                                    i4 = i13;
                                                    if (!ScopeMap.m6479containsimpl(this.observations, (DerivedState) objArr2[i14])) {
                                                        mutableScatterSet.removeElementAt(i14);
                                                    }
                                                } else {
                                                    jArr3 = jArr4;
                                                    i3 = i8;
                                                    i4 = i13;
                                                }
                                                j9 >>= i10;
                                                i13 = i4 + 1;
                                                jArr4 = jArr3;
                                                i8 = i3;
                                            }
                                            jArr2 = jArr4;
                                            i = i8;
                                            if (i12 != i10) {
                                                break;
                                            }
                                        } else {
                                            jArr2 = jArr4;
                                            i = i8;
                                        }
                                        int i15 = i11;
                                        if (i15 == length2) {
                                            break;
                                        }
                                        i11 = i15 + 1;
                                        objArr = objArr2;
                                        jArr5 = jArr6;
                                        jArr4 = jArr2;
                                        i8 = i;
                                        i10 = 8;
                                    }
                                } else {
                                    jArr2 = jArr4;
                                    i = i8;
                                }
                                zIsEmpty = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr4;
                                i = i8;
                                j5 = j7;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                zIsEmpty = !ScopeMap.m6479containsimpl(this.observations, (DerivedState) obj2);
                            }
                            if (zIsEmpty) {
                                mutableScatterMap.removeValueAt(i9);
                            }
                            i2 = 8;
                        } else {
                            jArr2 = jArr4;
                            i = i8;
                            j4 = j6;
                            c2 = c3;
                            j5 = j7;
                            i2 = i5;
                        }
                        j8 >>= i2;
                        i8 = i + 1;
                        i5 = i2;
                        c3 = c2;
                        j6 = j4;
                        j7 = j5;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    j = j6;
                    c = c3;
                    j2 = j7;
                    if (i7 != i5) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                    j = j6;
                    c = c3;
                    j2 = j7;
                }
                if (i6 == length) {
                    break;
                }
                i6++;
                c3 = c;
                j6 = j;
                j7 = j2;
                jArr4 = jArr;
                i5 = 8;
            }
        } else {
            j = 255;
            c = 7;
            j2 = -9187201950435737472L;
            j3 = 128;
        }
        if (!this.conditionallyInvalidatedScopes.isNotEmpty()) {
            return;
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        Object[] objArr3 = mutableScatterSet2.elements;
        long[] jArr7 = mutableScatterSet2.metadata;
        int length3 = jArr7.length - 2;
        if (length3 < 0) {
            return;
        }
        int i16 = 0;
        while (true) {
            long j10 = jArr7[i16];
            if ((((~j10) << c) & j10 & j2) != j2) {
                int i17 = 8 - ((~(i16 - length3)) >>> 31);
                for (int i18 = 0; i18 < i17; i18++) {
                    if ((j10 & j) < j3) {
                        int i19 = (i16 << 3) + i18;
                        if (!((RecomposeScopeImpl) objArr3[i19]).isConditional()) {
                            mutableScatterSet2.removeElementAt(i19);
                        }
                    }
                    j10 >>= 8;
                }
                if (i17 != 8) {
                    return;
                }
            }
            if (i16 == length3) {
                return;
            } else {
                i16++;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        int i;
        int i2;
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime = this.composer.getCurrentRecomposeScope$runtime()) == null) {
            return;
        }
        int i3 = 1;
        currentRecomposeScope$runtime.setUsed(true);
        boolean zRecordRead = currentRecomposeScope$runtime.recordRead(value);
        CompositionObserver compositionObserverObserver = observer();
        if (compositionObserverObserver != null) {
            compositionObserverObserver.onReadInScope(currentRecomposeScope$runtime, value);
        }
        if (zRecordRead) {
            return;
        }
        if (value instanceof StateObjectImpl) {
            ReaderKind.Companion companion = ReaderKind.INSTANCE;
            ((StateObjectImpl) value).m6729recordReadInh_f27i8$runtime(ReaderKind.m6717constructorimpl(1));
        }
        ScopeMap.m6471addimpl(this.observations, value, currentRecomposeScope$runtime);
        if (value instanceof DerivedState) {
            DerivedState<?> derivedState = (DerivedState) value;
            DerivedState.Record<?> currentRecord = derivedState.getCurrentRecord();
            ScopeMap.m6493removeScopeimpl(this.derivedStates, value);
            ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
            Object[] objArr = dependencies.keys;
            long[] jArr = dependencies.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i4 = 0;
                while (true) {
                    long j = jArr[i4];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i5 = 8;
                        int i6 = 8 - ((~(i4 - length)) >>> 31);
                        int i7 = 0;
                        while (i7 < i6) {
                            if ((j & 255) < 128) {
                                i2 = i3;
                                StateObject stateObject = (StateObject) objArr[(i4 << 3) + i7];
                                if (stateObject instanceof StateObjectImpl) {
                                    ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                                    ((StateObjectImpl) stateObject).m6729recordReadInh_f27i8$runtime(ReaderKind.m6717constructorimpl(i2));
                                }
                                ScopeMap.m6471addimpl(this.derivedStates, stateObject, value);
                            } else {
                                i2 = i3;
                                i5 = i5;
                            }
                            j >>= i5;
                            i7++;
                            i3 = i2;
                            i5 = i5;
                        }
                        i = i3;
                        if (i6 != i5) {
                            break;
                        }
                    } else {
                        i = i3;
                    }
                    if (i4 == length) {
                        break;
                    }
                    i4++;
                    i3 = i;
                }
            }
            currentRecomposeScope$runtime.recordDerivedStateValue(derivedState, currentRecord.getCurrentValue());
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        Object obj = this.observations.get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (recomposeScopeImpl.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                                ScopeMap.m6471addimpl(this.observationsProcessed, value, recomposeScopeImpl);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                ScopeMap.m6471addimpl(this.observationsProcessed, value, recomposeScopeImpl2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x0058 A[Catch: all -> 0x0064, LOOP:0: B:11:0x0021->B:21:0x0058, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0012, B:11:0x0021, B:13:0x0031, B:15:0x003d, B:17:0x0046, B:18:0x0050, B:21:0x0058, B:22:0x005b, B:23:0x0060), top: B:29:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0060 A[EDGE_INSN: B:32:0x0060->B:23:0x0060 BREAK  A[LOOP:0: B:11:0x0021->B:21:0x0058], SYNTHETIC] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(Object value) {
        synchronized (this.lock) {
            invalidateScopeOfLocked(value);
            Object obj = this.derivedStates.get(value);
            if (obj != null) {
                if (!(obj instanceof MutableScatterSet)) {
                    invalidateScopeOfLocked((DerivedState) obj);
                } else {
                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                    Object[] objArr = mutableScatterSet.elements;
                    long[] jArr = mutableScatterSet.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i = 0;
                        while (true) {
                            long j = jArr[i];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                if (i != length) {
                                    break;
                                    break;
                                }
                                i++;
                            } else {
                                int i2 = 8 - ((~(i - length)) >>> 31);
                                for (int i3 = 0; i3 < i2; i3++) {
                                    if ((255 & j) < 128) {
                                        invalidateScopeOfLocked((DerivedState) objArr[(i << 3) + i3]);
                                    }
                                    j >>= 8;
                                }
                                if (i2 != 8) {
                                    break;
                                } else if (i != length) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        synchronized (this.lock) {
            PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
            if (pausedCompositionImpl != null && !pausedCompositionImpl.isRecomposing$runtime()) {
                pausedCompositionImpl.markIncomplete$runtime();
                pausedCompositionImpl.getPausableApplier$runtime().markRecomposePending();
                return false;
            }
            drainPendingModificationsForCompositionLocked();
            try {
                MutableScatterMap<Object, Object> mutableScatterMapM6394takeInvalidationsafanTW4 = m6394takeInvalidationsafanTW4();
                try {
                    boolean zMo6400recomposeaFTiNEg$runtime = this.composer.mo6400recomposeaFTiNEg$runtime(mutableScatterMapM6394takeInvalidationsafanTW4, this.shouldPause);
                    if (!zMo6400recomposeaFTiNEg$runtime) {
                        drainPendingModificationsLocked();
                    }
                    return zMo6400recomposeaFTiNEg$runtime;
                } catch (Throwable th) {
                    this.invalidations = mutableScatterMapM6394takeInvalidationsafanTW4;
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                        } finally {
                            rememberEventDispatcher.clear();
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
        try {
            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
            state.getSlotStorage().disposeUnusedMovableContent(this.rememberManager, state);
            rememberEventDispatcher.dispatchRememberObservers();
        } finally {
            rememberEventDispatcher.clear();
        }
    }

    private final void applyChangesInLocked(Changes changes) {
        String str;
        RememberEventDispatcher rememberManager$runtime;
        long[] jArr;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        boolean zIsEmpty;
        long[] jArr3;
        RecordingApplier<Object> pausableApplier$runtime;
        this.rememberManager.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
        try {
            if (!changes.isEmpty()) {
                PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
                RecordingApplier<Object> recordingApplier = (pausedCompositionImpl == null || (pausableApplier$runtime = pausedCompositionImpl.getPausableApplier$runtime()) == null) ? this.applier : pausableApplier$runtime;
                PausedCompositionImpl pausedCompositionImpl2 = this.pendingPausedComposition;
                if (Intrinsics.areEqual(recordingApplier, pausedCompositionImpl2 != null ? pausedCompositionImpl2.getPausableApplier$runtime() : null)) {
                    str = "Compose:recordChanges";
                } else {
                    str = "Compose:applyChanges";
                }
                Object objBeginSection = Trace.INSTANCE.beginSection(str);
                try {
                    PausedCompositionImpl pausedCompositionImpl3 = this.pendingPausedComposition;
                    if (pausedCompositionImpl3 == null || (rememberManager$runtime = pausedCompositionImpl3.getRememberManager()) == null) {
                        rememberManager$runtime = this.rememberManager;
                    }
                    recordingApplier.onBeginChanges();
                    changes.execute(this.slotStorage, recordingApplier, rememberManager$runtime, this.composer.getErrorContext$runtime());
                    recordingApplier.onEndChanges();
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(objBeginSection);
                    this.rememberManager.dispatchRememberObservers();
                    this.rememberManager.dispatchSideEffects();
                    if (this.pendingInvalidScopes) {
                        Object objBeginSection2 = Trace.INSTANCE.beginSection("Compose:unobserve");
                        int i2 = 0;
                        try {
                            this.pendingInvalidScopes = false;
                            MutableScatterMap<Object, Object> mutableScatterMap = this.observations;
                            long[] jArr4 = mutableScatterMap.metadata;
                            int length = jArr4.length - 2;
                            if (length >= 0) {
                                int i3 = 0;
                                while (true) {
                                    long j3 = jArr4[i3];
                                    char c2 = 7;
                                    long j4 = -9187201950435737472L;
                                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i4 = 8;
                                        int i5 = 8 - ((~(i3 - length)) >>> 31);
                                        int i6 = i2;
                                        while (i6 < i5) {
                                            if ((j3 & 255) < 128) {
                                                int i7 = (i3 << 3) + i6;
                                                c = c2;
                                                Object obj = mutableScatterMap.keys[i7];
                                                Object obj2 = mutableScatterMap.values[i7];
                                                j2 = j4;
                                                if (obj2 instanceof MutableScatterSet) {
                                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                                    Object[] objArr = mutableScatterSet.elements;
                                                    long[] jArr5 = mutableScatterSet.metadata;
                                                    int length2 = jArr5.length - 2;
                                                    if (length2 >= 0) {
                                                        j = j3;
                                                        int i8 = i4;
                                                        int i9 = 0;
                                                        while (true) {
                                                            long j5 = jArr5[i9];
                                                            Object[] objArr2 = objArr;
                                                            long[] jArr6 = jArr5;
                                                            if ((((~j5) << c) & j5 & j2) != j2) {
                                                                int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                                                int i11 = 0;
                                                                while (i11 < i10) {
                                                                    if ((j5 & 255) < 128) {
                                                                        jArr3 = jArr4;
                                                                        int i12 = (i9 << 3) + i11;
                                                                        if (!((RecomposeScopeImpl) objArr2[i12]).getValid()) {
                                                                            mutableScatterSet.removeElementAt(i12);
                                                                        }
                                                                    } else {
                                                                        jArr3 = jArr4;
                                                                    }
                                                                    j5 >>= i8;
                                                                    i11++;
                                                                    jArr4 = jArr3;
                                                                }
                                                                jArr2 = jArr4;
                                                                if (i10 != i8) {
                                                                    break;
                                                                }
                                                            } else {
                                                                jArr2 = jArr4;
                                                            }
                                                            if (i9 == length2) {
                                                                break;
                                                            }
                                                            i9++;
                                                            objArr = objArr2;
                                                            jArr5 = jArr6;
                                                            jArr4 = jArr2;
                                                            i8 = 8;
                                                        }
                                                    } else {
                                                        jArr2 = jArr4;
                                                        j = j3;
                                                    }
                                                    zIsEmpty = mutableScatterSet.isEmpty();
                                                } else {
                                                    jArr2 = jArr4;
                                                    j = j3;
                                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                                    zIsEmpty = !((RecomposeScopeImpl) obj2).getValid();
                                                }
                                                if (zIsEmpty) {
                                                    mutableScatterMap.removeValueAt(i7);
                                                }
                                                i = 8;
                                            } else {
                                                jArr2 = jArr4;
                                                j = j3;
                                                c = c2;
                                                j2 = j4;
                                                i = i4;
                                            }
                                            j3 = j >> i;
                                            i6++;
                                            i4 = i;
                                            c2 = c;
                                            j4 = j2;
                                            jArr4 = jArr2;
                                        }
                                        jArr = jArr4;
                                        if (i5 != i4) {
                                            break;
                                        }
                                    } else {
                                        jArr = jArr4;
                                    }
                                    if (i3 == length) {
                                        break;
                                    }
                                    i3++;
                                    jArr4 = jArr;
                                    i2 = 0;
                                }
                            }
                            cleanUpDerivedStateObservations();
                            Unit unit2 = Unit.INSTANCE;
                            Trace.INSTANCE.endSection(objBeginSection2);
                        } catch (Throwable th) {
                            Trace.INSTANCE.endSection(objBeginSection2);
                            throw th;
                        }
                    }
                    try {
                        if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                            this.rememberManager.dispatchAbandons();
                        }
                    } finally {
                        this.rememberManager.clear();
                    }
                } catch (Throwable th2) {
                    Trace.INSTANCE.endSection(objBeginSection);
                    throw th2;
                }
            } else {
                try {
                    if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                        this.rememberManager.dispatchAbandons();
                    }
                } finally {
                    this.rememberManager.clear();
                }
            }
        } catch (Throwable th3) {
            try {
                if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                    this.rememberManager.dispatchAbandons();
                }
                throw th3;
            } finally {
                this.rememberManager.clear();
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                        } finally {
                            rememberEventDispatcher.clear();
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    abandonChanges();
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                        } finally {
                            rememberEventDispatcher.clear();
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    abandonChanges();
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime();
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } catch (Throwable th) {
                        rememberEventDispatcher.clear();
                        throw th;
                    }
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th2) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher2 = this.rememberManager;
                        try {
                            rememberEventDispatcher2.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher2.dispatchAbandons();
                        } finally {
                            rememberEventDispatcher2.clear();
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super ScopeMap<RecomposeScopeImpl, Object>, ? extends T> block) {
        MutableScatterMap<Object, Object> mutableScatterMapM6394takeInvalidationsafanTW4 = m6394takeInvalidationsafanTW4();
        try {
            return block.invoke(ScopeMap.m6475boximpl(mutableScatterMapM6394takeInvalidationsafanTW4));
        } catch (Throwable th) {
            this.invalidations = mutableScatterMapM6394takeInvalidationsafanTW4;
            throw th;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        if (this.abandonSet.isEmpty()) {
            return;
        }
        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
        try {
            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
            rememberEventDispatcher.dispatchAbandons();
        } finally {
            rememberEventDispatcher.clear();
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        this.slotStorage.invalidateAll();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime();
                this.slotStorage.verifyWellFormed();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition to, int groupIndex, Function0<? extends R> block) {
        if (to != null && !Intrinsics.areEqual(to, this) && groupIndex >= 0) {
            this.invalidationDelegate = (CompositionImpl) to;
            this.invalidationDelegateGroup = groupIndex;
            try {
                return block.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return block.invoke();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public ShouldPauseCallback getAndSetShouldPauseCallback(ShouldPauseCallback shouldPause) {
        ShouldPauseCallback shouldPauseCallback = this.shouldPause;
        this.shouldPause = shouldPause;
        return shouldPauseCallback;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        CompositionObserver compositionObserverObserver;
        CompositionImpl compositionImpl;
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (this.slotStorage.ownsRecomposeScope(scope)) {
            if (!scope.getCanRecompose()) {
                return InvalidationResult.IGNORED;
            }
            InvalidationResult invalidationResultInvalidateChecked = invalidateChecked(scope, anchor, instance);
            if (invalidationResultInvalidateChecked != InvalidationResult.IGNORED && (compositionObserverObserver = observer()) != null) {
                compositionObserverObserver.onScopeInvalidated(scope, instance);
            }
            return invalidationResultInvalidateChecked;
        }
        synchronized (this.lock) {
            compositionImpl = this.invalidationDelegate;
        }
        if (compositionImpl != null && compositionImpl.tryImminentInvalidation(scope, instance)) {
            return InvalidationResult.IMMINENT;
        }
        return InvalidationResult.IGNORED;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        this.pendingInvalidScopes = true;
        CompositionObserver compositionObserverObserver = observer();
        if (compositionObserverObserver != null) {
            compositionObserverObserver.onScopeDisposed(scope);
        }
    }

    @Override // androidx.compose.runtime.CompositionServices
    public <T> T getCompositionService(CompositionServiceKey<T> key) {
        if (Intrinsics.areEqual(key, CompositionKt.getObservableCompositionServiceKey())) {
            return (T) this;
        }
        return null;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl scope, Object instance) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime(scope, instance);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x009a A[Catch: all -> 0x00c3, LOOP:0: B:30:0x0059->B:44:0x009a, LOOP_END, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x0010, B:12:0x001f, B:14:0x0025, B:18:0x002b, B:19:0x0034, B:22:0x003a, B:23:0x0041, B:25:0x0047, B:27:0x004b, B:30:0x0059, B:32:0x0069, B:34:0x0075, B:36:0x007f, B:40:0x008e, B:44:0x009a, B:45:0x009d, B:48:0x00a2), top: B:62:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a2 A[Catch: all -> 0x00c3, EDGE_INSN: B:48:0x00a2->B:49:0x00a7 BREAK  A[LOOP:0: B:30:0x0059->B:44:0x009a], TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x0010, B:12:0x001f, B:14:0x0025, B:18:0x002b, B:19:0x0034, B:22:0x003a, B:23:0x0041, B:25:0x0047, B:27:0x004b, B:30:0x0059, B:32:0x0069, B:34:0x0075, B:36:0x007f, B:40:0x008e, B:44:0x009a, B:45:0x009d, B:48:0x00a2), top: B:62:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00a2 A[SYNTHETIC] */
    private final InvalidationResult invalidateChecked(RecomposeScopeImpl scope, Anchor anchor, Object instance) {
        synchronized (this.lock) {
            CompositionImpl compositionImpl = this.invalidationDelegate;
            CompositionImpl compositionImpl2 = null;
            if (compositionImpl != null) {
                if (!this.slotStorage.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                    compositionImpl = null;
                }
                compositionImpl2 = compositionImpl;
            }
            if (compositionImpl2 == null) {
                if (!tryImminentInvalidation(scope, instance)) {
                    if (instance != null) {
                        boolean z = instance instanceof DerivedState;
                        MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
                        if (z) {
                            Object obj = mutableScatterMap.get(scope);
                            if (obj != null) {
                                if (!(obj instanceof MutableScatterSet)) {
                                    if (obj != ScopeInvalidated.INSTANCE) {
                                        ScopeMap.m6471addimpl(this.invalidations, scope, instance);
                                        break;
                                    }
                                } else {
                                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                                    Object[] objArr = mutableScatterSet.elements;
                                    long[] jArr = mutableScatterSet.metadata;
                                    int length = jArr.length - 2;
                                    if (length < 0) {
                                        ScopeMap.m6471addimpl(this.invalidations, scope, instance);
                                        break;
                                    }
                                    int i = 0;
                                    loop0: while (true) {
                                        long j = jArr[i];
                                        if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                            if (i == length) {
                                                ScopeMap.m6471addimpl(this.invalidations, scope, instance);
                                                break;
                                            }
                                            i++;
                                        } else {
                                            int i2 = 8;
                                            int i3 = 8 - ((~(i - length)) >>> 31);
                                            int i4 = 0;
                                            while (i4 < i3) {
                                                if ((j & 255) < 128 && objArr[(i << 3) + i4] == ScopeInvalidated.INSTANCE) {
                                                    break loop0;
                                                }
                                                j >>= i2;
                                                i4++;
                                                i2 = i2;
                                            }
                                            if (i3 == i2) {
                                                if (i == length) {
                                                    i++;
                                                }
                                            }
                                            ScopeMap.m6471addimpl(this.invalidations, scope, instance);
                                            break;
                                        }
                                    }
                                }
                            } else {
                                ScopeMap.m6471addimpl(this.invalidations, scope, instance);
                                break;
                            }
                        } else {
                            ScopeMap.m6495setimpl(mutableScatterMap, scope, ScopeInvalidated.INSTANCE);
                        }
                    } else {
                        ScopeMap.m6495setimpl(this.invalidations, scope, ScopeInvalidated.INSTANCE);
                    }
                } else {
                    return InvalidationResult.IMMINENT;
                }
            }
            if (compositionImpl2 != null) {
                return compositionImpl2.invalidateChecked(scope, anchor, instance);
            }
            this.parent.invalidate$runtime(this);
            return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
        }
    }

    public final void removeObservation$runtime(Object instance, RecomposeScopeImpl scope) {
        ScopeMap.m6491removeimpl(this.observations, instance, scope);
    }

    public final void removeDerivedStateObservation$runtime(DerivedState<?> state) {
        if (ScopeMap.m6479containsimpl(this.observations, state)) {
            return;
        }
        ScopeMap.m6493removeScopeimpl(this.derivedStates, state);
    }

    /* JADX INFO: renamed from: takeInvalidations-afanTW4, reason: not valid java name */
    private final MutableScatterMap<Object, Object> m6394takeInvalidationsafanTW4() {
        MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
        this.invalidations = ScopeMap.m6478constructorimpl$default(null, 1, null);
        return mutableScatterMap;
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> block) {
        try {
            return block.invoke();
        } catch (Throwable th) {
            if (!this.abandonSet.isEmpty()) {
                RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                try {
                    rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                    rememberEventDispatcher.dispatchAbandons();
                } finally {
                    rememberEventDispatcher.clear();
                }
            }
            throw th;
        }
    }

    private final CompositionObserver observer() {
        return this.observerHolder.current();
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void deactivate() {
        synchronized (this.lock) {
            if (!(this.pendingPausedComposition == null)) {
                PreconditionsKt.throwIllegalStateException("Deactivate is not supported while pausable composition is in progress");
            }
            boolean zIsEmpty = this.slotStorage.isEmpty();
            if (!zIsEmpty || !this.abandonSet.isEmpty()) {
                Object objBeginSection = Trace.INSTANCE.beginSection("Compose:deactivate");
                try {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        if (!zIsEmpty) {
                            this.applier.onBeginChanges();
                            this.slotStorage.deactivateAll(this.rememberManager);
                            this.applier.onEndChanges();
                            rememberEventDispatcher.dispatchRememberObservers();
                        }
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                        Unit unit = Unit.INSTANCE;
                        Trace.INSTANCE.endSection(objBeginSection);
                    } catch (Throwable th) {
                        rememberEventDispatcher.clear();
                        throw th;
                    }
                } catch (Throwable th2) {
                    Trace.INSTANCE.endSection(objBeginSection);
                    throw th2;
                }
            }
            ScopeMap.m6476clearimpl(this.observations);
            ScopeMap.m6476clearimpl(this.derivedStates);
            ScopeMap.m6476clearimpl(this.invalidations);
            this.changes.clear();
            this.lateChanges.clear();
            this.composer.deactivate$runtime();
            this.state = 1;
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final int composerStacksSizes$runtime() {
        return this.composer.stacksSize$runtime();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x0059 A[LOOP:0: B:7:0x0016->B:21:0x0059, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x007d A[SYNTHETIC] */
    @Override // androidx.compose.runtime.ControlledComposition
    public boolean observesAnyOf(Set<? extends Object> values) {
        if (values instanceof ScatterSetWrapper) {
            ScatterSet set$runtime = ((ScatterSetWrapper) values).getSet$runtime();
            Object[] objArr = set$runtime.elements;
            long[] jArr = set$runtime.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                loop0: while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                Object obj = objArr[(i << 3) + i3];
                                if (ScopeMap.m6479containsimpl(this.observations, obj) || ScopeMap.m6479containsimpl(this.derivedStates, obj)) {
                                    break loop0;
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 == 8) {
                            if (i != length) {
                                i++;
                            }
                        }
                    } else if (i != length) {
                        i++;
                    }
                }
                return true;
            }
        } else {
            for (Object obj2 : values) {
                if (ScopeMap.m6479containsimpl(this.observations, obj2) || ScopeMap.m6479containsimpl(this.derivedStates, obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0243 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x0245 A[LOOP:6: B:93:0x01f2->B:109:0x0245, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:185:0x00ca A[EDGE_INSN: B:185:0x00ca->B:37:0x00ca BREAK  A[LOOP:2: B:23:0x0079->B:34:0x00b5], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x0252 A[EDGE_INSN: B:196:0x0252->B:111:0x0252 BREAK  A[LOOP:6: B:93:0x01f2->B:109:0x0245], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:0x018b A[EDGE_INSN: B:220:0x018b->B:74:0x018b BREAK  A[LOOP:13: B:61:0x014f->B:72:0x0183], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00b5 A[LOOP:2: B:23:0x0079->B:34:0x00b5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:36:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:71:0x0181 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0183 A[LOOP:13: B:61:0x014f->B:72:0x0183, LOOP_END] */
    private final void addPendingInvalidationsLocked(Set<? extends Object> values, boolean forgetConditionalScopes) {
        char c;
        long j;
        long j2;
        long j3;
        long[] jArr;
        String str;
        String str2;
        int i;
        long j4;
        boolean zContains;
        String str3;
        int i2;
        long[] jArr2;
        int i3;
        long[] jArr3;
        int i4;
        int i5;
        long j5;
        boolean zIsEmpty;
        int i6;
        long j6;
        long j7;
        char c2;
        long j8;
        int i7;
        int i8;
        Object obj = null;
        char c3 = 7;
        long j9 = -9187201950435737472L;
        int i9 = 8;
        if (values instanceof ScatterSetWrapper) {
            ScatterSet set$runtime = ((ScatterSetWrapper) values).getSet$runtime();
            Object[] objArr = set$runtime.elements;
            long[] jArr4 = set$runtime.metadata;
            int length = jArr4.length - 2;
            if (length >= 0) {
                int i10 = 0;
                j2 = 128;
                while (true) {
                    long j10 = jArr4[i10];
                    j3 = 255;
                    if ((((~j10) << c3) & j10 & j9) != j9) {
                        int i11 = 8 - ((~(i10 - length)) >>> 31);
                        int i12 = 0;
                        while (i12 < i11) {
                            if ((j10 & 255) < 128) {
                                c2 = c3;
                                Object obj2 = objArr[(i10 << 3) + i12];
                                j8 = j9;
                                if (obj2 instanceof RecomposeScopeImpl) {
                                    ((RecomposeScopeImpl) obj2).invalidateForResult(obj);
                                    j7 = j10;
                                    i7 = length;
                                } else {
                                    addPendingInvalidationsLocked(obj2, forgetConditionalScopes);
                                    Object obj3 = this.derivedStates.get(obj2);
                                    if (obj3 == null) {
                                        j7 = j10;
                                        i7 = length;
                                    } else if (obj3 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj3;
                                        Object[] objArr2 = mutableScatterSet.elements;
                                        long[] jArr5 = mutableScatterSet.metadata;
                                        int length2 = jArr5.length - 2;
                                        if (length2 >= 0) {
                                            j7 = j10;
                                            int i13 = 0;
                                            while (true) {
                                                long j11 = jArr5[i13];
                                                int i14 = i9;
                                                i7 = length;
                                                if ((((~j11) << c2) & j11 & j8) != j8) {
                                                    int i15 = 8 - ((~(i13 - length2)) >>> 31);
                                                    int i16 = 0;
                                                    while (i16 < i15) {
                                                        if ((j11 & 255) < 128) {
                                                            addPendingInvalidationsLocked((DerivedState) objArr2[(i13 << 3) + i16], forgetConditionalScopes);
                                                        }
                                                        j11 >>= i14;
                                                        i16++;
                                                        i14 = i14;
                                                    }
                                                    if (i15 != i14) {
                                                        break;
                                                    }
                                                    if (i13 != length2) {
                                                        break;
                                                    }
                                                    i13++;
                                                    length = i7;
                                                    i9 = 8;
                                                } else if (i13 != length2) {
                                                    break;
                                                    break;
                                                } else {
                                                    i13++;
                                                    length = i7;
                                                    i9 = 8;
                                                }
                                            }
                                        } else {
                                            j7 = j10;
                                            i7 = length;
                                        }
                                    } else {
                                        j7 = j10;
                                        i7 = length;
                                        addPendingInvalidationsLocked((DerivedState) obj3, forgetConditionalScopes);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                }
                                i8 = 8;
                            } else {
                                j7 = j10;
                                c2 = c3;
                                j8 = j9;
                                i7 = length;
                                i8 = i9;
                            }
                            i12++;
                            length = i7;
                            i9 = i8;
                            c3 = c2;
                            j9 = j8;
                            j10 = j7 >> i8;
                            obj = null;
                        }
                        c = c3;
                        j = j9;
                        int i17 = length;
                        if (i11 != i9) {
                            break;
                        } else {
                            length = i17;
                        }
                    } else {
                        c = c3;
                        j = j9;
                    }
                    if (i10 == length) {
                        break;
                    }
                    i10++;
                    c3 = c;
                    j9 = j;
                    obj = null;
                    i9 = 8;
                }
            } else {
                c = 7;
                j = -9187201950435737472L;
                j2 = 128;
                j3 = 255;
            }
        } else {
            c = 7;
            j = -9187201950435737472L;
            j2 = 128;
            j3 = 255;
            for (Object obj4 : values) {
                if (obj4 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj4).invalidateForResult(null);
                } else {
                    addPendingInvalidationsLocked(obj4, forgetConditionalScopes);
                    Object obj5 = this.derivedStates.get(obj4);
                    if (obj5 != null) {
                        if (obj5 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj5;
                            Object[] objArr3 = mutableScatterSet2.elements;
                            long[] jArr6 = mutableScatterSet2.metadata;
                            int length3 = jArr6.length - 2;
                            if (length3 >= 0) {
                                int i18 = 0;
                                while (true) {
                                    long j12 = jArr6[i18];
                                    if ((((~j12) << 7) & j12 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i18 != length3) {
                                            break;
                                            break;
                                        }
                                        i18++;
                                    } else {
                                        int i19 = 8 - ((~(i18 - length3)) >>> 31);
                                        for (int i20 = 0; i20 < i19; i20++) {
                                            if ((j12 & 255) < 128) {
                                                addPendingInvalidationsLocked((DerivedState) objArr3[(i18 << 3) + i20], forgetConditionalScopes);
                                            }
                                            j12 >>= 8;
                                        }
                                        if (i19 != 8) {
                                            break;
                                        } else if (i18 != length3) {
                                            break;
                                        } else {
                                            i18++;
                                        }
                                    }
                                }
                            }
                        } else {
                            addPendingInvalidationsLocked((DerivedState) obj5, forgetConditionalScopes);
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet3 = this.conditionallyInvalidatedScopes;
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet4 = this.invalidatedScopes;
        String str4 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>";
        if (!forgetConditionalScopes || !mutableScatterSet3.isNotEmpty()) {
            if (mutableScatterSet4.isNotEmpty()) {
                MutableScatterMap<Object, Object> mutableScatterMap = this.observations;
                long[] jArr7 = mutableScatterMap.metadata;
                int length4 = jArr7.length - 2;
                if (length4 >= 0) {
                    int i21 = 0;
                    while (true) {
                        long j13 = jArr7[i21];
                        if ((((~j13) << c) & j13 & j) != j) {
                            int i22 = 8 - ((~(i21 - length4)) >>> 31);
                            int i23 = 0;
                            while (i23 < i22) {
                                if ((j13 & j3) < j2) {
                                    int i24 = (i21 << 3) + i23;
                                    Object obj6 = mutableScatterMap.keys[i24];
                                    Object obj7 = mutableScatterMap.values[i24];
                                    if (obj7 instanceof MutableScatterSet) {
                                        Intrinsics.checkNotNull(obj7, str4);
                                        MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj7;
                                        Object[] objArr4 = mutableScatterSet5.elements;
                                        long[] jArr8 = mutableScatterSet5.metadata;
                                        int length5 = jArr8.length - 2;
                                        if (length5 >= 0) {
                                            j4 = j13;
                                            int i25 = 0;
                                            while (true) {
                                                long j14 = jArr8[i25];
                                                long[] jArr9 = jArr8;
                                                i = length4;
                                                if ((((~j14) << c) & j14 & j) != j) {
                                                    int i26 = 8 - ((~(i25 - length5)) >>> 31);
                                                    int i27 = 0;
                                                    while (i27 < i26) {
                                                        if ((j14 & j3) < j2) {
                                                            str3 = str4;
                                                            int i28 = (i25 << 3) + i27;
                                                            i2 = i27;
                                                            if (mutableScatterSet4.contains((RecomposeScopeImpl) objArr4[i28])) {
                                                                mutableScatterSet5.removeElementAt(i28);
                                                            }
                                                        } else {
                                                            str3 = str4;
                                                            i2 = i27;
                                                        }
                                                        j14 >>= 8;
                                                        i27 = i2 + 1;
                                                        str4 = str3;
                                                    }
                                                    str2 = str4;
                                                    if (i26 != 8) {
                                                        break;
                                                    }
                                                } else {
                                                    str2 = str4;
                                                }
                                                if (i25 == length5) {
                                                    break;
                                                }
                                                i25++;
                                                length4 = i;
                                                jArr8 = jArr9;
                                                str4 = str2;
                                            }
                                        } else {
                                            str2 = str4;
                                            i = length4;
                                            j4 = j13;
                                        }
                                        zContains = mutableScatterSet5.isEmpty();
                                    } else {
                                        str2 = str4;
                                        i = length4;
                                        j4 = j13;
                                        Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                        zContains = mutableScatterSet4.contains((RecomposeScopeImpl) obj7);
                                    }
                                    if (zContains) {
                                        mutableScatterMap.removeValueAt(i24);
                                    }
                                } else {
                                    jArr7 = jArr7;
                                    str2 = str4;
                                    i = length4;
                                    j4 = j13;
                                }
                                j13 = j4 >> 8;
                                i23++;
                                jArr7 = jArr7;
                                length4 = i;
                                str4 = str2;
                            }
                            jArr = jArr7;
                            str = str4;
                            int i29 = length4;
                            if (i22 != 8) {
                                break;
                            } else {
                                length4 = i29;
                            }
                        } else {
                            jArr = jArr7;
                            str = str4;
                        }
                        if (i21 == length4) {
                            break;
                        }
                        i21++;
                        jArr7 = jArr;
                        str4 = str;
                    }
                }
                cleanUpDerivedStateObservations();
                mutableScatterSet4.clear();
                return;
            }
            return;
        }
        MutableScatterMap<Object, Object> mutableScatterMap2 = this.observations;
        long[] jArr10 = mutableScatterMap2.metadata;
        int length6 = jArr10.length - 2;
        if (length6 >= 0) {
            int i30 = 0;
            while (true) {
                long j15 = jArr10[i30];
                if ((((~j15) << c) & j15 & j) != j) {
                    int i31 = 8 - ((~(i30 - length6)) >>> 31);
                    int i32 = 0;
                    while (i32 < i31) {
                        if ((j15 & j3) < j2) {
                            int i33 = (i30 << 3) + i32;
                            Object obj8 = mutableScatterMap2.keys[i33];
                            Object obj9 = mutableScatterMap2.values[i33];
                            if (obj9 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj9;
                                Object[] objArr5 = mutableScatterSet6.elements;
                                long[] jArr11 = mutableScatterSet6.metadata;
                                jArr3 = jArr10;
                                int length7 = jArr11.length - 2;
                                if (length7 >= 0) {
                                    j5 = j15;
                                    int i34 = 0;
                                    while (true) {
                                        long j16 = jArr11[i34];
                                        i4 = length6;
                                        i5 = i30;
                                        if ((((~j16) << c) & j16 & j) != j) {
                                            int i35 = 8 - ((~(i34 - length7)) >>> 31);
                                            int i36 = 0;
                                            while (i36 < i35) {
                                                if ((j16 & j3) < j2) {
                                                    i6 = i36;
                                                    int i37 = (i34 << 3) + i6;
                                                    j6 = j16;
                                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr5[i37];
                                                    if (mutableScatterSet3.contains(recomposeScopeImpl) || mutableScatterSet4.contains(recomposeScopeImpl)) {
                                                        mutableScatterSet6.removeElementAt(i37);
                                                    }
                                                } else {
                                                    i6 = i36;
                                                    j6 = j16;
                                                }
                                                j16 = j6 >> 8;
                                                i36 = i6 + 1;
                                            }
                                            if (i35 != 8) {
                                                break;
                                            }
                                            if (i34 != length7) {
                                                break;
                                            }
                                            i34++;
                                            length6 = i4;
                                            i30 = i5;
                                        } else if (i34 != length7) {
                                            break;
                                            break;
                                        } else {
                                            i34++;
                                            length6 = i4;
                                            i30 = i5;
                                        }
                                    }
                                } else {
                                    i4 = length6;
                                    i5 = i30;
                                    j5 = j15;
                                }
                                zIsEmpty = mutableScatterSet6.isEmpty();
                            } else {
                                jArr3 = jArr10;
                                i4 = length6;
                                i5 = i30;
                                j5 = j15;
                                Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj9;
                                zIsEmpty = mutableScatterSet3.contains(recomposeScopeImpl2) || mutableScatterSet4.contains(recomposeScopeImpl2);
                            }
                            if (zIsEmpty) {
                                mutableScatterMap2.removeValueAt(i33);
                            }
                        } else {
                            jArr3 = jArr10;
                            i4 = length6;
                            i5 = i30;
                            j5 = j15;
                        }
                        j15 = j5 >> 8;
                        i32++;
                        jArr10 = jArr3;
                        length6 = i4;
                        i30 = i5;
                    }
                    jArr2 = jArr10;
                    int i38 = length6;
                    int i39 = i30;
                    if (i31 != 8) {
                        break;
                    }
                    length6 = i38;
                    i3 = i39;
                } else {
                    jArr2 = jArr10;
                    i3 = i30;
                }
                if (i3 == length6) {
                    break;
                }
                i30 = i3 + 1;
                jArr10 = jArr2;
            }
        }
        mutableScatterSet3.clear();
        cleanUpDerivedStateObservations();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        int size = references.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual(references.get(i).getFirst().getComposition(), this)) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                    } finally {
                        rememberEventDispatcher.clear();
                    }
                }
                throw th;
            } catch (Throwable th2) {
                abandonChanges();
                throw th2;
            }
        }
    }

    private final <T> T guardChanges(Function0<? extends T> block) {
        try {
            return block.invoke();
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                    } finally {
                        rememberEventDispatcher.clear();
                    }
                }
                throw th;
            } catch (Throwable th2) {
                abandonChanges();
                throw th2;
            }
        }
    }
}
