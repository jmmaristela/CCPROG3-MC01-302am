// DO NOT EDIT
public class Report { // DO NOT EDIT

    private boolean success; // DO NOT EDIT
    private String message; // DO NOT EDIT


    public Report(boolean success, String message) {
        this.success = success; // DO NOT EDIT
        this.message = message; // DO NOT EDIT
    }

    public boolean isSuccess() { // DO NOT EDIT
        return success; // DO NOT EDIT
    }
    public void setSuccess(boolean success) { // DO NOT EDIT
        this.success = success; // DO NOT EDIT
    }

    public String getMessage() { // DO NOT EDIT
        return message; // DO NOT EDIT
    }
    public void setMessage(String message) { // DO NOT EDIT
        this.message = message; // DO NOT EDIT
    }

    @Override
    public String toString() { // YOU COULD EDIT
        return "Status Report: [success =" + success + ", message =" + message + "]"; // YOU COULD EDIT
    }
}
