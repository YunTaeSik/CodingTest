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
    fun addition_isCorrect() {
        solution("aabbaccc")
        // assertEquals(4, 2 + 2)
    }

    /**문자열 압축**/
    fun solution(s: String): Int {
        var answer = 0

        print(s)
        //한개씩 자르기
        for (count in s.indices) {

            //   println("count = $count")
            println(count)

            var stringBuilder = StringBuilder(s)
            stringBuilder.substring(0, count)

        }

        return answer
    }
}
