package com.bosch.si;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mem")
public class MemoryStressController {

	private static final String template = "Number of threads, %s!";
	public static final AtomicLong counter = new AtomicLong();
	public static List<StringBuffer> memPressureList = new ArrayList<StringBuffer>();
	public static List<Thread> threadList = new ArrayList<Thread>();

	//nt: number of threads, nl: number of elements in string List, st: thread sleep time
	//localhost:9000/mem?nt=5&nsl=100&st=3000
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String mem(
		       @RequestParam(value = "nt", required = false, defaultValue = "100") String numOfThread,
		       @RequestParam(value = "nsl", required = false, defaultValue = "100") String numOfStringList,
		       @RequestParam(value = "st", required = false, defaultValue = "600000") String sleepTime) throws InterruptedException {
		Date timeStamp = new Date();
		StringBuffer output = new StringBuffer(timeStamp.toString() + ": Got request: " + String.format(template, numOfThread) + " numOfStringList:" + numOfStringList + " sleepTime:" + sleepTime);
		System.out.println(output);
		for (int i = 0; i < Integer.parseInt(numOfThread); i++) {
			long count = counter.incrementAndGet();
			String tName = "Mem-" + count;
			Thread t = new Thread(tName) {
				public synchronized void run() {
					for (int i = 0; i < Integer.parseInt(numOfStringList); i++) {
						try {
							memPressureList.add(new StringBuffer("count: " + count + "  :: " + output));

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
					try {
						long time = Long.parseLong(sleepTime);
						Thread.sleep(time);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				};
			};
			t.start();
			threadList.add(t);
		}
		output.append(" :: freeMemory:" + Runtime.getRuntime().freeMemory())
		      .append(" :: total mem to JVM:" + Runtime.getRuntime().totalMemory());
		//Thread.sleep(3000);
		return output.append(" : memListSize:" + memPressureList.size()).toString();
	}

}
