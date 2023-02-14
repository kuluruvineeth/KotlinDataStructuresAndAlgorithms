package Arrays.Easy

import kotlin.math.max

//[1,2,3,4,5]
//Output : 5

class findingLargestElement {

    //Approach1: Traverse the array and keep track of max element
    //Time: O(N) and Space: O(1)
    fun approach1(nums: IntArray): Int{

        var max = nums[0]

        for(i in nums.indices){
            if(max < nums[i]){
                max = nums[i]
            }
        }
        return max
    }

    //Approach2: Using max function of int array
    //Time: O(N) and Space: O(1)
    fun approach2(nums: IntArray): Int{

        return nums.max()
    }

    //Approach3: Using recursion function
    //Time: O(N) and Space: O(N)
    fun approach3(nums: IntArray, n: Int): Int{

        //base condition
        if(n==1) return nums[0]

        //recursively track all subarrays
        var restOfArrayMax = approach3(nums,n-1)

        return max(restOfArrayMax,nums[n-1])
    }




}

fun main(){

    val nums = intArrayOf(1,2,3,45,6)

    val findingLargestElement = findingLargestElement()

    println("Max using approach1 : ${findingLargestElement.approach1(nums)}")
    println("Max using approach2 : ${findingLargestElement.approach2(nums)}")
    println("Max using approach3 : ${findingLargestElement.approach3(nums,5)}")




}