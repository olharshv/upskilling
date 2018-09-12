package com.luxoft.dbdc.upskilling.implementations;

import com.luxoft.dbcd.upskilling.implementations.TodoListItemImpl;
import org.junit.jupiter.api.*;

class TodoListItemImplTest {

    protected TodoListItemImpl todoItem;
    protected String title;

    @BeforeAll
    public static void setUpGlobal() {

    }

    @BeforeEach
    public void setUp (){
        title = "Todo List Item for test: ";
        todoItem = new TodoListItemImpl(title);
    }

    @Test
    public void todoItemIsNotNullAfterCreation() {

        Assertions.assertTrue(title.equalsIgnoreCase(todoItem.getTitle()));
    }

    @AfterEach
    public void tearDown() {

    }

    @AfterAll
    public static void tearDownGlobal() {

    }

}