package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void punchIn_setStartTime() {
        Employee test = new Employee(1, "Test", "TestDepartment", 20f);

        test.punchIn(10);
        double result = test.getStartTime();

        assertEquals(10, result);
    }

    @Test
    void punchOut_hoursWorkedUpdated() {
        Employee test = new Employee(1, "Test", "TestDepartment", 20f);
        test.punchIn(10);

        test.punchOut(12);
        float result = test.getHoursWorked();

        assertEquals(2, result);
    }
}