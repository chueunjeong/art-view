
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
    public List<Item> searchItem( int start, int end){
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
                            b.setDP_SEQ(parser.nextText());;
                        break;
                    case "DP_LAN":
                    	 if(b != null)
                             b.setDP_LAN(parser.nextText());
                    case "DP_Name":
                   	 if(b != null)
                            b.setTitle(parser.nextText());
                   	 
                   	 /*
                    case "DP_SUBNAME":
                   	 if(b != null)
                            b.setSubtitle(parser.nextText());
                    case "DP_PLACE":
                   	 if(b != null)
                            b.setDP_PLACE(parser.nextText());
                    case "DP_START":
                   	 if(b != null)
                            b.setDP_START(parser.nextText());
                    case "DP_END":
                   	 if(b != null)
                            b.setDP_END(parser.nextText());
                    case "DP_TYPE":
                   	 if(b != null)
                            b.setDP_TYPE(parser.nextText());
                   	 	 
                    	 
                 
                       	 
                    case "DP_HOMEPAGE":
                        if(b != null)
                            b.setDP_HOMEPAGE(parser.nextText());
                        break;
                    case "DP_EVENT":
                     	 if(b != null)
                              b.setDP_EVENT(parser.nextText());
                    case "DP_SPONSOR":
                     	 if(b != null)
                              b.setDP_SPONSOR(parser.nextText());
                    case "DP_VIEWTIME":
                     	 if(b != null)
                              b.setDP_VIEWTIME(parser.nextText());
                    case "DP_VIEWCHARGE":
                     	 if(b != null)
                              b.setPrice(parser.nextText());
                    case "DP_ART_PART":
                     	 if(b != null)
                              b.setDP_ART_PART(parser.nextText());
                    case "DP_ART_CNT":
                     	 if(b != null)
                              b.setDP_ART_CNT(parser.next());
                    case "DP_DP_ARTIST":
                     	 if(b != null)
                              b.setDP_ARTIST(parser.nextText());
                    case "DP_DP_DOCENT":
                     	 if(b != null)
                              b.setDP_DOCENT(parser.nextText());
                    case "DP_VIEWPOINT":
                     	 if(b != null)
                              b.setDP_VIEWPOINT(parser.nextText());
                    case "DP_MASTER":
                     	 if(b != null)
                              b.setDP_MASTER(parser.nextText());
                    case "DP_PHONE":
                     	 if(b != null)
                              b.setDP_PHONE(parser.nextText());
                    case "DP_INFO":
                     	 if(b != null)
                              b.setDP_INFO(parser.nextText());
                     	 	      
                        
                    case "DP_MAIN_IMG":
                        if(b != null)
                            b.setImage(parser.nextText());
                        break;

*/

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

