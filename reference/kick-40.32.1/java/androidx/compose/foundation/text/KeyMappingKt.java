package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeyMapping.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"commonKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "systemShortcutModifiers", "Landroidx/compose/foundation/text/KeyModifiers;", "commonKeyMapping-VSD1kLU", "(I)Landroidx/compose/foundation/text/KeyMapping;", "defaultKeyMapping", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    /* JADX INFO: renamed from: commonKeyMapping-VSD1kLU, reason: not valid java name */
    public static final KeyMapping m2841commonKeyMappingVSD1kLU(final int i) {
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo2840mapZmokQxo(KeyEvent event) {
                int iM2885getModifiersZmokQxo = KeyModifiersKt.m2885getModifiersZmokQxo(event);
                if (KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo, KeyModifiers.m2860plus1uj4btU(i, KeyModifiers.INSTANCE.m2883getShiftAuQ4EfA()))) {
                    if (Key.m8187equalsimpl0(KeyEvent_androidKt.m8507getKeyZmokQxo(event), Key.INSTANCE.m8485getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo, i)) {
                    long jM8507getKeyZmokQxo = KeyEvent_androidKt.m8507getKeyZmokQxo(event);
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo, Key.INSTANCE.m8242getCEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo, Key.INSTANCE.m8306getInsertEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo, Key.INSTANCE.m8373getNumPadInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo, Key.INSTANCE.m8474getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo, Key.INSTANCE.m8482getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo, Key.INSTANCE.m8192getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo, Key.INSTANCE.m8483getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo, Key.INSTANCE.m8485getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo, KeyModifiers.INSTANCE.m2883getShiftAuQ4EfA())) {
                    long jM8507getKeyZmokQxo2 = KeyEvent_androidKt.m8507getKeyZmokQxo(event);
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8264getDirectionLeftEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8366getNumPadDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8265getDirectionRightEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8367getNumPadDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8266getDirectionUpEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8368getNumPadDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8261getDirectionDownEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8365getNumPadDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8387getPageUpEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8379getNumPadPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8386getPageDownEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8378getNumPadPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8340getMoveHomeEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8376getNumPadMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8339getMoveEndEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8375getNumPadMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8306getInsertEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8373getNumPadInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                if (!KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo, KeyModifiers.INSTANCE.m2882getNoneAuQ4EfA())) {
                    return null;
                }
                long jM8507getKeyZmokQxo3 = KeyEvent_androidKt.m8507getKeyZmokQxo(event);
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8264getDirectionLeftEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8366getNumPadDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8265getDirectionRightEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8367getNumPadDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8266getDirectionUpEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8368getNumPadDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8261getDirectionDownEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8365getNumPadDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8260getDirectionCenterEK5gGoQ())) {
                    return KeyCommand.CENTER;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8387getPageUpEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8379getNumPadPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8386getPageDownEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8378getNumPadPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8340getMoveHomeEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8376getNumPadMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8339getMoveEndEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8375getNumPadMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8274getEnterEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8371getNumPadEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8205getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8259getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8389getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8257getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8254getCopyEK5gGoQ())) {
                    return KeyCommand.COPY;
                }
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8435getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }

    static {
        final KeyMapping keyMappingM2841commonKeyMappingVSD1kLU = m2841commonKeyMappingVSD1kLU(KeyModifiers.INSTANCE.m2877getCtrlAuQ4EfA());
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1$1
            /* JADX WARN: Code duplicated, block: B:22:0x0071  */
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo2840mapZmokQxo(KeyEvent event) {
                KeyCommand keyCommand;
                int iM2885getModifiersZmokQxo = KeyModifiersKt.m2885getModifiersZmokQxo(event);
                long jM8507getKeyZmokQxo = KeyEvent_androidKt.m8507getKeyZmokQxo(event);
                KeyCommand keyCommand2 = null;
                if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo, Key.INSTANCE.m8205getBackspaceEK5gGoQ())) {
                    if (KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo, KeyModifiers.INSTANCE.m2882getNoneAuQ4EfA()) || KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo, KeyModifiers.INSTANCE.m2883getShiftAuQ4EfA()) || KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo, KeyModifiers.INSTANCE.m2884getShiftMetaAuQ4EfA())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo, KeyModifiers.INSTANCE.m2877getCtrlAuQ4EfA()) || KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo, KeyModifiers.INSTANCE.m2880getCtrlShiftAuQ4EfA())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else {
                        keyCommand = null;
                    }
                } else if ((Key.m8187equalsimpl0(jM8507getKeyZmokQxo, Key.INSTANCE.m8274getEnterEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo, Key.INSTANCE.m8371getNumPadEnterEK5gGoQ())) && (KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo, KeyModifiers.INSTANCE.m2882getNoneAuQ4EfA()) || KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo, KeyModifiers.INSTANCE.m2883getShiftAuQ4EfA()) || KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo, KeyModifiers.INSTANCE.m2877getCtrlAuQ4EfA()) || KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo, KeyModifiers.INSTANCE.m2880getCtrlShiftAuQ4EfA()))) {
                    keyCommand = KeyCommand.NEW_LINE;
                } else {
                    keyCommand = null;
                }
                if (keyCommand != null) {
                    return keyCommand;
                }
                int iM2885getModifiersZmokQxo2 = KeyModifiersKt.m2885getModifiersZmokQxo(event);
                if (KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo2, KeyModifiers.INSTANCE.m2880getCtrlShiftAuQ4EfA())) {
                    long jM8507getKeyZmokQxo2 = KeyEvent_androidKt.m8507getKeyZmokQxo(event);
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8264getDirectionLeftEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8366getNumPadDirectionLeftEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8265getDirectionRightEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8367getNumPadDirectionRightEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8266getDirectionUpEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8368getNumPadDirectionUpEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8261getDirectionDownEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo2, Key.INSTANCE.m8365getNumPadDirectionDownEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo2, KeyModifiers.INSTANCE.m2877getCtrlAuQ4EfA())) {
                    long jM8507getKeyZmokQxo3 = KeyEvent_androidKt.m8507getKeyZmokQxo(event);
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8264getDirectionLeftEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8366getNumPadDirectionLeftEK5gGoQ())) {
                        keyCommand2 = KeyCommand.LEFT_WORD;
                    } else if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8265getDirectionRightEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8367getNumPadDirectionRightEK5gGoQ())) {
                        keyCommand2 = KeyCommand.RIGHT_WORD;
                    } else if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8266getDirectionUpEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8368getNumPadDirectionUpEK5gGoQ())) {
                        keyCommand2 = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8261getDirectionDownEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8365getNumPadDirectionDownEK5gGoQ())) {
                        keyCommand2 = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8299getHEK5gGoQ())) {
                        keyCommand2 = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8259getDeleteEK5gGoQ())) {
                        keyCommand2 = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo3, Key.INSTANCE.m8204getBackslashEK5gGoQ())) {
                        keyCommand2 = KeyCommand.DESELECT;
                    }
                } else if (KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo2, KeyModifiers.INSTANCE.m2883getShiftAuQ4EfA())) {
                    long jM8507getKeyZmokQxo4 = KeyEvent_androidKt.m8507getKeyZmokQxo(event);
                    if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo4, Key.INSTANCE.m8340getMoveHomeEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo4, Key.INSTANCE.m8376getNumPadMoveHomeEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_LINE_START;
                    } else if (Key.m8187equalsimpl0(jM8507getKeyZmokQxo4, Key.INSTANCE.m8339getMoveEndEK5gGoQ()) || Key.m8187equalsimpl0(jM8507getKeyZmokQxo4, Key.INSTANCE.m8375getNumPadMoveEndEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_LINE_END;
                    }
                } else if (KeyModifiers.m2847equalsimpl0(iM2885getModifiersZmokQxo2, KeyModifiers.INSTANCE.m2874getAltAuQ4EfA()) && Key.m8187equalsimpl0(KeyEvent_androidKt.m8507getKeyZmokQxo(event), Key.INSTANCE.m8259getDeleteEK5gGoQ())) {
                    keyCommand2 = KeyCommand.DELETE_TO_LINE_END;
                }
                return keyCommand2 == null ? keyMappingM2841commonKeyMappingVSD1kLU.mo2840mapZmokQxo(event) : keyCommand2;
            }
        };
    }
}
