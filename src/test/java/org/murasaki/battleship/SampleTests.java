package org.murasaki.battleship;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SampleTests
{
    @Test
    void testNormalJunit() {
        assertEquals(5, 5);
    }
    @Test
    void testWithApprovalTests() {
        Approvals.verify("Hello World");
    }

}
