package jp.co.internous.ecsite.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.ecsite.model.dao.GoodsRepository;
import jp.co.internous.ecsite.model.dao.PurchaseRepository;
import jp.co.internous.ecsite.model.dao.UserRepository;
import jp.co.internous.ecsite.model.dto.HistoryDTO;
import jp.co.internous.ecsite.model.dto.LoginDto;
import jp.co.internous.ecsite.model.entity.GOODS;
import jp.co.internous.ecsite.model.entity.PURCHASE;
import jp.co.internous.ecsite.model.entity.USER;
import jp.co.internous.ecsite.model.form.CartForm;
import jp.co.internous.ecsite.model.form.HistoryForm;
import jp.co.internous.ecsite.model.form.LoginForm;

//トップページへ遷移するコントローラー
// http://localhost:8080/ecsite/
@Controller
@RequestMapping("/ecsite")
public class IndexController {

//USERエンティティからuserテーブルにアクセスするDAO
	@Autowired
	private UserRepository userRepos;
	
//GOODSエンティティからgoodsテーブルにアクセスするDAO
	@Autowired
	private GoodsRepository goodsRepos;
	
//PURCHASEエンティティからpurchaseテーブルにアクセスするDAO
	@Autowired
	private PurchaseRepository purchaseRepos;
	
//WebサービスAPIとして作成するためJSON形式を扱えるように
//Gsonのインスタンス化
	private Gson gson = new Gson();
	
// トップページ(index.html)に遷移するメソッド
	@RequestMapping("/")
	public String index(Model m) {
		
	//goodsテーブルから商品データ取得
		List<GOODS> goods = goodsRepos.findAll();
		
	//モデルmに取得データ挿入
		m.addAttribute("goods", goods);
	
		return "index";
	}
	
	@ResponseBody
	@PostMapping("/api/login")
	public String loginApi( @RequestBody LoginForm form ) {
		
	//userテーブルからusernameとpasswordで検索し、結果を取得
		List<USER> users = userRepos.findByUSERNAMEAndPASSWORD( form.getUserName(), form.getPassWord() );
	
	//DTOをゲストの情報で初期化
		LoginDto dto = new LoginDto(0, null, null, "ゲスト");
		
	//検索結果が存在した時、実在のユーザ情報を変数dtoに詰める
		if (users.size() > 0) {
			dto = new LoginDto( users.get(0) );
		}
		
	//変数dtoをJsonオブジェクトとしてブラウザに返す
		return gson.toJson(dto);
		
	}
	
	@ResponseBody
	@PostMapping("/api/purchase")
	public String purchaseApi( @RequestBody CartForm cf ) {
		
		cf.getCartList().forEach( (c) -> {
				
				long total = c.getPrice() * c.getCount();
				
				purchaseRepos.persist( cf.getUserId(), c.getId(), c.getGoodsName(), c.getCount(), total);				
		});
		
		
		return String.valueOf( cf.getCartList().size() );
	}
	
//購入履歴を表示する
	@ResponseBody
	@PostMapping("/api/history")
	public String historyApi( @RequestBody HistoryForm hform ) {
		String userId = hform.getUserId();
		
		List<PURCHASE> history = purchaseRepos.findHistory( Long.parseLong(userId) );
		
		List<HistoryDTO> historyDTOList = new ArrayList<>();
		
		history.forEach( (v) -> {
			
			HistoryDTO dto = new HistoryDTO(v);
			
			historyDTOList.add(dto);
		});
		
		return gson.toJson( historyDTOList );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
