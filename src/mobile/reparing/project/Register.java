
package mobile.reparing.project;

public class Register {
    private String customerName,email,mobileNo,adress,productName,sn,model,type,fault;

    public Register(String customerName, String email, String mobileNo, String adress, String productName, String sn, String model, String type, String fault) {
        this.customerName = customerName;
        this.email = email;
        this.mobileNo = mobileNo;
        this.adress = adress;
        this.productName = productName;
        this.sn = sn;
        this.model = model;
        this.type = type;
        this.fault = fault;
    }

    Register() {
    }
      public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getsn() {
        return sn;
    }

    public void setsn(String sn) {
        this.sn = sn;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFault() {
        return fault;
    }

    public void setFault(String fault) {
        this.fault = fault;
    }
}
