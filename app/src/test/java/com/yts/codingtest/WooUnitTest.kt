package com.yts.codingtest

import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.collections.LinkedHashMap

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class WooUnitTest {
    @Test
    fun test() {
        assertEquals("11100,10001", solution10(3, 2, intArrayOf(2, 1, 1, 0, 1)))

        /*   assertEquals(
               "music 1011b\n" +
                       "images 0b\n" +
                       "movies 10200b\n" +
                       "other 105b",
               solution2("my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b")
           )
   */
        //assertEquals(2, solution4(intArrayOf(1, 3, 2, 1), intArrayOf(4, 2, 5, 3, 2)))
    }

    fun log(value: Any) {
        println(Gson().toJson(value))
    }

    fun solution10(U: Int, L: Int, C: IntArray): String {
        var answer = ""
        var upRow = U
        var loRow = L

        C.map {
            if (isMinusRowValue(it, upRow)) {
                answer += "1"
                upRow--
                it.minus(1)
            } else {
                answer += "0"
                it
            }
        }.mapIndexed { Index, it ->
            if (Index == 0) {
                answer += ","
            }
            if (isMinusRowValue(it, loRow)) {
                answer += "1"
                loRow--
                it.minus(1)
            } else {
                answer += "0"
                it
            }
        }
        if (upRow > 0 || loRow > 0) {
            answer = "IMPOSSIBLE"
        }
        return answer
    }


    private fun isMinusRowValue(value: Int, rowValue: Int): Boolean {
        return value > 0 && rowValue > 0
    }


    fun solution2(S: String): String {
        var answer = ""
        val dataMap = linkedMapOf("music" to 0, "images" to 0, "movies" to 0, "other" to 0)

        S.split("\n").forEach {
            val type = it.split(" ").first().split(".").last()
            val value = it.split(" ").last().replace("b", "").toInt()
            setDataMap(type, value, dataMap)
        }
        dataMap.forEach { (key, value) ->
            answer += key + " " + value + "b" + "\n"
        }

        return answer.substring(0..answer.length - 2)
    }

    fun setDataMap(type: String, value: Int, dataMap: LinkedHashMap<String, Int>) {
        val musicSet = setOf("mp3", "aac", "flac")
        val imageSet = setOf("jpg", "bmp", "gif")
        val videoSet = setOf("mp4", "avi", "mkv")
        when {
            musicSet.contains(type) -> {
                dataMap["music"] = (dataMap["music"] ?: 0) + value
            }
            imageSet.contains(type) -> {
                dataMap["images"] = (dataMap["images"] ?: 0) + value
            }
            videoSet.contains(type) -> {
                dataMap["movies"] = (dataMap["movies"] ?: 0) + value
            }
            else -> {
                dataMap["other"] = (dataMap["other"] ?: 0) + value
            }
        }
    }


}

