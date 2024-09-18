package participantPerSport;

public class TeamIncome {
        private int teamId;
        private int totalIncome;

        public TeamIncome(int teamId, int totalIncome) {
            this.teamId = teamId;
            this.totalIncome = totalIncome;
        }

        @Override
        public String toString() {
            return "Team ID: " + teamId + ", Total Income: " + totalIncome;
        }
    }

