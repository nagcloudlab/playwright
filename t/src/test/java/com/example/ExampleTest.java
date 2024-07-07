package com.example;


import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ExampleTest extends BaseTest {
    private static final String[] TODO_ITEMS = {
            "buy some cheese",
            "feed the cat",
            "book a doctors appointment"
    };

    @BeforeEach
    public void navigateToPage() {
        page.navigate("https://demo.playwright.dev/todomvc");
    }

    @Test
    public void shouldAllowMeToAddTodoItems() {
        
        Locator newTodo = page.getByPlaceholder("What needs to be done?");

        newTodo.fill(TODO_ITEMS[0]);
        newTodo.press("Enter");
        assertThat(page.getByTestId("todo-title")).hasText(TODO_ITEMS[0]);

        newTodo.fill(TODO_ITEMS[1]);
        newTodo.press("Enter");
        newTodo.fill(TODO_ITEMS[2]);
        newTodo.press("Enter");
        assertThat(page.getByTestId("todo-title")).hasText(TODO_ITEMS);

        checkNumberOfTodosInLocalStorage(3);
    }

    @Test
    public void shouldClearTextInputFieldWhenAnItemIsAdded() {
        Locator newTodo = page.getByPlaceholder("What needs to be done?");

        newTodo.fill(TODO_ITEMS[0]);
        newTodo.press("Enter");
        assertThat(newTodo).isEmpty();
        checkNumberOfTodosInLocalStorage(1);
    }

    @Test
    public void shouldAppendNewItemsToTheBottomOfTheList() {
        createDefaultTodos();

        Locator todoCount = page.getByTestId("todo-count");

        assertThat(page.getByText("3 items left")).isVisible();
        assertThat(todoCount).hasText("3 items left");
        assertThat(todoCount).containsText("3");
        assertThat(todoCount).hasText("3 items left");

        assertThat(page.getByTestId("todo-title")).hasText(TODO_ITEMS);
        checkNumberOfTodosInLocalStorage(3);
    }

    @Test
    public void shouldAllowMeToMarkItemsAsComplete() {
        Locator newTodo = page.getByPlaceholder("What needs to be done?");

        for (String item : TODO_ITEMS) {
            newTodo.fill(item);
            newTodo.press("Enter");
        }

        Locator firstTodo = page.getByTestId("todo-item").nth(0);
        firstTodo.getByRole(AriaRole.CHECKBOX).check();
        assertThat(firstTodo).hasClass("completed");

        Locator secondTodo = page.getByTestId("todo-item").nth(1);
        assertThat(secondTodo).not().hasClass("completed");
        secondTodo.getByRole(AriaRole.CHECKBOX).check();

        assertThat(firstTodo).hasClass("completed");
        assertThat(secondTodo).hasClass("completed");
    }

    @Test
    public void shouldAllowMeToUnmarkItemsAsComplete() {
        Locator newTodo = page.getByPlaceholder("What needs to be done?");

        for (String item : TODO_ITEMS) {
            newTodo.fill(item);
            newTodo.press("Enter");
        }

        Locator firstTodo = page.getByTestId("todo-item").nth(0);
        Locator secondTodo = page.getByTestId("todo-item").nth(1);
        Locator firstTodoCheckbox = firstTodo.getByRole(AriaRole.CHECKBOX);

        firstTodoCheckbox.check();
        assertThat(firstTodo).hasClass("completed");
        assertThat(secondTodo).not().hasClass("completed");
        checkNumberOfCompletedTodosInLocalStorage(1);

        firstTodoCheckbox.uncheck();
        assertThat(firstTodo).not().hasClass("completed");
        assertThat(secondTodo).not().hasClass("completed");
        checkNumberOfCompletedTodosInLocalStorage(0);
    }

    @Test
    public void shouldAllowMeToEditAnItem() {
        createDefaultTodos();

        Locator todoItems = page.getByTestId("todo-item");
        Locator secondTodo = todoItems.nth(1);
        secondTodo.dblclick();
        assertThat(secondTodo.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Edit"))).hasValue(TODO_ITEMS[1]);
        secondTodo.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Edit")).fill("buy some sausages");
        secondTodo.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Edit")).press("Enter");

        assertThat(todoItems).hasText(new String[]{TODO_ITEMS[0], "buy some sausages", TODO_ITEMS[2]});
        checkTodosInLocalStorage("buy some sausages");
    }

    private void createDefaultTodos() {
        Locator newTodo = page.getByPlaceholder("What needs to be done?");
        for (String item : TODO_ITEMS) {
            newTodo.fill(item);
            newTodo.press("Enter");
        }
    }

    private void checkNumberOfTodosInLocalStorage(int expected) {
        page.waitForFunction("e => JSON.parse(localStorage['react-todos']).length === e", expected);
    }

    private void checkNumberOfCompletedTodosInLocalStorage(int expected) {
        page.waitForFunction("e => JSON.parse(localStorage['react-todos']).filter(todo => todo.completed).length === e", expected);
    }

    private void checkTodosInLocalStorage(String title) {
        page.waitForFunction("t => JSON.parse(localStorage['react-todos']).map(todo => todo.title).includes(t)", title);
    }
}
