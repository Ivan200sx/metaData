package com.gmail.ivan200sx.metaData;


public class WebWetherSgd extends WebParser {

  String tempSgd;

  @Override
  protected String getUrl() {
    return "http://web.sugardas.lt";
  }

  @Override
  protected boolean findInfo() {
    int pos = html.indexOf("bg_1.jpg");
    if (pos < 0)
      return false;
    String[] tags = html.substring(pos + 95, pos + 98).split("\"");
    // System.out.println(tags[0]);
    tempSgd = tags[0];
    return true;
  }

  @Override
  protected void printInfo() {

    System.out.println("Sug temperature: " + tempSgd + " °C");
  }

  @Override
  protected void noInfo() {
    System.out.println("no currency");
  }
}
