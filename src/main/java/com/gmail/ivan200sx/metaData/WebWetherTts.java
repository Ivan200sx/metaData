package com.gmail.ivan200sx.metaData;


public class WebWetherTts extends WebParser {

  String tepmTts;

  @Override
  protected String getUrl() {
    return "http://tts.lt";
  }

  @Override
  protected boolean findInfo() {
    int pos = html.indexOf("Температура:");
    if (pos < 0)
      return false;
    String[] tags = html.substring(pos + 47, pos + 52).split("\"");
    // System.out.println(tags[0]);
    tepmTts = tags[0];
    return true;
  }

  @Override
  protected void printInfo() {

    System.out.println("Tts temperature:  " + tepmTts + " °C");
  }

  @Override
  protected void noInfo() {
    System.out.println("no currency");
  }

  public String getTtsToWeb() {
    String ttsToWeb;

    ttsToWeb = String.valueOf(tepmTts);

    return ttsToWeb;
  }
 }
