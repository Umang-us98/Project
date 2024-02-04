#include <jni.h>
#include <stdio.h>
#include "CmdAgentImpl.h"

#include <time.h>
#include <unistd.h>

JNIEXPORT jobject JNICALL Java_CmdAgentImpl_C_1GetLocalTime(JNIEnv * env, jobject thisObj, jobject obj);
JNIEXPORT jobject JNICALL Java_CmdAgentImpl_C_1GetVesrion(JNIEnv * env, jobject thisObj, jobject obj); 
