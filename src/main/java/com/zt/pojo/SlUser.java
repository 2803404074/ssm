package com.zt.pojo;

public class SlUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Sl_User.u_id
     *
     * @mbggenerated
     */
    private Integer uId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Sl_User.u_name
     *
     * @mbggenerated
     */
    private String uName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Sl_User.u_account
     *
     * @mbggenerated
     */
    private String uAccount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Sl_User.u_password
     *
     * @mbggenerated
     */
    private String uPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Sl_User.u_phone
     *
     * @mbggenerated
     */
    private String uPhone;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Sl_User.u_id
     *
     * @return the value of Sl_User.u_id
     *
     * @mbggenerated
     */
    public Integer getuId() {
        return uId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Sl_User.u_id
     *
     * @param uId the value for Sl_User.u_id
     *
     * @mbggenerated
     */
    public void setuId(Integer uId) {
        this.uId = uId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Sl_User.u_name
     *
     * @return the value of Sl_User.u_name
     *
     * @mbggenerated
     */
    public String getuName() {
        return uName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Sl_User.u_name
     *
     * @param uName the value for Sl_User.u_name
     *
     * @mbggenerated
     */
    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Sl_User.u_account
     *
     * @return the value of Sl_User.u_account
     *
     * @mbggenerated
     */
    public String getuAccount() {
        return uAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Sl_User.u_account
     *
     * @param uAccount the value for Sl_User.u_account
     *
     * @mbggenerated
     */
    public void setuAccount(String uAccount) {
        this.uAccount = uAccount == null ? null : uAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Sl_User.u_password
     *
     * @return the value of Sl_User.u_password
     *
     * @mbggenerated
     */
    public String getuPassword() {
        return uPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Sl_User.u_password
     *
     * @param uPassword the value for Sl_User.u_password
     *
     * @mbggenerated
     */
    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Sl_User.u_phone
     *
     * @return the value of Sl_User.u_phone
     *
     * @mbggenerated
     */
    public String getuPhone() {
        return uPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Sl_User.u_phone
     *
     * @param uPhone the value for Sl_User.u_phone
     *
     * @mbggenerated
     */
    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    public SlUser(String uName, String uAccount, String uPassword, String uPhone) {
        this.uName = uName;
        this.uAccount = uAccount;
        this.uPassword = uPassword;
        this.uPhone = uPhone;
    }

    public SlUser() {
    }

    @Override
    public String toString() {
        return "SlUser{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uAccount='" + uAccount + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uPhone='" + uPhone + '\'' +
                '}';
    }
}