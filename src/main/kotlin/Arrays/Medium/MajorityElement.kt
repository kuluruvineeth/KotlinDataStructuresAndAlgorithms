package Arrays.Medium

import java.lang.IllegalArgumentException

//Input: [1,1,1,1,1,4,5]
//Output: 1
class MajorityElement {

    //Approach1: Using two loops
    //Time: O(N^2) and Space: O(1)
    fun approach1(nums: IntArray): Int{
        for(num in nums){
            var count=0
            for(element in nums){
                if(element==num){
                    count++
                }
            }
            if(count > nums.size/2){
                return num
            }
        }
        throw IllegalArgumentException("No Majority Element")
    }

    //Approach2: Using Sorting approach
    //Time: O(NLogN) and Space: O(1)
    fun approach2(nums: IntArray): Int{
        nums.sort()
        return nums[nums.size/2]
    }

    //Approach3:
    //Time: O(N) and Space: O(1)
    fun approach3(nums: IntArray): Int{
        var majorityElement = nums[0]
        var count=1
        for(i in 1 until nums.size){
            if(nums[i]==majorityElement){
                count++
            }
            else{
                count--
                if(count==0){
                    majorityElement = nums[i]
                    count=1
                }
            }
        }
        return majorityElement
    }
}

fun main(){

    val majorityElement = MajorityElement()

    println("Approach1 : ${majorityElement.approach1(intArrayOf(1,1,1,1,1,4,5))}")
    println("Approach2 : ${majorityElement.approach2(intArrayOf(1,1,1,1,1,4,5))}")
    println("Approach3 : ${majorityElement.approach3(intArrayOf(1,1,1,1,1,4,5))}")

}