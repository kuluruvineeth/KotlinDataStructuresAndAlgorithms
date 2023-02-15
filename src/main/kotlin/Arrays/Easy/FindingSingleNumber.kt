package Arrays.Easy

//Input : [1,1,2,2,4,5,5]
//Output : 4
class FindingSingleNumber {

    //Approach: Take two loops and compare every pair
    //Time: O(N^2) and Space: O(N)
    fun approach1(nums: IntArray): Int{
        val uniqueElement = nums.toMutableList()
        for(i in nums.indices){
            for(j in i+1 until nums.size){
                if(nums[i]==nums[j]){
                    uniqueElement.remove(nums[i])
                    uniqueElement.remove(nums[j])
                }
            }
        }
        return uniqueElement[0]
    }

    //Approach2: Using Hashmap to keep count of elements
    //Time: O(N) and Space: O(N)
    fun approach2(nums: IntArray): Int{
        var hashMap = mutableMapOf<Int,Int>()
        for(num in nums){
            hashMap[num] = hashMap.getOrDefault(num,0) + 1
        }
        for(num in nums){
            if(hashMap[num]==1){
                return num
            }
        }
        return -1
    }

    //Approach3: Using Xor operator
    //Time: O(N) and Space: O(1)
    fun approach3(nums: IntArray): Int{
        var unique = 0
        for(num in nums){
            unique = unique xor num
        }
        return unique
    }
}

fun main(){

    val nums = intArrayOf(1,1,2,2,4,5,5)

    val findingSingleNumber = FindingSingleNumber()

    println("Single number using approach1 : ${findingSingleNumber.approach1(nums)}")
    println("Single number using approach2 : ${findingSingleNumber.approach2(nums)}")
    println("Single number using approach3 : ${findingSingleNumber.approach3(nums)}")

}