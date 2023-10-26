public class TimerTask {
	private Runnable runnable;
	private long delay;
	private boolean isScheduled = false;
	private long executionTime;

	public TimerTask(Runnable runnable) {
		this.runnable = runnable;
	}

	public void schedule(long delay) {
		this.delay = delay;
		this.executionTime = System.currentTimeMillis() + delay;
		this.isScheduled = true;
	}

	public void cancel() {
		this.isScheduled = false;
	}

	public boolean isScheduled() {
		return isScheduled;
	}

	public void run() {
		if (isScheduled) {
			long currentTime = System.currentTimeMillis();
			if (currentTime >= executionTime) {
				runnable.run();
				isScheduled = false;
			}
		}
	}
}