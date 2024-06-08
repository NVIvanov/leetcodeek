import java.util.*;

public class FindAllPeopleWithSecret {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Set<Integer> result = new HashSet<>();
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[2]));
        result.add(0);
        result.add(firstPerson);
        int i = 0;
        int meetingTime = meetings[0][2];
        int previousMeetingTime = meetingTime;
        List<int[]> meetingMembers = new ArrayList<>();
        while (i < meetings.length) {
            while (previousMeetingTime == meetingTime) {
                if (i < meetings.length) {
                    if (result.contains(meetings[i][0])) {
                        result.add(meetings[i][1]);
                    } else if (result.contains(meetings[i][1])) {
                        result.add(meetings[i][0]);
                    } else {
                        meetingMembers.add(meetings[i]);
                    }
                    i++;
                }
                if (i < meetings.length) {
                    meetingTime = meetings[i][2];
                } else {
                    meetingTime = -1;
                }
            }
            while (!meetingMembers.isEmpty()) {
                int j = 0;
                boolean metSomething = false;
                while (j < meetingMembers.size()) {
                    if (result.contains(meetingMembers.get(j)[0])) {
                        result.add(meetingMembers.get(j)[1]);
                        metSomething = true;
                        meetingMembers.remove(j);
                    } else if (result.contains(meetingMembers.get(j)[1])) {
                        result.add(meetingMembers.get(j)[0]);
                        metSomething = true;
                        meetingMembers.remove(j);
                    } else {
                        j++;
                    }
                }
                if (!metSomething) {
                    break;
                }
            }
            meetingMembers.clear();
            if (i < meetings.length) {
                previousMeetingTime = meetingTime;
                meetingTime = meetings[i][2];
            }
        }
        return result.stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(new FindAllPeopleWithSecret().findAllPeople(5,
                new int[][]{
                        {1,4,3},
                        {0,4,3}
                }, 3));
    }
}
