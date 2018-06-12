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

import skhu.artview.model.Space;

@Service
public class SpaceService {
	private static String clientID = "eTuxeFyegLrGJWxmcajB";
	private static String clientSecret = "4fN93YH4PY";

	// display ==> 몇개 출력
	// start==>몇번쨰부터 (space)
	public List<Space> searchSpace(String keyword, int display, int start) {
		List<Space> list = null;
		try {
			URL url;
			url = new URL(
					"https://openapi.naver.com/v1/search/" + "book.xml?query=" + URLEncoder.encode(keyword, "UTF-8")
							+ (display != 0 ? "&display=" + display : "") + (start != 0 ? "&start=" + start : ""));

			URLConnection urlConn = url.openConnection();
			urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
			urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new InputStreamReader(urlConn.getInputStream()));

			int eventType = parser.getEventType();
			Space b = null;
			while (eventType != XmlPullParser.END_DOCUMENT) {
				switch (eventType) {
				case XmlPullParser.END_DOCUMENT: // 문서의 끝
					break;
				case XmlPullParser.START_DOCUMENT:
					list = new ArrayList<Space>();
					break;
				case XmlPullParser.END_TAG: {
					String tag = parser.getName();
					if (tag.equals("space")) {
						list.add(b);
						b = null;
					}
				}
				case XmlPullParser.START_TAG: {
					String tag = parser.getName();
					switch (tag) {
					case "space":
						b = new Space();
						break;
					case "title":
						if (b != null)
							b.setTitle(parser.nextText());
						break;
					case "link":
						if (b != null)
							
						break;
					case "image":
						if (b != null)
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
