package com.datadog.trace.common.writer;

import com.datadog.trace.api.DDSpanId;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.core.DDSpan;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import io.ktor.sse.ServerSentEventKt;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes6.dex */
public class TraceStructureWriter implements Writer {
    private final boolean debugLog;
    private final boolean includeResource;
    private final boolean includeService;
    private final PrintStream out;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) TraceStructureWriter.class);
    private static final Pattern ARGS_DELIMITER = Pattern.compile(ServerSentEventKt.COLON, 16);

    @Override // com.datadog.trace.common.writer.Writer
    public void incrementDropCounts(int i) {
    }

    @Override // com.datadog.trace.common.writer.Writer
    public void start() {
    }

    public TraceStructureWriter() {
        this("", false);
    }

    public TraceStructureWriter(boolean z) {
        this("", z);
    }

    public TraceStructureWriter(String str) {
        this(str, false);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0076 A[Catch: IOException -> 0x0089, TRY_LEAVE, TryCatch #0 {IOException -> 0x0089, blocks: (B:10:0x001b, B:12:0x0027, B:14:0x0035, B:15:0x0039, B:17:0x003c, B:33:0x0076, B:24:0x0058, B:27:0x0062, B:30:0x006c, B:13:0x002a), top: B:40:0x001b }] */
    public TraceStructureWriter(String str, boolean z) {
        str = str == null ? "" : str;
        boolean z2 = false;
        if (!str.isEmpty() && str.charAt(0) == ':') {
            str = str.substring(1);
        }
        try {
            String[] args = parseArgs(str);
            String str2 = args[0];
            this.out = str2.isEmpty() ? System.out : new PrintStream(new FileOutputStream(str2));
            boolean z3 = false;
            for (int i = 1; i < args.length; i++) {
                String lowerCase = args[i].toLowerCase(Locale.ROOT);
                int iHashCode = lowerCase.hashCode();
                if (iHashCode != -321297139) {
                    if (iHashCode != 547817489) {
                        if (iHashCode == 1204416694 && lowerCase.equals("includeresource")) {
                            z2 = true;
                        } else {
                            log.warn("Illegal TraceStructureWriter argument '{}'", args[i]);
                        }
                    } else if (lowerCase.equals("debuglog")) {
                        z = true;
                    } else {
                        log.warn("Illegal TraceStructureWriter argument '{}'", args[i]);
                    }
                } else if (lowerCase.equals("includeservice")) {
                    z3 = true;
                } else {
                    log.warn("Illegal TraceStructureWriter argument '{}'", args[i]);
                }
            }
            this.debugLog = z;
            this.includeResource = z2;
            this.includeService = z3;
        } catch (IOException e) {
            throw new RuntimeException("Failed to create trace structure writer from " + str, e);
        }
    }

    private static String[] parseArgs(String str) {
        return ARGS_DELIMITER.split(str);
    }

    @Override // com.datadog.trace.common.writer.Writer
    public void write(List<DDSpan> list) {
        if (list.isEmpty()) {
            output(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, null, 0L);
            return;
        }
        DDTraceId traceId = list.get(0).getTraceId();
        long spanId = list.get(0).getSpanId();
        HashMap map = new HashMap();
        for (DDSpan dDSpan : list) {
            if (dDSpan.mo11181getLocalRootSpan() == dDSpan) {
                spanId = dDSpan.getSpanId();
            }
            map.put(Long.valueOf(dDSpan.getSpanId()), new Node(dDSpan, this.includeService, this.includeResource));
        }
        for (DDSpan dDSpan2 : list) {
            if (!traceId.equals(dDSpan2.getTraceId())) {
                String str = "Trace " + traceId + " has broken trace link at " + dDSpan2.getSpanId() + "(" + ((Object) dDSpan2.getOperationName()) + ")->" + dDSpan2.getTraceId();
                if (this.debugLog) {
                    log.error(str);
                    return;
                }
                return;
            }
            if (spanId != dDSpan2.getSpanId()) {
                Node node = (Node) map.get(Long.valueOf(dDSpan2.getParentId()));
                if (node == null) {
                    String str2 = "Trace " + traceId + " has broken parent link at " + dDSpan2.getSpanId() + "(" + ((Object) dDSpan2.getOperationName()) + ")->" + dDSpan2.getParentId();
                    if (this.debugLog) {
                        log.error(str2);
                    }
                    node = (Node) map.get(Long.valueOf(spanId));
                }
                node.addChild((Node) map.get(Long.valueOf(dDSpan2.getSpanId())));
            }
        }
        output(String.valueOf(map.get(Long.valueOf(spanId))), traceId, spanId);
    }

    private void output(String str, DDTraceId dDTraceId, long j) {
        this.out.println(str);
        if (this.debugLog) {
            Logger logger = log;
            if (logger.isDebugEnabled()) {
                StringBuilder sb = new StringBuilder();
                if (dDTraceId != null) {
                    sb.append("t_id=");
                    sb.append(dDTraceId);
                }
                if (j != 0) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append("s_id=");
                    sb.append(DDSpanId.toString(j));
                }
                if (sb.length() > 0) {
                    sb.append(" -> ");
                }
                logger.debug("{}wrote {}", sb, str);
            }
        }
    }

    @Override // com.datadog.trace.common.writer.Writer
    public boolean flush() {
        this.out.flush();
        return true;
    }

    @Override // com.datadog.trace.common.writer.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.out != System.out) {
            this.out.close();
        }
    }

    private static final class Node {
        private final List<Node> children;
        private final CharSequence operationName;
        private final CharSequence resourceName;
        private final CharSequence serviceName;

        private Node(DDSpan dDSpan, boolean z, boolean z2) {
            this.children = new ArrayList();
            this.operationName = dDSpan.getOperationName();
            this.resourceName = z2 ? dDSpan.getResourceName() : null;
            this.serviceName = z ? dDSpan.getServiceName() : null;
        }

        public void addChild(Node node) {
            this.children.add(node);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            CharSequence charSequence = this.serviceName;
            if (charSequence != null) {
                sb.append(charSequence);
                sb.append(AbstractJsonLexerKt.COLON);
            }
            sb.append(this.operationName);
            if (this.resourceName != null) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(this.resourceName);
            }
            Iterator<Node> it = this.children.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            sb.append(AbstractJsonLexerKt.END_LIST);
            return sb.toString();
        }
    }
}
