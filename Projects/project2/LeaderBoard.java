public class LeaderBoard {
    protected Contestant[] leaderBoard;
    private int index;

    LeaderBoard(int M) {
        leaderBoard = new Contestant[M];
        index = 0;
    }

    void add(Contestant C) {
        if (index == 0) {
            leaderBoard[index] = C;
            ++index;
        } else if (index < leaderBoard.length) {
            for (int i = 0; i < index; ++i) {
                if (leaderBoard[i].compareTo(C) <= 0) {
                    for (int j = index; j > i; --j) {
                        leaderBoard[j] = leaderBoard[j - 1];
                    }
                    leaderBoard[i] = C;
                    ++index;
                    return;
                }
            }
            leaderBoard[index] = C;
            ++index;
        } else {
            System.out.println("Appending to leaderboard failed because it is full.");
        }
    }

    Contestant[] finalBoard() {
        return leaderBoard;
    }
}
