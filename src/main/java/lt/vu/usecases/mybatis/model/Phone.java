package lt.vu.usecases.mybatis.model;

public class Phone {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PHONE.ID
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PHONE.MODEL
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    private String model;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PHONE.PRICE
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PHONE.MANUFACTURER_ID
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    private Integer manufacturerId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PHONE.ID
     *
     * @return the value of PUBLIC.PHONE.ID
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PHONE.ID
     *
     * @param id the value for PUBLIC.PHONE.ID
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PHONE.MODEL
     *
     * @return the value of PUBLIC.PHONE.MODEL
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    public String getModel() {
        return model;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PHONE.MODEL
     *
     * @param model the value for PUBLIC.PHONE.MODEL
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PHONE.PRICE
     *
     * @return the value of PUBLIC.PHONE.PRICE
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PHONE.PRICE
     *
     * @param price the value for PUBLIC.PHONE.PRICE
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PHONE.MANUFACTURER_ID
     *
     * @return the value of PUBLIC.PHONE.MANUFACTURER_ID
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    public Integer getManufacturerId() {
        return manufacturerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PHONE.MANUFACTURER_ID
     *
     * @param manufacturerId the value for PUBLIC.PHONE.MANUFACTURER_ID
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}