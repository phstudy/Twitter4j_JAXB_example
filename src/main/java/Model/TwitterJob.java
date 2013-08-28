package Model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import twitter4j.Status;
import twitter4j.internal.json.StatusJSONImpl;

@XmlRootElement(name = "TwitterJob")
public class TwitterJob implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Status> statuses;

	@XmlElement(type = StatusJSONImpl.class, name = "status")
	public List<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}
}
