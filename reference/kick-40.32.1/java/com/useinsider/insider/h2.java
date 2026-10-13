package com.useinsider.insider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class h2 implements j2 {
    private static final AtomicLong b = new AtomicLong(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f338a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static class a implements l2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f339a;
        private final m2 b;
        private final j2.a c;
        private final ExecutorService d;
        private volatile l2.a e = l2.a.READY;
        private volatile HttpsURLConnection f;

        public a(String str, m2 m2Var, j2.a aVar, ExecutorService executorService) {
            this.f339a = str;
            this.b = m2Var;
            this.c = aVar;
            this.d = executorService;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            try {
                try {
                    if (this.e != l2.a.CANCELLED) {
                        f3.b("http_url_connection_session", "HTTPS request is sending.", this.b.f(), "InsiderHTTPSURLConnectionSession-executeRequest");
                        this.f = (HttpsURLConnection) this.b.e().openConnection();
                        this.f.setRequestMethod(this.b.c());
                        for (Map.Entry entry : this.b.b().entrySet()) {
                            this.f.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                        this.f.setConnectTimeout(this.b.d());
                        this.f.setReadTimeout(this.b.d());
                        l2.a aVar = this.e;
                        l2.a aVar2 = l2.a.CANCELLED;
                        if (aVar == aVar2) {
                            f3.b("http_url_connection_session", "Request is canceled.", this.b.f(), "InsiderHTTPSURLConnectionSession-executeRequest");
                            this.f.disconnect();
                            if (this.f == null) {
                                return;
                            }
                        } else {
                            if (this.b.a() != null) {
                                this.f.setDoInput(true);
                                this.f.setDoOutput(true);
                                OutputStream outputStream = this.f.getOutputStream();
                                try {
                                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                                    bufferedWriter.write(this.b.a().toString());
                                    bufferedWriter.flush();
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                } catch (Throwable th) {
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (this.e == aVar2) {
                                f3.b("http_url_connection_session", "Request is canceled.", this.b.f(), "InsiderHTTPSURLConnectionSession-executeRequest");
                                this.f.disconnect();
                                if (this.f == null) {
                                    return;
                                }
                            } else {
                                int responseCode = this.f.getResponseCode();
                                n2 n2Var = new n2(responseCode, this.f.getHeaderFields());
                                boolean zA = g2.a(responseCode);
                                HttpsURLConnection httpsURLConnection = this.f;
                                InputStream inputStream = zA ? httpsURLConnection.getInputStream() : httpsURLConnection.getErrorStream();
                                String strA = inputStream != null ? a(inputStream) : null;
                                if (this.e != aVar2) {
                                    f3.b("http_url_connection_session", "Response is received successfully.", this.b.f(), "InsiderHTTPSURLConnectionSession-executeRequest");
                                    this.c.a(strA, n2Var, null);
                                }
                                if (this.f == null) {
                                    return;
                                }
                            }
                        }
                    } else if (this.f == null) {
                        return;
                    }
                    f3.b("http_url_connection_session", "Request connection terminated.", this.b.f(), "InsiderHTTPSURLConnectionSession-executeRequest");
                    this.f.disconnect();
                } catch (IOException e) {
                    if (this.e != l2.a.CANCELLED) {
                        f3.b("http_url_connection_session", "An error occurred while retrieving the response.", this.b.f(), "InsiderHTTPSURLConnectionSession-executeRequest");
                        this.c.a(null, null, e);
                    }
                    if (this.f != null) {
                        f3.b("http_url_connection_session", "Request connection terminated.", this.b.f(), "InsiderHTTPSURLConnectionSession-executeRequest");
                        this.f.disconnect();
                    }
                }
            } catch (Throwable th3) {
                if (this.f != null) {
                    f3.b("http_url_connection_session", "Request connection terminated.", this.b.f(), "InsiderHTTPSURLConnectionSession-executeRequest");
                    this.f.disconnect();
                }
                throw th3;
            }
        }

        @Override // com.useinsider.insider.l2
        public String a() {
            return this.f339a;
        }

        @Override // com.useinsider.insider.l2
        public void b() {
            if (this.e != l2.a.READY) {
                return;
            }
            this.e = l2.a.RUNNING;
            this.d.execute(new Runnable() { // from class: com.useinsider.insider.h2$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c();
                }
            });
        }

        private static String a(InputStream inputStream) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            String string = sb.toString();
                            bufferedReader.close();
                            return string;
                        }
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(line);
                        Insider.Instance.putException(e);
                        return null;
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                Insider.Instance.putException(e);
                return null;
            }
        }
    }

    h2(ExecutorService executorService) {
        this.f338a = executorService;
    }

    @Override // com.useinsider.insider.j2
    public l2 a(m2 m2Var, j2.a aVar) {
        return new a(System.currentTimeMillis() + "_" + b.incrementAndGet(), m2Var, aVar, this.f338a);
    }
}
