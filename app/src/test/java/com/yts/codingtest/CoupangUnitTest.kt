package com.yts.codingtest

import com.google.gson.Gson
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CoupangUnitTest {
    @Test
    fun test() {
        assertArrayEquals(longArrayOf(1, 1, 3, 1), solution1(arrayOf("one", "one", "two", "one")))

        assertEquals("_____h", solution2(6, "hi bye", 1))

        assertEquals(4, solution(intArrayOf(10, 10, 10, 10)))

    }

    fun log(value: Any) {
        println(Gson().toJson(value))
    }

    fun solution1(words: Array<String>): LongArray {
        val map = HashMap<String, Int>()
        val answer: LongArray = LongArray(words.size)

        words.forEachIndexed { i, word ->
            if (!map.contains(word)) {
                map[word] = i + 1
            }
            answer[i] = map[word]?.toLong() ?: 0
        }

        return answer
    }

    fun solution2(n: Int, text: String, second: Int): String {
        var answer = ""
        val charArray: MutableList<Char> = text.toCharArray().toMutableList()

        for (i in 0 until n) {
            charArray.add(0, '_')
        }

        charArray.forEachIndexed { index, c ->
            answer += charArray[((index + second) % charArray.size)]
        }

        return answer.slice(0 until n).replace(" ", "_")
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun solution(ages: IntArray): Int {
        var answer = 1
        val candleList = mutableListOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
        var ageString = ""

        ages.forEach {
            ageString += it.toString()
        }

        ageString.forEach {
            if (candleList.contains(it)) {
                candleList.remove(it)
            } else if (it == '6') {
                if (candleList.contains('9')) {
                    candleList.remove('9')
                } else {
                    addList(candleList, it)
                    answer++
                }
            } else if (it == '9') {
                if (candleList.contains('6')) {
                    candleList.remove('6')
                } else {
                    addList(candleList, it)
                    answer++
                }
            } else {
                addList(candleList, it)
                answer++
            }
        }

        return answer
    }


    fun addList(candleList: MutableList<Char>, removeChar: Char) {
        candleList.addAll(
            mutableListOf(
                '0',
                '1',
                '2',
                '3',
                '4',
                '5',
                '6',
                '7',
                '8',
                '9'
            )
        )
        candleList.remove(removeChar)
    }


    /**
     * 해시 알고리즘
     */
    //위장
    fun camouflage(clothes: Array<Array<String>>): Int {
        return clothes.groupBy { it[1] }.values.fold(1) { acc, v ->
            acc * (v.size + 1)
        } - 1
    }

    //베스트 앨범
    fun bestAlbum(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices.groupBy { genres[it] }
            .toList()
            .sortedByDescending { it.second.sumBy { plays[it] } }
            .map { it.second.sortedByDescending { plays[it] }.take(2) }
            .flatten()
            .toIntArray()
    }


    /**
     * 정렬
     */
    //K번째수
    fun kValue(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map {
            array.toList().subList(it[0] - 1, it[1]).sorted()[it[2] - 1]
        }.toList().toIntArray()
    }

    //가장 큰수
    fun largestNumber(numbers: IntArray): String {
        var answer = ""
        numbers.sortedWith(Comparator { num1: Int, num2: Int -> "$num2$num1".compareTo("$num1$num2") })
            .forEach { answer += it }
        if ("(0*)".toRegex().replace(answer, "").isEmpty()) {
            answer = "0"
        }
        return answer
    }

    //H-Index
    fun hIndex(citations: IntArray): Int {
        val result = citations.sortedArrayDescending()
        for (i in result.indices) {
            if (result[i] < i + 1) {
                return i
            }
        }
        return citations.size
    }

    /**
     * 완전탐색
     */
    //소수
    fun sosu(numbers: String): Int {


        var answer = 0
        return answer
    }

    /**
     * 깊이 / 너비 우선 탐색
     * DFS BFS
     */
    //타겟 넘버
    fun targetNumber(numbers: IntArray, target: Int): Int {
        //DFS
        return numbers.fold(listOf(0)) { list, i ->
            log(list)
            log(i)
            list.run {
                map { it + i } + map { it - i }
            }
        }.count { it == target }
    }

    /*//네트워크
    fun network(n: Int, computers: Array<IntArray>): Int {
        return computers.reduce { list, i ->
            log(list)
            log(i)
            list.run {
                map { it } + map { it }

            }.count()
        }
    }*/

}

