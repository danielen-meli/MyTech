package Model;


public class Payment { private Long id;
    private String status;
    private String detail;

    public Payment(Long id, String status, String detail) {
        this.id = id;
        this.status = status;
        this.detail = detail;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;

    }

}
