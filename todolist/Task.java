package todolist;

public class Task {

	private int taskId;
	private String taskName;
	private String taskCategory = null;
	private String dueDate = null;
	
	public void setTaskId(int id) {
		taskId = id;
	}
	
	public int getTaskId() {
		return taskId;
	}
	
	public void setTaskName(String name) {
		taskName = name;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public void setTaskCategory(String category) {
		taskCategory = category;
	}
	
	public String getTaskCategory() {
		return taskCategory;
	}
	
	public void setDueDate(String date) {
		dueDate = date;
	}
	
	public String getDueDate() {
		return dueDate;
	}
}
