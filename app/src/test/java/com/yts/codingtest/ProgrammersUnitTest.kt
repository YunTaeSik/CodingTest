package com.yts.codingtest

import com.google.gson.Gson
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.Exception
import kotlin.math.abs
import kotlin.math.max

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ProgrammersUnitTest {
    @Test
    fun test() {
        /*  assertEquals(
              5,
              camouflage(
                  arrayOf(
                      arrayOf("yellow_hat", "headgear"),
                      arrayOf("blue_sunglasses", "eyewear"),
                      arrayOf("green_turban", "headgear")
                  )
              )
          )*/

        assertArrayEquals(
            intArrayOf(4, 1, 3, 0),
            bestAlbum(
                arrayOf("classic", "pop", "classic", "classic", "pop"),
                intArrayOf(500, 600, 150, 800, 2500)
            )
        )
        assertArrayEquals(
            intArrayOf(5, 6, 3),
            kValue(
                intArrayOf(1, 5, 2, 6, 3, 7, 4),
                arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
            )
        )
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

    fun log(value: Any) {
        println(Gson().toJson(value))
    }

    /**
     * 정렬
     */
    //K번째수
    fun kValue(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map {
            log(it)
            //   array.toList().subList(it[0], Math.min(it[1], it.size))[0]
            array.toList().subList(0, 7)[it[2]]
        }.toList().toIntArray()

    }
}

