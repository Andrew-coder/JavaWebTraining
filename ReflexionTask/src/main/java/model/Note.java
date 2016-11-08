package model;


/**
 * Created by andri on 11/8/2016.
 */
public class Note {
    private String name;
    private String surname;
    private String patronymic;
    private String phone;
    /**
     * current date
     */
    private Date currentDate;

    /**
     * the dateof birthday
     */
    private Date birthDate;

    /**
     * Base constructor
     */
    public Note() {
        currentDate = new Date();
        birthDate = new Date();
    }

    public Note(String name, String surname, String patronymic, String phone, Date currentDate, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;
        this.currentDate = currentDate;
        this.birthDate = birthDate;
    }

    /**
     * this method calculates the number of days between two dates
     * @param currentDate first date (the current date)
     * @param birthDate second date (date of birthday)
     * @return the number of days
     */
    public long calculateTimeToBirth(Date currentDate, Date birthDate) {
        java.util.Date date1 = new java.util.Date(currentDate.getDay(),
                currentDate.getMonth().getMonthIndex(), currentDate.getYear());
        java.util.Date date2 = null;
        if(currentDate.getMonth().getMonthIndex() <
                birthDate.getMonth().getMonthIndex())
        {
            date2 = new java.util.Date(birthDate.getDay(),
                    birthDate.getMonth().getMonthIndex(), currentDate.getYear());
        }
        else {
            date2 = new java.util.Date(birthDate.getDay(),
                    birthDate.getMonth().getMonthIndex(), currentDate.getYear()+1);
        }

        long difference = Math.abs(date1.getTime() - date2.getTime());
        return difference/(24 * 60 * 60 * 1000);
    }

    /**
     * this method analyzes the string of full name and fills the name, surname and patronymic
     * @param name
     */
    public void setName(String name) {
        StringBuilder builder = new StringBuilder(name);
        name = builder.substring(0, builder.indexOf(" "));
        builder.delete(0, builder.indexOf(" ")+1);
        surname = builder.substring(0, builder.indexOf(" "));
        builder.delete(0, builder.indexOf(" ")+1);
        patronymic = builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" "+surname).append(" "+patronymic).append("\n"+ phone)
                .append("\ncurrent date: "+currentDate).append("\ndate of birth: "+birthDate + "\n")
                .append(calculateTimeToBirth(currentDate, birthDate) + " left!");
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
