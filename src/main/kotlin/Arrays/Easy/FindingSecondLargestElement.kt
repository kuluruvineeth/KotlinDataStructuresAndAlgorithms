package Arrays.Easy


//[34,23,12,56,89]
//Output: 56

class FindingSecondLargestElement {


    //Approach1: Traverse the array and keep track of max and second max element
    //Time: O(N) and Space: O(1)
    fun approach1(nums: IntArray): Int{

        var max  = Int.MIN_VALUE
        var secondMax = Int.MIN_VALUE

        for(element in nums){
            if(element > max){
                secondMax = max
                max = element
            }else if(element in (secondMax+1) until max){
                secondMax = element
            }
        }
        return secondMax
    }

    //Approach2: Find max, remove that and then find max element
    //Time: O(N) and Space: O(N)
    fun approach2(nums: IntArray): Int{

        var max = nums.max()
        var newArray = nums.filter { it != max }
        return newArray.max()
    }

    //Approach3: Sort array in descending order and then return second element in sorted array
    //Time: O(NlogN) and Space: O(1)
    fun approach3(nums: IntArray): Int{
        return nums.sortedArrayDescending()[1]
    }


}

fun main(){

    val nums = intArrayOf(34,23,12,56,89)

    val findingSecondLargestElement = FindingSecondLargestElement()

    println("Second Max using approach1 : ${findingSecondLargestElement.approach1(nums)}")
    println("Second Max using approach2 : ${findingSecondLargestElement.approach2(nums)}")
    println("Second Max using approach3 : ${findingSecondLargestElement.approach3(nums)}")

}