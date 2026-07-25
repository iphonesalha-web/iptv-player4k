# IPTV Player 4K - Android TV Application

تطبيق متقدم وقوي لمشاهدة قنوات IPTV والبث المباشر على أجهزة Android TV، مع دعم كامل للتحكم بالريموت والبث 4K.

## 🎬 المميزات الرئيسية

### 📺 تشغيل البث المباشر
- ✅ دعم **M3U playlists** - إضافة قوائم IPTV من روابط أو ملفات
- ✅ تشغيل **سلس وبدون تأخير** باستخدام ExoPlayer
- ✅ دعم **جودات متعددة** (SD, HD, FHD, 4K)
- ✅ دعم **RTMP, HTTP, HLS, DASH** وجميع الصيغ الشهيرة
- ✅ **إعادة محاولة تلقائية** عند قطع الاتصال
- ✅ **بث سريع جداً** بـ Buffering ذكي

### 📱 واجهة Android TV متقدمة
- ✅ **تحكم كامل بالريموت** (D-Pad, Select, Back)
- ✅ **قوائم هرمية** سهلة التنقل
- ✅ **تركيز بصري واضح** لسهولة الاستخدام
- ✅ **دعم تصحيح اتجاه النص** (RTL) للعربية
- ✅ **واجهة سوداء** (Dark Theme) متطورة

### ❤️ إدارة المفضلة
- ✅ حفظ القنوات المفضلة محلياً
- ✅ **ترتيب مخصص** للمفضلة
- ✅ حذف سريع من المفضلة
- ✅ **مزامنة تلقائية** عند إضافة قوائم جديدة

### 🔍 البحث والتصفية
- ✅ البحث السريع عن القنوات
- ✅ تصفية حسب **المجموعات** (Sports, Movies, Kids, etc.)
- ✅ ترتيب أبجدي تلقائي
- ✅ اقتراحات ذكية أثناء الكتابة

### 📊 سجل المشاهدة
- ✅ حفظ آخر القنوات التي شاهدتها
- ✅ **استئناف التشغيل** من آخر موضع
- ✅ إحصائيات المشاهدة
- ✅ نصائح المشاهدة الشخصية

### 🛠️ إعدادات متقدمة
- ✅ تخصيص حجم Buffer
- ✅ تحديد دقة التشغيل الافتراضية
- ✅ التحكم بحجم الخط
- ✅ إعدادات الأداء والذاكرة
- ✅ **إعدادات التوقيت** (Sleep Timer)

## 🔧 المتطلبات التقنية

- **Android 5.0+** (API Level 21)
- **Android TV Framework** (مدعوم على الهواتف أيضاً)
- **إنترنت**: اتصال سريع موثوق
- **الذاكرة**: 512 MB على الأقل
- **التخزين**: 50 MB مساحة حرة

## 💻 تقنيات البرمجة المستخدمة

### لغة و Frameworks
- 🎯 **Kotlin** - لغة حديثة وآمنة
- 🏗️ **MVVM Architecture** - معمارية قوية وقابلة للتوسع
- 📦 **Jetpack Components**:
  - LiveData - لمراقبة البيانات
  - ViewModel - إدارة حالة الواجهة
  - Room Database - قاعدة بيانات محلية
  - Navigation - الانتقال بين الشاشات

### مكتبات التشغيل والبث
- 📹 **ExoPlayer** - محرك تشغيل فيديو احترافي
- 🔄 **HLS/DASH Support** - دعم معايير البث المتقدمة
- 🔐 **DRM Support** - حماية المحتوى

### الشبكة والبيانات
- 🌐 **Retrofit** - جلب البيانات من الإنترنت
- 📡 **OkHttp** - إدارة الطلبات والتخزين المؤقت
- 📋 **Gson** - تحويل JSON

### غير متزامن ومتوازي
- ⚡ **Coroutines** - عمليات غير محجوبة
- 🔄 **Flow** - تدفق البيانات التفاعلي

### الأدوات الأخرى
- 🖼️ **Glide** - تحميل وعرض الصور
- 💉 **Hilt** - حقن التبعيات
- 🧪 **JUnit & Espresso** - اختبار تلقائي

## 📦 البنية المعمارية

