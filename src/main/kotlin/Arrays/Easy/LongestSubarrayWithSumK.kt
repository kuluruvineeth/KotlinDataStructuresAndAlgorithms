package Arrays.Easy

//Input : [1,2,3,5,6,7,8], sum=16
//Output : [2,3,5,6]
class LongestSubarrayWithSumK {


    //Approach1: Use Two loops and iterate all possible subarrays
    //Time: O(N^2) and Space: O(1)
    fun approach1(nums: IntArray, sum: Int): IntArray{

        var LargestSubarrayLength = 0
        var LargestStartIndex = -1
        var LargestEndIndex = -1

        for(i in nums.indices){
            for(j in i until nums.size){
                val subArray = nums.sliceArray(i until j+1)
                if(subArray.sum() == sum){
                    var length = j - i + 1
                    if(length > LargestSubarrayLength){
                        LargestSubarrayLength = length
                        LargestStartIndex = i
                        LargestEndIndex = j
                    }
                }
            }
        }
        if(LargestStartIndex == -1){
            return intArrayOf()
        }else{
            return nums.sliceArray(LargestStartIndex until LargestEndIndex+1)
        }
    }


    //Approach2: Using two pointers
    //Time: O(N) and Space: O(1)
    fun approach2(nums: IntArray, k: Int): IntArray{

        var sum = 0
        var start = 0
        var end = 0

        var LargestSubarrayLength = 0
        var LargestStartIndex = -1
        var LargestEndIndex = -1

        while(end < nums.size){
            sum += nums[end]

            while(sum > k && start<=end){
                sum -= nums[start]
                start++
            }
            if(sum == k){
                var length = end - start
                if(length > LargestSubarrayLength){
                    LargestSubarrayLength = length
                    LargestStartIndex = start
                    LargestEndIndex = end
                }
            }
            end++
        }
        return if(LargestStartIndex==-1){
            intArrayOf()
        }else{
            nums.sliceArray(LargestStartIndex until LargestEndIndex + 1)
        }
    }


    //Approach3: Using Hashmap
    //Time: O(N) and Space: O(N)
    fun approach3(nums: IntArray, k: Int): IntArray{
        var hashMap = mutableMapOf(0 to -1)
        var sum = 0
        var LargestSubArray = 0
        var LargestStartIndex = -1
        var LargestEndindex = -1

        for(i in nums.indices){
            sum += nums[i]
            if(hashMap.contains(sum-k)){
                val start = hashMap[sum-k]!!
                val length = i - start
                if(length > LargestSubArray){
                    LargestSubArray = length
                    LargestStartIndex = start + 1
                    LargestEndindex = i
                }
            }
            if(!hashMap.contains(sum-k)){
                hashMap[sum] = i
            }
        }
        return if(LargestStartIndex==-1){
            intArrayOf()
        }else{
            nums.sliceArray(LargestStartIndex until LargestEndindex  +1)
        }
    }
}

fun main(){

    val nums = intArrayOf(1,2,3,5,6,7,8)

    val longestSubarrayWithSumK = LongestSubarrayWithSumK()

    val approach1 = longestSubarrayWithSumK.approach1(nums,16)
    print("Approach1 : ")
    for(i in approach1){
        print("$i ")
    }
    println()
    val approach2 = longestSubarrayWithSumK.approach2(nums,16)
    print("Approach2 : ")
    for(i in approach2){
        print("$i ")
    }
    println()
    val approach3 = longestSubarrayWithSumK.approach3(nums,16)
    print("Approach3 : ")
    for(i in approach3){
        print("$i ")
    }
}