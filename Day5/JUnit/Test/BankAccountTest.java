package org.test.example;
import org.example.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BankAccountTest {
    private BankAccount account;
    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }
    @Test
    void testDeposit() {
        account.deposit(1000.0);
        assertEquals(1000.0, account.getBalance());
    }
    @Test
    void testWithdraw() {
        account.deposit(2000.0);
        account.withdraw(500.0);
        assertEquals(1500.0, account.getBalance());
    }
    @Test
    void testWithdrawInsufficientFunds() {
        account.deposit(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
    }
    @Test
    void testInitialBalance() {
        assertEquals(0.0, account.getBalance());
    }
    @Test
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0));
    }
}
