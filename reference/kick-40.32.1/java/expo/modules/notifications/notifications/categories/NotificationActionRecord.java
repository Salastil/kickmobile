package expo.modules.notifications.notifications.categories;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.records.Required;
import expo.modules.kotlin.types.OptimizedRecord;
import expo.modules.notifications.service.NotificationsService;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PEmptyArrays;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoNotificationCategoriesModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lexpo/modules/notifications/notifications/categories/NotificationActionRecord;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "<init>", "()V", NotificationsService.IDENTIFIER_KEY, "", "getIdentifier$annotations", "getIdentifier", "()Ljava/lang/String;", "buttonTitle", "getButtonTitle$annotations", "getButtonTitle", "textInput", "Lexpo/modules/notifications/notifications/categories/NotificationActionRecord$TextInput;", "getTextInput$annotations", "getTextInput", "()Lexpo/modules/notifications/notifications/categories/NotificationActionRecord$TextInput;", "options", "Lexpo/modules/notifications/notifications/categories/NotificationActionRecord$Options;", "getOptions$annotations", "getOptions", "()Lexpo/modules/notifications/notifications/categories/NotificationActionRecord$Options;", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "TextInput", "Options", "__Pika", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotificationActionRecord implements Record, PIntrospectionProvider {
    public TextInput textInput;
    public String identifier = "";
    public String buttonTitle = "";
    public Options options = new Options();

    /* JADX INFO: compiled from: ExpoNotificationCategoriesModule.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/notifications/notifications/categories/NotificationActionRecord$__Pika;", "", "<init>", "()V", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<NotificationActionRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(NotificationActionRecord.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty(NotificationsService.IDENTIFIER_KEY, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap()), new PAnnotation(Required.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 0, __pika, false, true, false), new PProperty("buttonTitle", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap()), new PAnnotation(Required.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 1, __pika, false, true, false), new PProperty("textInput", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(TextInput.class, true, TextInput.__Pika.__pika$IntrospectionData), 2, __pika, false, true, false), new PProperty("options", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Options.class, false, Options.__Pika.__pika$IntrospectionData), 3, __pika, false, true, false)}, PEmptyArrays.EMPTY_FUNCTIONS, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.categories.NotificationActionRecord");
                return ((NotificationActionRecord) obj).getIdentifier();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.categories.NotificationActionRecord");
                return ((NotificationActionRecord) obj).getButtonTitle();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.categories.NotificationActionRecord");
                return ((NotificationActionRecord) obj).getTextInput();
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.categories.NotificationActionRecord");
            return ((NotificationActionRecord) obj).getOptions();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.categories.NotificationActionRecord");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((NotificationActionRecord) obj).identifier = (String) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.categories.NotificationActionRecord");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((NotificationActionRecord) obj).buttonTitle = (String) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.categories.NotificationActionRecord");
                ((NotificationActionRecord) obj).textInput = (TextInput) obj2;
            } else {
                if (i != 3) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.categories.NotificationActionRecord");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.notifications.notifications.categories.NotificationActionRecord.Options");
                ((NotificationActionRecord) obj).options = (Options) obj2;
            }
        }
    }

    @Field
    @Required
    public static /* synthetic */ void getButtonTitle$annotations() {
    }

    @Field
    @Required
    public static /* synthetic */ void getIdentifier$annotations() {
    }

    @Field
    public static /* synthetic */ void getOptions$annotations() {
    }

    @Field
    public static /* synthetic */ void getTextInput$annotations() {
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    public final TextInput getTextInput() {
        return this.textInput;
    }

    public final Options getOptions() {
        return this.options;
    }

    /* JADX INFO: compiled from: ExpoNotificationCategoriesModule.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lexpo/modules/notifications/notifications/categories/NotificationActionRecord$TextInput;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "<init>", "()V", "placeholder", "", "getPlaceholder$annotations", "getPlaceholder", "()Ljava/lang/String;", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TextInput implements Record, PIntrospectionProvider {
        public String placeholder = "";

        /* JADX INFO: compiled from: ExpoNotificationCategoriesModule.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/notifications/notifications/categories/NotificationActionRecord$TextInput$__Pika;", "", "<init>", "()V", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class __Pika implements PPropertyAccessor {
            public static final __Pika INSTANCE;
            public static final PIntrospectionData<TextInput> __pika$IntrospectionData;

            static {
                __Pika __pika = new __Pika();
                INSTANCE = __pika;
                __pika$IntrospectionData = new PIntrospectionData<>(TextInput.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("placeholder", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap()), new PAnnotation(Required.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 0, __pika, false, true, false)}, PEmptyArrays.EMPTY_FUNCTIONS, null);
            }

            private __Pika() {
            }

            @Override // io.github.expo.pika.PPropertyAccessor
            public Object __pika$PropertyGet(Object obj, int i) {
                if (i != 0) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.categories.NotificationActionRecord.TextInput");
                return ((TextInput) obj).getPlaceholder();
            }

            @Override // io.github.expo.pika.PPropertyAccessor
            public void __pika$PropertySet(Object obj, int i, Object obj2) {
                if (i != 0) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.categories.NotificationActionRecord.TextInput");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((TextInput) obj).placeholder = (String) obj2;
            }
        }

        @Field
        @Required
        public static /* synthetic */ void getPlaceholder$annotations() {
        }

        @Override // io.github.expo.pika.PIntrospectionProvider
        public PIntrospectionData<?> getIntrospectionData() {
            return __Pika.__pika$IntrospectionData;
        }

        public final String getPlaceholder() {
            return this.placeholder;
        }
    }

    /* JADX INFO: compiled from: ExpoNotificationCategoriesModule.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lexpo/modules/notifications/notifications/categories/NotificationActionRecord$Options;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "<init>", "()V", "opensAppToForeground", "", "getOpensAppToForeground$annotations", "getOpensAppToForeground", "()Z", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Options implements Record, PIntrospectionProvider {
        public boolean opensAppToForeground = true;

        /* JADX INFO: compiled from: ExpoNotificationCategoriesModule.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/notifications/notifications/categories/NotificationActionRecord$Options$__Pika;", "", "<init>", "()V", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class __Pika implements PPropertyAccessor {
            public static final __Pika INSTANCE;
            public static final PIntrospectionData<Options> __pika$IntrospectionData;

            static {
                __Pika __pika = new __Pika();
                INSTANCE = __pika;
                __pika$IntrospectionData = new PIntrospectionData<>(Options.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("opensAppToForeground", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, false, true, false)}, PEmptyArrays.EMPTY_FUNCTIONS, null);
            }

            private __Pika() {
            }

            @Override // io.github.expo.pika.PPropertyAccessor
            public Object __pika$PropertyGet(Object obj, int i) {
                if (i != 0) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.categories.NotificationActionRecord.Options");
                return Boolean.valueOf(((Options) obj).getOpensAppToForeground());
            }

            @Override // io.github.expo.pika.PPropertyAccessor
            public void __pika$PropertySet(Object obj, int i, Object obj2) {
                if (i != 0) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.categories.NotificationActionRecord.Options");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((Options) obj).opensAppToForeground = ((Boolean) obj2).booleanValue();
            }
        }

        @Field
        public static /* synthetic */ void getOpensAppToForeground$annotations() {
        }

        @Override // io.github.expo.pika.PIntrospectionProvider
        public PIntrospectionData<?> getIntrospectionData() {
            return __Pika.__pika$IntrospectionData;
        }

        public final boolean getOpensAppToForeground() {
            return this.opensAppToForeground;
        }
    }
}
