
package skhu.artview.service;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import skhu.artview.model.Item;

@Service
public class MuseumService {
    private static String clientID = "AGyAj_q1XIJQNLiGGXhj";
    private static String clientSecret = "6367746a6b69726932304f686c5473";

    //display ==> 몇개 출력
    //start==>몇번쨰부터 (item)
    public List<Item> searchItem(String keyword, int start, int end){
        List<Item> list = null;
        try {
            URL url;
            url = new URL("http://openAPI.seoul.go.kr:8088/"
                    + clientSecret+"/xml/ListExhibitionOfSeoulMOAService/"
                    +start+
                    "/"
                    +end+
                    "/KOR/");
            URLConnection urlConn = url.openConnection();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(
                    new InputStreamReader(urlConn.getInputStream()));
            //Test에서 했던 방식은 DOM방식이기때문에?
            //그래서 이렇게 해도 된다?!??!??!?



            int eventType = parser.getEventType();
            Item b = null;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                case XmlPullParser.END_DOCUMENT: // 문서의 끝
                    break;
                case XmlPullParser.START_DOCUMENT:
                    list = new ArrayList<Item>();
                    break;
                case XmlPullParser.END_TAG: {
                    String tag = parser.getName();
                    if(tag.equals("row"))
                    {
                        list.add(b);
                        b = null;
                    }
                }
                case XmlPullParser.START_TAG: {
                    String tag = parser.getName();
                    switch (tag) {
                    case "row":
                        b = new Item();
                        break;
                    case "DP_SEQ":
                        if(b != null)
                            b.setTitle(parser.nextText());
                        break;
                    case "DP_LAN":
                        if(b != null)
                            b.setLink(parser.nextText());
                        break;
                    case "DP_NAME":
                        if(b != null)
                            b.setImage(parser.nextText());
                        break;



                    }

                }
                }
                eventType = parser.next();
            }




        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
}

