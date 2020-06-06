class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return people;
        }
        
        // sort
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });
        
        // place each person
        List<int[]> result = new LinkedList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        
        return result.toArray(new int[people.length][2]);
    }
}
