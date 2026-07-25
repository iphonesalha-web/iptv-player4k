# IPTV Player 4K - دليل المساهمة

شكراً لاهتمامك بالمساهمة! نرحب بمساهماتك لتحسين هذا المشروع.

## 📋 إرشادات المساهمة

### 1. Fork المستودع
```bash
git clone https://github.com/iphonesalha-web/iptv-player4k.git
cd iptv-player4k
git remote add upstream https://github.com/iphonesalha-web/iptv-player4k.git
```

### 2. إنشاء فرع جديد
```bash
git checkout -b feature/amazing-feature
# أو للإصلاح:
git checkout -b fix/bug-name
```

### 3. إجراء التعديلات
- اتبع معايير الكود (Kotlin best practices)
- اكتب تعليقات واضحة
- أضف اختبارات إن أمكن

### 4. Commit التغييرات
```bash
git add .
git commit -m "type: description"
```

**أنواع Commits:**
- `feat:` ميزة جديدة
- `fix:` إصلاح خطأ
- `docs:` تحديث التوثيق
- `refactor:` إعادة تنظيم الكود
- `test:` إضافة اختبارات
- `chore:` مهام الصيانة

### 5. Push و فتح Pull Request
```bash
git push origin feature/amazing-feature
```

## 📝 معايير الكود

### Kotlin
- استخدم `val` بدل `var` كلما أمكن
- استخدم `data class` للبيانات
- استخدم Lambda و Functional Programming
- أضف Null Safety checks

### التسمية
- **Classes**: `PascalCase` (مثل `ChannelAdapter`)
- **Functions**: `camelCase` (مثل `loadChannels()`)
- **Constants**: `UPPER_SNAKE_CASE` (مثل `BUFFER_SIZE`)
- **Private members**: prefix `_` أو `private`

### التوثيق
```kotlin
/**
 * وصف مختصر للدالة
 * 
 * @param param1 وصف المعامل الأول
 * @return وصف القيمة المرجعة
 */
fun myFunction(param1: String): Boolean {
    // تنفيذ
}
```

## 🧪 الاختبار

```bash
# اختبارات الوحدة
./gradlew test

# اختبارات الأجهزة
./gradlew connectedAndroidTest

# بناء الإصدار
./gradlew assembleRelease
```

## 📦 الإبلاغ عن الأخطاء

عند فتح Issue جديد، يرجى تضمين:

1. **الوصف**: ما هي المشكلة؟
2. **الخطوات**: كيف يمكن تكرار المشكلة؟
3. **النتيجة المتوقعة**: ما الذي كان يجب أن يحدث؟
4. **النتيجة الفعلية**: ما الذي حدث فعلاً؟
5. **البيئة**:
   - نسخة التطبيق
   - نسخة Android
   - نموذج الجهاز
6. **لقطات الشاشة**: إن أمكن

## 🎁 اقتراح ميزات جديدة

عند اقتراح ميزة، وصّف:

1. **المشكلة**: أين تشعر بالنقص؟
2. **الحل المقترح**: كيف تريد أن يعمل؟
3. **البدائل**: هل هناك حلول أخرى؟
4. **السياق الإضافي**: معلومات أخرى مفيدة

## 👥 قواعد السلوك

- احترم الآخرين والاختلافات
- اترك تعليقات بنّاءة
- ركز على الفكرة وليس الشخص
- كن صبوراً ومتفهماً

## 📚 الموارد المفيدة

- [Kotlin Docs](https://kotlinlang.org/docs/)
- [Android Developer Guide](https://developer.android.com/)
- [ExoPlayer Documentation](https://exoplayer.dev/)
- [MVVM Architecture](https://developer.android.com/jetpack/guide)
- [Material Design](https://material.io/)

## ✅ Checklist قبل الإرسال

- [ ] الكود يتبع معايير المشروع
- [ ] أضفت اختبارات للميزة/الإصلاح
- [ ] الكود يتم بناؤه بدون أخطاء
- [ ] الاختبارات تمر بنجاح
- [ ] حدثت التوثيق إن لزم الأمر
- [ ] لا توجد تعارضات مع main branch

## 🏆 أولويات المساهمة

### عالية الأولوية
- إصلاح الأخطاء الحرجة
- تحسينات الأداء
- ميزات مطلوبة بشدة

### متوسطة الأولوية
- ميزات جديدة مقترحة
- تحسينات واجهة المستخدم
- توثيق

### منخفضة الأولوية
- تحسينات بسيطة
- تنظيف الكود
- تحديث التبعيات

---

**شكراً لك على المساهمة!** ❤️
