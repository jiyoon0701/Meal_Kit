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
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.CartList;
import dto.PurchaseOrder;
import service.CartService;
import service.ItemService;
import service.UserService;

@Controller
@RequestMapping("/kakao")
public class KakaoPayController {

	@Autowired
	private ItemService service;

	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserService userService;

	int point = 0;
	@RequestMapping(value = "/kakaopay", method = { RequestMethod.GET })
	@ResponseBody
	public String kakaopay(@RequestParam String totalPrice, @RequestParam String points, Principal principal, PurchaseOrder purchaseOrder)
			throws Exception {
		try {
			String email = principal.getName();
			System.out.println("email1" + email);
			List<CartList> cartList = cartService.getCart(email);

			int totalQuantity = cartList.size();
			String item = cartList.get(0).getItem(); // 첫번째 상품의 이름
			
			point = Integer.parseInt(points);
			int totalprice = (Integer.parseInt(totalPrice)) - point;
			System.out.println(totalprice);
			item = URLEncoder.encode(item + " 외 " + (totalQuantity - 1) + "건", "UTF-8");

			URL url = new URL("Https://kapi.kakao.com/v1/payment/ready"); // 서버 주소
			HttpURLConnection serverConnection = (HttpURLConnection) url.openConnection(); // 서버 연결
			serverConnection.setRequestMethod("GET");
			serverConnection.setRequestProperty("Authorization", "KakaoAK 8e8d159be3a67af4a7971a885533e644");
			serverConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			serverConnection.setDoOutput(true);
			String info = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name="
					+ item + "&quantity=" + totalQuantity + "&total_amount=" + totalprice
					+ "&vat_amount=200&tax_free_amount=0&approval_url=http://localhost:8090/kickit/kakao/exception?success=true&fail_url=http://localhost:8090/kickit/kakao/exception?success=fail&cancel_url=http://localhost:8090/kickit/kakao/exception?success=cancle";
			OutputStream output = serverConnection.getOutputStream();
			DataOutputStream data = new DataOutputStream(output);
			data.writeBytes(info);
			data.close();

			int resultCode = serverConnection.getResponseCode();

			InputStream ins;
			if (resultCode == 200) { // 성공
				ins = serverConnection.getInputStream();
			} else {
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

	@RequestMapping(value = "/exception", method = { RequestMethod.GET })
	@ResponseBody
	public ModelAndView exception(@RequestParam("success") String success, Principal principal, PurchaseOrder purchaseOrder) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String email = principal.getName();
		List<CartList> cartList = cartService.getCart(email);

		if (success.equals("true")) {
			for (CartList PO : cartList) {
				purchaseOrder.setEmail(email);
				purchaseOrder.setItemCode(PO.getItemCode());
				purchaseOrder.setQuantity(PO.getQuantity());
				service.setPurchaseOrder(purchaseOrder);  // 구매 테이블로 들어감.
				userService.updateUserPoint(point, email);
				service.deleteItem(PO.getId());
			}
		}
		mav.addObject("success", success);
		mav.addObject("url", "mypage");
		return mav;
	}
}
