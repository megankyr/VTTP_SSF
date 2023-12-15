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
		int index = event.getIndex();
		String key = Integer.toString(index);
		template.opsForValue().set(key, event);
		
	}

	public long getNumberOfEvents(){
		long size = template.opsForValue().size("event");
		return size;
	}

	public Event getEvent(Integer index){
		String key = Integer.toString(index);
		Event event = (Event) template.opsForValue().get(key);
		return event;
	}

}
