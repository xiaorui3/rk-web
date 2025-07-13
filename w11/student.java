package w11;

import java.util.Objects;

public class student {
    private String name;
    private int birthday_year;
    private int birthday_month;
    private int birthday_day;
    private int Serial_No;
    public int getSerial_No() {
        return Serial_No;
    }
    public void setSerial_No(int serial_No) {
        Serial_No = serial_No;
    }
    public student() {
    }

    public student(String name, int birthday_year, int birthday_month, int birthday_day) {
        this.name = name;
        this.birthday_year = birthday_year;
        this.birthday_month = birthday_month;
        this.birthday_day = birthday_day;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return birthday_year
     */
    public int getBirthday_year() {
        return birthday_year;
    }

    /**
     * 设置
     * @param birthday_year
     */
    public void setBirthday_year(int birthday_year) {
        this.birthday_year = birthday_year;
    }

    /**
     * 获取
     * @return birthday_month
     */
    public int getBirthday_month() {
        return birthday_month;
    }

    /**
     * 设置
     * @param birthday_month
     */
    public void setBirthday_month(int birthday_month) {
        this.birthday_month = birthday_month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return birthday_year == student.birthday_year && birthday_month ==
                student.birthday_month && birthday_day == student.birthday_day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday_year, birthday_month, birthday_day);
    }

    /**
     * 获取
     * @return birthday_day
     */
    public int getBirthday_day() {
        return birthday_day;
    }

    /**
     * 设置
     * @param birthday_day
     */
    public void setBirthday_day(int birthday_day) {
        this.birthday_day = birthday_day;
    }

    public String toString() {
        return "student{name = " + name + ", birthday_year = " + birthday_year + ", birthday_month = " + birthday_month + ", birthday_day = " + birthday_day + "}";
    }
}
