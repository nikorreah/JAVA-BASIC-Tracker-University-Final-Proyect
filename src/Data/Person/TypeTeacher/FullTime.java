package Data.Person.TypeTeacher;

import Data.Person.Teacher;

public class FullTime extends Teacher {
    private float experience;

    public FullTime(String name, float experience) {
        super(name);
        this.experience = experience;
    }



    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    @Override
    public float teacherSalary() {
        float salary = baseSalary* experience * 1.1f;
        return salary;
    }

    @Override
    public float teacherSalary(float getBaseSalary) {
        return 0;
    }


}
