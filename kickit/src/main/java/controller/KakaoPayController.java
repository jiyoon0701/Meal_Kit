package controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.PurchaseOrder;
import service.ItemService;



// xx외 x건 과 같이 대표상품명만 넘겨주시면되고, 가맹점내에서 주문서 생성시 장바구니형태로 담아두시면 될것 같습니다.

@Controller
@RequestMapping("/kakao")
public class KakaoPayController {
	
	@Autowired
	ItemService service;
	
	@RequestMapping(value="/kakaopay",  method = {RequestMethod.POST})
	@ResponseBody
	public String kakaopay(@RequestParam Map<String, Object> param) {
		try {
			String item = String.valueOf(param.get("item"));
			int totalQuantity = Integer.valueOf((String) param.get("totalQuantity"));
			int totalPrice = Integer.valueOf((String) param.get("totalPrice"));
			
			JSONObject jsonObject = new JSONObject(param);
			 item = URLEncoder.encode(item+" 외 "+(totalQuantity-1)+"건", "UTF-8"); 
			System.out.println(jsonObject); 
			URL url = new URL("Https://kapi.kakao.com/v1/payment/ready"); // 서버 주소 
			HttpURLConnection serverConnection = (HttpURLConnection) url.openConnection(); // 서버 연결 
			serverConnection.setRequestMethod("GET");
			serverConnection.setRequestProperty("Authorization","");
			serverConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			serverConnection.setDoOutput(true);
			String info = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name="+item+"&quantity="+totalQuantity+"&total_amount="+totalPrice+"&vat_amount=200&tax_free_amount=0&approval_url=http://localhost:8090/kickit/content/info?item=2&fail_url=http://localhost:8090/springmvc1/kakao/fail&cancel_url=http://localhost:8090/springmvc1/kakao/cancle";
			OutputStream output = serverConnection.getOutputStream(); 
			DataOutputStream data = new DataOutputStream(output);
			data.writeBytes(info);
			data.close();
			
			int resultCode = serverConnection.getResponseCode();
			
			InputStream ins;
			if (resultCode == 200) { // 성공
				ins = serverConnection.getInputStream();
			//	service.setPurchaseOrder((List<PurchaseOrder>) param.get("po"));
				
			}else {
				ins = serverConnection.getErrorStream();
			}
			InputStreamReader reader = new InputStreamReader(ins);
			BufferedReader buffer = new BufferedReader(reader);
			return buffer.readLine();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"result\":\"NO\"}";
	}
}
