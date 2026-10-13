package io.github.centrifugal.centrifuge;

import io.github.centrifugal.centrifuge.internal.protocol.Protocol;
import java.util.Arrays;

/* JADX INFO: loaded from: classes9.dex */
public final class FilterNodeBuilder {
    private FilterNodeBuilder() {
    }

    private static FilterNode leaf(String str, String str2, String str3) {
        Protocol.FilterNode.Builder cmp = Protocol.FilterNode.newBuilder().setKey(str).setCmp(str2);
        if (str3 != null) {
            cmp.setVal(str3);
        }
        return new FilterNode(cmp.build());
    }

    private static FilterNode set(String str, String str2, String[] strArr) {
        Protocol.FilterNode.Builder cmp = Protocol.FilterNode.newBuilder().setKey(str).setCmp(str2);
        cmp.addAllVals(Arrays.asList(strArr));
        return new FilterNode(cmp.build());
    }

    private static FilterNode logical(String str, FilterNode[] filterNodeArr) {
        Protocol.FilterNode.Builder op = Protocol.FilterNode.newBuilder().setOp(str);
        for (FilterNode filterNode : filterNodeArr) {
            op.addNodes(filterNode.getProtoNode());
        }
        return new FilterNode(op.build());
    }

    public static FilterNode eq(String str, String str2) {
        return leaf(str, "eq", str2);
    }

    public static FilterNode neq(String str, String str2) {
        return leaf(str, "neq", str2);
    }

    public static FilterNode in(String str, String... strArr) {
        return set(str, "in", strArr);
    }

    public static FilterNode nin(String str, String... strArr) {
        return set(str, "nin", strArr);
    }

    public static FilterNode exists(String str) {
        return leaf(str, "ex", null);
    }

    public static FilterNode notExists(String str) {
        return leaf(str, "nex", null);
    }

    public static FilterNode startsWith(String str, String str2) {
        return leaf(str, "sw", str2);
    }

    public static FilterNode endsWith(String str, String str2) {
        return leaf(str, "ew", str2);
    }

    public static FilterNode contains(String str, String str2) {
        return leaf(str, "ct", str2);
    }

    public static FilterNode gt(String str, String str2) {
        return leaf(str, "gt", str2);
    }

    public static FilterNode gte(String str, String str2) {
        return leaf(str, "gte", str2);
    }

    public static FilterNode lt(String str, String str2) {
        return leaf(str, "lt", str2);
    }

    public static FilterNode lte(String str, String str2) {
        return leaf(str, "lte", str2);
    }

    public static FilterNode and(FilterNode... filterNodeArr) {
        return logical("and", filterNodeArr);
    }

    public static FilterNode or(FilterNode... filterNodeArr) {
        return logical("or", filterNodeArr);
    }

    public static FilterNode not(FilterNode filterNode) {
        return logical("not", new FilterNode[]{filterNode});
    }
}
