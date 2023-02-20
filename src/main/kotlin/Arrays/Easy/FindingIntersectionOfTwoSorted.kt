package Arrays.Easy

//Input: [1,3,5,7,9] , [0,1,2,3,4,6,8,10,12]
//Output : 1 3
class FindingIntersectionOfTwoSorted {


    //Approach1: Using Two Loops and comparing them
    //Time: O(N^2) and Space: O(N)
    fun approach1(nums1: List<Int>, nums2: List<Int>): List<Int>{

        val intersection = mutableListOf<Int>()

        for(i in nums1){
            if(nums2.contains(i)){
                intersection.add(i)
            }
        }
        return intersection
    }

    //Approach2: Using Two Pointers
    //Time: O(N) and Space: O(N)
    fun approach2(nums1: List<Int>, nums2: List<Int>): List<Int>{

        val intersection = mutableListOf<Int>()

        var i = 0
        var j = 0

        while (i < nums1.size && j < nums2.size){
            when{
                nums1[i] < nums2[j]  -> i++
                nums1[i] > nums2[j] -> j++
                else -> {
                    intersection.add(nums1[i])
                    i++
                    j++
                }
            }
        }
        return intersection
    }

    //Approach3: Using intersect function
    //Time: O(N) and Space: O(N)
    fun approach3(nums1: List<Int>, nums2: List<Int>): List<Int>{

        return nums1.toSet().intersect(nums2.toSet()).toList()
    }
}

fun main(){

    val nums1 = listOf<Int>(1,3,5,7,9)
    val nums2 = listOf<Int>(0,1,2,3,4,6,8,10,12)

    val findingIntersectionOfTwoSorted = FindingIntersectionOfTwoSorted()

    val approach1 = findingIntersectionOfTwoSorted.approach1(nums1,nums2)
    for(i in approach1){
        println("$i ")
    }
    println()
    val approach2 = findingIntersectionOfTwoSorted.approach2(nums1,nums2)
    for(i in approach2){
        println("$i ")
    }
    println()
    val approach3 = findingIntersectionOfTwoSorted.approach3(nums1,nums2)
    for(i in approach3){
        println("$i ")
    }
}