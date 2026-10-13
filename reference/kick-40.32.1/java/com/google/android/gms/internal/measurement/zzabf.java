package com.google.android.gms.internal.measurement;

import io.ktor.util.date.GMTDateParser;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.legacy.math.linearalgebra.Matrix;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzabf {
    TIME_HOUR_OF_DAY_PADDED('H'),
    TIME_HOUR_OF_DAY('k'),
    TIME_HOUR_12H_PADDED('I'),
    TIME_HOUR_12H('l'),
    TIME_MINUTE_OF_HOUR_PADDED(GMTDateParser.MONTH),
    TIME_SECONDS_OF_MINUTE_PADDED('S'),
    TIME_MILLIS_OF_SECOND_PADDED(Matrix.MATRIX_TYPE_RANDOM_LT),
    TIME_NANOS_OF_SECOND_PADDED('N'),
    TIME_AM_PM('p'),
    TIME_TZ_NUMERIC(GMTDateParser.ZONE),
    TIME_TZ_SHORT(Matrix.MATRIX_TYPE_ZERO),
    TIME_EPOCH_SECONDS(GMTDateParser.SECONDS),
    TIME_EPOCH_MILLIS('Q'),
    DATE_MONTH_FULL('B'),
    DATE_MONTH_SHORT('b'),
    DATE_MONTH_SHORT_ALT(GMTDateParser.HOURS),
    DATE_DAY_FULL('A'),
    DATE_DAY_SHORT('a'),
    DATE_CENTURY_PADDED('C'),
    DATE_YEAR_PADDED(GMTDateParser.YEAR),
    DATE_YEAR_OF_CENTURY_PADDED('y'),
    DATE_DAY_OF_YEAR_PADDED('j'),
    DATE_MONTH_PADDED(GMTDateParser.MINUTES),
    DATE_DAY_OF_MONTH_PADDED(GMTDateParser.DAY_OF_MONTH),
    DATE_DAY_OF_MONTH('e'),
    DATETIME_HOURS_MINUTES(Matrix.MATRIX_TYPE_RANDOM_REGULAR),
    DATETIME_HOURS_MINUTES_SECONDS('T'),
    DATETIME_HOURS_MINUTES_SECONDS_12H('r'),
    DATETIME_MONTH_DAY_YEAR('D'),
    DATETIME_YEAR_MONTH_DAY('F'),
    DATETIME_FULL('c');

    private static final Map zzF;
    private final char zzG;

    static {
        HashMap map = new HashMap();
        for (zzabf zzabfVar : values()) {
            if (map.put(Character.valueOf(zzabfVar.zzG), zzabfVar) != null) {
                String strValueOf = String.valueOf(zzabfVar);
                String.valueOf(strValueOf);
                throw new IllegalStateException("duplicate format character: ".concat(String.valueOf(strValueOf)));
            }
        }
        zzF = Collections.unmodifiableMap(map);
    }

    zzabf(char c) {
        this.zzG = c;
    }

    public static final zzabf zza(char c) {
        return (zzabf) zzF.get(Character.valueOf(c));
    }

    public final char zzb() {
        return this.zzG;
    }
}
