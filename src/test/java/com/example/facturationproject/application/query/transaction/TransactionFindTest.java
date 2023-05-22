package com.example.facturationproject.application.query.transaction;

import com.example.facturationproject.application.Auth.AuthService;
import com.example.facturationproject.domain.Sale.Sale;
import com.example.facturationproject.domain.transaction.Transaction;
import com.example.facturationproject.domain.transaction.TransactionRepository;
import com.example.facturationproject.domain.user.User;
import com.example.facturationproject.infrastructure.Dto.transaction.TransactionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransactionFindTest {

    private TransactionFind transactionFind;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AuthService authService;


    @BeforeEach
    void setUp() {
        transactionFind = new TransactionFind(transactionRepository,authService);
    }
    @Test
    void findAll() {
        Long id = 1L;
        User user = new User();
        user.setId(id);
        user.setName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setCreateAt(LocalDateTime.now());

        Sale sale = new Sale();
        sale.setId(id);
        sale.setPrice(100d);
        sale.setDescription("buy something");
        sale.setUser(user);
        sale.setCreateAt(LocalDateTime.now());

        Transaction transaction = new Transaction();
        transaction.setId(id);
        transaction.setAmount(100d);
        transaction.setDescription("pay something");
        transaction.setCreatedAt(LocalDateTime.now());
        transaction.setSale(sale);
        transaction.setUser(user);

        Transaction transaction2 = new Transaction();
        transaction2.setId(2L);
        transaction2.setAmount(200d);
        transaction2.setDescription("pay something");
        transaction2.setCreatedAt(LocalDateTime.now());
        transaction2.setSale(sale);
        transaction2.setUser(user);

        List<Transaction> transactions = List.of(transaction,transaction2);

        Mockito.when(authService.getIdCurrentLoggedUser()).thenReturn(user);
        Mockito.when(transactionRepository.findAllBySaleIdAndUserId(sale.getId(), user.getId())).thenReturn(Optional.of(transactions));
        List<TransactionResponse> transactionResponses = transactionFind.findAll(sale.getId());

        Mockito.verify(transactionRepository,Mockito.times(1)).findAllBySaleIdAndUserId(sale.getId(), user.getId());

        assertEquals(2,transactionResponses.size());
        assertEquals(id,transactionResponses.get(0).id());
        assertEquals(2L,transactionResponses.get(1).id());
        assertEquals(100d,transactionResponses.get(0).amount());
        assertEquals(200d,transactionResponses.get(1).amount());

    }
}