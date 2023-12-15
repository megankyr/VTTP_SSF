package vttp.ssf.assessment.eventmanagement.models;

public class Event {

    private int eventId;
    private String eventName;
    private int eventSize;
    private long eventDate;
    private int participants;
    private int index;
    
    public Event() {
    }
    public Event(int eventId, String eventName, int eventSize, long eventDate, int participants) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventSize = eventSize;
        this.eventDate = eventDate;
        this.participants = participants;
    }
    public Event(int eventId, String eventName, int eventSize, long eventDate, int participants, int index) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventSize = eventSize;
        this.eventDate = eventDate;
        this.participants = participants;
        this.index = index;
    }
    public int getEventId() {
        return eventId;
    }
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public int getEventSize() {
        return eventSize;
    }
    public void setEventSize(int eventSize) {
        this.eventSize = eventSize;
    }
    public long getEventDate() {
        return eventDate;
    }
    public void setEventDate(long eventDate) {
        this.eventDate = eventDate;
    }
    public int getParticipants() {
        return participants;
    }
    public void setParticipants(int participants) {
        this.participants = participants;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

}
