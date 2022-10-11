package com.gl.notescounter.util;

public class ArrayUtil {
	public static void mergeSort(int[] arr)
	{
		mergeSort(arr, 0, arr.length - 1);
	}

	private static void mergeSort(int [] arrInt, int left, int right)
	{
		if(left < right)
		{
			int mid = (left + right ) / 2;
			mergeSort(arrInt, left, mid);
			mergeSort(arrInt, mid+1, right);
			merge(arrInt, left, mid, right);
		}
	}

	private static void merge(int[] arrInt, int left, int mid, int right) {
		/*Merge Sort*/
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int [] arrLeft = new int[n1];
		int [] arrRight = new int[n2];
		
		for (int i = 0; i< n1; i++)
		{
			arrLeft[i] = arrInt[left + i];
		}
		for (int i = 0; i< n2; i++)
		{
			arrRight[i] = arrInt[mid + i + 1];
		}
		int i = 0, j = 0, k = left;
		
		while(i<n1 && j<n2)
		{
			if (arrLeft[i] < arrRight[j])
			{
				arrInt[k++] = arrLeft[i++];
			}
			else
			{
				arrInt[k++] = arrRight[j++];
			}
		}
		while (i < n1)
		{
			arrInt[k++] = arrLeft[i++];
		}
		while (j<n2)
		{
			arrInt[k++] = arrRight[j++];
		}
		
	}
	}


