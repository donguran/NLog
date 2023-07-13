package com.b3lon9.nlog
/*
 * Copyright 2023 Neander
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import android.util.Log

class NLog {
    companion object {
        private val TAG:String = "cavedwellers"
        private var isEnable = true

        /**
         * Custom Log Enable
         *
         * @param isEnable true:show log / false:don't show log
         * */
        fun setEnable(isEnable:Boolean) {
            this.isEnable = isEnable
        }

        private fun isEnable():Boolean = isEnable


        @JvmStatic
        fun v(msg:String) {
            if (isEnable()) {
                val e = Exception()
                val s = e.stackTrace[1]

                Log.v(TAG, "[${s.fileName}:${s.lineNumber}] $msg")
            }
        }

        @JvmStatic
        fun i(msg:String) {
            if (isEnable()) {
                val e = Exception()
                val s = e.stackTrace[1]

                Log.i(TAG, "[${s.fileName}:${s.lineNumber}] $msg")
            }
        }

        @JvmStatic
        fun d(msg:String) {
            if (isEnable()) {
                val e = Exception()
                val s = e.stackTrace[1]

                Log.d(TAG, "[${s.fileName}:${s.lineNumber}] $msg")
            }
        }

        @JvmStatic
        fun w(msg:String) {
            if (isEnable()) {
                val e = Exception()
                val s = e.stackTrace[1]

                Log.w(TAG, "[${s.fileName}:${s.lineNumber}] $msg")
            }
        }

        @JvmStatic
        fun e(msg:String) {
            if (isEnable()) {
                val e = Exception()
                val s = e.stackTrace[1]

                Log.e(TAG, "[${s.fileName}:${s.lineNumber}] $msg")
            }
        }
    }
}
