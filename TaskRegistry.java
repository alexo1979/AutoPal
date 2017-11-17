import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;
/**
 * class TaskRegistry
 * Keeps all the upcommnig tasks in one place.
 * A registry where you manipulate all the task.
 *
 * @author Aleksandar Dimeski
 * @version 2017/11/08
 */
public class TaskRegistry
{
    // list to keep all the upcomming tasks
    private List<Task> tasks;
    /**
     * Constructor for objects of class TaskRegistry
     */
    public TaskRegistry()
    {
        // initialise as an empty ArrayList of Task
        this.tasks = new ArrayList<>();
    }

    /**
     * Adding individual task in the task list tasks
     *
     * @param  task Individual task 
     */
    public void addTask(Task task)
    {
        this.tasks.add(task);
    }
    
    /**
     * Removes individual task in the task list tasks.
     * 
     * @param  index The index of the task in the list
     */
    public void deleteTask(int index)
    {
        this.tasks.remove(index);
    }
    
    /**
     * Removes individual task in the task list tasks.
     * 
     * @param  index The index of the task in the list
     */
    public List<Task> getTasks()
    {
        return this.tasks;
    }
    
    /**
     * Sorts all tasks by date in the same list
     * 
     */
    public void sortByDate()
    {
        Collections.sort(this.tasks, new Comparator<Task>()
        {
            public int compare(Task task1, Task task2)
            {
                return (int) task1.getTaskDate().compareTo(task2.getTaskDate());
            }
        });
    }
    
    /**
     * Sorts all tasks by vehicle in the same list
     * 
     */
    public void sortByVehicle()
    {
        Collections.sort(this.tasks, new Comparator<Task>()
        {
            public int compare(Task task1, Task task2)
            {
                return (int) task1.getVehicle().getRegNo().
                compareTo(task2.getVehicle().getRegNo());
            }
        });
    }
}
