package vttp.ssf.assessment.eventmanagement.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Repository
public class RedisRepository {

	@Autowired
	@Qualifier("redis")

	private RedisTemplate<String, Object> template;

	public void saveRecord(Event event){
		String key = event.getEventName();
		template.opsForValue().set(key, event);
		
	}

	public long getNumberOfEvents(){
		long size = template.opsForValue().size("event");
		return size;
	}

	public Event getEvent(Integer index){
		Event event = template.opsForValue().get
	}

	//copy




	// TODO: Task 3


	// TODO: Task 4
}
