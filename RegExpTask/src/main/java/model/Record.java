package model;

import java.util.Date;

/**
 * this class describes the record entity
 */
public class Record {
    private String name;
    private String surname;
    private String patronymic;
    private String fullName;

    private String nickName;

    private String comment;

    private Group group;

    private String homePhone;
    private String cellPhone;

    private String email;
    private String skype;

    private Address address;

    private Date creationDate;
    private Date lastChangeDate;

    /**
     * base constructor
     */
    public Record() {
        address = new Address();
    }

    public Record(String fullName, String nickName, String comment, Group group,
                  String homePhone, String cellPhone, String email, String skype,
                  Address address, Date creationDate, Date lastChangeDate) {
        this.fullName = fullName;
        this.nickName = nickName;
        this.comment = comment;
        this.group = group;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
        this.email = email;
        this.skype = skype;
        this.address = address;
        this.creationDate = creationDate;
        this.lastChangeDate = lastChangeDate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return (builder.append(fullName).append("\nnickname: "+ nickName)
                .append("\ncomment: "+ comment).append("\n group: "+ group)
                .append("\nhome phone: "+ homePhone).append("\n cell phone: "+cellPhone)
                .append("\ne-mail: "+ email).append("\nSkype name: "+ skype)
                .append("\naddress: "+ address).append("\nthe date of creating record: "+ creationDate)
                .append("\nthe date of last record change: "+ lastChangeDate)).toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGroup(Group group) { this.group = group; }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public void setEmail(String eMail) {
        this.email = eMail;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
