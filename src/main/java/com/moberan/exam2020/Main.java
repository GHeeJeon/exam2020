//callback이 호출되어 결과가 나올 때까지 thread를 대기시킴.
package com.moberan.exam2020;

import com.moberan.exam2020.lib.Task;
import com.moberan.exam2020.lib.TestLibrary;
import com.moberan.exam2020.SyncResult;

public class Main {

	public static void main(String[] args) {
		String result = tasks();
		System.out.println(result);
	}

	private static String tasks(){

		TestLibrary lib = new TestLibrary();

		SyncResult result = new SyncResult();

		lib.firstTask(new Task() {
			@Override
			public void taskCallback(String s) {
				 result.setResult(lib.secondTask(s));
			}
		});

		// FIXME always null.
		return result.getResult();
	}
}
