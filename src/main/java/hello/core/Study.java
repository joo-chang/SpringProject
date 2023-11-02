package hello.core;

public class Study {

    private StudyStatus status = StudyStatus.DRAFT;

    private int limit;

    public Study(int limit) {
        if (limit <= 0){
            throw new IllegalArgumentException("Limit은 0보다 커야 한다.");
        }
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return status;
    }
    public int getLimit() {
        return limit;
    }
}