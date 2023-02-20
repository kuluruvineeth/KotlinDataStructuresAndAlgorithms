package Arrays.Easy

//Input: [3,5,6,7,1,9], d=2
//Output: [6,7,1,9,3,5]
class LeftRotateArrayByd {


    //Approach1: Take last and add it to first elements leaving last d elements
    //Time: O(N) and Space: O(N)
    fun approach1(nums: MutableList<Int>,d: Int): List<Int>{
        val rotated = nums.takeLast(nums.size - d) + nums.dropLast(nums.size - d)
        nums.clear()
        nums.addAll(rotated)
        return nums
    }

    //Approach2: Rotate the array by d times
    //Time: O(Nd) and Space: O(1)
    fun approach2(nums: MutableList<Int>, d: Int): List<Int>{

        for(i in 0 until d){
            val temp = nums[0]
            for(j in 0 until nums.size-1){
                nums[j] = nums[j+1]
            }
            nums[nums.size-1] = temp
        }
        return nums
    }

}

fun main(){

    val nums = mutableListOf<Int>(3,5,6,7,1,9)

    val leftRotateArrayByd = LeftRotateArrayByd()

    val approach1 = leftRotateArrayByd.approach1(nums,2)
    print("Approach1 : ")
    for(i in approach1){
        print("$i ")
    }
    println()
    val nums1 = mutableListOf<Int>(3,5,6,7,1,9)
    val approach2 = leftRotateArrayByd.approach2(nums1,2)
    print("Approach2 : ")
    for(i in approach2){
        print("$i ")
    }
}