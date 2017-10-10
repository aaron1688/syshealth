# syshealth
this has no setup for db, queue, it's sprintboot only with :9000/hi, /mem?nt=5&amp;nsl=100&amp;st=3000, 9001:/env

	//nt: number of threads, nl: number of elements in string List, st: thread sleep time
	//localhost:900/mem?nt=5&nsl=100&st=3000
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String mem(
		       @RequestParam(value = "nt", required = false, defaultValue = "100") String numOfThread,
		       @RequestParam(value = "nsl", required = false, defaultValue = "100") String numOfStringList,
		       @RequestParam(value = "st", required = false, defaultValue = "600000") String sleepTime)
