package com.practice.java.threads;

public class MaxAllowedThreads {

	public static int recommendedThreadCount() {
		int mRtnValue = 0;
		Runtime runtime = Runtime.getRuntime();
		long maxMemory = runtime.maxMemory();
		long mTotalMemory = runtime.totalMemory();
		long freeMemory = runtime.freeMemory();
		int mAvailableProcessors = runtime.availableProcessors();
		System.out.println("Available processors=>" + mAvailableProcessors);
		long mTotalFreeMemory = freeMemory + (maxMemory - mTotalMemory);
		mRtnValue = (int) (mTotalFreeMemory / 4200000000l);
		int mNoOfThreads = mAvailableProcessors - 1;
		if (mNoOfThreads < mRtnValue)
			mRtnValue = mNoOfThreads;
		return mRtnValue;
	}
	
	public static void main(String...strings){
		
		System.out.println(new MaxAllowedThreads().recommendedThreadCount());
	}
}
