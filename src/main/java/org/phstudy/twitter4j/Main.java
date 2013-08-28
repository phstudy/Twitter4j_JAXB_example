package org.phstudy.twitter4j;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import Model.TwitterJob;

public class Main {

	public static void main(String[] args) throws TwitterException, JAXBException {

		String latestStatus = "twitter4j test2";
		Twitter twitter = TwitterFactory.getSingleton();
		Status status = twitter.updateStatus(latestStatus);

		TwitterJob twitterJob = new TwitterJob();
		List<Status> list = new ArrayList<Status>();
		list.add(status);
		twitterJob.setStatuses(list);

		JAXBContext jc = JAXBContext.newInstance(TwitterJob.class);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(twitterJob, System.out);

		System.out.println("Successfully updated the status to [" + status.getText() + "].");
	}
}
