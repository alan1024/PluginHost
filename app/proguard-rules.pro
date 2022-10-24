# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# 设置混淆的压缩比率 0 ~ 7
-optimizationpasses 5
# 混淆时不使用大小写混合，混淆后的类名为小写
-dontusemixedcaseclassnames
# 指定不去忽略非公共库的类
-dontskipnonpubliclibraryclasses
# 指定不去忽略非公共库的成员
-dontskipnonpubliclibraryclassmembers
# 混淆时不做预校验
-dontpreverify
# 混淆时不记录日志
-verbose
# 保留注解不混淆
-keepattributes *Annotation*,InnerClasses
# 避免混淆泛型
-keepattributes Signature
# 保留代码行号，方便异常信息的追踪
-keepattributes SourceFile,LineNumberTable
# 混淆采用的算法
-optimizations !code/simplification/cast,!field/*,!class/merging/*

-keep class com.rupee.park.** {*;}
-dontwarn com.rupee.park.**
-keep class com.qihoo360.** {*;}
-dontwarn com.qihoo360.**
-keep class com.alan.pluginhost.** {*;}
-dontwarn com.alan.pluginhost.**



-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.preference.Preference
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService

#support
-keep class android.support.** {*;}
-dontwarn android.support.**
-keep interface android.support.** { *; }

# support design
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }

#androidx
-keep class androidx.** {*;}
-keep interface androidx.** {*;}
-keep class * extends androidx.**  { *; }
-dontwarn androidx.**

#support design androidx
-keep class com.google.android.material.** {*;}
-dontwarn com.google.android.material.**
-dontnote com.google.android.material.**

# support v4/7库
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.support.annotation.**

#自定义view
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}


# 资源混淆
-keep class **.R$* {*;}

# 避免混淆枚举类
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Natvie 方法不混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

# 避免Parcelable混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

# 避免Serializable接口的子类中指定的某些成员变量和方法混淆避免Serializable接口的子类中指定的某些成员变量和方法混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# WebView混淆配置
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.webView, jav.lang.String);
}
-keepattributes JavascriptInterface

# okhttp3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**

# retrofit2
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions


# glide 3
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# glide 4
-keep public class * implements com.bumptech.glide.module.AppGlideModule
-keep public class * implements com.bumptech.glide.module.LibraryGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# gson
# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-dontwarn sun.misc.**
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.rupee.park.model.** {
    public *;
    <fields>;
    <methods>;
}


# Prevent proguard from stripping interface information from TypeAdapter, TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapter
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# Prevent R8 from leaving Data object members always null
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}

-keep class com.zy.devicelibrary.** {*;}

#appsflyer
-keep class com.appsflyer.** { *; }

#facebook
-keep class com.facebook.** { *; }


-dontwarn com.android.installreferrer

#-ButterKnife 7.0
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
 @butterknife.* <methods>;
}

# RxLifeCycle4
-keep class com.trello.rxlifecycle4.** { *; }
-keep interface com.trello.rxlifecycle4.** { *; }
-dontwarn com.trello.rxlifecycle4.**

# rxjava3
-keep class io.reactivex.rxjava3.** { *; }
-keep interface io.reactivex.rxjava3.** { *; }
-dontwarn io.reactivex.rxjava3.**

# reactivestreams
-keep class org.reactivestreams.** { *; }
-keep interface org.reactivestreams.** { *; }
-dontwarn org.reactivestreams.**

# firebase
-keep class com.google.firebase.** { *; }
-keep interface com.google.firebase.** { *; }
-dontwarn com.google.firebase.**
