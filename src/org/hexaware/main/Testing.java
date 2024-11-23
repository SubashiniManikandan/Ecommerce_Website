package org.hexaware.main;
import org.hexware.dao.*;
import org.junit.jupiter.api.BeforeEach;

public class Testing {
    protected DAO repository;

    @BeforeEach
    public void setUp() {
        repository = new DAO_Imp();
    }
}
