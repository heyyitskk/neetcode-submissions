class TimeMap {

    private static class TimeValue {
        String value;
        Integer timeStamp;

        TimeValue(String value, int timeStamp){
            this.value = value;
            this.timeStamp = timeStamp;
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
        return binarySearch(list, timestamp);
    }

    private String binarySearch(List<TimeValue> list, int timeStamp){
        int l = 0, r = list.size() - 1;
        String result = "";
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(list.get(mid).timeStamp <= timeStamp){
                l = mid + 1;
                result = list.get(mid).value;
            }
            else{
                r = mid - 1;
            }
        }
        return result;
    }
}
