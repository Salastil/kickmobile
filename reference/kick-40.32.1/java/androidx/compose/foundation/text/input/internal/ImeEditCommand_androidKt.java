package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ImeEditCommand.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000\u001a8\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f\u0018\u00010\fH\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002\u001a$\u0010\u001b\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u001dH\u0001\u001a\u001c\u0010\u001e\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0001¨\u0006\u001f"}, d2 = {"commitText", "", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "text", "", "newCursorPosition", "", "setComposingRegion", ViewProps.START, ViewProps.END, "setComposingText", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "deleteSurroundingText", "lengthBeforeCursor", "lengthAfterCursor", "deleteSurroundingTextInCodePoints", "finishComposingText", "setSelection", "isSurrogatePair", "", "high", "", "low", "imeReplace", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "", "imeDelete", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ImeEditCommand_androidKt {
    public static final void commitText(ImeEditCommandScope imeEditCommandScope, final String str, final int i) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.commitText$lambda$0(str, i, (TextFieldBuffer) obj);
            }
        });
    }

    static final Unit commitText$lambda$0(String str, int i, TextFieldBuffer textFieldBuffer) {
        TextRange composition = textFieldBuffer.getComposition();
        if (composition != null) {
            imeReplace(textFieldBuffer, TextRange.m9598getStartimpl(composition.getPackedValue()), TextRange.m9593getEndimpl(composition.getPackedValue()), str);
        } else {
            imeReplace(textFieldBuffer, TextRange.m9598getStartimpl(textFieldBuffer.getSelectionInChars()), TextRange.m9593getEndimpl(textFieldBuffer.getSelectionInChars()), str);
        }
        int iM9598getStartimpl = TextRange.m9598getStartimpl(textFieldBuffer.getSelectionInChars());
        textFieldBuffer.m3017setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(i > 0 ? (iM9598getStartimpl + i) - 1 : (iM9598getStartimpl + i) - str.length(), 0, textFieldBuffer.getLength())));
        return Unit.INSTANCE;
    }

    public static final void setComposingRegion(final ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.setComposingRegion$lambda$0(i, i2, imeEditCommandScope, (TextFieldBuffer) obj);
            }
        });
    }

    static final Unit setComposingRegion$lambda$0(int i, int i2, ImeEditCommandScope imeEditCommandScope, TextFieldBuffer textFieldBuffer) {
        if (textFieldBuffer.hasComposition$foundation()) {
            textFieldBuffer.commitComposition$foundation();
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        long jMo3050mapFromTransformedGEjPoXI = imeEditCommandScope.mo3050mapFromTransformedGEjPoXI(TextRangeKt.TextRange(i, i2));
        int iCoerceIn = RangesKt.coerceIn(TextRange.m9596getMinimpl(jMo3050mapFromTransformedGEjPoXI), 0, textFieldBuffer.getLength());
        int iCoerceIn2 = RangesKt.coerceIn(TextRange.m9595getMaximpl(jMo3050mapFromTransformedGEjPoXI), 0, textFieldBuffer.getLength());
        if (iCoerceIn != iCoerceIn2) {
            if (iCoerceIn < iCoerceIn2) {
                TextFieldBuffer.setComposition$foundation$default(textFieldBuffer, iCoerceIn, iCoerceIn2, null, 4, null);
            } else {
                TextFieldBuffer.setComposition$foundation$default(textFieldBuffer, iCoerceIn2, iCoerceIn, null, 4, null);
            }
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void setComposingText$default(ImeEditCommandScope imeEditCommandScope, String str, int i, List list, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            list = null;
        }
        setComposingText(imeEditCommandScope, str, i, list);
    }

    public static final void setComposingText(ImeEditCommandScope imeEditCommandScope, final String str, final int i, final List<AnnotatedString.Range<AnnotatedString.Annotation>> list) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.setComposingText$lambda$0(str, list, i, (TextFieldBuffer) obj);
            }
        });
    }

    static final Unit setComposingText$lambda$0(String str, List list, int i, TextFieldBuffer textFieldBuffer) {
        TextRange composition = textFieldBuffer.getComposition();
        if (composition != null) {
            String str2 = str;
            imeReplace(textFieldBuffer, TextRange.m9598getStartimpl(composition.getPackedValue()), TextRange.m9593getEndimpl(composition.getPackedValue()), str2);
            if (str2.length() > 0) {
                textFieldBuffer.setComposition$foundation(TextRange.m9598getStartimpl(composition.getPackedValue()), TextRange.m9598getStartimpl(composition.getPackedValue()) + str.length(), list);
            }
        } else {
            int iM9598getStartimpl = TextRange.m9598getStartimpl(textFieldBuffer.getSelectionInChars());
            String str3 = str;
            imeReplace(textFieldBuffer, iM9598getStartimpl, TextRange.m9593getEndimpl(textFieldBuffer.getSelectionInChars()), str3);
            if (str3.length() > 0) {
                textFieldBuffer.setComposition$foundation(iM9598getStartimpl, str.length() + iM9598getStartimpl, list);
            }
        }
        int iM9598getStartimpl2 = TextRange.m9598getStartimpl(textFieldBuffer.getSelectionInChars());
        textFieldBuffer.m3017setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(i > 0 ? (iM9598getStartimpl2 + i) - 1 : (iM9598getStartimpl2 + i) - str.length(), 0, textFieldBuffer.getLength())));
        return Unit.INSTANCE;
    }

    public static final void deleteSurroundingText(final ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.deleteSurroundingText$lambda$0(i, i2, imeEditCommandScope, (TextFieldBuffer) obj);
            }
        });
    }

    static final Unit deleteSurroundingText$lambda$0(int i, int i2, ImeEditCommandScope imeEditCommandScope, TextFieldBuffer textFieldBuffer) {
        if (!(i >= 0 && i2 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.");
        }
        long jMo3051mapToTransformedGEjPoXI = imeEditCommandScope.mo3051mapToTransformedGEjPoXI(textFieldBuffer.getSelectionInChars());
        int iM9593getEndimpl = TextRange.m9593getEndimpl(jMo3051mapToTransformedGEjPoXI);
        int transformedLength = iM9593getEndimpl + i2;
        if (((i2 ^ transformedLength) & (iM9593getEndimpl ^ transformedLength)) < 0) {
            transformedLength = imeEditCommandScope.getTransformedLength();
        }
        long jMo3050mapFromTransformedGEjPoXI = imeEditCommandScope.mo3050mapFromTransformedGEjPoXI(TextRangeKt.TextRange(TextRange.m9593getEndimpl(jMo3051mapToTransformedGEjPoXI), Math.min(transformedLength, imeEditCommandScope.getTransformedLength())));
        imeDelete(textFieldBuffer, TextRange.m9596getMinimpl(jMo3050mapFromTransformedGEjPoXI), TextRange.m9595getMaximpl(jMo3050mapFromTransformedGEjPoXI));
        int iM9598getStartimpl = TextRange.m9598getStartimpl(jMo3051mapToTransformedGEjPoXI);
        int i3 = iM9598getStartimpl - i;
        if (((i ^ iM9598getStartimpl) & (iM9598getStartimpl ^ i3)) < 0) {
            i3 = 0;
        }
        long jMo3050mapFromTransformedGEjPoXI2 = imeEditCommandScope.mo3050mapFromTransformedGEjPoXI(TextRangeKt.TextRange(Math.max(0, i3), TextRange.m9598getStartimpl(jMo3051mapToTransformedGEjPoXI)));
        imeDelete(textFieldBuffer, TextRange.m9596getMinimpl(jMo3050mapFromTransformedGEjPoXI2), TextRange.m9595getMaximpl(jMo3050mapFromTransformedGEjPoXI2));
        return Unit.INSTANCE;
    }

    public static final void deleteSurroundingTextInCodePoints(ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.deleteSurroundingTextInCodePoints$lambda$0(i, i2, (TextFieldBuffer) obj);
            }
        });
    }

    static final Unit deleteSurroundingTextInCodePoints$lambda$0(int i, int i2, TextFieldBuffer textFieldBuffer) {
        if (!(i >= 0 && i2 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.");
        }
        int iM9598getStartimpl = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iM9598getStartimpl + 1;
            if (TextRange.m9598getStartimpl(textFieldBuffer.getSelectionInChars()) > i4) {
                iM9598getStartimpl = isSurrogatePair(textFieldBuffer.asCharSequence().charAt((TextRange.m9598getStartimpl(textFieldBuffer.getSelectionInChars()) - i4) - 1), textFieldBuffer.asCharSequence().charAt(TextRange.m9598getStartimpl(textFieldBuffer.getSelectionInChars()) - i4)) ? iM9598getStartimpl + 2 : i4;
            } else {
                iM9598getStartimpl = TextRange.m9598getStartimpl(textFieldBuffer.getSelectionInChars());
                break;
            }
        }
        int length = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = length + 1;
            if (TextRange.m9593getEndimpl(textFieldBuffer.getSelectionInChars()) + i6 < textFieldBuffer.getLength()) {
                length = isSurrogatePair(textFieldBuffer.asCharSequence().charAt((TextRange.m9593getEndimpl(textFieldBuffer.getSelectionInChars()) + i6) - 1), textFieldBuffer.asCharSequence().charAt(TextRange.m9593getEndimpl(textFieldBuffer.getSelectionInChars()) + i6)) ? length + 2 : i6;
            } else {
                length = textFieldBuffer.getLength() - TextRange.m9593getEndimpl(textFieldBuffer.getSelectionInChars());
                break;
            }
        }
        imeDelete(textFieldBuffer, TextRange.m9593getEndimpl(textFieldBuffer.getSelectionInChars()), TextRange.m9593getEndimpl(textFieldBuffer.getSelectionInChars()) + length);
        imeDelete(textFieldBuffer, TextRange.m9598getStartimpl(textFieldBuffer.getSelectionInChars()) - iM9598getStartimpl, TextRange.m9598getStartimpl(textFieldBuffer.getSelectionInChars()));
        return Unit.INSTANCE;
    }

    public static final void finishComposingText(ImeEditCommandScope imeEditCommandScope) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.finishComposingText$lambda$0((TextFieldBuffer) obj);
            }
        });
    }

    static final Unit finishComposingText$lambda$0(TextFieldBuffer textFieldBuffer) {
        textFieldBuffer.commitComposition$foundation();
        return Unit.INSTANCE;
    }

    public static final void setSelection(final ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.setSelection$lambda$0(imeEditCommandScope, i, i2, (TextFieldBuffer) obj);
            }
        });
    }

    static final Unit setSelection$lambda$0(ImeEditCommandScope imeEditCommandScope, int i, int i2, TextFieldBuffer textFieldBuffer) {
        long jMo3051mapToTransformedGEjPoXI = imeEditCommandScope.mo3051mapToTransformedGEjPoXI(TextRangeKt.TextRange(0, textFieldBuffer.getLength()));
        int iM9596getMinimpl = TextRange.m9596getMinimpl(jMo3051mapToTransformedGEjPoXI);
        int iM9595getMaximpl = TextRange.m9595getMaximpl(jMo3051mapToTransformedGEjPoXI);
        if (i < iM9596getMinimpl) {
            i = iM9596getMinimpl;
        }
        if (i <= iM9595getMaximpl) {
            iM9595getMaximpl = i;
        }
        int iM9596getMinimpl2 = TextRange.m9596getMinimpl(jMo3051mapToTransformedGEjPoXI);
        int iM9595getMaximpl2 = TextRange.m9595getMaximpl(jMo3051mapToTransformedGEjPoXI);
        if (i2 < iM9596getMinimpl2) {
            i2 = iM9596getMinimpl2;
        }
        if (i2 <= iM9595getMaximpl2) {
            iM9595getMaximpl2 = i2;
        }
        textFieldBuffer.m3017setSelection5zctL8(imeEditCommandScope.mo3050mapFromTransformedGEjPoXI(TextRangeKt.TextRange(iM9595getMaximpl, iM9595getMaximpl2)));
        return Unit.INSTANCE;
    }

    private static final boolean isSurrogatePair(char c, char c2) {
        return Character.isHighSurrogate(c) && Character.isLowSurrogate(c2);
    }

    public static final void imeReplace(TextFieldBuffer textFieldBuffer, int i, int i2, CharSequence charSequence) {
        int iMin = Math.min(i, i2);
        int iMax = Math.max(i, i2);
        int i3 = 0;
        int i4 = iMin;
        while (i4 < iMax && i3 < charSequence.length() && charSequence.charAt(i3) == textFieldBuffer.asCharSequence().charAt(i4)) {
            i3++;
            i4++;
        }
        int length = charSequence.length();
        while (iMax > i4 && length > i3 && charSequence.charAt(length - 1) == textFieldBuffer.asCharSequence().charAt(iMax - 1)) {
            length--;
            iMax--;
        }
        if (i4 != iMax || i3 != length) {
            textFieldBuffer.replace(i4, iMax, charSequence.subSequence(i3, length));
        } else {
            textFieldBuffer.commitComposition$foundation();
            textFieldBuffer.clearHighlight$foundation();
        }
        textFieldBuffer.m3017setSelection5zctL8(TextRangeKt.TextRange(iMin + charSequence.length()));
    }

    public static final void imeDelete(TextFieldBuffer textFieldBuffer, int i, int i2) {
        TextRange composition = textFieldBuffer.getComposition();
        int iMin = Math.min(i, i2);
        int iMax = Math.max(i, i2);
        TextFieldBufferKt.delete(textFieldBuffer, iMin, iMax);
        if (composition != null) {
            composition.getPackedValue();
            long jM3021adjustTextRangevJH6DeI = TextFieldBufferKt.m3021adjustTextRangevJH6DeI(composition.getPackedValue(), iMin, iMax, 0);
            if (TextRange.m9592getCollapsedimpl(jM3021adjustTextRangevJH6DeI)) {
                textFieldBuffer.commitComposition$foundation();
            } else {
                TextFieldBuffer.setComposition$foundation$default(textFieldBuffer, TextRange.m9596getMinimpl(jM3021adjustTextRangevJH6DeI), TextRange.m9595getMaximpl(jM3021adjustTextRangevJH6DeI), null, 4, null);
            }
        }
    }
}
