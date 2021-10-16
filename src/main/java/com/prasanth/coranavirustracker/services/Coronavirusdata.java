package com.prasanth.coranavirustracker.services;
import java.io.IOException;

import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.prasanth.coranavirustracker.model.*;
import javax.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Coronavirusdata {
   
	private static String viru_data = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	
	private List<Locationstats> allstats = new ArrayList<>();
	
	public List<Locationstats> getAllstats() {
		return allstats;
	}


	



	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchvirusdata() throws IOException, InterruptedException
	{
		List<Locationstats> newstats= new ArrayList<>();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(viru_data)).build();
		
		HttpResponse<String> httpResponse = client.send(request,HttpResponse.BodyHandlers.ofString());
		//System.out.println(httpResponse.body());
		
		StringReader csvreader = new StringReader(httpResponse.body());
		
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvreader);
		for (CSVRecord record : records) {
			Locationstats lstates = new Locationstats();
			String check = record.get("Province/State");
			if(check.length()==0)
				continue;
			
    	    lstates.setState(record.get("Province/State"));
		    lstates.setCountry(record.get("Country/Region"));
		    lstates.setLatesttotalcases(Integer.parseInt(record.get(record.size()-1)));
		    int latestcase =Integer.parseInt(record.get(record.size()-1));
		    int lprevcase =Integer.parseInt(record.get(record.size()-2));
		    int asd = Math.abs(latestcase-lprevcase);
		    lstates.setDiffprevday(asd);
		   
		     newstats.add(lstates);
		    //System.out.println(state);
		}
		this.allstats=newstats;
	}
	
}
