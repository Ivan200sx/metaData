package com.gmail.ivan200sx.metaData;


public class Program {
  public static void main(String[] args) {
    WebParser web = new WebTime();
    web.parse();

    WebParser webWetTts = new WebWetherTts();
    webWetTts.parse();

    WebParser webWetSgd = new WebWetherSgd();
    webWetSgd.parse();
    // WebParser web= new WebCurenntcy();
    // web.parse();
  }
}
