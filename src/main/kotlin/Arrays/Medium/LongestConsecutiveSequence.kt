package Arrays.Medium

import kotlin.math.max


//Input : [100,4,200,1,3,2]
//Output : 4 (1,2,3,4)
class LongestConsecutiveSequence {


    //Approach1: Using two loops and sorting
    //Time: O(N^2) and Space: O(1)
    fun approach1(nums: IntArray): Int{
        var longest = 1
        nums.sort()
        for(i in 0 until nums.size){
            var length = 1
            var j = i+1
            while(j < nums.size && nums[j]==nums[j-1]+1){
                length++
                j++
            }
            longest = max(longest,length)
        }
        return longest
    }

    //Approach2: Using set
    //Time: O(N) and Space: O(N)
    fun approach2(nums: IntArray): Int{
        val set = nums.toSet()
        var longest = 1
        for(num in nums){
            if(num-1 !in set){
                var length=1
                var current = num
                while(current+1 in set){
                    length++
                    current++
                }
                longest = max(longest,length)
            }
        }
        return longest
    }

}

fun main(){

    val longestConsecutiveSequence = LongestConsecutiveSequence()

    println("Approach1 : ${longestConsecutiveSequence.approach1(intArrayOf(100,4,200,1,3,2))}")
    println("Approach2 : ${longestConsecutiveSequence.approach2(intArrayOf(100,4,200,1,3,2))}")

}