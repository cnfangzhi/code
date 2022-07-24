#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring
Java_com_fz_nativelib_NativeLib_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}