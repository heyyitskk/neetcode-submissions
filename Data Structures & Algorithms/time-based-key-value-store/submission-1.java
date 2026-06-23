
class TimeMap {

    private class TimeValue {
        String value;
        int timestamp;
        TimeValue(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<TimeValue>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<TimeValue> list = map.get(key);
        int l = 0, r = list.size() - 1;
        String result = "";
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(list.get(mid).timestamp <= timestamp){
                result = list.get(mid).value;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return result;
    }
}
