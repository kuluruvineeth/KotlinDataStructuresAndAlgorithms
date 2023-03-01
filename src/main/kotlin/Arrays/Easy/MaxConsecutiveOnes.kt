package Arrays.Easy

import kotlin.math.max


//Input : [0,0,1,1,1,1,0,1,1,1,0,1]
//Output : 4
class MaxConsecutiveOnes {

    //Approach1: Keeping track of max ones
    //Time: O(N) and Space : O(1)
    fun approach1(nums: IntArray): Int{

        var currentCount = 0
        var maxCount = 0

        for(i in nums.indices){
            if(nums[i]==1){
                currentCount++
                maxCount = max(maxCount,currentCount)
            }
            else{
                currentCount=0
            }
        }
        return maxCount
    }

    //Approach2: Using two pointers
    //Time: O(N) and Space: O(1)
    fun approach2(nums: IntArray): Int{

        var maxCount = 0
        var start = -1
        var end = -1

        for(i in nums.indices){
            if(nums[i]==1){
                if(start==-1){
                    start=i
                }
                end=i
            }
            else{
                if(start!=-1){
                    maxCount = max(maxCount,end-start+1)
                    start=-1
                    end = -1
                }
            }
        }
        if(start!=-1){
            maxCount = max(maxCount,end-start+1)
        }
        return maxCount
    }
}

fun main(){

    val nums = intArrayOf(0,0,1,1,1,1,0,1,1,1,0,1)

    val maxConsecutiveOnes = MaxConsecutiveOnes()

    println("Max Consecutive ones using approach 1 : ${maxConsecutiveOnes.approach1(nums)}")
    println("Max Consecutive ones using approach 2 : ${maxConsecutiveOnes.approach2(nums)}")

}