package Arrays.Easy

//Input : [1,1,2,2,2,3]
//Output : [1,2,3]
class RemoveDuplicatesFromSorted {

    //Approach1: Using new extra array
    //Time: O(N) and Space: O(N)
    fun approach1(nums: IntArray): IntArray{

        var newArray = IntArray(nums.size)
        var j=0
        for(i in 1 until nums.size)
        {
            if(nums[i]!=nums[i-1]){
                newArray[j++] = nums[i]
            }
        }
        newArray[j++] = nums[0]
        return newArray.sliceArray(0 until j)
    }

    //Approach2: Using extra pointer
    //Time: O(N) and Space: O(1)
    fun approach2(nums: IntArray): Int{

        var j=0
        for(i in 1 until nums.size){
            if(nums[i]!=nums[j]){
                j++
                nums[j] = nums[i]
            }
        }
        return j+1
    }

    //Approach3: Using inbuilt higher order distinct function
    //Time: O(N) and Space: O(1)
    fun approach3(nums: IntArray): IntArray{
        return nums.distinct().toIntArray()
    }

}

fun main(){

    val removeDuplicatesFromSorted = RemoveDuplicatesFromSorted()

    val approach1 = removeDuplicatesFromSorted.approach1(intArrayOf(1,1,2,2,2,3,3))
    print("Approach1 : ")
    for(i in approach1){
        print("$i ")
    }
    println()
    println("Approach2: ${removeDuplicatesFromSorted.approach2(intArrayOf(1,1,2,2,2,3,3))}")

    val approach3 = removeDuplicatesFromSorted.approach3(intArrayOf(1,1,2,2,2,3,3))
    print("Approach3 : ")
    for(i in approach3){
        print("$i ")
    }
}
