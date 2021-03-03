class Logger {

    /** Initialize your data structure here. */
    HashMap<String,Integer> loggerMessageEarliestTimeStamp;
    int globalTimeStamp = 0;
    public Logger() {
        loggerMessageEarliestTimeStamp = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        globalTimeStamp = Math.max(timestamp, globalTimeStamp);
        boolean result = true;
        
        if(!loggerMessageEarliestTimeStamp.containsKey(message)) {
            loggerMessageEarliestTimeStamp.put(message,globalTimeStamp);
            
        }
        else {
            int lastEntryTimeStamp = loggerMessageEarliestTimeStamp.get(message);
            if(globalTimeStamp - lastEntryTimeStamp >= 10) {
                loggerMessageEarliestTimeStamp.put(message, globalTimeStamp);
                result = true;
            }
            else{
                result = false;
            }
        }
        return result;
    }
}

/**

map with message and start timestamp
whenever entry is made to the map ofcourse true
if it exists see global timer and beginning time and then update it with global
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
