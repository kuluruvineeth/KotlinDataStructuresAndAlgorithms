package Arrays.Medium

//Input: [1,4,6,2,9,10], target=3
//Output: 0 3
class TwoSum {


    //Approach1: Using two loops to compare every pair of elements
    //Time: O(N^2) and Space: O(1)
    fun approach1(nums: IntArray,target: Int): IntArray{

        for(i in nums.indices){
            for(j in i+1 until nums.size){
                if(nums[i] + nums[j] == target){
                    return intArrayOf(i,j)
                }
            }
        }
        throw IllegalArgumentException("No two pairs")
    }

    //Approach2: Using Hash Table
    //Time: O(N) and Space: O(N)
    fun approach2(nums: IntArray, target: Int): IntArray{
        val hashMap = hashMapOf<Int,Int>()
        for(i in nums.indices){
            val complement = target - nums[i]
            if(hashMap.containsKey(complement)){
                return intArrayOf(hashMap[complement]!!,i)
            }
            hashMap[nums[i]] = i
        }
        throw IllegalArgumentException("No pair found")
    }

    //Approach3: Using sorting and two pointers
    //Time: O(NLogN) and Space: O(N)
    fun approach3(nums: IntArray, target: Int): IntArray{
        val sortedArray = nums.sortedArray()
        var left = 0
        var right = sortedArray.size-1
        while (left<right){
            val sum = sortedArray[left] + sortedArray[right]
            when{
                sum==target -> return intArrayOf(nums.indexOf(sortedArray[left]),nums.indexOf(sortedArray[right]))
                sum < target -> left++
                else  -> right--
            }
        }
        throw IllegalArgumentException("No pair found")
    }
}

fun main(){

    val twoSum = TwoSum()

    val approach1 = twoSum.approach1(intArrayOf(1,4,6,2,9,10),3)
    print("Approach1 : ")
    for(i in approach1){
        print("$i ")
    }
    println()
    val approach2 = twoSum.approach2(intArrayOf(1,4,6,2,9,10),3)
    print("Approach2 : ")
    for(i in approach2){
        print("$i ")
    }
    println()
    val approach3 = twoSum.approach3(intArrayOf(1,4,6,2,9,10),3)
    print("Approach3 : ")
    for(i in approach3){
        print("$i ")
    }
}