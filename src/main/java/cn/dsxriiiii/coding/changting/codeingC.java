package cn.dsxriiiii.coding.changting;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.coding.changting
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/11 19:47
 * @Description:
 **/
public class codeingC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tasks = scanner.nextLine().split(" ");
        int numSubtasks = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> subtaskMap = new HashMap<>();
        for (int i = 0; i < numSubtasks; i++) {
            String[] taskAndSubtasks = scanner.nextLine().split(" ");
            String parentTask = taskAndSubtasks[0];
            List<String> subtasks = new ArrayList<>();
            for (int j = 1; j < taskAndSubtasks.length; j++) {
                subtasks.add(taskAndSubtasks[j]);
            }
            subtaskMap.put(parentTask, subtasks);
        }
        String[] executeTasks = scanner.nextLine().split(" ");
        String[] skipTasks = scanner.nextLine().split(" ");
        Map<String, Boolean> taskExecutionStatus = new HashMap<>();
        for (String task : tasks) {
            taskExecutionStatus.put(task, false);
        }
        Set<String> executedTasks = new HashSet<>();
        for (String task : executeTasks) {
            markParentsAsExecuted(task, subtaskMap, taskExecutionStatus, executedTasks);
            taskExecutionStatus.put(task, true);
            executedTasks.add(task);
        }
        for (String task : skipTasks) {
            markChildrenAsSkipped(task, subtaskMap, taskExecutionStatus);
        }
        List<String> actualExecutionList = new ArrayList<>();
        for (String task : tasks) {
            if (taskExecutionStatus.get(task)) {
                actualExecutionList.add(task);
                if (subtaskMap.containsKey(task)) {
                    actualExecutionList.addAll(subtaskMap.get(task));
                }
            }
        }
        for (String task : actualExecutionList) {
            System.out.print(task + " ");
        }
        scanner.close();
    }

    private static void markParentsAsExecuted(String task, Map<String, List<String>> subtaskMap,
                                              Map<String, Boolean> taskExecutionStatus, Set<String> executedTasks) {
        if (!executedTasks.contains(task)) {
            if (subtaskMap.containsKey(task)) {
                for (String parentTask : subtaskMap.get(task)) {
                    markParentsAsExecuted(parentTask, subtaskMap, taskExecutionStatus, executedTasks);
                }
            }
            taskExecutionStatus.put(task, true);
            executedTasks.add(task);
        }
    }

    private static void markChildrenAsSkipped(String task, Map<String, List<String>> subtaskMap,
                                              Map<String, Boolean> taskExecutionStatus) {
        taskExecutionStatus.put(task, false);
        if (subtaskMap.containsKey(task)) {
            List<String> childrenTasks = subtaskMap.get(task);
            for (String childTask : childrenTasks) {
                markChildrenAsSkipped(childTask, subtaskMap, taskExecutionStatus);
            }
        }
    }
}
