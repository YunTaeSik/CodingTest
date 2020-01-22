package com.yts.codingtest

import org.junit.Test

class StudyUnitTest {
    @Test
    fun result() {

    }

    fun max(values: IntArray) : Int{
        var answer = Int.MIN_VALUE

        for(value in values){
            if(value > answer){
                answer = value
            }
        }
        return answer
    }

    fun min(values: IntArray) : Int{
        var answer = Int.MAX_VALUE

        for(value in values){
            if(value < answer){
                answer = value
            }
        }
        return answer
    }

}