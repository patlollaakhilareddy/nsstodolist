package todolist;

import org.junit.Test;

public class Modifytask extends BestTest{

	 @Test
	    public void testModifyTask() throws InterruptedException {
	        String taskName = StringUtility.generateRandomSentence();
	       getToDoApp()
	               .clickTaskId()
	                .typeUpdateTaskName(taskName)
	              .clickUpdate()
                .verifyTaskNameIsInList(taskName);
}
}