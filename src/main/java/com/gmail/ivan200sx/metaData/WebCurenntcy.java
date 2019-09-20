package com.gmail.ivan200sx.metaData;


public class WebCurenntcy extends WebParser {

	String currency;
	@Override
	protected String getUrl() 
	{
		return "http://www.xe.com/currencyconverter/convert/?Amount=1&From=EUR&To=RUB";
	}

	@Override
	protected boolean findInfo() 
	{
		int pos = html.indexOf("uccResultUnit");
		if(pos < 0)
			return false;
		String [] tags = html.substring(pos , pos +200).split("\"");
		currency = tags[1];
		return true;
	}

	@Override
	protected void printInfo()
	{

		System.out.println("1 evro " + currency + " RUB");
	}

	@Override
	protected void noInfo() 
	{
		System.out.println("no currency");
	}

}
