package Model;

public class Vehicle {
    String license;
    String company;

    public Vehicle(String license, String company) {
        this.license = license;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "license='" + license + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
