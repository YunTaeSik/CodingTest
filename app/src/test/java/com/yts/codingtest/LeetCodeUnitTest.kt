package com.yts.codingtest

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
class LeetCodeUnitTest {
    @Test
    fun test() {
        // assertArrayEquals(intArrayOf(1, 2), twoSum(intArrayOf(3, 2, 4), 6))
            assertEquals(3, lengthOfLongestSubstring("dvdf"))
      //  assertEquals(9646324351, reverse(1534236469))
    }

    /**
     * easy
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numMap: HashMap<Int, Int> = HashMap<Int, Int>()

        for (i in nums.indices) {
            val value = target - nums[i]
            if (numMap.containsKey(value)) {
                return intArrayOf(numMap[value]!!, i)
            }
            numMap[nums[i]] = i
        }
        return intArrayOf()
    }

    fun reverse(x: Int): Int {
        val s = Math.abs(x).toString()

        var ans: String?
        ans = s.reversed()
        if (ans[0] == '0') {
            ans = ans.removeRange(0, 0)
        }
        if (x < 0) {
            ans = "-$ans"
        }

        return try {
            ans.trim().toInt()
        } catch (e: Exception) {
            return 0
        }
    }

    /**
     * medium
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        var ans = 0
        val map: MutableMap<Char, Int> = HashMap() // current index of character
        // try to extend the range [i, j]
        var j = 0
        var i = 0

        while (j < n) {
            if (map.containsKey(s[j])) {
                i = Math.max(map[s[j]]!!, i)
            }
            ans = Math.max(ans, j - i + 1)
            map[s[j]] = j + 1
            j++
        }
        return ans
    }


}
