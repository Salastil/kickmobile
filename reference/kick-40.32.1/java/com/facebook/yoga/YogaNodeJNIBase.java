package com.facebook.yoga;

import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YogaNodeJNIBase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\bO\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u0080\u00022\u00020\u00012\u00020\u0002:\u0002\u0080\u0002B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0010¢\u0006\u0004\b\u0005\u0010\u0007B\u0011\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\nJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u001bH\u0016J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u001bH\u0016J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001dH\u0016J\u0016\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001bJ\b\u0010-\u001a\u00020\u0000H\u0016J\b\u0010.\u001a\u00020\u0000H\u0016J\b\u0010/\u001a\u00020\u001fH\u0002J\u0010\u00100\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u001bH\u0016J\n\u00101\u001a\u0004\u0018\u00010\u0000H\u0016J\n\u00102\u001a\u0004\u0018\u00010\u0000H\u0017J\u0010\u00103\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0001H\u0016J\u0018\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0016J\u0012\u00108\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010:\u001a\u00020\u001fH\u0016J\b\u0010;\u001a\u00020\u001dH\u0016J\u0010\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u0001H\u0016J\u0010\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020?H\u0016J\u0012\u0010\u008a\u0001\u001a\u00020\u001f2\u0007\u0010\u0086\u0001\u001a\u000206H\u0016J\u0012\u0010\u008b\u0001\u001a\u00020\u001f2\u0007\u0010\u008c\u0001\u001a\u000206H\u0016J\t\u0010\u008d\u0001\u001a\u00020\u001fH\u0016J\t\u0010\u008e\u0001\u001a\u00020\u001fH\u0016J\t\u0010\u008f\u0001\u001a\u00020\u001fH\u0016J\t\u0010\u0090\u0001\u001a\u00020\u001fH\u0016J\u0014\u0010\u0091\u0001\u001a\u00030\u0087\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u001c\u0010\u0094\u0001\u001a\u00020\u001f2\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u0095\u0001\u001a\u000206H\u0016J\u001c\u0010\u0096\u0001\u001a\u00020\u001f2\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u008c\u0001\u001a\u000206H\u0016J\u0013\u0010\u0097\u0001\u001a\u00020\u001f2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u0014\u0010\u0098\u0001\u001a\u00030\u0087\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u001c\u0010\u0099\u0001\u001a\u00020\u001f2\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u009a\u0001\u001a\u000206H\u0016J\u001c\u0010\u009b\u0001\u001a\u00020\u001f2\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u008c\u0001\u001a\u000206H\u0016J\u0013\u0010\u009c\u0001\u001a\u0002062\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u001b\u0010\u009d\u0001\u001a\u00020\u001f2\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0006\u0010D\u001a\u000206H\u0016J\u0014\u0010\u009e\u0001\u001a\u00030\u0087\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u001b\u0010\u009f\u0001\u001a\u00020\u001f2\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0006\u0010,\u001a\u000206H\u0016J\u001c\u0010 \u0001\u001a\u00020\u001f2\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u008c\u0001\u001a\u000206H\u0016J\u0013\u0010¡\u0001\u001a\u00020\u001f2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u0011\u0010£\u0001\u001a\u00020\u001f2\u0006\u00105\u001a\u000206H\u0016J\u0012\u0010¤\u0001\u001a\u00020\u001f2\u0007\u0010\u008c\u0001\u001a\u000206H\u0016J\t\u0010¥\u0001\u001a\u00020\u001fH\u0016J\t\u0010¦\u0001\u001a\u00020\u001fH\u0016J\t\u0010§\u0001\u001a\u00020\u001fH\u0016J\t\u0010¨\u0001\u001a\u00020\u001fH\u0016J\u0011\u0010ª\u0001\u001a\u00020\u001f2\u0006\u00107\u001a\u000206H\u0016J\u0012\u0010«\u0001\u001a\u00020\u001f2\u0007\u0010\u008c\u0001\u001a\u000206H\u0016J\t\u0010¬\u0001\u001a\u00020\u001fH\u0016J\t\u0010\u00ad\u0001\u001a\u00020\u001fH\u0016J\t\u0010®\u0001\u001a\u00020\u001fH\u0016J\t\u0010¯\u0001\u001a\u00020\u001fH\u0016J\u0012\u0010²\u0001\u001a\u00020\u001f2\u0007\u0010°\u0001\u001a\u000206H\u0016J\u0012\u0010³\u0001\u001a\u00020\u001f2\u0007\u0010\u008c\u0001\u001a\u000206H\u0016J\t\u0010´\u0001\u001a\u00020\u001fH\u0016J\t\u0010µ\u0001\u001a\u00020\u001fH\u0016J\t\u0010¶\u0001\u001a\u00020\u001fH\u0016J\u0012\u0010¹\u0001\u001a\u00020\u001f2\u0007\u0010·\u0001\u001a\u000206H\u0016J\u0012\u0010º\u0001\u001a\u00020\u001f2\u0007\u0010\u008c\u0001\u001a\u000206H\u0016J\t\u0010»\u0001\u001a\u00020\u001fH\u0016J\t\u0010¼\u0001\u001a\u00020\u001fH\u0016J\t\u0010½\u0001\u001a\u00020\u001fH\u0016J\u0012\u0010À\u0001\u001a\u00020\u001f2\u0007\u0010¾\u0001\u001a\u000206H\u0016J\u0012\u0010Á\u0001\u001a\u00020\u001f2\u0007\u0010\u008c\u0001\u001a\u000206H\u0016J\t\u0010Â\u0001\u001a\u00020\u001fH\u0016J\t\u0010Ã\u0001\u001a\u00020\u001fH\u0016J\t\u0010Ä\u0001\u001a\u00020\u001fH\u0016J\u0012\u0010Ç\u0001\u001a\u00020\u001f2\u0007\u0010Å\u0001\u001a\u000206H\u0016J\u0012\u0010È\u0001\u001a\u00020\u001f2\u0007\u0010\u008c\u0001\u001a\u000206H\u0016J\t\u0010É\u0001\u001a\u00020\u001fH\u0016J\t\u0010Ê\u0001\u001a\u00020\u001fH\u0016J\t\u0010Ë\u0001\u001a\u00020\u001fH\u0016J\u0013\u0010Ï\u0001\u001a\u00020\u001f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0013\u0010Ð\u0001\u001a\u00020\u001f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010Ñ\u0001\u001a\u00020\u001f2\u0007\u0010Ò\u0001\u001a\u000206H\u0016J\u0012\u0010Ó\u0001\u001a\u00020\u001f2\u0007\u0010Ô\u0001\u001a\u000206H\u0016J\t\u0010Õ\u0001\u001a\u000206H\u0016J\t\u0010Ö\u0001\u001a\u000206H\u0016J\u0012\u0010×\u0001\u001a\u00020\u001f2\u0007\u0010Ø\u0001\u001a\u00020\u001dH\u0016J+\u0010Ù\u0001\u001a\u00020\u00042\u0006\u00105\u001a\u0002062\u0007\u0010Ú\u0001\u001a\u00020\u001b2\u0006\u00107\u001a\u0002062\u0007\u0010Û\u0001\u001a\u00020\u001bH\u0007J+\u0010Ü\u0001\u001a\u00020\u00042\u0006\u00105\u001a\u0002062\u0007\u0010Ú\u0001\u001a\u00020\u001b2\u0006\u00107\u001a\u0002062\u0007\u0010Û\u0001\u001a\u00020\u001bH\u0007J\u0014\u0010Ý\u0001\u001a\u00020\u001f2\t\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0013H\u0016J\u0019\u0010ß\u0001\u001a\u0002062\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0007J\u001b\u0010è\u0001\u001a\u00020\u00042\u0007\u0010é\u0001\u001a\u00020\u00002\u0007\u0010ê\u0001\u001a\u00020\u001bH\u0003J\u0013\u0010ó\u0001\u001a\u0002062\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u0013\u0010ô\u0001\u001a\u0002062\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u0013\u0010õ\u0001\u001a\u0002062\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\t\u0010ø\u0001\u001a\u00020\u001dH\u0016J\t\u0010ù\u0001\u001a\u00020\u001fH\u0016J\u0014\u0010ú\u0001\u001a\u00030\u0087\u00012\b\u0010û\u0001\u001a\u00030ü\u0001H\u0016J\u001c\u0010ý\u0001\u001a\u00020\u001f2\b\u0010û\u0001\u001a\u00030ü\u00012\u0007\u0010þ\u0001\u001a\u000206H\u0016J\u001c\u0010ÿ\u0001\u001a\u00020\u001f2\b\u0010û\u0001\u001a\u00030ü\u00012\u0007\u0010þ\u0001\u001a\u000206H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0006R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010(\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010>\u001a\u00020?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR$\u0010F\u001a\u00020E2\u0006\u0010D\u001a\u00020E8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010L\u001a\u00020K2\u0006\u0010D\u001a\u00020K8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010R\u001a\u00020Q2\u0006\u0010D\u001a\u00020Q8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010W\u001a\u00020Q2\u0006\u0010D\u001a\u00020Q8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bX\u0010T\"\u0004\bY\u0010VR$\u0010Z\u001a\u00020Q2\u0006\u0010D\u001a\u00020Q8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b[\u0010T\"\u0004\b\\\u0010VR$\u0010^\u001a\u00020]2\u0006\u0010D\u001a\u00020]8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010d\u001a\u00020c2\u0006\u0010D\u001a\u00020c8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010j\u001a\u00020i2\u0006\u0010D\u001a\u00020i8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR(\u0010p\u001a\u0004\u0018\u00010o2\b\u0010D\u001a\u0004\u0018\u00010o8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR(\u0010v\u001a\u0004\u0018\u00010u2\b\u0010D\u001a\u0004\u0018\u00010u8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010{\u001a\u0002062\u0006\u0010D\u001a\u0002068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR'\u0010\u0080\u0001\u001a\u0002062\u0006\u0010D\u001a\u0002068V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0081\u0001\u0010}\"\u0005\b\u0082\u0001\u0010\u007fR'\u0010\u0083\u0001\u001a\u0002062\u0006\u0010D\u001a\u0002068V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0084\u0001\u0010}\"\u0005\b\u0085\u0001\u0010\u007fR\u0018\u0010\u0086\u0001\u001a\u00030\u0087\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0017\u00105\u001a\u00030\u0087\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010\u0089\u0001R\u0017\u00107\u001a\u00030\u0087\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b©\u0001\u0010\u0089\u0001R\u0018\u0010°\u0001\u001a\u00030\u0087\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b±\u0001\u0010\u0089\u0001R\u0018\u0010·\u0001\u001a\u00030\u0087\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¸\u0001\u0010\u0089\u0001R\u0018\u0010¾\u0001\u001a\u00030\u0087\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¿\u0001\u0010\u0089\u0001R\u0018\u0010Å\u0001\u001a\u00030\u0087\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÆ\u0001\u0010\u0089\u0001R'\u0010Ì\u0001\u001a\u0002062\u0006\u0010D\u001a\u0002068V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÍ\u0001\u0010}\"\u0005\bÎ\u0001\u0010\u007fR\u0016\u0010à\u0001\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bà\u0001\u0010)R\u0016\u0010á\u0001\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bá\u0001\u0010)R\"\u0010â\u0001\u001a\u0005\u0018\u00010ã\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bä\u0001\u0010å\u0001\"\u0006\bæ\u0001\u0010ç\u0001R\u0016\u0010ë\u0001\u001a\u0002068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bì\u0001\u0010}R\u0016\u0010í\u0001\u001a\u0002068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bî\u0001\u0010}R\u0016\u0010ï\u0001\u001a\u0002068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bð\u0001\u0010}R\u0016\u0010ñ\u0001\u001a\u0002068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bò\u0001\u0010}R\u0016\u0010ö\u0001\u001a\u00020?8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b÷\u0001\u0010A¨\u0006\u0081\u0002"}, d2 = {"Lcom/facebook/yoga/YogaNodeJNIBase;", "Lcom/facebook/yoga/YogaNode;", "", "nativePtr", "", "<init>", "(J)V", "()V", "yogaConfig", "Lcom/facebook/yoga/YogaConfig;", "(Lcom/facebook/yoga/YogaConfig;)V", "owner", "config", "children", "", "measureFunction", "Lcom/facebook/yoga/YogaMeasureFunction;", "minContentMeasureFunction", "baselineFunction", "Lcom/facebook/yoga/YogaBaselineFunction;", "nativePointer", "getNativePointer", "()J", "setNativePointer", "arr", "", "mLayoutDirection", "", "hasNewLayoutField", "", "reset", "", "childCount", "getChildCount", "()I", "getChildAt", ContextChain.TAG_INFRA, "addChildAt", "child", "setIsReferenceBaseline", "isReferenceBaseline", "()Z", "swapChildAt", "newChild", ViewProps.POSITION, "cloneWithChildren", "cloneWithoutChildren", "clearChildren", "removeChildAt", "getOwner", "getParent", "indexOf", "calculateLayout", ViewProps.WIDTH, "", ViewProps.HEIGHT, "freeze", "parent", "dirty", "isDirty", "copyStyle", "srcNode", "styleDirection", "Lcom/facebook/yoga/YogaDirection;", "getStyleDirection", "()Lcom/facebook/yoga/YogaDirection;", "setDirection", "direction", "value", "Lcom/facebook/yoga/YogaFlexDirection;", ViewProps.FLEX_DIRECTION, "getFlexDirection", "()Lcom/facebook/yoga/YogaFlexDirection;", "setFlexDirection", "(Lcom/facebook/yoga/YogaFlexDirection;)V", "Lcom/facebook/yoga/YogaJustify;", ViewProps.JUSTIFY_CONTENT, "getJustifyContent", "()Lcom/facebook/yoga/YogaJustify;", "setJustifyContent", "(Lcom/facebook/yoga/YogaJustify;)V", "Lcom/facebook/yoga/YogaAlign;", ViewProps.ALIGN_ITEMS, "getAlignItems", "()Lcom/facebook/yoga/YogaAlign;", "setAlignItems", "(Lcom/facebook/yoga/YogaAlign;)V", ViewProps.ALIGN_SELF, "getAlignSelf", "setAlignSelf", ViewProps.ALIGN_CONTENT, "getAlignContent", "setAlignContent", "Lcom/facebook/yoga/YogaPositionType;", "positionType", "getPositionType", "()Lcom/facebook/yoga/YogaPositionType;", "setPositionType", "(Lcom/facebook/yoga/YogaPositionType;)V", "Lcom/facebook/yoga/YogaBoxSizing;", "boxSizing", "getBoxSizing", "()Lcom/facebook/yoga/YogaBoxSizing;", "setBoxSizing", "(Lcom/facebook/yoga/YogaBoxSizing;)V", "Lcom/facebook/yoga/YogaWrap;", "wrap", "getWrap", "()Lcom/facebook/yoga/YogaWrap;", "setWrap", "(Lcom/facebook/yoga/YogaWrap;)V", "Lcom/facebook/yoga/YogaOverflow;", ViewProps.OVERFLOW, "getOverflow", "()Lcom/facebook/yoga/YogaOverflow;", "setOverflow", "(Lcom/facebook/yoga/YogaOverflow;)V", "Lcom/facebook/yoga/YogaDisplay;", "display", "getDisplay", "()Lcom/facebook/yoga/YogaDisplay;", "setDisplay", "(Lcom/facebook/yoga/YogaDisplay;)V", ViewProps.FLEX, "getFlex", "()F", "setFlex", "(F)V", ViewProps.FLEX_GROW, "getFlexGrow", "setFlexGrow", ViewProps.FLEX_SHRINK, "getFlexShrink", "setFlexShrink", ViewProps.FLEX_BASIS, "Lcom/facebook/yoga/YogaValue;", "getFlexBasis", "()Lcom/facebook/yoga/YogaValue;", "setFlexBasis", "setFlexBasisPercent", "percent", "setFlexBasisAuto", "setFlexBasisMaxContent", "setFlexBasisFitContent", "setFlexBasisStretch", "getMargin", "edge", "Lcom/facebook/yoga/YogaEdge;", "setMargin", ViewProps.MARGIN, "setMarginPercent", "setMarginAuto", "getPadding", "setPadding", ViewProps.PADDING, "setPaddingPercent", "getBorder", "setBorder", "getPosition", "setPosition", "setPositionPercent", "setPositionAuto", "getWidth", "setWidth", "setWidthPercent", "setWidthAuto", "setWidthMaxContent", "setWidthFitContent", "setWidthStretch", "getHeight", "setHeight", "setHeightPercent", "setHeightAuto", "setHeightMaxContent", "setHeightFitContent", "setHeightStretch", ViewProps.MIN_WIDTH, "getMinWidth", "setMinWidth", "setMinWidthPercent", "setMinWidthMaxContent", "setMinWidthFitContent", "setMinWidthStretch", ViewProps.MIN_HEIGHT, "getMinHeight", "setMinHeight", "setMinHeightPercent", "setMinHeightMaxContent", "setMinHeightFitContent", "setMinHeightStretch", ViewProps.MAX_WIDTH, "getMaxWidth", "setMaxWidth", "setMaxWidthPercent", "setMaxWidthMaxContent", "setMaxWidthFitContent", "setMaxWidthStretch", ViewProps.MAX_HEIGHT, "getMaxHeight", "setMaxHeight", "setMaxHeightPercent", "setMaxHeightMaxContent", "setMaxHeightFitContent", "setMaxHeightStretch", ViewProps.ASPECT_RATIO, "getAspectRatio", "setAspectRatio", "setMeasureFunction", "setMinContentMeasureFunction", "setMinContentWidth", "minContentWidth", "setMinContentHeight", "minContentHeight", "getMinContentWidth", "getMinContentHeight", "setAlwaysFormsContainingBlock", "alwaysFormsContainingBlock", "measure", "widthMode", "heightMode", "measureMinContent", "setBaselineFunction", "yogaBaselineFunction", "baseline", "isMeasureDefined", "isBaselineDefined", "data", "", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "replaceChild", "newNode", "childIndex", "layoutX", "getLayoutX", "layoutY", "getLayoutY", "layoutWidth", "getLayoutWidth", "layoutHeight", "getLayoutHeight", "getLayoutMargin", "getLayoutPadding", "getLayoutBorder", ViewProps.LAYOUT_DIRECTION, "getLayoutDirection", "hasNewLayout", "markLayoutSeen", "getGap", "gutter", "Lcom/facebook/yoga/YogaGutter;", "setGap", "gapLength", "setGapPercent", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class YogaNodeJNIBase extends YogaNode implements Cloneable {
    private static final int BORDER = 4;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int HAS_NEW_LAYOUT = 16;
    private static final int LAYOUT_BORDER_START_INDEX = 14;
    private static final int LAYOUT_DIRECTION_INDEX = 5;
    private static final int LAYOUT_EDGE_SET_FLAG_INDEX = 0;
    private static final int LAYOUT_HEIGHT_INDEX = 2;
    private static final int LAYOUT_LEFT_INDEX = 3;
    private static final int LAYOUT_MARGIN_START_INDEX = 6;
    private static final int LAYOUT_PADDING_START_INDEX = 10;
    private static final int LAYOUT_TOP_INDEX = 4;
    private static final int LAYOUT_WIDTH_INDEX = 1;
    private static final int MARGIN = 1;
    private static final int PADDING = 2;
    private float[] arr;
    private YogaBaselineFunction baselineFunction;
    private List<YogaNodeJNIBase> children;
    private YogaConfig config;
    private Object data;
    private boolean hasNewLayoutField;
    private int mLayoutDirection;
    private YogaMeasureFunction measureFunction;
    private YogaMeasureFunction minContentMeasureFunction;
    private long nativePointer;
    private YogaNodeJNIBase owner;

    /* JADX INFO: compiled from: YogaNodeJNIBase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[YogaEdge.values().length];
            try {
                iArr[YogaEdge.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[YogaEdge.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[YogaEdge.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[YogaEdge.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[YogaEdge.START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[YogaEdge.END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    private static final YogaValue valueFromLong(long j) {
        return INSTANCE.valueFromLong(j);
    }

    public Object clone() {
        return super.clone();
    }

    protected final long getNativePointer() {
        return this.nativePointer;
    }

    protected final void setNativePointer(long j) {
        this.nativePointer = j;
    }

    private YogaNodeJNIBase(long j) {
        this.hasNewLayoutField = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.nativePointer = j;
    }

    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YogaNodeJNIBase(YogaConfig yogaConfig) {
        this(YogaNative.jni_YGNodeNewWithConfigJNI(((YogaConfigJNIBase) yogaConfig).getNativePointer()));
        Intrinsics.checkNotNullParameter(yogaConfig, "yogaConfig");
        this.config = yogaConfig;
    }

    @Override // com.facebook.yoga.YogaNode
    public void reset() {
        this.measureFunction = null;
        this.minContentMeasureFunction = null;
        this.baselineFunction = null;
        setData(null);
        this.arr = null;
        this.hasNewLayoutField = true;
        this.mLayoutDirection = 0;
        YogaNative.jni_YGNodeResetJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public int getChildCount() {
        List<YogaNodeJNIBase> list = this.children;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase getChildAt(int i) {
        YogaNodeJNIBase yogaNodeJNIBase;
        List<YogaNodeJNIBase> list = this.children;
        if (list == null || (yogaNodeJNIBase = list.get(i)) == null) {
            throw new IllegalStateException("YogaNode does not have children");
        }
        return yogaNodeJNIBase;
    }

    @Override // com.facebook.yoga.YogaNode
    public void addChildAt(YogaNode child, int i) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (child instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) child;
            if (yogaNodeJNIBase.owner != null) {
                throw new IllegalStateException("Child already has a parent, it must be removed first.");
            }
            ArrayList arrayList = this.children;
            if (arrayList == null) {
                arrayList = new ArrayList(4);
                this.children = arrayList;
            }
            arrayList.add(i, child);
            yogaNodeJNIBase.owner = this;
            YogaNative.jni_YGNodeInsertChildJNI(this.nativePointer, yogaNodeJNIBase.nativePointer, i);
        }
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setIsReferenceBaseline(boolean isReferenceBaseline) {
        YogaNative.jni_YGNodeSetIsReferenceBaselineJNI(this.nativePointer, isReferenceBaseline);
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isReferenceBaseline() {
        return YogaNative.jni_YGNodeIsReferenceBaselineJNI(this.nativePointer);
    }

    public final void swapChildAt(YogaNode newChild, int position) {
        Intrinsics.checkNotNullParameter(newChild, "newChild");
        if (newChild instanceof YogaNodeJNIBase) {
            List<YogaNodeJNIBase> list = this.children;
            if (list == null) {
                throw new IllegalStateException("YogaNode does not have children".toString());
            }
            list.remove(position);
            list.add(position, newChild);
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) newChild;
            yogaNodeJNIBase.owner = this;
            YogaNative.jni_YGNodeSwapChildJNI(this.nativePointer, yogaNodeJNIBase.nativePointer, position);
        }
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase cloneWithChildren() {
        try {
            Object objClone = super.clone();
            Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type com.facebook.yoga.YogaNodeJNIBase");
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) objClone;
            List<YogaNodeJNIBase> list = yogaNodeJNIBase.children;
            if (list != null) {
                yogaNodeJNIBase.children = new ArrayList(list);
            }
            long jJni_YGNodeCloneJNI = YogaNative.jni_YGNodeCloneJNI(this.nativePointer);
            yogaNodeJNIBase.owner = null;
            yogaNodeJNIBase.nativePointer = jJni_YGNodeCloneJNI;
            int childCount = yogaNodeJNIBase.getChildCount();
            for (int i = 0; i < childCount; i++) {
                yogaNodeJNIBase.swapChildAt(yogaNodeJNIBase.getChildAt(i).cloneWithChildren(), i);
            }
            return yogaNodeJNIBase;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase cloneWithoutChildren() {
        try {
            Object objClone = super.clone();
            Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type com.facebook.yoga.YogaNodeJNIBase");
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) objClone;
            long jJni_YGNodeCloneJNI = YogaNative.jni_YGNodeCloneJNI(this.nativePointer);
            yogaNodeJNIBase.owner = null;
            yogaNodeJNIBase.nativePointer = jJni_YGNodeCloneJNI;
            yogaNodeJNIBase.clearChildren();
            return yogaNodeJNIBase;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private final void clearChildren() {
        this.children = null;
        YogaNative.jni_YGNodeRemoveAllChildrenJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase removeChildAt(int i) {
        List<YogaNodeJNIBase> list = this.children;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase yogaNodeJNIBaseRemove = list.remove(i);
        yogaNodeJNIBaseRemove.owner = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.nativePointer, yogaNodeJNIBaseRemove.nativePointer);
        return yogaNodeJNIBaseRemove;
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase getOwner() {
        return this.owner;
    }

    @Override // com.facebook.yoga.YogaNode
    @Deprecated(message = "Use getOwner() instead. This will be removed in the next version.")
    public YogaNodeJNIBase getParent() {
        return getOwner();
    }

    @Override // com.facebook.yoga.YogaNode
    public int indexOf(YogaNode child) {
        Intrinsics.checkNotNullParameter(child, "child");
        List<YogaNodeJNIBase> list = this.children;
        if (list != null) {
            return CollectionsKt.indexOf((List<? extends YogaNode>) list, child);
        }
        return -1;
    }

    @Override // com.facebook.yoga.YogaNode
    public void calculateLayout(float width, float height) {
        freeze(null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) obj;
            List<YogaNodeJNIBase> list = yogaNodeJNIBase.children;
            if (list != null) {
                for (YogaNodeJNIBase yogaNodeJNIBase2 : list) {
                    yogaNodeJNIBase2.freeze(yogaNodeJNIBase);
                    arrayList.add(yogaNodeJNIBase2);
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[0]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        int length = yogaNodeJNIBaseArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            jArr[i2] = yogaNodeJNIBaseArr[i2].nativePointer;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.nativePointer, width, height, jArr, yogaNodeJNIBaseArr);
    }

    private final void freeze(YogaNode parent) {
        Object data = getData();
        if (data instanceof YogaNode.Inputs) {
            ((YogaNode.Inputs) data).freeze(this, parent);
        }
    }

    @Override // com.facebook.yoga.YogaNode
    public void dirty() {
        YogaNative.jni_YGNodeMarkDirtyJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isDirty() {
        return YogaNative.jni_YGNodeIsDirtyJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public void copyStyle(YogaNode srcNode) {
        Intrinsics.checkNotNullParameter(srcNode, "srcNode");
        if (srcNode instanceof YogaNodeJNIBase) {
            YogaNative.jni_YGNodeCopyStyleJNI(this.nativePointer, ((YogaNodeJNIBase) srcNode).nativePointer);
        }
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaDirection getStyleDirection() {
        return YogaDirection.INSTANCE.fromInt(YogaNative.jni_YGNodeStyleGetDirectionJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setDirection(YogaDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.nativePointer, direction.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaFlexDirection getFlexDirection() {
        return YogaFlexDirection.INSTANCE.fromInt(YogaNative.jni_YGNodeStyleGetFlexDirectionJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexDirection(YogaFlexDirection value) {
        Intrinsics.checkNotNullParameter(value, "value");
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.nativePointer, value.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaJustify getJustifyContent() {
        return YogaJustify.INSTANCE.fromInt(YogaNative.jni_YGNodeStyleGetJustifyContentJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setJustifyContent(YogaJustify value) {
        Intrinsics.checkNotNullParameter(value, "value");
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.nativePointer, value.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaAlign getAlignItems() {
        return YogaAlign.INSTANCE.fromInt(YogaNative.jni_YGNodeStyleGetAlignItemsJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setAlignItems(YogaAlign value) {
        Intrinsics.checkNotNullParameter(value, "value");
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.nativePointer, value.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaAlign getAlignSelf() {
        return YogaAlign.INSTANCE.fromInt(YogaNative.jni_YGNodeStyleGetAlignSelfJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setAlignSelf(YogaAlign value) {
        Intrinsics.checkNotNullParameter(value, "value");
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.nativePointer, value.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaAlign getAlignContent() {
        return YogaAlign.INSTANCE.fromInt(YogaNative.jni_YGNodeStyleGetAlignContentJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setAlignContent(YogaAlign value) {
        Intrinsics.checkNotNullParameter(value, "value");
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.nativePointer, value.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaPositionType getPositionType() {
        return YogaPositionType.INSTANCE.fromInt(YogaNative.jni_YGNodeStyleGetPositionTypeJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPositionType(YogaPositionType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.nativePointer, value.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaBoxSizing getBoxSizing() {
        return YogaBoxSizing.INSTANCE.fromInt(YogaNative.jni_YGNodeStyleGetBoxSizingJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setBoxSizing(YogaBoxSizing value) {
        Intrinsics.checkNotNullParameter(value, "value");
        YogaNative.jni_YGNodeStyleSetBoxSizingJNI(this.nativePointer, value.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaWrap getWrap() {
        return YogaWrap.INSTANCE.fromInt(YogaNative.jni_YGNodeStyleGetFlexWrapJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWrap(YogaWrap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.nativePointer, value.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaOverflow getOverflow() {
        return YogaOverflow.INSTANCE.fromInt(YogaNative.jni_YGNodeStyleGetOverflowJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setOverflow(YogaOverflow yogaOverflow) {
        long j = this.nativePointer;
        if (yogaOverflow != null) {
            YogaNative.jni_YGNodeStyleSetOverflowJNI(j, yogaOverflow.intValue());
            return;
        }
        throw new IllegalArgumentException("overflow must not be null".toString());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaDisplay getDisplay() {
        return YogaDisplay.INSTANCE.fromInt(YogaNative.jni_YGNodeStyleGetDisplayJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setDisplay(YogaDisplay yogaDisplay) {
        long j = this.nativePointer;
        if (yogaDisplay != null) {
            YogaNative.jni_YGNodeStyleSetDisplayJNI(j, yogaDisplay.intValue());
            return;
        }
        throw new IllegalArgumentException("display must not be null".toString());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getFlex() {
        return YogaNative.jni_YGNodeStyleGetFlexJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlex(float f) {
        YogaNative.jni_YGNodeStyleSetFlexJNI(this.nativePointer, f);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getFlexGrow() {
        return YogaNative.jni_YGNodeStyleGetFlexGrowJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexGrow(float f) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.nativePointer, f);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getFlexShrink() {
        return YogaNative.jni_YGNodeStyleGetFlexShrinkJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexShrink(float f) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.nativePointer, f);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getFlexBasis() {
        return INSTANCE.valueFromLong(YogaNative.jni_YGNodeStyleGetFlexBasisJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexBasis(float flexBasis) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.nativePointer, flexBasis);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexBasisPercent(float percent) {
        YogaNative.jni_YGNodeStyleSetFlexBasisPercentJNI(this.nativePointer, percent);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexBasisAuto() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexBasisMaxContent() {
        YogaNative.jni_YGNodeStyleSetFlexBasisMaxContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexBasisFitContent() {
        YogaNative.jni_YGNodeStyleSetFlexBasisFitContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexBasisStretch() {
        YogaNative.jni_YGNodeStyleSetFlexBasisStretchJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMargin(YogaEdge edge) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        return INSTANCE.valueFromLong(YogaNative.jni_YGNodeStyleGetMarginJNI(this.nativePointer, edge.intValue()));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMargin(YogaEdge edge, float margin) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.nativePointer, edge.intValue(), margin);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMarginPercent(YogaEdge edge, float percent) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        YogaNative.jni_YGNodeStyleSetMarginPercentJNI(this.nativePointer, edge.intValue(), percent);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMarginAuto(YogaEdge edge) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        YogaNative.jni_YGNodeStyleSetMarginAutoJNI(this.nativePointer, edge.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getPadding(YogaEdge edge) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        return INSTANCE.valueFromLong(YogaNative.jni_YGNodeStyleGetPaddingJNI(this.nativePointer, edge.intValue()));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPadding(YogaEdge edge, float padding) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.nativePointer, edge.intValue(), padding);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPaddingPercent(YogaEdge edge, float percent) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        YogaNative.jni_YGNodeStyleSetPaddingPercentJNI(this.nativePointer, edge.intValue(), percent);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getBorder(YogaEdge edge) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        return YogaNative.jni_YGNodeStyleGetBorderJNI(this.nativePointer, edge.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setBorder(YogaEdge edge, float value) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        YogaNative.jni_YGNodeStyleSetBorderJNI(this.nativePointer, edge.intValue(), value);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getPosition(YogaEdge edge) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        return INSTANCE.valueFromLong(YogaNative.jni_YGNodeStyleGetPositionJNI(this.nativePointer, edge.intValue()));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPosition(YogaEdge edge, float position) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.nativePointer, edge.intValue(), position);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPositionPercent(YogaEdge edge, float percent) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        YogaNative.jni_YGNodeStyleSetPositionPercentJNI(this.nativePointer, edge.intValue(), percent);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setPositionAuto(YogaEdge edge) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        YogaNative.jni_YGNodeStyleSetPositionAutoJNI(this.nativePointer, edge.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getWidth() {
        return INSTANCE.valueFromLong(YogaNative.jni_YGNodeStyleGetWidthJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWidth(float width) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.nativePointer, width);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWidthPercent(float percent) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.nativePointer, percent);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWidthAuto() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWidthMaxContent() {
        YogaNative.jni_YGNodeStyleSetWidthMaxContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWidthFitContent() {
        YogaNative.jni_YGNodeStyleSetWidthFitContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWidthStretch() {
        YogaNative.jni_YGNodeStyleSetWidthStretchJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getHeight() {
        return INSTANCE.valueFromLong(YogaNative.jni_YGNodeStyleGetHeightJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setHeight(float height) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.nativePointer, height);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setHeightPercent(float percent) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.nativePointer, percent);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setHeightAuto() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setHeightMaxContent() {
        YogaNative.jni_YGNodeStyleSetHeightMaxContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setHeightFitContent() {
        YogaNative.jni_YGNodeStyleSetHeightFitContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setHeightStretch() {
        YogaNative.jni_YGNodeStyleSetHeightStretchJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMinWidth() {
        return INSTANCE.valueFromLong(YogaNative.jni_YGNodeStyleGetMinWidthJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinWidth(float minWidth) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.nativePointer, minWidth);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinWidthPercent(float percent) {
        YogaNative.jni_YGNodeStyleSetMinWidthPercentJNI(this.nativePointer, percent);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinWidthMaxContent() {
        YogaNative.jni_YGNodeStyleSetMinWidthMaxContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinWidthFitContent() {
        YogaNative.jni_YGNodeStyleSetMinWidthFitContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinWidthStretch() {
        YogaNative.jni_YGNodeStyleSetMinWidthStretchJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMinHeight() {
        return INSTANCE.valueFromLong(YogaNative.jni_YGNodeStyleGetMinHeightJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinHeight(float minHeight) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.nativePointer, minHeight);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinHeightPercent(float percent) {
        YogaNative.jni_YGNodeStyleSetMinHeightPercentJNI(this.nativePointer, percent);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinHeightMaxContent() {
        YogaNative.jni_YGNodeStyleSetMinHeightMaxContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinHeightFitContent() {
        YogaNative.jni_YGNodeStyleSetMinHeightFitContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinHeightStretch() {
        YogaNative.jni_YGNodeStyleSetMinHeightStretchJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMaxWidth() {
        return INSTANCE.valueFromLong(YogaNative.jni_YGNodeStyleGetMaxWidthJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxWidth(float maxWidth) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.nativePointer, maxWidth);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxWidthPercent(float percent) {
        YogaNative.jni_YGNodeStyleSetMaxWidthPercentJNI(this.nativePointer, percent);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxWidthMaxContent() {
        YogaNative.jni_YGNodeStyleSetMaxWidthMaxContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxWidthFitContent() {
        YogaNative.jni_YGNodeStyleSetMaxWidthFitContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxWidthStretch() {
        YogaNative.jni_YGNodeStyleSetMaxWidthStretchJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMaxHeight() {
        return INSTANCE.valueFromLong(YogaNative.jni_YGNodeStyleGetMaxHeightJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxHeight(float maxHeight) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.nativePointer, maxHeight);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxHeightPercent(float percent) {
        YogaNative.jni_YGNodeStyleSetMaxHeightPercentJNI(this.nativePointer, percent);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxHeightMaxContent() {
        YogaNative.jni_YGNodeStyleSetMaxHeightMaxContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxHeightFitContent() {
        YogaNative.jni_YGNodeStyleSetMaxHeightFitContentJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxHeightStretch() {
        YogaNative.jni_YGNodeStyleSetMaxHeightStretchJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getAspectRatio() {
        return YogaNative.jni_YGNodeStyleGetAspectRatioJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setAspectRatio(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.nativePointer, f);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMeasureFunction(YogaMeasureFunction measureFunction) {
        this.measureFunction = measureFunction;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.nativePointer, measureFunction != null);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinContentMeasureFunction(YogaMeasureFunction measureFunction) {
        this.minContentMeasureFunction = measureFunction;
        YogaNative.jni_YGNodeSetHasMinContentMeasureFuncJNI(this.nativePointer, measureFunction != null);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinContentWidth(float minContentWidth) {
        YogaNative.jni_YGNodeSetMinContentWidthJNI(this.nativePointer, minContentWidth);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinContentHeight(float minContentHeight) {
        YogaNative.jni_YGNodeSetMinContentHeightJNI(this.nativePointer, minContentHeight);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getMinContentWidth() {
        return YogaNative.jni_YGNodeGetMinContentWidthJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getMinContentHeight() {
        return YogaNative.jni_YGNodeGetMinContentHeightJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setAlwaysFormsContainingBlock(boolean alwaysFormsContainingBlock) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.nativePointer, alwaysFormsContainingBlock);
    }

    public final long measure(float width, int widthMode, float height, int heightMode) {
        YogaMeasureFunction yogaMeasureFunction = this.measureFunction;
        if (yogaMeasureFunction == null) {
            throw new IllegalStateException("Measure function isn't defined!".toString());
        }
        return yogaMeasureFunction.measure(this, width, YogaMeasureMode.INSTANCE.fromInt(widthMode), height, YogaMeasureMode.INSTANCE.fromInt(heightMode));
    }

    public final long measureMinContent(float width, int widthMode, float height, int heightMode) {
        YogaMeasureFunction yogaMeasureFunction = this.minContentMeasureFunction;
        if (yogaMeasureFunction == null) {
            throw new IllegalStateException("Min-content measure function isn't defined!".toString());
        }
        return yogaMeasureFunction.measure(this, width, YogaMeasureMode.INSTANCE.fromInt(widthMode), height, YogaMeasureMode.INSTANCE.fromInt(heightMode));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction) {
        this.baselineFunction = yogaBaselineFunction;
        YogaNative.jni_YGNodeSetHasBaselineFuncJNI(this.nativePointer, yogaBaselineFunction != null);
    }

    public final float baseline(float width, float height) {
        YogaBaselineFunction yogaBaselineFunction = this.baselineFunction;
        if (yogaBaselineFunction == null) {
            throw new IllegalStateException("Baseline function isn't defined!".toString());
        }
        return yogaBaselineFunction.baseline(this, width, height);
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isMeasureDefined() {
        return this.measureFunction != null;
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isBaselineDefined() {
        return this.baselineFunction != null;
    }

    @Override // com.facebook.yoga.YogaNode
    public Object getData() {
        return this.data;
    }

    @Override // com.facebook.yoga.YogaNode
    public void setData(Object obj) {
        this.data = obj;
    }

    private final long replaceChild(YogaNodeJNIBase newNode, int childIndex) {
        List<YogaNodeJNIBase> list = this.children;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(childIndex);
        list.add(childIndex, newNode);
        newNode.owner = this;
        return newNode.nativePointer;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutX() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutY() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutWidth() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutHeight() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutMargin(YogaEdge edge) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        float[] fArr = this.arr;
        if (fArr == null || (((int) fArr[0]) & 1) != 1) {
            return 0.0f;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[edge.ordinal()]) {
            case 1:
                return fArr[6];
            case 2:
                return fArr[7];
            case 3:
                return fArr[8];
            case 4:
                return fArr[9];
            case 5:
                return getLayoutDirection() == YogaDirection.RTL ? fArr[8] : fArr[6];
            case 6:
                return getLayoutDirection() == YogaDirection.RTL ? fArr[6] : fArr[8];
            default:
                throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
        }
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutPadding(YogaEdge edge) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        float[] fArr = this.arr;
        if (fArr == null) {
            return 0.0f;
        }
        float f = fArr[0];
        if ((((int) f) & 2) != 2) {
            return 0.0f;
        }
        int i = (((int) f) & 1) != 1 ? 4 : 0;
        int i2 = 10 - i;
        switch (WhenMappings.$EnumSwitchMapping$0[edge.ordinal()]) {
            case 1:
                return fArr[i2];
            case 2:
                return fArr[11 - i];
            case 3:
                return fArr[12 - i];
            case 4:
                return fArr[13 - i];
            case 5:
                return getLayoutDirection() == YogaDirection.RTL ? fArr[12 - i] : fArr[i2];
            case 6:
                return getLayoutDirection() == YogaDirection.RTL ? fArr[i2] : fArr[12 - i];
            default:
                throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
        }
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutBorder(YogaEdge edge) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        float[] fArr = this.arr;
        if (fArr == null) {
            return 0.0f;
        }
        float f = fArr[0];
        if ((((int) f) & 4) != 4) {
            return 0.0f;
        }
        int i = (14 - ((((int) f) & 1) == 1 ? 0 : 4)) - ((((int) f) & 2) != 2 ? 4 : 0);
        switch (WhenMappings.$EnumSwitchMapping$0[edge.ordinal()]) {
            case 1:
                return fArr[i];
            case 2:
                return fArr[i + 1];
            case 3:
                return fArr[i + 2];
            case 4:
                return fArr[i + 3];
            case 5:
                return getLayoutDirection() == YogaDirection.RTL ? fArr[i + 2] : fArr[i];
            case 6:
                return getLayoutDirection() == YogaDirection.RTL ? fArr[i] : fArr[i + 2];
            default:
                throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
        }
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaDirection getLayoutDirection() {
        YogaDirection.Companion companion = YogaDirection.INSTANCE;
        float[] fArr = this.arr;
        return companion.fromInt(fArr != null ? (int) fArr[5] : this.mLayoutDirection);
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean hasNewLayout() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return (((int) fArr[0]) & 16) == 16;
        }
        return this.hasNewLayoutField;
    }

    @Override // com.facebook.yoga.YogaNode
    public void markLayoutSeen() {
        float[] fArr = this.arr;
        if (fArr != null) {
            fArr[0] = ((int) fArr[0]) & (-17);
        }
        this.hasNewLayoutField = false;
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaValue getGap(YogaGutter gutter) {
        Intrinsics.checkNotNullParameter(gutter, "gutter");
        return INSTANCE.valueFromLong(YogaNative.jni_YGNodeStyleGetGapJNI(this.nativePointer, gutter.intValue()));
    }

    @Override // com.facebook.yoga.YogaNode
    public void setGap(YogaGutter gutter, float gapLength) {
        Intrinsics.checkNotNullParameter(gutter, "gutter");
        YogaNative.jni_YGNodeStyleSetGapJNI(this.nativePointer, gutter.intValue(), gapLength);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setGapPercent(YogaGutter gutter, float gapLength) {
        Intrinsics.checkNotNullParameter(gutter, "gutter");
        YogaNative.jni_YGNodeStyleSetGapPercentJNI(this.nativePointer, gutter.intValue(), gapLength);
    }

    /* JADX INFO: compiled from: YogaNodeJNIBase.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/yoga/YogaNodeJNIBase$Companion;", "", "<init>", "()V", "MARGIN", "", "PADDING", "BORDER", "HAS_NEW_LAYOUT", "LAYOUT_EDGE_SET_FLAG_INDEX", "LAYOUT_WIDTH_INDEX", "LAYOUT_HEIGHT_INDEX", "LAYOUT_LEFT_INDEX", "LAYOUT_TOP_INDEX", "LAYOUT_DIRECTION_INDEX", "LAYOUT_MARGIN_START_INDEX", "LAYOUT_PADDING_START_INDEX", "LAYOUT_BORDER_START_INDEX", "valueFromLong", "Lcom/facebook/yoga/YogaValue;", "raw", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final YogaValue valueFromLong(long raw) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return new YogaValue(Float.intBitsToFloat((int) raw), YogaUnit.INSTANCE.fromInt((int) (raw >> 32)));
        }
    }
}
