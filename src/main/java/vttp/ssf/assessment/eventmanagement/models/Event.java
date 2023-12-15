package vttp.ssf.assessment.eventmanagement.models;

public class Event {

    private int eventId;
    private String eventName;
    private int eventSize;
    private int eventDate;
    private int participants;
    
    public Event() {
    }
    public Event(int eventId, String eventName, int eventSize, int eventDate, int participants) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventSize = eventSize;
        this.eventDate = eventDate;
        this.participants = participants;
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
    public int getEventDate() {
        return eventDate;
    }
    public void setEventDate(int eventDate) {
        this.eventDate = eventDate;
    }
    public int getParticipants() {
        return participants;
    }
    public void setParticipants(int participants) {
        this.participants = participants;
    }
}
    
