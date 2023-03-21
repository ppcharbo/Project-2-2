package project.multi.agent.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * 
 * 
 * Action <SCHEDULE> * <DAY> Saturday ---> There are no lectures on Saturday
 * 
 * 
 * 
 */

@Rule(name = "No Lecture on saturday", description = "this rules is triggered when is saturday and is type schedule")
public class RuleScheduleOnSaturday {

	@Condition
	public boolean when(@Fact("DAY") String day,@Fact("Schedule") Object schedule) {
//
//		System.out.println("rule triggered when ");
//		System.out.println("1- <SENCENCE> is type  SCHEDULE");
//		System.out.println("2- <DAY> Saturday ");

		if (day.equals("Saturday") && schedule!=null)
			return true;
		else
			return false;
	}

	@Action
	public void result() {
		System.err.println("There are no lectures on Saturday ");
	}

}