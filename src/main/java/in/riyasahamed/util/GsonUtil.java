package in.riyasahamed.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	
	private GsonUtil(){
		//DEFAULT Constructor
	}

	public static Gson create() {
		 Gson gson = new GsonBuilder().setPrettyPrinting()
				 .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
				 .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
			.registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
			.create();
		 return gson;
	}
}
