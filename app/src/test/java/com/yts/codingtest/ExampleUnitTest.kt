package com.yts.codingtest

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun test() {
        // stringCompression("aabbaccc")
        //      var answer = fullSearch(intArrayOf(1, 2, 3, 4, 5))

        assertArrayEquals(intArrayOf(1), fullSearch(intArrayOf(1, 2, 3, 4, 5)))
        assertEquals(6, workoutClothes(7, intArrayOf(2, 3, 4), intArrayOf(1, 2, 3, 6)))
        assertEquals("TUE", getDaysOftheWeek(5, 24))

        getDaysOftheWeek(5, 24)
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

    /**체육복 탐욕법**/
    fun workoutClothes(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0

        var lostList = lost.toMutableList()
        var reserveList = reserve.toMutableList()


        val reserveListIterable = reserveList.iterator()
        /**
         * 내꺼 여분
         */
        while (reserveListIterable.hasNext()) {
            val value = reserveListIterable.next()
            when {
                lostList.contains(value) -> {
                    lostList.remove(value)
                    reserveListIterable.remove()
                }

            }
        }
        /**
         * 남는옷들
         */
        for (value in reserveList) {
            when {
                lostList.contains(value - 1) -> {
                    lostList.remove(value - 1)
                }
                lostList.contains(value + 1) -> {
                    lostList.remove(value + 1)
                }
            }
        }
        answer = n - lostList.size
        if (answer < 0) {
            answer = 0
        }

        return answer
    }

    /**2016년 요일구하기**/
    fun getDaysOftheWeek(a: Int, b: Int): String {
        val daysList = intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        val resultList = arrayListOf("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU")

        var sum = 0
        for (i in 0..a - 2) {
            sum += daysList[i]
        }
        sum += (b - 1)

        return resultList[sum % 7]
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
