# Lamport-quicksort sorting algorithm
Lamport's iterative variant of Hoare's quicksort algorithm in Java

The concept is to maintain a set of pairs of indices which represent the bounds of the
subarrays yet to be sorted. Initially, the set only contains the indices which bound the array
that is to be sorted. In each iteration, a pair of bounds is removed from the set and if the
corresponding subarray contains more than one element, quicksort’s partition algorithm is
carried out on the elements within the subarray. Partitioning produces two subarrays whose
bounds are added to the set. The algorithm terminates, when the set is empty. At this
point, the whole array will be sorted.
