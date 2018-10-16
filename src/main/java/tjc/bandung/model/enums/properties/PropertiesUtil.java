package tjc.bandung.model.enums.properties;
/**
 * Project Name : e-ideas-service
 * File Name : PropertiesUtil.java
 * Created By : Lukman Hakim (lukman@ecquaria.com)
 * Description :
 * Created Date : Nov 1, 2016
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Kornelius
 *
 */
public class PropertiesUtil {
	//Sample ArrayList
    private final List<String> servers = new ArrayList<String>();
    
    
    //Sample String
    private String host;
    
    //Sample Map
    private final Map<String, String> users = new ConcurrentHashMap<String, String>();
    
    //Sample Map
    private Map<String, String> activity = new ConcurrentHashMap<String, String>();

    private Map<String, String> message = new ConcurrentHashMap<String, String>();
    
    /**
     * @return
     */
    public Map<String, String> getUsers() {
        return this.users;
    }
    
    /**
     * @return
     */
    public List<String> getServers() {
        return this.servers;
    }


	/**
	 * @return
	 */
	public String getHost() {
		return this.host;
	}


	/**
	 * @return
	 */
	public Map<String, String> getMessage() {
		return message;
	}


	/**
	 * @param message
	 */
	public void setMessage(final Map<String, String> message) {
		this.message = message;
	}


	/**
	 * @return
	 */
	public Map<String, String> getActivity() {
		return activity;
	}


	/**
	 * @param activity
	 */
	public void setActivity(final Map<String, String> activity) {
		this.activity = activity;
	}


	 
    
}
