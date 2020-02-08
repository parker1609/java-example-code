package scheduler;

public class Process {
    private Long id;
    private Long arriveTime;
    private Long totalBurstTime;
    private Long currentBurstTime;
    private Long currentStartTime;
    private Long currentEndTime;
    private boolean isProcessed;
    private Long totalWaitingTime;

    public Process(Long id, Long arriveTime, Long totalBurstTime) {
        this.id = id;
        this.arriveTime = arriveTime;
        this.totalBurstTime = totalBurstTime;
        this.currentStartTime = 0L;
        this.currentEndTime = 0L;
        this.isProcessed = false;
        this.totalWaitingTime = 0L;
    }

    public void calculateRemainingBurstTime(Long usingTime) {
        this.totalBurstTime -= usingTime;
    }

    public void calculateTotalWaitingTime(Long waitingTime) {
        this.totalWaitingTime += waitingTime;
    }

    public Long getId() {
        return id;
    }

    public Long getArriveTime() {
        return arriveTime;
    }

    public Long getTotalBurstTime() {
        return totalBurstTime;
    }

    public Long getCurrentBurstTime() {
        return currentBurstTime;
    }

    public Long getCurrentStartTime() {
        return currentStartTime;
    }

    public Long getCurrentEndTime() {
        return currentEndTime;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public Long getTotalWaitingTime() {
        return totalWaitingTime;
    }

    public void setCurrentBurstTime(Long currentBurstTime) {
        this.currentBurstTime = currentBurstTime;
    }

    public void setCurrentStartTime(Long currentStartTime) {
        this.currentStartTime = currentStartTime;
    }

    public void setCurrentEndTime(Long currentEndTime) {
        this.currentEndTime = currentEndTime;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }

    public void setTotalWaitingTime(Long totalWaitingTime) {
        this.totalWaitingTime = totalWaitingTime;
    }
}
