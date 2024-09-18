import entities.Member;
import participant.ParticipantsPerTeam;
import participantPerSport.GenderCount;
import participantPerSport.ParticipantsPerSport;
import persistence.Database;
import persistence.MemberMapper;

import java.util.List;

public class Main {

    private final static String USER = "postgres";
    private final static String PASSWORD = "postgres";
    private final static String URL = "jdbc:postgresql://localhost:5432/sportsclub";

    public static void main(String[] args) {

        Database db = new Database(USER, PASSWORD, URL);
        MemberMapper memberMapper = new MemberMapper(db);
        List<Member> members = memberMapper.getAllMembers();
        List<ParticipantsPerTeam> participantsPerTeams = memberMapper.participantsPerTeam();
        List<ParticipantsPerSport> participantsPerSports = memberMapper.participantsPerSport();
        List<GenderCount> genderCounts = memberMapper.getGenderCount();
        int teamIncomes = memberMapper.getTotalIncome();




        showMembers(members);
        showMemberById(memberMapper, 13);
        showParticipantsPerTeam(participantsPerTeams);
        showParticipantsPerSport(participantsPerSports);
        showGenderCount(genderCounts);




        /*  
            int newMemberId = insertMember(memberMapper);
            deleteMember(newMemberId, memberMapper);
            showMembers(members);
            updateMember(13, memberMapper);
        */
    }

    private static void deleteMember(int memberId, MemberMapper memberMapper) {
        if (memberMapper.deleteMember(memberId)){
            System.out.println("Member with id = " + memberId + " is removed from DB");
        }
    }

    private static int insertMember(MemberMapper memberMapper) {
        Member m1 = new Member("Ole Olsen", "Banegade 2", 3700, "Rønne", "m", 1967);
        Member m2 = memberMapper.insertMember(m1);
        showMemberById(memberMapper, m2.getMemberId());
        return m2.getMemberId();
    }

    private static void updateMember(int memberId, MemberMapper memberMapper) {
        Member m1 = memberMapper.getMemberById(memberId);
        m1.setYear(1970);
        if(memberMapper.updateMember(m1)){
            showMemberById(memberMapper, memberId);
        }
    }

    private static void showMemberById(MemberMapper memberMapper, int memberId) {
        System.out.println("***** Vis medlem nr. 13: *******");
        System.out.println(memberMapper.getMemberById(memberId).toString());
    }

    private static void showMembers(List<Member> members) {
        System.out.println("***** Vis alle medlemmer *******");
        for (Member member : members) {
            System.out.println(member.toString());
        }
    }

    public static void showParticipantsPerTeam(List<ParticipantsPerTeam> participantPerTeam){
        System.out.println("***** Vis participants per team ******");
        for (ParticipantsPerTeam participantsPerTeam1 : participantPerTeam) {
            System.out.println(participantsPerTeam1.toString());
        }
    }

    public static void showParticipantsPerSport(List<ParticipantsPerSport> participantsPerSport){
        System.out.println("***** Vis participants per sport ******");
        for (ParticipantsPerSport participantsPerSport1 : participantsPerSport) {
            System.out.println(participantsPerSport1.toString());
        }
    }

    public static void showGenderCount(List<GenderCount> genderCounts){
        System.out.println("***** Vis participants per genders ******");
        for (GenderCount genderCount1 : genderCounts) {
            System.out.println(genderCount1.toString());
        }

    }
    public static void showTotalIncome (){
        System.out.println("***** Vis Team Total price ******");


    }
}
