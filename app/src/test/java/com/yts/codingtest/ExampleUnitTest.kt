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
        // stringCompression("aabbaccc")
        var answer = fullSearch(intArrayOf(1, 2, 3, 4, 5))
    }

    /**모의고사 완전탐색**/
    fun fullSearch(answers: IntArray): IntArray {
        var answer = arrayListOf<Int>()

        var onePerson = intArrayOf(1, 2, 3, 4, 5)
        var twoPerson = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        var threePerson = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        var onePersonAnswer = 0
        var twoPersonAnswer = 0
        var threePersonAnswer = 0

        for (i in answers.indices) {
            var example = answers[i]
            if (example == onePerson[i % onePerson.size]) {
                onePersonAnswer++
            }
            if (example == twoPerson[i % twoPerson.size]) {
                twoPersonAnswer++
            }
            if (example == threePerson[i % threePerson.size]) {
                threePersonAnswer++
            }
        }

        var answerCounts = intArrayOf(onePersonAnswer, twoPersonAnswer, threePersonAnswer)

        var max = answerCounts.max()
        for (i in answerCounts.indices) {
            if (max == answerCounts[i]) {
                answer.add(i + 1)
            }
        }
        return answer.toIntArray()
    }

    /**문자열 압축**/
    fun stringCompression(s: String): Int {
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
