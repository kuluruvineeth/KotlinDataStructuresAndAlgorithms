package Arrays.Easy

//Input: [0,4,1,7,0,67,34]
//Output: [4,1,7,67,34,0,0]

class MoveZerosToEnd {

    //Approach1: Using Separate elements
    //Time: O(N) and Space: O(N)
    fun approach1(nums:IntArray): List<Int>{

        var nonZeroElements = mutableListOf<Int>()
        var zeroElements = mutableListOf<Int>()

        for(i in nums.indices){
            if(nums[i]==0){
                zeroElements.add(nums[i])
            }
            else{
                nonZeroElements.add(nums[i])
            }
        }
        return nonZeroElements + zeroElements
    }

    //Approach2: Traverse and swap elements
    //Time: O(N) and Space: O(1)
    fun approach2(nums: IntArray): List<Int>{
        for(i in 0 until nums.size-1){
            if(nums[i]==0){
                var j = i+1
                while(j < nums.size && nums[j]==0){
                    j++
                }
                if(j < nums.size){
                    nums[i]=nums[j]
                    nums[j]=0
                }
            }
        }
        return nums.toList()
    }

    //Approach3: Using Partition function
    //Time: O(N) and Space: O(N)
    fun approach3(nums: IntArray): List<Int>{
        val partition = nums.partition { it!=0 }
        var newList = mutableListOf<Int>()
        newList.addAll(partition.first)
        newList.addAll(partition.second)
        return newList
    }
}

fun main(){

    val nums = intArrayOf(0,4,1,7,0,67,34)

    val moveZerosToEnd = MoveZerosToEnd()

    val approach1 = moveZerosToEnd.approach1(nums)

    print("Approach1: ")
    for(i in approach1){
        print("$i ")
    }
    println()
    val approach2 = moveZerosToEnd.approach2(nums)

    print("Approach2: ")
    for(i in approach2){
        print("$i ")
    }
    println()
    val approach3 = moveZerosToEnd.approach3(nums)

    print("Approach3: ")
    for(i in approach3){
        print("$i ")
    }
}