package InterviewCakeProblems;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 *
 * Your company built an in-house calendar tool called HiCal.
 * You want to add a feature to see the times in a day when everyone is available.
 * To do this, you’ll need to know when any team is having a meeting.
 * In HiCal, a meeting is stored as an object of a Meeting class with
 * integer variables startTime and endTime.
 * These integers represent the number of 30-minute blocks past 9:00am.
 */
public class MeetingMerger {

	public List<Meeting> mergeMeetings(List<Meeting> meetings) {
		if (meetings.size() <= 1) {
			return meetings;
		}

		List<Meeting> mergedMeetings = new LinkedList<Meeting>();

		class MeetingComparator implements Comparator<Meeting> {
			@Override
			public int compare(Meeting m1, Meeting m2) {
				if (m2.startTime == m1.startTime) {
					return m1.endTime - m2.endTime;
				}
				return m1.startTime - m2.startTime;
			}
		}

		Collections.sort(meetings, new MeetingComparator());

		int start = meetings.get(0).startTime;
		int end  = meetings.get(0).endTime;
		for (int i = 1; i < meetings.size(); i++) {
			if (meetings.get(i).startTime > end) {
				// new distinct time found
				mergedMeetings.add(new Meeting(start, end));
				start = meetings.get(i).startTime;
				end = meetings.get(i).endTime;
			}
			else {
				end = Math.max(end, meetings.get(i).endTime);
			}
		}

		mergedMeetings.add(new Meeting(start, end));
		return mergedMeetings;
	}

	public static void main(String[] args) {
		List<Meeting> l = new LinkedList<Meeting>();
		l.add(new Meeting(0, 1));
		l.add(new Meeting(3, 5));
		l.add(new Meeting(4, 8));
		l.add(new Meeting(5,7));
		l.add(new Meeting(10, 12));
		l.add(new Meeting(9, 10));

		MeetingMerger m = new MeetingMerger();
		List<Meeting> answer = m.mergeMeetings(l);
		Iterator<Meeting> i = answer.iterator();
		while (i.hasNext()) {
			System.out.println(i.next().toString());
		}
	}

}
