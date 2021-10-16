package Data.Person.TypeTeacher;

import Data.Person.Teacher;

public class PartTime extends Teacher {
    private float hoursPerWeek;

    public PartTime(String name, float hoursPerWeek) {
        super(name);
        this.hoursPerWeek= hoursPerWeek;
    }

    public PartTime(float baseSalary) {
        super(baseSalary);
    }


    public float getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(float hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public float teacherSalary() {
        float salary = getBaseSalary() * hoursPerWeek;
        return salary;
    }

    @Override
    public float teacherSalary(float getBaseSalary) {
        return 0;
    }


}
