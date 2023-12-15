package election;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import election.candidate.Candidate;

public class ElectionTest {
	@Test
	public void noVotes() {
		Candidate candidate0 = Candidate.values()[0];
		assertEquals(candidate0, new Election().getWinner());
	}

	@ParameterizedTest
	@CsvSource(textBlock = """
		JACK, 1
		JILL, 1
		SAM,  1
		MAX,  1
		JACK, 2
		JILL, 100
	""")
	public void singleCandidate(Candidate candidate, int voteCount) {
		Election election = new Election();
		election.addVotes(candidate, voteCount);
		assertEquals(candidate, election.getWinner());
	}

	@ParameterizedTest
	@CsvSource(textBlock = """
		JACK, JILL, 10
		JILL, SAM,  20
		SAM,  MAX,  30
		JACK, SAM,  100
		JILL, MAX,  42
		JACK, MAX,  5
	""")
	public void twoCandidatesSameVoteCount(Candidate c1, Candidate c2, int voteCount) {
		Candidate expected = c1.ordinal() < c2.ordinal() ? c1 : c2;

		Election election = new Election();
		election.addVotes(c1, voteCount);
		election.addVotes(c2, voteCount);
		assertEquals(expected, election.getWinner());

		Election election2 = new Election();
        election2.addVotes(c2, voteCount);
        election2.addVotes(c1, voteCount);
		assertEquals(expected, election2.getWinner());
	}


    @Test
    public void candidateVoteCount() {
        Election election = new Election();
        election.addVotes(Candidate.JACK, 1);
        election.addVotes(Candidate.JILL, 4);
        election.addVotes(Candidate.SAM, 3);
        election.addVotes(Candidate.MAX, 2);

        assertArrayEquals(new Candidate[] {
            Candidate.JACK,
            Candidate.JILL,
            Candidate.SAM,
            Candidate.MAX
        }, election.getCandidatesWithMoreVotesThan(0));

        assertArrayEquals(new Candidate[] {
            Candidate.JILL,
            Candidate.SAM,
            Candidate.MAX
        }, election.getCandidatesWithMoreVotesThan(1));

        assertArrayEquals(new Candidate[] {
            Candidate.JILL,
            Candidate.SAM
        }, election.getCandidatesWithMoreVotesThan(2));

        assertArrayEquals(new Candidate[] {
            Candidate.JILL
        }, election.getCandidatesWithMoreVotesThan(3));

        assertArrayEquals(new Candidate[0], election.getCandidatesWithMoreVotesThan(4));
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        0, 'JACK,JILL,SAM,MAX'
        1, 'JILL,SAM,MAX'
        2, 'JILL,SAM'
        3, 'JILL'
        4, ''
    """)
    public void candidateVoteCountAdvanced(int voteCount, String expectedCandidateNamesTxt) {
        Election election = new Election();
        election.addVotes(Candidate.JACK, 1);
        election.addVotes(Candidate.JILL, 4);
        election.addVotes(Candidate.SAM, 3);
        election.addVotes(Candidate.MAX, 2);

        Candidate[] expectedCandidates = makeCandidateNames(expectedCandidateNamesTxt);
        assertArrayEquals(expectedCandidates, election.getCandidatesWithMoreVotesThan(voteCount));
    }

    private Candidate[] makeCandidateNames(String expectedCandidateNamesTxt) {
        if (expectedCandidateNamesTxt.isEmpty())  return new Candidate[0];

        String[] expectedCandidateNames = expectedCandidateNamesTxt.split(",");
        Candidate[] retval = new Candidate[expectedCandidateNames.length];
        for (int i = 0; i < retval.length; i++) {
            retval[i] = Candidate.valueOf(expectedCandidateNames[i]);
        }
        return retval;
    }
}
