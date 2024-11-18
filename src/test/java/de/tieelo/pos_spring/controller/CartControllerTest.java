package de.tieelo.pos_spring.controller;

import de.tieelo.pos_spring.dto.CartItemDTO;
import de.tieelo.pos_spring.entity.Item;
import de.tieelo.pos_spring.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CartControllerTest {

    private CartController cartController;

    @Mock
    private CartService cartService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cartController = new CartController(cartService);
    }

    @Test
    void fillCartTest() {
        int[] idAndAmount = {1, 5};

        ResponseEntity<Void> response = cartController.fillCart(idAndAmount);

        verify(cartService, times(1)).addItemToCart(idAndAmount);
        assertEquals(ResponseEntity.ok().build(), response);
    }

    @Test
    void sellCart_ShouldCallServiceAndReturnOk() {
        ResponseEntity<Void> response = cartController.sellCart();

        verify(cartService, times(1)).checkout();
        assertEquals(ResponseEntity.ok().build(), response);
    }

    @Test
    void getTotalCost_ShouldReturnTotalCost() {
        double expectedTotal = 42.50;
        when(cartService.getTotalCost()).thenReturn(expectedTotal);

        ResponseEntity<Double> response = cartController.getTotalCost();

        verify(cartService, times(1)).getTotalCost();
        assertEquals(ResponseEntity.ok(expectedTotal), response);
    }

    @Test
    void removeItemById_ShouldCallServiceAndReturnOk() {
        int[] idAndAmount = {1, 2};

        ResponseEntity<Void> response = cartController.removeItemById(idAndAmount);

        verify(cartService, times(1)).removeItemFromCart(idAndAmount);
        assertEquals(ResponseEntity.ok().build(), response);
    }

    @Test
    void putCartBackToInventory_ShouldCallServiceAndReturnOk() {
        ResponseEntity<Void> response = cartController.putCartBackToInventory();

        verify(cartService, times(1)).putCartBackToInventory();
        assertEquals(ResponseEntity.ok().build(), response);
    }

    @Test
    void getItemCount_ShouldReturnItemCount() {
        int expectedCount = 5;
        when(cartService.getItemCount()).thenReturn(expectedCount);

        ResponseEntity<Integer> response = cartController.getItemCount();

        verify(cartService, times(1)).getItemCount();
        assertEquals(ResponseEntity.ok(expectedCount), response);
    }

    @Test
    void getItemsInCart_ShouldReturnListOfItems() {
        List<CartItemDTO> expectedItems = new ArrayList<>();
        CartItemDTO item = new CartItemDTO(new Item(),1);
        expectedItems.add(item);
        when(cartService.getItemsFromCart()).thenReturn(expectedItems);

        ResponseEntity<List<CartItemDTO>> response = cartController.getItemsInCart();

        verify(cartService, times(1)).getItemsFromCart();
        assertEquals(ResponseEntity.ok(expectedItems), response);
    }
}
