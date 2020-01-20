package com.yts.codingtest

import org.junit.Test

import org.junit.Assert.*
import java.lang.StringBuilder

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun test() {
        solution("aabbaccc")
    }

    /**문자열 압축**/
    fun solution(s: String): Int {
        var answer = Int.MAX_VALUE

        var length = s.length

        for (i in 1..length) {
            var append = StringBuilder("")

            var value = ""
            var preValue = ""
            var count = 1
            var text: String

            for (index in s.indices) {
                var startIndex = index * i
                var endIndex = startIndex + i

                if (startIndex <= length && endIndex <= length) {
                    var substring = s.substring(startIndex, endIndex)

                    if (value != "") {
                        preValue = value
                    }
                    value = substring

                    println("value = $value ")
                    println("preValue = $preValue ")

                    var addCountText = ""
                    if (value == preValue) {
                        println("같다")
                        count++

                        if (endIndex == length) {
                            if (count > 1) {
                                addCountText = count.toString()
                            }
                            text = addCountText + preValue
                            append.append(text)
                            count = 1
                        }
                        println("endIndex = $endIndex ")
                    } else {
                        println("다르다")
                        if (count > 1) {
                            addCountText = count.toString()
                        }
                        text = addCountText + preValue
                        append.append(text)
                        count = 1
                    }

                } else {

                    println("value = $value ")
                    println("preValue = $preValue ")
                    append.append(value)
                    println("끝났다")
                    break

                }
            }
            println(append.count())
            if (append.count() in 1 until answer) {
                answer = append.count()
            }
        }


        println(answer)
        return answer
    }
}
