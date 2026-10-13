package expo.modules.adapters.react;

import com.facebook.jni.HybridData;
import com.facebook.soloader.SoLoader;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.views.AnyViewProp;
import expo.modules.kotlin.views.ViewManagerWrapperDelegate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FabricComponentsRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\bH\u0082 JD\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\r2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\r0\rH\u0082 ¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u000bH\u0004R\u0010\u0010\u0007\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lexpo/modules/adapters/react/FabricComponentsRegistry;", "", "viewDelegates", "", "Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;", "<init>", "(Ljava/util/List;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "initHybrid", "registerComponentsRegistry", "", "componentNames", "", "", "statePropNames", "statePropTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "([Ljava/lang/String;[[Ljava/lang/String;[[Lexpo/modules/kotlin/jni/ExpectedType;)V", "finalize", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FabricComponentsRegistry {
    private final HybridData mHybridData;
    public static final int $stable = 8;

    private final native HybridData initHybrid();

    private final native void registerComponentsRegistry(String[] componentNames, String[][] statePropNames, ExpectedType[][] statePropTypes);

    public FabricComponentsRegistry(List<ViewManagerWrapperDelegate> viewDelegates) {
        Intrinsics.checkNotNullParameter(viewDelegates, "viewDelegates");
        this.mHybridData = initHybrid();
        int size = viewDelegates.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = viewDelegates.get(i).getViewManagerName();
        }
        List<ViewManagerWrapperDelegate> list = viewDelegates;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Map<String, AnyViewProp> props = ((ViewManagerWrapperDelegate) it.next()).getProps();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, AnyViewProp> entry : props.entrySet()) {
                if (entry.getValue().get_isStateProp()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            arrayList.add(linkedHashMap.values());
        }
        ArrayList arrayList2 = arrayList;
        String[][] strArr2 = new String[size][];
        for (int i2 = 0; i2 < size; i2++) {
            int size2 = ((Collection) arrayList2.get(i2)).size();
            String[] strArr3 = new String[size2];
            for (int i3 = 0; i3 < size2; i3++) {
                strArr3[i3] = ((AnyViewProp) CollectionsKt.elementAt((Iterable) arrayList2.get(i2), i3)).getName();
            }
            strArr2[i2] = strArr3;
        }
        ExpectedType[][] expectedTypeArr = new ExpectedType[size][];
        for (int i4 = 0; i4 < size; i4++) {
            int size3 = ((Collection) arrayList2.get(i4)).size();
            ExpectedType[] expectedTypeArr2 = new ExpectedType[size3];
            for (int i5 = 0; i5 < size3; i5++) {
                expectedTypeArr2[i5] = ((AnyViewProp) CollectionsKt.elementAt((Iterable) arrayList2.get(i4), i5)).getType().getCppRequiredTypes();
            }
            expectedTypeArr[i4] = expectedTypeArr2;
        }
        registerComponentsRegistry(strArr, strArr2, expectedTypeArr);
    }

    protected final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }

    static {
        SoLoader.loadLibrary("expo-modules-core");
    }
}
