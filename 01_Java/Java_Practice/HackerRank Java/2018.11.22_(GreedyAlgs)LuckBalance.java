static int luckBalance(int k, int[][] contests) {
        int total = 0;
        List<Integer> importantContests = new ArrayList<>();
        for (int i=0; i<contests.length; i++){
            int luck = contests[i][0];
            int importance = contests[i][1];
            total += luck;
            if (importance == 1) {
                importantContests.add(luck);
            }
        }
        Collections.sort(importantContests);
        int luckLost = 0;
        int numImportantContestsToWin = importantContests.size() - k;
        //we will lose the last k contests which should have the smallest luck cost associated with them
        for (int i=0; i<numImportantContestsToWin; i++){
            luckLost += importantContests.get(i);
        }
        //we added the luck to total in the begining
        //in order to see the total luck remaining we actually need to subtract twice
        int result = total - 2*luckLost;
        return result;
    }