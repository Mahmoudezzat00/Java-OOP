package election;

import election.candidate.Candidate;

public class Election {
        private int[] voteCounts;

        public Election() {
            int candidateCount = Candidate.values().length; //4
            voteCounts = new int[candidateCount];
        }

        public void addVote(Candidate candidate) { //+1
            addVotes(candidate, 1);
        }

        public void addVotes(Candidate candidate, int count) { //+n
            voteCounts[candidate.ordinal()] += count;
        }
        //how many candidate are there, that have more than n votes
        private int getCandidateCountWithMoreVotesThan(int voteCount) {
            int retval = 0;
            for (int i = 0; i < voteCounts.length;i++) {
                if (voteCounts[i] > voteCount) retval++;
            }
            return retval;
        }

        //return those Candidates that have more than n votes
        public Candidate[] getCandidatesWithMoreVotesThan(int voteCount) {
            int candidateCount = getCandidateCountWithMoreVotesThan(voteCount);

            Candidate[] retval = new Candidate[candidateCount];
            int retvalIdx = 0;
            for (int i = 0; i < voteCounts.length; i++) {
                if (voteCounts[i] <= voteCount ) continue;
                retval[retvalIdx] = Candidate.values()[i];
                ++retvalIdx;
            }
            return retval;

        }

        public Candidate getWinner() {
            return Candidate.values()[getWinningIdx()];
        }

        private int getWinningIdx() {
            int winningIdx = 0;
            for (int i = 0; i < voteCounts.length;i++) {
                if (voteCounts[i] > voteCounts[winningIdx]) {
                    winningIdx = i;
                }
            }
            return winningIdx;
        }

}