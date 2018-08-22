package todolist;



import org.junit.Test;

import todolist.Todotask.BaseTest;

public class TestTaskAdd extends BestTest {

    /**
     * Secnario: Add Task
     * Test Case # 1. Verify a task can be added without any categories or due date
     * @throws InterruptedException
     */
    @Test
    public void testAddTaskWOCatAndDueDate() throws InterruptedException {
        String taskName = StringUtility.generateRandomSentence();
        getToDoApp() .typeTaskName(taskName)
                .clickAdd()
                .verifyTaskNameIsInList(taskName);
    }
}