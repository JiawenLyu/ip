# User Guide

##Welcome to Duke

Duke is a task manager to help users manage personal tasks, including events, deadlines, and todo tasks.

## Features 

### Add tasks

Add a `event`, `todo`, or `deadline` task to the task list.   

### Finish tasks

You can mark a task as done if you finish this task.

### List all tasks

You can see all the tasks you have currently.

### Delete tasks

You can delete tasks from the tasks you have currently.

### Find tasks 

You can find tasks with certain keywords from all the tasks you have currently.

### Load tasks

When you open Duke, the tasks stored in a local file `duke.txt` will be loaded automatically. If the file does not exist, Duke will create a new local file `duke.txt`.
  
### Save tasks

When you make changes to the tasks list, the changes will be saved into a local file `duke.txt` automatically.

### Exit

You can use `bye` to exit Duke. 

## Usage

### `event` - Add an event task 

Enter `event` task with a description and its date/time to add an event task.

Example of usage: 

`event project meeting /at Mon 2-4 pm`

Expected outcome:

```
 -------------------------------------------
 Got it. I've added this task: 
 [E][✘]project meeting (at: Mon 2-4 pm)
 Now you have 1 tasks in the list
 -------------------------------------------
```

### `todo` - Add a todo task

Enter `todo` task with a description to add a todo task.

Example of usage: 

`todo borrow book`

Expected outcome:

```
-------------------------------------------
Got it. I've added this task: 
[T][✘]borrow book
Now you have 2 tasks in the list
-------------------------------------------
```

### `deadline` - Add a deadline task

Enter a `deadline` task with a description and its due date/time to add a deadline event.

Example of usage: 

`deadline return book /by Sunday`

Expected outcome:

```
-------------------------------------------
 Got it. I've added this task: 
 [D][✘]return book (by: Sunday)
 Now you have 3 tasks in the list
 -------------------------------------------
 ```

### `done` - Mark a task as done

Enter `done` with an index number to mark the task with the index in the tasks list as done.

Example of usage: 

`done 1`

Expected outcome:

```
-------------------------------------------
Nice! I've marked this task as done:
[E][✓]project meeting (at: Mon 2-4 pm)

-------------------------------------------
```

### `list` - List all the tasks

Enter `list` to see all the tasks.

Example of usage: 

`list`

Expected outcome:

```
-------------------------------------------
1. [E][✓]project meeting (at: Mon 2-4 pm)
2. [T][✘]borrow book
3. [D][✘]return book (by: Sunday)

-------------------------------------------
```

### `delete` - Delete a task

Enter `delete` with an index number to delete the task with this index.

Example of usage: 

`delete 2`

Expected outcome:

```
-------------------------------------------
Noted. I've removed this task: 
[T][✘]borrow book
Now you have 2 items in the list.

-------------------------------------------
```

### `find` - Find the tasks with a keyword

Enter `find` with a keyword to see all the tasks that contain this keyword.

Example of usage: 

`find book`

Expected outcome:

```
-------------------------------------------
Here are the matching tasks in your list:
1.[D][✘]return book (by: Sunday)

-------------------------------------------
```

### `bye` - Exit Duke

Enter `bye` command to print goodbye message and exit Duke.

Example of usage: 

`bye`

Expected outcome:

```
-------------------------------------------
Bye. Hope to see you again soon!

-------------------------------------------
```