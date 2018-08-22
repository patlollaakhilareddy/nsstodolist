package todolist;



import org.junit.Test;

import todolist.Todotask.BaseTest;

public class TestTaskDelete extends BestTest{
    /**
     *
     * @throws InterruptedException
     */
    @Test
    public void testDeleteAllTasks() throws InterruptedException {
        getToDoApp()
                .clickSelectAllCheckbox()
                .clickRemove()
                .verifyAllTasksDeleted();
    }
}