# syshealth
this has no setup for db, queue, it's sprintboot only with :9000/hi, /mem?nt=5&amp;nsl=100&amp;st=3000, 9001:/env

i.e.
http://54.183.230.63:9000/mem?nt=50&nsl=10000&st=30000
Fri Jul 14 13:53:58 UTC 2017: Got request: Number of threads, 50! numOfStringList:10000 sleepTime:30000 :: freeMemory:40142224 :: total mem to JVM:508887040 : memListSize:1074455
http://54.183.230.63:9000/hi

	//nt: number of threads, nl: number of elements in string List, st: thread sleep time
	//localhost:9000/mem?nt=5&nsl=100&st=3000
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String mem(
		       @RequestParam(value = "nt", required = false, defaultValue = "100") String numOfThread,
		       @RequestParam(value = "nsl", required = false, defaultValue = "100") String numOfStringList,
		       @RequestParam(value = "st", required = false, defaultValue = "600000") String sleepTime)
		       
git add -f build/libs/syshealth-0.0.1-SNAPSHOT.jar

docker build -t aaron1688/syshealth:1.0 .		       
docker run -d -p 9000:9000 -p 9001:9001 --name syshealth aaron1688/syshealth:1.0
curl localhost:9000/hi
curl localhost:9001/env