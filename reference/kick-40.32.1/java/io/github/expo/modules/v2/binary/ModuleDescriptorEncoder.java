package io.github.expo.modules.v2.binary;

import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.modules.ModuleEventDefinition;
import io.github.expo.modules.v2.modules.ModuleFunctionDefinition;
import io.github.expo.modules.v2.modules.ModulePropertyDefinition;
import io.github.expo.modules.v2.modules.ModuleSharedClassDefinition;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModuleDescriptorEncoder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t¢\u0006\u0004\b\u0011\u0010\u0012JK\u0010\u0013\u001a\u00020\u0005*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J!\u0010\u0015\u001a\u00020\u0016*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u0016*\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH\u0002¢\u0006\u0004\b\u001a\u0010\u0018J!\u0010\u001b\u001a\u00020\u0016*\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0002¢\u0006\u0004\b\u001c\u0010\u0018J!\u0010\u001d\u001a\u00020\u0016*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0002¢\u0006\u0004\b\u001e\u0010\u0018¨\u0006\u001f"}, d2 = {"Lio/github/expo/modules/v2/binary/ModuleDescriptorEncoder;", "", "<init>", "()V", "encode", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "functions", "", "Lio/github/expo/modules/v2/modules/ModuleFunctionDefinition;", "properties", "Lio/github/expo/modules/v2/modules/ModulePropertyDefinition;", "sharedClasses", "Lio/github/expo/modules/v2/modules/ModuleSharedClassDefinition;", "events", "Lio/github/expo/modules/v2/modules/ModuleEventDefinition;", "encode-18NA9x0", "(Ljava/nio/ByteBuffer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)I", "writeDescriptor", "writeDescriptor-18NA9x0", "writeFunctions", "", "writeFunctions-uOnPpUM", "(Ljava/nio/ByteBuffer;Ljava/util/List;)V", "writeSharedClasses", "writeSharedClasses-uOnPpUM", "writeEvents", "writeEvents-uOnPpUM", "writeProperties", "writeProperties-uOnPpUM", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ModuleDescriptorEncoder {
    public static final ModuleDescriptorEncoder INSTANCE = new ModuleDescriptorEncoder();

    private ModuleDescriptorEncoder() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: encode-18NA9x0$default, reason: not valid java name */
    public static /* synthetic */ int m12324encode18NA9x0$default(ModuleDescriptorEncoder moduleDescriptorEncoder, ByteBuffer byteBuffer, List list, List list2, List list3, List list4, int i, Object obj) {
        if ((i & 8) != 0) {
            list3 = CollectionsKt.emptyList();
        }
        List list5 = list3;
        if ((i & 16) != 0) {
            list4 = CollectionsKt.emptyList();
        }
        return moduleDescriptorEncoder.m12330encode18NA9x0(byteBuffer, list, list2, list5, list4);
    }

    /* JADX INFO: renamed from: encode-18NA9x0, reason: not valid java name */
    public final int m12330encode18NA9x0(ByteBuffer buf, List<ModuleFunctionDefinition> functions, List<ModulePropertyDefinition> properties, List<ModuleSharedClassDefinition> sharedClasses, List<ModuleEventDefinition> events) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        Intrinsics.checkNotNullParameter(functions, "functions");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(sharedClasses, "sharedClasses");
        Intrinsics.checkNotNullParameter(events, "events");
        return m12325writeDescriptor18NA9x0(buf, functions, properties, sharedClasses, events);
    }

    /* JADX INFO: renamed from: writeDescriptor-18NA9x0, reason: not valid java name */
    private final int m12325writeDescriptor18NA9x0(ByteBuffer byteBuffer, List<ModuleFunctionDefinition> list, List<ModulePropertyDefinition> list2, List<ModuleSharedClassDefinition> list3, List<ModuleEventDefinition> list4) {
        int iM12269getPositionimpl = BinaryBuffer.m12269getPositionimpl(byteBuffer);
        BinaryBuffer.m12285putIntWPjWIpM(byteBuffer, 0);
        m12327writeFunctionsuOnPpUM(byteBuffer, list);
        m12328writePropertiesuOnPpUM(byteBuffer, list2);
        m12329writeSharedClassesuOnPpUM(byteBuffer, list3);
        m12326writeEventsuOnPpUM(byteBuffer, list4);
        int iM12269getPositionimpl2 = BinaryBuffer.m12269getPositionimpl(byteBuffer);
        BinaryBuffer.m12305setPositionimpl(byteBuffer, iM12269getPositionimpl);
        BinaryBuffer.m12285putIntWPjWIpM(byteBuffer, iM12269getPositionimpl2);
        return iM12269getPositionimpl2;
    }

    /* JADX INFO: renamed from: writeFunctions-uOnPpUM, reason: not valid java name */
    private final void m12327writeFunctionsuOnPpUM(ByteBuffer byteBuffer, List<ModuleFunctionDefinition> list) {
        BinaryBuffer.m12285putIntWPjWIpM(byteBuffer, list.size());
        for (ModuleFunctionDefinition moduleFunctionDefinition : list) {
            BinaryBuffer.m12293putStringWPjWIpM(byteBuffer, moduleFunctionDefinition.getJsName());
            BinaryBuffer.m12293putStringWPjWIpM(byteBuffer, moduleFunctionDefinition.getMethodName());
            BinaryBuffer.m12285putIntWPjWIpM(byteBuffer, moduleFunctionDefinition.getFlags());
            BinaryBuffer.m12285putIntWPjWIpM(byteBuffer, moduleFunctionDefinition.getArgTypes().length);
            for (int[] iArr : moduleFunctionDefinition.getArgTypes()) {
                BinaryBuffer.m12286putIntArrayWPjWIpM(byteBuffer, iArr);
            }
            BinaryBuffer.m12286putIntArrayWPjWIpM(byteBuffer, moduleFunctionDefinition.getReturnType());
        }
    }

    /* JADX INFO: renamed from: writeSharedClasses-uOnPpUM, reason: not valid java name */
    private final void m12329writeSharedClassesuOnPpUM(ByteBuffer byteBuffer, List<ModuleSharedClassDefinition> list) {
        BinaryBuffer.m12285putIntWPjWIpM(byteBuffer, list.size());
        for (ModuleSharedClassDefinition moduleSharedClassDefinition : list) {
            BinaryBuffer.m12293putStringWPjWIpM(byteBuffer, moduleSharedClassDefinition.getJsName());
            BinaryBuffer.m12285putIntWPjWIpM(byteBuffer, moduleSharedClassDefinition.getClassId());
            BinaryBuffer.m12293putStringWPjWIpM(byteBuffer, moduleSharedClassDefinition.getTrampolineName());
            BinaryBuffer.m12285putIntWPjWIpM(byteBuffer, moduleSharedClassDefinition.getArgTypes().length);
            for (int[] iArr : moduleSharedClassDefinition.getArgTypes()) {
                BinaryBuffer.m12286putIntArrayWPjWIpM(byteBuffer, iArr);
            }
        }
    }

    /* JADX INFO: renamed from: writeEvents-uOnPpUM, reason: not valid java name */
    private final void m12326writeEventsuOnPpUM(ByteBuffer byteBuffer, List<ModuleEventDefinition> list) {
        BinaryBuffer.m12285putIntWPjWIpM(byteBuffer, list.size());
        for (ModuleEventDefinition moduleEventDefinition : list) {
            BinaryBuffer.m12293putStringWPjWIpM(byteBuffer, moduleEventDefinition.getJsName());
            BinaryBuffer.m12286putIntArrayWPjWIpM(byteBuffer, moduleEventDefinition.getPayloadType());
        }
    }

    /* JADX INFO: renamed from: writeProperties-uOnPpUM, reason: not valid java name */
    private final void m12328writePropertiesuOnPpUM(ByteBuffer byteBuffer, List<ModulePropertyDefinition> list) {
        BinaryBuffer.m12285putIntWPjWIpM(byteBuffer, list.size());
        for (ModulePropertyDefinition modulePropertyDefinition : list) {
            BinaryBuffer.m12293putStringWPjWIpM(byteBuffer, modulePropertyDefinition.getJsName());
            BinaryBuffer.m12293putStringWPjWIpM(byteBuffer, modulePropertyDefinition.getGetterName());
            BinaryBuffer.m12285putIntWPjWIpM(byteBuffer, modulePropertyDefinition.getFlags());
            BinaryBuffer.m12286putIntArrayWPjWIpM(byteBuffer, modulePropertyDefinition.getGetterType());
            BinaryBuffer.m12274putBooleanWPjWIpM(byteBuffer, modulePropertyDefinition.getSetterName() != null);
            String setterName = modulePropertyDefinition.getSetterName();
            if (setterName != null) {
                BinaryBuffer.m12293putStringWPjWIpM(byteBuffer, setterName);
                int[] setterType = modulePropertyDefinition.getSetterType();
                if (setterType == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                BinaryBuffer.m12286putIntArrayWPjWIpM(byteBuffer, setterType);
            }
        }
    }
}
