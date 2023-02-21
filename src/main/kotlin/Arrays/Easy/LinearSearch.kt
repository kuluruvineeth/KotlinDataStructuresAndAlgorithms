package Arrays.Easy

//Input: [1,3,4,5,6,2,9], target=2
//Output: 5
class LinearSearch {

    //Approach1: Traverse the array and returned matched index
    //Time: O(N) and Space: O(1)
    fun approach1(nums: List<Int>,target: Int): Int{

        for(i in nums.indices){
            if(nums[i]==target){
                return i
            }
        }
        return -1
    }

    //Approach2: Using indexOf function
    //Time: O(N) and Space: O(1)
    fun approach2(nums: List<Int>, target: Int): Int{
        return nums.indexOf(target)
    }

}

fun main(){

    val nums = listOf<Int>(1,3,4,5,6,2,9)

    val linearSearch = LinearSearch()

    println("Approach1 : ${linearSearch.approach1(nums,2)}")
    println("Approach2 : ${linearSearch.approach2(nums,2)}")

}