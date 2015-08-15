package com.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WeatherInfo
 */
@WebServlet("/WeatherInfo")
public class WeatherInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WeatherInfo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		String urlStr="http://api.openweathermap.org/data/2.5/forecast/city?id="+request.getParameter("id")+"&APPID="+request.getParameter("APPID");
		URL url = new URL(urlStr);
		String rep="Connection failed";
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		if(httpCon.getResponseCode() == 200){
			BufferedReader buf = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			String temp;
			StringBuilder buffer=new StringBuilder();
			while(( temp = buf.readLine()) != null){
					buffer.append(temp);
			}
			rep=buffer.toString();
			
		}
		httpCon.connect();
        PrintWriter printWriter  = response.getWriter();
        printWriter.println(rep);	
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
