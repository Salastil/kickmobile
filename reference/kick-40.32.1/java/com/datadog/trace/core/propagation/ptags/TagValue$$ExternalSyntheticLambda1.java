package com.datadog.trace.core.propagation.ptags;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class TagValue$$ExternalSyntheticLambda1 implements TagValue.CharConverter {
    @Override // com.datadog.trace.core.propagation.ptags.TagValue.CharConverter
    public final char convert(char c) {
        return TagValue.convertDDtoW3C(c);
    }
}
