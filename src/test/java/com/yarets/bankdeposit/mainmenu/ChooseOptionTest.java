package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.deposit.DefaultDeposit;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.*;

import static org.junit.jupiter.api.Assertions.*;

class ChooseOptionTest {

    @Mock
    private DefaultDeposit defaultDeposit;

    @Mock
    private List<DefaultDeposit> testListDeposit;

    @Before
    public  void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoCommand() {
    }

}