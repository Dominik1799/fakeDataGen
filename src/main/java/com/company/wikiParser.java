package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class wikiParser {

    public void parse() throws IOException {
        Elements help = new Elements();
        Elements help2 = new Elements();
        Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_criminal_enterprises,_gangs,_and_syndicates").get();
        Elements elements = doc.getElementsByTag("ul");
        for (Element element : elements){
            if (element.className().equals("") && element.id().equals("")){
                help.addAll(element.children());
            }
        }
        for (Element element : help){
            if (element.id().equals("") && element.className().equals("") && !(element.toString().contains("Category")))
                help2.addAll(element.getElementsByTag("a"));
        }
        BufferedWriter out;
        FileWriter fstream = new FileWriter("C:\\Users\\dunco\\IdeaProjects\\fakeDataGen\\datasets\\gangs.txt", true); //true tells to append data.
        out = new BufferedWriter(fstream);
        for (Element element : help2){
            if (element.toString().contains("/wiki/") && !element.toString().contains("mafia")){
                out.write(element.text() + "\n");
            }
        }


    }
}
