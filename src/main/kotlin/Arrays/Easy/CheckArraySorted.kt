package Arrays.Easy

//Input : [1,2,3,4,6]
//Output : true
class CheckArraySorted {


    //Approach1: Traverse the array and compare adjacent elements
    //Time: O(N) and Space: O(1)
    fun approach1(nums: IntArray): Boolean{

        for(i in 1 until nums.size){
            if(nums[i] < nums[i-1]){
                return false
            }
        }
        return true
    }

    //Approach2: Using Recursive Approach
    //Time: O(N) and Space: O(N)
    fun approach2(nums: IntArray, n: Int): Boolean{

        //base condition
        if(n==1) return true

        return (nums[n-1] > nums[n-2] && approach2(nums,n-1))
    }

    //Approach3: Using inbuilt functions
    //Time: O(NLogN) and Space: O(1)
    fun approach3(nums: IntArray): Boolean{
        return nums.sorted() == nums.toList()
    }
}

fun main(){

    val nums = intArrayOf(1,2,3,4,5)

    val checkArraySorted = CheckArraySorted()

    println("Is Array Sorted Using Approach1 : ${checkArraySorted.approach1(nums)}")
    println("Is Array Sorted Using Approach2 : ${checkArraySorted.approach2(nums,5)}")
    println("Is Array Sorted Using Approach3 : ${checkArraySorted.approach3(nums)}")

}