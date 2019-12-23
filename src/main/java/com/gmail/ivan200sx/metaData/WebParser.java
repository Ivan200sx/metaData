package com.gmail.ivan200sx.metaData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

abstract class WebParser {
  protected String url;
  protected String html;

  final public void parse() {
    url = getUrl();
    loadPage();
    if (findInfo())
      printInfo();
    else
      noInfo();
  }

  private void loadPage() {
    StringBuffer sb = new StringBuffer();
    try {
      URL data = new URL(url);
      InputStreamReader isr = new InputStreamReader(data.openStream());
      BufferedReader br = new BufferedReader(isr);
      while (true) {
        String line = br.readLine();
        if (line == null)
          break;
        sb.append(line);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    html = sb.toString();
  }

  abstract protected String getUrl();

  abstract protected boolean findInfo();

  abstract protected void printInfo();

  abstract protected void noInfo();
}
