package com.gl.notescounter.util;
import java.util.Scanner;
import com.gl.notescounter.util.ArrayUtil;
public class DriverClass1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of denominations:");
		int numberOfDenominations = s.nextInt();
		
		int [] arrDenominations = new int[numberOfDenominations];
		System.out.println("Enter the values of denominations");
		for(int i = 0; i< numberOfDenominations; i++)
		{
			arrDenominations[i] = s.nextInt();
		}
		
		// sort the Denominations:
		ArrayUtil.mergeSort(arrDenominations);
		
		int [] counter = new int[numberOfDenominations];

		
		System.out.println("enter the amount you want to pay: ");
		int amountToPay = s.nextInt();
		
		int remainingAmount = countNotes(arrDenominations, counter, 0, numberOfDenominations - 1, amountToPay);
		
		if (remainingAmount > 0)
		{
			System.out.println("Amount cannot be paid in give denominations!");
		}
		else
		{
			for(int i = numberOfDenominations - 1; i>=0; i--)
			{
				if(counter[i] != 0)
				{
					System.out.println("Denomination of " + arrDenominations[i] + ":" + counter[i]);
				}
			}
		}
	}

public static int countNotes(int[] arrDenominations, int[] counter, int low, int high, int amountToPay )
{
	/*
	 */
	if (amountToPay == 0)
	{
		return 0;
	}
	if (amountToPay < arrDenominations[0])
	{
		return amountToPay;
	}
	
	
	if(amountToPay >= arrDenominations[high])
	{
		counter[high] = amountToPay / arrDenominations[high];
		amountToPay %= arrDenominations[high];
		return countNotes(arrDenominations, counter, 0, high - 1, amountToPay);
	}
	int mid = (low+high)/2;
	if(amountToPay <= arrDenominations[mid])
	{
		return countNotes(arrDenominations, counter, 0, mid - 1, amountToPay);
	}
	return countNotes(arrDenominations, counter, 0, high - 1, amountToPay);
}

}



