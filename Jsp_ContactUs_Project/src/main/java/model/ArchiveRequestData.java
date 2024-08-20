package model;

public class ArchiveRequestData {
    private int id;
    private String fullName;
    private String Email;
    private String Message;
    private String Status;
    public ArchiveRequestData(int id, String full_name,String email,String message,String status){
        this.id = id;
        this.fullName = full_name;
        this.Email = email;
        this.Message = message;
        this.Status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "ArchiveRequestData{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", Email='" + Email + '\'' +
                ", Message='" + Message + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
