package com

import StringManipulate
import java.util.*

class ManipulateString {
    internal enum class Digits(val digit: Int) {
        ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

    }


    fun main(args: Array<String>) {
        println("Enter Input String:")
        val sc = Scanner(System.`in`)
        val strInput = sc.nextLine()
        var strOutput: String? = null
        if (strInput != null) {
            strOutput = methodCall(strInput)
        }
        println(strOutput)
    }

    fun methodCall(str: String): String? {
        val splitStr = str.split("-".toRegex()).toTypedArray()
        val sb = StringBuffer()
        var sum = 0
        try {
            if (splitStr != null) for (s in splitStr) {
                var temp = 0
                if (sb.length > 0) sb.append("+")
                temp = if (s != null && s.trim { it <= ' ' } != "") {
                    try {
                        val pattern = "\\d+".toRegex();
                        var result=pattern.containsMatchIn(s);

                        if (result) {
                            Integer.valueOf(s.trim { it <= ' ' })
                        } else {
                            val d: Digits = Digits.valueOf(s.trim { it <= ' ' }.toUpperCase())
                            d.digit
                        }

                    } catch (iaexp: IllegalArgumentException) {
                        throw iaexp
                    }
                } else {
                    return "Invalid String..."
                }
                sum = sum + temp ;
                sb.append(temp)
            }
        } catch (ex: Exception) {
            return "Invalid String..."
        }
        println("sum:$sum")
        return "$sb=$sum"
    }
}