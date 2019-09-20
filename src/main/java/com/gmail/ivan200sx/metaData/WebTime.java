package com.gmail.ivan200sx.metaData;


public class WebTime extends WebParser 
{
	String time;
	@Override
	protected String getUrl() 
	{
		return "https://time.is";
	}
	@Override
	protected boolean findInfo() 
	{
		int pos = html.indexOf("\"twd\"");
		if(pos < 0)
			return false;
		time =html.substring(pos +6, pos +14);
		return true;
	}
	@Override
	protected void printInfo() 
	{
		System.out.println("Visaginas time: " + time);
	}
	@Override
	protected void noInfo() 
	{
		System.out.println("No time");
	}

}
