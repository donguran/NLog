package com.b3lon9.nlog

import android.util.Log

class NLog {
    companion object {
        @JvmStatic
        private val TAG:String = "Neander"

        @JvmStatic
        fun v(msg:String) {
            val e = Exception()
            val s = e.stackTrace[1]

            Log.v(TAG, "[${s.fileName}:${s.lineNumber}] $msg")
        }

        @JvmStatic
        fun i(msg:String) {
            val e = Exception()
            val s = e.stackTrace[1]

            Log.i(TAG, "[${s.fileName}:${s.lineNumber}] $msg")
        }

        @JvmStatic
        fun d(msg:String) {
            val e = Exception()
            val s = e.stackTrace[1]

            Log.d(TAG, "[${s.fileName}:${s.lineNumber}] $msg")
        }

        @JvmStatic
        fun w(msg:String) {
            val e = Exception()
            val s = e.stackTrace[1]

            Log.w(TAG, "[${s.fileName}:${s.lineNumber}] $msg")
        }

        @JvmStatic
        fun e(msg:String) {
            val e = Exception()
            val s = e.stackTrace[1]

            Log.e(TAG, "[${s.fileName}:${s.lineNumber}] $msg")
        }
    }
}