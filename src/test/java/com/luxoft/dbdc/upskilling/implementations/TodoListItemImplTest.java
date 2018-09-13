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

//    @Test
//    public void toogle_an_item() {
//        item.toggle();
//        Assertions.assertTrue(item.isToggled());
//    }
//
//    @Test
//    public void untoggle_an_item() {
//        item.toggle();
//        item.toggle();
//        Assertions.assertFalse(item.isToggled());
//    }
//
 //   @Test
 //  public void item_is_not_toggled_after_creation() {
//       Assertions.assertFalse(item.isToggled());
//    }
//
//    @Test
//    public void item_have_title() {
//        Assertions.assertEquals("Todo item for test", item.getTitle());
//    }
//
//    @Test
//    public void cannot_create_item_with_empty_title() {
//        Assertions.assertThrows(IllegalArgumentException.class,
//                () -> new TodoListItemImpl(""));
//    }
//
//    @Test
//    public void can_set_new_title() {
//        String new_title = "New title for test item";
//        TodoListItemImpl newItem = item.setTitle(new_title);
//        Assertions.assertEquals(new_title, newItem.getTitle());
//    }
//
//    @Test
//    public void cannot_set_empty_title() {
//        Assertions.assertThrows(IllegalArgumentException.class,
//                () -> item.setTitle(""));
//    }

    @AfterEach
    public void tearDown() {

    }

    @AfterAll
    public static void tearDownGlobal() {

    }

}