package vttp.ssf.assessment.eventmanagement.services;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Service
public class DatabaseService {

    public ArrayList<Event> readFile(String fileName) {
        ArrayList<Event> result = new ArrayList<Event>();
        try {
            String text = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
            JSONObject object = new JSONObject(text);
            JSONArray array = object.getJSONArray("events");

            for (int i = 0; i < array.length(); i++) {
                int eventId = Integer.parseInt(array.getJSONObject(i).getString("eventId"));
                String eventName = array.getJSONObject(i).getString("eventName");
                int eventSize = Integer.parseInt(array.getJSONObject(i).getString("eventSize"));
                int eventDate = Integer.parseInt(array.getJSONObject(i).getString("eventDate"));
                int participants = Integer.parseInt(array.getJSONObject(i).getString("participants"));

                result.add(new Event(eventId, eventName, eventSize, eventDate, participants));

            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

}