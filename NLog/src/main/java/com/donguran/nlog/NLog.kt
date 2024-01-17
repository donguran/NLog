package com.donguran.nlog
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

/**
 * JvmStatic Java와의 상호작용
 * */
object NLog {
    private var TAG: String = "donguran"
    private var isEnable = true

    /**
     * Custom Log Enable
     *
     * @param isEnable true:show log / false:don't show log
     * */
    fun setEnable(isEnable: Boolean) {
        this.isEnable = isEnable
    }

    private fun isEnable(): Boolean = isEnable

    private fun getTag(): String = TAG

    private fun setTag(tagName: String) {
        this.TAG = tagName
    }


    fun init(tagName: String, isEnable: Boolean): Unit {
        this.TAG = tagName
        this.isEnable = isEnable
    }


    @JvmStatic
    fun v(msg: String) = inlineV(msg)

    @JvmStatic
    fun i(msg: String) = inlineI(msg)

    @JvmStatic
    fun d(msg: String) = inlineD(msg)

    @JvmStatic
    fun w(msg: String) = inlineW(msg)

    @JvmStatic
    fun e(msg: String) = inlineE(msg)

    /**
     * Overload
     * */
    @JvmStatic
    fun v(tagName: String, msg: String) {
        setTag(tagName)
        inlineV(msg)
    }

    @JvmStatic
    fun i(tagName: String, msg: String) {
        setTag(tagName)
        inlineI(msg)
    }

    @JvmStatic
    fun d(tagName: String, msg: String) {
        setTag(tagName)
        inlineD(msg)
    }

    @JvmStatic
    fun w(tagName: String, msg: String) {
        setTag(tagName)
        inlineW(msg)
    }

    @JvmStatic
    fun e(tagName: String, msg: String) {
        setTag(tagName)
        inlineE(msg)
    }

    /*
    line 2023-11-23-수
    overload
    */
    @JvmStatic
    fun l (): Unit = line()

    @JvmStatic
    fun l(level: LogLevel) = line(level = level)

    @JvmStatic
    fun l(count: Int) = line(count = count)

    @JvmStatic
    fun l(shape: String) = line(shape = shape)

    @JvmStatic
    fun l(level:LogLevel, count: Int) = line(level = level, count = count)

    @JvmStatic
    fun l(level:LogLevel, shape: String) = line(level= level, shape = shape)

    @JvmStatic
    fun l(count: Int, shape: String) = line(count = count, shape = shape)

    @JvmStatic
    fun l(level: LogLevel, count: Int, shape: String) = line(level=level, count = count, shape = shape)


    private inline fun line(level: LogLevel = LogLevel.VERBOSE, count: Int = 10, shape: String = "=") {
        val strBuilder = StringBuilder()

        for (i in 0..count) {
            strBuilder.append(shape)
        }

        strBuilder.toString().let {
            when (level) {
                LogLevel.VERBOSE -> inlineV(it)
                LogLevel.INFO -> inlineI(it)
                LogLevel.DEBUG -> inlineD(it)
                LogLevel.WARN -> inlineW(it)
                LogLevel.ERROR -> inlineE(it)
            }
        }
    }

    private inline fun inlineV(msg: String){
        if (isEnable()) {
            val e = Exception()
            val s = e.stackTrace[1]

            Log.v(getTag(), "[${s.fileName}:${s.lineNumber}] $msg")
        }
    }

    private inline fun inlineI(msg: String){
        if (isEnable()) {
            val e = Exception()
            val s = e.stackTrace[1]

            Log.i(getTag(), "[${s.fileName}:${s.lineNumber}] $msg")
        }
    }

    private inline fun inlineD(msg: String){
        if (isEnable()) {
            val e = Exception()
            val s = e.stackTrace[1]

            Log.d(getTag(), "[${s.fileName}:${s.lineNumber}] $msg")
        }
    }

    private inline fun inlineW(msg: String){
        if (isEnable()) {
            val e = Exception()
            val s = e.stackTrace[1]

            Log.w(getTag(), "[${s.fileName}:${s.lineNumber}] $msg")
        }
    }

    private inline fun inlineE(msg: String){
        if (isEnable()) {
            val e = Exception()
            val s = e.stackTrace[1]

            Log.e(getTag(), "[${s.fileName}:${s.lineNumber}] $msg")
        }
    }
}
