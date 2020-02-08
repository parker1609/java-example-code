package scheduler;

public class SchedulerResults {
    private Long startTime;
    private Long endTime;
    private Long totalSpendingTime;
    private Long totalWaitingTime;

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Long getTotalSpendingTime() {
        return totalSpendingTime;
    }

    public Long getTotalWaitingTime() {
        return totalWaitingTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public void setTotalSpendingTime(Long totalSpendingTime) {
        this.totalSpendingTime = totalSpendingTime;
    }

    public void setTotalWaitingTime(Long totalWaitingTime) {
        this.totalWaitingTime = totalWaitingTime;
    }
}