```
iptv-player4k/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/iptv/player4k/
│   │   │   │   ├── ui/
│   │   │   │   │   ├── activities/
│   │   │   │   │   │   ├── MainActivity.kt
│   │   │   │   │   │   ├── PlayerActivity.kt
│   │   │   │   │   │   └── SettingsActivity.kt
│   │   │   │   │   ├── fragments/
│   │   │   │   │   │   ├── ChannelsFragment.kt
│   │   │   │   │   │   ├── FavoritesFragment.kt
│   │   │   │   │   │   ├── PlaylistsFragment.kt
│   │   │   │   │   │   ├── SearchFragment.kt
│   │   │   │   │   │   └── SettingsFragment.kt
│   │   │   │   │   ├── adapters/
│   │   │   │   │   │   ├── ChannelAdapter.kt
│   │   │   │   │   │   ├── PlaylistAdapter.kt
│   │   │   │   │   │   └── GroupAdapter.kt
│   │   │   │   │   └── player/
│   │   │   │   │       ├── PlayerController.kt
│   │   │   │   │       └── PlayerUI.kt
│   │   │   │   ├── data/
│   │   │   │   │   ├── models/
│   │   │   │   │   │   ├── Channel.kt
│   │   │   │   │   │   ├── Playlist.kt
│   │   │   │   │   │   └── Group.kt
│   │   │   │   │   ├── database/
│   │   │   │   │   │   ├── AppDatabase.kt
│   │   │   │   │   │   ├── ChannelDao.kt
│   │   │   │   │   │   └── PlaylistDao.kt
│   │   │   │   │   ├── api/
│   │   │   │   │   │   ├── PlaylistService.kt
│   │   │   │   │   │   └── ApiClient.kt
│   │   │   │   │   └── repository/
│   │   │   │   │       ├── ChannelRepository.kt
│   │   │   │   │       └── PlaylistRepository.kt
│   │   │   │   ├── viewmodel/
│   │   │   │   │   ├── ChannelViewModel.kt
│   │   │   │   │   ├── PlayerViewModel.kt
│   │   │   │   │   └── SettingsViewModel.kt
│   │   │   │   └── utils/
│   │   │   │       ├── M3UParser.kt
│   │   │   │       ├── Constants.kt
│   │   │   │       ├── Extensions.kt
│   │   │   │       └── Preferences.kt
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   ├── drawable/
│   │   │   │   ├── values/
│   │   │   │   └── anim/
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   └── build.gradle
├── .github/workflows/
│   └── android-build.yml
├── build.gradle
├── settings.gradle
├── README.md
├── CONTRIBUTING.md
└── LICENSE
```

## 🚀 البدء السريع

### التثبيت من المصدر

```bash
# استنساخ المستودع
git clone https://github.com/iphonesalha-web/iptv-player4k.git
cd iptv-player4k

# بناء المشروع
./gradlew build

# تثبيت على الجهاز
./gradlew installDebug
```

### الاستخدام الأول

1. **فتح التطبيق** على جهاز Android TV
2. **إضافة قائمة IPTV**:
   - اضغط على "إضافة قائمة" (Add Playlist)
   - اختر: رابط M3U أو ملف من الجهاز
   - انتظر تحميل القنوات
3. **مشاهدة القنوات**:
   - اختر قنة من القائمة
   - استخدم الريموت للتحكم
4. **إضافة للمفضلة**:
   - اضغط ⭐ أثناء المشاهدة

## 📖 التوثيق

- [دليل المستخدم](docs/USER_GUIDE.md) - كيفية استخدام التطبيق
- [دليل المطور](docs/DEVELOPER_GUIDE.md) - معلومات تقنية للمطورين
- [API Documentation](docs/API.md) - وثائق الـ API
- [Changelog](CHANGELOG.md) - سجل التحديثات

## 🤝 المساهمة

نرحب بمساهماتك! اطلع على [CONTRIBUTING.md](CONTRIBUTING.md) لمعرفة كيفية المساهمة.

### المساهمون ✨

- **Your Name** - المنشئ الأساسي
- [والمزيد من المساهمين...]

## 📋 الخارطة الطريقية

### الإصدار 1.0 (الحالي)
- ✅ تشغيل أساسي للقنوات
- ✅ إدارة القوائم
- ✅ المفضلة والبحث
- ✅ إعدادات أساسية

### الإصدار 1.1 (قريباً)
- ⏳ دعم EPG (جدول البرامج)
- ⏳ تسجيل المشاهدة (PVR)
- ⏳ الترجمات
- ⏳ جودة تلقائية

### الإصدار 2.0 (المستقبل)
- 🔮 تطبيق على الهاتف
- 🔮 المزامنة السحابية
- 🔮 وضع عرض الشرائح
- 🔮 VPN مدمج

## ⚙️ الإعدادات المتقدمة

### متغيرات البيئة

```properties
# في ملف local.properties
SDK_PATH=/path/to/android/sdk
NDK_PATH=/path/to/android/ndk
```

### إعدادات Gradle

اراجع `gradle.properties` لتخصيص عملية البناء.

## 🐛 التقارير عن الأخطاء

إذا وجدت مشكلة:
1. تحقق من [Issues](../../issues) الموجودة
2. فتح Issue جديد مع:
   - وصف المشكلة
   - خطوات التكرار
   - لقطات شاشة (إن أمكن)
   - معلومات الجهاز والنسخة

## 📞 التواصل والدعم

- 📧 البريد: [بريدك]
- 💬 المشاكل: [Issues](../../issues)
- 🌐 الموقع: [موقعك]

## 📄 الترخيص

هذا المشروع تحت رخصة **MIT License**. اطلع على [LICENSE](LICENSE) للمزيد.

## 🙏 شكر وتقدير

- شكر خاص لفريق ExoPlayer
- شكر لمجتمع Android Developers
- شكر لكل المساهمين في هذا المشروع

---

**صُنع بـ ❤️ من قبل مطورين عرب**

⭐ إذا أعجبك المشروع، يرجى إعطاؤه نجمة (Star)!
