package Arrays.Medium

import java.util.SortedMap

//Input: [1,0,1,2,0,0]
//Output: [0,0,0,1,1,2]
class sort0s1s2s {

    //Approach1: Keeping track of all counts of 0s,1s and 2s
    //Time: O(N) and Space: O(1)
    fun approach1(nums: IntArray): IntArray{

        var zerosCount = 0
        var onesCount = 0
        var twosCount = 0

        for(num in nums){
            when(num){
                0 -> zerosCount++
                1 -> onesCount++
                2 -> twosCount++
            }
        }
        for(i in nums.indices){
            when{
                zerosCount > 0 -> {
                    nums[i] = 0
                    zerosCount--
                }
                onesCount > 0 -> {
                    nums[i] = 1
                    onesCount--
                }
                twosCount > 0 -> {
                    nums[i] = 2
                    twosCount--
                }
            }
        }
        return nums
    }


    //Approach2: Using two pointers
    //Time: O(N) and Space: O(1)
    fun approach2(nums: IntArray): IntArray{
        var left = 0
        var right = nums.size - 1

        //to move 0s to the beginning of array
        while(left < right){
            while(left < right && nums[left]==0) left++
            while (left < right && nums[right]!=0) right--
            if(left<right){
                var temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp
            }
        }
        right = nums.size-1
        //to move 2s to the end of array
        while(left < right){
            while(left < right && nums[left]==1) left++
            while (left < right && nums[right]==2) right--
            if(left < right){
                var temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp
            }
        }
        return nums
    }

    //Approach3: Using counting sort
    //Time: O(N) and Space: O(1)
    fun approach3(nums: IntArray): IntArray{

        var counts = IntArray(3)
        for(num in nums){
            counts[num]++
        }
        var index=0
        for(i in counts.indices){
            for(j in 0 until counts[i]){
                nums[index++] = i
            }
        }
        return nums
    }
}

fun main(){

    val sort0s1s2s = sort0s1s2s()

    print("Approach1: ")
    val approach1 = sort0s1s2s.approach1(intArrayOf(1,0,1,2,0,0))
    for(i in approach1){
        print("$i ")
    }
    println()
    print("Approach2: ")
    val approach2 = sort0s1s2s.approach2(intArrayOf(1,0,1,2,0,0))
    for(i in approach2){
        print("$i ")
    }
    println()
    print("Approach3: ")
    val approach3 = sort0s1s2s.approach3(intArrayOf(1,0,1,2,0,0))
    for(i in approach3){
        print("$i ")
    }
}