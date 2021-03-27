/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Integer> empImportance;
    Map<Integer, List<Integer>> subordinates;
    public int getImportance(List<Employee> employees, int id) {
        
        empImportance = new HashMap<>();
        subordinates = new HashMap<>();
        
        preprocess(employees);
        return dfs(id);
        
        
        
        
    }
    
    private int dfs(int id) {
        int sum = 0;
        List<Integer> subs = subordinates.get(id);
        
        for(int empid : subs) {
            sum+=dfs(empid);
        }
        sum+=empImportance.get(id);
        return sum;
    }
    
    private void preprocess(List<Employee> employees) {
        for(Employee employee : employees) {
            empImportance.put(employee.id, employee.importance );
            subordinates.put(employee.id, employee.subordinates);
        }
    }
}

/*
an employee has 1 or 0 leader
run a dfs 

put employees to a map
run a dfs until no subs
two maps
*/
